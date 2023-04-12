package sc2002assignment;

import java.util.ArrayList;

public class student extends request {
	private String studentID;
	private String name;
	private String email;
	private boolean hasProject;
	private int studProjID;
	
	public student (String name, String email) {
		this.name = name;
		this.email = email;
		studentID = email.substring(0, email.indexOf('@'));
		hasProject = false;
		studProjID = 0;
	}
	
	public void viewProjects (ArrayList<project> projList) {
		if (this.hasProject == true) {
			System.out.println("Student already has project.");
			return;
		}
		else {			
			System.out.println("List of projects: ");
			for (int x = 0; x < projList.size(); x++) {
				project proj = projList.get(x);
				System.out.println("Project ID: " + proj.getProjID() + "\tProject Title: " + proj.getProjName());
			}
		}
	}
	
	public void reqProject (ArrayList<request> reqList, int projID) {
		request req = new request();
		if (reqList.size() == 0) {
			req.setReqID(1);
		}
		else {
			req.setReqID(reqList.size() + 1);
		}
		req.setStudentID(studentID);
		req.setProjID(projID);
		req.setReqType("allocate");
		reqList.add(req);
	}
	
	public void viewRegProject (ArrayList<project> projList) {
		if (hasProject == false) {
			System.out.println("You have not registered a project.");
		}
		else {
			for (int x = 0; x < projList.size(); x++) {
				if (projList.get(x).getStudID().equalsIgnoreCase(this.studentID)) {
					System.out.println("Here is your registered project");
				}
			}
		}
	}
	
	public void reqEditProjTitle (ArrayList<request> reqList, int projID, String newTitle) {
		request req = new request();
		if (reqList.size() == 0) {
			req.setReqID(1);
		}
		else {
			req.setReqID(reqList.size() + 1);
		}
		req.setStudentID(studentID);
		req.setProjID(projID);
		req.setReqType("title");
		req.setReqStatus("pending");
		req.setNewTitle(newTitle);
		reqList.add(req);
		System.out.println("Request has been sent");
	}
	
	public void deregisterProj (ArrayList<request> reqList, int projID) {
		request req = new request();
		if (reqList.size() == 0) {
			req.setReqID(1);
		}
		else {
			req.setReqID(reqList.size() + 1);
		}
		req.setStudentID(studentID);
		req.setProjID(projID);
		req.setReqType("unregister");
		req.setReqStatus("pending");
		reqList.add(req);
		System.out.println("Request has been sent");
	}
	
	public void viewReqHistory (ArrayList<request> reqList, String studentID) {
		System.out.println("Here is your request history: ");
		for (int x = 0; x < reqList.size(); x++) {
			if (reqList.get(x).getStudentID().equalsIgnoreCase(studentID)) {
				System.out.print("Request ID: ");
				System.out.println(reqList.get(x).getReqID());
			}
		}
	}
	
	public boolean getHasProj () {
		return this.hasProject;
	}
	
	public boolean setHasProj (boolean hasProj) {
		return this.hasProject = hasProj;
	}
	
	public String getStudentID () {
		return studentID;
	}
	
	public String getStudentEmail () {
		return email;
	}
	
	public String getStudentName () {
		return name;
	}
	
	public int getStudentProjID () {
		return studProjID;
	}
}
