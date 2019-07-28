package model;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import view.*;

// for researchers information checking and changing
public class ReadResearcherModel 
{
	private DefaultTableModel rtablemodel = new DefaultTableModel(0, 9);
	private JTable rtable=new JTable(rtablemodel);
	private JScrollPane scrollpane = new JScrollPane(rtable);
	private ArrayList <ResearchersData> listofresearchers  = new ArrayList<ResearchersData>();
	ResearchersData rmodel;
	
	//first checking researchers list in file
	@SuppressWarnings("unchecked")
	public  ArrayList<ResearchersData> readFile()
	{
		ArrayList<ResearchersData> rlist = null;
		try{
			FileInputStream filepath = new FileInputStream("src/files/researcherdata.dat");
			ObjectInputStream filetoobj = new ObjectInputStream(filepath);
			Object obj= filetoobj.readObject();
			rlist = (ArrayList<ResearchersData>)obj;
			filetoobj.close();
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}
		catch (ClassNotFoundException e){}
		return rlist;
	}
	
	//calling the method to show researchers table
	public ReadResearcherModel() { tableResearchers(); }
	
	//adding to file
	public void addRecord(ViewResearchersList review)
	{
		rmodel = new ResearchersData(review.getNewID().getText(),
				review.getnewName().getText(),
				review.getnewContact().getText(), review.getnewAddress().getText(),
				review.getnewEmail().getText(), 
				review.getNewUsername().getText(), review.getNewPassword().getText());
		if(readFile()!=null) 
		{ //add to existing file
			listofresearchers= readFile();
			listofresearchers.add(rmodel);
			objectToFile(); 
			JOptionPane.showMessageDialog(null, "Add Successful"); }
		else 
		{ listofresearchers.add(rmodel);
			objectToFile(); 
			JOptionPane.showMessageDialog(null, "Add Successful"); }
	}
	
	//update method
	public void updateData(ViewResearchersList vrl, int i){
		listofresearchers= readFile();
			rmodel= new ResearchersData(vrl.getOldID().getText(),
					vrl.getOldName().getText(),
					vrl.getOldContact().getText(), vrl.getOldAddress().getText(),
					vrl.getOldEmail().getText(), 
					vrl.getOldUsername().getText(), vrl.getOldPassword().getText());
			listofresearchers.set(i,rmodel);
			objectToFile();
	}
	
	//delete method
	public void deleteData(int i) throws IOException
	{
		listofresearchers= readFile();
		listofresearchers.remove(i);	
		if(i>0)
		objectToFile();
		else {
			File file = new File("src/files/researcherdata.dat");
			file.delete();
			file.createNewFile();
			
		}
	}
	
	//write object to file
	public void objectToFile() 
	{
		try 
		{
			File file = new File("src/files/researcherdata.dat");
			FileOutputStream filestream = new FileOutputStream(file);
			ObjectOutputStream objectstream = new ObjectOutputStream(filestream);
			objectstream.writeObject(listofresearchers);
			objectstream.close();
		}catch (Exception e) { }
	}
	
	//method to display researcher's table
	public void tableResearchers() {	
		//variable for serial no.
		int counter=1;
	if(readFile()!=null) {
		listofresearchers =readFile();
		ResearchersData rob = new ResearchersData();
		for(int i=0; i<listofresearchers.size(); i++)
		{
			rob=listofresearchers.get(i);
			Object[] data= {counter,rob.getId(),rob.getName(),rob.getContact(),rob.getAddress(),rob.getEmail(),rob.getUsername(),rob.getPassword().toString()};
			rtablemodel.addRow(data);	
			counter++;
		}}
		Object columnTitle[]= {"Sn","Reg. Id","Full Name","Contact","Address","Email","Username","Password"};
		rtablemodel.setColumnIdentifiers(columnTitle);
	}
	
	//return scrollpane and table
	
	public JTable getTable() {
		return rtable;
	}
	
	public JScrollPane getScroll() {
		return scrollpane;
	}
	
}
