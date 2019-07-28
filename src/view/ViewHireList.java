package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ReadHireController;
import model.*;

public class ViewHireList extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField resercherIdField, articleIDField, articleNameField, usernameField, newIdField, newArticleId;
	private JButton btnAdd, btnUpdate, btnDelete;

	//to view table
	private JTable viewTable = new JTable();
	private JScrollPane viewScroll;
	//for  row num
	private int rowcounter;
	/**
	 * Create the panel.
	 */
	AdministratorView advw;
	ResearcherView researcherView;
	ReadHireController rrc = new ReadHireController(this);
	public ViewHireList(AdministratorView advw) {
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
		JLabel tt= new JLabel("Articles on Hire");
		tt.setBounds(3,3,500,30);
		tt.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		panel.add(tt);
		makeFontwhite(tt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(null);
		panel_1.setBounds(840, 5, 410, 585);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblUpdate = new JLabel("Update ");
		lblUpdate.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		lblUpdate.setBounds(211, 5, 200, 25);
		panel_1.add(lblUpdate);

		JLabel lblIdNo = new JLabel("Researcher Id:");
		lblIdNo.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblIdNo.setBounds(25, 35, 100, 23);
		panel_1.add(lblIdNo);

		JLabel lblFullName = new JLabel("Username:");
		lblFullName.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblFullName.setBounds(52, 65, 84, 23);
		panel_1.add(lblFullName);

		JLabel lblContact = new JLabel("Article Id: ");
		lblContact.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblContact.setBounds(52, 95, 84, 23);
		panel_1.add(lblContact);

		resercherIdField = new JTextField();
		resercherIdField.setBounds(133, 35, 257, 19);
		panel_1.add(resercherIdField);
		resercherIdField.setColumns(10);
		resercherIdField.setEditable(false);

		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(133, 65, 257, 19);
		panel_1.add(usernameField);
		usernameField.setEditable(false);

		articleIDField = new JTextField();
		articleIDField.setColumns(10);
		articleIDField.setBounds(133, 95, 257, 19);
		panel_1.add(articleIDField);
		articleIDField.setEditable(false);

		btnDelete = new JButton("Return");
		btnDelete.setBounds(305, 155, 85, 21);
		panel_1.add(btnDelete);

		JLabel lblAddNewResearcher = new JLabel("Hire Articles");
		lblAddNewResearcher.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		lblAddNewResearcher.setBounds(155, 200, 207, 25);
		panel_1.add(lblAddNewResearcher);

		JLabel label_2 =new JLabel("Researcher Id:");
		label_2.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_2.setBounds(25, 240, 100, 23);
		panel_1.add(label_2);



		JLabel label_6 =new JLabel("Article Id: ");
		label_6.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_6.setBounds(52, 280, 84, 23);
		panel_1.add(label_6);


		newIdField = new JTextField();
		newIdField.setColumns(10);
		newIdField.setBounds(133, 240, 257, 19);
		panel_1.add(newIdField);

		newArticleId = new JTextField();
		newArticleId.setColumns(10);
		newArticleId.setBounds(133, 280, 257, 19);
		panel_1.add(newArticleId);

		btnAdd = new JButton("Hire");
		btnAdd.setBounds(305, 340, 85, 21);
		panel_1.add(btnAdd);
		setVisible(true);

		makeFontwhite(lblAddNewResearcher);
		makeFontwhite(lblUpdate);
		makeFontwhite(lblIdNo);
		makeFontwhite(lblFullName);
		makeFontwhite(lblContact);
		makeFontwhite(label_2);
		makeFontwhite(label_6);

		//		calling controller
		rrc.addFunction();
		rrc.viewTable();
		rrc.deleterow();
		getScroll().setBounds(3,35,810,520);
		panel.add(getScroll());
		rowField();
		
		disableTextfields(resercherIdField);
		disableTextfields(usernameField);
		disableTextfields(articleIDField);

	}
	
	//constructor for researchers frame
	public ViewHireList(ResearcherView rvw) {
		researcherView=rvw;
		setLayout(null);
		setBounds(5,80,1255,600);
		setBackground(new Color(0,0,0,65));

		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setBounds(5, 5, 1250, 585);
		add(panel);
		panel.setLayout(null);

		//calling controller
		rrc.showTabletoResearcher();
		getScroll().setBounds(350,35,500,520);
		panel.add(getScroll());
	}
	//method to make jlabel's font white
	public void makeFontwhite(JLabel a) {a.setForeground(Color.WHITE);}
	//disabling tfd
	public void disableTextfields(JTextField a) {a.setEditable(false);}

	//getters 

	public JTextField getOldID() { 
		return resercherIdField;}

	public JTextField getNewID() { 
		return newIdField;}

	public JTextField getoldarticleid() { 
		return articleIDField;}
	
	public JTextField getNewarticleid() { 
		return newArticleId;}


	public JTextField getarticlename() { 
		return articleNameField;}


	public JTextField getusername() { 
		return usernameField;}


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

	public void recallPaint() { advw.showHires();}

	//show table data in the textfields and help update and delete
	public void rowField()
	{ 
		viewTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				int c;
				String id ,articleid,username;
				DefaultTableModel viewTablemodel = (DefaultTableModel)viewTable.getModel();
				c=viewTable.getSelectedRow();
				id= viewTablemodel.getValueAt(c, 1).toString();
				articleid= viewTablemodel.getValueAt(c,3).toString();
				username=viewTablemodel.getValueAt(c,2).toString();
				updatePanel(id,username, articleid);
				setRowCount(viewTable.getSelectedRow());
			}
		});
	}
	//to set the values of update fields 
	public void updatePanel(String id, String username, String articleid)
	{
		this.resercherIdField.setText(id);
		this.usernameField.setText(username);
		this.articleIDField.setText(articleid);
	}

	//for row number selector
	public int getRowCount() 
	{ return rowcounter; }
	public void setRowCount(int n)
	{rowcounter= n;}

}
