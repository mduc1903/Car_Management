package productmanagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import productmanagement.model.entity.Car;
import productmanagement.services.CarManager;
import productmanagement.services.impl.CarManagerImpl;

public class ClientCarView extends JFrame {

	private static final long serialVersionUID = 1L;
	private CarManager carManager;
	private JPanel cpListCar;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ClientCarView() {
		carManager = new CarManagerImpl();

		setTitle("Danh sách xe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 493);
		cpListCar = new JPanel();
		cpListCar.setBackground(new Color(204, 255, 204));
		cpListCar.setBackground(new Color(204, 255, 204));
		setLocationRelativeTo(null);

		setContentPane(cpListCar);

		JLabel lblListCar = new JLabel("Danh sách xe");
		lblListCar.setBounds(243, 11, 214, 41);
		lblListCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblListCar.setFont(new Font("Tahoma", Font.BOLD, 26));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(table.getSelectedRow());
				table.getValueAt(table.getSelectedRow(), 0).toString();
			}
		});
		scrollPane.setBounds(33, 119, 635, 282);

		table = new JTable();
		table.setBackground(new Color(245, 255, 250));
		scrollPane.setViewportView(table);

		JButton btnDetail = new JButton("Xem chi tiết");
		btnDetail.setBounds(544, 412, 124, 30);
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(table, "Hãy chọn ô tô để xem thông tin", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Car carSelected = carManager.searchCarById((Integer) table.getValueAt(row, 0));
					System.out.println(carSelected);
					ClientCarInfoView carInfoView = new ClientCarInfoView();
					carInfoView.setVisible(true);
					carInfoView.getCar(carSelected);
					dispose();
				}
			}
		});
		btnDetail.setFont(new Font("Tahoma", Font.BOLD, 13));
		cpListCar.setLayout(null);
		cpListCar.add(lblListCar);
		cpListCar.add(scrollPane);
		cpListCar.add(btnDetail);

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(445, 63, 134, 35);
		cpListCar.add(btnSearch);

		JLabel lblSearch = new JLabel("Tìm xe:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearch.setBounds(150, 63, 73, 35);
		cpListCar.add(lblSearch);

		JPanel cpSearch = new JPanel();
		cpSearch.setBounds(233, 63, 151, 35);
		cpListCar.add(cpSearch);
		cpSearch.setLayout(null);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 0, 151, 35);
		cpSearch.add(textField);

		JButton btnTurnBack = new JButton("Quay lại");
		btnTurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientMainView mainView = new ClientMainView();
				mainView.setVisible(true);
				dispose();
			}
		});
		btnTurnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTurnBack.setBounds(33, 412, 110, 30);
		cpListCar.add(btnTurnBack);
		loadData();
	}

	private void loadData() {
		List<Car> carList = carManager.getAllCars();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Tên xe");
		model.addColumn("Số chỗ ngồi");
		model.addColumn("Giá bán");
		model.addColumn("Phiên bản");

		model.setRowCount(0);
		carList.forEach(item -> {
			model.addRow(new Object[] { item.getId(), item.getName(), item.getNumberOfSeats(), item.getPrice(),
					item.getNumberOfSeats(), item.getVersion() });
		});
		table.setModel(model);
	}
}
