package com.service.user;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class License {

	String uname;
	String licenseKey;
	String licenseType;
	String expiryDate;
	String blade;
	String optional_list;
	int seats;
	String statueMessage;

	public String getStatueMessage() {
		return statueMessage;
	}

	public void setStatueMessage(String statueMessage) {
		this.statueMessage = statueMessage;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBlade() {
		return blade;
	}

	public void setBlade(String blade) {
		this.blade = blade;
	}

	public String getOptional_list() {
		return optional_list;
	}

	public void setOptional_list(String optional_list) {
		this.optional_list = optional_list;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setExpiryDate(Date sqlDate) {
		// TODO Auto-generated method stub

	}
}
