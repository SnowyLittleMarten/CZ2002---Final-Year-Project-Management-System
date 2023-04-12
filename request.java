package sc2002assignment;

import java.util.ArrayList;

public class request {
	private int reqID;
	private int projID;
	private String studentID = "";
	private String supervisorID = "";
	private String reqType = ""; //allocate, unregister, title, transfer
	private String reqStatus = "pending"; //approved, pending, rejected
	private String newTitle = "";
	
	/*
	public void viewRequests(ArrayList<request> reqList) {
		
	}
	*/
	
	public int setReqID (int x) {
		return reqID = x;
	}
	
	public int getReqID () {
		return reqID;
	}
	
	public int setProjID (int x) {
		return projID = x;
	}
	
	public int getProjID () {
		return projID;
	}
	
	public String setStudentID (String x) {
		return studentID = x;
	}
	
	public String getStudentID () {
		return studentID;
	}

	public String setSupervisorID (String x) {
		return supervisorID = x;
	}
	
	public String getSupervisorID () {
		return supervisorID;
	}
	
	public String setReqType (String x) {
		return reqType = x;
	}
	
	public String getReqType () {
		return reqType;
	}
	
	public String setReqStatus (String x) {
		return reqStatus = x;
	}
	
	public String getReqStatus () {
		return reqStatus;
	}
	
	public String setNewTitle (String x) {
		return newTitle = x;
	}
	
	public String getNewTitle () {
		return newTitle;
	}
}
