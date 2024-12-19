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
import productmanagement.model.entity.Car;
import productmanagement.services.CarManager;
import productmanagement.services.impl.CarManagerImpl;
import productmanagement.utils.NumberUtils;

public class EditCarView extends JDialog {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private CarManager carManager;
	private CarAddDTO carAddDTO;
	private AdminCarView parentView;
	private int carId;
	private JDialog frmEditCar;
	private JTextField txtEditName;
	private JTextField txtEditPrice;
	private JTextField txtEditTotal;
	private JTextField txtEditSeats;
	private JTextField txtEditColor;
	private JLabel labelEditTypeCar;
	private JLabel labelEditColor;
	private JTextField txtEditMomen;
	private JTextField txtEditWattage;
	private JTextField txtEditAirBags;
	private JTextField txtEditVersion;
	private JTextField txtEditLength;
	private JTextField txtEditHeight;
	private JTextField txtEditWidth;
	private JComboBox<Object> comboBoxEditTypeCar;
	private JTextArea txtEditDescription;

	/**
	 * Create the application.
	 */
	public EditCarView(AdminCarView parent) {
		this.parentView = parent;
		initialize();
		carManager = new CarManagerImpl();
		carAddDTO = new CarAddDTO();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditCar = new JDialog();
		frmEditCar.getContentPane().setBackground(new Color(102, 51, 204));
		frmEditCar.setTitle("Edit car");
		frmEditCar.setBounds(100, 100, 551, 900);
		frmEditCar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmEditCar.getContentPane().setLayout(null);
		frmEditCar.setLocationRelativeTo(null);

		JLabel labelTitleEdit = new JLabel("Edit Car");
		labelTitleEdit.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitleEdit.setForeground(new Color(255, 255, 255));
		labelTitleEdit.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelTitleEdit.setBounds(0, 0, 535, 38);
		frmEditCar.getContentPane().add(labelTitleEdit);

		JLabel labelEditName = new JLabel("Tên xe:");
		labelEditName.setForeground(new Color(255, 255, 255));
		labelEditName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditName.setBounds(45, 49, 79, 35);
		frmEditCar.getContentPane().add(labelEditName);

		txtEditName = new JTextField();
		labelEditName.setLabelFor(txtEditName);
		txtEditName.setBounds(45, 84, 463, 35);
		frmEditCar.getContentPane().add(txtEditName);
		txtEditName.setColumns(10);

		txtEditPrice = new JTextField();
		txtEditPrice.setBounds(45, 165, 463, 35);
		frmEditCar.getContentPane().add(txtEditPrice);
		txtEditPrice.setColumns(10);

		JLabel labelEditPrice = new JLabel("Giá bán:");
		labelEditPrice.setForeground(new Color(255, 255, 255));
		labelEditPrice.setLabelFor(txtEditPrice);
		labelEditPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditPrice.setBounds(45, 130, 114, 35);
		frmEditCar.getContentPane().add(labelEditPrice);

		txtEditTotal = new JTextField();
		txtEditTotal.setColumns(10);
		txtEditTotal.setBounds(288, 245, 220, 35);
		frmEditCar.getContentPane().add(txtEditTotal);

		txtEditSeats = new JTextField();
		txtEditSeats.setColumns(10);
		txtEditSeats.setBounds(45, 245, 220, 35);
		frmEditCar.getContentPane().add(txtEditSeats);

		txtEditColor = new JTextField();
		txtEditColor.setColumns(10);
		txtEditColor.setBounds(288, 484, 220, 35);
		frmEditCar.getContentPane().add(txtEditColor);

		JLabel labelEditTotal = new JLabel("Số lượng tồn:");
		labelEditTotal.setForeground(new Color(255, 255, 255));
		labelEditTotal.setLabelFor(txtEditTotal);
		labelEditTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditTotal.setBounds(288, 211, 114, 35);
		frmEditCar.getContentPane().add(labelEditTotal);

		JLabel labelEditSeats = new JLabel("Số chỗ ngồi:");
		labelEditSeats.setForeground(new Color(255, 255, 255));
		labelEditSeats.setLabelFor(txtEditSeats);
		labelEditSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditSeats.setBounds(45, 211, 104, 35);
		frmEditCar.getContentPane().add(labelEditSeats);

		labelEditTypeCar = new JLabel("Loại xe:");
		labelEditTypeCar.setForeground(new Color(255, 255, 255));
		labelEditTypeCar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditTypeCar.setBounds(45, 291, 104, 35);
		frmEditCar.getContentPane().add(labelEditTypeCar);

		labelEditColor = new JLabel("Màu sắc:");
		labelEditColor.setForeground(new Color(255, 255, 255));
		labelEditColor.setLabelFor(txtEditColor);
		labelEditColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditColor.setBounds(288, 449, 104, 35);
		frmEditCar.getContentPane().add(labelEditColor);

		JButton btnFromEditBackMain = new JButton("Cancel");
		btnFromEditBackMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnFromEditBackMain.setBackground(new Color(204, 0, 0));
		btnFromEditBackMain.setForeground(new Color(255, 255, 255));
		btnFromEditBackMain.setBounds(288, 804, 104, 35);
		frmEditCar.getContentPane().add(btnFromEditBackMain);

		JButton btnEditCar = new JButton("Chỉnh sửa");
		btnEditCar.setToolTipText("Chỉnh sửa");
		btnEditCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtEditName.getText().trim();
				String seats = txtEditSeats.getText().trim();
				String price = txtEditPrice.getText().trim();
				String typeCar = (String) comboBoxEditTypeCar.getSelectedItem();
				String length = txtEditLength.getText().trim();
				String height = txtEditHeight.getText().trim();
				String width = txtEditWidth.getText().trim();
				String momen = txtEditMomen.getText().trim();
				String wattage = txtEditWattage.getText().trim();
				String description = txtEditDescription.getText().trim();
				String airBags = txtEditAirBags.getText().trim();
				String total = txtEditTotal.getText().trim();
				String version = txtEditVersion.getText().trim();
				String color = txtEditColor.getText().trim();

				if(name.isEmpty() || seats.isEmpty() || price.isEmpty() || typeCar.isEmpty() || height.isEmpty() || length.isEmpty() || width.isEmpty() || momen.isEmpty() || wattage.isEmpty() || description.isEmpty() || airBags.isEmpty() || total.isEmpty() || version.isEmpty() || color.isEmpty()) {
					JOptionPane.showMessageDialog(frmEditCar, "Không được để trống ô nhập.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(price)) {
		            JOptionPane.showMessageDialog(frmEditCar, "Giá bán phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(price))) {
					JOptionPane.showMessageDialog(frmEditCar, "Giá bán phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(length)) {
		            JOptionPane.showMessageDialog(frmEditCar, "Chiều dài ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(length))) {
					JOptionPane.showMessageDialog(frmEditCar, "Chiều dài ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(width)) {
		            JOptionPane.showMessageDialog(frmEditCar, "Chiều rộng ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(width))) {
					JOptionPane.showMessageDialog(frmEditCar, "Chiều rộng ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(height)) {
		            JOptionPane.showMessageDialog(frmEditCar, "Chiều cao ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(height))) {
					JOptionPane.showMessageDialog(frmEditCar, "Chiều cao ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(momen)) {
		            JOptionPane.showMessageDialog(frmEditCar, "Momen ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(momen))) {
					JOptionPane.showMessageDialog(frmEditCar, "Momen ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(wattage)) {
		            JOptionPane.showMessageDialog(frmEditCar, "Công suất ô tô phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(wattage))) {
					JOptionPane.showMessageDialog(frmEditCar, "Công suất ô tô phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(airBags)) {
		            JOptionPane.showMessageDialog(frmEditCar, "Số lượng túi khí phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(airBags))) {
					JOptionPane.showMessageDialog(frmEditCar, "Số lượng túi khí phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.isInteger(total)) {
					JOptionPane.showMessageDialog(frmEditCar, "Số lượng tồn phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Integer.parseInt(total))) {
					JOptionPane.showMessageDialog(frmEditCar, "Số lượng tồn phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.isInteger(seats)) {
					JOptionPane.showMessageDialog(frmEditCar, "Số chỗ ngồi phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Integer.parseInt(seats))) {
					JOptionPane.showMessageDialog(frmEditCar, "Số chỗ ngồi phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					carAddDTO.setId(carId);
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
					if(carManager.editCar(carAddDTO)) {
						JOptionPane.showMessageDialog(frmEditCar, "Thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frmEditCar, "Thất bại", "Error", JOptionPane.ERROR_MESSAGE);
					}
					parentView.reloadTable();
					setVisible(false);
					dispose();
				}
			}
		});
		btnEditCar.setForeground(new Color(255, 255, 255));
		btnEditCar.setBackground(new Color(51, 102, 204));
		btnEditCar.setBounds(161, 804, 104, 35);
		frmEditCar.getContentPane().add(btnEditCar);

		comboBoxEditTypeCar = new JComboBox<>();
		comboBoxEditTypeCar.setModel(new DefaultComboBoxModel<>(new String[] {"Xe xăng", "Xe điện"}));
		labelEditTypeCar.setLabelFor(comboBoxEditTypeCar);
		comboBoxEditTypeCar.setBounds(45, 326, 220, 35);
		frmEditCar.getContentPane().add(comboBoxEditTypeCar);

		JLabel labelEditMomen = new JLabel("Momen:");
		labelEditMomen.setForeground(Color.WHITE);
		labelEditMomen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditMomen.setBounds(288, 291, 114, 35);
		frmEditCar.getContentPane().add(labelEditMomen);

		txtEditMomen = new JTextField();
		labelEditMomen.setLabelFor(txtEditMomen);
		txtEditMomen.setColumns(10);
		txtEditMomen.setBounds(288, 326, 220, 35);
		frmEditCar.getContentPane().add(txtEditMomen);

		JLabel labelEditWattage = new JLabel("Công suất:");
		labelEditWattage.setForeground(Color.WHITE);
		labelEditWattage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditWattage.setBounds(45, 372, 114, 35);
		frmEditCar.getContentPane().add(labelEditWattage);

		txtEditWattage = new JTextField();
		labelEditWattage.setLabelFor(txtEditWattage);
		txtEditWattage.setColumns(10);
		txtEditWattage.setBounds(45, 403, 220, 35);
		frmEditCar.getContentPane().add(txtEditWattage);

		txtEditAirBags = new JTextField();
		txtEditAirBags.setColumns(10);
		txtEditAirBags.setBounds(288, 403, 220, 35);
		frmEditCar.getContentPane().add(txtEditAirBags);

		JLabel lblSTiKh = new JLabel("Số túi khí");
		lblSTiKh.setLabelFor(txtEditAirBags);
		lblSTiKh.setForeground(Color.WHITE);
		lblSTiKh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSTiKh.setBounds(288, 372, 114, 35);
		frmEditCar.getContentPane().add(lblSTiKh);

		JLabel labelEditVersion = new JLabel("Phiên bản:");
		labelEditVersion.setForeground(Color.WHITE);
		labelEditVersion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditVersion.setBounds(45, 449, 114, 35);
		frmEditCar.getContentPane().add(labelEditVersion);

		txtEditVersion = new JTextField();
		labelEditVersion.setLabelFor(txtEditVersion);
		txtEditVersion.setColumns(10);
		txtEditVersion.setBounds(45, 484, 220, 35);
		frmEditCar.getContentPane().add(txtEditVersion);

		txtEditLength = new JTextField();
		txtEditLength.setColumns(10);
		txtEditLength.setBounds(45, 565, 140, 35);
		frmEditCar.getContentPane().add(txtEditLength);

		txtEditHeight = new JTextField();
		txtEditHeight.setColumns(10);
		txtEditHeight.setBounds(368, 565, 140, 35);
		frmEditCar.getContentPane().add(txtEditHeight);

		txtEditWidth = new JTextField();
		txtEditWidth.setColumns(10);
		txtEditWidth.setBounds(210, 565, 140, 35);
		frmEditCar.getContentPane().add(txtEditWidth);

		JLabel labelEditLength = new JLabel("Chiều dài:");
		labelEditLength.setLabelFor(txtEditLength);
		labelEditLength.setForeground(Color.WHITE);
		labelEditLength.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditLength.setBounds(45, 530, 114, 35);
		frmEditCar.getContentPane().add(labelEditLength);

		JLabel labelEditWidth = new JLabel("Chiều rộng:");
		labelEditWidth.setLabelFor(txtEditWidth);
		labelEditWidth.setForeground(Color.WHITE);
		labelEditWidth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditWidth.setBounds(210, 530, 114, 35);
		frmEditCar.getContentPane().add(labelEditWidth);

		JLabel labelEditHeight = new JLabel("Chiều cao:");
		labelEditHeight.setLabelFor(txtEditHeight);
		labelEditHeight.setForeground(Color.WHITE);
		labelEditHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelEditHeight.setBounds(368, 530, 114, 35);
		frmEditCar.getContentPane().add(labelEditHeight);

		JLabel lblEditDescription = new JLabel("Mô tả:");
		lblEditDescription.setForeground(Color.WHITE);
		lblEditDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEditDescription.setBounds(45, 611, 114, 35);
		frmEditCar.getContentPane().add(lblEditDescription);

		txtEditDescription = new JTextArea();
		lblEditDescription.setLabelFor(txtEditDescription);
		txtEditDescription.setBounds(45, 644, 463, 125);
		frmEditCar.getContentPane().add(txtEditDescription);
	}

	@Override
	public void setVisible(boolean b) {
		frmEditCar.setVisible(b);
	}

	public void getCar(Car carSelected) {
		txtEditName.setText(carSelected.getName());
		txtEditSeats.setText(String.valueOf(carSelected.getNumberOfSeats()));
		txtEditPrice.setText(String.valueOf(carSelected.getPrice()));
		switch (carSelected.getTypeCar()) {
			case "Xe xăng": {
				comboBoxEditTypeCar.setSelectedIndex(0);
				break;
			}
			case "Xe điện": {
				comboBoxEditTypeCar.setSelectedIndex(1);
				break;
			}
		}
		String[] parts = carSelected.getSize().split("-");
		txtEditLength.setText(parts[0]);
		txtEditWidth.setText(parts[1]);
		txtEditHeight.setText(parts[2]);
		txtEditMomen.setText(String.valueOf(carSelected.getMomen()));
		txtEditWattage.setText(String.valueOf(carSelected.getWattage()));
		txtEditDescription.setText(carSelected.getDescription());
		txtEditAirBags.setText(String.valueOf(carSelected.getNumberOfAirBag()));
		txtEditTotal.setText(String.valueOf(carSelected.getTotal()));
		txtEditVersion.setText(carSelected.getVersion());
		txtEditColor.setText(carSelected.getColor());
		carId = carSelected.getId();
	}
}
