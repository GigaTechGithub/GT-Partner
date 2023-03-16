

function isValidPassword(password) {
	
	const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);
	const passwordMsgLabel = $("#passwordMsgLabel");
	passwordMsgLabel.get(0).style.display = "None";
  // Check if password meets minimum length requirement
  if (password.length < 8) {
	  passwordMsgLabel.get(0).style.display = "block";
	  passwordMsgLabel.get(0).textContent = 'Password must include 8 characters';
	  passwordMsgLabel.get(0).style.color = "red";
	  return false;
  }
  
  // Check if password includes at least one lowercase letter, one uppercase letter, one digit, and one special character
  const hasLowerCase = /[a-z]/.test(password);
  const hasUpperCase = /[A-Z]/.test(password);
  const hasDigit = /\d/.test(password);
		
  if (!hasLowerCase) {
	  passwordMsgLabel.get(0).style.display = "block";
	  passwordMsgLabel.get(0).textContent = 'Password must include a lowercase letter';
	  passwordMsgLabel.get(0).style.color = "red";
	  return false;
  }
  if (!hasUpperCase) {
	  passwordMsgLabel.get(0).style.display = "block";
	  passwordMsgLabel.get(0).textContent = 'Password must include an uppercase letter';
	  passwordMsgLabel.get(0).style.color = "red";
	  return false;
  }
  if (!hasDigit) {
	  passwordMsgLabel.get(0).style.display = "block";
	  passwordMsgLabel.get(0).textContent = 'Password must include a digit';
	  passwordMsgLabel.get(0).style.color = "red";
	  return false;
  }
  if (!hasSpecialChar) {
	  passwordMsgLabel.get(0).style.display = "block";
	  passwordMsgLabel.get(0).textContent = 'Password must include a special character';
	  passwordMsgLabel.get(0).style.color = "red";
	  return false;
  }
  
  
  passwordMsgLabel.get(0).style.display = "None";
  // Password meets all requirements
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
    
    const isValid = isValidPassword(password);
    
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




