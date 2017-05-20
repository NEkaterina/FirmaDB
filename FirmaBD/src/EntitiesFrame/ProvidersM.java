/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesFrame;

import Entities.Providers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kathy
 */
public class ProvidersM extends AbstractTableModel {

    /**
     * @return the list
     */
    public ArrayList<Providers> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<Providers> list) {
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
    private ArrayList<Providers> list = new ArrayList<>();
    private Connection con;
    private Statement stmt = null;
    private ResultSet rs = null;
    private int rowsCount;

    public ProvidersM(Connection con) throws SQLException {
        super();
        this.con = con;
        updateData();

    }

    public void updateData() throws SQLException {
        try {
            getList().clear();
            Statement stmt = getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM providers");
            while (rs.next()) {
                Providers p = new Providers(rs.getInt("id_providers"), rs.getString("company_name"),
                        rs.getString("address_company"), rs.getString("phone_company"));

                getList().add(p);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        setRowsCount(getList().size());
    }

    public void delete(int id) throws SQLException {
        Statement statement = getCon().createStatement();
        statement.executeUpdate("delete from providers where id_providers="
                + id + ";");
    }

    @Override
    public int getRowCount() {
        return getList().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                return getList().get(rowIndex).getCompany_name();
            case 1:
                return getList().get(rowIndex).getAddress_company();
            case 2:
                return getList().get(rowIndex).getPhone_company();
            default:
                break;
        }

        return null;
    }

    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "Name";
            case 1:
                return "Address";
            case 2:
                return "Phone";

        }
        return null;
    }

    public Providers getSelectesP(int row) {
        return getList().get(row);
    }

}
