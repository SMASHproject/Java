import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Controller {
	static Data data = new Data();
	
	static int totalprice=0;
	
	public static void AdminWindow(){//결제창 만들
		JFrame frame = new JFrame();//프레임만들기 //괄호 안에 바로 "타이틀"집어 넣어도 됨
		frame.setTitle("PAYMENT");
		frame.setBounds(400,100,700,500);//프레임의 위치,크기지정 ,(x좌표,y좌표,width,height)
//------메인패널 생성 		
		JPanel Mainpanel = new JPanel();
		Mainpanel.setLayout(new BorderLayout());//보더레이이웃 사용(North,Center)
//------위쪽 패널 생성 및 세팅 
		JPanel Toppanel = new JPanel();//위쪽 패널 생성
		
		JLabel labelTop=new JLabel("ADMIN PAGE",JLabel.CENTER);
		labelTop.setFont(new Font(null,Font.BOLD,30));//폰트 모양 및 크기
		
		TitledBorder tborderTop =new TitledBorder("   ");//테두리 만들어주기 위한 방법
		tborderTop.setTitlePosition(TitledBorder.ABOVE_TOP);//지정한 위치에 타이틀을 나타내주는 보더
		tborderTop.setTitleJustification(TitledBorder.CENTER);//자리맞춤을 가운데로 지정
		labelTop.setBorder(tborderTop);
		Toppanel.add(labelTop);
//------가운데 패널 생성(주문 리스트 및 금액이 담길 예정 )
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(6, 3, 0, 10));//(10, 3, 0, 00)
		panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		

		try {
			parseJSON_admin(downloadURL("http://166.104.245.69/admin.php"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel l=new JLabel("#");panel1.add(l);
		JLabel l2=new JLabel("Staff");panel1.add(l2);
		JLabel l3=new JLabel("price");panel1.add(l3);
		
		JLabel l4=new JLabel("#1");panel1.add(l4);
		JLabel l5=new JLabel(""+data.Finalstaff[0]);panel1.add(l5);
		JLabel l6=new JLabel(""+data.PRICE[0]);panel1.add(l6);
		
		JLabel l7=new JLabel("#2");panel1.add(l7);
		JLabel l8=new JLabel(""+data.Finalstaff[1]);panel1.add(l8);
		JLabel l9=new JLabel(""+data.PRICE[1]);panel1.add(l9);
		
		JLabel l10=new JLabel("#3");panel1.add(l10);
		JLabel l11=new JLabel(""+data.Finalstaff[2]);panel1.add(l11);
		JLabel l12=new JLabel(""+data.PRICE[2]);panel1.add(l12);
		
		JLabel l13=new JLabel("#4");panel1.add(l13);
		JLabel l14=new JLabel(""+data.Finalstaff[3]);panel1.add(l14);
		JLabel l15=new JLabel(""+data.PRICE[3]);panel1.add(l15);
		
		JLabel l16=new JLabel("#5");panel1.add(l16);
		JLabel l17=new JLabel(""+data.Finalstaff[4]);panel1.add(l17);
		JLabel l18=new JLabel(""+data.PRICE[4]);panel1.add(l18);
		
		

//------메인패널(보더레이아웃)에 붙이기 
		Mainpanel.add(Toppanel, BorderLayout.NORTH);
		Mainpanel.add(panel1, BorderLayout.CENTER);
		
		frame.add(Mainpanel);
		frame.setVisible(true);
		
	}
	public static int getStaff(){//직원번호를 리턴 
		
		if(data.staff[1] == 1) return 1;
		else if(data.staff[2] == 1) return 2;
		else if(data.staff[3] == 1) return 3;
		else if(data.staff[4] == 1) return 4;
		else if(data.staff[5] == 1) return 5;
		else return 0;//직원을 누르지 않았을 때 
	}
	
	public static void ChangeStateToBack(int Staffindex, int Tableindex, JButton button)
	{	

		if(data.Table[Tableindex] == 1)//테이블상황이 승인 및 제작 상태일때 ,
		{	
			data.staff[Staffindex]=0;//직원 선택 취소 
			data.back=0;//back버튼 취소 
			data.Table[Tableindex]--;//음료제작 완료표시하고,
			button.setBackground(Color.WHITE);
			button.setBorderPainted(false);
			button.setOpaque(true);
		
		}
		else if(data.Table[Tableindex] == 2)//테이블상황이 제작완료일 때 
		{//결제창을 보여준다.
			data.staff[Staffindex]=0;//직원 선택 취소 
			data.back=0;
			data.Table[Tableindex]--;//음료제작 완료표시하고,
			button.setBackground(Color.YELLOW);
			button.setBorderPainted(false);
			button.setOpaque(true);
		}
		else{
			data.staff[Staffindex]=0;//직원 선택 취소
			data.back=0;

		
		}
		
		
	}

	public static void ChangeState(int Staffindex ,int Tableindex,JButton button){
		
		if(data.Table[Tableindex] == 0)//테이블상황이 초기 상태일때 ,
		{	
			data.staff[Staffindex]=0;//직원 선택 취소
			data.Table[Tableindex]++;//테이블을 승인하고,
			button.setBackground(Color.YELLOW);
			button.setBorderPainted(false);
			button.setOpaque(true);
			
			//옐로알람 
			//downloadURL("http://166.104.245.69/ararm.php?staff_name="+Staffindex+"&order_num="+Integer.valueOf(button.getText())+"&state=yellow");
			System.out.println(downloadURL("http://166.104.245.69/alarm.php?order_num="+data.order_num[Integer.valueOf(button.getText())]+"&state=yellow&staff="+Staffindex+""));

		}
		else if(data.Table[Tableindex] == 1)//테이블상황이 승인 및 제작 상태일때 ,
		{	
			data.staff[Staffindex]=0;//직원 선택 취소 
			data.Table[Tableindex]++;//음료제작 완료표시하고,
			button.setBackground(Color.GREEN);
			button.setBorderPainted(false);
			button.setOpaque(true);
			
			//그린알람 
			//System
			System.out.println(downloadURL("http://166.104.245.69/alarm.php?order_num="+data.order_num[Integer.valueOf(button.getText())]+"&state=green&staff="+Staffindex+""));
			
		}
		else if(data.Table[Tableindex] == 2)//테이블상황이 제작완료일 때 
		{//결제창을 보여준다.
			data.staff[Staffindex]=0;//직원 선택 취소 
			Controller.PayWindow(Staffindex,Tableindex,button);
		
			
		}
		
	}
	
	
	public static void PayWindow(int Staffindex,int Tableindex,JButton button){//결제창 만들
		JFrame frame = new JFrame();//프레임만들기 //괄호 안에 바로 "타이틀"집어 넣어도 됨
		frame.setTitle("PAYMENT");
		frame.setBounds(400,200,400,500);//프레임의 위치,크기지정 ,(x좌표,y좌표,width,height)
//------메인패널 생성 		
		JPanel Mainpanel = new JPanel();
		Mainpanel.setLayout(new BorderLayout());//보더레이이웃 사용(North,Center)
//------위쪽 패널 생성 및 세팅 
		JPanel Toppanel = new JPanel();//위쪽 패널 생성
		
		String TABLE = "Bill of table number "+button.getText();
		JLabel labelTop=new JLabel(TABLE,JLabel.CENTER);
		labelTop.setFont(new Font(null,Font.BOLD,20));//폰트 모양 및 크기
		
		TitledBorder tborderTop =new TitledBorder("   ");//테두리 만들어주기 위한 방법
		tborderTop.setTitlePosition(TitledBorder.ABOVE_TOP);//지정한 위치에 타이틀을 나타내주는 보더
		tborderTop.setTitleJustification(TitledBorder.CENTER);//자리맞춤을 가운데로 지정
		labelTop.setBorder(tborderTop);
		Toppanel.add(labelTop);	
//------가운데 패널 생성(주문 리스트 및 금액이 담길 예정 ) 		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(10, 3, 0, 00));
		panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		JLabel l=new JLabel("Menu");panel1.add(l);
		JLabel l2=new JLabel("Number");panel1.add(l2);
		JLabel l3=new JLabel("price");panel1.add(l3);
		
		JLabel l4=new JLabel("Americano");panel1.add(l4);
		JLabel l5=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][0]);panel1.add(l5);
		JLabel l6=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][0]*3000);panel1.add(l6);
		
		JLabel l7=new JLabel("Latte");panel1.add(l7);
		JLabel l8=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][1]);panel1.add(l8);
		JLabel l9=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][1]*4000);panel1.add(l9);
		
		JLabel l10=new JLabel("Milk");panel1.add(l10);
		JLabel l11=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][2]);panel1.add(l11);
		JLabel l12=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][2]*2000);panel1.add(l12);
		
		JLabel l13=new JLabel("Greentealatte");panel1.add(l13);
		JLabel l14=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][3]);panel1.add(l14);
		JLabel l15=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][3]*4500);panel1.add(l15);
		
		JLabel l16=new JLabel("Mochachino");panel1.add(l16);
		JLabel l17=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][4]);panel1.add(l17);
		JLabel l18=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][4]*4500);panel1.add(l18);
		
		JLabel l19=new JLabel("Macchiato");panel1.add(l19);
		JLabel l20=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][5]);panel1.add(l20);
		JLabel l21=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][5]*4500);panel1.add(l21);
		
		JLabel l22=new JLabel("Muffin");panel1.add(l22);
		JLabel l23=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][6]);panel1.add(l23);
		JLabel l24=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][6]*3000);panel1.add(l24);
		
		JLabel l25=new JLabel("Honeybread");panel1.add(l25);
		JLabel l26=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][7]);panel1.add(l26);
		JLabel l27=new JLabel(""+data.menu_num[Integer.valueOf((String)button.getText())][7]*5000);panel1.add(l27);
		
		int totalNUm=0;
		totalprice=0;
		for(int b=0;b<8;b++) totalNUm= totalNUm + data.menu_num[Integer.valueOf((String)button.getText())][b];
		
		totalprice= data.menu_num[Integer.valueOf((String)button.getText())][0]*3000 + data.menu_num[Integer.valueOf((String)button.getText())][1]*4000 +
		data.menu_num[Integer.valueOf((String)button.getText())][2]*2000 + data.menu_num[Integer.valueOf((String)button.getText())][3]*4500 + data.menu_num[Integer.valueOf((String)button.getText())][4]*4500 +
		data.menu_num[Integer.valueOf((String)button.getText())][5]*4500 + data.menu_num[Integer.valueOf((String)button.getText())][6]*3000 + data.menu_num[Integer.valueOf((String)button.getText())][7]*5000;

		
		JLabel l28=new JLabel("Total");panel1.add(l28);
		JLabel l29=new JLabel(""+totalNUm);panel1.add(l29);
		JLabel l30=new JLabel(""+totalprice);panel1.add(l30);
		
