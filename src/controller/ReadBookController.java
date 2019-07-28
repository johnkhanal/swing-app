package controller;
import view.*;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import model.*;

// for the researcher panel opened  by admin
public class ReadBookController {
	ViewBookChaptersList viewResearcher;
	ReadBookModel rmodel;

	public ReadBookController(ViewBookChaptersList viewResearcher)
	{
		this.viewResearcher= viewResearcher;
	}
	

	//add or update functions
	public void addFunction()
	{
		viewResearcher.getAddbtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(
						viewResearcher.getnewName().getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Enter required information");
				}
				else {
					rmodel= new ReadBookModel();
					rmodel.addRecord(viewResearcher);
					viewResearcher.recallPaint();
				}
			}
		});
	}
	//method to view table
	public void viewTable() {
		rmodel= new ReadBookModel();
		rmodel.tableResearchers();
		JScrollPane var = rmodel.getScroll();
		viewResearcher.setTable(rmodel.getTable());
		viewResearcher.setScroll(var);}
	
	//method to view table to researcher
	public void viewResearcherTable() {
		rmodel= new ReadBookModel();
		rmodel.tableAvailableBook();
		JScrollPane var = rmodel.getScroll();
		viewResearcher.setTable(rmodel.getTable());
		viewResearcher.setScroll(var);}
	
	
	//method to update the row
	public void updateSelectedRow() { 
		viewResearcher.getUpdatebtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				rmodel = new ReadBookModel();
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				viewResearcher.recallPaint();}
				
			}}
		});
	}

}
