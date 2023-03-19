

function isValidPassword(password, passwordMsgLabel, confirmPassword, confirmPasswordLabel) {
	
	passwordMsgLabel.style.display = "None";
	confirmPasswordLabel.display = "None";
  // Check if password meets minimum length requirement
  if (password.length < 8) {
	  passwordMsgLabel.style.display = "block";
	  passwordMsgLabel.textContent = 'Password must include 8 characters eg, Abcd@123';
	  passwordMsgLabel.style.color = "red";
	  return false;
  }
  
  // Check if password includes at least one lowercase letter, one uppercase letter, one digit, and one special character
  const hasLowerCase = /[a-z]/.test(password);
  const hasUpperCase = /[A-Z]/.test(password);
  const hasDigit = /\d/.test(password);
  const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);
	
  if (!hasLowerCase) {
	  passwordMsgLabel.style.display = "block";
	  passwordMsgLabel.textContent = 'Password must include a lowercase letter eg, Abcd@123';
	  passwordMsgLabel.style.color = "red";
	  return false;
  }
  if (!hasUpperCase) {
	  passwordMsgLabel.style.display = "block";
	  passwordMsgLabel.textContent = 'Password must include an uppercase letter eg, Abcd@123';
	  passwordMsgLabel.style.color = "red";
	  return false;
  }
  if (!hasDigit) {
	  passwordMsgLabel.style.display = "block";
	  passwordMsgLabel.textContent = 'Password must include a digit eg, Abcd@123';
	  passwordMsgLabel.style.color = "red";
	  return false;
  }
  if (!hasSpecialChar) {
	  passwordMsgLabel.style.display = "block";
	  passwordMsgLabel.textContent = 'Password must include a special character eg, Abcd@123';
	  passwordMsgLabel.style.color = "red";
	  return false;
  }
  
  if (password != confirmPassword) {
	  confirmPasswordLabel.style.display = "block";
	  confirmPasswordLabel.textContent = 'Password and Confirm Password does not match';
	  confirmPasswordLabel.style.color = "red";
	  return false;
  }
  
  passwordMsgLabel.style.display = "None";
  confirmPasswordLabel.style.display = "None";
  
  return true;
}

function addUser() {
	
    var fullName = $("#fullName").val();
    var userName = $("#userName").val();
    var password = $("#password").val();
    var email = $("#email").val();
    var mobile = $("#mobile").val();
    var admin = document.querySelector('input[name = "mRadio1"]:checked') == null ? "" : document.querySelector('input[name = "mRadio1"]:checked').value;
    var selectCompany = $("#selectCompany").val();
    var selectStatus = $("#selectStatus").val();
    var passwordMsgLabel = $("#passwordMsgLabel").get(0);
    var confirmPassword = $("#confirmPassword").val();
    var confirmPasswordLabel = $("#confirmedPasswordMsgLabel").get(0);
    
    	if(fullName == "" || userName == "" || password == "" || email == "" || admin == "" || selectStatus == ""){
    		alert("Please fill up mandatory fields");
    	}else{
        	if(admin == "no" && selectCompany == ""){
        		alert("Please fill up mandatory fields");
        	}
        	else{
        		var isValid = isValidPassword(password, passwordMsgLabel, confirmPassword, confirmPasswordLabel);
        		if (isValid) {
	        		var user = {};
	            	user["name"] = fullName;
	            	user["username"] = userName;
	            	user["password"] = password;    
	            	user["email"] = email;
	            	user["mobile"] = mobile;
	            	user["isAdmin"] = (admin=="yes"?"Y":"N");
	            	user["diligenceId"] = (selectCompany==""?0:selectCompany);
	            	user["status"] = selectStatus;
	            	
	            	$('#pleaseWaitDialog').modal('show');
	                
	                $.ajax({
	                    type: "POST",
	                    contentType: "application/json",
	                    url: "/saveUser",
	                    data: JSON.stringify(user),
	                    dataType: 'json',
	                    cache: false,
	                    timeout: 600000,
	                    success: function (data) {
	                        if(data["message"]=="Failed"){
	                        	alert("Failed to save data. Please try again");
	                        }
	                        
	                        else{
	                            var rowId = data["message"];
	                            var companyName = data["additionalInfo"];
	                            
	                        	$("#fullName").val("");
	                            $("#userName").val("");
	                            $("#password").val("");
	                            $("#email").val("");
	                            $("#mobile").val("");
	                            $("#selectCompany").val("");
	                            $("#selectStatus").val("");
	                            
	                            var companyName = data["additionalInfo"];
	                            var status = (selectStatus==0?"Inactive":"Active");
	                            var isAdmin = (admin=="yes"?"Y":"N");
	
	                            t.row.add([rowId, fullName, userName, companyName, email, mobile, status, '<input type="button" value="Edit User" id="editBtn" />' +' '+ '<input type="button" value="Delete User" id="dltBtn" style="background-color: yellow" />', selectCompany, isAdmin,password, password]).draw();
	
	                            $('#modalWindow1').modal('hide');
	                            $('#pleaseWaitDialog').modal('hide');
	                        }
	
	                    },
	                    error: function (e) {
	
	                        alert("Failed to save data. Please try again");
	
	                    }
	                });
	        	}
        	}
    	}
    
}

