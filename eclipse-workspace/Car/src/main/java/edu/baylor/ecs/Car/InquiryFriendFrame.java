package edu.baylor.ecs.Car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InquiryFriendFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textField;
	private JFrame frame = new JFrame("Car List"); 
	private String[] columnNames = {"Make", "Model", "Year",
			"Color", "Price"};
	private DefaultTableModel tblModel = new DefaultTableModel();
	private Car myList;
	private Object[][] listData;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton backButton;
	private TableRowSorter<TableModel> rowSorter;
	private JButton addButton;
	private CarFavList favList;

    /**
     * Launch the application.
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
            @SuppressWarnings("unused")
			InquiryFriendFrame frame = new InquiryFriendFrame();
    }

    /**
     * Create the frame.
     * @throws FileNotFoundException 
     */
    public InquiryFriendFrame() throws FileNotFoundException {

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        JLabel label = new JLabel("Search :");
        label.setBounds(12, 12, 75, 18);
        
        
        textField = new JTextField();
        textField.setBounds(80, 7, 189, 28);
        contentPane.add(textField);
        textField.setColumns(10);
        label.setLabelFor(textField);
        contentPane.add(label);
        
        myList = new Car();
        myList.readCSV("CarList1.csv");
        listData = myList.conver2Data();
        tableModel = new DefaultTableModel(listData,columnNames);
        table = new JTable(tableModel);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        textField.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(22, 42, 570, 400);
        contentPane.add(scrollPane);    
        
        backButton = new JButton("Back");
        backButton.setBounds(160, 455, 80, 40);
        contentPane.add(backButton);
        backButton.addActionListener(this);
        
        addButton = new JButton("Add");
        addButton.setBounds(360, 455, 80, 40);
        contentPane.add(addButton);
        addButton.addActionListener(this);
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(650, 570);
		frame.add(contentPane);
		
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
    		frame.dispose();
    		
    	}
		else if(e.getSource() == addButton) {
			int column = 0;
	        int row = table.getSelectedRow();
	        String value = table.getModel().getValueAt(row, column).toString();
	        favList.store(value);
		}
    }
    
    
    
}
