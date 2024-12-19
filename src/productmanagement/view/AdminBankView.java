package productmanagement.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import productmanagement.model.dto.BankSearchDTO;
import productmanagement.model.entity.Bank;
import productmanagement.services.BankService;
import productmanagement.services.impl.BankServiceImpl;
import productmanagement.utils.NumberUtils;

public class AdminBankView extends JPanel {

	private static final long serialVersionUID = 1L;
	private BankService bankService;
	private JTextField txtSearchBankName;
	private JTextField txtSearchMaxFee;
	private JTextField txtSearchMinFee;
	private JTable bankTable;
	private DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
//	@SuppressWarnings("rawtypes")
	public AdminBankView() {
		bankService = new BankServiceImpl();
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panelSearchBank = new JPanel();
		panelSearchBank.setLayout(null);
		panelSearchBank.setBorder(new LineBorder(new Color(102, 51, 204)));
		panelSearchBank.setBackground(Color.WHITE);
		panelSearchBank.setBounds(32, 0, 1058, 262);
		add(panelSearchBank);
		
		JPanel panelSearchBankTitle = new JPanel();
		panelSearchBankTitle.setLayout(null);
		panelSearchBankTitle.setBackground(new Color(102, 51, 204));
		panelSearchBankTitle.setBounds(0, 0, 1057, 50);
		panelSearchBank.add(panelSearchBankTitle);
		
		JLabel lblQunLNgn = new JLabel("Quản lý ngân hàng");
		lblQunLNgn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLNgn.setForeground(Color.WHITE);
		lblQunLNgn.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblQunLNgn.setBounds(405, 11, 268, 28);
		panelSearchBankTitle.add(lblQunLNgn);
		
		JLabel lblSearchBankName = new JLabel("Tên ngân hàng");
		lblSearchBankName.setForeground(new Color(102, 51, 204));
		lblSearchBankName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchBankName.setBounds(10, 61, 133, 25);
		panelSearchBank.add(lblSearchBankName);
		
		JLabel lblSearchMinFee = new JLabel("Lãi suất từ");
		lblSearchMinFee.setForeground(new Color(102, 51, 204));
		lblSearchMinFee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchMinFee.setBounds(404, 61, 118, 25);
		panelSearchBank.add(lblSearchMinFee);
		
		JLabel lblSearchMaxFee = new JLabel("Lãi suất đến");
		lblSearchMaxFee.setForeground(new Color(102, 51, 204));
		lblSearchMaxFee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchMaxFee.setBounds(793, 61, 118, 25);
		panelSearchBank.add(lblSearchMaxFee);
		
		txtSearchBankName = new JTextField();
		txtSearchBankName.setColumns(10);
		txtSearchBankName.setBounds(10, 97, 250, 35);
		panelSearchBank.add(txtSearchBankName);
		
		txtSearchMaxFee = new JTextField();
		lblSearchMaxFee.setLabelFor(txtSearchMaxFee);
		txtSearchMaxFee.setColumns(10);
		txtSearchMaxFee.setBounds(793, 97, 250, 35);
		panelSearchBank.add(txtSearchMaxFee);
		
		txtSearchMinFee = new JTextField();
		lblSearchMinFee.setLabelFor(txtSearchMinFee);
		txtSearchMinFee.setColumns(10);
		txtSearchMinFee.setBounds(404, 97, 250, 35);
		panelSearchBank.add(txtSearchMinFee);
		
		JButton btnSearchBank = new JButton("Tìm kiếm");
		btnSearchBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankSearchDTO modelSearch = new BankSearchDTO();
				String searchName = txtSearchBankName.getText().trim();
				if (!searchName.isEmpty()) {
					modelSearch.setName(searchName);
				}

				String minFeeInput = txtSearchMinFee.getText().trim();
				if (!minFeeInput.isEmpty()) {
					if (!NumberUtils.isDouble(minFeeInput)) {
						JOptionPane.showMessageDialog(panelSearchBank, "Lãi suất phải là số", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Double searchMinFee = Double.parseDouble(minFeeInput);
						if (NumberUtils.positiveNumber(searchMinFee)) {
							modelSearch.setMinFee(searchMinFee);
						} else {
							JOptionPane.showMessageDialog(panelSearchBank, "Lãi suất phải lớn hơn hoặc bằng 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				String maxFeeInput = txtSearchMaxFee.getText().trim();
				if (!maxFeeInput.isEmpty()) {
					if (!NumberUtils.isDouble(maxFeeInput)) {
						JOptionPane.showMessageDialog(panelSearchBank, "Lãi suất phải là sốr", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Double searchMaxFee = Double.parseDouble(maxFeeInput);
						if (NumberUtils.positiveNumber(searchMaxFee)) {
							modelSearch.setMaxFee(searchMaxFee);
						} else {
							JOptionPane.showMessageDialog(panelSearchBank, "Lãi suất phải lớn hơn hoặc bằng 0", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				List<Bank> searchResults = bankService.searchBank(modelSearch);
				tableModel.setRowCount(0);;
				setTableData(searchResults);
			}
		});
		btnSearchBank.setToolTipText("TÌm kiếm");
		btnSearchBank.setForeground(Color.WHITE);
		btnSearchBank.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearchBank.setBackground(new Color(51, 102, 204));
		btnSearchBank.setBounds(404, 170, 118, 35);
		panelSearchBank.add(btnSearchBank);
		
		JButton btnResetForm = new JButton("Reset");
		btnResetForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchBankName.setText("");
				txtSearchMaxFee.setText("");
				txtSearchMinFee.setText("");
			}
		});
		btnResetForm.setToolTipText("Reset");
		btnResetForm.setForeground(Color.WHITE);
		btnResetForm.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetForm.setBackground(new Color(204, 0, 0));
		btnResetForm.setBounds(536, 170, 118, 35);
		panelSearchBank.add(btnResetForm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 338, 1058, 283);
		add(scrollPane);
		
		bankTable = new JTable();
		bankTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(bankTable);
		tableModel = new DefaultTableModel();
		bankTable.setModel(tableModel);

		tableModel.addColumn("ID");
		tableModel.addColumn("Tên ngân hàng");
		tableModel.addColumn("Lãi suất");

		setTableData(bankService.getAllBanks());

		cssTable(bankTable);
		
		JComboBox<Object> comboBoxSortBank = new JComboBox<Object>();
		comboBoxSortBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBoxSortBank.setModel(new DefaultComboBoxModel<Object>(new String[] {"Mặc định", "Lãi suất"}));
		comboBoxSortBank.setForeground(new Color(102, 51, 204));
		comboBoxSortBank.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxSortBank.setBackground(Color.WHITE);
		comboBoxSortBank.setBounds(864, 292, 226, 35);
		add(comboBoxSortBank);
		
		JLabel lblSortBank = new JLabel("Sắp xếp theo: ");
		lblSortBank.setLabelFor(comboBoxSortBank);
		lblSortBank.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSortBank.setForeground(new Color(102, 51, 204));
		lblSortBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSortBank.setBounds(717, 292, 136, 35);
		add(lblSortBank);
		
		JButton btnDeleteBank = new JButton("Xóa");
		btnDeleteBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = bankTable.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(bankTable, "Hãy chọn ngân hàng để xóa", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int id = (int) bankTable.getValueAt(row, 0);
					String name = (String) bankTable.getValueAt(row, 1);
					int confirm = JOptionPane.showConfirmDialog(bankTable, "Bạn có muốn xóa ngân hàng " + name + " có ID là " + id + " ?");
					if (confirm == JOptionPane.YES_OPTION) {
						if(bankService.delBank(id)) {
							JOptionPane.showMessageDialog(bankTable, "Thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(bankTable, "Thất bại", "Error", JOptionPane.ERROR_MESSAGE);
						}
						reloadTable();
					}
				}
			}
		});
		btnDeleteBank.setToolTipText("Xóa");
		btnDeleteBank.setForeground(Color.WHITE);
		btnDeleteBank.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteBank.setBackground(new Color(204, 0, 0));
		btnDeleteBank.setBounds(972, 642, 118, 35);
		add(btnDeleteBank);
		
		JButton btnUpdateBank = new JButton("Chỉnh sửa");
		btnUpdateBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = bankTable.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(bankTable, "Hãy chọn ngân hàng để chỉnh sửa", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Bank bankSelected = bankService.searchBankById((Integer)bankTable.getValueAt(row, 0));
					System.out.println(bankSelected);
					openEditBankDialog(bankSelected);
				}
			}
		});
		btnUpdateBank.setToolTipText("Chỉnh sửa");
		btnUpdateBank.setForeground(Color.WHITE);
		btnUpdateBank.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateBank.setBackground(new Color(51, 102, 204));
		btnUpdateBank.setBounds(831, 642, 118, 35);
		add(btnUpdateBank);
		
