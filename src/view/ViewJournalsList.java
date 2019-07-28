package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import controller.*;
import model.*;

public class ViewJournalsList extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField, nameField, journalTitleField, authorField, yearField, volumeField, issueField, pageField,newIdField, newNameField, newJournalTitleField, newAuthorField, newYearField, newvolumeField, newIssueField, newPageField;
	private JButton btnAdd, btnUpdate, btnDelete;

	private JTable viewTable = new JTable();
	private JScrollPane viewScroll;
	//for  row num
	private int rowcounter;

	//model called to read the list of researchers for auto increment id
	ReadJournalModel rrmodel= new ReadJournalModel();
	/**
	 * Create the panel.
	 */
	AdministratorView advw;
	ReadJournalController rrc;

	ResearcherView researchview;

	public ViewJournalsList(AdministratorView advw) {
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
		JLabel tt= new JLabel("Journal Articles");
		tt.setBounds(3,3,500,30);
		tt.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		panel.add(tt);
		makeFontwhite(tt);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(null);
		panel_1.setBounds(835, 5, 410, 585);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblUpdate = new JLabel("Update ");
		lblUpdate.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		lblUpdate.setBounds(211, 5, 200, 25);
		panel_1.add(lblUpdate);

		JLabel lblIdNo = new JLabel("Id no.");
		lblIdNo.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblIdNo.setBounds(25, 30, 53, 23);
		panel_1.add(lblIdNo);

		JLabel lblFullName = new JLabel("Article Name:");
		lblFullName.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblFullName.setBounds(25, 60, 100, 23);
		panel_1.add(lblFullName);

		JLabel lblJournaltitle = new JLabel("Journal Title: ");
		lblJournaltitle.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblJournaltitle.setBounds(25, 90, 100, 23);
		panel_1.add(lblJournaltitle);

		JLabel lblAddress = new JLabel("Author:  ");
		lblAddress.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblAddress.setBounds(25, 120, 100, 23);
		panel_1.add(lblAddress);

		JLabel lblEmail = new JLabel("Publisher Year:");
		lblEmail.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblEmail.setBounds(25, 150, 100, 23);
		panel_1.add(lblEmail);

		JLabel lblUsername = new JLabel("Volume: ");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblUsername.setBounds(25, 180, 100, 23);
		panel_1.add(lblUsername);

		JLabel lblPassword = new JLabel("Issue no.: ");
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblPassword.setBounds(25, 210, 100, 23);
		panel_1.add(lblPassword);

		JLabel lblpage = new JLabel("Page no.: ");
		lblpage.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblpage.setBounds(25, 240, 100, 23);
		panel_1.add(lblpage);

		textField = new JTextField();
		textField.setBounds(133, 30, 257, 19);
		panel_1.add(textField);
		textField.setColumns(10);

		textField.setEditable(false);
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(133, 60, 257, 19);
		panel_1.add(nameField);

		journalTitleField = new JTextField();
		journalTitleField.setColumns(10);
		journalTitleField.setBounds(133, 90, 257, 19);
		panel_1.add(journalTitleField);

		authorField = new JTextField();
		authorField.setColumns(10);
		authorField.setBounds(133, 120, 257, 19);
		panel_1.add(authorField);

		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(133, 150, 257, 19);
		panel_1.add(yearField);

		volumeField = new JTextField();
		volumeField.setColumns(10);
		volumeField.setBounds(133, 180, 257, 19);
		panel_1.add(volumeField);

		issueField = new JTextField();
		issueField.setColumns(10);
		issueField.setBounds(133, 210, 257, 19);
		panel_1.add(issueField);

		pageField = new JTextField();
		pageField.setColumns(10);
		pageField.setBounds(133, 240, 257, 19);
		panel_1.add(pageField);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(133, 260, 85, 21);
		panel_1.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(305, 260, 85, 21);
		panel_1.add(btnDelete);

		JLabel lblAddNewResearcher = new JLabel("Add New");
		lblAddNewResearcher.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		lblAddNewResearcher.setBounds(225, 290, 220, 25);
		panel_1.add(lblAddNewResearcher);

		JLabel label_1 = new JLabel("Id no.");
		label_1.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_1.setBounds(25, 320, 10053, 23);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("Article Name:");
		label_2.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_2.setBounds(25, 350, 100, 23);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("Journal Title: ");
		label_3.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_3.setBounds(25, 380, 100, 23);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("Author:  ");
		label_4.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_4.setBounds(25, 410, 100, 23);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("Publisher Year:");
		label_5.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_5.setBounds(25, 440, 100, 23);
		panel_1.add(label_5);

		JLabel label_6 = new JLabel("Volume: ");
		label_6.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_6.setBounds(25, 470, 100, 23);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("Issue no.: ");
		label_7.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_7.setBounds(25, 500, 100, 23);
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("Page no.: ");
		label_8.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_8.setBounds(25, 530, 100, 23);
		panel_1.add(label_8);

		newIdField = new JTextField();
		newIdField.setColumns(10);
		newIdField.setBounds(133, 320, 257, 19);
		panel_1.add(newIdField);
		//id 
		newIdField.setEditable(false);
		if(rrmodel.readFile()!=null)
		{
			int subId = Integer.parseInt(rrmodel.readFile().get(rrmodel.readFile().size()-1).getId());
			String newId = String.valueOf(subId+1);
			newIdField.setText(newId);
		}
		else {newIdField.setText("2000");}

		newNameField = new JTextField();
		newNameField.setColumns(10);
		newNameField.setBounds(133, 350, 257, 19);
		panel_1.add(newNameField);

		newJournalTitleField = new JTextField();
		newJournalTitleField.setColumns(10);
		newJournalTitleField.setBounds(133, 380, 257, 19);
		panel_1.add(newJournalTitleField);

		newAuthorField = new JTextField();
		newAuthorField.setColumns(10);
		newAuthorField.setBounds(133, 410, 257, 19);
		panel_1.add(newAuthorField);

		newYearField = new JTextField();
		newYearField.setColumns(10);
		newYearField.setBounds(133, 440, 257, 19);
		panel_1.add(newYearField);

		newvolumeField = new JTextField();
		newvolumeField.setColumns(10);
		newvolumeField.setBounds(133, 470, 257, 19);
		panel_1.add(newvolumeField);

		newIssueField = new JTextField();
		newIssueField.setColumns(10);
		newIssueField.setBounds(133, 500, 257, 19);
		panel_1.add(newIssueField);

		newPageField = new JTextField();
		newPageField.setColumns(10);
		newPageField.setBounds(133, 530, 257, 19);
		panel_1.add(newPageField);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(227, 560, 85, 21);
		panel_1.add(btnAdd);
		setVisible(true);

		makeFontwhite(lblAddNewResearcher);
		makeFontwhite(lblUpdate);
		makeFontwhite(lblIdNo);
		makeFontwhite(lblFullName);
		makeFontwhite(lblAddress);
		makeFontwhite(lblJournaltitle);
		makeFontwhite(lblEmail);
		makeFontwhite(lblUsername);
		makeFontwhite(lblPassword);
		makeFontwhite(lblpage);

		makeFontwhite(label_1);
		makeFontwhite(label_2);
		makeFontwhite(label_3);
		makeFontwhite(label_4);
		makeFontwhite(label_5);
		makeFontwhite(label_6);
		makeFontwhite(label_7);
		makeFontwhite(label_8);

		//		calling controller
		rrc= new ReadJournalController(this);
		//adding new
		rrc.addFunction();
		//		deleting method from controller
		rrc.deleterow();
		// editing from the controller

		rrc.updateSelectedRow();
		//		setting table 
		rrc.viewTable();
		getScroll().setBounds(3,35,810,520);
		panel.add(getScroll());
		//ro selector of the table
		rowField();

	}

	//for researcher's frame
	public ViewJournalsList(ResearcherView rw) {
		this.researchview= rw;
		setLayout(null);
		setBounds(5,80,1255,600);
		setBackground(new Color(0,0,0,65));

		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setBounds(5, 5, 820, 585);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(null);
		panel_1.setBounds(835, 5, 410, 585);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblUpdate = new JLabel("Details ");
		lblUpdate.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		lblUpdate.setBounds(211, 5, 68, 25);
		panel_1.add(lblUpdate);

		JLabel lblIdNo = new JLabel("Id no.");
		lblIdNo.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblIdNo.setBounds(25, 30, 53, 23);
		panel_1.add(lblIdNo);

		JLabel lblFullName = new JLabel("Article Name:");
		lblFullName.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblFullName.setBounds(25, 60, 100, 23);
		panel_1.add(lblFullName);

		JLabel lblJournaltitle = new JLabel("Journal Title: ");
		lblJournaltitle.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblJournaltitle.setBounds(25, 90, 100, 23);
		panel_1.add(lblJournaltitle);

		JLabel lblAddress = new JLabel("Author:  ");
		lblAddress.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblAddress.setBounds(25, 120, 100, 23);
		panel_1.add(lblAddress);

		JLabel lblEmail = new JLabel("Publisher Year:");
		lblEmail.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblEmail.setBounds(25, 150, 100, 23);
		panel_1.add(lblEmail);

		JLabel lblUsername = new JLabel("Volume: ");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblUsername.setBounds(25, 180, 100, 23);
		panel_1.add(lblUsername);

		JLabel lblPassword = new JLabel("Issue no.: ");
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblPassword.setBounds(25, 210, 100, 23);
		panel_1.add(lblPassword);

		JLabel lblpage = new JLabel("Page no.: ");
		lblpage.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblpage.setBounds(25, 240, 100, 23);
		panel_1.add(lblpage);

		textField = new JTextField();
		textField.setBounds(133, 30, 257, 19);
		panel_1.add(textField);
		textField.setColumns(10);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(133, 60, 257, 19);
		panel_1.add(nameField);

		journalTitleField = new JTextField();
		journalTitleField.setColumns(10);
		journalTitleField.setBounds(133, 90, 257, 19);
		panel_1.add(journalTitleField);

		authorField = new JTextField();
		authorField.setColumns(10);
		authorField.setBounds(133, 120, 257, 19);
		panel_1.add(authorField);

		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(133, 150, 257, 19);
		panel_1.add(yearField);

		volumeField = new JTextField();
		volumeField.setColumns(10);
		volumeField.setBounds(133, 180, 257, 19);
		panel_1.add(volumeField);

		issueField = new JTextField();
		issueField.setColumns(10);
		issueField.setBounds(133, 210, 257, 19);
		panel_1.add(issueField);

		pageField = new JTextField();
		pageField.setColumns(10);
		pageField.setBounds(133, 240, 257, 19);
		panel_1.add(pageField);


		makeFontwhite(lblUpdate);
		makeFontwhite(lblIdNo);
		makeFontwhite(lblFullName);
		makeFontwhite(lblAddress);
		makeFontwhite(lblJournaltitle);
		makeFontwhite(lblEmail);
		makeFontwhite(lblUsername);
		makeFontwhite(lblPassword);
		makeFontwhite(lblpage);
		//textfields disabled
		disableTextfields(textField);
		disableTextfields(nameField);
		disableTextfields(journalTitleField);
		disableTextfields(yearField);
		disableTextfields(authorField);
		disableTextfields(volumeField);
		disableTextfields(issueField);
		disableTextfields(pageField);

		//controller
		rrc= new ReadJournalController(this);
		rrc.viewTabletoResearcher();
		getScroll().setBounds(3,35,810,520);
		panel.add(getScroll());
		//row  selector of the table
		rowField();
	}

	//method to make jlabel's font white
	public void makeFontwhite(JLabel a) {a.setForeground(Color.WHITE);}
	//disabling tfd
	public void disableTextfields(JTextField a) {a.setEditable(false);}
	//getters 

	public JTextField getOldID() { 
		return textField;}

	public JTextField getNewID() { 
		return newIdField;}

	public JTextField getOldName() { 
		return nameField;}

	public JTextField getnewName() { 
		return newNameField;}

	public JTextField getOldJournalTitle() { 
		return journalTitleField;}

	public JTextField getnewJournalTitle() { 
		return newJournalTitleField;}

	public JTextField getOldAuthor() { 
		return authorField;}

	public JTextField getnewAuthor() { 
		return newAuthorField;}

	public JTextField getOldYear() { 
		return yearField;}

	public JTextField getnewYear() { 
		return newYearField;}

	public JTextField getOldVolume() { 
		return volumeField;}

	public JTextField getNewVolume() { 
		return newvolumeField;}

	public JTextField getOldIssue() { 
		return issueField;}

	public JTextField getNewIssue() { 
		return newIssueField;}

	public JTextField getOldPage() {
		return pageField;
	}
	public JTextField getnewpage() {
		return newPageField;
	}

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

	public void recallPaint() { advw.showJournalPanel();}

	//show table data in the textfields and help update and delete
	public void rowField()
	{ 
		viewTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				int c;
				String id ,oldname,oldjtitle,oldauthor,oldyear,oldvolume, oldissue,oldpage;
				DefaultTableModel viewTablemodel = (DefaultTableModel)viewTable.getModel();
				c=viewTable.getSelectedRow();
				id= viewTablemodel.getValueAt(c, 1).toString();
				oldname= viewTablemodel.getValueAt(c,2).toString();
				oldjtitle= viewTablemodel.getValueAt(c,3).toString();
				oldauthor= viewTablemodel.getValueAt(c,4).toString();
				oldyear= viewTablemodel.getValueAt(c,5).toString();
				oldvolume= viewTablemodel.getValueAt(c,6).toString();
				oldissue= viewTablemodel.getValueAt(c,7).toString();
				oldpage= viewTablemodel.getValueAt(c,8).toString();
				updatePanel(id, oldname,oldjtitle, oldauthor, oldyear, oldvolume, oldissue,oldpage);
				setRowCount(viewTable.getSelectedRow());
			}
		});
	}
	//to set the values of update fields 
	public void updatePanel(String id , String oldname,String oldjtitle,String oldauthor,String oldyear,String oldvolume, String oldissue, String oldpage)
	{
		this.textField.setText(id);
		this.nameField.setText(oldname);
		this.authorField.setText(oldauthor);
		this.journalTitleField.setText(oldjtitle);
		this.yearField.setText(oldyear);
		this.volumeField.setText(oldvolume);
		this.issueField.setText(oldissue);
		this.pageField.setText(oldpage);
	}

	//for row number selector
	public int getRowCount() 
	{ return rowcounter; }
	public void setRowCount(int n)
	{rowcounter= n;}

}
