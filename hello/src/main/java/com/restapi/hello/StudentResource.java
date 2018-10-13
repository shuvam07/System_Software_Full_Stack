package com.restapi.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void here() {
		System.out.println("here....");
	}
	
	@GET
	@Path("student/{roll}")
	@Produces({/*MediaType.APPLICATION_XML,*/MediaType.APPLICATION_JSON})
	public Student getStudent(@PathParam("roll") String roll) throws Exception {
		System.out.println("Roll : " +roll);
		JDBCConnection db = new JDBCConnection();
		db.connect();
		Student s = db.getDetails(roll);
		if(s==null) {
			System.out.println("Student not found");
			return null;
		}
		db.closeConnection();
		System.out.println("Total Marks = "+s.getTotalMarks());
		return s;
	}
	
	
	
}