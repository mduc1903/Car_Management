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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import productmanagement.SystemConstant;
import productmanagement.model.entity.User;
import productmanagement.services.UserService;
import productmanagement.services.impl.UserServiceImpl;
import productmanagement.utils.CipherUtils;

public class AddUserView extends JDialog {

	private static final long serialVersionUID = 1L;
	private UserService userService;
	private AdminUserView parentView;
	private JDialog frmAddUser;
	private JTextField txtAddFullName;
	private JTextField txtAddGmail;
	private JTextField txtAddPhoneNumber;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddUserView(AdminUserView parent) {
		setResizable(false);
		getContentPane().setBackground(new Color(102, 51, 204));
		userService = new UserServiceImpl();
		this.parentView = parent;

		frmAddUser = new JDialog();
		getContentPane().setBackground(new Color(102, 51, 204));
		setTitle("Add User");
		setBounds(100, 100, 450, 500);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(parentView);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Thêm người dùng");
		lblNewLabel.setToolTipText("Thêm người dùng");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 40);
		getContentPane().add(lblNewLabel);

		JLabel labelAddFullName = new JLabel("Họ và tên:");
		labelAddFullName.setForeground(Color.WHITE);
		labelAddFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddFullName.setBounds(10, 39, 79, 35);
		getContentPane().add(labelAddFullName);

		txtAddFullName = new JTextField();
		txtAddFullName.setToolTipText("Nhập họ và tên");
		txtAddFullName.setColumns(10);
		txtAddFullName.setBounds(10, 74, 414, 35);
		getContentPane().add(txtAddFullName);

		JLabel labelAddGmail = new JLabel("Gmail:");
		labelAddGmail.setForeground(Color.WHITE);
		labelAddGmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddGmail.setBounds(10, 120, 79, 35);
		getContentPane().add(labelAddGmail);

		JLabel labelAddPhoneNumber = new JLabel("Số điện thoại:");
		labelAddPhoneNumber.setForeground(Color.WHITE);
		labelAddPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddPhoneNumber.setBounds(10, 203, 127, 35);
		getContentPane().add(labelAddPhoneNumber);

		JLabel labelAddRole = new JLabel("Quyền hạn:");
		labelAddRole.setForeground(Color.WHITE);
		labelAddRole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAddRole.setBounds(10, 283, 91, 35);
		getContentPane().add(labelAddRole);

		txtAddGmail = new JTextField();
		txtAddGmail.setToolTipText("Nhập gmail");
		txtAddGmail.setColumns(10);
		txtAddGmail.setBounds(10, 157, 414, 35);
		getContentPane().add(txtAddGmail);

		txtAddPhoneNumber = new JTextField();
		txtAddPhoneNumber.setToolTipText("Nhập số điện thoại");
		txtAddPhoneNumber.setColumns(10);
		txtAddPhoneNumber.setBounds(10, 237, 414, 35);
		getContentPane().add(txtAddPhoneNumber);

		JComboBox<?> comboBoxAddRole = new JComboBox();
		comboBoxAddRole.setModel(new DefaultComboBoxModel(new String[] { "Quản trị viên", "Người dùng" }));
		comboBoxAddRole.setBounds(10, 318, 414, 35);
		getContentPane().add(comboBoxAddRole);

		JButton btnAddUser = new JButton("Thêm");
		btnAddUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fullName = txtAddFullName.getText().trim();
				String gmail = txtAddGmail.getText().trim();
				String phoneNumber = txtAddPhoneNumber.getText().trim();
				int status = SystemConstant.getDefaultStatus();
				byte[] key = CipherUtils.hexStringToByteArray(SystemConstant.getHexkey());
				String password = CipherUtils.encrypt(SystemConstant.getDefaultPassword(), key);
				System.out.println(password);
				int index = comboBoxAddRole.getSelectedIndex();
				System.out.println(index);
				int roleId = 1;
				switch (index) {
					case 0: {
						roleId = 1;
						break;
					}
					case 1: {
						roleId = 2;
						break;
					}
				}
				if(fullName.isEmpty() || gmail.isEmpty() || phoneNumber.isEmpty()) {
					JOptionPane.showMessageDialog(frmAddUser, "Không được để trống ô nhập.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					User user = new User();
					user.setFullName(fullName);
					user.setGmail(gmail);
					user.setPhoneNumber(phoneNumber);
					user.setPassword(password);
					user.setStatus(status);
					user.setRoleId(roleId);
					if(userService.addUser(user)) {
						JOptionPane.showMessageDialog(frmAddUser, "Thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frmAddUser, "Thất bại", "Error", JOptionPane.ERROR_MESSAGE);
					}
					parentView.reloadTableActive();
					setVisible(false);
					dispose();
				}
			}
		});
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddUser.setToolTipText("Thêm người dùng");
		btnAddUser.setBackground(new Color(51, 102, 204));
		btnAddUser.setForeground(new Color(255, 255, 255));
		btnAddUser.setBounds(114, 388, 89, 35);
		getContentPane().add(btnAddUser);

		JButton btnBackToMain = new JButton("Quay lại");
		btnBackToMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnBackToMain.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBackToMain.setForeground(new Color(255, 255, 255));
		btnBackToMain.setBackground(new Color(204, 0, 0));
		btnBackToMain.setBounds(230, 388, 89, 35);
		getContentPane().add(btnBackToMain);
	}
}
