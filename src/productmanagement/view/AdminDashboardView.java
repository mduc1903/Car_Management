package productmanagement.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import productmanagement.services.BankService;
import productmanagement.services.CarManager;
import productmanagement.services.UserService;
import productmanagement.services.impl.BankServiceImpl;
import productmanagement.services.impl.CarManagerImpl;
import productmanagement.services.impl.UserServiceImpl;

public class AdminDashboardView extends JPanel {

	private static final long serialVersionUID = 1L;
	private CarManager carManager;
	private UserService userService;
	private BankService bankService;

	/**
	 * Create the panel.
	 */
	public AdminDashboardView() {
		carManager = new CarManagerImpl();
		userService = new UserServiceImpl();
		bankService = new BankServiceImpl();

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1100, 750);
		add(panel);
		panel.setLayout(null);

		JPanel boxItemDashboard1 = new JPanel();
		boxItemDashboard1.setBackground(new Color(102, 51, 204));
		boxItemDashboard1.setBounds(92, 57, 250, 125);
		panel.add(boxItemDashboard1);
		boxItemDashboard1.setLayout(null);

		JLabel lblAdminDashboardCar = new JLabel("Tổng số ô tô");
		lblAdminDashboardCar.setForeground(new Color(255, 255, 255));
		lblAdminDashboardCar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdminDashboardCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminDashboardCar.setBounds(10, 11, 132, 35);
		boxItemDashboard1.add(lblAdminDashboardCar);

		JLabel lblDashboardCarTotal = new JLabel(String.valueOf(carManager.statisticsTotal()));
		lblDashboardCarTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDashboardCarTotal.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDashboardCarTotal.setForeground(new Color(255, 255, 255));
		lblDashboardCarTotal.setBounds(53, 65, 187, 49);
		boxItemDashboard1.add(lblDashboardCarTotal);

		JPanel boxItemDashboard2 = new JPanel();
		boxItemDashboard2.setBackground(new Color(102, 51, 204));
		boxItemDashboard2.setBounds(419, 57, 250, 125);
		panel.add(boxItemDashboard2);
		boxItemDashboard2.setLayout(null);

		JLabel lblAdminDashboardUser = new JLabel("Tổng số người dùng");
		lblAdminDashboardUser.setBounds(10, 11, 172, 35);
		lblAdminDashboardUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminDashboardUser.setForeground(Color.WHITE);
		lblAdminDashboardUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		boxItemDashboard2.add(lblAdminDashboardUser);

		JLabel lblDashboardUserTotal = new JLabel(String.valueOf(userService.getAllUser().size()));
		lblDashboardUserTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDashboardUserTotal.setForeground(Color.WHITE);
		lblDashboardUserTotal.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDashboardUserTotal.setBounds(38, 65, 202, 49);
		boxItemDashboard2.add(lblDashboardUserTotal);

		JPanel boxItemDashboard3 = new JPanel();
		boxItemDashboard3.setBackground(new Color(102, 51, 204));
		boxItemDashboard3.setBounds(741, 57, 250, 125);
		panel.add(boxItemDashboard3);
		boxItemDashboard3.setLayout(null);

		JLabel lblAdminDashboardShowroom = new JLabel("Số ngân hàng liên kết");
		lblAdminDashboardShowroom.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminDashboardShowroom.setForeground(Color.WHITE);
		lblAdminDashboardShowroom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdminDashboardShowroom.setBounds(10, 11, 179, 35);
		boxItemDashboard3.add(lblAdminDashboardShowroom);

		JLabel lblDashboardShowroomTotal = new JLabel(String.valueOf(bankService.getAllBanks().size()));
		lblDashboardShowroomTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDashboardShowroomTotal.setForeground(Color.WHITE);
		lblDashboardShowroomTotal.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDashboardShowroomTotal.setBounds(35, 65, 205, 49);
		boxItemDashboard3.add(lblDashboardShowroomTotal);


	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1100, 0); // Đặt kích thước chiều rộng mặc định cho sidebar
	}
}
