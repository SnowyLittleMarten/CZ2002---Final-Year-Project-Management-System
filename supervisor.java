package sc2002assignment;

import java.util.ArrayList;

public class supervisor {
	private String supervisorID;
	private String name;
	private String email;
	private int studentCount; //use this attribute in coordinator class to determine if reach limit of 2 student
	
	public supervisor (String name, String email) {
		this.name = name;
		this.email = email;
		supervisorID = email.substring(0, email.indexOf('@'));
		studentCount = 0;
	}
	
	public project createProj(String projTitle, String supervisorID, String supervisorName, String supervisorEmail) {
		project proj = new project(projTitle, supervisorID, supervisorName, supervisorEmail);
		return proj;
	}
	
	public void viewCreatedProj (ArrayList<project> projList, String supervisorID) {
		boolean hasProj = false;
		for (int x = 0; x < projList.size(); x++) {
			if (projList.get(x).getSupervisorID().equalsIgnoreCase(supervisorID)) {
				hasProj = true;
				System.out.println(projList.get(x).getProjID());
			}
		}
		if (hasProj == false) {
			System.out.println("You have not created any projects.");
		}
	}
	
	/* NOT IN USE
	public void editProjTitle (project proj, String newTitle) {
		proj.setProjTitle(newTitle);
		System.out.println("TItle has been changed");
	}
	*/
	
	/*
	public void editProjTitle (ArrayList<project> projList, String supervisorID, String newTitle) {
		for (int x = 0; x < projList.size(); x++) {
			if (projList.get(x).getSupervisorID().equalsIgnoreCase(supervisorID)) {
				projList.get(x).setProjTitle(newTitle);
				System.out.println("The project title has been successfully changed");
			}
		}
	}
	*/
	
	/* THIS METHOD FOR FYP COORDINATOR
	public void allocateProject (ArrayList<project> projList, String studentID, String studName, String studEmail, int projID) {
		for (int x = 0; x < projList.size(); x++) {
			if (projList.get(x).getProjID() == projID) {
				projList.get(x).setStudentID(studentID);
				projList.get(x).setStudentName(studName);
				projList.get(x).setStudentEmail(studEmail);
				projList.get(x).setStatus("allocated");
				break;
			}
		}
	}
	*/
	
	/* THIS METHOD FOR FYP COORDINATOR
	public void unregisterProject (ArrayList<project> projList, int projID) {
		for (int x = 0; x < projList.size(); x++) {
			if (projList.get(x).getProjID() == projID) {
				projList.get(x).setStudentID("");
				projList.get(x).setStudentName("");
				projList.get(x).setStudentEmail("");
				projList.get(x).setStatus("available");
				break;
			}
		}
	}
	*/
	
	public void reqTransferSupervisor (int projID, String newSupervisorID) {
		
	}
	
	public void viewRequests (ArrayList<request> reqList, String supervisorID) {
		for (int x = 0; x < reqList.size(); x++) {
			if (reqList.get(x).getSupervisorID().equalsIgnoreCase(supervisorID)) {
				if (reqList.get(x).getReqStatus().equalsIgnoreCase("pending")) {
					System.out.println(reqList.get(x).getReqID());	
				}
			}
		}
	}
	
	public void viewReqHistory (ArrayList<request> reqList, String supervisorID) {
		for (int x = 0; x < reqList.size(); x++) {
			if (reqList.get(x).getSupervisorID().equalsIgnoreCase(supervisorID)) {
				if (!(reqList.get(x).getReqStatus().equalsIgnoreCase("pending"))) {
					System.out.println(reqList.get(x).getReqID());
				}
			}
		}
	}
	
	public void viewStudReq (ArrayList<request> reqList, String studentID) {
		for (int x = 0; x < reqList.size(); x++) {
			if (reqList.get(x).getStudentID().equalsIgnoreCase(studentID)) {
				if (!(reqList.get(x).getReqStatus().equalsIgnoreCase("pending"))) {
					System.out.println(reqList.get(x).getReqID());
				}
			}
		}
	}	

	public request selectRequest (ArrayList<request> reqList, int reqID) {
		request req = new request();
		for (int x = 0; x < reqList.size(); x++) {
			if (reqList.get(x).getReqID() == reqID) {
				req = reqList.get(x);
			}
		}
		return req;
	}
	
	public project selectProject (ArrayList<project> projList, request req) {
		project proj = null;
		for (int x = 0; x < projList.size(); x++) {
			if (projList.get(x).getProjID() == req.getProjID()) {
				proj = projList.get(x);
				return proj;
			}
		}
		return proj;
	}
	
	public void approveTitleRequests (request req, project proj, String newTItle) {
		proj.setProjTitle(newTItle);
		req.setReqStatus("approved");
		System.out.println("Title has been changed");
	}
	
	public void rejectRequests (request req) {
		req.setReqStatus("rejected");
		System.out.println("Request has been rejected");
	}
}