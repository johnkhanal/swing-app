package model;

import java.io.Serializable;

public class HireData implements Serializable{

	/**
	 * Serializable class of records of researcher id and article id on hire
	 */
	private static final long serialVersionUID = 1L;
	//properties
	private String id, articleid;
	private  String username;
	
	public HireData(String id, String articleid)
	{
		this.id=id;
		this.articleid=articleid;
	}
	
	public HireData() {}
	
	//getters
	
	public String getId()
	{
		return id;
	}
	
	public String getArticleid()
	{
		return articleid;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;	}
}
