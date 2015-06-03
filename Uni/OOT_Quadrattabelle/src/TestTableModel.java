import javax.swing.table.AbstractTableModel;

public class TestTableModel extends AbstractTableModel {
	private int nrOfColumns = 2;
	private Class<?>[] columnClasses = { java.lang.Integer.class,
			java.lang.Double.class };
	private int nrOfRows = 1000000;

	public Class<?> getColumnClass(int columnIndex) {
		System.out.println("getColumnClass(" + columnIndex + ")");
		return columnClasses[columnIndex];
	}

	public String getColumnName(int columnIndex) {
		System.out.println("getColumnName(" + columnIndex + ")");
		if (columnIndex == 0)
			return "x";
		else
			return "sqrt(x)";
	}

	public int getColumnCount() {
		System.out.println("getColumnCount()");
		return nrOfColumns;
	}

	public int getRowCount() {
		System.out.println("getRowCount()");
		return nrOfRows;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("getValueAt(" + rowIndex + ", " + columnIndex + ")");
		if (columnIndex == 0)
			return new Integer(rowIndex);
		else
			return new Double(Math.sqrt(rowIndex));
	}

}
