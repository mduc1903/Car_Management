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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import productmanagement.SystemConstant;
import productmanagement.model.entity.User;
import productmanagement.services.UserService;
import productmanagement.services.impl.UserServiceImpl;
import productmanagement.utils.CipherUtils;


public class SignUpView extends JFrame {

	private static final long serialVersionUID = 1L;
	private UserService userService;
	private JPanel contentPane;
	private JTextField txtFullname;
	private JTextField txtGmail;
	private JTextField txtPhoneNumber;
	private JPasswordField txtPasswordSignUp;
	private JPasswordField txtEnterPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
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
	public SignUpView() {
		userService = new UserServiceImpl();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(102, 51, 204));
		setLocationRelativeTo(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(0, 0, 559, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(37, 67, 84, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gmail");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(37, 110, 84, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(37, 153, 143, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mật khẩu");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(37, 196, 84, 32);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(10, 237, 168, 32);
		contentPane.add(lblNewLabel_1_4);
		
		txtFullname = new JTextField();
		txtFullname.setBounds(177, 67, 337, 32);
		contentPane.add(txtFullname);
		txtFullname.setColumns(10);
		
		txtGmail = new JTextField();
		txtGmail.setColumns(10);
		txtGmail.setBounds(177, 110, 337, 32);
		contentPane.add(txtGmail);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(177, 153, 337, 32);
		contentPane.add(txtPhoneNumber);
		
		txtPasswordSignUp = new JPasswordField();
		txtPasswordSignUp.setBounds(177, 196, 337, 32);
		contentPane.add(txtPasswordSignUp);
		
		txtEnterPassword = new JPasswordField();
		txtEnterPassword.setBounds(177, 239, 337, 32);
		contentPane.add(txtEnterPassword);
		
		JButton btnSignUp = new JButton("Đăng ký");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName = txtFullname.getText();
                String gmail = txtGmail.getText();
                String phoneNumber = txtPhoneNumber.getText();
                char[] passwordChars = txtPasswordSignUp.getPassword();
                String password = new String(passwordChars);
                char[] passwordCharsEnter = txtEnterPassword.getPassword();
                String confirmPassword = new String(passwordCharsEnter);
//
             // Kiểm tra nếu các trường nhập trống
                if (fullName.isEmpty() || gmail.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                	JOptionPane.showMessageDialog(contentPane, "Không được để trống ô nhập.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if(!password.equals(confirmPassword)) {
                	JOptionPane.showMessageDialog(contentPane, "Nhập lại mật khẩu phải khớp với mật khẩu.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if(userService.isUserExists(gmail)){
                	JOptionPane.showMessageDialog(contentPane, "Tài khoản đã tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    byte[] key = CipherUtils.hexStringToByteArray(SystemConstant.getHexkey());
                    System.out.println(key);
    				String passwordFinal = CipherUtils.encrypt(password, key);
                	User user = new User();
                	user.setFullName(fullName);
                	user.setGmail(gmail);
                	user.setPhoneNumber(phoneNumber);
                	user.setPassword(passwordFinal);
                	user.setRoleId(SystemConstant.getDefaultRoleid());
                	user.setStatus(SystemConstant.getDefaultStatus());
                	if(userService.addUser(user)) {
                		JOptionPane.showMessageDialog(contentPane, "Đăng ký thành công.", "Success", JOptionPane.INFORMATION_MESSAGE);
                		LoginView loginView = new LoginView();
                		loginView.setVisible(true);
                		dispose();
                	} else {
                		JOptionPane.showMessageDialog(contentPane, "Đăng ký thất bại.", "Error", JOptionPane.ERROR_MESSAGE);
                	}
                }                
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignUp.setForeground(new Color(102, 51, 204));
		btnSignUp.setBounds(309, 313, 133, 35);
		contentPane.add(btnSignUp);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear all text fields
                txtFullname.setText("");
                txtGmail.setText("");
                txtPhoneNumber.setText("");
                txtPasswordSignUp.setText("");
                txtEnterPassword.setText("");
			}
		});
		btnReset.setForeground(new Color(102, 51, 204));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(127, 313, 133, 35);
		contentPane.add(btnReset);
	}
}
