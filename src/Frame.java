import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Frame extends JFrame{

	Connection conn = null;
	PreparedStatement state = null;
	ResultSet result = null;
	
	public static int tabIndex;
	public static String sql;
	public static int car_id;
	
	//Tabs
	JTabbedPane jtp = new JTabbedPane();
	JPanel tab1 = new JPanel();
	JPanel tab2 = new JPanel();
	JPanel tab3 = new JPanel();
	JPanel tab4 = new JPanel();
	JPanel tab5 = new JPanel();
	
	//table
	JTable table = new JTable();
	JTable table2 = new JTable();
	JTable table3 = new JTable();
	JTable table4 = new JTable();
	
	//Scroll
	JScrollPane myScroll = new JScrollPane(table);
	JScrollPane myScroll2 = new JScrollPane(table2);
	JScrollPane myScroll3 = new JScrollPane(table3);
	JScrollPane myScroll4 = new JScrollPane(table4);
	
/* Чудя се за абстрактен клас за тези панели */	
	
	//Panels for tab1
	JPanel upPanel = new JPanel(); 
	JPanel midPanel = new JPanel();// buttons are here
	JPanel tablePanel = new JPanel(); // for the table
	
	//Panels for tab2
	JPanel upPanel2 = new JPanel(); 
	JPanel midPanel2 = new JPanel();// buttons are here
	JPanel tablePanel2 = new JPanel(); // for the table
	
	//Panels for tab3
	JPanel upPanel3 = new JPanel(); 
	JPanel midPanel3 = new JPanel();// buttons are here
	JPanel tablePanel3 = new JPanel(); // for the table 
	
	//Panel for tab4
	JPanel upPanel4 = new JPanel(); 
	JPanel midPanel4 = new JPanel();// buttons are here
	JPanel tablePanel4 = new JPanel(); // for the table 
	
	//Labels for tab1
	JLabel firstName = new JLabel("First name:");
	JLabel lastName = new JLabel("Last name:");
	JLabel address = new JLabel("Address:");

	//Labels for tab2
	JLabel carBrand = new JLabel("Car Brand:");
	JLabel carModel = new JLabel("Car Model:");
	JLabel regNum = new JLabel("Registration Number:");
	
	//Labels for tab 3
	JLabel selectCustomer = new JLabel("Select Customer:");
	JLabel selectCar = new JLabel("Select Car:");
	JLabel rentDate = new JLabel("Rent Date:");
	JLabel returnDate = new JLabel("Return Date:");
	
	//Labels for tab 4
	JLabel enterFname = new JLabel("Enter First Name:");
	JLabel enterLname = new JLabel("Enter Last Name:");
	
	//Text fields for Tab 1
	JTextField firstNameTF = new JTextField(20);
	JTextField lastNameTF = new JTextField(20);
	JTextField addressTF = new JTextField(20);
	
	//Text fields for Tab 2
	JTextField carBrandTF = new JTextField(20);
	JTextField carModelTF = new JTextField(20);
	JTextField regNumTF = new JTextField(20);
	
	//Text fields for Tab 3
	JTextField rentDateTF = new JTextField(20);
	JTextField returnDateTF = new JTextField(20);
	
	//Text fields for Tab 4
	JTextField customerFnameTF = new JTextField(20);
	JTextField customerLnameTF = new JTextField(20);
	
	//Buttons 
	JButton createBtn = new JButton("Add");
	JButton updateBtn = new JButton("Update");
	JButton deleteBtn = new JButton("Delete");
	
	// TAB2 Buttons
	JButton createBtn2 = new JButton("Add");
	JButton updateBtn2 = new JButton("Update");
	JButton deleteBtn2 = new JButton("Delete");
	
	//Tab3 Buttons
	JButton createBtn3 = new JButton("Add");
	//JButton updateBtn3 = new JButton("Update");
	JButton deleteBtn3 = new JButton("Delete");
	
	//Tab4 Buttons
	JButton searchBtn = new JButton("Search");
	
	//ComboBox
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox2 = new JComboBox();
	protected int row;
	protected int column;
	
	public Frame() {
		
		this.setSize(500,500);
		this.setTitle("Car Rental");
		this.setVisible(true);
		//this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//tabs
		jtp.add("Add customers", tab1);
		jtp.add("Add cars", tab2);
		jtp.add("Rent", tab3);
		jtp.add("Search customer", tab4);
		
		//TAB 1 - up; mid; table
			tab1.setLayout(new GridLayout(3,1));
			upPanel.setLayout(new GridLayout(5, 2));
			upPanel.add(firstName);
			upPanel.add(firstNameTF);
			upPanel.add(lastName);
			upPanel.add(lastNameTF);
			upPanel.add(address);
			upPanel.add(addressTF);
	
			//midPanel
			midPanel.setLayout(new FlowLayout());
			midPanel.add(createBtn);
			midPanel.add(updateBtn);
			midPanel.add(deleteBtn);
		
			//table Panel
			//myScroll.setSize(100, 50);
			tablePanel.setLayout(new BorderLayout());
			//myScroll.setVisible(true);
			tablePanel.add(myScroll);
		
	//TAB 2 up; mid; table
		tab2.setLayout(new GridLayout(3,1));
		//upPanel2
		upPanel2.setLayout(new GridLayout(4, 2));
		upPanel2.add(carBrand);
		upPanel2.add(carBrandTF);
		upPanel2.add(carModel);
		upPanel2.add(carModelTF);
		upPanel2.add(regNum);
		upPanel2.add(regNumTF);
		
		//midPanel
		midPanel2.setLayout(new FlowLayout());
		midPanel2.add(createBtn2);
		midPanel2.add(updateBtn2);
		midPanel2.add(deleteBtn2);
		
		//tablePanel
		tablePanel2.setLayout(new BorderLayout());
		tablePanel2.add(myScroll2);
		
	//Tab 3 up; mid; table
		tab3.setLayout(new GridLayout(3,1));
		//upPanel3
		upPanel3.setLayout(new GridLayout(4, 2));
		upPanel3.add(selectCustomer);
		upPanel3.add(comboBox);
		upPanel3.add(selectCar);
		upPanel3.add(comboBox2);
		upPanel3.add(rentDate);
		upPanel3.add(rentDateTF);
		upPanel3.add(returnDate);
		upPanel3.add(returnDateTF);
		
		//midPanel3
		midPanel3.setLayout(new FlowLayout());
		midPanel3.add(createBtn3);
		//midPanel3.add(updateBtn3);
		midPanel3.add(deleteBtn3);
		
		//tablePanel3
		tablePanel3.setLayout(new BorderLayout());
		tablePanel3.add(myScroll3);
		
	//TAB 4
		tab4.setLayout(new GridLayout(3,1));
		upPanel4.setLayout(new GridLayout(3, 2));
		upPanel4.add(enterFname);
		upPanel4.add(customerFnameTF);
		upPanel4.add(enterLname);
		upPanel4.add(customerLnameTF);

		//MidPanel
		midPanel4.setLayout(new FlowLayout());
		midPanel4.add(searchBtn);
				
		//Table Panel 4
		tablePanel4.setLayout(new BorderLayout());
		tablePanel4.add(myScroll4);
		
		//putting ActionListener to the buttons
		//tab1 buttons Actions
		createBtn.addActionListener(new addButtonAction());
		deleteBtn.addActionListener(new deleteButtonAction());
		updateBtn.addActionListener(new updateButtonAction());
		
		//tab2 buttons Actions
		createBtn2.addActionListener(new addButtonAction());
		deleteBtn2.addActionListener(new deleteButtonAction());
		updateBtn2.addActionListener(new updateButtonAction());
		
		//tab3 buttons Actions
		createBtn3.addActionListener(new addButtonAction());
		deleteBtn3.addActionListener(new deleteButtonAction());
		//updateBtn3.addActionListener(new updateButtonAction());
		
		//Tab4 button Action
		searchBtn.addActionListener(new searchButtonAction());
		
		// selected tab so can be used for changing the buttons!
		ChangeListener changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		        tabIndex = sourceTabbedPane.getSelectedIndex();
		        
		        refreshTable(table);
		        refreshTable(table2);
		        refreshTable(table3);
		       // refreshTable(table4);
		        
//		        System.out.println("Tab changed to: " + tabIndex);
//		        System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(tabIndex));
		      }//end stateChange 
		};// end ChangeListener;
		
		jtp.addChangeListener(changeListener);
			
		tab1.add(upPanel);
		tab1.add(midPanel);
		tab1.add(tablePanel);
		
		tab2.add(upPanel2);
		tab2.add(midPanel2);
		tab2.add(tablePanel2);
		
		tab3.add(upPanel3);
		tab3.add(midPanel3);
		tab3.add(tablePanel3);
		
		tab4.add(upPanel4);
		tab4.add(midPanel4);
		tab4.add(tablePanel4);
		
		this.add(jtp);
		
		ifSelectedRow(table);
		ifSelectedRow(table2);
		ifSelectedRow(table3);
		
		refreshTable(table);
		refreshTable(table2);
		refreshTable(table3);
		//refreshTable(table4);
		FillComboBox();
		
	}// end Constructor
	
	private void ifSelectedRow(JTable table) {
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			       row = target.getSelectedRow();
			       column = target.getSelectedColumn();
//			       System.out.println("row: " +row);
//			       System.out.println("col: " + column);
				       switch (tabIndex) {
					case 0:
						firstNameTF.setText((String) target.getValueAt(row, 1));
						lastNameTF.setText((String) target.getValueAt(row, 2));
						addressTF.setText((String) target.getValueAt(row, 3));
						break;
					case 1:
						carBrandTF.setText((String) target.getValueAt(row, 1));
						carModelTF.setText((String) target.getValueAt(row, 2));
						regNumTF.setText((String) target.getValueAt(row, 3));
						break;
					default:
						break;
					}// end switch case
			       
			    }//end if
			    
			  }//end mouseClicked
			});
	}//end ifSelectedRow
	
	//table methods
	public ResultSet getAll(){	
		
		switch (tabIndex) {
		case 0:
			sql = "SELECT * FROM CUSTOMERS";
			break;
		case 1:
			sql = "SELECT * FROM CARS";
			break;
		case 2:
			sql = "SELECT RENT_ID, FNAME, LNAME ,BRAND, MODEL, REG_NUM, RENT_DATE, RETURN_DATE"
					+ " FROM RENT "
					+ "INNER JOIN CARS "
					+ "ON CARS.CAR_ID = RENT.CAR_ID "
					+ "INNER JOIN CUSTOMERS "
					+ "ON CUSTOMERS.CUSTOMER_ID = RENT.CUSTOMER_ID ";
			break;
		case 3:
			break;
		default:
			//JOptionPane.showMessageDialog(null, "Error with the table");
			break;
		}
		
		conn = DBConnection.getConnection();
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			return result;
		}
		
	}// end getAll	
	
	public void refreshTable(JTable table){
		try {
			table.setModel(new MyModel(getAll()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end refreshTable
//end table methods	
	
	// Fill ComboBox 	
	public void FillComboBox() {
		
		String comboBoxQuery = "SELECT * FROM CUSTOMERS";
		String comboBoxQueryCars = "SELECT * FROM CARS WHERE RATE = 0 ";
		try {
			result = state.executeQuery(comboBoxQuery);
			
			while(result.next()) {
				comboBox.addItem("ID: " + result.getString(1) + " " + result.getString(2) + " " + result.getString(3));
			}// while customers ComboBox
			
			result = state.executeQuery(comboBoxQueryCars);
			while(result.next()) {
				comboBox2.addItem("ID: " + result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " Reg Num:" + result.getString(4));
			}// end while cars ComboBox
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}// end Fill ComboBox
	
	public void clear(JTextField txtF1,JTextField txtF2, JTextField txtF3) {
		txtF1.setText("");
		txtF2.setText("");
		txtF3.setText("");
	}// end clear
	
//	public void clear() {
//		firstNameTF.setText("");
//		lastNameTF.setText("");
//		addressTF.setText("");
//		
//	}// end clear
	
	public void clear() {
		//cleaning the comboBox items and then refill them
		for(int i = comboBox.getItemCount()-1;i >= 0; i--){
			comboBox.removeItemAt(i);
		}
			
		for(int i = comboBox2.getItemCount()-1;i >= 0; i--){
			comboBox2.removeItemAt(i);
		}
	}//end clear2
	
	//check if the fields are empty 
	public boolean isEmptyField(JTextField txtF1,JTextField txtF2, JTextField txtF3 ) {
		
		if(!txtF1.getText().isEmpty() & !txtF2.getText().isEmpty() & !txtF3.getText().isEmpty()) {
			return true;
		}
		else return false;
	}//end isEmptyField
	
	public boolean isEmptyField(JTextField txtF1,JTextField txtF2) {
		
		if(!txtF1.getText().isEmpty() & !txtF2.getText().isEmpty()) {
			return true;
		}
		else return false;
	}//end isEmptyField
	
	public int getID(JComboBox comboBox) {
		char[] IDnum = new char[2];
		//comboBox.getSelectedItem().toString().length();
		
		String ID = comboBox.getSelectedItem().toString();
		
		// ДА ГО ОПРАВИМ 
		ID.getChars(4, 6, IDnum, 0);
		
		return Integer.parseInt(new String(IDnum).trim());
	}//end getID
	
	class addButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnection.getConnection();
			
			switch (tabIndex) {
			case 0:
				// the mysql insert statement
				sql = "INSERT INTO CUSTOMERS(FNAME,LNAME,ADDRESS) VALUES(?,?,?)";
				try {
					if(isEmptyField(firstNameTF,lastNameTF,addressTF)) {
						// create the mysql insert the statement
						state = conn.prepareStatement(sql);
						state.setString(1, firstNameTF.getText());
						state.setString(2, lastNameTF.getText());
						state.setString(3, addressTF.getText());
					
						// execute the prepared statement
						state.executeUpdate();
						
						refreshTable(table);
						refreshTable(table2);
						refreshTable(table3);
						clear(firstNameTF,lastNameTF,addressTF);// cleaning the fields
						clear();
						FillComboBox();//filling ComboBox
					} else {
						JOptionPane.showMessageDialog(null, "Error! Empty field/s!");	
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} break;
				
			case 1:
				// the mysql insert statement
				sql = "INSERT INTO CARS(BRAND,MODEL,REG_NUM, RATE) VALUES(?,?,?,FALSE)";
				try {
					if(isEmptyField(carBrandTF,carModelTF,regNumTF)) {
						// create the mysql insert the statement
						state = conn.prepareStatement(sql);
						state.setString(1, carBrandTF.getText());
						state.setString(2, carModelTF.getText());
						state.setString(3, regNumTF.getText());
					
						// execute the prepared statement
						state.executeUpdate();
						
						refreshTable(table);
						refreshTable(table2);
						refreshTable(table3);
						clear(carBrandTF,carModelTF,regNumTF);// cleaning the fields
						clear();
						FillComboBox();//filling ComboBox
					} else {
						JOptionPane.showMessageDialog(null, "Error! Empty field/s!");	
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error! Registration number is not unique!");
					//e1.printStackTrace();
				}
				break;
				
			case 2:
				// the mysql insert statement
				sql = "INSERT INTO RENT(CUSTOMER_ID, CAR_ID, RENT_DATE, RETURN_DATE) VALUES(?,?,?,?)";
				
				try { // Май ще трябва да проверява дали и ComboBox-а е празен 
					
					if(isEmptyField(rentDateTF,returnDateTF)) {
						// create the mysql insert the statement	
						state = conn.prepareStatement(sql);
						
						state.setInt(1, getID(comboBox));
						state.setInt(2, getID(comboBox2));
						state.setString(3, rentDateTF.getText());
						state.setString(4, returnDateTF.getText());
						
						// execute the prepared statement
						state.executeUpdate();
						
						// при резервация на кола, избраният автомобил бива зает за да не може да се заема отново, докато не се върне
						// затова RATE = 1(true) 
						state = conn.prepareStatement("UPDATE CARS SET RATE = 1 WHERE CAR_ID = ?");
						state.setInt(1, getID(comboBox2));
						state.executeUpdate();
						
						refreshTable(table);
						refreshTable(table2);
						refreshTable(table3);
						clear(rentDateTF, returnDateTF, returnDateTF);// cleaning the fields
						clear();
						FillComboBox();//filling ComboBox
					} else {
						JOptionPane.showMessageDialog(null, "Error! Empty field/s!");	
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			
			default:
				break;
			}
		}//end actionPerformed
	}//end class addButtonAction
	
	class deleteButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnection.getConnection();
			
			int col = 0;
			int row;
			int id = 0;
			
			JTable tempTable = new JTable();
			
			switch (tabIndex) {
			case 0:
				row = table.getSelectedRow();
				id = (int) table.getValueAt(row, col);
				sql = "DELETE FROM CUSTOMERS WHERE CUSTOMER_ID = ? ";
				tempTable = table;
				clear(firstNameTF, lastNameTF, addressTF);
				break;
				
			case 1:
				row = table2.getSelectedRow();
				id = (int) table2.getValueAt(row, col);
				sql = "DELETE FROM CARS WHERE CAR_ID = ? ";
				tempTable = table2;
				clear(carBrandTF, carModelTF, regNumTF);
				break;
				
			case 2:
				row = table3.getSelectedRow();
				id = (int) table3.getValueAt(row, col);
				sql = "DELETE FROM RENT WHERE RENT_ID = ?";
				tempTable = table3;
				break;
			default:
				break;
			}//end switch case
			
			try { 
				//prepare the statement 
				state = conn.prepareStatement("UPDATE RENT, CARS SET CARS.Rate = 0 WHERE RENT.RENT_ID = ? AND RENT.CAR_ID = CARS.CAR_ID");
				state.setInt(1, id);
				state.executeUpdate();
				
				//prepare the statement 
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				// execute the prepared statement
				state.execute();
								
				refreshTable(tempTable);
				refreshTable(table);
				refreshTable(table2);
				refreshTable(table3);
				clear();// cleaning the fields
//				clear(firstNameTF, lastNameTF, addressTF);
				FillComboBox();//filling ComboBox
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error! Empty field/s!");
				//e1.printStackTrace();
			}
		}//end actionPerformed
	}//end of deleteButtonAction

	class updateButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int col = 0;
			int row = 0;
			
			int id = 0;
			//String sqlUpdate = null;
			JTable tempTable = new JTable();
			
			switch (tabIndex) {
			case 0:
				row = table.getSelectedRow();
				id = (int) table.getValueAt(row, col);
				
				sql = "UPDATE CUSTOMERS SET FNAME = ? , LNAME = ? , ADDRESS = ?  WHERE CUSTOMER_ID = ? ";
				try {
					if(isEmptyField(firstNameTF,lastNameTF,addressTF)) {
							
						// create the mysql insert the statement
						state = conn.prepareStatement(sql);
						state.setString(1, firstNameTF.getText());
						state.setString(2, lastNameTF.getText());
						state.setString(3, addressTF.getText());
						state.setInt(4, id);
					
						// execute the prepared statement
						state.executeUpdate();
						
						refreshTable(table);
						refreshTable(table2);
						refreshTable(table3);
						clear(firstNameTF,lastNameTF,addressTF);// cleaning the fields
						clear();
						FillComboBox();//filling ComboBox
					} else {
						JOptionPane.showMessageDialog(null, "There is an empty field!");	
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error! Too long!");	
					//e1.printStackTrace();
				} break;
				
			case 1:
				row = table2.getSelectedRow();
				id = (int) table2.getValueAt(row, col);
				
				sql = "UPDATE CARS SET BRAND = ? , MODEL = ? , REG_NUM = ?  WHERE CAR_ID = ? ";
				try {
					if(isEmptyField(carBrandTF, carModelTF, regNumTF)) {
							
						// create the mysql insert the statement
						state = conn.prepareStatement(sql);
						state.setString(1, carBrandTF.getText());
						state.setString(2, carModelTF.getText());
						state.setString(3, regNumTF.getText());
						state.setInt(4, id);
					
						// execute the prepared statement
						state.executeUpdate();
						
						refreshTable(table);
						refreshTable(table2);
						refreshTable(table3);
						clear(carBrandTF,carModelTF,regNumTF);// cleaning the fields
						clear();
						FillComboBox();//filling ComboBox
					} else {
						JOptionPane.showMessageDialog(null, "There is an empty field!");	
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error! Too long!");	
					//e1.printStackTrace();
				}
				break;
				
			case 2:
				row = table3.getSelectedRow();
				id = (int) table3.getValueAt(row, col);
				
				sql = "UPDATE RENT SET CUSTOMER_ID = ? , CAR_ID = ? , RENT_DATE = ? , RETURN_DATE = ?  WHERE RENT_ID = ? ";
				try {
					if(isEmptyField(returnDateTF,rentDateTF)) {
							
						// create the mysql insert the statement
						state = conn.prepareStatement(sql);
						state.setString(1, carBrandTF.getText());
						state.setString(2, carModelTF.getText());
						state.setString(3, regNumTF.getText());
						state.setInt(4, id);
					
						// execute the prepared statement
						state.executeUpdate();
						
						refreshTable(table);
						refreshTable(table2);
						refreshTable(table3);
						clear(carBrandTF,carModelTF,regNumTF);// cleaning the fields
						clear();
						FillComboBox();//filling ComboBox
					} else {
						JOptionPane.showMessageDialog(null, "There is an empty field!");	
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error! Too long!");	
					//e1.printStackTrace();
				}
				break;
				
			default:
				break;
				
			}
		}//end actionPerformed
		
	}//end updateButton Action
	
	class searchButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnection.getConnection();
			
			sql = "SELECT FNAME, LNAME "
					+ "FROM CUSTOMERS "
					+ "WHERE FNAME = ? AND LNAME = ?";
			
			if(isEmptyField(customerFnameTF, customerLnameTF)) {
				try {
					state = conn.prepareStatement(sql);
					state.setString(1, customerFnameTF.getText());
					state.setString(2, customerLnameTF.getText());
					
					result = state.executeQuery();
					
					table4.setModel(new MyModel(result));
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "There is an empty field!");	
			}	 
		}//end actionPerformed	
	}//end searchButtonAction
	
}// end Frame
