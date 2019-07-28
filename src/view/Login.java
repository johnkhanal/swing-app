package view;

import java.awt.*;
import javax.swing.*;


//the login frame for both admin and researcher
public class Login extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JComboBox<String> comboBox;
	JButton btnLogin ;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Northampton Research Center");
		setSize( 1280, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//setting image as the background 
		JLabel bg;
		bg = new JLabel(new ImageIcon("src/bg/gradient.jpg"));
		bg.setBounds(0,0,1280,768);
		contentPane.add(bg);
		//login panel
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,0,65));
		panel_1.setBounds(681, 51, 530, 620);
		bg.add(panel_1);
		panel_1.setLayout(null);
		
		//determines admin or researcher
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Admin", "Researcher"}));
		comboBox.setBounds(257, 176, 163, 38);
		panel_1.add(comboBox);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 24));
		lblLoginAs.setBounds(96, 174, 101, 43);
		panel_1.add(lblLoginAs);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setBounds(193, 42, 158, 51);
		panel_1.add(lblLoginPage);
		lblLoginPage.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 24));
		lblUsername.setBounds(96, 281, 115, 43);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 24));
		lblPassword.setBounds(96, 352, 115, 43);
		panel_1.add(lblPassword);
		//username field
		textField = new JTextField();
		textField.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		textField.setBounds(220, 281, 200, 36);
		panel_1.add(textField);
		textField.setColumns(10);
		//password field
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		textField_1.setBounds(220, 357, 200, 36);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		//button to log in
		btnLogin = new JButton("Log In");
		btnLogin.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		btnLogin.setBounds(214, 476, 97, 38);
		panel_1.add(btnLogin);
		
		JLabel lblNorthamptonResearchCentre = new JLabel("Northampton Research Centre");
		lblNorthamptonResearchCentre.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 40));
		lblNorthamptonResearchCentre.setBounds(12, 51, 657, 66);
		bg.add(lblNorthamptonResearchCentre);
		
		JLabel lblResearchArticleManagement = new JLabel("Research Article Management");
		lblResearchArticleManagement.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 35));
		lblResearchArticleManagement.setBounds(12, 130, 657, 66);
		bg.add(lblResearchArticleManagement);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 60));
		lblWelcome.setBounds(163, 324, 305, 103);
		bg.add(lblWelcome);
		
		setVisible(true);
	}
	
	//getters
	public JTextField getUserName() { return this.textField;}
	public JPasswordField getPasswordField() { return this.textField_1; }
	public JButton getLoginBtn() { return this.btnLogin; }
	public JComboBox<String> getUserType() { return this.comboBox; }
	
}
