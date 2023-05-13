import java.awt.*;
import java.util.Objects;

public class dashboard extends javax.swing.JFrame {

    public dashboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        ListEmp = new javax.swing.JButton();
        updateSal = new javax.swing.JButton();
        new_Emp = new javax.swing.JButton();
        Updt_Emp = new javax.swing.JButton();
        TakeAtten = new javax.swing.JButton();
        GenSlip = new javax.swing.JButton();
        viewAtten = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        Salary = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ListEmp.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        ListEmp.setText("List Employee");
        ListEmp.addActionListener(this::ListEmpActionPerformed);
        getContentPane().add(ListEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 130, 40));

        updateSal.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        updateSal.setText("Update Salary");
        updateSal.addActionListener(this::updateSalActionPerformed);
        getContentPane().add(updateSal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 130, 40));

        new_Emp.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        new_Emp.setText("New Employee");
        new_Emp.addActionListener(this::new_EmpActionPerformed);
        getContentPane().add(new_Emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 130, 40));

        Updt_Emp.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        Updt_Emp.setText("Update Employee");
        Updt_Emp.addActionListener(this::Updt_EmpActionPerformed);
        getContentPane().add(Updt_Emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 130, 40));

        TakeAtten.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12)); // NOI18N
        TakeAtten.setText("Take Attendance");
        TakeAtten.addActionListener(this::TakeAttenActionPerformed);
        getContentPane().add(TakeAtten, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 130, 40));

        GenSlip.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GenSlip.setText("Generate Slip");
        GenSlip.addActionListener(this::GenSlipActionPerformed);
        getContentPane().add(GenSlip, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, 130, 40));

        viewAtten.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewAtten.setText("View Attendance");
        viewAtten.addActionListener(this::viewAttenActionPerformed);
        getContentPane().add(viewAtten, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 310, 130, 40));

        Exit.setBackground(new java.awt.Color(255, 0, 0));
        Exit.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        Exit.setText("Exit");
        Exit.addActionListener(this::ExitActionPerformed);
        getContentPane().add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, 130, 40));

        Salary.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Salary.setText("Salary");
        Salary.addActionListener(this::SalaryActionPerformed);
        getContentPane().add(Salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 130, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/img3.jpeg")))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListEmpActionPerformed
        // TODO add your handling code here:
        new List_Employee().setVisible(true);
    }//GEN-LAST:event_ListEmpActionPerformed

    private void updateSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSalActionPerformed
        // TODO add your handling code here:
        new Update_salary().setVisible(true);
    }//GEN-LAST:event_updateSalActionPerformed

    private void new_EmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_EmpActionPerformed
        // TODO add your handling code here:
        new New_Employee().setVisible(true);
    }//GEN-LAST:event_new_EmpActionPerformed

    private void Updt_EmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Updt_EmpActionPerformed
        // TODO add your handling code here:
        new Update_Employee().setVisible(true);
    }//GEN-LAST:event_Updt_EmpActionPerformed

    private void TakeAttenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeAttenActionPerformed
        // TODO add your handling code here:
        new TakeAttendance().setVisible(true);
    }//GEN-LAST:event_TakeAttenActionPerformed

    private void GenSlipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenSlipActionPerformed
        // TODO add your handling code here:
        new pay_slip().setVisible(true);
    }//GEN-LAST:event_GenSlipActionPerformed

    private void viewAttenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAttenActionPerformed
        // TODO add your handling code here:
        new view_attendance().setVisible(true);
    }//GEN-LAST:event_viewAttenActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void SalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryActionPerformed
        // TODO add your handling code here:
        new Salary().setVisible(true);
    }//GEN-LAST:event_SalaryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton GenSlip;
    private javax.swing.JButton ListEmp;
    private javax.swing.JButton Salary;
    private javax.swing.JButton TakeAtten;
    private javax.swing.JButton Updt_Emp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton new_Emp;
    private javax.swing.JButton updateSal;
    private javax.swing.JButton viewAtten;
    // End of variables declaration//GEN-END:variables
}
