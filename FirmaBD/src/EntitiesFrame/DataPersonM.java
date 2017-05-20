/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesFrame;

import Entities.DataPerson;
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
public class DataPersonM extends AbstractTableModel {

    private ArrayList<DataPerson> list = new ArrayList<>();
    private Connection con;
    private int rowsCount;

    public DataPersonM(Connection con) throws SQLException {
        super();
        this.con = con;
        updateData();
    }

    public void updateData() throws SQLException {
        try {
            getList().clear();
            Statement stmt = getCon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM data_person");
            while (rs.next()) {
                DataPerson dp = new DataPerson(rs.getInt("id_dp"), rs.getString("surname"),
                        rs.getString("firstname"), rs.getString("otchestvo"),
                        rs.getString("passport"), rs.getDate("birthday"),
                        rs.getString("address"), rs.getString("phone"));

                getList().add(dp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        setRowsCount(getList().size());
    }

    public void delete(int id) throws SQLException {
        Statement statement = getCon().createStatement();
        statement.executeUpdate("delete from data_person where id_dp="
                + id + ";");
    }

    @Override
    public int getRowCount() {
        return getRowsCount(); //rowsCount;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                return getList().get(rowIndex).getSurname();
            case 1:
                return getList().get(rowIndex).getFirstname();
            case 2:
                return getList().get(rowIndex).getOtchestvo();
            case 3:
                return getList().get(rowIndex).getPassport();
            case 4:
                return getList().get(rowIndex).getBirthday();
            case 5:
                return getList().get(rowIndex).getAddress();
            case 6:
                return getList().get(rowIndex).getPhone();
            default:
                break;
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
        }
        return null;
    }

    public DataPerson getSelectesDP(int row) {
        return getList().get(row);
    }

    /**
     * @return the list
     */
    public ArrayList<DataPerson> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<DataPerson> list) {
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

}
