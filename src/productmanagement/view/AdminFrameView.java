package productmanagement.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import productmanagement.model.entity.User;

public class AdminFrameView implements Navigate {
	private JFrame frame;
	private JPanel contentPanel;
    private CardLayout cardLayout;
    private JPanel currentPage;
    private User user;

	public JPanel getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(JPanel currentPage) {
		this.currentPage = currentPage;
	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					AdminFrameView window = new AdminFrameView();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AdminFrameView(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Trang quản trị");
		frame.setBounds(100, 100, 1316, 790);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

		AdminSidebarView sidebar = new AdminSidebarView(this, user);
		frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(sidebar, BorderLayout.WEST);
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
        showDefaultPage();
	}

	private void showDefaultPage() {
		JPanel dashboardPanel = new AdminDashboardView();
        contentPanel.add(dashboardPanel, "Default");
        cardLayout.show(contentPanel, "Default");
    }

	@Override
	public void navigateTo(JPanel page) {
		contentPanel.add(page, "Page");
		cardLayout.show(contentPanel, "Page");
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

	@Override
	public void logout() {
		frame.dispose();
		
	}

}
