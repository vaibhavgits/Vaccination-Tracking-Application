package com.vaccine.models;

public class LocationStats {

    private String vaccine;
    private String date;
    private String latestTotalVaccinated;
    private long diffFromPrevDay;

    

	public String getVaccine() {
		return vaccine;
	}



	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	

	public long getDiffFromPrevDay() {
		return diffFromPrevDay;
	}



	public String getLatestTotalVaccinated() {
		return latestTotalVaccinated;
	}



	public void setLatestTotalVaccinated(String latestTotalVaccinated) {
		this.latestTotalVaccinated = latestTotalVaccinated;
	}



	public void setDiffFromPrevDay(long diffFromPrevDay) {
		this.diffFromPrevDay = diffFromPrevDay;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "LocationStats [vaccine=" + vaccine + ", date=" + date + ", latestTotalVaccinated="
				+ latestTotalVaccinated + ", diffFromPrevDay=" + diffFromPrevDay + "]";
	}

    
}
