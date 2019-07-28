package controller;

import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import model.*;
import view.*;
import controller.*;

public class LoginController {
	//login view and models objects
	Login viewobj;
	LoginModel modelobj;

	//constructor
	public LoginController(Login viewobj, LoginModel modelobj)  {   
		this.viewobj=viewobj;
		this.modelobj=modelobj; }

	//method to login 
	public void loginmethod() {
		viewobj.getLoginBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] password= {'a','d','m','i','n'};
				if(viewobj.getUserType().getSelectedItem().toString().equals("Admin"))
				{ 
					if(viewobj.getUserName().getText().equals("admin"))
					{
						if( Arrays.equals(viewobj.getPasswordField().getPassword(),password)){
							viewobj.dispose();
							AdministratorView advw = new AdministratorView();
							advw.setVisible(true);

						}
						//password incorrect message
						else { JOptionPane.showMessageDialog(null, "Invalid password!"); 	}
					}
					else { //wrong user name message
						JOptionPane.showMessageDialog(null, "Invalid username"); }
				}
				//Researcher login
				else {
					if(modelobj.checkResearcher(viewobj)) {
						viewobj.dispose();	
						ResearcherView researcherFrame= new ResearcherView();
						researcherFrame.setVisible(true);
						ReadHireModel sendusername= new ReadHireModel(viewobj.getUserName().getText());
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid username or password");
					}
				}
			}});
	}
}
