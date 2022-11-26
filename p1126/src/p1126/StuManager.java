package p1126;

import java.util.Scanner;

public class StuManager {
	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(System.in);
		int choice=0;
		Cal c=new Cal();
		log_in in=new log_in();
		int flag=0;
		//아이디 비번 읽어들어오기
		in.log_read();
		
		flag=in.screen_login();
		
	
		if(flag==0) {
			System.out.println("3번 이상 틀리셨습니다. 시스템을 종료합니다. ");
		}
		if(flag==1) {
		loop:
		while(true) {
			
			
		//본문 
			choice=c.screen_main();
			
			switch(choice) {
			
			case 1: // 성적입력
				c.input_score();
					break;
			case 2: // 성적출력
				c.output_score();
					break;
			case 3: // 성적수정
				c.modify_score();
					break;
			case 4: // 학생 검색
				c.search();
					break;
			case 5: // 등수처리 
				c.rank();
					break;
			case 6: //성적정렬 선택
				c.arrange();
					break;
			case 7: // 파일 불러오기
				c.read();
					break;
			case 8: // 파일 저장
				c.save();
					break;
			case 0: // 프로그램 종료
				System.out.println("프로그램을 종료하겠습니다.");
					break loop;
			}//switch
			
			}//while1
		}//if
		
	}//main


}//class
