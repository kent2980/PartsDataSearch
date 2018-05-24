package com.controller.addpanel;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import com.controller.main.CharacterIconCustomHandler;

import jp.data.view.AddModelPanel;

public class DeleteModelIconCustomHandler implements MouseListener{
	private final JLabel batuLabel;
	private final JComboBox<String> combo;
	private final DefaultComboBoxModel<String> model;
	private final List<Map<String,String>> modelDataSetList;
	private final List<Map<Integer, String>> partsStreamSet;
	private static ImageIcon iconSelect;
	private static ImageIcon iconLight;

	static {
		URL url1 = CharacterIconCustomHandler.class.getResource("/picture/newIcon/batuSelect.png");
		iconSelect = new ImageIcon(url1);
		Image image1 = iconSelect.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconSelect = new ImageIcon(image1);


		URL url2 = CharacterIconCustomHandler.class.getResource("/picture/newIcon/batu.png");
		iconLight = new ImageIcon(url2);
		Image image2 = iconLight.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconLight = new ImageIcon(image2);
	}

	public DeleteModelIconCustomHandler(List<Map<String,String>> modelDataSetList, List<Map<Integer, String>> partsStreamSet, AddModelPanel addPanel){
		this.batuLabel = addPanel.getBatuLabel();
		this.combo = addPanel.getCombo();
		this.model = addPanel.getModel();
		this.modelDataSetList = modelDataSetList;
		this.partsStreamSet = partsStreamSet;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		batuLabel.setIcon(iconSelect);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		batuLabel.setIcon(iconLight);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(! combo.getSelectedItem().equals("モデルを追加してください") && model.getSize() == 1) {
			model.addElement("モデルを追加してください");
		    combo.setSelectedItem("モデルを追加してください");
		    model.removeElementAt(0);
			modelDataSetList.remove(0);
			partsStreamSet.remove(0);
			combo.setModel(model);
		}else if(model.getSize() > 1){
			int i = combo.getSelectedIndex();
			model.removeElementAt(i);
			modelDataSetList.remove(i);
			partsStreamSet.remove(i);
			combo.setModel(model);
		}
		batuLabel.setIcon(iconLight);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		batuLabel.setIcon(iconSelect);
	}
}
