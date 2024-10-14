package com.hexaware.crimeanalysis.main;



import java.util.Collection;
import java.util.Scanner;

import com.hexaware.crimeanalysis.dao.CrimeAnalysisDaoImpl;
import com.hexaware.crimeanalysis.entity.Incident;
import com.hexaware.crimeanalysis.entity.Officer;
import com.hexaware.crimeanalysis.entity.Report;
import com.hexaware.crimeanalysis.service.CrimeAnalysisServiceImpl;

public class MainModule {
	  public static void main(String[] args) {
	        CrimeAnalysisDaoImpl dao = new CrimeAnalysisDaoImpl();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nCrime Analysis System");
	            System.out.println("1. Create an Incident");
	            System.out.println("2. Update Incident Status");
	            System.out.println("3. Search Incidents by Criteria");
	            System.out.println("4. Get Incidents in Date Range");
	            System.out.println("5. Generate Incident Report");
	            System.out.println("6. Exit");
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1:
	                    
	                    Incident incident = new Incident();
	                    System.out.print("Enter Incident ID: ");
	                    incident.setIncidentID(scanner.nextInt());
	                    scanner.nextLine();  // Consume newline

	                    System.out.print("Enter Incident Type: ");
	                    incident.setIncidentType(scanner.nextLine());

	                    System.out.print("Enter Incident Date (YYYY-MM-DD): ");
	                    incident.setIncidentDate(scanner.nextLine());

	                    System.out.print("Enter Location: ");
	                    incident.setLocation(scanner.nextLine());

	                    System.out.print("Enter Description: ");
	                    incident.setDescription(scanner.nextLine());

	                    System.out.print("Enter Status (e.g., Open, Closed): ");
	                    incident.setStatus(scanner.nextLine());

	                    if (dao.createIncident(incident)) {
	                        System.out.println("Incident created successfully.");
	                    } else {
	                        System.out.println("Error creating incident.");
	                    }
	                    break;

	                case 2:
	                    
	                    System.out.print("Enter Incident ID to update: ");
	                    int incidentId = scanner.nextInt();
	                    scanner.nextLine();  // Consume newline

	                    System.out.print("Enter new Status: ");
	                    String newStatus = scanner.nextLine();

	                    if (dao.updateIncidentStatus(newStatus, incidentId)) {
	                        System.out.println("Incident status updated successfully.");
	                    } else {
	                        System.out.println("Error updating incident status.");
	                    }
	                    break;

	                case 3:
	                    
	                    System.out.print("Enter search criteria (e.g., Robbery): ");
	                    String criteria = scanner.nextLine();
	                    Collection<Incident> incidents = dao.searchIncidents(criteria);
	                    System.out.println("Search Results:");
	                    for (Incident inc : incidents) {
	                        System.out.println(inc.toString());
	                    }
	                    break;

	                case 4:
	                    
	                    System.out.print("Enter start date (YYYY-MM-DD): ");
	                    String startDate = scanner.nextLine();

	                    System.out.print("Enter end date (YYYY-MM-DD): ");
	                    String endDate = scanner.nextLine();

	                    Collection<Incident> dateRangeIncidents = dao.getIncidentsInDateRange(startDate, endDate);
	                    System.out.println("Incidents in Date Range:");
	                    for (Incident inc : dateRangeIncidents) {
	                        System.out.println(inc.toString());
	                    }
	                    break;

	                case 5:
	                    
	                    System.out.print("Enter Incident ID to generate report: ");
	                    int reportIncidentID = scanner.nextInt();
	                    scanner.nextLine();  // Consume newline

	                    Incident fetchedIncident = null;
	                    for (Incident inc : dao.searchIncidents("")) {
	                        if (inc.getIncidentID() == reportIncidentID) {
	                            fetchedIncident = inc;
	                            break;
	                        }
	                    }

	                    if (fetchedIncident != null) {
	                        Report report = dao.generateIncidentReport(fetchedIncident);
	                        System.out.println("Report generated successfully.");
	                        System.out.println("Incident ID: " + report.getIncidentID());
	                        System.out.println("Report Date: " + report.getReportDate());
	                        System.out.println("Report Details: " + report.getReportDetails());
	                        System.out.println("Status: " + report.getStatus());
	                    } else {
	                        System.out.println("Incident not found.");
	                    }
	                    break;

	                case 6:
	                    
	                    System.out.println("Exiting the system...");
	                    scanner.close();
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please select a valid option.");
	                    break;
	            }
	        }
	    }
}