$(document).ready(function(){
	var result;
	var current_fs, next_fs, previous_fs; //fieldsets
	var opacity;
	var current = 1;
	var steps = $("fieldset").length;
	
    setProgressBar(current);
    
    $(".nextFromFirstStep").click(function(){

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
    	var radio2 = document.querySelector('input[name = "radio2"]:checked') == null? "" : document.querySelector('input[name = "radio2"]:checked').value;
    	var radio3 = document.querySelector('input[name = "radio3"]:checked') == null? "" : document.querySelector('input[name = "radio3"]:checked').value;
    	var radio4 = document.querySelector('input[name = "radio4"]:checked') == null? "" : document.querySelector('input[name = "radio4"]:checked').value;
    	
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
    
	$(".nextFromSecondStep").click(function(){
		
		var legId = document.getElementById("rowId2").value;
		var leg1 = document.getElementById("legal1").value;
		var leg2 = document.getElementById("legal2").value;
		var leg3 = document.getElementById("legal3").value;
		var leg4 = document.getElementById("legal4").value;
		var leg5 = document.getElementById("legal5").value;
		var leg6 = document.getElementById("legal6").value;
		var leg7 = document.getElementById("legal7").value;
		var leg8 = document.getElementById("legal8").value;
		var leg9 = document.getElementById("legal9").value;
		var leg10 = document.getElementById("legal10").value;
		var leg11 = document.getElementById("legal11").value;
		var leg12 = document.getElementById("legal12").value;
		var leg13 = document.getElementById("legal13").value;
		var leg14 = document.getElementById("legal14").value;
		var leg15 = document.getElementById("legal15").value;
		var leg16 = document.getElementById("legal16").value;
		
		var legal = {};
		legal["id"]= legId;
		legal["legal1"] = leg1;
		legal["legal2"] = leg2;
		legal["legal3"] = leg3;
		legal["legal4"] = leg4;
		legal["legal5"] = leg5;
		legal["legal6"] = leg6;
		legal["legal7"] = leg7;
		legal["legal8"] = leg8;
		legal["legal9"] = leg9;
		legal["legal10"] = leg10;
		legal["legal11"] = leg11;
		legal["legal12"] = leg12;
		legal["legal13"] = leg13;
		legal["legal14"] = leg14;
		legal["legal15"] = leg15;
		legal["legal16"] = leg16;
		
		$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/addLegal",
            data: JSON.stringify(legal),
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
        	document.getElementById("rowId2").value = result;
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
	        
    });
	
	$(".nextFromThirdStep").click(function(){
        
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
	
	$(".nextFromFourthStep").click(function(){
		
		var revId = document.getElementById("rowId4").value;
		var revenue1 = document.getElementById("revenue1").value;
		var revenue2 = document.getElementById("revenue2").value;
		var revenue3 = document.getElementById("revenue3").value;
		var revenue4 = document.getElementById("revenue4").value;
		
		var revenue = {};
		revenue["id"]= revId;
		revenue["revenue1"]= revenue1;
		revenue["revenue2"]= revenue2;
		revenue["revenue3"]= revenue3;
		revenue["revenue4"]= revenue4;
        
		$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/addRevenue",
            data: JSON.stringify(revenue),
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
        	document.getElementById("rowId4").value = result;
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
    });
	
	$(".nextFromFifthStep").click(function(){
		var techId = document.getElementById("rowId5").value;
		var tech1 = document.getElementById("tech1").value;
		var tech2 = document.getElementById("tech2").value;
		var tech3 = document.getElementById("tech3").value;
		var tech4 = document.getElementById("tech4").value;
		var tech5 = document.getElementById("tech5").value;
		var tech6 = document.getElementById("tech6").value;
		var tech7 = document.getElementById("tech7").value;
		var tech8 = document.getElementById("tech8").value;
		var tech9 = document.getElementById("tech9").value;
		var tech10 = document.getElementById("tech10").value;
		var tech11 = document.getElementById("tech11").value;
		var tech12 = document.getElementById("tech12").value;
		var tech13 = document.getElementById("tech13").value;
		var tech14 = document.getElementById("tech14").value;
		var tech15 = document.getElementById("tech15").value;
		var tech16 = document.getElementById("tech16").value;
		var tech17 = document.getElementById("tech17").value;
		var tech18 = document.getElementById("tech18").value;
		var tech19 = document.getElementById("tech19").value;
		var tech20 = document.getElementById("tech20").value;
		var tech21 = document.getElementById("tech21").value;
		var tech22 = document.getElementById("tech22").value;
		var tech23 = document.getElementById("tech23").value;
		var tech24 = document.getElementById("tech24").value;
		var tech25 = document.getElementById("tech25").value;
		var tech26 = document.getElementById("tech26").value;
		var tech27 = document.getElementById("tech27").value;
		var tech28 = document.getElementById("tech28").value;
		var tech29 = document.getElementById("tech29").value;
		var tech30 = document.getElementById("tech30").value;
		var tech31 = document.getElementById("tech31").value;
		var tech32 = document.getElementById("tech32").value;
		var tech33 = document.getElementById("tech33").value;
		var tech34 = document.getElementById("tech34").value;
		var tech35 = document.getElementById("tech35").value;
		var tech36 = document.getElementById("tech36").value;
		var tech37 = document.getElementById("tech37").value;
		var tech38 = document.getElementById("tech38").value;
		var tech39 = document.getElementById("tech39").value;
		var tech40 = document.getElementById("tech40").value;
		var tech41 = document.getElementById("tech41").value;
		var tech42 = document.getElementById("tech42").value;
		
		var tech = {};
		tech["id"]= techId;
		tech["tech1"] = tech1;
		tech["tech2"] = tech2;
		tech["tech3"] = tech3;
		tech["tech4"] = tech4;
		tech["tech5"] = tech5;
		tech["tech6"] = tech6;
		tech["tech7"] = tech7;
		tech["tech8"] = tech8;
		tech["tech9"] = tech9;
		tech["tech10"] = tech10;
		tech["tech11"] = tech11;
		tech["tech12"] = tech12;
		tech["tech13"] = tech13;
		tech["tech14"] = tech14;
		tech["tech15"] = tech15;
		tech["tech16"] = tech16;
		tech["tech17"] = tech17;
		tech["tech18"] = tech18;
		tech["tech19"] = tech19;
		tech["tech20"] = tech20;
		tech["tech21"] = tech21;
		tech["tech22"] = tech22;
		tech["tech23"] = tech23;
		tech["tech24"] = tech24;
		tech["tech25"] = tech25;
		tech["tech26"] = tech26;
		tech["tech27"] = tech27;
		tech["tech28"] = tech28;
		tech["tech29"] = tech29;
		tech["tech30"] = tech30;
		tech["tech31"] = tech31;
		tech["tech32"] = tech32;
		tech["tech33"] = tech33;
		tech["tech34"] = tech34;
		tech["tech35"] = tech35;
		tech["tech36"] = tech36;
		tech["tech37"] = tech37;
		tech["tech38"] = tech38;
		tech["tech3"] = tech3;
		tech["tech39"] = tech39;
		tech["tech40"] = tech40;
		tech["tech41"] = tech41;
		tech["tech42"] = tech42;
		
		$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/addTechnology",
            data: JSON.stringify(tech),
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
        	document.getElementById("rowId5").value = result;
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
    });
	
	$(".nextFromSixthStep").click(function(){
		
		var ipId = document.getElementById("rowId6").value;
		var ip1 = document.getElementById("ip1").value;
		var ip2 = document.getElementById("ip2").value;
		var ip3 = document.getElementById("ip3").value;
		var ip4 = document.getElementById("ip4").value;
		var ip5 = document.getElementById("ip5").value;
		var ip6 = document.getElementById("ip6").value;
		var ip7 = document.getElementById("ip7").value;
		var ip8 = document.getElementById("ip8").value;
		var ip9 = document.getElementById("ip9").value;	
		
		var ip = {};
		ip["id"]= ipId;
		ip["ip1"]= ip1;
		ip["ip2"]= ip2;
		ip["ip3"]= ip3;
		ip["ip4"]= ip4;
		ip["ip5"]= ip5;
		ip["ip6"]= ip6;
		ip["ip7"]= ip7;
		ip["ip8"]= ip8;
		ip["ip9"]= ip9;
        
		$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/addIp",
            data: JSON.stringify(ip),
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
        	document.getElementById("rowId6").value = result;
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
    });
	
	$(".nextFromSeventhStep").click(function(){
		
		var itId = document.getElementById("rowId7").value;
		var it1 = document.getElementById("it1").value;
		var it2 = document.getElementById("it2").value;
		var it3 = document.getElementById("it3").value;
		var it4 = document.getElementById("it4").value;
		var it5 = document.getElementById("it5").value;
		var it6 = document.getElementById("it6").value;
		var it7 = document.getElementById("it7").value;
		var it8 = document.getElementById("it8").value;
		var it9 = document.getElementById("it9").value;
		var it10 = document.getElementById("it10").value;
		
		var it = {};
		it["id"]= itId;
		it["it1"]= it1;
		it["it2"]= it2;
		it["it3"]= it3;
		it["it4"]= it4;
		it["it5"]= it5;
		it["it6"]= it6;
		it["it7"]= it7;
		it["it8"]= it8;
		it["it9"]= it9;
		it["it10"]= it10;
        
		$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/addIt",
            data: JSON.stringify(it),
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
        	document.getElementById("rowId7").value = result;
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




	
	