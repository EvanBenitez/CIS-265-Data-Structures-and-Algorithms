package BenitezAS4;

public class Student {
  //student's Name
  private String name;
  //student's id
  private int id;
  //student's gpa
  private float gpa;

  //Default constructor
  public Student() {
    this("", 0, 0);
  }

  //creat a student object
  public Student(String name, int id, float gpa) {
    this.name = name;
    this.id = id;
    this.gpa = gpa;
  }

  //print out student information
  public void printStudent() {
    System.out.println("    Student name: " + name);
    System.out.println("    Student ID: " + id);
    System.out.println("    Student GPA: " + gpa);
  }

  public int getID() {
    return id;
  }
}
