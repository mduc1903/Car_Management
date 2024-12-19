package productmanagement.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import productmanagement.model.entity.Car;
import productmanagement.services.CarManager;
import productmanagement.services.impl.CarManagerImpl;

public class ClientCompareCarView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CarManager carManager;
	private JComboBox<String> CarComboBox1;
	private JComboBox<String> CarComboBox2;
	private JTable compareTable;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ClientCompareCarView() {
		try {
			carManager = new CarManagerImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}

		setTitle("So sánh xe");
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 831, 619);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("So sánh xe ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(46, 139, 87));
		lblNewLabel.setFont(new Font("SVN-Agency FB", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 10, 815, 43);
		contentPane.add(lblNewLabel);

		CarComboBox1 = new JComboBox();

		CarComboBox1.setBackground(new Color(240, 255, 240));
		CarComboBox1.setFont(new Font("SVN-Agency FB", Font.PLAIN, 16));
		CarComboBox1.setBounds(93, 81, 197, 29);
		contentPane.add(CarComboBox1);

		CarComboBox2 = new JComboBox();
		CarComboBox2.setBackground(new Color(240, 255, 240));
		CarComboBox2.setFont(new Font("SVN-Agency FB", Font.PLAIN, 16));
		CarComboBox2.setBounds(495, 81, 197, 29);
		contentPane.add(CarComboBox2);

		// Thêm tên xe vào các combobox
		carManager.loadCarNamesToComboBox(CarComboBox1);
		carManager.loadCarNamesToComboBox(CarComboBox2);

		CarComboBox1.setSelectedIndex(-1);
		CarComboBox2.setSelectedIndex(-1);

		// Combobox1
		CarComboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});

		// Combobox2
		CarComboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});

		JButton btnTurnBack = new JButton("Quay lại");
		btnTurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientMainView mainView = new ClientMainView();
				mainView.setVisible(true);
				dispose();
			}
		});
		btnTurnBack.setFont(new Font("SVN-Agency FB", Font.BOLD, 16));
		btnTurnBack.setBounds(24, 548, 128, 21);
		contentPane.add(btnTurnBack);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(62, 148, 685, 368);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		compareTable = new JTable();
		compareTable.setEnabled(false);
		compareTable.setBackground(new Color(245, 255, 250));
		compareTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		compareTable.setRowSelectionAllowed(false);
		compareTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JScrollPane scrollPane = new JScrollPane(compareTable); // Add table to scroll pane
		panel.add(scrollPane, BorderLayout.CENTER); // Add scroll pane to panel

		// Căn giữa các trường dữ liệu trong bảng
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		compareTable.setDefaultRenderer(Object.class, centerRenderer);
		compareTable.setRowHeight(30); // Giãn khoảng cách giữa các dòng
	}

	private void updateTable() {
		String selectedCarName1 = (String) CarComboBox1.getSelectedItem();
		String selectedCarName2 = (String) CarComboBox2.getSelectedItem();

		if (selectedCarName1 == null || selectedCarName2 == null) {
			return; // Chỉ hiển thị bảng khi cả hai combobox đã được chọn
		}

		Car car1 = carManager.getCarByName(selectedCarName1);
		Car car2 = carManager.getCarByName(selectedCarName2);

		String[][] data = {
				{ "Số chỗ ngồi", car1 != null ? String.valueOf(car1.getNumberOfSeats()) : "",
						car2 != null ? String.valueOf(car2.getNumberOfSeats()) : "" },
				{ "Giá bán", car1 != null ? String.valueOf(car1.getPrice()) : "",
						car2 != null ? String.valueOf(car2.getPrice()) : "" },
				{ "Momen", car1 != null ? String.valueOf(car1.getMomen()) : "",
						car2 != null ? String.valueOf(car2.getMomen()) : "" },
				{ "Công suất", car1 != null ? String.valueOf(car1.getWattage()) : "",
						car2 != null ? String.valueOf(car2.getWattage()) : "" },
				{ "Số túi khí", car1 != null ? String.valueOf(car1.getNumberOfAirBag()) : "",
						car2 != null ? String.valueOf(car2.getNumberOfAirBag()) : "" },
				{ "Số lượng còn lại", car1 != null ? String.valueOf(car1.getTotal()) : "",
						car2 != null ? String.valueOf(car2.getTotal()) : "" },
				{ "Phiên bản", car1 != null ? car1.getVersion() : "", car2 != null ? car2.getVersion() : "" } };

		String[] columnNames = { "Attribute", car1.getName(), car2.getName() };
		compareTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
	}
}
