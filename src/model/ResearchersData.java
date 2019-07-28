package model;

import java.io.Serializable;

// serializable class of researchers
public class ResearchersData implements Serializable {
	private static final long serialVersionUID = 1L;
	//researcher's properties
	private String id, name, contact,address, email, username, password;
	
	//constructor
	public ResearchersData() {}
	public ResearchersData(String id,String name,String contact,String address,String  email,String username,String password)
	{
		this.id= id;
		this.name=name;
		this.contact=contact;
		this.address=address;
		this.email= email;
		this.username=username;
		this.password=password;
	}
	
	//getters
	public String getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	
	public String getContact()
	{
		return contact;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getEmail()
	{
		return email;
	}
	public String getUsername()
	{
		return username;
	}
	
	public char[] getPassword()
	{
		return password.toCharArray();
	}
}
