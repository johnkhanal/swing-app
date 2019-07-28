package model;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import view.*;

// for conferencedata information checking and changing
public class ReadConferenceModel 
{
	private DefaultTableModel rtablemodel = new DefaultTableModel(0, 9);
	private JTable rtable=new JTable(rtablemodel);
	private JScrollPane scrollpane = new JScrollPane(rtable);
	private ArrayList <ConferenceData> listofconferencedata  = new ArrayList<ConferenceData>();
	ConferenceData rmodel;

	//first checking conferencedata list in file
	@SuppressWarnings("unchecked")
	public  ArrayList<ConferenceData> readFile()
	{
		ArrayList<ConferenceData> rlist = null;
		try{
			FileInputStream filepath = new FileInputStream("src/files/conferencedata.dat");
			ObjectInputStream filetoobj = new ObjectInputStream(filepath);
			Object obj= filetoobj.readObject();
			rlist = (ArrayList<ConferenceData>)obj;
			filetoobj.close();
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}
		catch (ClassNotFoundException e){}
		return rlist;
	}

	//calling the method to show conferencedata table
	public ReadConferenceModel() { }

	//adding to file
	public void addRecord(ViewConferenceList review)
	{
		rmodel = new ConferenceData(review.getNewID().getText(),
				review.getnewName().getText(),
				review.getnewAuthor().getText(), review.getnewYear().getText(),
				review.getnewEditor().getText(), review.getNewPlace().getText(),review.getNewPublisher().getText());
		if(readFile()!=null) 
		{ //add to existing file
			listofconferencedata= readFile();
			listofconferencedata.add(rmodel);
			objectToFile(); 
			JOptionPane.showMessageDialog(null, "Add Successful"); }
		else 
		{ listofconferencedata.add(rmodel);
		objectToFile(); 
		JOptionPane.showMessageDialog(null, "Add Successful"); }
	}

	//update method
	public void updateData(ViewConferenceList review, int i){
		listofconferencedata= readFile();
		rmodel = new ConferenceData(review.getOldID().getText(),
				review.getOldName().getText(),
				review.getOldAuthor().getText(), review.getOldYear().getText(),
				review.getOldEditor().getText(), review.getOldPlace().getText(),review.getOldPublisher().getText());
		listofconferencedata.set(i,rmodel);
		objectToFile();
	}

	//delete method
	public void deleteData(int i) throws IOException {
		listofconferencedata= readFile();
		listofconferencedata.remove(i);
		if(i>0)
			objectToFile();
			else {
				File file = new File("src/files/conferencedata.dat");
				file.delete();
				  file.createNewFile();
				 
				
			}
	}

	//write object to file
	public void objectToFile() 
	{
		try 
		
		{
			File file = new File("src/files/conferencedata.dat");
			FileOutputStream filestream = new FileOutputStream(file);
			ObjectOutputStream objectstream = new ObjectOutputStream(filestream);
			objectstream.writeObject(listofconferencedata);
			objectstream.close();
	
		}catch (Exception e) { }
	}

	//method to display researcher's table
	public void tableResearchers() {	
		//variable for serial no.
		int counter=1;
		if(readFile()!=null) {
			listofconferencedata =readFile();
			ConferenceData rob = new ConferenceData();
			for(int i=0; i<listofconferencedata.size(); i++)
			{
				rob=listofconferencedata.get(i);
				Object[] data= {counter,rob.getId(),rob.getName(),rob.getauthor(), rob.getyear(), rob.geteditor(),rob.getplace(),rob.getpage()};
				rtablemodel.addRow(data);	
				counter++;
			}}
		Object columnTitle[]= {"Sn","Reg. Id","Article Title","Author","Publication Year","Editor","Location","Page(s)"};
		rtablemodel.setColumnIdentifiers(columnTitle);
	}

	//return scrollpane and table

	public JTable getTable() {
		return rtable;
	}

	public JScrollPane getScroll() {
		return scrollpane;
	}

	//data of hired articles read to compare if the article is already hired
	@SuppressWarnings("unchecked")
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
	public void tableAvailableConference() {
		if(readFile()!=null) {
			int counter=1;
			boolean available =true;
			listofconferencedata = readFile();
			ConferenceData rob = new ConferenceData();
			for(int c=0; c<listofconferencedata.size(); c++)
			{
				if(readHireData()!=null)
				{
					HireData hd = new HireData();
					for(int i=0; i<readHireData().size(); i++)
					{
						rob=listofconferencedata.get(c);
						hd=readHireData().get(i);
						if(!rob.getId().equals(hd.getArticleid()))
						{	available = true;
						} else {available = false; break;}
					}
				}
				if(available)
				{
					rob=listofconferencedata.get(c);
					Object[] data= {counter,rob.getId(),rob.getName(),rob.getauthor(), rob.getyear(),rob.geteditor(), rob.getplace(),rob.getpage()};
					rtablemodel.addRow(data);	
					counter++;
				}}}
		Object columnTitle[]= {"Sn","Reg. Id","Article Title","Author","Publication Year","Editor","Location","Page(s)"};
		rtablemodel.setColumnIdentifiers(columnTitle);
	}

}
