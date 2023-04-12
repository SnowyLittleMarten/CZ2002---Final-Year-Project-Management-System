package sc2002assignment;

import java.util.ArrayList;

public class project {
	private String projTitle;
	private int projID;
	private String supervisorID;
	private String supervisorName;
	private String supervisorEmail;
	private String status = "";
	private String studentName = "";
	private String studentEmail = "";
	private String studentID = "";
	
	public project (String projTitle, String supervisorID, String supervisorName, String supervisorEmail) {
		this.projTitle = projTitle;
		this.supervisorID = supervisorID;
		this.supervisorName = supervisorName;
		this.supervisorEmail = supervisorEmail;
		status = "available";
		studentName = "";
		studentEmail = "";
		studentID = "";
		projID = 0;
	}

	/* CAN IGNORE FOR NOW
	public project (ArrayList<project> projectList, project proj) {
		if (projectList.isEmpty() == true) {
			proj.setProjID(1);
		}
		else {
			proj.setProjID(projectList.size() + 1);
		}
		projectList.add(proj);
	}
	
	public project (ArrayList<project> projectList, String projTitle, String supervisorID, String supervisorName, String supervisorEmail) {
		project proj = new project(projTitle, supervisorID, supervisorName, supervisorEmail);
		if (projectList.isEmpty() == true) {
			proj.setProjID(1);
		}
		else {
			proj.setProjID(projectList.size() + 1);
		}
		projectList.add(proj);
	}
	*/
	
	public void viewProjectStudent(ArrayList<project> projectList, student stud) {
		if (stud.getHasProj() == true) {
			System.out.println("Student already has project.");
			return;
		}
		else {			
			System.out.println("List of projects: ");
			for (int x = 0; x < projectList.size(); x++) {
				project proj = projectList.get(x);
				System.out.println("Project ID: " + proj.projID + "\tProject Title: " + proj.projTitle + "\tSupervisor Name: " + proj.supervisorName + "\tSupervisor Email: " + proj.supervisorEmail);
			}
		}
	}
	
	public void registerProj(ArrayList<project> projectList, int projID, String studentName, String studentEmail) {
		for (int x = 0; x < projectList.size(); x++) {
			if (projectList.get(x).projID == projID) {
				projectList.get(x).studentName = studentName;
				projectList.get(x).studentEmail = studentEmail;
				projectList.get(x).status = "allocated";
				System.out.println("Project has been allocated");
				break;
			}
		}
	}
	
	public void editProjTitle(ArrayList<project> projectList, int projID, String newTitle) {
		for (int x = 0; x < projectList.size(); x++) {
			if (projectList.get(x).projID == projID) {
				projectList.get(x).projTitle = newTitle;
				System.out.println("Project ID " + projectList.get(x).projID + "'s title has been changed!");
			}
		}
	}
	
	public void deregisterProj(ArrayList<project> projectList, int projID, String studentName, String studentEmail) {
		for (int x = 0; x < projectList.size(); x++) {
			if (projectList.get(x).projID == projID && projectList.get(x).studentName == studentName && projectList.get(x).studentEmail == studentEmail) {
				projectList.get(x).studentName = "";
				projectList.get(x).studentEmail = "";
				projectList.get(x).status = "available";
				System.out.println("Project has been deregistered");
				break;
			}
		}
	}
	
	public String setProjTitle (String projTitle) {
		return this.projTitle = projTitle;
	}
	
	public int setProjID (int projID) {
		return this.projID = projID;
	}
	
	public int getProjID () {
		return projID;
	}
	
	public String getStudID() {
		return studentID;
	}
	
	public String getProjName() {
		return projTitle;
	}
	
	public String getSupervisorID() {
		return supervisorID;
	}
	
	public String setStudentName (String name) {
		return this.studentName = name;
	}
	
	public String setStudentEmail (String email) {
		return this.studentEmail = email;
	}
	
	public String setStudentID (String id) {
		return this.studentID = id;
	}
	
	public String setStatus (String status) {
		return this.status = status;
	}
	
}
