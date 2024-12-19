package productmanagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import productmanagement.model.dto.CarAddDTO;
import productmanagement.services.CarManager;
import productmanagement.services.impl.CarManagerImpl;
import productmanagement.utils.NumberUtils;

public class AddCarView extends JDialog{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private CarManager carManager;
	private CarAddDTO carAddDTO;
	private AdminCarView parentView;
	private JDialog frmAddCar;
	private JTextField txtAddName;
	private JTextField txtAddPrice;
	private JTextField txtAddTotal;
	private JTextField txtAddSeats;
	private JTextField txtAddColor;
	private JLabel labelAddTypeCar;
	private JLabel labelAddColor;
	private JTextField txtAddMomen;
	private JTextField txtAddWattage;
	private JTextField txtAddAirBags;
	private JTextField txtAddVersion;
	private JTextField txtAddLength;
	private JTextField txtAddHeight;
	private JTextField txtAddWidth;
	private JComboBox<Object> comboBoxAddTypeCar;
	private JTextArea txtAddDescription;

	/**
	 * Create the application.
	 */
	public AddCarView(AdminCarView parent) {
		this.parentView = parent;
		initialize();
		carManager = new CarManagerImpl();
		carAddDTO = new CarAddDTO();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddCar = new JDialog();
		frmAddCar.getContentPane().setBackground(new Color(102, 51, 204));
		frmAddCar.setTitle("Add car");
		frmAddCar.setBounds(100, 100, 550, 900);
		frmAddCar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmAddCar.getContentPane().setLayout(null);
		frmAddCar.setLocationRelativeTo(this);

		JLabel labelTitleAdd = new JLabel("Add Car");
		labelTitleAdd.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitleAdd.setForeground(new Color(255, 255, 255));
		labelTitleAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelTitleAdd.setBounds(0, 0, 535, 38);
		frmAddCar.getContentPane().add(labelTitleAdd);

		JLabel labelAddName = new JLabel("Tên xe:");
		labelAddName.setForeground(new Color(255, 255, 255));
		labelAddName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddName.setBounds(45, 49, 79, 35);
		frmAddCar.getContentPane().add(labelAddName);

		txtAddName = new JTextField();
		labelAddName.setLabelFor(txtAddName);
		txtAddName.setBounds(45, 84, 463, 35);
		frmAddCar.getContentPane().add(txtAddName);
		txtAddName.setColumns(10);

		txtAddPrice = new JTextField();
		txtAddPrice.setBounds(45, 165, 463, 35);
		frmAddCar.getContentPane().add(txtAddPrice);
		txtAddPrice.setColumns(10);

		JLabel labelAddPrice = new JLabel("Giá bán:");
		labelAddPrice.setForeground(new Color(255, 255, 255));
		labelAddPrice.setLabelFor(txtAddPrice);
		labelAddPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddPrice.setBounds(45, 130, 114, 35);
		frmAddCar.getContentPane().add(labelAddPrice);

		txtAddTotal = new JTextField();
		txtAddTotal.setColumns(10);
		txtAddTotal.setBounds(288, 245, 220, 35);
		frmAddCar.getContentPane().add(txtAddTotal);

		txtAddSeats = new JTextField();
		txtAddSeats.setColumns(10);
		txtAddSeats.setBounds(45, 245, 220, 35);
		frmAddCar.getContentPane().add(txtAddSeats);

		txtAddColor = new JTextField();
		txtAddColor.setColumns(10);
		txtAddColor.setBounds(288, 484, 220, 35);
		frmAddCar.getContentPane().add(txtAddColor);

		JLabel labelAddTotal = new JLabel("Số lượng tồn:");
		labelAddTotal.setForeground(new Color(255, 255, 255));
		labelAddTotal.setLabelFor(txtAddTotal);
		labelAddTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddTotal.setBounds(288, 211, 114, 35);
		frmAddCar.getContentPane().add(labelAddTotal);

		JLabel labelAddSeats = new JLabel("Số chỗ ngồi:");
		labelAddSeats.setForeground(new Color(255, 255, 255));
		labelAddSeats.setLabelFor(txtAddSeats);
		labelAddSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddSeats.setBounds(45, 211, 104, 35);
		frmAddCar.getContentPane().add(labelAddSeats);

		labelAddTypeCar = new JLabel("Loại xe:");
		labelAddTypeCar.setForeground(new Color(255, 255, 255));
		labelAddTypeCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddTypeCar.setBounds(45, 291, 104, 35);
		frmAddCar.getContentPane().add(labelAddTypeCar);

		labelAddColor = new JLabel("Màu sắc:");
		labelAddColor.setForeground(new Color(255, 255, 255));
		labelAddColor.setLabelFor(txtAddColor);
		labelAddColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddColor.setBounds(288, 449, 104, 35);
		frmAddCar.getContentPane().add(labelAddColor);

		JButton btnFromAddBackMain = new JButton("Cancel");
		btnFromAddBackMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnFromAddBackMain.setBackground(new Color(204, 0, 0));
		btnFromAddBackMain.setForeground(new Color(255, 255, 255));
		btnFromAddBackMain.setBounds(288, 804, 104, 35);
		frmAddCar.getContentPane().add(btnFromAddBackMain);

		JButton btnAddCar = new JButton("Add");
		btnAddCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtAddName.getText().trim();
				String seats = txtAddSeats.getText().trim();
				String price = txtAddPrice.getText().trim();
				String typeCar = (String) comboBoxAddTypeCar.getSelectedItem();
				String length = txtAddLength.getText().trim();
				String height = txtAddHeight.getText().trim();
				String width = txtAddWidth.getText().trim();
				String momen = txtAddMomen.getText().trim();
				String wattage = txtAddWattage.getText().trim();
				String description = txtAddDescription.getText().trim();
				String airBags = txtAddAirBags.getText().trim();
				String total = txtAddTotal.getText().trim();
				String version = txtAddVersion.getText().trim();
				String color = txtAddColor.getText().trim();

				if(name.isEmpty() || seats.isEmpty() || price.isEmpty() || typeCar.isEmpty() || height.isEmpty() || length.isEmpty() || width.isEmpty() || momen.isEmpty() || wattage.isEmpty() || description.isEmpty() || airBags.isEmpty() || total.isEmpty() || version.isEmpty() || color.isEmpty()) {
					JOptionPane.showMessageDialog(frmAddCar, "Không được để trống ô nhập.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(price)) {
		            JOptionPane.showMessageDialog(frmAddCar, "Giá bán phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(price))) {
					JOptionPane.showMessageDialog(frmAddCar, "Giá bán phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(length)) {
		            JOptionPane.showMessageDialog(frmAddCar, "Chiều dài ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(length))) {
					JOptionPane.showMessageDialog(frmAddCar, "Chiều dài ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(width)) {
		            JOptionPane.showMessageDialog(frmAddCar, "Chiều rộng ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(width))) {
					JOptionPane.showMessageDialog(frmAddCar, "Chiều rộng ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(height)) {
		            JOptionPane.showMessageDialog(frmAddCar, "Chiều cao ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(height))) {
					JOptionPane.showMessageDialog(frmAddCar, "Chiều cao ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(momen)) {
		            JOptionPane.showMessageDialog(frmAddCar, "Momen ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(momen))) {
					JOptionPane.showMessageDialog(frmAddCar, "Momen ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(wattage)) {
		            JOptionPane.showMessageDialog(frmAddCar, "Công suất ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(wattage))) {
					JOptionPane.showMessageDialog(frmAddCar, "Công suất ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(airBags)) {
		            JOptionPane.showMessageDialog(frmAddCar, "Số lượng túi khí phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(airBags))) {
					JOptionPane.showMessageDialog(frmAddCar, "Số lượng túi khí phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.isInteger(total)) {
					JOptionPane.showMessageDialog(frmAddCar, "Số lượng tồn phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Integer.parseInt(total))) {
					JOptionPane.showMessageDialog(frmAddCar, "Số lượng tồn phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.isInteger(seats)) {
					JOptionPane.showMessageDialog(frmAddCar, "Số chỗ ngồi phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Integer.parseInt(seats))) {
					JOptionPane.showMessageDialog(frmAddCar, "Số chỗ ngồi phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					carAddDTO.setName(name);
					carAddDTO.setNumberOfSeats(Integer.parseInt(seats));
					carAddDTO.setPrice(Double.parseDouble(price));
					carAddDTO.setTypeCar(typeCar);
					carAddDTO.setLength(Double.parseDouble(length));
					carAddDTO.setWidth(Double.parseDouble(width));
					carAddDTO.setHeight(Double.parseDouble(height));
					carAddDTO.setMomen(Double.parseDouble(momen));
					carAddDTO.setWattage(Integer.parseInt(wattage));
					carAddDTO.setDescription(description);
					carAddDTO.setNumberOfAirBag(Integer.parseInt(airBags));
					carAddDTO.setTotal(Integer.parseInt(total));
					carAddDTO.setVersion(version);
					carAddDTO.setColor(color);
					if(carManager.addCar(carAddDTO)) {
						JOptionPane.showMessageDialog(frmAddCar, "Thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frmAddCar, "Thất bại", "Error", JOptionPane.ERROR_MESSAGE);
					}
					parentView.reloadTable();
					setVisible(false);
					dispose();
				}
			}
		});
		btnAddCar.setForeground(new Color(255, 255, 255));
		btnAddCar.setBackground(new Color(0, 204, 51));
		btnAddCar.setBounds(161, 804, 104, 35);
		frmAddCar.getContentPane().add(btnAddCar);

		comboBoxAddTypeCar = new JComboBox<>();
		comboBoxAddTypeCar.setModel(new DefaultComboBoxModel<>(new String[] {"Xe xăng", "Xe điện"}));
		labelAddTypeCar.setLabelFor(comboBoxAddTypeCar);
		comboBoxAddTypeCar.setBounds(45, 326, 220, 35);
		frmAddCar.getContentPane().add(comboBoxAddTypeCar);

		JLabel labelAddMomen = new JLabel("Momen:");
		labelAddMomen.setForeground(Color.WHITE);
		labelAddMomen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddMomen.setBounds(288, 291, 114, 35);
		frmAddCar.getContentPane().add(labelAddMomen);

		txtAddMomen = new JTextField();
		labelAddMomen.setLabelFor(txtAddMomen);
		txtAddMomen.setColumns(10);
		txtAddMomen.setBounds(288, 326, 220, 35);
		frmAddCar.getContentPane().add(txtAddMomen);

		JLabel labelAddWattage = new JLabel("Công suất:");
		labelAddWattage.setForeground(Color.WHITE);
		labelAddWattage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddWattage.setBounds(45, 372, 114, 35);
		frmAddCar.getContentPane().add(labelAddWattage);

		txtAddWattage = new JTextField();
		labelAddWattage.setLabelFor(txtAddWattage);
		txtAddWattage.setColumns(10);
		txtAddWattage.setBounds(45, 403, 220, 35);
		frmAddCar.getContentPane().add(txtAddWattage);

		txtAddAirBags = new JTextField();
		txtAddAirBags.setColumns(10);
		txtAddAirBags.setBounds(288, 403, 220, 35);
		frmAddCar.getContentPane().add(txtAddAirBags);

		JLabel lblSTiKh = new JLabel("Số túi khí");
		lblSTiKh.setLabelFor(txtAddAirBags);
		lblSTiKh.setForeground(Color.WHITE);
		lblSTiKh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSTiKh.setBounds(288, 372, 114, 35);
		frmAddCar.getContentPane().add(lblSTiKh);

		JLabel labelAddVersion = new JLabel("Phiên bản:");
		labelAddVersion.setForeground(Color.WHITE);
		labelAddVersion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddVersion.setBounds(45, 449, 114, 35);
		frmAddCar.getContentPane().add(labelAddVersion);

		txtAddVersion = new JTextField();
		labelAddVersion.setLabelFor(txtAddVersion);
		txtAddVersion.setColumns(10);
		txtAddVersion.setBounds(45, 484, 220, 35);
		frmAddCar.getContentPane().add(txtAddVersion);

		txtAddLength = new JTextField();
		txtAddLength.setColumns(10);
		txtAddLength.setBounds(45, 565, 140, 35);
		frmAddCar.getContentPane().add(txtAddLength);

		txtAddHeight = new JTextField();
		txtAddHeight.setColumns(10);
		txtAddHeight.setBounds(368, 565, 140, 35);
		frmAddCar.getContentPane().add(txtAddHeight);

		txtAddWidth = new JTextField();
		txtAddWidth.setColumns(10);
		txtAddWidth.setBounds(210, 565, 140, 35);
		frmAddCar.getContentPane().add(txtAddWidth);

		JLabel labelAddLength = new JLabel("Chiều dài:");
		labelAddLength.setLabelFor(txtAddLength);
		labelAddLength.setForeground(Color.WHITE);
		labelAddLength.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddLength.setBounds(45, 530, 114, 35);
		frmAddCar.getContentPane().add(labelAddLength);

		JLabel labelAddWidth = new JLabel("Chiều rộng:");
		labelAddWidth.setLabelFor(txtAddWidth);
		labelAddWidth.setForeground(Color.WHITE);
		labelAddWidth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddWidth.setBounds(210, 530, 114, 35);
		frmAddCar.getContentPane().add(labelAddWidth);

		JLabel labelAddHeight = new JLabel("Chiều cao:");
		labelAddHeight.setLabelFor(txtAddHeight);
		labelAddHeight.setForeground(Color.WHITE);
		labelAddHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddHeight.setBounds(368, 530, 114, 35);
		frmAddCar.getContentPane().add(labelAddHeight);

		JLabel lblAddDescription = new JLabel("Mô tả:");
		lblAddDescription.setForeground(Color.WHITE);
		lblAddDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddDescription.setBounds(45, 611, 114, 35);
		frmAddCar.getContentPane().add(lblAddDescription);

		txtAddDescription = new JTextArea();
		lblAddDescription.setLabelFor(txtAddDescription);
		txtAddDescription.setBounds(45, 644, 463, 125);
		frmAddCar.getContentPane().add(txtAddDescription);
	}

	@Override
	public void setVisible(boolean b) {
		frmAddCar.setVisible(b);
	}
}
