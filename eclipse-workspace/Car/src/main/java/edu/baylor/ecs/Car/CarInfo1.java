package edu.baylor.ecs.Car;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarInfo1 extends JFrame implements ActionListener{
	private JPanel contentPane;
	private CarInfo1 image;
	private JButton okButton;
	private JButton FavorButton;
	private JFrame frame = new JFrame("2018 Mercedes-Benz E200");
	private CarFavList info;
	private String carName = "2018 Mercedes-Benz E200";
	
	public CarInfo1() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
		
		JLabel label = new JLabel();
		ImageIcon img = new ImageIcon("BenzE200.jpg");
		label.setIcon(img);
		label.setBounds(125,25,500,333);
		contentPane.add(label);
		
		JLabel label1 = new JLabel("Test");
		label1.setText("The 2018 Mercedes-Benz E200 is an intriguing luxury sedan. On the one hand, it doesn’t get ");
		label1.setBounds(100, 350, 600, 85);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Test");
		label2.setText("the power and performance of some of its more brawny siblings within the E (and indeed C-");
		label2.setBounds(100, 370, 600, 85);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Test");
		label3.setText("Class) portfolio, but on the other, it gets all the luxury inclusions, safety and technology at a ");
		label3.setBounds(100, 390, 600, 85);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("Test");
		label4.setText("hard to believe starting price. However, the price of the car is $97,000");
		label4.setBounds(100, 410, 600, 85);
		contentPane.add(label4);
		
		
		
		okButton = new JButton("OK");
		okButton.setBounds(250, 500, 80, 40);
		contentPane.add(okButton);
		okButton.addActionListener((ActionListener) this);
		
		FavorButton = new JButton("Favor");
		FavorButton.setBounds(400, 500, 80, 40);
		contentPane.add(FavorButton);
		FavorButton.addActionListener((ActionListener) this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(800, 650);
		frame.add(contentPane);
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == okButton) {
    		this.dispose();
    		
    	}
    	else if(e.getSource() == FavorButton) {
    		//this.dispose();
    		info.store(carName);
    	}
    }
	public static void main(String args[]) {
		CarInfo1 info1 = new CarInfo1();
		
	}
	
}
