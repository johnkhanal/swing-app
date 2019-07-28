package model;

import java.io.Serializable;

public class ConferenceData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//properties
	private String id, articlename, author, year, editor, place, page;
	
	public ConferenceData(String id, String articlename, String author, String year, String editor, String place, String page )
	{
		this.id=id;
		this.articlename=articlename;
		this.author=author;
		this.year=year;
		this.editor=editor;
		this.place=place;
		this.page=page;
	}
	
	public ConferenceData() {}
	
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
	public String geteditor()
	{
		return editor;
	}
	
	public String getplace()
	{
		return place;
	}
	
	public String getpage()
	{
		return page;
	}

}
