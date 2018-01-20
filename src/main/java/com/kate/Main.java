package com.kate;

import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        String release = "2018-01-20 19:45";

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
