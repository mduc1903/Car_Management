package productmanagement.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import productmanagement.model.entity.User;
import productmanagement.services.UserService;
import productmanagement.services.impl.UserServiceImpl;

public class AdminUserView extends JPanel {

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private JTextField txtSearchUserName1;
	private JTextField txtSearchUserName2;
	private JTable userTableActive;
	private JTable userTableDisable;
	private JButton btnSearchUser1, btnDelUser, btnAddUser, btnSearchUser2, btnRestoreUser;
	private JTabbedPane tabbedPane;
	private JPanel panelUserActive, panelUserDel;
	private JScrollPane scrollPane, scrollPane_1;
	private DefaultTableModel tableModelActive, tableModelDisable;

	/**
	 * Create the panel.
	 */
	public AdminUserView() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 204));
		panel.setBounds(39, 0, 1061, 54);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý người dùng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 1061, 28);
		panel.add(lblNewLabel);

		tabbedPane = new JTabbedPane(SwingConstants.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(39, 50, 1078, 732);
		add(tabbedPane);

		panelUserActive = new JPanel();
		panelUserActive.setBackground(new Color(102, 51, 204));
		tabbedPane.addTab("Đang hoạt động", null, panelUserActive, "Người dùng còn hoạt động trong hệ thống");
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		panelUserActive.setLayout(null);

		JLabel lblSearchUserName1 = new JLabel("Nhập tên người dùng:");
		lblSearchUserName1.setForeground(new Color(255, 255, 255));
		lblSearchUserName1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearchUserName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchUserName1.setBounds(10, 11, 139, 35);
		panelUserActive.add(lblSearchUserName1);

		txtSearchUserName1 = new JTextField();
		txtSearchUserName1.setBounds(148, 12, 381, 35);
		panelUserActive.add(txtSearchUserName1);
		txtSearchUserName1.setColumns(10);

		btnSearchUser1 = new JButton("Tìm kiếm");
		btnSearchUser1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fullName = txtSearchUserName1.getText().trim();
				List<User> searchResults = userService.searchUser(fullName, true);
				tableModelActive.setRowCount(0);
				setTableDataActive(searchResults);
			}
		});
		btnSearchUser1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearchUser1.setBackground(new Color(255, 255, 255));
		btnSearchUser1.setForeground(new Color(102, 51, 204));
		btnSearchUser1.setBounds(563, 11, 127, 35);
		panelUserActive.add(btnSearchUser1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 57, 907, 530);
		panelUserActive.add(scrollPane);

		userTableActive = new JTable();
		userTableActive.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(userTableActive);
		scrollPane.setViewportView(userTableActive);
		tableModelActive = new DefaultTableModel();
		userTableActive.setModel(tableModelActive);

		tableModelActive.addColumn("ID");
		tableModelActive.addColumn("Họ tên");
		tableModelActive.addColumn("Gmail");
		tableModelActive.addColumn("Số điện thoại");

		setTableDataActive(userService.getAllUsersActive());

		cssTable(userTableActive);

		btnDelUser = new JButton("Vô hiệu hóa");
		btnDelUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = userTableActive.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(tabbedPane, "Hãy chọn tài khoản cần vô hiệu hóa", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int id = (int) userTableActive.getValueAt(row, 0);
					String name = (String) userTableActive.getValueAt(row, 1);
					int confirm = JOptionPane.showConfirmDialog(tabbedPane, "Xóa người dùng có tên " + name + " với ID là " + id + "?");
					if (confirm == JOptionPane.YES_OPTION) {
						userService.deleteUser(id);
						tableModelActive.setRowCount(0);
						setTableDataActive(userService.getAllUsersActive());
						reloadTableDisable();
					}
				}
			}
		});
		btnDelUser.setToolTipText("Vô hiệu hóa người dùng");
		btnDelUser.setForeground(Color.WHITE);
		btnDelUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelUser.setBackground(new Color(204, 0, 0));
		btnDelUser.setBounds(800, 611, 127, 35);
		panelUserActive.add(btnDelUser);

		btnAddUser = new JButton("Thêm mới");
		btnAddUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openAddUserDialog();
			}
		});
		btnAddUser.setToolTipText("Thêm mới người dùng");
		btnAddUser.setForeground(new Color(102, 51, 204));
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddUser.setBackground(new Color(255, 255, 255));
		btnAddUser.setBounds(635, 611, 127, 35);
		panelUserActive.add(btnAddUser);

		panelUserDel = new JPanel();
		panelUserDel.setBackground(new Color(102, 51, 204));
		tabbedPane.addTab("Vô hiệu hóa", null, panelUserDel, null);
		panelUserDel.setLayout(null);

		JLabel lblSearchUserName2 = new JLabel("Nhập tên người dùng:");
		lblSearchUserName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchUserName2.setForeground(new Color(255, 255, 255));
		lblSearchUserName2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearchUserName2.setBounds(10, 11, 139, 35);
		panelUserDel.add(lblSearchUserName2);

		txtSearchUserName2 = new JTextField();
		txtSearchUserName2.setColumns(10);
		txtSearchUserName2.setBounds(147, 11, 381, 35);
		panelUserDel.add(txtSearchUserName2);

		btnSearchUser2 = new JButton("Tìm kiếm");
		btnSearchUser2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fullName = txtSearchUserName2.getText().trim();
				List<User> searchResults = userService.searchUser(fullName, false);
				tableModelDisable.setRowCount(0);
				setTableDataDisable(searchResults);
			}
		});
		btnSearchUser2.setToolTipText("Tìm kiếm");
		btnSearchUser2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearchUser2.setForeground(new Color(153, 51, 255));
		btnSearchUser2.setBackground(new Color(255, 255, 255));
		btnSearchUser2.setBounds(562, 11, 127, 35);
		panelUserDel.add(btnSearchUser2);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(102, 51, 204)));
		scrollPane_1.setBounds(20, 57, 907, 530);
		panelUserDel.add(scrollPane_1);

		userTableDisable = new JTable();
		scrollPane_1.setViewportView(userTableDisable);
		userTableDisable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableModelDisable = new DefaultTableModel();
		userTableDisable.setModel(tableModelDisable);

		tableModelDisable.addColumn("ID");
		tableModelDisable.addColumn("Họ tên");
		tableModelDisable.addColumn("Gmail");
		tableModelDisable.addColumn("Số điện thoại");

		setTableDataDisable(userService.getAllUsersDisable());

		cssTable(userTableDisable);

		btnRestoreUser = new JButton("Khôi phục");
		btnRestoreUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = userTableDisable.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(tabbedPane, "Hãy chọn tài khoản cần khôi phục", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int id = (int) userTableDisable.getValueAt(row, 0);
					String name = (String) userTableDisable.getValueAt(row, 1);
					int confirm = JOptionPane.showConfirmDialog(tabbedPane, "Khôi phục người dùng có tên " + name + " với ID là " + id + "?");
					if (confirm == JOptionPane.YES_OPTION) {
						userService.restoreUser(id);
						tableModelDisable.setRowCount(0);
						setTableDataDisable(userService.getAllUsersDisable());
						reloadTableActive();
					}
				}
			}
		});
		btnRestoreUser.setToolTipText("Khôi phục tài khoản");
		btnRestoreUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRestoreUser.setForeground(new Color(102, 51, 204));
		btnRestoreUser.setBackground(new Color(255, 255, 255));
		btnRestoreUser.setBounds(800, 608, 127, 35);
		panelUserDel.add(btnRestoreUser);

	}

	private void setTableDataActive(List<User> userList) {
		userList.forEach(item -> {
			tableModelActive.addRow(new Object[] { item.getId(), item.getFullName(), item.getGmail(), item.getPhoneNumber()});
		});
	}

	private void setTableDataDisable(List<User> userList) {
		userList.forEach(item -> {
			tableModelDisable.addRow(new Object[] { item.getId(), item.getFullName(), item.getGmail(), item.getPhoneNumber()});
		});
	}

	public void reloadTableActive() {
		tableModelActive.setRowCount(0);
		setTableDataActive(userService.getAllUsersActive());
	}

	public void reloadTableDisable() {
		tableModelDisable.setRowCount(0);
		setTableDataDisable(userService.getAllUsersDisable());
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1100, 0); // Đặt kích thước chiều rộng mặc định cho sidebar
	}

	 private void openAddUserDialog() {
		 AddUserView addUserView = new AddUserView(this);
		 addUserView.setVisible(true);
	 }

	private void cssTable(JTable carTable) {
		TableColumn column;
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < carTable.getColumnCount(); i++) {
			column = carTable.getColumnModel().getColumn(i);
			column.setCellRenderer(centerRenderer);
			switch (i) {
			case 0:
				column.setPreferredWidth(25); // ID
				break;
			case 1:
				column.setPreferredWidth(150); // Name
				break;
			case 2:
				column.setPreferredWidth(150); // gmail
				break;
			case 3:
				column.setPreferredWidth(50); // phone
				break;
			}
		}
	}
}
