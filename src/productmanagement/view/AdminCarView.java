package productmanagement.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import productmanagement.model.dto.CarSearchDTO;
import productmanagement.model.entity.Car;
import productmanagement.services.CarManager;
import productmanagement.services.impl.CarManagerImpl;
import productmanagement.utils.NumberUtils;

public class AdminCarView extends JPanel{

	private static final long serialVersionUID = 1L;
	private CarManager carManager = new CarManagerImpl();

	private JPanel panelSearchCar;
	private JPanel panelSearchCarTitle;
	private JLabel lblNewLabel, lblSortCar;
	private JLabel lblSearchNameCar, lblSearchTypeCar, lblSearchColorCar, lblSearchMinPriceCar, lblSearchMaxPriceCar, lblSearchMinSeatsCar, lblSearchMaxSeatsCar;
	private JTextField txtSearchNameCar;
	private JTextField txtSearchColorCar;
	private JTextField txtSearchMinPriceCar;
	private JTextField txtSearchMaxPriceCar;
	private JTextField txtSearchMinSeatsCar;
	private JTextField txtSearchMaxSeatsCar;
	private JTable carTable;
	private JButton btnSearchCar, btnDeleteCar, btnResetForm, btnAddCar, btnUpdateCar;
	private JScrollPane scrollPane;
	private JComboBox<?> comboBoxSortCar;
	private DefaultTableModel tableModel;
	private JComboBox<Object> comboBoxSearchTypeCar;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdminCarView() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		panelSearchCar = new JPanel();
		panelSearchCar.setBackground(new Color(255, 255, 255));
		panelSearchCar.setBorder(new LineBorder(new Color(102, 51, 204)));
		panelSearchCar.setBounds(31, 0, 1058, 338);
		add(panelSearchCar);
		panelSearchCar.setLayout(null);

		panelSearchCarTitle = new JPanel();
		panelSearchCarTitle.setBackground(new Color(102, 51, 204));
		panelSearchCarTitle.setBounds(0, 0, 1057, 50);
		panelSearchCar.add(panelSearchCarTitle);
		panelSearchCarTitle.setLayout(null);

		lblNewLabel = new JLabel("Quản lý ô tô");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(405, 11, 268, 28);
		panelSearchCarTitle.add(lblNewLabel);

		lblSearchNameCar = new JLabel("Tên xe");
		lblSearchNameCar.setForeground(new Color(102, 51, 204));
		lblSearchNameCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchNameCar.setBounds(10, 61, 81, 25);
		panelSearchCar.add(lblSearchNameCar);

		lblSearchTypeCar = new JLabel("Loại xe");
		lblSearchTypeCar.setForeground(new Color(102, 51, 204));
		lblSearchTypeCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchTypeCar.setBounds(414, 61, 81, 25);
		panelSearchCar.add(lblSearchTypeCar);

		lblSearchColorCar = new JLabel("Màu sắc");
		lblSearchColorCar.setForeground(new Color(102, 51, 204));
		lblSearchColorCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchColorCar.setBounds(793, 61, 81, 25);
		panelSearchCar.add(lblSearchColorCar);

		txtSearchNameCar = new JTextField();
		lblSearchNameCar.setLabelFor(txtSearchNameCar);
		txtSearchNameCar.setBounds(10, 97, 250, 35);
		panelSearchCar.add(txtSearchNameCar);
		txtSearchNameCar.setColumns(10);

		txtSearchColorCar = new JTextField();
		lblSearchColorCar.setLabelFor(txtSearchColorCar);
		txtSearchColorCar.setColumns(10);
		txtSearchColorCar.setBounds(793, 97, 250, 35);
		panelSearchCar.add(txtSearchColorCar);

		lblSearchMinPriceCar = new JLabel("Giá thấp nhất");
		lblSearchMinPriceCar.setForeground(new Color(102, 51, 204));
		lblSearchMinPriceCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchMinPriceCar.setBounds(10, 162, 156, 25);
		panelSearchCar.add(lblSearchMinPriceCar);

		lblSearchMaxPriceCar = new JLabel("Giá cao nhất");
		lblSearchMaxPriceCar.setForeground(new Color(102, 51, 204));
		lblSearchMaxPriceCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchMaxPriceCar.setBounds(275, 162, 156, 25);
		panelSearchCar.add(lblSearchMaxPriceCar);