//------아래쪽 패널 생성(버튼) 
		JPanel panel2 = new JPanel();// 아래쪽 패널 생성
		panel2.setLayout(new GridLayout(0, 2, 5, 0));
		panel2.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 15));
		JButton pay = new JButton("Pay");
		JButton cancel = new JButton("Cancel");
		panel2.add(pay); // 버튼
		panel2.add(cancel);
//------메인패널(보더레이아웃)에 붙이기 
		Mainpanel.add(Toppanel, BorderLayout.NORTH);
		Mainpanel.add(panel1, BorderLayout.CENTER);
		Mainpanel.add(panel2, BorderLayout.SOUTH);
		
		frame.add(Mainpanel);
		frame.setVisible(true);
		
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				// System
				downloadURL("http://166.104.245.69/payment.php?order_num="+data.order_num[Integer.valueOf(button.getText())]+"&payment="+totalprice+"");
				data.staff[Staffindex]=0;//직원 선택 취소
				data.Table[Tableindex]=0;//음료제작 완료표시하고,
				button.setBackground(Color.WHITE);
				button.setBorderPainted(false);
				button.setOpaque(true);
				button.setText("000");
				data.button[Tableindex] = "0";
				frame.dispose();//창 닫기 
			}	
		});
		cancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {	
				frame.dispose();//창 닫기 
			}	
		});
	}
	public static void ShowOrderList(int tableNum){
		//------프레임 생
				JFrame frame = new JFrame();//프레임만들기 //괄호 안에 바로 "타이틀"집어 넣어도 됨
				frame.setTitle("OrderList");
				frame.setBounds(400,200,600,500);//프레임의 위치,크기지정 ,(x좌표,y좌표,width,height)
		//------메인 패널 생성 		
				JPanel Mainpanel = new JPanel();
				Mainpanel.setLayout(new BorderLayout());//보더레이이웃 사용(North,Center)		
		//------위쪽 패널 생성 및 세팅 
				JPanel Toppanel = new JPanel();//위쪽 패널 생성
				
				String TABLE = "Order List of table number "+tableNum;
				JLabel labelTop=new JLabel(TABLE,JLabel.CENTER);
				labelTop.setFont(new Font(null,Font.BOLD,20));//폰트 모양 및 크기
				
				TitledBorder tborderTop =new TitledBorder("   ");//테두리 만들어주기 위한 방법
				tborderTop.setTitlePosition(TitledBorder.ABOVE_TOP);//지정한 위치에 타이틀을 나타내주는 보더
				tborderTop.setTitleJustification(TitledBorder.CENTER);//자리맞춤을 가운데로 지정
				labelTop.setBorder(tborderTop);
				Toppanel.add(labelTop);
		//------가운데 패널 생성 및 세팅  (이 부분에 주문 내역이 담길 예정) 
				JPanel panel1 = new JPanel();// 가운데쪽 패널 생성
				panel1.setLayout(new GridLayout(9, 3, 0, 0));
				panel1.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 15));
				
				JLabel l=new JLabel("Menu");panel1.add(l);
				JLabel l2=new JLabel("Number");panel1.add(l2);
				JLabel l3=new JLabel("price");panel1.add(l3);
				
				JLabel l4=new JLabel("Americano");panel1.add(l4);
				JLabel l5=new JLabel(""+data.menu_num[tableNum][0]);panel1.add(l5);
				JLabel l6=new JLabel(""+data.menu_num[tableNum][0]*3000);panel1.add(l6);
				
				JLabel l7=new JLabel("Latte");panel1.add(l7);
				JLabel l8=new JLabel(""+data.menu_num[tableNum][1]);panel1.add(l8);
				JLabel l9=new JLabel(""+data.menu_num[tableNum][1]*4000);panel1.add(l9);
				
				JLabel l10=new JLabel("Milk");panel1.add(l10);
				JLabel l11=new JLabel(""+data.menu_num[tableNum][2]);panel1.add(l11);
				JLabel l12=new JLabel(""+data.menu_num[tableNum][2]*2000);panel1.add(l12);
				
				JLabel l13=new JLabel("Greentealatte");panel1.add(l13);
				JLabel l14=new JLabel(""+data.menu_num[tableNum][3]);panel1.add(l14);
				JLabel l15=new JLabel(""+data.menu_num[tableNum][3]*4500);panel1.add(l15);
				
				JLabel l16=new JLabel("Mochachino");panel1.add(l16);
				JLabel l17=new JLabel(""+data.menu_num[tableNum][4]);panel1.add(l17);
				JLabel l18=new JLabel(""+data.menu_num[tableNum][4]*4500);panel1.add(l18);
				
				JLabel l19=new JLabel("Macchiato");panel1.add(l19);
				JLabel l20=new JLabel(""+data.menu_num[tableNum][5]);panel1.add(l20);
				JLabel l21=new JLabel(""+data.menu_num[tableNum][5]*4500);panel1.add(l21);
				
				JLabel l22=new JLabel("Muffin");panel1.add(l22);
				JLabel l23=new JLabel(""+data.menu_num[tableNum][6]);panel1.add(l23);
				JLabel l24=new JLabel(""+data.menu_num[tableNum][6]*3000);panel1.add(l24);
				
				JLabel l25=new JLabel("Honeybread");panel1.add(l25);
				JLabel l26=new JLabel(""+data.menu_num[tableNum][7]);panel1.add(l26);
				JLabel l27=new JLabel(""+data.menu_num[tableNum][7]*5000);panel1.add(l27);

		//------아래쪽 패널 생성 및 세팅(버튼) 
				JPanel panel2 = new JPanel();// 아래쪽 패널 생성(주문내역이 담길 곳) 
				panel2.setLayout(new GridLayout(0, 1, 5, 0));
				panel2.setBorder(BorderFactory.createEmptyBorder(0, 15, 10, 15));
				JButton ok = new JButton("OK");
				panel2.add(ok); // 버튼

				// ------메인패널(보더레이아웃)에 패널1과 패널2 붙이기
				Mainpanel.add(Toppanel, BorderLayout.NORTH);
				Mainpanel.add(panel1, BorderLayout.CENTER);
				Mainpanel.add(panel2, BorderLayout.SOUTH);
				
				frame.add(Mainpanel);
				frame.setVisible(true);
				
				ok.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent arg0) {	
						frame.dispose();//창 닫기 
					}	
				});
				
			}

	
