package com.hexaware.crimeanalysis.entity;

public class Report {
	   private String reportID;
	    private String incidentID;
	    private String reportingOfficer;
	    private String reportDate; 
	    private String reportDetails;
	    private String status;
	    public Report() {}
		public Report(String reportID, String incidentID, String reportingOfficer, String reportDate,
				String reportDetails, String status) {
			super();
			this.reportID = reportID;
			this.incidentID = incidentID;
			this.reportingOfficer = reportingOfficer;
			this.reportDate = reportDate;
			this.reportDetails = reportDetails;
			this.status = status;
		}
		public String getReportID() {
			return reportID;
		}
		public void setReportID(String reportID) {
			this.reportID = reportID;
		}
		public String getIncidentID() {
			return incidentID;
		}
		public void setIncidentID(String incidentID) {
			this.incidentID = incidentID;
		}
		public String getReportingOfficer() {
			return reportingOfficer;
		}
		public void setReportingOfficer(String reportingOfficer) {
			this.reportingOfficer = reportingOfficer;
		}
		public String getReportDate() {
			return reportDate;
		}
		public void setReportDate(String reportDate) {
			this.reportDate = reportDate;
		}
		public String getReportDetails() {
			return reportDetails;
		}
		public void setReportDetails(String reportDetails) {
			this.reportDetails = reportDetails;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	    

}
