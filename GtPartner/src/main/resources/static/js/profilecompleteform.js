$(document).ready(function(){
	var result;
	var current_fs, next_fs, previous_fs; //fieldsets
	var opacity;
	var current = 1;
	var steps = $("fieldset").length;
	
    setProgressBar(current);
    
    $(".nextFromFirstStep").click(function(){
//    	current_fs = $(this).parent();
//		next_fs = $(this).parent().next();
//		
//		//Add Class Active
//		$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
//		
//		//show the next fieldset
//		next_fs.show(); 
//		//hide the current fieldset with style
//		current_fs.animate({opacity: 0}, {
//			step: function(now) {
//				// for making fielset appear animation
//				opacity = 1 - now;
//	
//				current_fs.css({
//					'display': 'none',
//					'position': 'relative'
//				});
//				next_fs.css({'opacity': opacity});
//			}, 
//			duration: 500
//		});
//		setProgressBar(++current);

    	var comId = document.getElementById("rowId").value;
    	var comLegalName = document.getElementById("comLegalName").value;
    	var secondComName = document.getElementById("secondComName").value;
    	var countryOfReg = document.getElementById("countryOfReg").value;
    	var state = document.getElementById("state").value;
    	var regDate = document.getElementById("regDate").value;
    	var taxId = document.getElementById("taxId").value;
    	var legalAddr = document.getElementById("legalAddr").value;
    	var secondAddr = document.getElementById("secondAddr").value;
    	var telephone = document.getElementById("telephone").value;
    	var website = document.getElementById("website").value;
    	var employeeCount = document.getElementById("employeeCount").value;
    	var pComLegalName = document.getElementById("pComLegalName").value;
    	var parentSecondName = document.getElementById("parentSecondName").value;
    	var parentLocation = document.getElementById("parentLocation").value;
    	var globalName = document.getElementById("globalName").value;
    	var secondGlobalName = document.getElementById("secondGlobalName").value;
    	var globalLocation = document.getElementById("globalLocation").value;
    	var bodCount = document.getElementById("bodCount").value;
    	var personalConnection = document.getElementById("personalConnection").value;
    	var isGovCon = document.getElementById("isGovCon").value;
    	var isGov = document.getElementById("isGov").value;
    	var ethical1 = document.getElementById("ethical1").value;
    	var ethical2 = document.getElementById("ethical2").value;
    	var export1 = document.getElementById("export1").value;
    	var export2 = document.getElementById("export2").value;
    	
    	var radio1 = document.querySelector('input[name = "radio1"]:checked') == null? "" : document.querySelector('input[name = "radio1"]:checked').value;
    	var radio2 = document.querySelector('input[name = "radio2"]:checked') == null? "" : document.querySelector('input[name = "radio1"]:checked').value;
    	var radio3 = document.querySelector('input[name = "radio3"]:checked') == null? "" : document.querySelector('input[name = "radio1"]:checked').value;
    	var radio4 = document.querySelector('input[name = "radio4"]:checked') == null? "" : document.querySelector('input[name = "radio1"]:checked').value;
    	
    	if(comLegalName == "" || countryOfReg=="" || regDate=="" || taxId=="" || legalAddr=="" || website=="" || employeeCount=="" || bodCount == "" || personalConnection == "" || isGovCon =="" || isGov == "" || ethical1 == "" || ethical2 == "" || export1 == "" || export2 == "" || radio1 == "" || radio2 == ""){
    	
    		alert("Please fill up mandatory fields");
    		return 0;
    	}
    	
    	else{
    	
    		if((radio1 == "yes" && secondComName== "") || (radio2 == "yes" && secondAddr== "") || (radio3 == "yes" && parentSecondName == "") || (radio4 == "yes" && secondGlobalName== "")){
    			
    			alert("Please fill up mandatory fields");
    			return 0;
    			
    		}
    		
    		else{
    			var company = {};
    			company["id"]= comId;
    			company["address"] = legalAddr;
    			company["companyName"] = comLegalName;  
    			company["companySecondName"] = secondComName;
    			company["country"] = countryOfReg;
    			company["ethical1"] = ethical1;
    			company["ethical2"] = ethical2;
    			company["export1"] = export1;
    			company["export2"] = export2;  
    			company["incorporation_date"] = regDate;
    			company["isGov"] = isGov;
    			company["isGovCon"] = isGovCon;
    			company["noOfBod"] = bodCount;
    			company["noOfEmployees"] = employeeCount;
    			company["parentCompanyGlobalLocation"] = globalLocation;  
    			company["parentCompanyGlobalName"] = globalName;
    			company["parentCompanyLocation"] = parentLocation;
    			company["parentCompanyName"] = pComLegalName;
    			company["parentCompanySecondGlobalName"] = secondGlobalName;
    			company["parentCompanySecondName"] = parentSecondName;
    			company["personalConnection"] = personalConnection;  
    			company["province"] = state;
    			company["secondAddress"] = secondAddr;
    			company["taxId"] = taxId;
    			company["telephone"] = telephone;
    			company["website"] = website;
                
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "/addCompany",
                    data: JSON.stringify(company),
                    dataType: 'json',
                    cache: false,
                    timeout: 600000,
                    success: function (data) {
                        console.log(data["message"]);
                        if(data["message"]=="Failed"){
                        	alert("Failed to save data. Please try again");
                        	result = data["message"];
                        }
                        
                        else{
//                        	current_fs = $(this).parent();
//                			next_fs = $(this).parent().next();
//                			
//                			//Add Class Active
//                			$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
//                			
//                			//show the next fieldset
//                			next_fs.show(); 
//                			//hide the current fieldset with style
//                			current_fs.animate({opacity: 0}, {
//                				step: function(now) {
//                					// for making fielset appear animation
//                					opacity = 1 - now;
//                		
//                					current_fs.css({
//                						'display': 'none',
//                						'position': 'relative'
//                					});
//                					next_fs.css({'opacity': opacity});
//                				}, 
//                				duration: 500
//                			});
//                			setProgressBar(++current);
                        	result = data["message"];
                        }

                    },
                    error: function (e) {

                        alert("Failed to save data. Please try again");
                        result = e;

                    },
                    async: false
                });
                
                if(result == "Failed"){
                	
                }
                
                else{
                	document.getElementById("rowId").value = result;
                	current_fs = $(this).parent();
        			next_fs = $(this).parent().next();
        			
        			//Add Class Active
        			$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
        			
        			//show the next fieldset
        			next_fs.show(); 
        			//hide the current fieldset with style
        			current_fs.animate({opacity: 0}, {
        				step: function(now) {
        					// for making fielset appear animation
        					opacity = 1 - now;
        		
        					current_fs.css({
        						'display': 'none',
        						'position': 'relative'
        					});
        					next_fs.css({'opacity': opacity});
        				}, 
        				duration: 500
        			});
        			setProgressBar(++current);
                }
                
    			
    		}
    		
    	}
    });
	
	$(".next").click(function(){
        
        current_fs = $(this).parent();
        next_fs = $(this).parent().next();
        
        //Add Class Active
        $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
        
        //show the next fieldset
        next_fs.show(); 
        //hide the current fieldset with style
        current_fs.animate({opacity: 0}, {
            step: function(now) {
                // for making fielset appear animation
                opacity = 1 - now;
    
                current_fs.css({
                    'display': 'none',
                    'position': 'relative'
                });
                next_fs.css({'opacity': opacity});
            }, 
            duration: 500
        });
        setProgressBar(++current);
    });
    
    $(".previous").click(function(){
        
        current_fs = $(this).parent();
        previous_fs = $(this).parent().prev();
        
        //Remove class active
        $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
        
        //show the previous fieldset
        previous_fs.show();
    
        //hide the current fieldset with style
        current_fs.animate({opacity: 0}, {
            step: function(now) {
                // for making fielset appear animation
                opacity = 1 - now;
    
                current_fs.css({
                    'display': 'none',
                    'position': 'relative'
                });
                previous_fs.css({'opacity': opacity});
            }, 
            duration: 500
        });
        setProgressBar(--current);
    });
    
    function setValue(value){
    	result = value;
    }
    
    function setProgressBar(curStep){
        var percent = parseFloat(100 / steps) * curStep;
        percent = percent.toFixed();
        $(".progress-bar")
          .css("width",percent+"%")   
    }
    
    $(".submit").click(function(){
        return false;
    })
        
});


	
	