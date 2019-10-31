package edu.baylor.ecs.Car;

import java.util.ArrayList;

public class CarFavList {
	private ArrayList<ArrayList<String> > aList =  
            new ArrayList<ArrayList<String> >();
	
	public void store(String str) {
		ArrayList<String> a = new ArrayList<String>(); 
		a.add(str);
		aList.add(a);
	}
	@SuppressWarnings("null")
	public String[] show() {
		String[] list = null; 
		for(int i = 0; i < aList.size(); i++) {
			for(int j = 0; j < aList.get(i).size(); j++) {
				list[j] = aList.get(i).get(j);
			}
			
		}
		return list;
	}
	
}
