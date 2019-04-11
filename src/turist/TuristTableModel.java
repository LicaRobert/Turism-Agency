package turist;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TuristTableModel implements TableModel {
	private List<Turist> turisti;

	public TuristTableModel(List<Turist> lista) {
		// TODO Auto-generated constructor stub
		turisti = lista;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return turisti.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return "Id";
		case 1:
			return "Nume";
		case 2:
			return "Sex";
		case 3:
			return "Varsta";
		case 4:
			return "Inceput sejur";
		case 5:
			return "Sfarsit sejur";
		case 6:
			return "Statiune dorita";
		}
		return "";
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0 || columnIndex == 2)
			return Integer.class;
		if (columnIndex == 7) {
			return JButton.class;
		}
		return String.class;
	}
    
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	
		//return columnIndex == 5;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (rowIndex >= turisti.size())
			return null;
		Turist turist = turisti.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return turist.getId();
		case 1:
			return turist.getNume();
		case 2:
			return turist.getSex();
		case 3:
			return turist.getVarsta();
		case 4:
			return turist.getPsejur();
		case 5:
			return turist.getSsejur();
		case 6:
			return turist.getStatiune();
		
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
