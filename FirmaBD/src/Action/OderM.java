/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Entities.Selling;
import Entities.SellingMaterials;
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
public class OderM extends AbstractTableModel {
    private List<SellingMaterials> list = new ArrayList<>();
     
    private Connection c;
    public OderM(Connection c) {
        super();
        this.c = c;
        updateData();
    }

    public void updateData() {
        try {
            Statement statement = getC().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM selling_materials");
            setList(new ArrayList<>());

            while (rs.next()) {
                SellingMaterials item = new SellingMaterials(rs.getInt("fk_id_selling"),
                        rs.getInt("fk_id_materials"), rs.getInt("amount"));

                getList().add(item); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        setRowsCount(getList().size());
    }
   
    private int rowsCount;
    private int colCount = 7;

    @Override
    public int getRowCount() {
        return getList().size();
    }

    @Override
    public int getColumnCount() {
        return getColCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                try {
                    Statement statement = getC().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * " +
                            " FROM selling"
                            + " where id_selling=" + getList().get(rowIndex).getSellingId()+ ";");
                    rs.next();
                    s = rs.getString("number_contract");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 1:
                try {
                    Statement statement = getC().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * " +
                            " FROM selling"
                            + " where id_selling=" + getList().get(rowIndex).getSellingId()+ ";");
                    rs.next();
                    s = rs.getString("date_selling");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 2:
                try {
                    Statement statement = getC().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT CONCAT_WS(' ', surname,firstname,otchestvo) AS FIO_Worker " +
                            "FROM data_person join co_worker on data_person.id_dp = co_worker.fk_dp_cw join selling on " +
                            "co_worker.id_cw=selling.fk_id_cw" +
                            " join selling_materials on selling.id_selling = selling_materials.fk_id_selling"
                            + " where id_selling=" + getList().get(rowIndex).getSellingId()+ ";");
                    rs.next();
                    s = rs.getString("FIO_Worker");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 3:
                try {
                    Statement statement = getC().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT CONCAT_WS(' ', surname,firstname,otchestvo) AS FIO_Client " +
                            "FROM data_person join client on data_person.id_dp = client.fk_dp_client join selling on " +
                            "client.id_client = selling.fk_id_client" + 
                            " join selling_materials on selling.id_selling = selling_materials.fk_id_selling"
                            + " where id_selling=" + getList().get(rowIndex).getSellingId() + ";");
                   rs.next();
                        s = rs.getString("FIO_Client");
                    

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 4:
                try {
                    Statement statement = getC().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT CONCAT_WS('  cost: ', name_materials, price_materials) AS Inf"
                            + " FROM materials where id_materials=" + getList().get(rowIndex).getMaterialsId() + ";");
                    rs.next();
                    s = rs.getString("Inf");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
           
          
                  case 5:
                return getList().get(rowIndex).getAmount();
                  case 6:
                      int k=0;
                    try {
                    Statement statement = getC().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT price_materials as price"
                            + " FROM materials join selling_materials on selling_materials.fk_id_materials"
                            + " = materials.id_materials "
                            + "where id_materials=" + getList().get(rowIndex).getMaterialsId() + ";");
                    rs.next();
                    s = rs.getString("price");
                    k= Integer.parseInt(s)*getList().get(rowIndex).getAmount();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }  
                    return ""+k;
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Number contract";
            case 1:
                return "Date";
            case 2:
                return "FIO worker";
            case 3:
                return "FIO client";
            case 4:
                return "Name materials";
            case 5:
                return "Amount";
            case 6:
                return "Summa";
        }
        return null;
    }

    public SellingMaterials getSelectesItem(int row) {
        return getList().get(row);
    }

    /**
     * @return the list
     */
    public List<SellingMaterials> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<SellingMaterials> list) {
        this.list = list;
    }

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

    /**
     * @return the colCount
     */
    public int getColCount() {
        return colCount;
    }

    /**
     * @param colCount the colCount to set
     */
    public void setColCount(int colCount) {
        this.colCount = colCount;
    }
}


