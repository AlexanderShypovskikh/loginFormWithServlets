
   function validateForm(){
	   var login = document.forms["loginForm"]["login"].value;
	   var pass = document.forms["loginForm"]["password"].value;
	      
	   if(login == ""){
		   document.getElementById("loginErr").innerHTML= "Please, enter correct value of Login";
	       return false;
	    } else if(pass == ""){
	    	 document.getElementById("passwordErr").innerHTML= "Please, enter correct value of Password";
	    	 return false;
	    } 
   } 
   
   
   function validateRegisterForm(){
	   var login = document.forms["registerForm"]["login"].value;
	   var pass = document.forms["registerForm"]["password"].value;
	   var fname = document.forms["registerForm"]["fname"].value;
	   var lname = document.forms["registerForm"]["lname"].value;
     
	   if(login == ""){
		   document.getElementById("loginErr").innerHTML= "Please, enter correct value of Login";
	       return false;
	    } else if(fname == ""){
			   document.getElementById("fnameErr").innerHTML= "Please, enter correct value of First  Name";
		       return false;
		       }else if(lname == ""){
				   document.getElementById("lnameErr").innerHTML= "Please, enter correct value of Last Name";
			       return false;
			       } else if(pass == ""){
			    	   	document.getElementById("passwordErr").innerHTML= "Please, enter correct value of Password";
			    	   		return false;
	                }
	        }
  
   function validateOrder(){
	   var login = document.forms["loginForm"]["login"].value;
	   var pass = document.forms["loginForm"]["password"].value;
	      
	   if(login == ""){
		   document.getElementById("loginErr").innerHTML= "Please, enter correct value of Login";
	       return false;
	    } else if(pass == ""){
	    	 document.getElementById("passwordErr").innerHTML= "Please, enter correct value of Password";
	    	 return false;
	    } 
   } 
   
   