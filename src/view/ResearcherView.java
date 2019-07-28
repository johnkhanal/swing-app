package view;

import java.awt.*;
import javax.swing.*;
import controller.*;

/*
 * This is the frame of the researcher opened after a researcher logins
 */
public class ResearcherView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel headlabel,bglabel;
	private JButton  btnJournalArticles, btnConferenceArticles, btnBookchapters, btnHireArticle, logoutbtn;

	/**
	 * Create the frame.
	 */
	public ResearcherView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 1280, 720);
		setLocationRelativeTo(null);
		setTitle("Northampton Research Center");
		setResizable(false);
		//the section with the button menus which is static
		headlabel = new JLabel(new ImageIcon("src/bg/gradient.jpg"));
		headlabel.setBounds(0, 0, 1280, 80);
		getContentPane().add(headlabel);
		
		//section where the panel with dynamic content load
		bglabel = new JLabel(new ImageIcon("src/bg/gradient.jpg"));
		bglabel.setBounds(0, 80, 1280, 720);
		getContentPane().add(bglabel);

		JLabel lblNorthamptonResearchCenter = new JLabel("Northampton Research Center");
		lblNorthamptonResearchCenter.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblNorthamptonResearchCenter.setBounds(454, 656, 398, 27);
		bglabel.add(lblNorthamptonResearchCenter);

		btnJournalArticles = new JButton("Journal Articles");
		btnJournalArticles.setBounds(200, 25, 150, 35);
		btnJournalArticles.setFocusPainted(false);
		btnJournalArticles.setForeground(Color.white);
		btnJournalArticles.setBorderPainted(false);
		btnJournalArticles.setBackground(Color.DARK_GRAY);

		btnConferenceArticles = new JButton("Conference Articles");
		btnConferenceArticles.setBounds(375, 25, 150, 35);
		btnConferenceArticles.setFocusPainted(false);
		btnConferenceArticles.setForeground(Color.white);
		btnConferenceArticles.setBorderPainted(false);
		btnConferenceArticles.setBackground(Color.DARK_GRAY);

		btnBookchapters = new JButton("Book Chapters");
		btnBookchapters.setBounds(550, 25, 150, 35);
		btnBookchapters.setFocusPainted(false);
		btnBookchapters.setForeground(Color.white);
		btnBookchapters.setBorderPainted(false);
		btnBookchapters.setBackground(Color.DARK_GRAY);

		btnHireArticle = new JButton("Hire Articles");
		btnHireArticle.setBounds(725, 25, 150, 35);
		btnHireArticle.setFocusPainted(false);
		btnHireArticle.setForeground(Color.white);
		btnHireArticle.setBorderPainted(false);
		btnHireArticle.setBackground(Color.DARK_GRAY);

		logoutbtn = new JButton();
		logoutbtn.setBorderPainted(false);
		logoutbtn.setFocusPainted(false);
		logoutbtn.setToolTipText("Log Out");
		logoutbtn.setIcon(new ImageIcon("src/bg/signout.png"));
		logoutbtn.setContentAreaFilled(false);
		logoutbtn.setBounds(1202, 20, 80, 72);

		//menu buttons
		headlabel.add(btnJournalArticles);
		headlabel.add(btnConferenceArticles);
		headlabel.add(btnBookchapters);
		headlabel.add(btnHireArticle);
		headlabel.add(logoutbtn);	

		//welcome 
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(new Color(0,0,0,65));
		lblWelcome.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 60));
		lblWelcome.setBounds(468, 280, 383, 82);
		bglabel.add(lblWelcome);
		
		ResearcherController controller =  new ResearcherController(this);
		controller.adminFunctions();


	}

	//getters
	public JButton getlogout() {
		return this.logoutbtn; }


	public JButton getJournal() {
		return this.btnJournalArticles; }

	public JButton getBook() {
		return this.btnBookchapters; }
	
	public JButton getConference() {
		return this.btnConferenceArticles; }

	public JButton getHires() {
		return this.btnHireArticle; }



	//to view different info when buttons are clicked
	//for journal articles
	public void showJournalPanel()
	{
		bglabel.removeAll();
		ViewJournalsList viewset = new ViewJournalsList(this);
		bglabel.add(viewset);
		bglabel.revalidate();
		bglabel.repaint();
	}
//
//	//for conference panel
	public void showConference()
	{
		bglabel.removeAll();
		ViewConferenceList viewset = new ViewConferenceList(this);
		bglabel.add(viewset);
		bglabel.revalidate();
		bglabel.repaint();
	}
//
//	//for book panel
	public void showBooks()
	{
		bglabel.removeAll();
		ViewBookChaptersList viewset = new ViewBookChaptersList(this);
		bglabel.add(viewset);
		bglabel.revalidate();
		bglabel.repaint();
	}
//	
//	//for hire panel
	public void showHires()
	{
		bglabel.removeAll();
		ViewHireList viewset = new ViewHireList(this);
		bglabel.add(viewset);
		bglabel.revalidate();
		bglabel.repaint();
	}

	//for hired articles
	public void showArticles()
	{

	}

}

