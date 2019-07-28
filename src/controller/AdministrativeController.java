package controller;
 import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
public class AdministrativeController 
{
	AdministratorView mainview;
	
	//
	public AdministrativeController(AdministratorView vw) {
		this.mainview= vw;
	}
	
	//admin functions
	public void adminFunctions()
	{
		//logout
		mainview.getlogout().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainview.dispose();
				Login newlogin = new Login();
				LoginModel newmodel  = new LoginModel();
				LoginController newcontroller = new LoginController(newlogin, newmodel);
				newcontroller.loginmethod();
			}
		});
		//show researchers panel
		mainview.getResearcher().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				mainview.showResearchersPanel();} });
		//show journal panel
		mainview.getJournal().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				mainview.showJournalPanel();} });
		//show book chapters panel
		mainview.getBook().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				mainview.showBooks();} });
		//show conference articles panel
		mainview.getConference().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				mainview.showConference();} });
		//show hires panel
		mainview.getHires().addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				mainview.showHires();} });
	}
}