		lblSearchMinSeatsCar = new JLabel("Số chỗ ngồi thấp nhất");
		lblSearchMinSeatsCar.setForeground(new Color(102, 51, 204));
		lblSearchMinSeatsCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchMinSeatsCar.setBounds(557, 162, 169, 25);
		panelSearchCar.add(lblSearchMinSeatsCar);

		lblSearchMaxSeatsCar = new JLabel("Số chỗ ngồi nhiều nhất");
		lblSearchMaxSeatsCar.setForeground(new Color(102, 51, 204));
		lblSearchMaxSeatsCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchMaxSeatsCar.setBounds(843, 162, 200, 25);
		panelSearchCar.add(lblSearchMaxSeatsCar);

		txtSearchMinPriceCar = new JTextField();
		lblSearchMinPriceCar.setLabelFor(txtSearchMinPriceCar);
		txtSearchMinPriceCar.setColumns(10);
		txtSearchMinPriceCar.setBounds(10, 198, 200, 35);
		panelSearchCar.add(txtSearchMinPriceCar);

		txtSearchMaxPriceCar = new JTextField();
		lblSearchMaxPriceCar.setLabelFor(txtSearchMaxPriceCar);
		txtSearchMaxPriceCar.setColumns(10);
		txtSearchMaxPriceCar.setBounds(275, 198, 200, 35);
		panelSearchCar.add(txtSearchMaxPriceCar);

		txtSearchMinSeatsCar = new JTextField();
		lblSearchMinSeatsCar.setLabelFor(txtSearchMinSeatsCar);
		txtSearchMinSeatsCar.setColumns(10);
		txtSearchMinSeatsCar.setBounds(557, 198, 200, 35);
		panelSearchCar.add(txtSearchMinSeatsCar);

		txtSearchMaxSeatsCar = new JTextField();
		lblSearchMaxSeatsCar.setLabelFor(txtSearchMaxSeatsCar);
		txtSearchMaxSeatsCar.setColumns(10);
		txtSearchMaxSeatsCar.setBounds(843, 198, 200, 35);
		panelSearchCar.add(txtSearchMaxSeatsCar);

		btnSearchCar = new JButton("Tìm kiếm");
		btnSearchCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CarSearchDTO modelSearch = new CarSearchDTO();
				String searchName = txtSearchNameCar.getText().trim();
				if (!searchName.isEmpty()) {
					modelSearch.setName(searchName);
				}

