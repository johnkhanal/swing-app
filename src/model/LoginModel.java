package model;

import java.io.*;
import java.util.*;
import view.Login;
public class LoginModel {
	// attributes needed 
	private String username;
	private char[] password;
	//constructor
	public LoginModel() { }

	//method created for researcher's login
	@SuppressWarnings("unchecked")
	public boolean checkResearcher(Login viewlogin)
	{
		boolean checked= false;
		ArrayList<ResearchersData> res = null;
		try {
			FileInputStream filestreamin = new FileInputStream("src/files/researcherdata.dat");
			ObjectInputStream objectstream = new ObjectInputStream(filestreamin);
			Object researcherObject= objectstream.readObject();
			res = (ArrayList<ResearchersData>)researcherObject;

			for (int i = 0; i < res.size(); i++) {
				setUserName(res.get(i).getUsername());
				setPassword(res.get(i).getPassword());
				checked=checkValidity(viewlogin.getUserName().getText(),viewlogin.getPasswordField().getPassword());
				if(checked) break;	
			}
			objectstream.close(); 

		}catch (Exception e) {
		}
		return checked;
	}

	//method to verify the researcher by comparing the username and password with researcher's record
	public boolean checkValidity(String user, char[] pass) {
		String username= getUsername();
		char[] password = getPassword();
		if(username.equals(user))
		{
			if(Arrays.equals(password,pass))
			{
				return true;
			}
			else 
				return false;
		}
		else
			return false;
	}

	//getter and setters for  attributes
	public void setUserName(String username) { 	this.username= username; 	}
	public void setPassword(char[] password) { this.password = password; 	}
	public String getUsername() { 	return this.username; }
	public char[] getPassword() { 	return this.password; }
}

