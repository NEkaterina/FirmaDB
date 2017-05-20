/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesFrame;

import Entities.DataPerson;
import Entities.co_worker;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kathy
 */
public class AddC_W extends javax.swing.JDialog {

    /**
     * @return the c
     */
    public Connection getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Connection c) {
        this.c = c;
    }

    /**
     * @return the editCW
     */
    public co_worker getEditCW() {
        return editCW;
    }

    /**
     * @param editCW the editCW to set
     */
    public void setEditCW(co_worker editCW) {
        this.editCW = editCW;
    }

    /**
     * @return the data
     */
    public List<DataPerson> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<DataPerson> data) {
        this.data = data;
    }
    private Connection c;
    private co_worker editCW;
    private List<DataPerson> data;

    /**
     * Creates new form AddC_W
     */
    public AddC_W(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();
        this.c = c;
        entryCo_Worker();

    }

    public AddC_W(java.awt.Frame parent, boolean modal, Connection c, co_worker cw) {
        super(parent, modal);
        initComponents();
        this.c = c;
        editCW = cw;

        entryCo_Worker();
        fillFields();
        jTextField1.setText(editCW.getPost());
        jTextField2.setText(editCW.getSalary() + "");

    }

    private void entryCo_Worker() {
        data = new ArrayList<>();
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("select id_dp, surname, firstname,"
                    + " otchestvo, passport,birthday,address,phone from data_person left join "
                    + "co_worker on data_person.id_dp = co_worker.fk_dp_cw "
                    + "where co_worker.id_cw IS NULL");
            while (rs.next()) {
                DataPerson tmp = new DataPerson(rs.getInt("id_dp"), rs.getString("surname"),
                        rs.getString("firstname"), rs.getString("otchestvo"),
                        rs.getString("passport"), rs.getDate("birthday"),
                        rs.getString("address"), rs.getString("phone"));
                data.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddData.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBox1.setModel(new DefaultComboBoxModel(getData().toArray()));
    }

    private void fillFields() {

        jComboBox1.setSelectedItem(-1);

        for (DataPerson s : getData()) {
            if (s.getId() != getEditCW().getDataPId()) {
                jComboBox1.setSelectedItem((s));
            }
        }

    }

    public boolean check() {
        if ("".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Surname cannot be empty");
            return false;
        }
        if ("".equals(jTextField2.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Firstname cannot be empty");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Worker");
        jLabel1.setToolTipText("");

        jLabel2.setText("Post");

        jLabel3.setText("Salary");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTextField1.getAccessibleContext().setAccessibleName("Post");
        jTextField2.getAccessibleContext().setAccessibleName("Salary");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!check()) {
            return;
        }
        try {
            // TODO add your handling code here:
            Statement statement = getC().createStatement();
            if (getEditCW() == null) {
                statement.executeUpdate("insert into co_worker (fk_dp_cw,post,"
                        + "salary) values ('" + ((DataPerson) jComboBox1.getSelectedItem()).getId() + "','"
                        + jTextField1.getText() + "','" + jTextField2.getText() + "');");
            } else {
                statement.executeUpdate("update co_worker set  post='" + jTextField1.getText()
                        + "',salary='" + jTextField2.getText()
                        + "' where id_cw=" + getEditCW().getId() + ";");
            }

        } catch (SQLException ex) {
            if (ex.getMessage().contains("User_Login_key")) {
                JOptionPane.showMessageDialog(new JFrame(), "This login already exist");
            } else {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
            return;
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
