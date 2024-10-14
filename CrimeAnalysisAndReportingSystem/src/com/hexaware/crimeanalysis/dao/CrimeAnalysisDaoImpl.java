package com.hexaware.crimeanalysis.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.hexaware.crimeanalysis.entity.Incident;
import com.hexaware.crimeanalysis.entity.Report;
import com.hexaware.crimeanalysis.util.DBConnection;

public class CrimeAnalysisDaoImpl implements ICrimeAnalysisDao{
	   private Connection connection;

	    public CrimeAnalysisDaoImpl() {
	        connection = DBConnection.getConnection();
	    }

	    @Override
	    public boolean createIncident(Incident incident) {
	        String query = "INSERT INTO incidents (IncidentID, IncidentType, IncidentDate, Location, Description, Status) VALUES (?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, incident.getIncidentID());
	            stmt.setString(2, incident.getIncidentType());
	            stmt.setString(3, incident.getIncidentDate());
	            stmt.setString(4, incident.getLocation());
	            stmt.setString(5, incident.getDescription());
	            stmt.setString(6, incident.getStatus());
	            
	            return stmt.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public boolean updateIncidentStatus(String status, int incidentId) {
	        String query = "UPDATE incidents SET Status = ? WHERE IncidentID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, status);
	            stmt.setInt(2, incidentId);
	            return stmt.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public Collection<Incident> getIncidentsInDateRange(String startDate, String endDate) {
	        Collection<Incident> incidents = new ArrayList<>();
	        String query = "SELECT * FROM incidents WHERE IncidentDate BETWEEN ? AND ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, startDate);
	            stmt.setString(2, endDate);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Incident incident = new Incident();
	                incident.setIncidentID(rs.getInt("IncidentID"));
	                incident.setIncidentType(rs.getString("IncidentType"));
	                incident.setIncidentDate(rs.getString("IncidentDate"));
	                incident.setLocation(rs.getString("Location"));
	                incident.setDescription(rs.getString("Description"));
	                incident.setStatus(rs.getString("Status"));
	                incidents.add(incident);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return incidents;
	    }

	    @Override
	    public Collection<Incident> searchIncidents(String criteria) {
	        Collection<Incident> incidents = new ArrayList<>();
	        String query = "SELECT * FROM incidents WHERE IncidentType LIKE ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, "%" + criteria + "%");
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Incident incident = new Incident();
	                incident.setIncidentID(rs.getInt("IncidentID"));
	                incident.setIncidentType(rs.getString("IncidentType"));
	                incident.setIncidentDate(rs.getString("IncidentDate"));
	                incident.setLocation(rs.getString("Location"));
	                incident.setDescription(rs.getString("Description"));
	                incident.setStatus(rs.getString("Status"));
	                incidents.add(incident);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return incidents;
	    }

	    @Override
	    public Report generateIncidentReport(Incident incident) {
	        // Create a new Report object
	        Report report = new Report();

	       
	        report.setIncidentID(incident.getIncidentID()); 
	        report.setReportDetails(incident.getDescription());  
	        report.setReportDate(incident.getIncidentDate());  
	        report.setStatus(incident.getStatus()); 



	        return report;
	    }

		@Override
		public void createCase(String caseDescription, Collection<Incident> incidents) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void getCaseDetails(int caseId) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean updateCaseDetails() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Collection<?> getAllCases() {
			// TODO Auto-generated method stub
			return null;
		}

	}


