package learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
	
	JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails,deletePersonalDetails,
	checkpackage, bookpackage, viewpackage, viewhotels, bookhotels, viewBookedHotel, destinations,
	payments, calculators, notepad, about;
	
	String username;
	
	Dashboard(String username) {
		this.username = username;
		
		//fullscreen of frame
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0, 0, 102));
		p1.setBounds(0, 0, 1300, 55);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel icon = new JLabel(i3);
		icon.setBounds(5, 0, 65, 50);
		p1.add(icon);
		
		JLabel heading = new JLabel("Dashboard");
		heading.setBounds(80, 5, 300, 40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		p1.add(heading);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0, 0, 102));
		p2.setBounds(0, 55, 200, 700);
		add(p2);
		
		addPersonalDetails = new JButton("Add Personal Details");
		addPersonalDetails.setBounds(0, 0, 250, 40);
		addPersonalDetails.setBackground(new Color(0, 0, 102));
		addPersonalDetails.setForeground(Color.WHITE);
		addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addPersonalDetails.setMargin(new Insets(0, 0, 0, 50));
		addPersonalDetails.addActionListener(this);
		p2.add(addPersonalDetails);
		
		updatePersonalDetails = new JButton("Update Personal Details");
		updatePersonalDetails.setBounds(0, 40, 250, 40);
		updatePersonalDetails.setBackground(new Color(0, 0, 102));
		updatePersonalDetails.setForeground(Color.WHITE);
		updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updatePersonalDetails.setMargin(new Insets(0, 0, 0, 50));
		updatePersonalDetails.addActionListener(this);
		p2.add(updatePersonalDetails);
		
		viewPersonalDetails = new JButton("View Details");
		viewPersonalDetails.setBounds(0, 80, 270, 40);
		viewPersonalDetails.setBackground(new Color(0, 0, 102));
		viewPersonalDetails.setForeground(Color.WHITE);
		viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
		viewPersonalDetails.addActionListener(this);
		p2.add(viewPersonalDetails);
		
		deletePersonalDetails = new JButton("Delete Personal Details");
		deletePersonalDetails.setBounds(0, 120, 250, 40);
		deletePersonalDetails.setBackground(new Color(0, 0, 102));
		deletePersonalDetails.setForeground(Color.WHITE);
		deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deletePersonalDetails.setMargin(new Insets(0, 0, 0, 40));
		deletePersonalDetails.addActionListener(this);
		p2.add(deletePersonalDetails);
		
		checkpackage = new JButton("Check Package");
		checkpackage.setBounds(0, 160, 250, 40);
		checkpackage.setBackground(new Color(0, 0, 102));
		checkpackage.setForeground(Color.WHITE);
		checkpackage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkpackage.setMargin(new Insets(0, 0, 0, 120));
		checkpackage.addActionListener(this);
		p2.add(checkpackage);
		
		bookpackage = new JButton("Book Package");
		bookpackage.setBounds(0, 200, 250, 40);
		bookpackage.setBackground(new Color(0, 0, 102));
		bookpackage.setForeground(Color.WHITE);
		bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookpackage.setMargin(new Insets(0, 0, 0, 120));
		bookpackage.addActionListener(this);
		p2.add(bookpackage);
		
		viewpackage = new JButton("View Package");
		viewpackage.setBounds(0, 240, 250, 40);
		viewpackage.setBackground(new Color(0, 0, 102));
		viewpackage.setForeground(Color.WHITE);
		viewpackage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		viewpackage.setMargin(new Insets(0, 0, 0, 120));
		viewpackage.addActionListener(this);
		p2.add(viewpackage);
		
		viewhotels = new JButton("View Hotels");
		viewhotels.setBounds(0, 280, 250, 40);
		viewhotels.setBackground(new Color(0, 0, 102));
		viewhotels.setForeground(Color.WHITE);
		viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 14));
		viewhotels.setMargin(new Insets(0, 0, 0, 130));
		viewhotels.addActionListener(this);
		p2.add(viewhotels);
		
		bookhotels = new JButton("Book Hotel");
		bookhotels.setBounds(0, 320, 250, 40);
		bookhotels.setBackground(new Color(0, 0, 102));
		bookhotels.setForeground(Color.WHITE);
		bookhotels.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookhotels.setMargin(new Insets(0, 0, 0, 140));
		bookhotels.addActionListener(this);
		p2.add(bookhotels);
		
		viewBookedHotel = new JButton("View Booked Hotel");
		viewBookedHotel.setBounds(0, 360, 250, 40);
		viewBookedHotel.setBackground(new Color(0, 0, 102));
		viewBookedHotel.setForeground(Color.WHITE);
		viewBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		viewBookedHotel.setMargin(new Insets(0, 0, 0, 70));
		viewBookedHotel.addActionListener(this);
		p2.add(viewBookedHotel);
		
		destinations = new JButton("Destinations");
		destinations.setBounds(0, 400, 250, 40);
		destinations.setBackground(new Color(0, 0, 102));
		destinations.setForeground(Color.WHITE);
		destinations.setFont(new Font("Tahoma", Font.PLAIN, 14));
		destinations.setMargin(new Insets(0, 0, 0, 125));
		destinations.addActionListener(this);
		p2.add(destinations);
		
		payments = new JButton("Payments");
		payments.setBounds(0, 440, 250, 40);
		payments.setBackground(new Color(0, 0, 102));
		payments.setForeground(Color.WHITE);
		payments.setFont(new Font("Tahoma", Font.PLAIN, 14));
		payments.setMargin(new Insets(0, 0, 0, 155));
		payments.addActionListener(this);
		p2.add(payments);
		
		calculators = new JButton("Calculator");
		calculators.setBounds(0, 480, 250, 40);
		calculators.setBackground(new Color(0, 0, 102));
		calculators.setForeground(Color.WHITE);
		calculators.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calculators.setMargin(new Insets(0, 0, 0, 145));
		calculators.addActionListener(this);
		p2.add(calculators);
		
		notepad = new JButton("Notepad");
		notepad.setBounds(0, 520, 250, 35);
		notepad.setBackground(new Color(0, 0, 102));
		notepad.setForeground(Color.WHITE);
		notepad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		notepad.setMargin(new Insets(0, 0, 0, 155));
		notepad.addActionListener(this);
		p2.add(notepad);
		
		about = new JButton("About");
		about.setBounds(0, 560, 250, 35);
		about.setBackground(new Color(0, 0, 102));
		about.setForeground(Color.WHITE);
		about.setFont(new Font("Tahoma", Font.PLAIN, 14));
		about.setMargin(new Insets(0, 0, 0, 165));
		about.addActionListener(this);
		p2.add(about);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image = new JLabel(i6);
		image.setBounds(0,0,1300,800);
		add(image);
		
		JLabel text = new JLabel("Travel and Tourism Management System");
		text.setBounds(350, 70, 1000, 70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.PLAIN, 45));
		image.add(text);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addPersonalDetails) {
			new AddCustomer(username);
		} else if (ae.getSource() == viewPersonalDetails) {
			new ViewCustomer(username);
		} else if (ae.getSource() == updatePersonalDetails) {
			new UpdateCustomer(username);
		} else if (ae.getSource() == checkpackage) {
			new CheckPackage();
		} else if (ae.getSource() == bookpackage) {
			new BookPackage(username);
		} else if (ae.getSource() == viewpackage) {
			new ViewPackage(username);
		} else if (ae.getSource() == viewhotels) {
			new CheckHotels();
		} else if (ae.getSource() == destinations) {
			new Destinations();
		} else if (ae.getSource() == bookhotels) {
			new BookHotel(username);
		} else if (ae.getSource() == viewBookedHotel) {
			new ViewBookedHotel(username);
		} else if (ae.getSource() == payments) {
			new Payment();
		} else if (ae.getSource() == calculators) {
			
			//we can operate the windows calculator from here
			try {
				Runtime.getRuntime().exec("calc.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (ae.getSource() == notepad) {
			
			//we can operate the windows notepad from here
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (ae.getSource() == about) {
			new About();
		}
	}
	
	public static void main(String[] args) {
		new Dashboard("");
	}
}