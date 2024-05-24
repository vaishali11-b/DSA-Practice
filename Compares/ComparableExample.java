//https://www.hackerrank.com/challenges/java-sort/submissions/code/384169663

import java.util.*;

class Student implements Comparable<Student> {
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
  //here implementation of compareTo method
    @Override
    public int compareTo(Student s) {
        if (this.getCgpa() == s.getCgpa()) {
            if (this.getFname().equals(s.getFname())) {
                return this.getId() - s.getId();
            }
            return this.getFname().compareTo(s.getFname());
        }
        return Double.compare(s.getCgpa(), this.getCgpa());
    }
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
    // Collections.sort invokes the compareTo method
        Collections.sort(studentList);
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
