import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class RightGUI {
	public void Buttons(JPanel panel) {
		
		panel.setLayout(new GridLayout(7, 1,0, 10));// 패널 1 = 0행2열 & element간의 가로와 세로 간격은 0 과 10씩
		panel.setBorder(BorderFactory.createEmptyBorder(0, 200, 00, 200));// 패널1 상좌하우 간격 띄우기 
			
		JButton button1 = new JButton("STAFF 1");
		JButton button2 = new JButton("STAFF 2");
		JButton button3 = new JButton("STAFF 3");
		JButton button4 = new JButton("STAFF 4");
		JButton button5 = new JButton("STAFF 5");
		JButton back = new JButton("BACK");
		JButton admin = new JButton("ADMIN");
		
		panel.add(admin);//버튼 7개 추가
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(back);
		
		admin.setForeground(Color.red);
		back.setForeground(Color.red);
		
		button1.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent arg0) {	Data.staff[1] =1;}	});
		button2.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent arg0) {	Data.staff[2] =1;}	});
		button3.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent arg0) {	Data.staff[3] =1;}	});
		button4.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent arg0) {	Data.staff[4] =1;}	});
		button5.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent arg0) {	Data.staff[5] =1;}	});
		back.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent arg0) {	Data.back =1;}	});
		admin.addActionListener(new ActionListener() {	public void actionPerformed(ActionEvent arg0) {	Controller.AdminWindow();}	});

	}
	
	

}
