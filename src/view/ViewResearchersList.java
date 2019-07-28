package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.*;
import model.*;

public class ViewResearchersList extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField, nameField, contactField, addressField, emailField, usernameField, passwordField, newIdField, newNameField, newContactField, newAddressField, newEdmailField, newusernameField, newPasswordField;
	private JButton btnAdd, btnUpdate, btnDelete;

	//to view table
	private JTable viewTable = new JTable();
	private JScrollPane viewScroll;
	//for  row num
	private int rowcounter;
	//model called to read the list of researchers for auto increment id
	ReadResearcherModel rrmodel= new ReadResearcherModel();
	
	/**
	 * Create the panel.
	 */
	AdministratorView advw;
	ReadResearcherController rrc = new ReadResearcherController(this);
	public ViewResearchersList(AdministratorView advw) {
		this.advw= advw;
		setLayout(null);
		setBounds(5,80,1255,600);
		setBackground(new Color(0,0,0,65));

		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setBounds(5, 5, 820, 585);
		add(panel);
		panel.setLayout(null);

		//title
		JLabel tt= new JLabel("Researchers");
		tt.setBounds(3,3,500,30);
		tt.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		panel.add(tt);
		makeFontwhite(tt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(null);
		panel_1.setBounds(840, 5, 410, 585);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		lblUpdate.setBounds(211, 5,200, 25);
		panel_1.add(lblUpdate);

		JLabel lblIdNo = new JLabel("Id no.");
		lblIdNo.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblIdNo.setBounds(52, 35, 53, 23);
		panel_1.add(lblIdNo);

		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblFullName.setBounds(52, 65, 84, 23);
		panel_1.add(lblFullName);

		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblContact.setBounds(52, 95, 84, 23);
		panel_1.add(lblContact);

		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblAddress.setBounds(52, 125, 84, 23);
		panel_1.add(lblAddress);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblEmail.setBounds(52, 155, 84, 23);
		panel_1.add(lblEmail);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblUsername.setBounds(52, 185, 84, 23);
		panel_1.add(lblUsername);

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblPassword.setBounds(52, 215, 84, 23);
		panel_1.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(133, 35, 257, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(133, 65, 257, 19);
		panel_1.add(nameField);

		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setBounds(133, 95, 257, 19);
		panel_1.add(contactField);

		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(133, 125, 257, 19);
		panel_1.add(addressField);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(133, 155, 257, 19);
		panel_1.add(emailField);

		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(133, 185, 257, 19);
		panel_1.add(usernameField);

		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(133, 215, 257, 19);
		panel_1.add(passwordField);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(133, 245, 85, 21);
		panel_1.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(305, 245, 85, 21);
		panel_1.add(btnDelete);

		JLabel lblAddNewResearcher = new JLabel("Add New Researcher");
		lblAddNewResearcher.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		lblAddNewResearcher.setBounds(155, 295, 207, 25);
		panel_1.add(lblAddNewResearcher);

		JLabel label_1 = new JLabel("Id no.");
		label_1.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_1.setBounds(52, 325, 53, 23);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Full Name:");
		label_2.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_2.setBounds(52, 355, 84, 23);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("Contact: ");
		label_3.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_3.setBounds(52, 385, 84, 23);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("Address: ");
		label_4.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_4.setBounds(52, 415, 84, 23);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("Email:");
		label_5.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_5.setBounds(52, 445, 84, 23);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("Username:");
		label_6.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_6.setBounds(52, 475, 84, 23);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("Password: ");
		label_7.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_7.setBounds(52, 505, 84, 23);
		panel_1.add(label_7);

		newIdField = new JTextField();
		newIdField.setColumns(10);
		newIdField.setBounds(133, 325, 257, 19);
		panel_1.add(newIdField);
		//id 
		newIdField.setEditable(false);
		if(rrmodel.readFile()!=null)
		{
			int subId = Integer.parseInt(rrmodel.readFile().get((rrmodel.readFile().size())-1).getId());
			String newId = String.valueOf(subId+1);
			newIdField.setText(newId);
		}
		else {newIdField.setText("1");}

		newNameField = new JTextField();
		newNameField.setColumns(10);
		newNameField.setBounds(133, 355, 257, 19);
		panel_1.add(newNameField);

		newContactField = new JTextField();
		newContactField.setColumns(10);
		newContactField.setBounds(133, 385, 257, 19);
		panel_1.add(newContactField);

		newAddressField = new JTextField();
		newAddressField.setColumns(10);
		newAddressField.setBounds(133, 415, 257, 19);
		panel_1.add(newAddressField);

		newEdmailField = new JTextField();
		newEdmailField.setColumns(10);
		newEdmailField.setBounds(133, 445, 257, 19);
		panel_1.add(newEdmailField);

		newusernameField = new JTextField();
		newusernameField.setColumns(10);
		newusernameField.setBounds(133, 475, 257, 19);
		panel_1.add(newusernameField);

		newPasswordField = new JTextField();
		newPasswordField.setColumns(10);
		newPasswordField.setBounds(133, 505, 257, 19);
		panel_1.add(newPasswordField);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(227, 540, 85, 21);
		panel_1.add(btnAdd);
		setVisible(true);

		makeFontwhite(lblAddNewResearcher);
		makeFontwhite(lblUpdate);
		makeFontwhite(lblIdNo);
		makeFontwhite(lblFullName);
		makeFontwhite(lblAddress);
		makeFontwhite(lblContact);
		makeFontwhite(lblEmail);
		makeFontwhite(lblUsername);
		makeFontwhite(lblPassword);
		makeFontwhite(label_1);
		makeFontwhite(label_2);
		makeFontwhite(label_3);
		makeFontwhite(label_4);
		makeFontwhite(label_5);
		makeFontwhite(label_6);
		makeFontwhite(label_7);

		//		calling controller
		rrc.addFunction();
		rrc.viewTable();
		rrc.updateSelectedRow();
		rrc.deleterow();
		getScroll().setBounds(3,35,810,520);
		panel.add(getScroll());
		rowField();

	}
	//method to make jlabel's font white
	public void makeFontwhite(JLabel a) {a.setForeground(Color.WHITE);}

	//getters 

	public JTextField getOldID() { 
		return textField;}

	public JTextField getNewID() { 
		return newIdField;}

	public JTextField getOldName() { 
		return nameField;}

	public JTextField getnewName() { 
		return newNameField;}

	public JTextField getOldContact() { 
		return contactField;}

	public JTextField getnewContact() { 
		return newContactField;}

	public JTextField getOldAddress() { 
		return addressField;}

	public JTextField getnewAddress() { 
		return newAddressField;}

	public JTextField getOldEmail() { 
		return emailField;}

	public JTextField getnewEmail() { 
		return newEdmailField;}

	public JTextField getOldUsername() { 
		return usernameField;}

	public JTextField getNewUsername() { 
		return newusernameField;}

	public JTextField getOldPassword() { 
		return passwordField;}

	public JTextField getNewPassword() { 
		return newPasswordField;}

	//btns
	public JButton getAddbtn() { return btnAdd;}
	public JButton getUpdatebtn () 
	{
		return btnUpdate;
	}

	public JButton getDeletebtn()
	{
		return btnDelete;
	}

	//table and scroll pane setter and getter

	public JTable getTable() { return viewTable;}
	public void setTable(JTable rtab) { viewTable = rtab;}
	public JScrollPane getScroll() { return viewScroll;}
	public void setScroll(JScrollPane viewScroll) {this.viewScroll= viewScroll;}

	//to show the panel 
	public void recallPaint() { advw.showResearchersPanel();}

	//show table data in the textfields and help update and delete
	public void rowField()
	{ 
		viewTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				int c;
				String id ,oldname,oladdress,oldcontact,oldemail,oldusername, oldpassword;
				DefaultTableModel viewTablemodel = (DefaultTableModel)viewTable.getModel();
				c=viewTable.getSelectedRow();
				id= viewTablemodel.getValueAt(c, 1).toString();
				oldname= viewTablemodel.getValueAt(c,2).toString();
				oldcontact= viewTablemodel.getValueAt(c,3).toString();
				oladdress= viewTablemodel.getValueAt(c,4).toString();
				oldemail= viewTablemodel.getValueAt(c,5).toString();
				oldusername= viewTablemodel.getValueAt(c,6).toString();
				oldpassword= viewTablemodel.getValueAt(c,7).toString();
				updatePanel(id, oldname, oldcontact, oladdress, oldemail, oldusername, oldpassword);
				setRowCount(viewTable.getSelectedRow());
			}
		});
	}
	//to set the values of update fields 
	public void updatePanel(String id, String name, String contact,  String address, String email, String username, String password)
	{
		this.textField.setText(id);
		this.nameField.setText(name);
		this.addressField.setText(address);
		this.contactField.setText(contact);
		this.emailField.setText(email);
		this.usernameField.setText(username);
		this.passwordField.setText(password);
	}

	//for row number selector
	public int getRowCount() 
	{ return rowcounter; }
	public void setRowCount(int n)
	{rowcounter= n;}

}
