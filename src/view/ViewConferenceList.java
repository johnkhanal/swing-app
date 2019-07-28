package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import controller.*;
import model.*;
public class ViewConferenceList extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField, nameField, editorField, authorField, yearField, placeField, publisherField, newIdField, newNameField, newEditorField, newAuthorField, newYearField, newplaceField, newPublisherField;
	private JButton btnAdd, btnUpdate, btnDelete;

	//to view table
	private JTable viewTable = new JTable();
	private JScrollPane viewScroll;
	//for  row num
	private int rowcounter;
	
	//model
	ReadConferenceModel rrModel = new ReadConferenceModel();
	/**
	 * Create the panel.
	 */
	AdministratorView advw;
	ResearcherView researcherView;
	ReadConferenceController rrc ;
	public ViewConferenceList(AdministratorView advw) {
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
		JLabel tt= new JLabel("Conference Articles ");
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

		JLabel lblJournaltitle = new JLabel("Editor:");
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

		JLabel lblUsername = new JLabel("Place of Publication: ");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblUsername.setBounds(25, 180, 150, 23);
		panel_1.add(lblUsername);

		JLabel lblPassword = new JLabel("Page no.: ");
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblPassword.setBounds(25, 210, 100, 23);
		panel_1.add(lblPassword);


		textField = new JTextField();
		textField.setBounds(150, 30, 257, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(150, 60, 257, 19);
		panel_1.add(nameField);

		editorField = new JTextField();
		editorField.setColumns(10);
		editorField.setBounds(150, 90, 257, 19);
		panel_1.add(editorField);

		authorField = new JTextField();
		authorField.setColumns(10);
		authorField.setBounds(150, 120, 257, 19);
		panel_1.add(authorField);

		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(150, 150, 257, 19);
		panel_1.add(yearField);

		placeField = new JTextField();
		placeField.setColumns(10);
		placeField.setBounds(150, 180, 257, 19);
		panel_1.add(placeField);

		publisherField = new JTextField();
		publisherField.setColumns(10);
		publisherField.setBounds(150, 210, 257, 19);
		panel_1.add(publisherField);


		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(150, 260, 85, 21);
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

		JLabel label_3 = new JLabel("Editor: ");
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

		JLabel label_6 = new JLabel("Place of Publication: ");
		label_6.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		label_6.setBounds(25, 470, 150, 23);
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("Page no.: ");
		label_7.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		label_7.setBounds(25, 500, 100, 23);
		panel_1.add(label_7);


		newIdField = new JTextField();
		newIdField.setColumns(10);
		newIdField.setBounds(150, 320, 257, 19);
		panel_1.add(newIdField);
		//id 
		newIdField.setEditable(false);
		if(rrModel.readFile()!=null)
		{
			//getting the last stored id, converting into integer and adding 1 to the new id
			int subId = Integer.parseInt(rrModel.readFile().get(rrModel.readFile().size()-1).getId());
			String newId = String.valueOf(subId+1);
			newIdField.setText(newId);
		}
		else {newIdField.setText("4000");}

		newNameField = new JTextField();
		newNameField.setColumns(10);
		newNameField.setBounds(150, 350, 257, 19);
		panel_1.add(newNameField);

		newEditorField = new JTextField();
		newEditorField.setColumns(10);
		newEditorField.setBounds(150, 380, 257, 19);
		panel_1.add(newEditorField);

		newAuthorField = new JTextField();
		newAuthorField.setColumns(10);
		newAuthorField.setBounds(150, 410, 257, 19);
		panel_1.add(newAuthorField);

		newYearField = new JTextField();
		newYearField.setColumns(10);
		newYearField.setBounds(150, 440, 257, 19);
		panel_1.add(newYearField);

		newplaceField = new JTextField();
		newplaceField.setColumns(10);
		newplaceField.setBounds(150, 470, 257, 19);
		panel_1.add(newplaceField);

		newPublisherField = new JTextField();
		newPublisherField.setColumns(10);
		newPublisherField.setBounds(150, 500, 257, 19);
		panel_1.add(newPublisherField);


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

		makeFontwhite(label_1);
		makeFontwhite(label_2);
		makeFontwhite(label_3);
		makeFontwhite(label_4);
		makeFontwhite(label_5);
		makeFontwhite(label_6);
		makeFontwhite(label_7);

		//		calling controller
		rrc=new ReadConferenceController(this);
		rrc.viewTable();
		rrc.addFunction();
		rrc.updateSelectedRow();
		rrc.deleterow();
		getScroll().setBounds(3,35,810,520);
		panel.add(getScroll());
		rowField();
	}

	//reseacher's frame
	public ViewConferenceList(ResearcherView advw) {
		this.researcherView= advw;
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

		JLabel lblJournaltitle = new JLabel("Editor:");
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

		JLabel lblUsername = new JLabel("Place of Publication: ");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblUsername.setBounds(25, 180, 150, 23);
		panel_1.add(lblUsername);

		JLabel lblPassword = new JLabel("Page no.: ");
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblPassword.setBounds(25, 210, 100, 23);
		panel_1.add(lblPassword);


		textField = new JTextField();
		textField.setBounds(150, 30, 257, 19);
		panel_1.add(textField);
		textField.setColumns(10);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(150, 60, 257, 19);
		panel_1.add(nameField);

		editorField = new JTextField();
		editorField.setColumns(10);
		editorField.setBounds(150, 90, 257, 19);
		panel_1.add(editorField);

		authorField = new JTextField();
		authorField.setColumns(10);
		authorField.setBounds(150, 120, 257, 19);
		panel_1.add(authorField);

		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(150, 150, 257, 19);
		panel_1.add(yearField);

		placeField = new JTextField();
		placeField.setColumns(10);
		placeField.setBounds(150, 180, 257, 19);
		panel_1.add(placeField);

		publisherField = new JTextField();
		publisherField.setColumns(10);
		publisherField.setBounds(150, 210, 257, 19);
		panel_1.add(publisherField);

		setVisible(true);

		makeFontwhite(lblUpdate);
		makeFontwhite(lblIdNo);
		makeFontwhite(lblFullName);
		makeFontwhite(lblAddress);
		makeFontwhite(lblJournaltitle);
		makeFontwhite(lblEmail);
		makeFontwhite(lblUsername);
		makeFontwhite(lblPassword);


		//		calling controller
		rrc=new ReadConferenceController(this);
		rrc.viewResearchersTable();
		getScroll().setBounds(3,35,810,520);
		panel.add(getScroll());
		rowField();

		//disable textfields
		disableTextfields(textField);
		disableTextfields(nameField);
		disableTextfields(editorField);
		disableTextfields(yearField);
		disableTextfields(authorField);
		disableTextfields(placeField);
		disableTextfields(publisherField);
	}


	//method to make jlabel's font white
	public void makeFontwhite(JLabel a) {a.setForeground(Color.WHITE);}
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

	public JTextField getOldEditor() { 
		return editorField;}

	public JTextField getnewEditor() { 
		return newEditorField;}

	public JTextField getOldAuthor() { 
		return authorField;}

	public JTextField getnewAuthor() { 
		return newAuthorField;}

	public JTextField getOldYear() { 
		return yearField;}

	public JTextField getnewYear() { 
		return newYearField;}

	public JTextField getOldPlace() { 
		return placeField;}

	public JTextField getNewPlace() { 
		return newplaceField;}

	public JTextField getOldPublisher() { 
		return publisherField;}

	public JTextField getNewPublisher() { 
		return newPublisherField;}


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

	public void recallPaint() { advw.showConference();}

	//show table data in the textfields and help update and delete
	public void rowField()
	{ 
		viewTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				int c;
				String id ,oldname,oldAuthor,oldEditor,oldyear,oldplace, oldpublisher;
				DefaultTableModel viewTablemodel = (DefaultTableModel)viewTable.getModel();
				c=viewTable.getSelectedRow();
				id= viewTablemodel.getValueAt(c, 1).toString();
				oldname= viewTablemodel.getValueAt(c,2).toString();
				oldEditor= viewTablemodel.getValueAt(c,5).toString();
				oldAuthor= viewTablemodel.getValueAt(c,3).toString();
				oldyear= viewTablemodel.getValueAt(c,4).toString();
				oldplace= viewTablemodel.getValueAt(c,6).toString();
				oldpublisher= viewTablemodel.getValueAt(c,7).toString();
				updatePanel(id, oldname, oldEditor, oldAuthor, oldyear, oldplace, oldpublisher);
				setRowCount(viewTable.getSelectedRow());
			}
		});
	}
	//to set the values of update fields 
	public void updatePanel(String id , String oldname,String oldEditor,String oldAuthor,String oldyear,String oldplace, String oldpublisher)
	{
		this.textField.setText(id);
		this.nameField.setText(oldname);
		this.authorField.setText(oldAuthor);
		this.editorField.setText(oldEditor);
		this.yearField.setText(oldyear);
		this.placeField.setText(oldplace);
		this.publisherField.setText(oldpublisher);}

	//for row number selector
	public int getRowCount() 
	{ return rowcounter; }
	public void setRowCount(int n)
	{rowcounter= n;}

}
