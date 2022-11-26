package p1126;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class log_in {
	ArrayList<Teacher> t_list=new ArrayList<Teacher>();
	String id;
	String pw;
	Scanner scan=new Scanner(System.in);
	int count=0;
	
	//log_in main 화면 
	int screen_login() {
		int flag=0;
		count=0;
		loop:
		while(count<3) { 
		System.out.println("[ 성적처리프로그램 - 로그인 ]");
	
		System.out.println("ID를 입력해주세요");
		id=scan.next();
		System.out.println("PW를 입력해주세요");
		pw=scan.next();
		for(int i=0;i<t_list.size();i++) {
			if(t_list.get(i).t_id.equals(id)) {//아이디 먼저 CHECK하고 
				if(t_list.get(i).t_pw.equals(pw)) {//비밀번호 그 다음 CHECK하고
					System.out.println("로그인에 성공하셨습니다.");
					flag++;
					break loop;
				}//pw if
			}// id if
		}//check for 
		
		
		if(flag==0&&count!=2) {
			System.out.println("아이디와 비밀번호가 틀리셨습니다. 다시 입력해주세요");
		} //틀리면 다시 입력 받기 
		
		
		count++; //횟수체크
		
		}//while
		
		return flag;
	}// method
	
	
	
	void log_read() throws Exception {
		BufferedReader lr = new BufferedReader(new FileReader("C:\\Users\\USER\\id.txt"));
		String data = "";
		String[] temp = null;
		
		while(true) {
			data = lr.readLine();
			if(data==null) break;
			temp = data.split(",");
			t_list.add(new Teacher(temp[0],temp[1]));
			}

		
		System.out.println("[[ 관리자 정보 출력 ]]");
		System.out.println("아이디\t비밀번호");
		System.out.println("---------------------------------------------------------------");	
		for(int i=0;i<t_list.size();i++) {
				System.out.printf("%s\t%s\n",
						t_list.get(i).t_id,t_list.get(i).t_pw);
			}//for
			
		
			System.out.println();
			
			}// method


}//class
