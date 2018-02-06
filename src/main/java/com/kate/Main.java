package com.kate;

import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        String release = "2018-02-06 17:00";

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(0);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.init(release);
                mainFrame.setVisible(true);
            }
        });
    }
    
}
