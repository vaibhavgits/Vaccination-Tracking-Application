package com.vaccine.services;

import com.vaccine.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VaccineDataService {

//    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private static String VACCINE_DATA_URL = "https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/vaccinations/country_data/India.csv";
    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
    	Collections.reverse(allStats);
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VACCINE_DATA_URL))
                .build();
        
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(httpResponse.body());
        
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        
        
//        for-each loop syntax
//        int ar[] = { 10, 50, 60, 80, 90 };
//        for (int element : ar) {
//        	System.out.print(element + " ");
//        }
        
        long prevDayCases;
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setDate(record.get("date"));
            locationStat.setVaccine(record.get("vaccine"));
            //locationStat.setLatestTotalVaccinated(record.get("total_vaccinations"));
            
            
            String latestTotalVaccinated = record.get("total_vaccinations");
            locationStat.setLatestTotalVaccinated(latestTotalVaccinated);
            
//            int prevDayCases = Integer.parseInt(record.get(record.size() - 2).get("total_vaccinations"));
//            locationStat.setDiffFromPrevDay(Integer.parseInt(latestTotalVaccinated)	 - prevDayCases);
            
            
            long latestCases = Long.parseLong(latestTotalVaccinated);
            
            if(newStats.size()!=0)
            prevDayCases = Long.parseLong(newStats.get(newStats.size()-1).getLatestTotalVaccinated());
            else
            prevDayCases = 0;
            
//            System.out.println(latestCases);
            //if(i!=0)
            //int prevDayCases = Integer.parseInt(record.get(record.size() - 2));
//            locationStat.setLatestTotalCases(latestCases);
            locationStat.setDiffFromPrevDay(latestCases - prevDayCases);
            
            newStats.add(locationStat);
        }
        this.allStats = newStats;
    }

}
