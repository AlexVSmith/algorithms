package com.kate;

import com.kate.algorithms.Algoritm_1_6;
import com.kate.debug.Debug;
import com.kate.debug.DebugListener;
import java.awt.Color;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public class MainFrame extends javax.swing.JFrame {
    
    private Algoritm_1_6 algoritm_1_6;
    
    void init(String release) {
        
        String releaseString = "Kate algoritms. Release: " + release;
        setTitle(releaseString);
        
        Debug.setDebugListener(new DebugListener() {
            @Override
            public void print(String flag, String str) {
                printWithProperties(flag, str);
            }
        });

        Debug.print("dbi", releaseString);
        Debug.print("db", "===================================================================================================");
        
        jComboBox_Type_1_6.removeAllItems();
        jComboBox_Type_1_6.addItem("Kate's version of filling (with shift)");
        jComboBox_Type_1_6.addItem("Random filling");

        jComboBox_Type_1_6.setSelectedIndex(0);
        //jSpinner_Days.setValue(11);
        jSpinner_Shift.setValue(3);
        
    }
    
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel_1_6 = new javax.swing.JPanel();
        jLabel_Sheeps = new javax.swing.JLabel();
        jLabel_Days = new javax.swing.JLabel();
        jSpinner_Sheeps = new javax.swing.JSpinner();
        jSpinner_Days = new javax.swing.JSpinner();
        jButton_Solve_1_6 = new javax.swing.JButton();
        jComboBox_Type_1_6 = new javax.swing.JComboBox<>();
        jLabel_Type_1_6 = new javax.swing.JLabel();
        jLabel_Shift = new javax.swing.JLabel();
        jSpinner_Shift = new javax.swing.JSpinner();
        jScrollPane_Debug = new javax.swing.JScrollPane();
        jTextPane_Debug = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane.setDividerLocation(200);
        jSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel_Sheeps.setText("Ships / ports:");

        jLabel_Days.setText("Days:");

        jSpinner_Sheeps.setModel(new javax.swing.SpinnerNumberModel(6, 2, 98, 1));
        jSpinner_Sheeps.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_SheepsStateChanged(evt);
            }
        });

        jSpinner_Days.setModel(new javax.swing.SpinnerNumberModel(7, 3, 99, 1));
        jSpinner_Days.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_DaysStateChanged(evt);
            }
        });

        jButton_Solve_1_6.setText("Solve (get Short Schedule)");
        jButton_Solve_1_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Solve_1_6ActionPerformed(evt);
            }
        });

        jComboBox_Type_1_6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel_Type_1_6.setText("Type of filling Main Schedule:");

        jLabel_Shift.setText("Shift:");

        jSpinner_Shift.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
        jSpinner_Shift.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_ShiftStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel_1_6Layout = new javax.swing.GroupLayout(jPanel_1_6);
        jPanel_1_6.setLayout(jPanel_1_6Layout);
        jPanel_1_6Layout.setHorizontalGroup(
            jPanel_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_1_6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel_1_6Layout.createSequentialGroup()
                            .addGroup(jPanel_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_Sheeps)
                                .addComponent(jLabel_Days)
                                .addComponent(jLabel_Shift))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSpinner_Sheeps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinner_Days, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinner_Shift, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton_Solve_1_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox_Type_1_6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel_Type_1_6))
                .addContainerGap(543, Short.MAX_VALUE))
        );
        jPanel_1_6Layout.setVerticalGroup(
            jPanel_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_1_6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel_Type_1_6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_Type_1_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Sheeps)
                    .addComponent(jSpinner_Sheeps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Days)
                    .addComponent(jSpinner_Days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_1_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner_Shift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Shift))
                .addGap(18, 18, 18)
                .addComponent(jButton_Solve_1_6)
                .addContainerGap())
        );

        jTabbedPane.addTab("1-6", jPanel_1_6);

        jSplitPane.setTopComponent(jTabbedPane);

        jScrollPane_Debug.setAutoscrolls(true);

        jTextPane_Debug.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jScrollPane_Debug.setViewportView(jTextPane_Debug);

        jSplitPane.setRightComponent(jScrollPane_Debug);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Solve_1_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Solve_1_6ActionPerformed
        //Debug.print("w", "jComboBox_Type_1_6.getSelectedIndex() == " + jComboBox_Type_1_6.getSelectedIndex());
        if (algoritm_1_6 == null) {
            algoritm_1_6 = new Algoritm_1_6();
        }
        algoritm_1_6.init((int) jSpinner_Sheeps.getValue(), (int) jSpinner_Days.getValue());
        algoritm_1_6.getSchedules(jComboBox_Type_1_6.getSelectedIndex(), (int) jSpinner_Shift.getValue());
    }//GEN-LAST:event_jButton_Solve_1_6ActionPerformed

    private void jSpinner_SheepsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_SheepsStateChanged
        int numOfNewSheepsPorts = (int) jSpinner_Sheeps.getValue();
        if (numOfNewSheepsPorts >= (int) jSpinner_Days.getValue()) {
            jSpinner_Days.setValue(numOfNewSheepsPorts + 1);
        }
    }//GEN-LAST:event_jSpinner_SheepsStateChanged

    private void jSpinner_DaysStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_DaysStateChanged
        int numOfDays = (int) jSpinner_Days.getValue();
        if (numOfDays <= (int) jSpinner_Sheeps.getValue()) {
            jSpinner_Sheeps.setValue(numOfDays - 1);
        }
        if (numOfDays <= (int) jSpinner_Shift.getValue()) {
            jSpinner_Shift.setValue(numOfDays - 1);
        }
    }//GEN-LAST:event_jSpinner_DaysStateChanged

    private void jSpinner_ShiftStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_ShiftStateChanged
        int shift = (int) jSpinner_Shift.getValue();
        if (shift > (int) jSpinner_Days.getValue() - 1) {
            jSpinner_Shift.setValue((int) jSpinner_Days.getValue() - 1);
        }
    }//GEN-LAST:event_jSpinner_ShiftStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Solve_1_6;
    private javax.swing.JComboBox<String> jComboBox_Type_1_6;
    private javax.swing.JLabel jLabel_Days;
    private javax.swing.JLabel jLabel_Sheeps;
    private javax.swing.JLabel jLabel_Shift;
    private javax.swing.JLabel jLabel_Type_1_6;
    private javax.swing.JPanel jPanel_1_6;
    private javax.swing.JScrollPane jScrollPane_Debug;
    private javax.swing.JSpinner jSpinner_Days;
    private javax.swing.JSpinner jSpinner_Sheeps;
    private javax.swing.JSpinner jSpinner_Shift;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextPane jTextPane_Debug;
    // End of variables declaration//GEN-END:variables

    private void writeToDebugTextPane(String str, Color color, boolean italic, boolean bold) {
        StyledDocument doc = jTextPane_Debug.getStyledDocument();
        SimpleAttributeSet sas = new SimpleAttributeSet();
        sas.addAttribute(javax.swing.text.StyleConstants.Foreground,    color);
        sas.addAttribute(javax.swing.text.StyleConstants.Italic,        italic);
        sas.addAttribute(javax.swing.text.StyleConstants.Bold,          bold);
        try {
            doc.insertString(doc.getLength(), str, sas);
            doc.insertString(doc.getLength(), "\n", sas);
        } catch (BadLocationException ex) {
            Debug.print("e", "Error: " + ex.getClass() + ":" + ex.getMessage());
        }
        jTextPane_Debug.repaint();
    }

    private void printWithProperties(String flag, String str) {
        Color color     = Color.BLACK;
        boolean bold    = false;
        boolean italic  = false;
        
        if (flag.length() == 3) {
            if (flag.substring(2).equals("i")) {
                italic  = true;
            }
            else if (flag.substring(2).equals("b")) {
                bold  = true;
            }
            flag = flag.substring(0, 2);
        }

        if (flag.length() == 2) {
            if (flag.substring(1).equals("i")) {
                italic  = true;
            }
            else if (flag.substring(1).equals("b")) {
                bold  = true;
            }
            flag = flag.substring(0, 1);
        }
        
        switch (flag) {
            case "b":
                color = Color.BLUE;
                break;
            case "d":
                color = new Color(13, 98, 4);
                break;
            case "c":
                color = Color.CYAN;
                break;
            case "g":
                color = Color.GREEN;
                break;
            case "m":
                color = Color.MAGENTA;
                break;
            case "o":
                color = Color.ORANGE;
                break;
            case "p":
                color = Color.PINK;
                break;
            case "y":
                color = Color.YELLOW;
                break;
            case "r":
                color = Color.RED;
                break;
            case "w":
                color   = new Color(255, 0, 255);
                break;
        }
        
        writeToDebugTextPane(str, color, italic, bold);
    }
}
