package BenitezAS5;

import java.io.PrintWriter;

public class GradStudent extends Student{

  //for the college they graduated from
  private String college;

  //creat a grad student object
  public GradStudent(String name, int id, float gpa, String college){
    super(name, id, gpa);
    this.college = college;
  }

  //prints the grad student
  public void printStudent(){
    super.printStudent();
    System.out.println("    College Graduated: " + college);
  }

  //prints to output file
  public void printStudent(PrintWriter output){
    super.printStudent(output);
    output.println("graduate," + college);
  //  printStudent();
  }
}
