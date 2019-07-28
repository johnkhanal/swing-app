package model;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import view.*;

// for bookdata information checking and changing
public class ReadBookModel 
{
	private DefaultTableModel rtablemodel = new DefaultTableModel(0, 9);
	private JTable rtable=new JTable(rtablemodel);
	private JScrollPane scrollpane = new JScrollPane(rtable);
	private ArrayList <BookChapterData> listofbookdata  = new ArrayList<BookChapterData>();
	BookChapterData rmodel;

	//first checking bookdata list in file
	@SuppressWarnings("unchecked")
	public  ArrayList<BookChapterData> readFile()
	{
		ArrayList<BookChapterData> rlist = null;
		try{
			FileInputStream filepath = new FileInputStream("src/files/bookdata.dat");
			ObjectInputStream filetoobj = new ObjectInputStream(filepath);
			Object obj= filetoobj.readObject();
			rlist = (ArrayList<BookChapterData>)obj;
			filetoobj.close();
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}
		catch (ClassNotFoundException e){}
		return rlist;
	}

	public ReadBookModel() {}

	//adding to file
	public void addRecord(ViewBookChaptersList review)
	{
		rmodel = new BookChapterData(review.getNewID().getText(),
				review.getnewName().getText(),
				review.getnewAuthor().getText(), review.getnewYear().getText(),
				review.getnewEditor().getText(), review.getNewPlace().getText(),review.getNewPublisher().getText(),review.getnewpage().getText());
		if(readFile()!=null) 
		{ //add to existing file
			listofbookdata= readFile();
			listofbookdata.add(rmodel);
			objectToFile(); 
			JOptionPane.showMessageDialog(null, "Add Successful"); }
		else 
		{ listofbookdata.add(rmodel);
		objectToFile(); 
		JOptionPane.showMessageDialog(null, "Add Successful"); }
	}

	//update method
	public void updateData(ViewBookChaptersList review, int i){
		listofbookdata= readFile();
		rmodel = new BookChapterData(review.getOldID().getText(),
				review.getOldName().getText(),
				review.getOldAuthor().getText(), review.getOldYear().getText(),
				review.getOldEditor().getText(), review.getOldPlace().getText(),review.getOldPublisher().getText(),review.getOldPage().getText());
		listofbookdata.set(i,rmodel);
		objectToFile();
	}

	//delete method
	public void deleteData(int i) throws IOException {
		listofbookdata= readFile();
		listofbookdata.remove(i);
		if(i>0)
			objectToFile();
		else {
			File file = new File("src/files/bookdata.dat");
			file.delete();
			file.createNewFile();
		}
	}

	//write object to file
	public void objectToFile() 
	{
		try 
		{
			File file = new File("src/files/bookdata.dat");
			FileOutputStream filestream = new FileOutputStream(file);
			ObjectOutputStream objectstream = new ObjectOutputStream(filestream);
			objectstream.writeObject(listofbookdata);
			objectstream.close();
		}catch (Exception e) { }
	}

	//method to display researcher's table
	public void tableResearchers() {	
		//variable for serial no.
		int counter=1;
		if(readFile()!=null) {
			listofbookdata =readFile();
			BookChapterData rob = new BookChapterData();
			for(int i=0; i<listofbookdata.size(); i++)
			{
				rob=listofbookdata.get(i);
				Object[] data= {counter,rob.getId(),rob.getName(), rob.geteditor(),rob.getauthor(), rob.getyear(),rob.getplace(),rob.getpublisher(), rob.getpage()};
				rtablemodel.addRow(data);	
				counter++;
			}}
		Object columnTitle[]= {"Sn","Reg. Id","Article Title","Editor","Author","Publication Year","Publication Place","Publisher","Page(s)"};
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
	public void tableAvailableBook() {
		if(readFile()!=null) {
			int counter=1;
			boolean available =true;
			listofbookdata = readFile();
			BookChapterData rob = new BookChapterData();
			for(int c=0; c<listofbookdata.size(); c++)
			{
				if(readHireData()!=null)
				{
					HireData hd = new HireData();
					for(int i=0; i<readHireData().size(); i++)
					{
						rob=listofbookdata.get(c);
						hd=readHireData().get(i);
						if(!rob.getId().equals(hd.getArticleid()))
						{	available = true;
						} else {available = false; break;}
					}
				}
				if(available)
				{
					rob=listofbookdata.get(c);
					Object[] data= {counter,rob.getId(),rob.getName(), rob.geteditor(),rob.getauthor(), rob.getyear(),rob.getplace(),rob.getpublisher(), rob.getpage()};
					rtablemodel.addRow(data);	
					counter++;
				}}}
		Object columnTitle[]= {"Sn","Reg. Id","Article Title","Editor","Author","Publication Year","Publication Place","Publisher","Page(s)"};
		rtablemodel.setColumnIdentifiers(columnTitle);
	}


}
