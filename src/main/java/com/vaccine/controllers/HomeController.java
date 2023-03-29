package com.vaccine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vaccine.services.VaccineDataService;
import com.vaccine.models.LocationStats;

//import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    VaccineDataService vaccineDataService;

    @GetMapping("/vaccine-tracker")
    public String home(Model model) {
        List<LocationStats> allStats = vaccineDataService.getAllStats();
//        Collections.reverse(allStats);
//        print vaccine name of 0th index list 
//        System.out.println(allStats.get(0).getVaccine());
//        
//        print total vaccinations  name of 0th index list 
//        System.out.println(allStats.get(1).getLatestTotalVaccinated());
        
//        To display table
        model.addAttribute("locationStats", allStats);
        
//        To display "Total vaccines administered as of today"
//        String totalAdministeredVaccines = allStats.get(allStats.size()-1).getLatestTotalVaccinated();
        String totalAdministeredVaccines = allStats.get(0).getLatestTotalVaccinated();
        model.addAttribute("totalAdministeredVaccines", totalAdministeredVaccines);
        
//      To display "New vaccines administered since previous day"
//        long totalNewVaccinesAdministered = Long.parseLong(totalAdministeredVaccines) - Long.parseLong(allStats.get(allStats.size()-2).getLatestTotalVaccinated());
        long totalNewVaccinesAdministered = Long.parseLong(totalAdministeredVaccines) - Long.parseLong(allStats.get(1).getLatestTotalVaccinated());
        model.addAttribute("totalNewVaccinesAdministered", totalNewVaccinesAdministered);

        return "home";
    }
}
