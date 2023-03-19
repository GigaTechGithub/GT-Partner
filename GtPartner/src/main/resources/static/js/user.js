

function isValidPassword(password, passwordMsgLabel, confirmPassword, confirmPasswordLabel) {
	
	passwordMsgLabel.style.display = "None";
	confirmPasswordLabel.display = "None";
  // Check if password meets minimum length requirement
  if (password.length < 8) {
	  passwordMsgLabel.style.display = "block";
	  passwordMsgLabel.textContent = 'Password must include 8 characters eg, Abc@123';
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
	  passwordMsgLabel.textContent = 'Password must include a lowercase letter eg, Abc@123';
	  passwordMsgLabel.style.color = "red";
	  return false;
  }
  if (!hasUpperCase) {
	  passwordMsgLabel.style.display = "block";
	  passwordMsgLabel.textContent = 'Password must include an uppercase letter eg, Abc@123';
	  passwordMsgLabel.style.color = "red";
	  return false;
  }
  if (!hasDigit) {
	  passwordMsgLabel.style.display = "block";
	  passwordMsgLabel.textContent = 'Password must include a digit eg, Abc@123';
	  passwordMsgLabel.style.color = "red";
	  return false;
  }
  if (!hasSpecialChar) {
	  passwordMsgLabel.style.display = "block";
	  passwordMsgLabel.textContent = 'Password must include a special character eg, Abc@123';
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
    
    const isValid = isValidPassword(password, passwordMsgLabel, confirmPassword, confirmPasswordLabel);
    
    if (isValid) {
    	if(fullName == "" || userName == "" || password == "" || email == "" || admin == "" || selectStatus == ""){
    		alert("Please fill up mandatory fields");
    	}else{
        	if(admin == "no" && selectCompany == ""){
        		alert("Please fill up mandatory fields");
        	}
        	else{
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




