
public class Data {

	//계산하기 쉽게 0번째 인덱스는 더미값입니다. 1번째 인덱스부터 사용하면 됩니다. 
	static int[] staff = {0,0,0,0,0,0}; 
	static int[] Table = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//0인 경우: 초기  , 1인 경우: 승인되서 음료 제작 중인 상태, 2인 경우: 제작완료
	static int[] order_num = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	static int back = 0;
	
	static int pos_table_num = 0;

	static int[][] menu_num = new int[17][8];
	
	static int PRICE[] = {0,0,0,0,0};
	static String Finalstaff[] = {"","","","",""};
	
	// LEFT_GUI에서 POS기의 1 ~ 16 까지 할당, 0은 List칸이 비어있는 상태, 1은 주문들어온 테이블이 차지하고 있는상태
	static String button[] = {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
	
	// LEFT_GUI Timer에서 While문의 조건에 들어갈 변수 
	static boolean boolean_while;
	
	
}

