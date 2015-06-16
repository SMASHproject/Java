import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.json.simple.parser.ParseException;


public class LeftGUI {
	
	static Data data = new Data();
	static Controller controller = new Controller();
	
	static int i;
	
	public void now(JPanel panel) {		
		
		JPanel panel1 = new JPanel();JButton button1 = new JButton("List1");JPanel panel1_1 = new JPanel();
		JPanel panel2 = new JPanel();JButton button2 = new JButton("List2");JPanel panel2_1 = new JPanel();
		JPanel panel3 = new JPanel();JButton button3 = new JButton("List3");JPanel panel3_1 = new JPanel();
		JPanel panel4 = new JPanel();JButton button4 = new JButton("List4");JPanel panel4_1 = new JPanel();
		JPanel panel5 = new JPanel();JButton button5 = new JButton("List5");JPanel panel5_1 = new JPanel();
		JPanel panel6 = new JPanel();JButton button6 = new JButton("List6");JPanel panel6_1 = new JPanel();
		JPanel panel7 = new JPanel();JButton button7 = new JButton("List7");JPanel panel7_1 = new JPanel();
		JPanel panel8 = new JPanel();JButton button8 = new JButton("List8");JPanel panel8_1 = new JPanel();
		JPanel panel9 = new JPanel();JButton button9 = new JButton("List9");JPanel panel9_1 = new JPanel();
		JPanel panel10 = new JPanel();JButton button10 = new JButton("List10");JPanel panel10_1 = new JPanel();
		JPanel panel11 = new JPanel();JButton button11 = new JButton("List11");JPanel panel11_1 = new JPanel();
		JPanel panel12 = new JPanel();JButton button12 = new JButton("List12");JPanel panel12_1 = new JPanel();
		JPanel panel13 = new JPanel();JButton button13 = new JButton("List13");JPanel panel13_1 = new JPanel();
		JPanel panel14 = new JPanel();JButton button14 = new JButton("List14");JPanel panel14_1 = new JPanel();
		JPanel panel15 = new JPanel();JButton button15 = new JButton("List15");JPanel panel15_1 = new JPanel();
		JPanel panel16 = new JPanel();JButton button16 = new JButton("List16");JPanel panel16_1 = new JPanel();
		
		Timer m_timer = new Timer();
    	TimerTask m_task = new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println(i);

				try {
					String downloadurl = controller.downloadURL("http://166.104.245.69/pos_order.php");
			    	if(downloadurl.isEmpty())
			    		;
			    	else{
			    		controller.parseJSON_pos_order(downloadurl);
			    		data.boolean_while = true;	
						i =1;
						while(data.boolean_while){
							// button[i]번째 값이 0이면 비어있는 테이블이므로 받아온 주문을 입력한다.
							if(data.button[i].equals("0"))
							{
								//button[i]에 "1"을 넣어줘서 다음에 들어온 주문이 입력되는 것을 막는다.
								data.button[i] = "1";
								
								//i번째 테이블에 가서 버튼의 텍스트를 주문받은 테이블 번호로 바꿔준다.
								switch(i) {
								case 1 :
									button1.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 2 :
									button2.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 3 :
									button3.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 4 :
									button4.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 5 :
									button5.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 6 :
									button6.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 7 :
									button7.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 8 :
									button8.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 9 :
									button9.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 10 :
									button10.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 11 :
									button11.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 12 :
									button12.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 13 :
									button13.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 14 :
									button14.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 15 :
									button15.setText(data.pos_table_num+"");data.boolean_while = false;
									break;
								case 16 :
									button16.setText(data.pos_table_num+"");data.boolean_while = false;
									break;	
								}
							}
							//만약 i번째 리스트가 비어있지 않다면 다음 리스트를 확인
							else{
								if(i == 15){
									i = 1;

								}
								i++;
							}
						}
			    	}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
    		
    	};
    	
    	m_timer.schedule(m_task, 0, 3000);

    	
		panel1.setLayout(new GridLayout(1,1,0,0));// 패널 1 = 0행2열 & element간의 가로와 세로 간격은 0 과 0씩	
		panel1_1.setLayout(new GridLayout(1,1,0,0));
		panel1.add(button1);
		panel1_1.add(panel1);
		
		panel2.setLayout(new GridLayout(1,1,0,0));
		panel2_1.setLayout(new GridLayout(1,1,0,0));
		panel2.add(button2);
		panel2_1.add(panel2);
		
		panel3.setLayout(new GridLayout(1,1,0,0));		
		panel3.add(button3);
		panel3_1.setLayout(new GridLayout(1,1,0,0));
		panel3_1.add(panel3);
		
		panel4.setLayout(new GridLayout(1,1,0,0));	
		panel4.add(button4);
		panel4_1.setLayout(new GridLayout(1,1,0,0));
		panel4_1.add(panel4);
		
		panel5.setLayout(new GridLayout(1,1,0,0));		
		panel5.add(button5);
		panel5_1.setLayout(new GridLayout(1,1,0,0));
		panel5_1.add(panel5);
		
		panel6.setLayout(new GridLayout(1,1,0,0));		
		panel6.add(button6);
		panel6_1.setLayout(new GridLayout(1,1,0,0));
		panel6_1.add(panel6);
		
		panel7.setLayout(new GridLayout(1,1,0,0));		
		panel7.add(button7);
		panel7_1.setLayout(new GridLayout(1,1,0,0));
		panel7_1.add(panel7);
		
		panel8.setLayout(new GridLayout(1,1,0,0));		
		panel8.add(button8);
		panel8_1.setLayout(new GridLayout(1,1,0,0));
		panel8_1.add(panel8);
		
		panel9.setLayout(new GridLayout(1,1,0,0));	
		panel9.add(button9);
		panel9_1.setLayout(new GridLayout(1,1,0,0));
		panel9_1.add(panel9);
		
		panel10.setLayout(new GridLayout(1,1,0,0));		
		panel10.add(button10);
		panel10_1.setLayout(new GridLayout(1,1,0,0));
		panel10_1.add(panel10);
		
		panel11.setLayout(new GridLayout(1,1,0,0));	
		panel11.add(button11);
		panel11_1.setLayout(new GridLayout(1,1,0,0));
		panel11_1.add(panel11);
		
		panel12.setLayout(new GridLayout(1,1,0,0));	
		panel12.add(button12);
		panel12_1.setLayout(new GridLayout(1,1,0,0));
		panel12_1.add(panel12);
		
		panel13.setLayout(new GridLayout(1,1,0,0));		
		panel13.add(button13);
		panel13_1.setLayout(new GridLayout(1,1,0,0));
		panel13_1.add(panel13);
		
		panel14.setLayout(new GridLayout(1,1,0,0));		
		panel14.add(button14);
		panel14_1.setLayout(new GridLayout(1,1,0,0));
		panel14_1.add(panel14);
		
		
		panel15.setLayout(new GridLayout(1,1,0,0));	
		panel15.add(button15);
		panel15_1.setLayout(new GridLayout(1,1,0,0));
		panel15_1.add(panel15);
		
		panel16.setLayout(new GridLayout(1,1,0,0));		
		panel16.add(button16);
		panel16_1.setLayout(new GridLayout(1,1,0,0));
		panel16_1.add(panel16);

		panel1.setBackground(Color.WHITE);
//------메인 패널 설정		
		panel.setLayout(new GridLayout(4,4,3,3));//(행갯수,열갯수,가로 gap,세로 gap)
//------평면에 끌로 판듯이 외곽선 효과를 내는 것이고 양각의 효과를 준다.
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
//------그리드레이아웃 설정
		panel1.setBorder(eborder);panel1_1.setBorder(eborder);  panel.add(panel1_1);panel1.setBackground(Color.RED);panel1.setOpaque(true);panel1_1.setOpaque(true);
		panel2.setBorder(eborder);panel2_1.setBorder(eborder);  panel.add(panel2_1);panel2.setBackground(Color.RED);panel2.setOpaque(true);panel2_1.setOpaque(true);
		panel3.setBorder(eborder);panel3_1.setBorder(eborder);  panel.add(panel3_1);panel3.setBackground(Color.RED);panel3.setOpaque(true);panel3_1.setOpaque(true);
		panel4.setBorder(eborder);panel4_1.setBorder(eborder);  panel.add(panel4_1);panel4.setBackground(Color.RED);panel4.setOpaque(true);panel4_1.setOpaque(true);
		panel5.setBorder(eborder);panel5_1.setBorder(eborder);  panel.add(panel5_1);panel5.setBackground(Color.RED);panel5.setOpaque(true);panel5_1.setOpaque(true);
		panel6.setBorder(eborder);panel6_1.setBorder(eborder);  panel.add(panel6_1);panel6.setBackground(Color.RED);panel6.setOpaque(true);panel6_1.setOpaque(true);
		panel7.setBorder(eborder);panel7_1.setBorder(eborder);  panel.add(panel7_1);panel7.setBackground(Color.RED);panel7.setOpaque(true);panel7_1.setOpaque(true);
		panel8.setBorder(eborder);panel8_1.setBorder(eborder);  panel.add(panel8_1);panel8.setBackground(Color.RED);panel8.setOpaque(true);panel8_1.setOpaque(true);
		panel9.setBorder(eborder);panel9_1.setBorder(eborder);  panel.add(panel9_1);panel9.setBackground(Color.RED);panel9.setOpaque(true);panel9_1.setOpaque(true);
		panel10.setBorder(eborder);panel10_1.setBorder(eborder);panel.add(panel10_1);panel10.setBackground(Color.RED);panel10.setOpaque(true);panel10_1.setOpaque(true);
		panel11.setBorder(eborder);panel11_1.setBorder(eborder);panel.add(panel11_1);panel11.setBackground(Color.RED);panel11.setOpaque(true);panel11_1.setOpaque(true);
		panel12.setBorder(eborder);panel12_1.setBorder(eborder);panel.add(panel12_1);panel12.setBackground(Color.RED);panel12.setOpaque(true);panel12_1.setOpaque(true);
		panel13.setBorder(eborder);panel13_1.setBorder(eborder);panel.add(panel13_1);panel13.setBackground(Color.RED);panel13.setOpaque(true);panel13_1.setOpaque(true);
		panel14.setBorder(eborder);panel14_1.setBorder(eborder);panel.add(panel14_1);panel14.setBackground(Color.RED);panel14.setOpaque(true);panel14_1.setOpaque(true);
		panel15.setBorder(eborder);panel15_1.setBorder(eborder);panel.add(panel15_1);panel15.setBackground(Color.RED);panel15.setOpaque(true);panel15_1.setOpaque(true);
		panel16.setBorder(eborder);panel16_1.setBorder(eborder);panel.add(panel16_1);panel16.setBackground(Color.RED);panel16.setOpaque(true);panel16_1.setOpaque(true);
		
		button1.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면, 
						controller.ChangeState(controller.getStaff(),1,button1);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button1.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),1,button1);
				}
			}	
		}
		);
		button2.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),2,button2);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button2.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),2,button2);
				}
			}	
		}
		);
		button3.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),3,button3);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button3.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),3,button3);
				}
			}	
		}
		);
		button4.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),4,button4);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button4.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),4,button4);
				}
			}	
		}
		);
		button5.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),5,button5);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button5.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),5,button5);
				}
			}	
		}
		);
		button6.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),6,button6);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button6.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),6,button6);
				}
			}	
		}
		);
		button7.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),7,button7);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button7.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),7,button7);
				}
			}	
		}
		);
		button8.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),8,button8);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button8.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),8,button8);
				}
			}	
		}
		);
		button9.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),9,button9);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button9.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),9,button9);
				}
			}	
		}
		);
		button10.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),10,button10);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(Integer.valueOf(button10.getText()));
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),10,button10);
				}
			}	
		}
		);
		button11.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),11,button11);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(11);
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),11,button11);
				}
			}	
		}
		);
		button12.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),12,button12);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(12);
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),12,button12);
				}
			}	
		}
		);
		button13.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),13,button13);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(13);
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),13,button13);
				}
			}	
		}
		);
		button14.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),14,button14);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(14);
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),14,button14);
				}
			}	
		}
		);
		button15.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),15,button15);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(15);
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),15,button15);
				}
			}	
		}
		);
		button16.addActionListener(new ActionListener() 
		{//테이블 번호를 눌렀을 때, 
			public void actionPerformed(ActionEvent arg0) 
			{	
				if(data.back == 0)
				{
					if(controller.getStaff() != 0) //직원버튼을 먼저 눌렀다면,
						controller.ChangeState(controller.getStaff(),16,button16);
					else//직원버튼 안누르고 테이블 버튼만 눌렀을 때는 주문상세보기 창을 띄워준다.
						controller.ShowOrderList(16);
				}
				else
				{
					if(controller.getStaff() != 0)//back버튼과 함께 직원버튼도 눌렀다면 
						controller.ChangeStateToBack(controller.getStaff(),16,button16);
				}
			}	
		}
		);

	}

}
