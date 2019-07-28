package controller;
import view.*;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import model.*;

// for the researcher panel opened  by admin
public class ReadResearcherController {
	ViewResearchersList viewResearcher;
	ReadResearcherModel rmodel;

	public ReadResearcherController(ViewResearchersList viewResearcher)
	{
		this.viewResearcher= viewResearcher;
	}

	//add or update functions
	public void addFunction()
	{
		viewResearcher.getAddbtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(
						viewResearcher.getnewAddress().getText().isEmpty() || viewResearcher.getnewContact().getText().isEmpty()|| viewResearcher.getnewEmail().getText().isEmpty()|| viewResearcher.getNewUsername().getText().isEmpty()||viewResearcher.getNewPassword().getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter required information");
				}
				else {
					rmodel= new ReadResearcherModel();
					rmodel.addRecord(viewResearcher);
					viewResearcher.recallPaint();
				}
			}
		});
	}
	//method to view table
	public void viewTable() {
		rmodel= new ReadResearcherModel();
		JScrollPane var = rmodel.getScroll();
		viewResearcher.setTable(rmodel.getTable());
		viewResearcher.setScroll(var);}
	
	//method to update the row
	public void updateSelectedRow() { 
		viewResearcher.getUpdatebtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rmodel = new ReadResearcherModel();
				if(viewResearcher.getOldID().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error");
				}else {
						rmodel.updateData(viewResearcher,viewResearcher.getRowCount());
						JOptionPane.showMessageDialog(null, "Updated");
					viewResearcher.recallPaint();
				}
			}
		});
	}
	
	//to delete
	public void deleterow()
	{
		viewResearcher.getDeletebtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(viewResearcher.getOldID().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error");
				}else {
					int opt = JOptionPane.showConfirmDialog(null, "Confirm Delete?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (opt == JOptionPane.YES_OPTION) {
				try {
					rmodel.deleteData(viewResearcher.getRowCount());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				viewResearcher.recallPaint();}
				
			}}
		});
	}

}
