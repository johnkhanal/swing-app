package controller;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import model.*;
import view.*;

public class ReadHireController  {
	ViewHireList viewResearcher;
	ReadHireModel rmodel;

	public ReadHireController(ViewHireList viewResearcher)
	{
		this.viewResearcher= viewResearcher;
	}

	//add or update functions
	public void addFunction()
	{
		viewResearcher.getAddbtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(
						viewResearcher.getNewID().getText().isEmpty() || viewResearcher.getNewarticleid().getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Enter id.");
				}
				else {
					rmodel= new ReadHireModel();
					rmodel.addRecord(viewResearcher);
					viewResearcher.recallPaint();
				}
			}
		});
	}
	//method to view table
	public void viewTable() {
		rmodel= new ReadHireModel();
		rmodel.tableResearchers();
		JScrollPane var = rmodel.getScroll();
		viewResearcher.setTable(rmodel.getTable());
		viewResearcher.setScroll(var);}
	
	//for resercher's frame
	public void showTabletoResearcher()
	{
		rmodel= new ReadHireModel();
		rmodel.showtableToResearchers();
		JScrollPane var = rmodel.getScroll();
		viewResearcher.setTable(rmodel.getTable());
		viewResearcher.setScroll(var);
	}
	
	//to delete
	public void deleterow()
	{
		viewResearcher.getDeletebtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(viewResearcher.getoldarticleid().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error");
				}else {
					int opt = JOptionPane.showConfirmDialog(null, "Are you sure to return?", "Confirm",
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
