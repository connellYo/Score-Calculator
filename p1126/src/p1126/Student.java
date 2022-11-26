package p1126;


public class Student {
	int kor,eng,math,rank,total;
	String id,name;
	double avg;
	static int count=0;
	
	Student() {
		count++;
		this.id= String.format("s%04d", count);
	}

	public Student( String name,int kor, int eng, int math) {
		count++;
		this.id= String.format("s%04d", count);
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
		this.total=kor+eng+math;
		this.avg=total/3.0;
		
	}

	public Student(String id,String name,int kor, int eng, int math,  int total,  double avg, int rank) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.rank = rank;
		this.total = total;
		this.id = id;
		this.name = name;
		this.avg = avg;
	}
	
	

}
