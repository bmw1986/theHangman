package thePackage;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;

import javax.swing.JTextArea;

import thePackage.*;

@SuppressWarnings({ "unused", "serial" })
public class popUpGUI extends javax.swing.JFrame {
    //GUI object
    GUI gui = null;
    //KeybindingController object
    KeybindingController keybindingController = null;

    /** Creates new form GUI */
    public popUpGUI() {
        initComponents();
        createObjects();
        gui.searchForPorts();
        keybindingController.toggleControls();
        keybindingController.bindKeys();
    }

    private void createObjects()
    {
    	gui = new GUI(this);
        keybindingController = new KeybindingController(this);
    }
    
    @SuppressWarnings("rawtypes")
	private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblLeft = new javax.swing.JLabel();
        btnLeftAccel = new javax.swing.JButton();
        btnLeftDecel = new javax.swing.JButton();
        btnRightAccel = new javax.swing.JButton();
        lblRight = new javax.swing.JLabel();
        btnRightDecel = new javax.swing.JButton();
        cboxPorts = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btnConnect = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Serial Communicator");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("The Serial Communicator");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Throttle");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Left");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Right");

        lblLeft.setFont(new java.awt.Font("Tahoma", 1, 18));
        lblLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLeft.setText("0");

        btnLeftAccel.setText("/\\");
            btnLeftAccel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnLeftAccelActionPerformed(evt);
                }
            });

            btnLeftDecel.setText("\\/");
            btnLeftDecel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnLeftDecelActionPerformed(evt);
                }
            });

            btnRightAccel.setText("/\\");
                btnRightAccel.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnRightAccelActionPerformed(evt);
                    }
                });

                lblRight.setFont(new java.awt.Font("Tahoma", 1, 18));
                lblRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lblRight.setText("0");

                btnRightDecel.setText("\\/");
                btnRightDecel.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnRightDecelActionPerformed(evt);
                    }
                });

                jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
                jLabel5.setText("Select the COM Port");

                btnConnect.setText("Connect");
                btnConnect.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnConnectActionPerformed(evt);
                    }
                });

                btnDisconnect.setText("Disconnect");
                btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnDisconnectActionPerformed(evt);
                    }
                });

                jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
                jLabel6.setText("Controls");

                jLabel7.setText("Q - Accelerate Left");

                jLabel8.setText("A - Decelerate Left");

                jLabel9.setText("W - Accelerate Both");

                jLabel10.setText("S - Decelerate Both");

                jLabel11.setText("D - Decelerate Right");

                jLabel12.setText("E - Accelerate Right");

                jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
                jLabel13.setText("Log");

                txtLog.setColumns(20);
                txtLog.setEditable(false);
                txtLog.setLineWrap(true);
                txtLog.setRows(5);
                txtLog.setFocusable(false);
                jScrollPane2.setViewportView(txtLog);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboxPorts, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnConnect)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDisconnect))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnLeftDecel)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(lblLeft, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnLeftAccel, javax.swing.GroupLayout.Alignment.LEADING)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnRightDecel)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(lblRight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnRightAccel, javax.swing.GroupLayout.Alignment.LEADING)))))
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9))
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboxPorts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConnect)
                                    .addComponent(btnDisconnect))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLeftAccel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblLeft)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLeftDecel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRightAccel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRight)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRightDecel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void btnLeftAccelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftAccelActionPerformed
        keybindingController.setLeftThrottle(keybindingController.accelerate(keybindingController.getLeftThrottle()));
        keybindingController.updateLabels();
    }//GEN-LAST:event_btnLeftAccelActionPerformed

    private void btnLeftDecelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftDecelActionPerformed
        keybindingController.setLeftThrottle(keybindingController.decelerate(keybindingController.getLeftThrottle()));
        keybindingController.updateLabels();
    }//GEN-LAST:event_btnLeftDecelActionPerformed

    private void btnRightAccelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightAccelActionPerformed
        keybindingController.setRightThrottle(keybindingController.accelerate(keybindingController.getRightThrottle()));
        keybindingController.updateLabels();
    }//GEN-LAST:event_btnRightAccelActionPerformed

    private void btnRightDecelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightDecelActionPerformed
        keybindingController.setRightThrottle(keybindingController.decelerate(keybindingController.getRightThrottle()));
        keybindingController.updateLabels();
    }//GEN-LAST:event_btnRightDecelActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        gui.connect();
        if (gui.getConnected() == true)
        {
            if (gui.initIOStream() == true)
            {
                gui.initListener();
            }
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
        gui.disconnect();
    }//GEN-LAST:event_btnDisconnectActionPerformed
    
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new popUpGUI().setVisible(true);
//            }
//        });
//        
//		//Communicator.writeData(fromConsole);
//        //System.out.println(fromConsole);
//    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnConnect;
    public javax.swing.JButton btnDisconnect;
    public javax.swing.JButton btnLeftAccel;
    public javax.swing.JButton btnLeftDecel;
    public javax.swing.JButton btnRightAccel;
    public javax.swing.JButton btnRightDecel;
    @SuppressWarnings("rawtypes")
	public javax.swing.JComboBox cboxPorts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JLabel lblLeft;
    public javax.swing.JLabel lblRight;
    public javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables

    
}
