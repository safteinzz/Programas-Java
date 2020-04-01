/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtablestest;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SaFteiNZz
 */
public class VstTableItemModel extends AbstractTableModel {

    private List<usuario> users;

    public VstTableItemModel(List<usuario> users) {

        this.users = new ArrayList<usuario>(users);

    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = "??";
        usuario user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = user.getId();
                break;
            case 1:
                value = user.getNombre();
                break;
            case 2:
                value = user.getPueblo();
                break;            
        }

        return value;

    }

    /*
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return // Return the class that best represents the column...
    }
    */

    /* Override this if you want the values to be editable...
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //....
    }
    */

    /**
     * This will return the user at the specified row...
     * @param row
     * @return 
     */
    public usuario getUserAt(int row) {
        return users.get(row);
    }

}