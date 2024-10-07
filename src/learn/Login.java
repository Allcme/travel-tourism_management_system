package learn;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*; //it is the subpackage used for LineBorder
import java.awt.event.*; 
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JTextField tfuserName, tfpassword;
	JButton login, signUp, password;
	
	Login() {  //constructor
		setSize(900, 400);  //(length, width)
		setLocation(250, 150); //(left, top)
		
		//by default swing use border-layout it consider the whole frame as center
		//customized layout 
		setLayout(null);
		
		//it take the whole panel and change the color into white.
		getContentPane().setBackground(Color.WHITE);
		
		JPanel p1 = new JPanel(); //Object for Panel
		p1.setBackground(new Color(131, 193, 233));//(r, g, b) //(Color.WHITE); BACKGROUND COLOUR SET TO WHITE
		p1.setBounds(0, 0, 400, 400); //location for panel starting its 0,0 then (length, width)
		p1.setLayout(null); //setBound won't work without this
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel image = new JLabel(i3); // we can able to write text in panel with the help of JLable
	    image.setBounds(100, 120, 200, 200);
	    p1.add(image);
		
	    
	    JPanel p2 = new JPanel();
	    p2.setLayout(null);
	    p2.setBounds(400, 30, 450, 300);
	    add(p2);
	    
	    JLabel lbluserName = new JLabel("Username");
	    lbluserName.setBounds(60, 20, 100, 20);//(left, top, length_name, width_name)  //helps to locate JLabel data on panel
	    lbluserName.setFont(new Font("SAN_SERIF", Font.PLAIN, 20)); //(style, weight, size)
	    p2.add(lbluserName);
	    
	    tfuserName = new JTextField();//create box for user entry
	    tfuserName.setBounds(60, 60, 300, 30);
	    tfuserName.setBorder(BorderFactory.createEmptyBorder());//remove the border of box
		p2.add(tfuserName);
		
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(60, 110, 100, 20);//(left, top, length_name, width_name)  //helps to locate JLabel data on panel
		lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20)); //(style, weight, size)
	    p2.add(lblpassword);
	    
	    tfpassword = new JTextField();//create box for user entry
	    tfpassword.setBounds(60, 150, 300, 30);
	    tfpassword.setBorder(BorderFactory.createEmptyBorder());//remove the border of box
		p2.add(tfpassword);
		
		login = new JButton("Login"); //login button created
		login.setBounds(60, 200, 130, 30);
		login.setBackground(new Color(133, 193, 233));
		login.setForeground(Color.WHITE); //change the text color
		login.setBorder(new LineBorder(new Color(133, 193, 233)));
		login.addActionListener(this);
		p2.add(login);
		
		signUp = new JButton("SignUp"); //signUp button created
		signUp.setBounds(230, 200, 130, 30);
		signUp.setBackground(new Color(133, 193, 233));
		signUp.setForeground(Color.WHITE); //change the text color
		signUp.setBorder(new LineBorder(new Color(133, 193, 233)));
		signUp.addActionListener(this);
		p2.add(signUp);
		
		password = new JButton("Forget Password"); //signUp button created
		password.setBounds(150, 250, 130, 30);
		password.setBackground(new Color(133, 193, 233));
		password.setForeground(Color.WHITE);  //change the text color
		password.setBorder(new LineBorder(new Color(133, 193, 233)));
		password.addActionListener(this);
		p2.add(password);
		
		JLabel text = new JLabel("Trouble in login...");
		text.setBounds(300, 250, 150, 20);
		text.setForeground(Color.RED);   //change the text color
		p2.add(text);
		
	    setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == login) {
			try {
				String username = tfuserName.getText();
				String pass = tfpassword.getText();
				
				String query = "select * from account where username = '"+username+"'AND password = '"+pass+"'";
				Conn c = new Conn();
				ResultSet rs  = c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
				} else {
					//alert for incorrect Input
					JOptionPane.showMessageDialog(null, "Incorrect username or password");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		//if the signup button is clicked it'll close the login page and wait the signup page
		else if (ae.getSource() == signUp) {
			setVisible(false);
			new SignUp();
		} else {
			setVisible(false);
			new ForgetPassword();
		}
		
	}
	public static void main(String[] args) {
		
		new Login(); //anonymous login object
	}

}
