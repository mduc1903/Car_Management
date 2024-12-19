package productmanagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import productmanagement.SystemConstant;
import productmanagement.model.entity.User;
import productmanagement.services.UserService;
import productmanagement.services.impl.UserServiceImpl;
import productmanagement.utils.CipherUtils;

public class AdminSettingsView extends JPanel {

	private static final long serialVersionUID = 1L;
	private UserService userService;
	private JTextField txtUpdateNameUser;
	private JTextField txtUpdateGmailUser;
	private JTextField txtUpdatePhoneUser;
	private JPasswordField txtUpdatePasswordUser;

	/**
	 * Create the panel.
	 */
	public AdminSettingsView(Navigate navigate, User user) {
		userService = new UserServiceImpl();
		
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(102, 51, 204)));
		panel.setBounds(29, 0, 1058, 400);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 51, 204));
		panel_1.setBounds(0, 0, 1058, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cập nhật thông tin cá nhân");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 1058, 28);
		panel_1.add(lblNewLabel);

		JLabel lblUpdateNameUser = new JLabel("Họ và tên: ");
		lblUpdateNameUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdateNameUser.setForeground(new Color(102, 51, 204));
		lblUpdateNameUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUpdateNameUser.setBounds(10, 75, 99, 35);
		panel.add(lblUpdateNameUser);

		JLabel lblUpdateGmailUser = new JLabel("Gmail:");
		lblUpdateGmailUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdateGmailUser.setForeground(new Color(102, 51, 204));
		lblUpdateGmailUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUpdateGmailUser.setBounds(10, 132, 99, 35);
		panel.add(lblUpdateGmailUser);

		JLabel lblUpdatePhoneUser = new JLabel("Số điện thoại:");
		lblUpdatePhoneUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdatePhoneUser.setForeground(new Color(102, 51, 204));
		lblUpdatePhoneUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUpdatePhoneUser.setBounds(10, 192, 99, 35);
		panel.add(lblUpdatePhoneUser);

		JLabel lblUpdatePasswordUser = new JLabel("Mật khẩu:");
		lblUpdatePasswordUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdatePasswordUser.setForeground(new Color(102, 51, 204));
		lblUpdatePasswordUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUpdatePasswordUser.setBounds(10, 255, 99, 35);
		panel.add(lblUpdatePasswordUser);

		txtUpdateNameUser = new JTextField();
		lblUpdateNameUser.setLabelFor(txtUpdateNameUser);
		txtUpdateNameUser.setBounds(119, 77, 477, 35);
		panel.add(txtUpdateNameUser);
		txtUpdateNameUser.setColumns(10);
		txtUpdateNameUser.setText(user.getFullName());

		txtUpdateGmailUser = new JTextField();
		lblUpdateGmailUser.setLabelFor(txtUpdateGmailUser);
		txtUpdateGmailUser.setColumns(10);
		txtUpdateGmailUser.setBounds(119, 134, 477, 35);
		panel.add(txtUpdateGmailUser);
		txtUpdateGmailUser.setText(user.getGmail());

		txtUpdatePhoneUser = new JTextField();
		lblUpdatePhoneUser.setLabelFor(txtUpdatePhoneUser);
		txtUpdatePhoneUser.setColumns(10);
		txtUpdatePhoneUser.setBounds(119, 194, 477, 35);
		panel.add(txtUpdatePhoneUser);
		txtUpdatePhoneUser.setText(user.getPhoneNumber());

		JButton btnUpdateUser = new JButton("Cập nhật");
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = user.getId();
				String fullName = txtUpdateNameUser.getText().trim();
				String gmail = txtUpdateGmailUser.getText().trim();
				String phoneNumber = txtUpdatePhoneUser.getText().trim();
				int status = user.getStatus();
				byte[] key = CipherUtils.hexStringToByteArray(SystemConstant.getHexkey());
				char[] pass = txtUpdatePasswordUser.getPassword();
				String passwor = new String(pass);
				String password = CipherUtils.encrypt(passwor, key);
				System.out.println(password);
				int roleId = user.getRoleId();
				if(fullName.isEmpty() || gmail.isEmpty() || phoneNumber.isEmpty()) {
					JOptionPane.showMessageDialog(txtUpdatePasswordUser, "Không được để trống ô nhập.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					User user = new User();
					user.setId(id);
					user.setFullName(fullName);
					user.setGmail(gmail);
					user.setPhoneNumber(phoneNumber);
					user.setPassword(password);
					user.setStatus(status);
					user.setRoleId(roleId);
					if(userService.updateUser(user)) {
						JOptionPane.showMessageDialog(txtUpdatePasswordUser, "Thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(txtUpdatePasswordUser, "Thất bại", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnUpdateUser.setBackground(new Color(102, 51, 204));
		btnUpdateUser.setForeground(new Color(255, 255, 255));
		btnUpdateUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateUser.setBounds(470, 333, 117, 35);
		panel.add(btnUpdateUser);

		txtUpdatePasswordUser = new JPasswordField();
		lblUpdatePasswordUser.setLabelFor(txtUpdatePasswordUser);
		txtUpdatePasswordUser.setBounds(119, 255, 477, 35);
		panel.add(txtUpdatePasswordUser);
		byte[] key = CipherUtils.hexStringToByteArray(SystemConstant.getHexkey());
		String passwordDecypted = CipherUtils.decrypt(user.getPassword(), key);
		txtUpdatePasswordUser.setText(passwordDecypted);
		System.out.println(passwordDecypted);

//		JButton btnLogout = new JButton("Đăng xuất");
//		btnLogout.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				LoginView loginView = new LoginView();
//				loginView.setVisible(true);
//			}
//		});
//		btnLogout.setBorder(new LineBorder(new Color(102, 51, 204), 2));
//		btnLogout.setForeground(new Color(102, 51, 204));
//		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnLogout.setBackground(new Color(255, 255, 255));
//		btnLogout.setBounds(981, 411, 106, 35);
//		add(btnLogout);

	}
}
