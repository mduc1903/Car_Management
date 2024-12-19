package productmanagement.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdminShowroomView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AdminShowroomView() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 51, 204));
		panel.setBounds(39, 0, 1061, 54);
		add(panel);

		JLabel lblQunLShowroom = new JLabel("Quản lý showroom");
		lblQunLShowroom.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLShowroom.setForeground(Color.WHITE);
		lblQunLShowroom.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblQunLShowroom.setBounds(0, 11, 1061, 28);
		panel.add(lblQunLShowroom);

	}
}
