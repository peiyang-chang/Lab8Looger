package edu.baylor.ecs.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class Car extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<CarList> carList;
	private CarList car = new CarList();
	private ArrayList<CarList> CarArrayList = new ArrayList<CarList>();
	private ArrayList<String> col = new
			ArrayList<String>(Arrays.asList("Make", "Model", "Year",
					"Color", "Price"));
	private ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	
	
	public Car() {
		carList = new ArrayList<CarList>();
	}
	
	public void add(CarList a) {
		carList.add(a);
	}
	
    public void loadList() {
    	
    	for(ArrayList<String> listc : list) {
    		CarList car1 = new CarList(listc.get(0),listc.get(1),
    				listc.get(2),listc.get(3),listc.get(4));
    		CarArrayList.add(car1);
    		//AList.add(car1);
    	}
    }
    
    public void setRow(ArrayList<String> listA, int row) {
        list.get(row).clear();
        list.get(row).addAll(listA);
    }
    
    public void readCSV(String fileName) throws FileNotFoundException{
    	Scanner scanner = new Scanner(new File(fileName));
    	while(scanner.hasNext()) {
    		String line = scanner.nextLine();
    		String[] spilt = line.split(",");
    		CarList car = new CarList(spilt[0],spilt[1],spilt[2],
    				spilt[3],spilt[4]);
    		carList.add(car);
    	}
    	scanner.close();
    	loadList();
    }

    public Object[][] conver2Data(){
    	Object[][] data = new Object[carList.size()][5];
    	for(int i = 0; i < carList.size(); i++) {
    		data[i][0] = carList.get(i).getMake();
    		data[i][1] = carList.get(i).getModel();
    		data[i][2] = carList.get(i).getYear();
    		data[i][3] = carList.get(i).getColor();
    		data[i][4] = carList.get(i).getPrice();
    	}
    	return data;
    }

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
