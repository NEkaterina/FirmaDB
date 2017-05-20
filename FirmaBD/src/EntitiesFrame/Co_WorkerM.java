/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesFrame;

import Entities.Client;
import Entities.co_worker;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kathy
 */
public class Co_WorkerM extends AbstractTableModel {

    /**
     * @return the list
     */
    public List<co_worker> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<co_worker> list) {
        this.list = list;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the stmt
     */
    public Statement getStmt() {
        return stmt;
    }

    /**
     * @param stmt the stmt to set
     */
    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the rowsCount
     */
    public int getRowsCount() {
        return rowsCount;
    }

    /**
     * @param rowsCount the rowsCount to set
     */
    public void setRowsCount(int rowsCount) {
        this.rowsCount = rowsCount;
    }
    private List<co_worker> list = new ArrayList<>();
    private Connection con;
    private Statement stmt = null;
    private ResultSet rs = null;
    private int rowsCount;

    public Co_WorkerM(Connection con) throws SQLException {
        super();
        this.con = con;
        updateData();
    }

    public void updateData() throws SQLException {
        try {
            getList().clear();
            setStmt(getCon().createStatement());
            setRs(getStmt().executeQuery("SELECT * FROM co_worker"));
            while (getRs().next()) {
                co_worker cw = new co_worker(getRs().getInt("id_cw"),
                        getRs().getInt("fk_dp_cw"), getRs().getString("post"),
                        getRs().getInt("salary"));
                getList().add(cw);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        setRowsCount(getList().size());
    }

    public void delete(int id) throws SQLException {
        Statement statement = getCon().createStatement();
        statement.executeUpdate("delete from co_worker where id_cw="
                + id + ";");
    }

    @Override
    public int getRowCount() {
        return getList().size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                try {
                    Statement statement = getCon().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM data_person where id_dp=" + getList().get(rowIndex).getDataPId() + ";");
                    rs.next();
                    s = rs.getString("surname");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 1:
                try {
                    Statement statement = getCon().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM data_person where id_dp=" + getList().get(rowIndex).getDataPId() + ";");
                    rs.next();

                    s = rs.getString("firstname");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 2:
                try {
                    Statement statement = getCon().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM data_person where id_dp=" + getList().get(rowIndex).getDataPId() + ";");
                    rs.next();

                    s = rs.getString("otchestvo");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 3:
                try {
                    Statement statement = getCon().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM data_person where id_dp=" + getList().get(rowIndex).getDataPId() + ";");
                    rs.next();

                    s = rs.getString("passport");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 4:
                try {
                    Statement statement = getCon().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM data_person where id_dp=" + getList().get(rowIndex).getDataPId() + ";");
                    rs.next();

                    s = rs.getString("birthday");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 5:
                try {
                    Statement statement = getCon().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM data_person where id_dp=" + getList().get(rowIndex).getDataPId() + ";");
                    rs.next();

                    s = rs.getString("address");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 6:
                try {
                    Statement statement = getCon().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM data_person where id_dp=" + getList().get(rowIndex).getDataPId() + ";");
                    rs.next();

                    s = rs.getString("phone");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 7:
                return getList().get(rowIndex).getPost();
            case 8:
                return getList().get(rowIndex).getSalary();

        }
        return null;
    }

    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "Surname";
            case 1:
                return "Firstname";
            case 2:
                return "Otchestvo";
            case 3:
                return "Passport";
            case 4:
                return "Birthday";
            case 5:
                return "Address";
            case 6:
                return "Phone";
            case 7:
                return "Post";
            case 8:
                return "Salary";
        }
        return null;
    }

    public co_worker getSelectesCW(int row) {
        return getList().get(row);
    }

}
