package model;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import view.*;

// for hires information checking and returning
public class ReadHireModel 
{
	private DefaultTableModel rtablemodel = new DefaultTableModel(0, 4);
	private JTable rtable=new JTable(rtablemodel);
	private JScrollPane scrollpane = new JScrollPane(rtable);
	private ArrayList <HireData> listofresearchers  = new ArrayList<HireData>();
	HireData rmodel;
	ReadResearcherModel remodel = new ReadResearcherModel();
	//variable for recording currently logged in username
	private static String currentResearcher;
	//constructor created to set username value
	public ReadHireModel(String a) { currentResearcher= a;}
	public String getCurrentResearcher() { return currentResearcher;}
	
	//empty constructor
	public ReadHireModel() { }
	
	//first checking hires list in file
	@SuppressWarnings("unchecked")
	public  ArrayList<HireData> readFile()
	{
		ArrayList<HireData> rlist = null;
		try{
			FileInputStream filepath = new FileInputStream("src/files/hires.dat");
			ObjectInputStream filetoobj = new ObjectInputStream(filepath);
			Object obj= filetoobj.readObject();
			rlist = (ArrayList<HireData>)obj;
			filetoobj.close();
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}
		catch (ClassNotFoundException e){}
		return rlist;
	}

	//adding hires to file
	public void addRecord(ViewHireList review)
	{
		boolean validid= false;
		String id=review.getNewID().getText();
		rmodel = new HireData(review.getNewID().getText(), review.getNewarticleid().getText());
		boolean onhire = false;
			if(readFile()!=null) {
				listofresearchers=readFile();
				for(int i=0; i<readFile().size();i++)
				{
					//not hiring already hired articles
					if(readFile().get(i).getArticleid().equals(review.getNewarticleid().getText())) {
						JOptionPane.showMessageDialog(null, "Article already hired!");
						onhire = true;
						break;}
					}
				}	
			if(onhire==false) 
			{
				if(remodel.readFile()==null)
				{
					JOptionPane.showMessageDialog(null, "NO RESEARCHER FOUND!");
				}
				else
				{
				for(int i=0; i<remodel.readFile().size();i++)
				{
					if(remodel.readFile().get(i).getId().equals(id)) {
						rmodel.setUsername(remodel.readFile().get(i).getUsername());
						System.out.println(remodel.readFile().get(i).getUsername());
						listofresearchers.add(rmodel);
						objectToFile(); 
						JOptionPane.showMessageDialog(null, "Article hired.");
						validid=true;
						break;
					}
					
				}
				if(validid==false)
				{
					JOptionPane.showMessageDialog(null, "Enter valid researcher id.");
				}
				
				}
				
			}

		}


	//return method
	public void deleteData(int i) throws IOException {
		listofresearchers= readFile();
		listofresearchers.remove(i);
		if(i>0)
			objectToFile();
			else {
				File file = new File("src/files/hires.dat");
				file.delete();
				file.createNewFile();
				
				
			}
	}

	//write object to file
	public void objectToFile() 
	{
		try 
		{
			File file = new File("src/files/hires.dat");
			FileOutputStream filestream = new FileOutputStream(file);
			ObjectOutputStream objstream = new ObjectOutputStream(filestream);
			objstream.writeObject(listofresearchers);
			objstream.close();
		}catch (Exception e) { }
	}

	//method to display  table
	public void tableResearchers() {	
		//variable for serial no.
		int counter=1;
		if(readFile()!=null) {
			listofresearchers =readFile();
			HireData rob = new HireData();
			for(int i=0; i<listofresearchers.size(); i++)
			{
				rob=listofresearchers.get(i);
				Object[] data= {counter,rob.getId(),rob.getUsername(),rob.getArticleid()};
				rtablemodel.addRow(data);	
				counter++;
			}}
		Object columnTitle[]= {"Sn","Researcher ID","Username","Article ID"};
		rtablemodel.setColumnIdentifiers(columnTitle);
	}
	
	//method to display current researcher's articles only
	public void showtableToResearchers() {	
		//variable for serial no.
		int counter=1;
		if(readFile()!=null) {
			listofresearchers =readFile();
			HireData rob = new HireData();
			for(int i=0; i<listofresearchers.size(); i++)
			{
				rob=listofresearchers.get(i);
				if(rob.getUsername().equals(getCurrentResearcher())) {
					Object[] data= {counter,rob.getArticleid()};
					rtablemodel.addRow(data);	
					counter++;
				}}
				
			}
		Object columnTitle[]= {"Sn","Article ID"};
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
