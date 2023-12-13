package com.dollop.lib;

public class Validation {
   
	public boolean isEmail(String email)
	{
		try{if(email.substring(email.length()-10).equals("@gmail.com"))
			  return true;
		}catch(Exception e) {
			
		}
		
		
		return false;
	}
	
	public boolean isMobile(String mobile){
		if(mobile.length()==10 && mobile.charAt(0)>'5')
		{
		   for(int i=0;i<mobile.length();i++)
		   {
			   if(mobile.charAt(i)<'0' || mobile.charAt(i)>'9')
				   return false;
		   }
			return true;
		}
		return false;
	}
	
	public boolean isName(String name){
	    
		 for(int i=0;i<name.length();i++)
		   {
			   if(!(name.charAt(i)>='a' && name.charAt(i)<='z' ||name.charAt(i)>='A' && name.charAt(i)<='Z'))
				   return false;
		   }
			return true;
	}

	public boolean isPassword(String password,String confirm) {
		if(password.length()==8 && password.equals(confirm))
			return true;
		return false;
	}
}
