<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>License Client</title>
<script language="JavaScript">

	function getLicense() {
	    var xhttp = new XMLHttpRequest();
	    var username = document.getElementById("usrname");
	    var url = "http://localhost:8080/LicenseService/backend/user/services/get/" + username.value;
	    xhttp.open("GET", url, true);
	    xhttp.onreadystatechange = function () {
	    	 var licKey = document.getElementById("licensekey");
	    	    var licType = document.getElementById("licensetype");
	    	    var expDate = document.getElementById("expirydate");
	  		  var blade =  document.getElementById("blade");
		      var optional_list =  document.getElementById("optional_list");
		      var seats =  document.getElementById("seats");
	    	    if (xhttp.readyState == 4 && xhttp.status == 200) {
	    	        var response = eval("(" + xhttp.responseText + ")");
	    	        if (response.licenseKey != "0" || response.licenseKey != null) {
	    	            licKey.value = response.licenseKey;
	    	            licType.value = response.licenseType;
	    	            expDate.value = response.expiryDate;
	    	        	blade.value = response.blade;
	    	        	optional_list.value = response.optional_list;
	    	        	seats.value = response.seats;
	    	        	document.getElementById("status_div").innerHTML = response.statueMessage;
	    	        }
	    	        else {
	    	            licKey.value = "";
	    	            licType.value = "";
	    	            expDate.value = "";
	    	        	blade.value = "";
	    	        	optional_list.value ="";
	    	        	seats.value = "";
	    	        	document.getElementById("status_div").innerHTML = response.statueMessage;
	    	            confirmMessage();
	    	        }
	    	    }
	    	    else{
	    	    	document.getElementById("status_div").innerHTML = "error..";
	    	    }
	    };
	    xhttp.send(null);
	};
	

function parseResponse(arr) {
    var out = "";
    var i;
    for(i = 0; i < arr.length; i++) {
    	out +=  arr[i].display + '<br>';   
    	}
    $('status_div').innerHTML = out;
}

function confirmMessage() {
    var x;
    var r = "Licensing provides additional HPE iLO functionality, such as "+
            "graphical remote console, multi-user collaboration, and "+
            "video record/playback along with many more advanced features.\n\n"+
    	    " Do you want to get iLO license?";
    if (confirm(r) == true) {
    	createLicense();
    } 
}

function createLicense() {
	  var xhttp = new XMLHttpRequest();
	  var err = "";
	  var username = document.getElementById("usrname");
	  var url = "http://localhost:8080/LicenseService/backend/user/services/create/" + username.value;
	  xhttp.onreadystatechange = function() {
		  var licKey =  document.getElementById("licensekey");
	      var licType =  document.getElementById("licensetype");
	      var expDate =  document.getElementById("expirydate");
		  var blade =  document.getElementById("blade");
	      var optional_list =  document.getElementById("optional_list");
	      var seats =  document.getElementById("seats");
	    if (xhttp.readyState == 4 && xhttp.status == 200) {
	        var response = eval( "(" +  xhttp.responseText + ")");
	        if (response.licenseKey != "0" ) {
	        	licKey.value = response.licenseKey;
	        	licType.value = response.licenseType;
	        	expDate.value = response.expiryDate;
	        	blade.value = response.blade;
	        	optional_list.value = response.optional_list;
	        	seats.value = response.seats;
	        } 
	        else {
	        	licKey.value = "";
	        	licType.value ="";
	        	expDate.value = "";
	        	blade.value = "";
	        	optional_list.value ="";
	        	seats.value = "";
	        }
        	document.getElementById("status_div").innerHTML = response.statueMessage;
	        
	  }
	  else
		  document.getElementById("status_div").innerHTML  ="Error in creating key data..";
	    };
	  xhttp.open("PUT", url, true);
	  xhttp.setRequestHeader("Content-type","text/plain");
	  xhttp.send();
	};

	function updateLicense() {
		  var xhttp = new XMLHttpRequest();	
		  var username = document.getElementById("usrname");
		  var url ="http://localhost:8080/LicenseService/backend/user/services/update/" + username.value;
		  var licKey =  document.getElementById("licensekey");
	      var licType =  document.getElementById("licensetype");
	      var expDate =  document.getElementById("expirydate");
		  var blade =  document.getElementById("blade");
	      var optional_list =  document.getElementById("optional_list");
	      var seats =  document.getElementById("seats");
		  xhttp.open("POST", url, true);
		  
		  xhttp.onreadystatechange = function() {
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
				var response = eval( "(" +  xhttp.responseText + ")");
		       	licKey.value = response.licenseKey;
		       	licType.value = response.licenseType;
		       	expDate.value = response.expiryDate; 
		       	blade.value = response.blade;
	        	optional_list.value = response.optional_list;
	        	seats.value = response.seats;
		       	document.getElementById("status_div").innerHTML = response.statueMessage;
		    }
		  };
		  xhttp.send();
		};
		function deleteLicense() {
			  var xhttp = new XMLHttpRequest();
			  var username = document.getElementById("usrname");
			  var url ="http://localhost:8080/LicenseService/backend/user/services/remove/" + username.value;
			  var licKey =  document.getElementById("licensekey");
		      var licType =  document.getElementById("licensetype");
		      var expDate =  document.getElementById("expirydate");
			  var blade =  document.getElementById("blade");
		      var optional_list =  document.getElementById("optional_list");
		      var seats =  document.getElementById("seats");
			  xhttp.open( "DELETE", url, true);
			  xhttp.onreadystatechange = function() {
			    if (xhttp.readyState == 4 && xhttp.status == 200) {
			    	document.getElementById("status_div").innerHTML = xhttp.responseText;
			    	username.value = "";
		        	licKey.value = "";
		        	licType.value ="";
		        	expDate.value = "";
		        	blade.value = "";
		        	optional_list.value ="";
		        	seats.value = "";
			    }
			  };
			  xhttp.send();
			};
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
				<td></td>
				<td>User name:</td>
				<td><input type="text" id="usrname" size="40" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>License Key :</td>
				<td><input type="text" id="licensekey" size="40" /></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td>License Type :</td>
				<td><input type="text" id="licensetype" size="40" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>Expiry Date :</td>
				<td><input type="text" id="expirydate" size="40" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>Blade :</td>
				<td><input type="text" id="blade" size="40" /></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td>Optional List :</td>
				<td><input type="text" id="optional_list" size="40" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>Seats :</td>
				<td><input type="text" id="seats" size="40" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><button type="button" onclick="createLicense()">Create</button>
					<button type="button" onclick="getLicense()">Validate</button>
					<button type="button" onclick="updateLicense()">Edit</button>
					<button type="button" onclick="deleteLicense()">Delete</button></td>
				<td></td>
			</tr>
		</table>
		<div id="status_div"></div>
	</div>
</body>
</html>