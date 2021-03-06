/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implicitForms;

/**
 *
 * @author Robert Walker
 */
public class implicitControlFrame extends javax.swing.JFrame {

    configForm formConfig;
    testStartForm startForm;
    
    /**
     * Creates new form implicitControlFrame
     */
    public implicitControlFrame() {
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

        lbl_SplashTitle = new javax.swing.JLabel();
        btn_CreateConfiguration = new javax.swing.JButton();
        btn_StartFromExisting = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 125));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        lbl_SplashTitle.setBackground(new java.awt.Color(0, 0, 204));
        lbl_SplashTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_SplashTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbl_SplashTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_SplashTitle.setText("Howard Implicit Association Test");
        lbl_SplashTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray));
        lbl_SplashTitle.setMaximumSize(new java.awt.Dimension(500, 50));
        lbl_SplashTitle.setMinimumSize(new java.awt.Dimension(500, 14));
        lbl_SplashTitle.setOpaque(true);
        lbl_SplashTitle.setPreferredSize(new java.awt.Dimension(500, 14));
        getContentPane().add(lbl_SplashTitle);

        btn_CreateConfiguration.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_CreateConfiguration.setText("Create a New Configuration");
        btn_CreateConfiguration.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_CreateConfiguration.setMaximumSize(new java.awt.Dimension(500, 23));
        btn_CreateConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CreateConfigurationActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CreateConfiguration);

        btn_StartFromExisting.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_StartFromExisting.setText("Start from Existing Configuration");
        btn_StartFromExisting.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        btn_StartFromExisting.setMaximumSize(new java.awt.Dimension(500, 23));
        btn_StartFromExisting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StartFromExistingActionPerformed(evt);
            }
        });
        getContentPane().add(btn_StartFromExisting);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CreateConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CreateConfigurationActionPerformed
        openConfigForm();
        dispose();
    }//GEN-LAST:event_btn_CreateConfigurationActionPerformed

    private void btn_StartFromExistingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StartFromExistingActionPerformed
        openStartingForm();
        dispose();
    }//GEN-LAST:event_btn_StartFromExistingActionPerformed

    private void openConfigForm() {
        
        formConfig = new configForm();
        formConfig.setVisible(true);
    }
    
    private void openStartingForm() {
        
        startForm = new testStartForm();
        startForm.setVisible(true);
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CreateConfiguration;
    private javax.swing.JButton btn_StartFromExisting;
    private javax.swing.JLabel lbl_SplashTitle;
    // End of variables declaration//GEN-END:variables
}
