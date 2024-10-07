package learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //for ActionListener

//ActionListener helps to make everything work as javaScript do

public class SignUp extends JFrame implements ActionListener{
	
	//global variables
	JButton create, back;
	JTextField tfName, tfuserName, tfpassword, tfanswer;
	Choice security;
	
	SignUp() {
		setBounds(200, 150, 900, 360); //takes 4 arguments
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(133, 193, 233));
		p1.setBounds(0, 0, 500, 400);
		p1.setLayout(null);
		add(p1);
		
		JLabel lbluserName = new JLabel("Username");
		lbluserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbluserName.setBounds(50, 20, 125, 25);
		p1.add(lbluserName);
		
		tfuserName = new JTextField();
		tfuserName.setBounds(190, 20, 180, 25);
		tfuserName.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfuserName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(50, 60, 125, 25);
		p1.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(190, 60, 180, 25);
		tfName.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfName);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpassword.setBounds(50, 100, 125, 25);
		p1.add(lblpassword);
		
		tfpassword = new JTextField();
		tfpassword.setBounds(190, 100, 180, 25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);
		
		JLabel lblSecurity = new JLabel("Security Question");
		lblSecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecurity.setBounds(50, 140, 125, 25);
		p1.add(lblSecurity);
		
		//DropDown 
		security = new Choice();
		security.add("Choose ur fav question");
		security.add("Fav Character from The Boys");
		security.add("Fav Marvel superhero");
		security.add("Your Lucky number");
		security.add("Your Childhood Superhero");
		security.setBounds(190, 140, 180, 25);
		p1.add(security);
		
		JLabel lblAnswer = new JLabel("Answer"); //answer of above question
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer.setBounds(50, 180, 125, 25);
		p1.add(lblAnswer);
		
		tfanswer = new JTextField(); //user input for answer box
		tfanswer.setBounds(190, 180, 180, 25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);
		
		create =new JButton("Create"); //create button
		create.setBackground(Color.WHITE);
		create.setForeground(new Color(133, 193, 233));
		create.setFont(new Font("Tahoma", Font.BOLD, 14));
		create.setBounds(80, 250, 100, 30);
		create.addActionListener(this); //while clicked it will do event
		p1.add(create);

		back =new JButton("Back"); //back button
		back.setBackground(Color.WHITE);
		back.setForeground(new Color(133, 193, 233));
		back.setFont(new Font("Tahoma", Font.BOLD, 14));
		back.setBounds(250, 250, 100, 30);
		back.addActionListener(this);  //while clicked it will do event
		p1.add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(580, 50, 250, 250);
		add(image);
		
		//if we write anything below setVisible u can't able to see anything
		setVisible(true); 
	}
	
	//used to avoid error in Signup class, it is override'd
	//this will say what to do to the events occur while clicked or any action performed
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == create) {
			String username = tfuserName.getText();
			String name = tfName.getText();
			String password = tfpassword.getText();
			String question = security.getSelectedItem(); //for dropdown
			String answer = tfanswer.getText();
			
			String query = "insert into account values('"+username+ "', '"+name+"', '"+password+"','"+question+"','"+answer+"')";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query);
				
				//If the execution is success then the pop_up shows, the below is for pop_up
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				
				setVisible(false); //when clicked ok in pop_up
				new Login();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == back) {
			setVisible(false); //frame closed
			new Login();		//login panel opened
		}
	}
	
	/*//String ke ander ek number ko concatenate karna hai
	int number = 10; '10'
	"stringstring"+number+"stringstring"
	 */
	
	public static void main(String[] args) {
		new SignUp();

	}

}
