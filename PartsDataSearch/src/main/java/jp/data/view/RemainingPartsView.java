package jp.data.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class RemainingPartsView extends JDialog {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final DefaultTableModel model;
	private final JTable table;

	public RemainingPartsView(){
		//Viewの設定
		this.setBounds(100, 100, 500, 700);
		this.setLocationRelativeTo(null);
		this.setModal(true);

		//パネル
		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);

		//モデル名ラベル
		JLabel modelName = new JLabel();
		layout.putConstraint(SpringLayout.NORTH, modelName, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, modelName, 10, SpringLayout.WEST, panel);
		panel.add(modelName);

		//テーブル
		model = new DefaultTableModel(3,40);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		table.setRowHeight(60);
		table.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		layout.putConstraint(SpringLayout.NORTH, sp, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, sp, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, sp, -10, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.SOUTH, sp, -20, SpringLayout.SOUTH, panel);
		panel.add(sp);

		this.getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void setTableModel(Object[][] data, Object[] column) {
		model.setDataVector(data, column);
		table.setModel(model);
	}

	/**
	 * @return model
	 */
	public DefaultTableModel getModel() {
		return model;
	}

	/**
	 * @return table
	 */
	public JTable getTable() {
		return table;
	}
}
