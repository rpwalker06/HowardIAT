/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implicit;

import java.util.HashMap;
import javax.swing.JLabel;

/**
 *
 * @author Robert Walker
 */
public class fourStimulusPanel extends javax.swing.JPanel {
    
    public HashMap<Integer, JLabel> stimulusMapping = new HashMap<>();

    /**
     * Creates new form twoStimulusPanel
     */
    public fourStimulusPanel() {
        initComponents();
    }
    
    private void mapLabels ()
    {
        stimulusMapping.put(experimentView.LEFT_TOP_INDEX, lbl_LeftTopStimulus);
        stimulusMapping.put(experimentView.LEFT_BOTTOM_INDEX, lbl_LeftBottomStimulus);
        stimulusMapping.put(experimentView.RIGHT_TOP_INDEX, lbl_RightTopStimulus);
        stimulusMapping.put(experimentView.RIGHT_BOTTOM_INDEX, lbl_RightBottomStimulus);
        stimulusMapping.put(experimentView.FOCUS_INDEX, lbl_FocusStimulus);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_LeftTopStimulus = new javax.swing.JLabel();
        lbl_RightTopStimulus = new javax.swing.JLabel();
        lbl_LeftConnectPhrase = new javax.swing.JLabel();
        lbl_RightConnectPhrase = new javax.swing.JLabel();
        lbl_RightBottomStimulus = new javax.swing.JLabel();
        lbl_LeftBottomStimulus = new javax.swing.JLabel();
        lbl_FocusStimulus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lbl_LeftTopStimulus.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_LeftTopStimulus.setForeground(new java.awt.Color(255, 255, 255));
        lbl_LeftTopStimulus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_LeftTopStimulus.setText("jLabel1");
        lbl_LeftTopStimulus.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_LeftTopStimulus.setName("0"); // NOI18N

        lbl_RightTopStimulus.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_RightTopStimulus.setForeground(new java.awt.Color(255, 255, 255));
        lbl_RightTopStimulus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_RightTopStimulus.setText("jLabel1");
        lbl_RightTopStimulus.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lbl_RightTopStimulus.setName("1"); // NOI18N

        lbl_LeftConnectPhrase.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_LeftConnectPhrase.setForeground(new java.awt.Color(255, 255, 255));
        lbl_LeftConnectPhrase.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_LeftConnectPhrase.setText("or");
        lbl_LeftConnectPhrase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_RightConnectPhrase.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_RightConnectPhrase.setForeground(new java.awt.Color(255, 255, 255));
        lbl_RightConnectPhrase.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_RightConnectPhrase.setText("or");
        lbl_RightConnectPhrase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_RightBottomStimulus.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_RightBottomStimulus.setForeground(new java.awt.Color(0, 255, 0));
        lbl_RightBottomStimulus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_RightBottomStimulus.setText("jLabel1");
        lbl_RightBottomStimulus.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_RightBottomStimulus.setName("3"); // NOI18N

        lbl_LeftBottomStimulus.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbl_LeftBottomStimulus.setForeground(new java.awt.Color(0, 255, 0));
        lbl_LeftBottomStimulus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_LeftBottomStimulus.setText("jLabel1");
        lbl_LeftBottomStimulus.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbl_LeftBottomStimulus.setName("2"); // NOI18N

        lbl_FocusStimulus.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_FocusStimulus.setForeground(new java.awt.Color(255, 255, 255));
        lbl_FocusStimulus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_FocusStimulus.setText("jLabel7");
        lbl_FocusStimulus.setName("4"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_LeftBottomStimulus, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
                        .addComponent(lbl_RightBottomStimulus, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_LeftTopStimulus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_LeftConnectPhrase, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_RightConnectPhrase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_RightTopStimulus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
            .addComponent(lbl_FocusStimulus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_LeftTopStimulus, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lbl_RightTopStimulus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_LeftConnectPhrase, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_RightConnectPhrase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_RightBottomStimulus, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(lbl_LeftBottomStimulus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addComponent(lbl_FocusStimulus, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(110, 110, 110))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        mapLabels();
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_FocusStimulus;
    private javax.swing.JLabel lbl_LeftBottomStimulus;
    private javax.swing.JLabel lbl_LeftConnectPhrase;
    private javax.swing.JLabel lbl_LeftTopStimulus;
    private javax.swing.JLabel lbl_RightBottomStimulus;
    private javax.swing.JLabel lbl_RightConnectPhrase;
    private javax.swing.JLabel lbl_RightTopStimulus;
    // End of variables declaration//GEN-END:variables
}
