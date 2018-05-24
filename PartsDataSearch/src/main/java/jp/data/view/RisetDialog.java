package jp.data.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class RisetDialog extends JDialog {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final JButton okButton = new JButton("OK");
	private final JButton ngButton = new JButton("CANCEL");

	public RisetDialog(String messege){
		this.setBounds(100, 100, 260, 160);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);

		JLabel label = new JLabel(messege);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		layout.putConstraint(SpringLayout.NORTH, label, 15, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, label, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, label, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.SOUTH, label, -70, SpringLayout.SOUTH, panel);
		panel.add(label);

		layout.putConstraint(SpringLayout.NORTH, okButton, -35, SpringLayout.SOUTH, okButton);
		layout.putConstraint(SpringLayout.WEST, okButton, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, okButton, 260/2-15, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH, okButton, -20, SpringLayout.SOUTH, panel);
		panel.add(okButton);

		layout.putConstraint(SpringLayout.NORTH, ngButton, -35, SpringLayout.SOUTH, ngButton);
		layout.putConstraint(SpringLayout.WEST, ngButton, 260/2-5, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, ngButton, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.SOUTH, ngButton, -20, SpringLayout.SOUTH, panel);
		panel.add(ngButton);

		this.getContentPane().add(panel, BorderLayout.CENTER);

		this.setModal(true);
	}

	/**
	 * @return okButton
	 */
	public JButton getOkButton() {
		return okButton;
	}

	/**
	 * @return ngButton
	 */
	public JButton getNgButton() {
		return ngButton;
	}

}
