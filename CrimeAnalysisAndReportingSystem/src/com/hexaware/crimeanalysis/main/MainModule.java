package com.hexaware.crimeanalysis.main;



import java.util.Collection;

import com.hexaware.crimeanalysis.entity.Incident;
import com.hexaware.crimeanalysis.service.CrimeAnalysisServiceImpl;

public class MainModule {
    public static void main(String[] args) {
        CrimeAnalysisServiceImpl service = new CrimeAnalysisServiceImpl();

        // Example usage: Creating a new incident
        Incident newIncident = new Incident(0, "Robbery", "2024-10-14", "Downtown", "A robbery occurred.", "Open", 0, 0);
        service.createIncident(newIncident);  // Assuming createIncident returns void

        // Search incidents
        Collection<Incident> incidents = service.searchIncidents("Robbery");
        if (incidents.isEmpty()) {
            System.out.println("No incidents found for the given search term.");
        } else {
            System.out.println("Incidents found:");
            for (Incident incident : incidents) {
                System.out.println(incident);
            }
        }
    }
}