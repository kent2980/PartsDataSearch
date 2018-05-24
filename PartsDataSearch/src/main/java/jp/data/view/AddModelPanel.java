package jp.data.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class AddModelPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final JButton addButton = new JButton();
	private final JComboBox<String> combo = new JComboBox<>();
	private final JLabel mcName = new JLabel();
	private final JLabel substrateName = new JLabel();
	private final JLabel substrateFace = new JLabel();
	private final JLabel stView = new JLabel();
	private final JLabel batuLabel = new JLabel();
	private final JLabel RemainingParts = new JLabel();
	private final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

	public AddModelPanel(int i) {
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.setOpaque(false);

		//【モデル１】
		//追加ボタン1
		addButton.setText("add" + i);
		layout.putConstraint(SpringLayout.NORTH, addButton, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, addButton, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, addButton, 80, SpringLayout.WEST, addButton);
		layout.putConstraint(SpringLayout.SOUTH, addButton, 30, SpringLayout.NORTH, addButton);
		this.add(addButton);
		//リストボックス1
		model.addElement("モデルを追加してください");
		combo.setModel(model);
		combo.setFont(new Font("メイリオ",Font.BOLD,13));
		layout.putConstraint(SpringLayout.NORTH, combo, 0, SpringLayout.NORTH, addButton);
		layout.putConstraint(SpringLayout.WEST, combo, 20, SpringLayout.EAST, addButton);
		layout.putConstraint(SpringLayout.EAST, combo, 300, SpringLayout.WEST, combo);
		layout.putConstraint(SpringLayout.SOUTH, combo, 0, SpringLayout.SOUTH, addButton);
		this.add(combo);
		//マシン名：
		JLabel mcNameLabel = new JLabel("【マシン】：");
		mcNameLabel.setFont(new Font("メイリオ",Font.BOLD,13));
		layout.putConstraint(SpringLayout.NORTH, mcNameLabel, 15, SpringLayout.SOUTH, combo);
		layout.putConstraint(SpringLayout.WEST, mcNameLabel, 0, SpringLayout.WEST, combo);
		this.add(mcNameLabel);
		mcName.setFont(new Font("メイリオ",Font.BOLD,13));
		layout.putConstraint(SpringLayout.NORTH, mcName, 15, SpringLayout.SOUTH, combo);
		layout.putConstraint(SpringLayout.WEST, mcName, 5, SpringLayout.EAST, mcNameLabel);
		this.add(mcName);
		//基板名：
		JLabel substrateNameLabel = new JLabel("【基板名】：");
		substrateNameLabel.setFont(new Font("メイリオ",Font.BOLD,13));
		layout.putConstraint(SpringLayout.NORTH, substrateNameLabel, 15, SpringLayout.SOUTH, combo);
		layout.putConstraint(SpringLayout.WEST, substrateNameLabel, 70, SpringLayout.EAST, mcNameLabel);
		this.add(substrateNameLabel);
		substrateName.setFont(new Font("メイリオ",Font.BOLD,13));
		layout.putConstraint(SpringLayout.NORTH, substrateName, 15, SpringLayout.SOUTH, combo);
		layout.putConstraint(SpringLayout.WEST, substrateName, 5, SpringLayout.EAST, substrateNameLabel);
		this.add(substrateName);
		//面：
		JLabel substrateFaceLabel = new JLabel("【面】：");
		substrateFaceLabel.setFont(new Font("メイリオ",Font.BOLD,13));
		layout.putConstraint(SpringLayout.NORTH, substrateFaceLabel, 15, SpringLayout.SOUTH, combo);
		layout.putConstraint(SpringLayout.WEST, substrateFaceLabel, 100, SpringLayout.EAST, substrateNameLabel);
		this.add(substrateFaceLabel);
		substrateFace.setFont(new Font("メイリオ",Font.BOLD,13));
		layout.putConstraint(SpringLayout.NORTH, substrateFace, 15, SpringLayout.SOUTH, combo);
		layout.putConstraint(SpringLayout.WEST, substrateFace, 5, SpringLayout.EAST, substrateFaceLabel);
		this.add(substrateFace);
		//ST表示画面
		stView.setFont(new Font("メイリオ",Font.BOLD,38));
		stView.setOpaque(true);
		stView.setBackground(new Color(255,255,255));
		stView.setHorizontalAlignment(SwingConstants.CENTER);
		stView.setVerticalAlignment(SwingConstants.CENTER);
		stView.setBorder(new BevelBorder(BevelBorder.LOWERED));
		layout.putConstraint(SpringLayout.NORTH, stView, 0, SpringLayout.NORTH, addButton);
		layout.putConstraint(SpringLayout.WEST, stView, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, stView, 120, SpringLayout.WEST, stView);
		layout.putConstraint(SpringLayout.SOUTH, stView, 60, SpringLayout.NORTH, stView);
		this.add(stView);
		//削除ラベル
		URL url = this.getClass().getResource("/picture/newIcon/batu.png");
		ImageIcon batuicon = new ImageIcon(url);
		Image image = batuicon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		batuicon = new ImageIcon(image);
		batuLabel.setIcon(batuicon);
		layout.putConstraint(SpringLayout.NORTH, batuLabel, 0, SpringLayout.NORTH, combo);
		layout.putConstraint(SpringLayout.WEST, batuLabel, 15, SpringLayout.EAST, combo);
		this.add(batuLabel);
		//残部品ラベル
		RemainingParts.setFont(new Font("メイリオ",Font.BOLD,20));
		RemainingParts.setHorizontalAlignment(SwingConstants.CENTER);
		layout.putConstraint(SpringLayout.NORTH, RemainingParts, 0, SpringLayout.NORTH, combo);
		layout.putConstraint(SpringLayout.WEST, RemainingParts, 35, SpringLayout.EAST, batuLabel);
		layout.putConstraint(SpringLayout.SOUTH, RemainingParts, 0, SpringLayout.SOUTH, combo);
		this.add(RemainingParts);
	}

	/**
	 * @return add
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * @return combo
	 */
	public JComboBox<String> getCombo() {
		return combo;
	}

	/**
	 * @return mcName
	 */
	public JLabel getMcName() {
		return mcName;
	}

	/**
	 * @return substrateName
	 */
	public JLabel getSubstrateName() {
		return substrateName;
	}

	/**
	 * @return substrateFace
	 */
	public JLabel getSubstrateFace() {
		return substrateFace;
	}

	/**
	 * @return stView
	 */
	public JLabel getStView() {
		return stView;
	}

	/**
	 * @return model
	 */
	public DefaultComboBoxModel<String> getModel() {
		return model;
	}

	/**
	 * @return batuLabel
	 */
	public JLabel getBatuLabel() {
		return batuLabel;
	}

	/**
	 * @return remainingParts
	 */
	public JLabel getRemainingParts() {
		return RemainingParts;
	}
}
