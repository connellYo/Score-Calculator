package p1126;

import java.util.Comparator;

public class Stu_score implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.total<o2.total) {
			return -1 ;
			
		}else if(o1.total>o2.total) {
			return 1;
		}
		return 0;
	}

}
