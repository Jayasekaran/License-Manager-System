package com.service.user;

import java.sql.SQLException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MediaType;

@Path("/user/services")
public class UserServices {

	@PUT
	@Path("/create/{usrname}")
	@Produces(MediaType.APPLICATION_JSON)
	public License createUserLicense(@PathParam("usrname") String userName) {
		LicenseDB licenseDB = new LicenseDB();
		return licenseDB.createLicenseByUser(userName);
	}

	@GET
	@Path("/get/{usrname}")
	@Produces(MediaType.APPLICATION_JSON)
	public License getUserLicense(@PathParam("usrname") String userName) {
		LicenseDB licenseDB = new LicenseDB();
		return licenseDB.getLicenseByUser(userName);
	}

	@POST
	@Path("/update/{usrname}")
	@Produces(MediaType.APPLICATION_JSON)
	public License updateUserLicense(@PathParam("usrname") String userName) {
		System.out.println("user name is TEST updated");
		LicenseDB licenseDB = new LicenseDB();
		return licenseDB.updateLicenseByUser(userName);
	}

	@DELETE
	@Path("/remove/{usrname}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUserLicense(@PathParam("usrname") String userName) throws ClassNotFoundException, SQLException {
		System.out.println("License TEST is deleted");
		LicenseDB licenseDB = new LicenseDB();
		return licenseDB.removeLicenseByUser(userName);
	}

	// @Path("/license")
	// public UserLicense getUserLicense(){
	// return new UserLicense();
	// }
}
