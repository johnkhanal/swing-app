package model;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import view.*;

// for journal information checking and changing
public class ReadJournalModel 
{
	private DefaultTableModel rtablemodel = new DefaultTableModel(0, 9);
	private JTable rtable=new JTable(rtablemodel);
	private JScrollPane scrollpane = new JScrollPane(rtable);
	private ArrayList <JournalData> listofjournal  = new ArrayList<JournalData>();
	JournalData rmodel;
	
	//first checking journal list in file
	@SuppressWarnings("unchecked")
	public  ArrayList<JournalData> readFile()
	{
		ArrayList<JournalData> rlist = null;
		try{
			FileInputStream filepath = new FileInputStream("src/files/journaldata.dat");
			ObjectInputStream filetoobj = new ObjectInputStream(filepath);
			Object obj= filetoobj.readObject();
			rlist = (ArrayList<JournalData>)obj;
			filetoobj.close();
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}
		catch (ClassNotFoundException e){}
		return rlist;
	}
	
	//calling the method to show journal table
	public ReadJournalModel() {}
	
	//adding to file
	public void addRecord(ViewJournalsList review)
	{
		rmodel = new JournalData(review.getNewID().getText(),
				review.getnewName().getText(),
				review.getnewJournalTitle().getText(), 
				review.getnewAuthor().getText(), review.getnewYear().getText(),
				review.getNewVolume().getText(), review.getNewIssue().getText(),review.getnewpage().getText());
		if(readFile()!=null) 
		{ //add to existing file
			listofjournal= readFile();
			listofjournal.add(rmodel);
			objectToFile(); 
			JOptionPane.showMessageDialog(null, "Add Successful"); }
		else 
		{ listofjournal.add(rmodel);
			objectToFile(); 
			JOptionPane.showMessageDialog(null, "Add Successful"); }
	}
	
	//update method
	public void updateData(ViewJournalsList review, int i){
		listofjournal= readFile();
		rmodel = new JournalData(review.getOldID().getText(),
				review.getOldName().getText(),
				review.getOldJournalTitle().getText(), 
				review.getOldAuthor().getText(), review.getOldYear().getText(),
				review.getOldVolume().getText(), review.getOldIssue().getText(),review.getOldPage().getText());
			listofjournal.set(i,rmodel);
			objectToFile();
	}
	
	//delete method
	public void deleteData(int i) throws IOException {
		listofjournal= readFile();
		listofjournal.remove(i);
		if(i>0)
			objectToFile();
			else {
				File file = new File("src/files/journaldata.dat");
				file.delete();
				file.createNewFile();
				 
			}
	}
	
	//write object to file
	public void objectToFile() 
	{
		try 
		{
			File file = new File("src/files/journaldata.dat");
			FileOutputStream filstream = new FileOutputStream(file);
			ObjectOutputStream objstream = new ObjectOutputStream(filstream);
			objstream.writeObject(listofjournal);
			objstream.close();
		}catch (Exception e) { }
	}
	
	//method to display researcher's table
	public void tableResearchers() {	
		//variable for serial no.
		int counter=1;
	if(readFile()!=null) {
		listofjournal =readFile();
		JournalData rob = new JournalData();
		for(int i=0; i<listofjournal.size(); i++)
		{
			rob=listofjournal.get(i);
			Object[] data= {counter,rob.getId(),rob.getName(),rob.getJournalName(),rob.getauthor(), rob.getyear(), rob.getVolume(),rob.getIssue(), rob.getpage()};
			rtablemodel.addRow(data);	
			counter++;
		}}
		Object columnTitle[]= {"Sn","Reg. Id","Article Title","Journal Title","Author","Publication Year","Volume","Issue / Part","Page(s)"};
		rtablemodel.setColumnIdentifiers(columnTitle);
	}
	
	//data of hired articles read to compare if the article is already hired
		public  ArrayList<HireData> readHireData()
		{
			ArrayList<HireData> rlist = null;
			try{
				FileInputStream filepath = new FileInputStream("src/files/hiredata.dat");
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
		
	//for researchers frame
	public void tableOnlyFreeJournal() {
		if(readFile()!=null) {
			int counter=1;
			boolean available =true;
			listofjournal = readFile();
			JournalData rob = new JournalData();
			for(int c=0; c<listofjournal.size(); c++)
			{
				if(readHireData()!=null)
				{
					HireData hd = new HireData();
					for(int i=0; i<readHireData().size(); i++)
					{
						rob=listofjournal.get(c);
						hd=readHireData().get(i);
						if(!rob.getId().equals(hd.getArticleid()))
						{	available = true;
						} else {available = false; break;}
					}
				}
				if(available)
				{
					rob=listofjournal.get(c);
					Object[] data= {counter,rob.getId(),rob.getName(),rob.getJournalName(),rob.getauthor(), rob.getyear(), rob.getVolume(),rob.getIssue(), rob.getpage()};
					rtablemodel.addRow(data);	
					counter++;
				}}}
		Object columnTitle[]= {"Sn","Reg. Id","Article Title","Journal Title","Author","Publication Year","Volume","Issue / Part","Page(s)"};
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