function updateUser() {
  	var rowId = $("#rowId").val();
    var fullName = $("#editFullName").val();
    var userName = $("#editUserName").val();
    var password = $("#editPassword").val();
    var email = $("#editEmail").val();
    var mobile = $("#editMobile").val();
    var admin = document.querySelector('input[name = "nRadio1"]:checked') == null ? "" : document.querySelector('input[name = "nRadio1"]:checked').value;
    var selectCompany = $("#editSelectCompany").val();
    var selectStatus = $("#editSelectStatus").val();
    var epml = $("#editPasswordMsgLabel").get(0);
    var confirmPassword = $("#editConfirmPassword").val();
    var ecpml = $("#editConfirmPasswordMsgLabel").get(0);
    
    if(fullName == "" || userName == "" || password == "" || email == "" || mobile ==  "" || admin == "" || selectStatus == ""){
		alert("Please fill up mandatory fields");
	}
    
    else{
    	if(admin == "no" && selectCompany == ""){
    		alert("Please fill up mandatory fields");
    	}
    	else{
    	    var isValid = isValidPassword(password, epml, confirmPassword, ecpml);
    	    if (isValid) {
    	    	var user = {};
        		user["id"] = rowId;
            	user["name"] = fullName;
            	user["username"] = userName;
            	user["password"] = password;    
            	user["email"] = email;
            	user["mobile"] = mobile;
            	user["isAdmin"] = (admin=="yes"?"Y":"N");
            	user["diligenceId"] = (selectCompany==null || selectCompany==""?"0":selectCompany);
            	user["status"] = selectStatus;
            	
            	console.log(user["diligenceId"]);
                
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/saveUser",
                    data: JSON.stringify(user),
                    dataType: 'json',
                    cache: false,
                    timeout: 600000,
                    success: function (data) {
                        if(data["message"]=="Failed"){
                        	alert("Failed to update data. Please try again");
                        }
                        
                        else{
                            var rowId = data["message"];
                            var companyName = data["additionalInfo"];
                            
                        	$("#fullName").val("");
                            $("#userName").val("");
                            $("#password").val("");
                            $("#email").val("");
                            $("#mobile").val("");
                            $("#selectCompany").val("");
                            $("#selectStatus").val("");
                            
                            var companyName = data["additionalInfo"];
                            var status = (selectStatus==0?"Inactive":"Active");
                            var isAdmin = (admin=="yes"?"Y":"N");
                            
                            t.rows().eq(0).each(function (index) { // loop through all the rows
                                var row = t.row(index);
                                var rowData = row.data(); // get the data for the current row
                                if (rowData[0] === rowId) { // check if the current row has the desired column value
                                    row.remove(); // remove the row from the DataTable
                                }
                            });
                            
                            t.draw();
                            
                            t.row.add([rowId, fullName, userName, companyName, email, mobile, status, '<input type="button" value="Edit User" id="editBtn" />' +' '+ '<input type="button" value="Delete User" id="dltBtn" style="background-color: yellow" />', selectCompany, isAdmin, password, password]).draw();

                            $('#modalWindow2').modal('hide');
                        }

                    },
                    error: function (e) {

                        alert("Failed to update data. Please try again");

                    }
                });
				
			}
    		
    	}
    }
}



