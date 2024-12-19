package productmanagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import productmanagement.model.entity.Car;

public class ClientCarInfoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel cpCarInfo;
	private JTextField txtName;
	private JTextField txtSeats;
	private JTextField txtPrice;
	private JTextField txtMomen;
	private JTextField txtWattage;
	private JTextField txtAirBags;
	private JTextField txtTotal;
	private JTextField txtVersion;
	private JTextField txtDescription;

	/**
	 * Create the frame.
	 */
	public ClientCarInfoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 489);
		cpCarInfo = new JPanel();
		cpCarInfo.setBackground(new Color(204, 255, 204));
		cpCarInfo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(cpCarInfo);
		cpCarInfo.setLayout(null);
		
		JLabel lblTitle = new JLabel("Xem thông tin chi tiết xe");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTitle.setBounds(104, 21, 360, 38);
		cpCarInfo.add(lblTitle);
		
		JButton btnTurnBack = new JButton("Quay lại");
		btnTurnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientCarView carView = new ClientCarView();
				carView.setVisible(true);
				dispose();
			}
		});
		btnTurnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTurnBack.setBounds(21, 401, 116, 32);
		cpCarInfo.add(btnTurnBack);
		
		JLabel lblName = new JLabel("Tên xe:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(10, 73, 99, 32);
		cpCarInfo.add(lblName);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		lblName.setLabelFor(txtName);
		txtName.setBounds(114, 73, 151, 32);
		cpCarInfo.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNumberOfSeats = new JLabel("Số chỗ ngồi:");
		lblNumberOfSeats.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfSeats.setBounds(10, 116, 99, 32);
		cpCarInfo.add(lblNumberOfSeats);
		
		txtSeats = new JTextField();
		txtSeats.setEditable(false);
		lblNumberOfSeats.setLabelFor(txtSeats);
		txtSeats.setColumns(10);
		txtSeats.setBounds(114, 116, 151, 32);
		cpCarInfo.add(txtSeats);
		
		JLabel lblPrice = new JLabel("Giá bán:");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(10, 159, 99, 32);
		cpCarInfo.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		lblPrice.setLabelFor(txtPrice);
		txtPrice.setColumns(10);
		txtPrice.setBounds(114, 159, 151, 32);
		cpCarInfo.add(txtPrice);
		
		JLabel lblMomen = new JLabel("Momen:");
		lblMomen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMomen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMomen.setBounds(10, 202, 99, 32);
		cpCarInfo.add(lblMomen);
		
		txtMomen = new JTextField();
		txtMomen.setEditable(false);
		lblMomen.setLabelFor(txtMomen);
		txtMomen.setColumns(10);
		txtMomen.setBounds(114, 202, 151, 32);
		cpCarInfo.add(txtMomen);
		
		JLabel lblWattage = new JLabel("Công suất:");
		lblWattage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWattage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWattage.setBounds(275, 73, 93, 32);
		cpCarInfo.add(lblWattage);
		
		txtWattage = new JTextField();
		txtWattage.setEditable(false);
		lblWattage.setLabelFor(txtWattage);
		txtWattage.setColumns(10);
		txtWattage.setBounds(379, 70, 151, 32);
		cpCarInfo.add(txtWattage);
		
		JLabel lblNumberOfAirBag = new JLabel("Số túi khí:");
		lblNumberOfAirBag.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfAirBag.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfAirBag.setBounds(275, 116, 93, 32);
		cpCarInfo.add(lblNumberOfAirBag);
		
		txtAirBags = new JTextField();
		txtAirBags.setEditable(false);
		lblNumberOfAirBag.setLabelFor(txtAirBags);
		txtAirBags.setColumns(10);
		txtAirBags.setBounds(379, 116, 151, 32);
		cpCarInfo.add(txtAirBags);
		
		JLabel lblTotal = new JLabel("Số lượng tồn:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(275, 159, 93, 32);
		cpCarInfo.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		lblTotal.setLabelFor(txtTotal);
		txtTotal.setColumns(10);
		txtTotal.setBounds(379, 159, 151, 32);
		cpCarInfo.add(txtTotal);
		
		JLabel lblVersion = new JLabel("Phiên bản:");
		lblVersion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVersion.setBounds(275, 202, 93, 32);
		cpCarInfo.add(lblVersion);
		
		txtVersion = new JTextField();
		txtVersion.setEditable(false);
		lblVersion.setLabelFor(txtVersion);
		txtVersion.setColumns(10);
		txtVersion.setBounds(379, 202, 151, 32);
		cpCarInfo.add(txtVersion);
		
		JLabel lblDescription = new JLabel("Mô tả:");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setBounds(20, 245, 87, 32);
		cpCarInfo.add(lblDescription);
		
		txtDescription = new JTextField();
		txtDescription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescription.setEditable(false);
		lblDescription.setLabelFor(txtDescription);
		txtDescription.setColumns(10);
		txtDescription.setBounds(66, 280, 464, 110);
		cpCarInfo.add(txtDescription);
	}
	public void getCar(Car carSelected) {
		txtName.setText(carSelected.getName());
		txtSeats.setText(String.valueOf(carSelected.getNumberOfSeats()));
		txtPrice.setText(String.valueOf(carSelected.getPrice()));
		txtMomen.setText(String.valueOf(carSelected.getMomen()));
		txtWattage.setText(String.valueOf(carSelected.getWattage()));
		txtAirBags.setText(String.valueOf(carSelected.getNumberOfAirBag()));
		txtTotal.setText(String.valueOf(carSelected.getTotal()));
		txtVersion.setText(carSelected.getVersion());
		txtDescription.setText(carSelected.getDescription());
	}

}
