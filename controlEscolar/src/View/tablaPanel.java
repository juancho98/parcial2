/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class tablaPanel extends JPanel implements TableModelListener{
    
    public tablaPanel(Object[][] data, String[] columnNames){
        super();
        super.setSize(500, 500);
        
        JTable table = new JTable(new modeloTabla(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        table.getModel().addTableModelListener(this);
        
        super.add(scrollPane);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        modeloTabla model = (modeloTabla)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

        // Do something with the data...
        System.out.println(data);
    }
}