				String minPriceInput = txtSearchMinPriceCar.getText().trim();
				if (!minPriceInput.isEmpty()) {
					if (!NumberUtils.isDouble(minPriceInput)) {
						JOptionPane.showMessageDialog(panelSearchCar, "Price must be number", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Double searchMinPrice = Double.parseDouble(minPriceInput);
						if (NumberUtils.positiveNumber(searchMinPrice)) {
							modelSearch.setMinPrice(searchMinPrice);
						} else {
							JOptionPane.showMessageDialog(panelSearchCar, "Price must > 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				String maxPriceInput = txtSearchMaxPriceCar.getText().trim();
				if (!maxPriceInput.isEmpty()) {
					if (!NumberUtils.isDouble(maxPriceInput)) {
						JOptionPane.showMessageDialog(panelSearchCar, "Price must be number", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Double searchMaxPrice = Double.parseDouble(maxPriceInput);
						if (NumberUtils.positiveNumber(searchMaxPrice)) {
							modelSearch.setMaxPrice(searchMaxPrice);
						} else {
							JOptionPane.showMessageDialog(panelSearchCar, "Price must > 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				String minSeatsInput = txtSearchMinSeatsCar.getText().trim();
				if (!minSeatsInput.isEmpty()) {
					if (!NumberUtils.isDouble(minSeatsInput)) {
						JOptionPane.showMessageDialog(panelSearchCar, "Price must be number", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Integer searchMinSeats = Integer.parseInt(minSeatsInput);
						if (NumberUtils.positiveNumber(searchMinSeats)) {
							modelSearch.setMinSeats(searchMinSeats);
						} else {
							JOptionPane.showMessageDialog(panelSearchCar, "Number of seats must > 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				String maxSeatsInput = txtSearchMaxSeatsCar.getText().trim();
				if (!maxSeatsInput.isEmpty()) {
					if (!NumberUtils.isDouble(maxSeatsInput)) {
						JOptionPane.showMessageDialog(panelSearchCar, "Price must be number", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Integer searchMaxSeats = Integer.parseInt(maxSeatsInput);
						if (NumberUtils.positiveNumber(searchMaxSeats)) {
							modelSearch.setMaxSeats(searchMaxSeats);
						} else {
							JOptionPane.showMessageDialog(panelSearchCar, "Number of seats must > 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				String searchTypeCar = (String) comboBoxSearchTypeCar.getSelectedItem();
				if (!searchTypeCar.isEmpty()) {
					modelSearch.setTypeCar(searchTypeCar);
				}

				String searchColor = txtSearchColorCar.getText().trim();
				if (!searchColor.isEmpty()) {
					modelSearch.setColor(searchColor);
				}
				List<Car> searchResults = carManager.searchCar(modelSearch);
				tableModel.setRowCount(0);
				setTableData(searchResults);
			}
		});
		btnSearchCar.setToolTipText("TÌm kiếm");
		btnSearchCar.setForeground(new Color(255, 255, 255));
		btnSearchCar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearchCar.setBackground(new Color(51, 102, 204));
		btnSearchCar.setBounds(414, 272, 118, 35);
		panelSearchCar.add(btnSearchCar);

		btnResetForm = new JButton("Reset");
		btnResetForm.setToolTipText("Reset");
		btnResetForm.setForeground(new Color(255, 255, 255));
		btnResetForm.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetForm.setBackground(new Color(204, 0, 0));
		btnResetForm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtSearchColorCar.setText("");
				comboBoxSearchTypeCar.setSelectedIndex(0);
				txtSearchMaxPriceCar.setText("");
				txtSearchMaxSeatsCar.setText("");
				txtSearchMinPriceCar.setText("");
				txtSearchMinSeatsCar.setText("");
				txtSearchNameCar.setText("");
			}
		});
		btnResetForm.setBounds(546, 272, 118, 35);
		panelSearchCar.add(btnResetForm);

		comboBoxSearchTypeCar = new JComboBox<>();
		comboBoxSearchTypeCar.setModel(new DefaultComboBoxModel(new String[] {"", "Xe xăng", "Xe điện"}));
		lblSearchTypeCar.setLabelFor(comboBoxSearchTypeCar);
		comboBoxSearchTypeCar.setBounds(414, 97, 250, 35);
		panelSearchCar.add(comboBoxSearchTypeCar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 397, 1058, 283);
		add(scrollPane);

		carTable = new JTable();
		carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(carTable);
		tableModel = new DefaultTableModel();
		carTable.setModel(tableModel);

		tableModel.addColumn("ID");
		tableModel.addColumn("Tên xe");
		tableModel.addColumn("Giá");
		tableModel.addColumn("Số lượng tồn");
		tableModel.addColumn("Số chỗ ngồi");
		tableModel.addColumn("Loại xe");
		tableModel.addColumn("Màu sắc");

		setTableData(carManager.getAllCars());

		cssTable(carTable);

		btnDeleteCar = new JButton("Xóa");
		btnDeleteCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = carTable.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(carTable, "Hãy chọn ô tô để xóa", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int id = (int) carTable.getValueAt(row, 0);
					String name = (String) carTable.getValueAt(row, 1);
					int confirm = JOptionPane.showConfirmDialog(carTable, "Bạn có muốn xóa ô tô " + name + " có ID là " + id + " ?");
					if (confirm == JOptionPane.YES_OPTION) {
						if(carManager.delCar(id)) {
							JOptionPane.showMessageDialog(carTable, "Thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(carTable, "Thất bại", "Error", JOptionPane.ERROR_MESSAGE);
						}
						reloadTable();
					}
				}
			}
		});
		btnDeleteCar.setToolTipText("Xóa");
		btnDeleteCar.setForeground(Color.WHITE);
		btnDeleteCar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteCar.setBackground(new Color(204, 0, 0));
		btnDeleteCar.setBounds(971, 691, 118, 35);
		add(btnDeleteCar);

		btnUpdateCar = new JButton("Chỉnh sửa");
		btnUpdateCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = carTable.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(carTable, "Hãy chọn ô tô để chỉnh sửa", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Car carSelected = carManager.searchCarById((Integer)carTable.getValueAt(row, 0));
					System.out.println(carSelected);
					openEditCarDialog(carSelected);
				}
			}
		});
		btnUpdateCar.setToolTipText("Chỉnh sửa");
		btnUpdateCar.setForeground(Color.WHITE);
		btnUpdateCar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateCar.setBackground(new Color(51, 102, 204));
		btnUpdateCar.setBounds(823, 691, 118, 35);
		add(btnUpdateCar);

		btnAddCar = new JButton("Thêm mới");
		btnAddCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openAddCarDialog();
			}
		});
		btnAddCar.setToolTipText("Thêm mới");
		btnAddCar.setForeground(Color.WHITE);
		btnAddCar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddCar.setBackground(new Color(102, 51, 204));
		btnAddCar.setBounds(675, 691, 118, 35);
		add(btnAddCar);

		lblSortCar = new JLabel("Sắp xếp theo: ");
		lblSortCar.setForeground(new Color(102, 51, 204));
		lblSortCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSortCar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSortCar.setBounds(717, 351, 136, 35);
		add(lblSortCar);

		comboBoxSortCar = new JComboBox();
		comboBoxSortCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sortChoice = (String) comboBoxSortCar.getSelectedItem();
				switch (sortChoice) {
				case "Mặc định":
					List<Car> sortedCars = carManager.sortedCar();
					tableModel.setRowCount(0);
					setTableData(sortedCars);
					break;
				case "Giá":
					List<Car> sortedCarsByPrice = carManager.sortedCarByPrice();
					tableModel.setRowCount(0);
					setTableData(sortedCarsByPrice);
					break;
				case "Số chỗ ngồi":
					List<Car> sortedCarsByNumberOfSeats = carManager.sortedCarByNumberOfSeats();
					tableModel.setRowCount(0);
					setTableData(sortedCarsByNumberOfSeats);
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		});
		comboBoxSortCar.setForeground(new Color(102, 51, 204));
		comboBoxSortCar.setBackground(new Color(255, 255, 255));
		comboBoxSortCar.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxSortCar.setModel(new DefaultComboBoxModel(new String[] {"Mặc định", "Giá", "Số chỗ ngồi"}));
		comboBoxSortCar.setBounds(863, 351, 226, 35);
		add(comboBoxSortCar);

	}

	public void reloadTable() {
		tableModel.setRowCount(0);
		setTableData(carManager.getAllCars());
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1100, 0); // Đặt kích thước chiều rộng mặc định cho sidebar
	}

	private void setTableData(List<Car> carList) {
		carList.forEach(item -> {
			tableModel.addRow(new Object[] { item.getId(), item.getName(), item.getPrice(), item.getTotal(), item.getNumberOfSeats(), item.getTypeCar(), item.getColor()});
		});
	}

	 private void openAddCarDialog() {
		 AddCarView addCarView = new AddCarView(this);
		 addCarView.setVisible(true);
	 }

	 private void openEditCarDialog(Car carSelected) {
		 EditCarView editCarView = new EditCarView(this);
		 editCarView.setVisible(true);
		 editCarView.getCar(carSelected);
	 }

	private void cssTable(JTable carTable) {
		TableColumn column;
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < carTable.getColumnCount(); i++) {
			column = carTable.getColumnModel().getColumn(i);
			column.setCellRenderer(centerRenderer);
			switch (i) {
			case 0:
				column.setPreferredWidth(25); // ID
				break;
			case 1:
				column.setPreferredWidth(150); // Name
				break;
			case 2:
				column.setPreferredWidth(150); // Price
				break;
			case 3:
				column.setPreferredWidth(50); // Total
				break;
			case 4:
				column.setPreferredWidth(50); // Number of seats
				break;
			case 5:
				column.setPreferredWidth(150); // Manufacturer
				break;
			case 6:
				column.setPreferredWidth(70); // Color
				break;
//			case 7:
//				column.setPreferredWidth(50); // type car
			}
		}
	}
}
