package productmanagement.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import productmanagement.model.entity.Bank;
import productmanagement.services.BankService;
import productmanagement.services.impl.BankServiceImpl;
import productmanagement.utils.NumberUtils;

public class AddBankView extends JDialog {

	private static final long serialVersionUID = 1L;
	private BankService bankService;
	private AdminBankView parentView;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtAddNameBank;
	private JTextField txtAddFeeBank;

	/**
	 * Create the dialog.
	 */
	public AddBankView(AdminBankView parent) {
		setResizable(false);
		bankService = new BankServiceImpl();
		this.parentView = parent;
		
		setBounds(100, 100, 453, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 51, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		contentPanel.setLayout(null);
		
		JLabel lblThmNgnHng = new JLabel("Thêm ngân hàng");
		lblThmNgnHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmNgnHng.setForeground(Color.WHITE);
		lblThmNgnHng.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThmNgnHng.setBounds(0, 0, 437, 38);
		contentPanel.add(lblThmNgnHng);
		
		JLabel lblAddNameBank = new JLabel("Tên ngân hàng");
		lblAddNameBank.setForeground(Color.WHITE);
		lblAddNameBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddNameBank.setBounds(20, 49, 198, 35);
		contentPanel.add(lblAddNameBank);
		
		txtAddNameBank = new JTextField();
		txtAddNameBank.setColumns(10);
		txtAddNameBank.setBounds(20, 95, 396, 35);
		contentPanel.add(txtAddNameBank);
		
		txtAddFeeBank = new JTextField();
		txtAddFeeBank.setColumns(10);
		txtAddFeeBank.setBounds(20, 183, 396, 35);
		contentPanel.add(txtAddFeeBank);
		
		JLabel lblAddFeeBank = new JLabel("Lãi suất");
		lblAddFeeBank.setForeground(Color.WHITE);
		lblAddFeeBank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddFeeBank.setBounds(20, 141, 79, 35);
		contentPanel.add(lblAddFeeBank);
		
		JButton btnAddBank = new JButton("Thêm");
		btnAddBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtAddNameBank.getText().trim();
				String fee = txtAddFeeBank.getText().trim();
				
				if(name.isEmpty() || fee.isEmpty()) {
					JOptionPane.showMessageDialog(contentPanel, "Không được để trống ô nhập.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (!NumberUtils.isDouble(fee)) {
		            JOptionPane.showMessageDialog(contentPanel, "Lãi suất phải là số.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!NumberUtils.positiveNumber(Double.parseDouble(fee))) {
					JOptionPane.showMessageDialog(contentPanel, "Lãi suất phải lớn hơn 0.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Bank bank = new Bank();
					bank.setName(name);
					bank.setFee(Double.parseDouble(fee));
					if(bankService.addBank(bank)) {
						JOptionPane.showMessageDialog(contentPanel, "Thành công", "Message", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(contentPanel, "Thất bại", "Error", JOptionPane.ERROR_MESSAGE);
					}
					parentView.reloadTable();
					setVisible(false);
					dispose();
				}
			}
		});
		btnAddBank.setForeground(Color.WHITE);
		btnAddBank.setBackground(new Color(0, 204, 51));
		btnAddBank.setBounds(94, 252, 104, 35);
		contentPanel.add(btnAddBank);
		
		JButton btnFromAddBackMain = new JButton("Quay lại");
		btnFromAddBackMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnFromAddBackMain.setForeground(Color.WHITE);
		btnFromAddBackMain.setBackground(new Color(204, 0, 0));
		btnFromAddBackMain.setBounds(238, 252, 104, 35);
		contentPanel.add(btnFromAddBackMain);
	}
}
