/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesFrame;

import Entities.Materials;
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
public class MaterialsM extends AbstractTableModel {

    /**
     * @return the list
     */
    public ArrayList<Materials> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<Materials> list) {
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
    private ArrayList<Materials> list = new ArrayList<>();
    private Connection con;
    private Statement stmt = null;
    private ResultSet rs = null;
    private int rowsCount;

    public MaterialsM(Connection con) throws SQLException {
        super();
        this.con = con;
        updateData();
    }

    public void updateData() throws SQLException {
        try {
            getList().clear();
            Statement stmt = getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM materials");
            while (rs.next()) {
                Materials m = new Materials(rs.getInt("id_materials"), rs.getString("name_materials"),
                        rs.getInt("amount_materials"), rs.getInt("price_materials"), rs.getInt("fk_providers"));

                getList().add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        setRowsCount(getList().size());
    }

    public void delete(int id) throws SQLException {
        Statement statement = getCon().createStatement();
        statement.executeUpdate("delete from materials where id_materials="
                + id + ";");
    }

    @Override
    public int getRowCount() {
        return getList().size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                return getList().get(rowIndex).getName_materials();
            case 1:
                return getList().get(rowIndex).getAmount_materials();
            case 2:
                return getList().get(rowIndex).getPrice_materials();
            case 3:
                try {
                    Statement statement = getCon().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM providers where id_providers=" + getList().get(rowIndex).getProvidersId() + ";");
                    rs.next();

                    s = rs.getString("company_name");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
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
                return "Amount";
            case 2:
                return "Price";
            case 3:
                return "Provider";

        }
        return null;
    }

    public Materials getSelectesM(int row) {
        return getList().get(row);
    }

}
