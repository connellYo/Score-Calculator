package p1126;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Cal {
	Scanner scan=new Scanner(System.in);
	int choice=0;
	String name,check_name;
	int kor,eng,math;
	int rank;
	int count=0;
	String title=new String("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등수\t");
	ArrayList<Student>list=new ArrayList<Student>();
	
	//로그인 화면 
	
	
	//메인 화면
	int screen_main() {
		System.out.println("[ 성적처리프로그램 ]");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.println("3. 성적수정");
		System.out.println("4. 학생검색");
		System.out.println("5. 등수처리");
		System.out.println("6. 성적정렬선택");
		System.out.println("7. 파일불러오기");
		System.out.println("8. 파일저장하기");
		System.out.println("0. 프로그램 종료");
		System.out.println("-------------------------");
		System.out.println("원하는 번호를 입력하세요.>>");
		choice = scan.nextInt();
		
		return choice;
	}
	//성적입력
	void input_score() {
		System.out.println("[성적입력]");
		while(true) {
		System.out.printf("%d 번째 학생을 입력하세요(>>>>나가고 싶으시면 0번을 눌러주세요)",list.size()+1);
		name=scan.next();
		if(name.equals("0")) {
			break;
		}
		
		System.out.println("국어 점수를 입력하세요:");
		kor=scan.nextInt();
		System.out.println("영어 점수를 입력하세요");
		eng=scan.nextInt();
		System.out.println("수학 점수를 입력하세요");
		math=scan.nextInt();
		list.add(new Student(name,kor,eng,math));
		}
	}
	//성적출력
	void output_score() {
		System.out.println("[성적출력]");
		System.out.println(title);
		System.out.println("---------------------------------------------------------------");
		for(int i=0;i<list.size();i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",list.get(i).id,
					list.get(i).name,list.get(i).kor,list.get(i).eng,list.get(i).math,list.get(i).total,list.get(i).avg,list.get(i).rank);
		}
	
	}
	
	int check_id(String check_id_num,ArrayList<Integer> check_list,ArrayList<Student> list) {
		int check_no=0;
		for(int i=0;i<check_list.size();i++) {
			if(check_id_num.equals(list.get(check_list.get(i)).id)){
				check_no=check_list.get(i);
			}
			
		}
		
		return check_no;
	}
	
	//성적 수정
	void modify_score(){
		int check_no=0;
		String check_id_num=null;
		ArrayList <Integer>check_list=new ArrayList <Integer>();
		System.out.println("[성적수정]");
		System.out.println("이름을 입력하시오:");
		check_name=scan.next();
		for(int i=0;i<list.size();i++) {
			if(check_name.equals(list.get(i).name)) {
				check_no++;
				check_list.add(i);
			}
		}
		
		if(check_no==0) {
			System.out.println("검색하신 이름이 없습니다.");
			return;
			
		}
		
		if(check_list.size()>1) {
			System.out.println("검색하신 이름이 2개 이상 있습니다. 학번을 입력해주세요");
			check_id_num=scan.next();
			check_no=check_id(check_id_num, check_list, list);		
		}
		
		modify_print(check_no);
		
	}
	
	void modify_print(int check_no) {
		System.out.println("[[[ 점수수정 ]]]");
		System.out.println("1. 국어점수수정");
		System.out.println("2. 영어점수수정");
		System.out.println("3. 수학점수수정");
		System.out.println("0. 수정취소");
		System.out.println("-------------------------");
		System.out.println("수정할 과목을 선택하세요.>>");
		choice = scan.nextInt();
		
		
	    switch(choice) {
	    case 1: //국어
	    	System.out.println("현재 국어점수 : " + list.get(check_no).kor);
	    	System.out.println("수정할 국어점수를 입력하세요.>>");
	    	list.get(check_no).kor = scan.nextInt(); //변수에 직접수정
	    	System.out.printf("국어점수가 %d 로 수정되었습니다. \n",list.get(check_no).kor);
	    	System.out.println();
	    	break;
	    	
	    case 2: //영어
	    	System.out.println("현재 영어점수 : " + list.get(check_no).eng);
	    	System.out.println("수정할 영어점수를 입력하세요.>>");
	    	list.get(check_no).eng = scan.nextInt(); //변수에 직접수정
	    	System.out.printf("영어점수가 %d 로 수정되었습니다. \n",list.get(check_no).eng);
	    	System.out.println();
	    	break;
	    
	    case 3: //수학	
	    	System.out.println("현재 수학점수 : " + list.get(check_no).math);
	    	System.out.println("수정할 수학점수를 입력하세요.>>");
	    	list.get(check_no).math = scan.nextInt(); //변수에 직접수정
	    	System.out.printf("수학점수가 %d 로 수정되었습니다. \n",list.get(check_no).math);
	    	System.out.println();
	    	break;
	    	
	    case 0:
	    	return;
	    	
	    }//switch
	    
	    list.get(check_no).total = list.get(check_no).kor + list.get(check_no).eng + list.get(check_no).math;
	    list.get(check_no).avg = list.get(check_no).total/3.0;
	    
	}//modify_print
		
	
	
	//학생 검색
	void search() {
		String check_name,check_id;
		count=0;
		System.out.println("[학생검색]");
		System.out.println("1.이름으로 검색");
		System.out.println("2.id로 검색");
		System.out.println("원하시는 번호를 선택해주세요(돌아가기 0번)>>>>>>>>>>>>>>>>");
		choice=scan.nextInt();
		
		
		switch(choice) {
		
		case 1:
		System.out.println("이름을 입력해주세요");
		String c_name=scan.next();
		
		System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균\t등수");
		System.out.println("---------------------------------------------------------------");
		for(int i=0;i<list.size();i++) {
			if(list.get(i).name.contains(c_name)) {
				System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
						list.get(i).id,list.get(i).name,list.get(i).kor,
						list.get(i).eng,list.get(i).math,list.get(i).total,list.get(i).avg,
						list.get(i).rank);
				count++;
			}//if
		}//for
		

		System.out.printf("찾고자 하는 학생 [ %d ]명이 검색되었습니다.! ",count);
		System.out.println();
		return;
		
		
		
		case 2: 
			System.out.println("이름을 입력해주세요");
			String c_id=scan.next();
			System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균\t등수");
			System.out.println("---------------------------------------------------------------");
			for(int i=0;i<list.size();i++) {
				if(list.get(i).id.contains(c_id)) {
					System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
							list.get(i).id,list.get(i).name,list.get(i).kor,
							list.get(i).eng,list.get(i).math,list.get(i).total,list.get(i).avg,
							list.get(i).rank);
					count++;
				}//if
			}//for
			
		
		
		case 0: System.out.println("학생 검색 프로그램에서 나가겠습니다.");
				return;
		}
	}
	
	
	//등수 처리
	void rank() {
		System.out.println("[[ 등수처리 ]]");
		for(int i=0;i<list.size();i++) {
			count=1; //등수체크
			for(int j=0;j<list.size();j++) {
				if(list.get(i).total<list.get(j).total) {
					count++;
				}
			}
			list.get(i).rank = count; //등수 입력
		}//for
		
		System.out.println("등수처리가 완료되었습니다.!!");
		System.out.println();
	}
	//성적 정렬
	void arrange() {
		
		
		System.out.println("[ 성적 정렬 ]");
		System.out.println(" 1. 이름 순차 정렬 ");
		System.out.println(" 2. 이름 역순 정렬 ");
		System.out.println(" 3. 등수 순차 정렬 ");
		System.out.println(" 4. 등수 역순 정렬 ");
		System.out.println(" 5. 학번 순차 정렬 ");
		System.out.println(" 6. 학번 역순 정렬 ");
		System.out.println("-------------------------");
		System.out.println("선택하고 싶은 정렬의 번호를 입력해주세요>>");
		choice = scan.nextInt();
		
	    switch(choice) {
	    
	    case 1:
	    	System.out.println(" [1. 이름 순차 정렬] ");
	    	Collections.sort(list,new StuName());
	    	
	    		break;
	    case 2:
	    	System.out.println(" [2. 이름 역순 정렬] ");
	    	Collections.sort(list,new StuName().reversed());
	    		break;
	    case 3:
	    	System.out.println(" [3. 등수 순차 정렬] ");
	    	Collections.sort(list,new Stu_score());
	    		break;
	    	
	    case 4:
	    	System.out.println(" [4. 등수 역순 정렬] ");
	    	Collections.sort(list,new Stu_score().reversed());
	    	
	    		break;
	    case 5:
	    	System.out.println(" [5. 학번 순차 정렬] ");
	    	Collections.sort(list,new StuID());
	    	
	    		break;
	    case 6:
	    	System.out.println(" [ 6. 학번 역순 정렬] ");
	    	Collections.sort(list,new StuID().reversed());
	    		break;
	    }
		
	    System.out.println("[정렬완료]");
	}
	//파일 불러오기
	void read() throws Exception {	
	ArrayList<Student> saved_list = new ArrayList<Student>();
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\list.txt"));
	String data = "";
	String[] temp = null;
	
		
		//1번째
	while(true) {
		data = br.readLine();
		if(data==null) break;
		temp = data.split(",");
		saved_list.add(new Student(temp[0],temp[1],Integer.parseInt(temp[2]),
					Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),
					Integer.parseInt(temp[5]),Double.parseDouble(temp[6]),Integer.parseInt(temp[7])));
		}
		
			saved_list.get(saved_list.size()-1).count=saved_list.size();
		
		list=saved_list;
		System.out.println("[[ 성적출력 ]]");
		System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균\t등수");
		System.out.println("---------------------------------------------------------------");
		for(int i=0;i<list.size();i++) {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
					list.get(i).id,list.get(i).name,list.get(i).kor,
					list.get(i).eng,list.get(i).math,list.get(i).total,list.get(i).avg,list.get(i).rank);
			
		}//for
		System.out.println();}
	//파일 저장
	void save() throws Exception{
		
		FileWriter fw = new FileWriter("C:\\Users\\USER\\list.txt");
		String data="";	
		
		for(int i=0;i<list.size();i++) {
		data = String.format("%s,%s,%d,%d,%d,%d,%.2f,%d\r\n",list.get(i).id,list.get(i).name,list.get(i).kor,list.get(i).eng,list.get(i).math,list.get(i).total,list.get(i).avg,list.get(i).rank);
		fw.write(data);}
		fw.close();
		System.out.println("파일에 글자가 저장되었습니다.");
	}
	
	























////class
}

