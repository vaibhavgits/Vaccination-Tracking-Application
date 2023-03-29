# Vaccination-Tracking-Application
This project is a web application built using SpringBoot, Thymeleaf, and Bootstrap to track the COVID-19 vaccination progress in India. The application uses a live and updated daily CSV file provided by Our World in Data that contains vaccination data for all countries, including India.

## Usage
To use this application, simply clone the repository and run it on your local machine. The application uses Maven as the build tool and can be run using the following command in the root directory of the project:

Once the application is running, you can access it in your web browser at http://localhost:8081/vaccine-tracker. 

## Data Source
The data used in this application is sourced from the following URL:
https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/vaccinations/country_data/India.csv

This CSV file is updated daily with the latest vaccination data for India.

## Features
The application provides the following features:

* Display of the total number of vaccinations administered in India
* Display of the number of people who have received at least one dose of the vaccine
* Display of the number of people who are fully vaccinated
* Display of the vaccination coverage in terms of the percentage of the population that has received at least one dose and the percentage that is fully vaccinated
* Display of a graph showing the vaccination progress over time

## Technologies Used
* SpringBoot - A popular Java web framework
* Thymeleaf - A modern server-side Java template engine
* Bootstrap - A popular front-end framework for building responsive web pages

## Contributing
If you would like to contribute to this project, please fork the repository and create a pull request with your changes.
