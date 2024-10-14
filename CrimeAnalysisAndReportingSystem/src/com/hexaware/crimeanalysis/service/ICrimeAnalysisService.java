package com.hexaware.crimeanalysis.service;

import java.util.Collection;

import com.hexaware.crimeanalysis.entity.Incident;
import com.hexaware.crimeanalysis.entity.Report;

public interface ICrimeAnalysisService {
    boolean createIncident(Incident incident);
    boolean updateIncidentStatus(String status, int incidentId);
    Collection<Incident> getIncidentsInDateRange(String startDate, String endDate);
    Collection<Incident> searchIncidents(String criteria);
    Report generateIncidentReport(Incident incident);
    void createCase(String caseDescription, Collection<Incident> incidents);
    void getCaseDetails(int caseId);
    boolean updateCaseDetails();
    Collection<?> getAllCases();

}