//------addr(서버주소)로부터 JSON데이터 받아오기 	
//------String html = downloadURL("http://166.104.245.73/student_info.php?student_id=2010030030"); 이와같이 사용
	public static String downloadURL(String addr) {
    	String doc ="";
    	try {
    		URL url = new URL(addr);
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		if(conn !=null) {
    			conn.setConnectTimeout(10000);
    			conn.setUseCaches(false);
    			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
    				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    				for( ; ; ) {
    					String line = br.readLine();
    					if(line == null)break;
    					doc = doc + line + "\n";
    				}
    				br.close();
    			}
    			conn.disconnect();
    		}
    	}
    	catch(Exception ex) {;}
    	return doc;
	}
	
	//admin에 대한 JSON 파서 
	public static void parseJSON_admin(String JSON) throws org.json.simple.parser.ParseException {
		Object obj = JSONValue.parseWithException(JSON);
		JSONArray array =(JSONArray)obj;
		JSONObject obj2 = null;
			   
		for(int i=0;i<array.size();i++){
			obj2 = (JSONObject) array.get(i);
			data.Finalstaff[i] = (String) obj2.get("name");
			data.PRICE[i] = Integer.valueOf((String)obj2.get("peformance"));
		}
	}
	
	//pos_order에 대한 JSON 파서 
	public static void parseJSON_pos_order(String JSON) throws org.json.simple.parser.ParseException {
		try {
			 
            JSONParser jsonParser = new JSONParser();
            //JSON데이터를 넣어 JSON Object 로 만들어 준다.
            JSONObject jsonObject = (JSONObject) jsonParser.parse(JSON);
            
            int table_number = Integer.valueOf((String) jsonObject.get("table_num"));
            data.order_num[table_number] = Integer.valueOf((String) jsonObject.get("order_num"));
            data.pos_table_num = table_number;           
            JSONArray orderList = (JSONArray) jsonObject.get("orderlist");
            for(int i=0; i<orderList.size(); i++){
            	//배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
                JSONObject orderObject = (JSONObject) orderList.get(i);
                //JSON name으로 추출
                if( ( (String) orderObject.get("content") ).equals("Americano"))
                	data.menu_num[table_number][0] = Integer.valueOf((String)orderObject.get("amount"));
                else if( ( (String) orderObject.get("content") ).equals("Latte"))
                	data.menu_num[table_number][1] = Integer.valueOf((String)orderObject.get("amount"));
                else if( ( (String) orderObject.get("content") ).equals("Milk"))
                	data.menu_num[table_number][2] = Integer.valueOf((String)orderObject.get("amount"));
                else if( ( (String) orderObject.get("content") ).equals("Greentealatte"))
                	data.menu_num[table_number][3] = Integer.valueOf((String)orderObject.get("amount"));
                else if( ( (String) orderObject.get("content") ).equals("Mochachino"))
                	data.menu_num[table_number][4] = Integer.valueOf((String)orderObject.get("amount"));
                else if( ( (String) orderObject.get("content") ).equals("Macchiato"))
                	data.menu_num[table_number][5] = Integer.valueOf((String)orderObject.get("amount"));
                else if( ( (String) orderObject.get("content") ).equals("Muffin"))
                	data.menu_num[table_number][6] = Integer.valueOf((String)orderObject.get("amount"));
                else if( ( (String) orderObject.get("content") ).equals("Honeybread"))
                	data.menu_num[table_number][7] = Integer.valueOf((String)orderObject.get("amount"));
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	

	
}
