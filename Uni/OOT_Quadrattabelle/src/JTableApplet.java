import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class JTableApplet extends JApplet {
	  public void init() {
		    Container contentPane = getContentPane();
		    contentPane.setLayout(new BorderLayout());
		    TestTableModel myTableModel = new TestTableModel();
		    JTable myJTable = new JTable(myTableModel);
		    JScrollPane myScrollPane = new JScrollPane(myJTable);
		    contentPane.add(myScrollPane ,BorderLayout.CENTER);
		  } 

}
