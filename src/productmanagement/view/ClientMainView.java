package productmanagement.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ClientMainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientMainView frame = new ClientMainView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ClientMainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 570);
		setLocationRelativeTo(null);
		setTitle("Home page");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(245, 255, 250));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar MainMenu = new JMenuBar();
		MainMenu.setMargin(new Insets(0, 5, 5, 5));
		MainMenu.setBackground(new Color(143, 188, 143));
		MainMenu.setBounds(170, 34, 613, 52);
		contentPane.add(MainMenu);
		
		JMenuItem compareItem = new JMenuItem("So sánh xe ");
		compareItem.setBackground(new Color(143, 188, 143));
		compareItem.setHorizontalAlignment(SwingConstants.CENTER);
		compareItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientCompareCarView compareView = new ClientCompareCarView();
				compareView.setVisible(true);
				dispose();
				
			}
		});
		
//		JMenuItem cartMenu = new JMenuItem("Giỏ hàng");
//		cartMenu.setBackground(new Color(143, 188, 143));
//		cartMenu.setSelected(true);
//		cartMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
//		MainMenu.add(cartMenu);
		
		JMenuItem productMenu = new JMenuItem("Sản phẩm");
		productMenu.setBackground(new Color(143, 188, 143));
		productMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientCarView carView = new ClientCarView();
				carView.setVisible(true);
				dispose();
			}
		});
		productMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		MainMenu.add(productMenu);
		compareItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		MainMenu.add(compareItem);
		
		JLabel lblNewLabel = new JLabel("Vinfast");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(31, 44, 118, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnLogout = new JButton("Đăng xuất");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
				dispose();
			}
		});
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBackground(new Color(102, 153, 102));
		btnLogout.setBounds(680, 458, 129, 35);
		contentPane.add(btnLogout);
	}
}
