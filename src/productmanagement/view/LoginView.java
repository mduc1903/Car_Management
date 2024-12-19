package productmanagement.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import productmanagement.model.entity.User;
import productmanagement.services.UserService;
import productmanagement.services.impl.UserServiceImpl;

import javax.swing.SwingConstants;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private UserService userService;
	private JPanel contentPane;
	private JTextField txtGmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		userService = new UserServiceImpl();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(102, 51, 204));
		setLocationRelativeTo(this);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(0, 10, 531, 32);
		contentPane.add(lblNewLabel);

		JLabel lblGmail = new JLabel("Gmail:");
		lblGmail.setForeground(new Color(255, 255, 255));
		lblGmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGmail.setBounds(33, 71, 114, 32);
		contentPane.add(lblGmail);

		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(33, 129, 114, 32);
		contentPane.add(lblPassword);

		txtGmail = new JTextField();
		txtGmail.setBounds(152, 74, 337, 32);
		contentPane.add(txtGmail);
		txtGmail.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(152, 129, 337, 32);
		contentPane.add(txtPassword);

		JButton btnLogInButton = new JButton("Đăng nhập");
		btnLogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String gmail = txtGmail.getText();
				char[] passwordChars = txtPassword.getPassword();
				String password = new String(passwordChars);
				System.out.println("MK nè: " + password);
				
				// Kiểm tra nếu các trường nhập trống
				if (gmail.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Không được để trống tài khoản và mật khẩu.", "Error", JOptionPane.ERROR_MESSAGE);
					txtGmail.requestFocus();
				} else {
					// Gọi phương thức xử lý đăng nhập từ LoginController
	                int loginResult = userService.authenticate(gmail, password);
	                if (loginResult == 1) {
	                	JOptionPane.showMessageDialog(contentPane, "Đăng nhập thành công.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    // Chuyển đến màn hình chính
	                    ClientMainView mainView = new ClientMainView();
	                    mainView.setVisible(true);
	                    dispose();
	                } else if(loginResult == 2) {
	                	//Chuyển đến màn hình Admin
	                	JOptionPane.showMessageDialog(contentPane, "Đăng nhập thành công.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                	User user = userService.searchUserByGmail(gmail);
	                	AdminFrameView adminView = new AdminFrameView(user);
	                	adminView.setVisible(true);
	                	dispose();
	                } else if (loginResult == -1) {
	                	JOptionPane.showMessageDialog(contentPane, "Tài khoản chưa tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);
	                } else if (loginResult == -2) {
	                	JOptionPane.showMessageDialog(contentPane, "Tài khoản bị vô hiệu hóa.", "Error", JOptionPane.ERROR_MESSAGE);
	                } else {
	                	JOptionPane.showMessageDialog(contentPane, "Mật khẩu không chính xác.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
				}
				

			}
		});
		btnLogInButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogInButton.setForeground(new Color(102, 51, 204));
		btnLogInButton.setBounds(296, 204, 133, 35);
		contentPane.add(btnLogInButton);

		JButton btnSignUpButton = new JButton("Đăng ký");
		btnSignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hiển thị frame đăng ký khi nhấn nút Sign Up
                SignUpView signUpFrame = new SignUpView();
                signUpFrame.setVisible(true);
                dispose();
			}
		});
		btnSignUpButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignUpButton.setForeground(new Color(102, 51, 204));
		btnSignUpButton.setBounds(110, 204, 133, 35);
		contentPane.add(btnSignUpButton);

		this.setVisible(true);
	}

}
