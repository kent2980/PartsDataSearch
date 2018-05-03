package jp.data.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import jp.data.controller.MainViewController;

public class MainView {
	
    public static void main(String[] args) { 
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("MainView");
                
                MainView mainView = new MainView();
                new MainViewController(mainView);
                frame.setBounds(200, 100, 1000, 700);
                frame.setResizable(false);
                frame.setContentPane(mainView.getContentPane());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
        		URL url = MainView.class.getResource("/picture/newIcon/appicon.jpg");
        		ImageIcon icon = new ImageIcon(url);
        		frame.setIconImage(icon.getImage());
                frame.setVisible(true);
            }
        });
    }
    
	/**
	 * このパネルのフィールドです
	 */
	private final JLabel partsCodeLabel = new JLabel("部品コード");
	private final JTextField partsCodeField = new JTextField();
	private final JLabel newLabel = new JLabel();
	private final AddModelPanel addPanel1 = new AddModelPanel(1);
	private final AddModelPanel addPanel2 = new AddModelPanel(2);
	private final AddModelPanel addPanel3 = new AddModelPanel(3);
	private final AddModelPanel addPanel4 = new AddModelPanel(4);
	private final JPanel panel = new BackImagePanel("/picture/newIcon/backimage.jpg");
	private final RisetDialog dialog = new RisetDialog("リセットしますか？");
	private final RemainingPartsView partsView = new RemainingPartsView();

	/**
	 * 親コンポーネント
	 */
	private final JPanel container = createContainer(panel, partsCodeLabel, partsCodeField, newLabel,
																								addPanel1, addPanel2, addPanel3, addPanel4, dialog, partsView);
	
	/**
	 * staticメソッド（ウィジェットの配置）
	 */
	private static JPanel createContainer(JPanel panel, JLabel partsCodeLabel, JTextField partsCodeField,JLabel newLabel,
																			AddModelPanel addPanel1,AddModelPanel addPanel2,AddModelPanel addPanel3,AddModelPanel addPanel4, RisetDialog dialog, RemainingPartsView partsView) {

		partsCodeField.requestFocusInWindow();
		partsCodeField.setSelectionColor(null);
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);
		panel.setBackground(new Color(246,240,240));
		//部品コード ラベル
		partsCodeLabel.setFont(new Font("メイリオ", Font.PLAIN, 20));
		layout.putConstraint(SpringLayout.NORTH, partsCodeLabel, 20, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, partsCodeLabel, 140, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.SOUTH, partsCodeLabel, 50, SpringLayout.NORTH, partsCodeLabel);
		layout.putConstraint(SpringLayout.EAST, partsCodeLabel, 356, SpringLayout.WEST, panel);
		panel.add(partsCodeLabel);
		//部品コード テキストフィールド
		layout.putConstraint(SpringLayout.NORTH, partsCodeField, 1, SpringLayout.SOUTH, partsCodeLabel);
		layout.putConstraint(SpringLayout.WEST, partsCodeField, 0, SpringLayout.WEST, partsCodeLabel);
		layout.putConstraint(SpringLayout.SOUTH, partsCodeField, 100, SpringLayout.SOUTH, partsCodeLabel);
		layout.putConstraint(SpringLayout.EAST, partsCodeField, 600, SpringLayout.WEST, panel);
		partsCodeField.setFont(new Font("Lucida Sans", Font.PLAIN, 50));
		partsCodeField.setHorizontalAlignment(JTextField.CENTER);
		partsCodeField.setCaretColor(new Color(55,55,55,100));
		panel.add(partsCodeField);
		//【モデル１】
		layout.putConstraint(SpringLayout.NORTH, addPanel1, 40, SpringLayout.SOUTH, partsCodeField);
		layout.putConstraint(SpringLayout.WEST, addPanel1, 0, SpringLayout.WEST, partsCodeField);
		layout.putConstraint(SpringLayout.EAST, addPanel1, 780, SpringLayout.WEST, addPanel1);
		layout.putConstraint(SpringLayout.SOUTH, addPanel1, 80, SpringLayout.NORTH, addPanel1);
		panel.add(addPanel1);
		//追加ボタン2
			layout.putConstraint(SpringLayout.NORTH, addPanel2, 30, SpringLayout.SOUTH, addPanel1);
			layout.putConstraint(SpringLayout.WEST, addPanel2, 0, SpringLayout.WEST, addPanel1);
			layout.putConstraint(SpringLayout.EAST, addPanel2, 780, SpringLayout.WEST, addPanel2);
			layout.putConstraint(SpringLayout.SOUTH, addPanel2, 80, SpringLayout.NORTH, addPanel2);
			panel.add(addPanel2);
		//追加ボタン3
			layout.putConstraint(SpringLayout.NORTH, addPanel3, 30, SpringLayout.SOUTH, addPanel2);
			layout.putConstraint(SpringLayout.WEST, addPanel3, 0, SpringLayout.WEST, addPanel1);
			layout.putConstraint(SpringLayout.EAST, addPanel3, 780, SpringLayout.WEST, addPanel3);
			layout.putConstraint(SpringLayout.SOUTH, addPanel3, 80, SpringLayout.NORTH, addPanel3);
			panel.add(addPanel3);
		//追加ボタン4
		layout.putConstraint(SpringLayout.NORTH, addPanel4, 30, SpringLayout.SOUTH, addPanel3);
		layout.putConstraint(SpringLayout.WEST, addPanel4, 0, SpringLayout.WEST, addPanel1);
		layout.putConstraint(SpringLayout.EAST, addPanel4, 780, SpringLayout.WEST, addPanel4);
		layout.putConstraint(SpringLayout.SOUTH, addPanel4, 80, SpringLayout.NORTH, addPanel4);
		panel.add(addPanel4);
		//更新ボタン
		URL url = MainView.class.getResource("/picture/newIcon/micky.jpg");
		ImageIcon icon = new ImageIcon(url);
		newLabel.setIcon(icon);
		layout.putConstraint(SpringLayout.NORTH, newLabel, -40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, newLabel, 650, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.EAST, newLabel, 295, SpringLayout.WEST, newLabel);
		layout.putConstraint(SpringLayout.SOUTH, newLabel, 260, SpringLayout.NORTH, newLabel);
		panel.add(newLabel);
		return panel;
	}
	
    public JComponent getContentPane() {
        return container;
    }

	/**
	 * @return partsCodeLabel
	 */
	public JLabel getPartsCodeLabel() {
		return partsCodeLabel;
	}

	/**
	 * @return partsCodeField
	 */
	public JTextField getPartsCodeField() {
		return partsCodeField;
	}

	/**
	 * @return addPanel1
	 */
	public AddModelPanel getAddPanel1() {
		return addPanel1;
	}

	/**
	 * @return addPanel2
	 */
	public AddModelPanel getAddPanel2() {
		return addPanel2;
	}

	/**
	 * @return addPanel3
	 */
	public AddModelPanel getAddPanel3() {
		return addPanel3;
	}

	/**
	 * @return addPanel4
	 */
	public AddModelPanel getAddPanel4() {
		return addPanel4;
	}

	/**
	 * @return newLabel
	 */
	public JLabel getNewLabel() {
		return newLabel;
	}

	/**
	 * @return mainPanel
	 */
	public JPanel getMainPanel() {
		return panel;
	}

	/**
	 * @return dialog
	 */
	public RisetDialog getDialog() {
		return dialog;
	}

	/**
	 * @return partsView
	 */
	public RemainingPartsView getPartsView() {
		return partsView;
	}

}
