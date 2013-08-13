/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package display.gui;

import display.displayslaves.CraftingDisplaySlave;
import javax.swing.DefaultListModel;

/**
 *
 * @author Austin
 */
public class CraftingGUI extends javax.swing.JFrame {

    public DefaultListModel listModel = new DefaultListModel();
    public CraftingGUI() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        craftSpace3 = new javax.swing.JPanel();
        craftThree = new javax.swing.JLabel();
        craftSpace2 = new javax.swing.JPanel();
        craftTwo = new javax.swing.JLabel();
        craftSpace1 = new javax.swing.JPanel();
        craftOne = new javax.swing.JLabel();
        finalCraftSpace = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        craftSpace3.setBackground(new java.awt.Color(204, 204, 255));
        craftSpace3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        craftSpace3.setForeground(new java.awt.Color(255, 255, 255));
        craftSpace3.setPreferredSize(new java.awt.Dimension(75, 75));
        craftSpace3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                craftSpace3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout craftSpace3Layout = new javax.swing.GroupLayout(craftSpace3);
        craftSpace3.setLayout(craftSpace3Layout);
        craftSpace3Layout.setHorizontalGroup(
            craftSpace3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(craftThree, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );
        craftSpace3Layout.setVerticalGroup(
            craftSpace3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(craftThree, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        craftSpace2.setBackground(new java.awt.Color(204, 204, 255));
        craftSpace2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        craftSpace2.setForeground(new java.awt.Color(255, 255, 255));
        craftSpace2.setPreferredSize(new java.awt.Dimension(75, 75));
        craftSpace2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                craftSpace2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout craftSpace2Layout = new javax.swing.GroupLayout(craftSpace2);
        craftSpace2.setLayout(craftSpace2Layout);
        craftSpace2Layout.setHorizontalGroup(
            craftSpace2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(craftTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );
        craftSpace2Layout.setVerticalGroup(
            craftSpace2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(craftTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        craftSpace1.setBackground(new java.awt.Color(204, 204, 255));
        craftSpace1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        craftSpace1.setForeground(new java.awt.Color(255, 255, 255));
        craftSpace1.setPreferredSize(new java.awt.Dimension(75, 75));
        craftSpace1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                craftSpace1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout craftSpace1Layout = new javax.swing.GroupLayout(craftSpace1);
        craftSpace1.setLayout(craftSpace1Layout);
        craftSpace1Layout.setHorizontalGroup(
            craftSpace1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(craftOne, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );
        craftSpace1Layout.setVerticalGroup(
            craftSpace1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(craftOne, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        finalCraftSpace.setBackground(new java.awt.Color(255, 153, 153));
        finalCraftSpace.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        finalCraftSpace.setForeground(new java.awt.Color(255, 255, 255));
        finalCraftSpace.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout finalCraftSpaceLayout = new javax.swing.GroupLayout(finalCraftSpace);
        finalCraftSpace.setLayout(finalCraftSpaceLayout);
        finalCraftSpaceLayout.setHorizontalGroup(
            finalCraftSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );
        finalCraftSpaceLayout.setVerticalGroup(
            finalCraftSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );

        itemList.setModel(listModel);
        itemList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                itemListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(itemList);

        jLabel1.setText("Crafting");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(craftSpace1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finalCraftSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(craftSpace2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(craftSpace3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(craftSpace1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(craftSpace2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(craftSpace3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(finalCraftSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void craftSpace1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_craftSpace1MouseClicked
        CraftingDisplaySlave.displayList(1);
    }//GEN-LAST:event_craftSpace1MouseClicked

    private void craftSpace2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_craftSpace2MouseClicked
        CraftingDisplaySlave.displayList(2);
    }//GEN-LAST:event_craftSpace2MouseClicked

    private void craftSpace3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_craftSpace3MouseClicked
        CraftingDisplaySlave.displayList(3);
    }//GEN-LAST:event_craftSpace3MouseClicked

    private void itemListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_itemListValueChanged
        CraftingDisplaySlave.displayCraftingItem();
    }//GEN-LAST:event_itemListValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CraftingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CraftingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CraftingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CraftingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CraftingGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel craftOne;
    private javax.swing.JPanel craftSpace1;
    private javax.swing.JPanel craftSpace2;
    private javax.swing.JPanel craftSpace3;
    public javax.swing.JLabel craftThree;
    public javax.swing.JLabel craftTwo;
    private javax.swing.JPanel finalCraftSpace;
    public javax.swing.JList itemList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
