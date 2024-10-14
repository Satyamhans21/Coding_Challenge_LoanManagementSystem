package com.hexaware.crimeanalysis.service;

import java.util.Collection;

import com.hexaware.crimeanalysis.dao.CrimeAnalysisDaoImpl;
import com.hexaware.crimeanalysis.dao.ICrimeAnalysisDao;
import com.hexaware.crimeanalysis.entity.Incident;
import com.hexaware.crimeanalysis.entity.Report;

public class CrimeAnalysisServiceImpl implements ICrimeAnalysisService {
	   private ICrimeAnalysisDao crimeAnalysisDao;

	    public CrimeAnalysisServiceImpl() {
	        this.crimeAnalysisDao = new CrimeAnalysisDaoImpl();
	    }

	    @Override
	    public boolean createIncident(Incident incident) {
	        return crimeAnalysisDao.createIncident(incident);
	    }

	    @Override
	    public boolean updateIncidentStatus(String status, int incidentId) {
	        return crimeAnalysisDao.updateIncidentStatus(status, incidentId);
	    }

	    @Override
	    public Collection<Incident> getIncidentsInDateRange(String startDate, String endDate) {
	        return crimeAnalysisDao.getIncidentsInDateRange(startDate, endDate);
	    }

	    @Override
	    public Collection<Incident> searchIncidents(String criteria) {
	        return crimeAnalysisDao.searchIncidents(criteria);
	    }

	    @Override
	    public Report generateIncidentReport(Incident incident) {
	        return crimeAnalysisDao.generateIncidentReport(incident);
	    }

	    @Override
	    public void createCase(String caseDescription, Collection<Incident> incidents) {
	        crimeAnalysisDao.createCase(caseDescription, incidents);
	    }

	    @Override
	    public void getCaseDetails(int caseId) {
	        crimeAnalysisDao.getCaseDetails(caseId);
	    }

	    @Override
	    public boolean updateCaseDetails() {
	        return crimeAnalysisDao.updateCaseDetails();
	    }

	    @Override
	    public Collection<?> getAllCases() {
	        return crimeAnalysisDao.getAllCases();
	    }

}
