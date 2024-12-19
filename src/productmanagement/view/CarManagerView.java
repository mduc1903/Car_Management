//package productmanagement.view;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumn;
//
//import productmanagement.model.dto.CarSearchDTO;
//import productmanagement.model.entity.Car;
//import productmanagement.services.CarManager;
//import productmanagement.services.impl.CarManagerImpl;
//import productmanagement.utils.NumberUtils;
//
//public class CarManagerView {
//	private CarManager carManager;
//	private JFrame frmCarManagement;
//	private JPanel panel;
//	private JLabel labelSearchName;
//	private JLabel labelSearchManufacturer;
//	private JLabel labelSearchColor;
//	private JLabel labelSearchMinPrice;
//	private JLabel labelSearchMaxPrice;
//	private JLabel labelSearchMinSeats;
//	private JTextField txtSearchName;
//	private JTextField txtSearchManufacturer;
//	private JTextField txtSearchColor;
//	private JTextField txtSearchMinPrice;
//	private JTextField txtSearchMaxPrice;
//	private JTextField txtSearchMinSeats;
//	private JTextField txtSearchMaxSeats;
//	private JLabel labelSearchMaxSeats;
//	private JButton btnReserSearchForm;
//	private JButton btnSearch;
//	private JButton btnInsertCar;
//	private JButton btnDelete;
//	private JScrollPane scrollPane;
//	private JTable carTable;
//	private JComboBox<Object> comboBoxSort;
//	private DefaultTableModel tableModel;
//	private JButton btnEditCar;
//	private JLabel labelSort;
//
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CarManagerView window = new CarManagerView();
//					window.frmCarManagement.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public CarManagerView() {
//		initialize();
//
//		tableModel.addColumn("ID");
//		tableModel.addColumn("Name");
//		tableModel.addColumn("Price");
//		tableModel.addColumn("Total");
//		tableModel.addColumn("Number of seats");
//		tableModel.addColumn("Manufacturer");
//		tableModel.addColumn("Color");
//
//		setTableData(carManager.getAllCars());
//
//		cssTable(carTable);
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frmCarManagement = new JFrame();
//		frmCarManagement.setTitle("Car Management");
//		frmCarManagement.getContentPane().setBackground(new Color(255, 255, 153));
//		frmCarManagement.setBounds(100, 100, 1068, 706);
//		frmCarManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frmCarManagement.getContentPane().setLayout(null);
//		frmCarManagement.setLocationRelativeTo(null);
//
//		panel = new JPanel();
//		panel.setBackground(new Color(255, 255, 255));
//		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		panel.setBounds(10, 23, 1032, 219);
//		frmCarManagement.getContentPane().add(panel);
//		panel.setLayout(null);
//
//		labelSearchName = new JLabel("Name");
//		labelSearchName.setBounds(22, 11, 68, 14);
//		panel.add(labelSearchName);
//
//		txtSearchName = new JTextField();
//		labelSearchName.setLabelFor(txtSearchName);
//		txtSearchName.setBounds(20, 36, 255, 31);
//		panel.add(txtSearchName);
//		txtSearchName.setColumns(10);
//
//		labelSearchManufacturer = new JLabel("Manufacturer");
//		labelSearchManufacturer.setBounds(380, 11, 99, 14);
//		panel.add(labelSearchManufacturer);
//
//		txtSearchManufacturer = new JTextField();
//		labelSearchManufacturer.setLabelFor(txtSearchManufacturer);
//		txtSearchManufacturer.setBounds(380, 36, 255, 31);
//		panel.add(txtSearchManufacturer);
//		txtSearchManufacturer.setColumns(10);
//
//		labelSearchColor = new JLabel("Color");
//		labelSearchColor.setBounds(761, 11, 110, 14);
//		panel.add(labelSearchColor);
//
//		txtSearchColor = new JTextField();
//		labelSearchColor.setLabelFor(txtSearchColor);
//		txtSearchColor.setBounds(762, 36, 238, 31);
//		panel.add(txtSearchColor);
//		txtSearchColor.setColumns(10);
//
//		labelSearchMinPrice = new JLabel("Price from");
//		labelSearchMinPrice.setBounds(22, 91, 121, 14);
//		panel.add(labelSearchMinPrice);
//
//		txtSearchMinPrice = new JTextField();
//		txtSearchMinPrice.setBounds(22, 116, 180, 31);
//		panel.add(txtSearchMinPrice);
//		txtSearchMinPrice.setColumns(10);
//
//		labelSearchMaxPrice = new JLabel("Price to");
//		labelSearchMaxPrice.setBounds(286, 91, 121, 14);
//		panel.add(labelSearchMaxPrice);
//
//		txtSearchMaxPrice = new JTextField();
//		txtSearchMaxPrice.setColumns(10);
//		txtSearchMaxPrice.setBounds(286, 116, 180, 31);
//		panel.add(txtSearchMaxPrice);
//
//		txtSearchMinSeats = new JTextField();
//		txtSearchMinSeats.setColumns(10);
//		txtSearchMinSeats.setBounds(545, 116, 180, 31);
//		panel.add(txtSearchMinSeats);
//
//		labelSearchMinSeats = new JLabel("Number of seats from");
//		labelSearchMinSeats.setBounds(545, 91, 137, 14);
//		panel.add(labelSearchMinSeats);
//
//		txtSearchMaxSeats = new JTextField();
//		txtSearchMaxSeats.setColumns(10);
//		txtSearchMaxSeats.setBounds(820, 116, 180, 31);
//		panel.add(txtSearchMaxSeats);
//
//		labelSearchMaxSeats = new JLabel("Number of seats to");
//		labelSearchMaxSeats.setBounds(820, 91, 143, 14);
//		panel.add(labelSearchMaxSeats);
//
//		btnReserSearchForm = new JButton("Reset");
//		btnReserSearchForm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				txtSearchColor.setText("");
//				txtSearchManufacturer.setText("");
//				txtSearchMaxPrice.setText("");
//				txtSearchMaxSeats.setText("");
//				txtSearchMinPrice.setText("");
//				txtSearchMinSeats.setText("");
//				txtSearchName.setText("");
//			}
//		});
//		btnReserSearchForm.setForeground(new Color(255, 255, 255));
//		btnReserSearchForm.setBackground(new Color(204, 0, 0));
//		btnReserSearchForm.setToolTipText("Reset");
//		btnReserSearchForm.setBounds(377, 172, 89, 31);
//		panel.add(btnReserSearchForm);
//
//		btnSearch = new JButton("Search");
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				CarSearchDTO modelSearch = new CarSearchDTO();
//				String searchName = txtSearchName.getText().trim();
//				if (!searchName.isEmpty()) {
//					modelSearch.setName(searchName);
//				}
//
//				String minPriceInput = txtSearchMinPrice.getText().trim();
//				if (!minPriceInput.isEmpty()) {
//					if (!NumberUtils.isDouble(minPriceInput)) {
//						JOptionPane.showMessageDialog(frmCarManagement, "Price must be number", "Error",
//								JOptionPane.ERROR_MESSAGE);
//					} else {
//						Double searchMinPrice = Double.parseDouble(minPriceInput);
//						if (NumberUtils.positiveNumber(searchMinPrice)) {
//							modelSearch.setMinPrice(searchMinPrice);
//						} else {
//							JOptionPane.showMessageDialog(frmCarManagement, "Price must > 0", "Error", JOptionPane.ERROR_MESSAGE);
//						}
//					}
//				}
//
//				String maxPriceInput = txtSearchMaxPrice.getText().trim();
//				if (!maxPriceInput.isEmpty()) {
//					if (!NumberUtils.isDouble(maxPriceInput)) {
//						JOptionPane.showMessageDialog(frmCarManagement, "Price must be number", "Error",
//								JOptionPane.ERROR_MESSAGE);
//					} else {
//						Double searchMaxPrice = Double.parseDouble(maxPriceInput);
//						if (NumberUtils.positiveNumber(searchMaxPrice)) {
//							modelSearch.setMaxPrice(searchMaxPrice);
//						} else {
//							JOptionPane.showMessageDialog(frmCarManagement, "Price must > 0", "Error", JOptionPane.ERROR_MESSAGE);
//						}
//					}
//				}
//
//				String minSeatsInput = txtSearchMinSeats.getText().trim();
//				if (!minSeatsInput.isEmpty()) {
//					if (!NumberUtils.isDouble(minSeatsInput)) {
//						JOptionPane.showMessageDialog(frmCarManagement, "Price must be number", "Error",
//								JOptionPane.ERROR_MESSAGE);
//					} else {
//						Integer searchMinSeats = Integer.parseInt(minSeatsInput);
//						if (NumberUtils.positiveNumber(searchMinSeats)) {
//							modelSearch.setMinSeats(searchMinSeats);
//						} else {
//							JOptionPane.showMessageDialog(frmCarManagement, "Number of seats must > 0", "Error", JOptionPane.ERROR_MESSAGE);
//						}
//					}
//				}
//
//				String maxSeatsInput = txtSearchMaxSeats.getText().trim();
//				if (!maxSeatsInput.isEmpty()) {
//					if (!NumberUtils.isDouble(maxSeatsInput)) {
//						JOptionPane.showMessageDialog(frmCarManagement, "Price must be number", "Error",
//								JOptionPane.ERROR_MESSAGE);
//					} else {
//						Integer searchMaxSeats = Integer.parseInt(maxSeatsInput);
//						if (NumberUtils.positiveNumber(searchMaxSeats)) {
//							modelSearch.setMaxSeats(searchMaxSeats);
//						} else {
//							JOptionPane.showMessageDialog(frmCarManagement, "Number of seats must > 0", "Error", JOptionPane.ERROR_MESSAGE);
//						}
//					}
//				}
//
//				String searchManufacturer = txtSearchManufacturer.getText().trim();
//				if (!searchManufacturer.isEmpty()) {
//					modelSearch.setManufacturer(searchManufacturer);
//				}
//
//				String searchColor = txtSearchColor.getText().trim();
//				if (!searchColor.isEmpty()) {
//					modelSearch.setColor(searchColor);
//				}
//				List<Car> searchResults = carManager.searchCar(modelSearch);
//				tableModel.setRowCount(0);
//				setTableData(searchResults);
//			}
//		});
//		btnSearch.setBackground(new Color(0, 102, 255));
//		btnSearch.setForeground(new Color(255, 255, 255));
//		btnSearch.setBounds(545, 172, 89, 31);
//		panel.add(btnSearch);
//
//		btnInsertCar = new JButton("Add");
//		btnInsertCar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new AddCarView().setVisible(true);
//				frmCarManagement.dispose();
//			}
//		});
//		btnInsertCar.setForeground(new Color(255, 255, 255));
//		btnInsertCar.setBackground(new Color(0, 204, 51));
//		btnInsertCar.setBounds(688, 597, 109, 31);
//		frmCarManagement.getContentPane().add(btnInsertCar);
//
//		btnDelete = new JButton("Delete");
//		btnDelete.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int row = carTable.getSelectedRow();
//				if (row == -1) {
//					JOptionPane.showMessageDialog(frmCarManagement, "Please choose car need delete", "Error",
//							JOptionPane.ERROR_MESSAGE);
//				} else {
//					int id = (int) carTable.getValueAt(row, 0);
//					String name = (String) carTable.getValueAt(row, 1);
//					int confirm = JOptionPane.showConfirmDialog(frmCarManagement, "Delete " + name + " with ID is " + id);
//					if (confirm == JOptionPane.YES_OPTION) {
//						carManager.delCar(id);
//						tableModel.setRowCount(0);
//						setTableData(carManager.getAllCars());
//					}
//				}
//			}
//		});
//		btnDelete.setForeground(Color.WHITE);
//		btnDelete.setBackground(new Color(204, 0, 0));
//		btnDelete.setBounds(926, 597, 116, 31);
//		frmCarManagement.getContentPane().add(btnDelete);
//
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 299, 1032, 274);
//		frmCarManagement.getContentPane().add(scrollPane);
//
//		carTable = new JTable();
//		carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		carTable.setRowHeight(30);
//		scrollPane.setViewportView(carTable);
//
//		carManager = new CarManagerImpl();
//		tableModel = new DefaultTableModel();
//		carTable.setModel(tableModel);
//
//		btnEditCar = new JButton("Edit");
//		btnEditCar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int row = carTable.getSelectedRow();
//				if (row == -1) {
//					JOptionPane.showMessageDialog(frmCarManagement, "Please choose car need edit", "Error",
//							JOptionPane.ERROR_MESSAGE);
//				} else {
//					Car carSelected = new Car();
//					carSelected.setId((Integer)carTable.getValueAt(row, 0));
//					carSelected.setName(String.valueOf(carTable.getValueAt(row, 1)));
//					carSelected.setProduct_price((Double)carTable.getValueAt(row, 2));
//					carSelected.setProduct_total((Integer)carTable.getValueAt(row, 3));
//					carSelected.setNumberOfSeats((Integer) carTable.getValueAt(row, 4));
//					carSelected.setManufacturer(String.valueOf(carTable.getValueAt(row, 5)));
//					carSelected.setColor(String.valueOf(carTable.getValueAt(row, 6)));
//					EditCarView editCarView = new EditCarView();
//					editCarView.setVisible(true);
//					editCarView.getCar(carSelected);
//					frmCarManagement.dispose();
//				}
//			}
//		});
//		btnEditCar.setForeground(Color.WHITE);
//		btnEditCar.setBackground(new Color(0, 102, 255));
//		btnEditCar.setBounds(807, 597, 109, 31);
//		frmCarManagement.getContentPane().add(btnEditCar);
//
//		labelSort = new JLabel("Sort by:");
//		labelSort.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		labelSort.setBounds(816, 253, 58, 35);
//		frmCarManagement.getContentPane().add(labelSort);
//
//		comboBoxSort = new JComboBox<Object>();
//		comboBoxSort.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String sortChoice = (String) comboBoxSort.getSelectedItem();
//				switch (sortChoice) {
//				case "Default":
//					List<Car> sortedCars = carManager.sortedCar();
//					tableModel.setRowCount(0);
//					setTableData(sortedCars);
//					break;
//				case "Price":
//					System.out.println("Sort by price:");
//					List<Car> sortedCarsByPrice = carManager.sortedCarByPrice();
//					tableModel.setRowCount(0);
//					setTableData(sortedCarsByPrice);
//					break;
//				case "Number of seats":
//					System.out.println("Sort by number of seats:");
//					List<Car> sortedCarsByNumberOfSeats = carManager.sortedCarByNumberOfSeats();
//					tableModel.setRowCount(0);
//					setTableData(sortedCarsByNumberOfSeats);
//					break;
//				default:
//					System.out.println("Invalid choice. Please try again.");
//					break;
//				}
//			}
//		});
//		labelSort.setLabelFor(comboBoxSort);
//		comboBoxSort.setBackground(new Color(255, 255, 255));
//		comboBoxSort.setModel(new DefaultComboBoxModel<Object>(new String[] { "Default", "Price", "Number of seats" }));
//		comboBoxSort.setBounds(874, 261, 154, 22);
//		frmCarManagement.getContentPane().add(comboBoxSort);
//	}
//
//	public void setVisible(boolean b) {
//		frmCarManagement.setVisible(b);
//	}
//
//	private void setTableData(List<Car> carList) {
//		carList.forEach(item -> {
//			tableModel.addRow(new Object[] { item.getProduct_id(), item.getProduct_name(), item.getProduct_price(),
//					item.getProduct_total(), item.getNumberOfSeats(), item.getManufacturer(), item.getColor() });
//		});
//	}
//
//	private void cssTable(JTable carTable) {
//		TableColumn column;
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//		for (int i = 0; i < carTable.getColumnCount(); i++) {
//			column = carTable.getColumnModel().getColumn(i);
//			column.setCellRenderer(centerRenderer);
//			switch (i) {
//			case 0:
//				column.setPreferredWidth(50); // ID
//				break;
//			case 1:
//				column.setPreferredWidth(150); // Name
//				break;
//			case 2:
//				column.setPreferredWidth(150); // Price
//				break;
//			case 3:
//				column.setPreferredWidth(100); // Total
//				break;
//			case 4:
//				column.setPreferredWidth(100); // Number of seats
//				break;
//			case 5:
//				column.setPreferredWidth(150); // Manufacturer
//				break;
//			case 6:
//				column.setPreferredWidth(150); // Color
//				break;
//			}
//		}
//	}
//}