		JButton btnAddBank = new JButton("Thêm mới");
		btnAddBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAddBankDialog();
			}
		});
		btnAddBank.setToolTipText("Thêm mới");
		btnAddBank.setForeground(Color.WHITE);
		btnAddBank.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddBank.setBackground(new Color(102, 51, 204));
		btnAddBank.setBounds(690, 642, 118, 35);
		add(btnAddBank);

	}
	
	private void setTableData(List<Bank> bankList) {
		bankList.forEach(item -> {
			tableModel.addRow(new Object[] { item.getId(), item.getName(), item.getFee()});
		});
	}
	
	private void openAddBankDialog() {
		 AddBankView addBankView = new AddBankView(this);
		 addBankView.setVisible(true);
	 }

	 private void openEditBankDialog(Bank bankSelected) {
		 EditBankView editBankView = new EditBankView(this);
		 editBankView.setVisible(true);
		 editBankView.getBank(bankSelected);
	 }
	
	public void reloadTable() {
		tableModel.setRowCount(0);
		setTableData(bankService.getAllBanks());
	}
	
	private void cssTable(JTable bankTable) {
		TableColumn column;
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < bankTable.getColumnCount(); i++) {
			column = bankTable.getColumnModel().getColumn(i);
			column.setCellRenderer(centerRenderer);
			switch (i) {
			case 0:
				column.setPreferredWidth(25); // ID
				break;
			case 1:
				column.setPreferredWidth(300); // Name
				break;
			case 2:
				column.setPreferredWidth(150); // Price
				break;

			}
		}
	}
}
