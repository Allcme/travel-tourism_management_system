package learn;
		
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
	
	Choice chotel, cac, cfood;
	JTextField tfpersons, tfdays;
	JLabel labelusername, labelid, labelnumber, labelprice;
	JButton checkprice, bookhotel, back;
	String username;
	
	BookHotel(String username) {
		this.username = username;
		
		setBounds(200, 50, 850, 550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text = new JLabel("BOOK HOTEL");
		text.setBounds(100, 10, 200, 30);
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblusername.setBounds(40, 70, 100, 20);
		add(lblusername);
		
		labelusername = new JLabel();
		labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelusername.setBounds(220, 70, 200, 20);
		add(labelusername);
		
		JLabel lblpackage = new JLabel("Select Hotel");
		lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpackage.setBounds(40, 110, 150, 20);
		add(lblpackage);
		
		chotel = new Choice();
		/*cpackage.add("Gold Package");
		cpackage.add("Silver Package");
		cpackage.add("Bronze Package");*/
		chotel.setBounds(220, 110, 200, 20);
		add(chotel);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from hotel");
			while(rs.next()) {
				chotel.add(rs.getString("name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblpersons = new JLabel("Total Persons");
		lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpersons.setBounds(40, 150, 150, 25);
		add(lblpersons);
		
		tfpersons = new JTextField("1");
		tfpersons.setBounds(220, 150, 200, 25);
		add(tfpersons);

		JLabel lbldays = new JLabel("No. of Days");
		lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldays.setBounds(40, 190, 150, 25);
		add(lbldays);
		
		tfdays = new JTextField("1");
		tfdays.setBounds(220, 190, 200, 25);
		add(tfdays);
	
		
		JLabel lblac = new JLabel("AC/ Non-AC");
		lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblac.setBounds(40, 230, 150, 20);
		add(lblac);
		
		cac= new Choice();
		cac.add("AC");
		cac.add("Non-AC");
		cac.setBounds(220, 230, 200, 20);
		add(cac);
	
		JLabel lblfood = new JLabel("Food Included");
		lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblfood.setBounds(40, 270, 150, 25);
		add(lblfood);
		
		cfood= new Choice();
		cfood.add("Yes");
		cfood.add("No");
		cfood.setBounds(220, 270, 200, 20);
		add(cfood);
		
		JLabel lblid = new JLabel("Id");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblid.setBounds(40, 310, 150, 20);
		add(lblid);
		
		labelid = new JLabel();
		labelid.setBounds(220, 310, 200, 25);
		add(labelid);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblnumber.setBounds(40, 350, 150, 20);
		add(lblnumber);
		
		labelnumber = new JLabel();
		labelnumber.setBounds(220, 350, 200, 25);
		add(labelnumber);
		
		JLabel lbltotal = new JLabel("Total Price");
		lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbltotal.setBounds(40, 390, 150, 25);
		add(lbltotal);
		
		labelprice = new JLabel();
		labelprice.setBounds(220, 390, 150, 25);
		add(labelprice);
		
		
		try {
			Conn c = new Conn();
			String query = "select * from customer where username = '"+username+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				//labelphone.setText(rs.getString("phone"));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		checkprice = new JButton("Check Price");
		checkprice.setBackground(Color.BLACK);
		checkprice.setForeground(Color.WHITE);
		checkprice.setBounds(40, 450, 120, 25);
		checkprice.addActionListener(this);
		add(checkprice);
		
		bookhotel = new JButton("Book Hotel");
		bookhotel.setBackground(Color.BLACK);
		bookhotel.setForeground(Color.WHITE);
		bookhotel.setBounds(180, 450, 120, 25);
		bookhotel.addActionListener(this);
		add(bookhotel);
		
		back = new JButton("Book Price");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(320, 450, 120, 25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i4 = new JLabel(i3);
		i4.setBounds(450, 50, 400, 300);
		add(i4);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == checkprice) {
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
				while(rs.next()) {
					int cost = Integer.parseInt(rs.getString("costperperson"));
					int food = Integer.parseInt(rs.getString("foodincluded"));
					int ac = Integer.parseInt(rs.getString("acroom"));
					
					int persons = Integer.parseInt(tfpersons.getText());
					int days = Integer.parseInt(tfdays.getText());
					
					String acselected = cac.getSelectedItem();
					String foodselected = cfood.getSelectedItem();
					
					if(persons * days > 0) {
						int total = 0;
						total += acselected.equals("AC") ? ac : 0;
						total += foodselected.equals("Yes") ? food : 0;
						total += cost;
						total = total * persons * days;
						labelprice.setText("Rs " + total);
					} else {
						JOptionPane.showMessageDialog(null, "Please enter a valid number");
						}
					
					}
			
				} catch (Exception e) {
					e.printStackTrace();
				}	
			
		}else if (ae.getSource() == bookhotel) {
			try {
				Conn c = new Conn();
				c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"', '"+labelnumber.getText()+"','"+labelprice.getText()+"')");
			
				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully.");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		} else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new BookHotel("sharukh");
	}
}
