package model;

import java.io.Serializable;

public class JournalData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//properties
	private String id, articlename, journalName, author, year, volume, issue, page;
	
	public JournalData(String id, String articlename,String journalName,  String author, String year, String volume, String issue, String page )
	{
		this.id=id;
		this.articlename=articlename;
		this.journalName=journalName;
		this.author=author;
		this.year=year;
		this.volume=volume;
		this.issue=issue;
		this.journalName=journalName;
		this.page=page;
	}
	
	public JournalData() {}
	
	//getters
	
	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return articlename;
	}
	public String getauthor()
	{
		return author;
	}
	
	public String getyear()
	{
		return year;
	}
	public String getJournalName()
	{
		return journalName;
	}
	
	public String getVolume()
	{
		return volume;
	}
	
	public String getIssue()
	{
		return issue;
	}
	
	public String getpage()
	{
		return page;
	}

}
