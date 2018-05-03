package jp.data.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import jp.data.controller.MainViewController;

public class MainViewTest {
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("MainViewTest");
                
                MainView mainView = new MainView();
                new MainViewController(mainView);
                frame.setBounds(200, 100, 1000, 650);
                frame.setResizable(false);
                frame.setContentPane(mainView.getContentPane());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
