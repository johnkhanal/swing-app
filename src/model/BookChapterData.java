package model;

import java.io.Serializable;

public class BookChapterData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//properties
	private String id, articlename, author, year, editor, place, publisher, page;
	
	public BookChapterData(String id, String articlename, String author, String year, String editor, String place, String publisher, String page )
	{
		this.id=id;
		this.articlename=articlename;
		this.author=author;
		this.year=year;
		this.editor=editor;
		this.place=place;
		this.publisher=publisher;
		this.page=page;
	}
	
	public BookChapterData() {}
	
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
	
	public String getpublisher()
	{
		return publisher;
	}
	
	public String getpage()
	{
		return page;
	}
}
