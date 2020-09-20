<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>License Form</title>
<script language="JavaScript">

	function cancelLicense(){
		window.location= "/LicenseClient/client.jsp";
		
	}
	function saveLicense(){
		window.location= "/LicenseClient/client.jsp";
		
	}
</script>
</head>

<body>
	<div id="license_div"
		style="text-align: center; font-size: 20px; font-weight: bold;">
		License Service Application</div>

	<div id="licensedetails_div"
		style="margin-top: 50px; margin-left: 150px;">
		<table>
			<tr>
				<td>User name:</td>
				<td><input type="text" name="usrname" size="40"/></td>
			</tr>
			<tr>
				<td>License Key :</td>
				<td><input type="text" name="licensekey" size="40" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="text" name="licensetype" size="40" /></td>
			</tr>
			<tr>
				<td>Expiry Date :</td>
				<td><input type="text" name="expirydate" size="40" /></td>
			</tr>
			<tr>
				<td>Blade :</td>
				<td><input type="text" name="blade" size="40" /></td>
			</tr>

			<tr>
				<td>Optional List :</td>
				<td><input type="text" id="optional_list" size="40" /></td>
			</tr>
			<tr>
				<td>Seats :</td>
				<td><input type="text" id="seats" size="40" /></td>
			</tr>
			<tr>
				<td><button type="button" onclick="saveLicense()">Save</button>
				<td><button type="button" onclick="cancelLicense()">Cancel</button>
			</tr>

		</table>
		<div id="status_div"></div>
	</div>
</body>
</html>