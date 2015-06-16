import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class MainGUI {
	
	

	LeftGUI Table = new LeftGUI();
	RightGUI buttons = new RightGUI();//버튼 생성위한 클래스 선언
	
	@SuppressWarnings({ "static-access", "static-access" })
	
	public void MakeGUI(){
		JFrame frame = new JFrame();//프레임만들기 //괄호 안에 바로 "타이틀"집어 넣어도 됨
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//디폴트 모양의 프레임만들기
		frame.setTitle("MIT POS SYSTEM");
		frame.setBounds(300,100,930,530);//프레임의 위치,크기지정 ,(x좌표,y좌표,width,height)
		
//------메인 패널 생성		
		JPanel Mainpanel = new JPanel();
		Mainpanel.setLayout(new BorderLayout());//보더레이이웃 사용(North,Center)
		
//------TOP,LEFT,RIGHT 패널 생성
		JPanel Toppanel = new JPanel();//위쪽 패널 생성
		JPanel Leftpanel = new JPanel();//왼쪽 패널 생성
		JPanel Rightpanel = new JPanel();//오른쪽 패널 생성
		
//------TOP패널 설정 	
		JLabel labelTop=new JLabel("                    MIT POS SYSTEM                    ",JLabel.CENTER);
		labelTop.setFont(new Font(null,Font.BOLD,30));//폰트 모양 및 크기
		
		TitledBorder tborderTop =new TitledBorder("   ");//테두리 만들어주기 위한 방법
		tborderTop.setTitlePosition(TitledBorder.ABOVE_TOP);//지정한 위치에 타이틀을 나타내주는 보더
		tborderTop.setTitleJustification(TitledBorder.CENTER);//자리맞춤을 가운데로 지정
		labelTop.setBorder(tborderTop);
		Toppanel.add(labelTop);
		
		
//------LEFT패널 설정
		Leftpanel.setLayout(new GridLayout(1,1,0,0));//1행1열 & 가로와 세로 간격은 0과 0만큼		
		Table.now(Leftpanel);//Left패널의 테이블 만들기 위한 클래스,메소드 호출
		
		Calendar cal = Calendar.getInstance();
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(cal.MONTH)+1;
	    int day = cal.get(cal.DATE);

		TitledBorder tborderLeft =new TitledBorder("TABLE    "+"("+year+"-"+month+"-"+day+")");//테두리 만들어주기 위한 방법
		tborderLeft.setTitlePosition(TitledBorder.ABOVE_TOP);//지정한 위치에 타이틀을 나타내주는 보더
		tborderLeft.setTitleJustification(TitledBorder.LEFT);//자리맞춤을 가운데로 지정
		Leftpanel.setBorder(tborderLeft);
		
//------RIGHT패널 설정		
		
		buttons.Buttons(Rightpanel);//버튼 생성 메소드 호출
		
		TitledBorder tborderRight =new TitledBorder(" ");//테두리 만들어주기 위한 방법
		tborderRight.setTitlePosition(TitledBorder.ABOVE_TOP);//지정한 위치에 타이틀을 나타내주는 보더
		tborderRight.setTitleJustification(TitledBorder.RIGHT);//자리맞춤을 왼쪽으로 지정
		Rightpanel.setBorder(tborderRight);
		


//------메인패널(보더레이아웃)에 패널1과 패널2 붙이기	
		
		Mainpanel.add(Toppanel,BorderLayout.NORTH);//메인페널 위쪽에 패널1붙이기
		Mainpanel.add(Leftpanel,BorderLayout.CENTER);//메인페널 중앙에 중앙페널 붙이기
		Mainpanel.add(Rightpanel,BorderLayout.EAST);
		
			
//------프레임에 메인패널 붙이기		
		frame.add(Mainpanel);//프레임에 패널붙이기
		frame.setVisible(true);//프레임은 기본세팅이 보이지 않게 되어 있으므로 보이게 따로 세팅
		
	}
}
