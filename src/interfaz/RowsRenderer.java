package interfaz;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RowsRenderer extends DefaultTableCellRenderer {

	private int columna ;

	public RowsRenderer(int Colpatron)
	{
	    this.columna = Colpatron;
	}

	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
	{        
	    
	    table.setForeground(Color.GRAY);
    
	    super.getTableCellRendererComponent(table, value, selected, focused, row, column);
	    if(table.getValueAt(row,columna).equals(""))
	    {
	        this.setForeground(Color.GREEN);
	        setBackground(Color.DARK_GRAY);

	    }else{
	    	this.setForeground(Color.red);
	    	setBackground(Color.yellow);
	    }
//	    if(row == 0){
//	    	setBackground(Color.blue);
//		    this.setForeground(Color.WHITE);
//	    }
	    
	    return this;
	  }
	
}
