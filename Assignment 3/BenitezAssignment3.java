/*
 *  Name: Evan Benitez
 *  CSU ID: 2486032
 *  CIS 265: Assignment 3
 *  Discription: Create an array of student objects and allow user to
 *               create and then veiw their content
*/
package benitezCIS265;

import java.util.Scanner;

public class BenitezAssignment3 {
  public static void main(String[] args) {

    //create scanner fo user input
    Scanner input = new Scanner(System.in);
    //create an array of students
    Student[] students;
    //number of students
    int number;

    //get the number of student objects to creat and creates the student objects
    do {
      System.out.print("How many students do you have (1-10):");
      number = input.nextInt();
      input.nextLine();
      if(number > 10 || number < 1) {
        System.out.println("I cannot create " + number + " students!");
      }
    } while (number > 10 || number < 1);

    //create the student array with specified number of students
    students = new Student[number];

    //get student data
    for(int i = 0; i < students.length; i++){
      System.out.print("Student " + (i + 1) + " name: ");
      String name = input.nextLine();

      //variable for checking duplicate ids
      boolean exist;
      int id;
      do {
        System.out.print("Student " + (i + 1) + " ID: ");
        id = input.nextInt();
        input.nextLine();

        if(exist = exist(students, id)){
          System.out.println("Student ID " + id + " already exist! Please retry!");
        }
      }while(exist);

      System.out.print("Student " + (i + 1) + " GPA: ");
      float gpa = input.nextFloat();
      input.nextLine();

      //create new student
      students[i] = new Student(name, id, gpa);
    }

    //enter lookup phase
    int id;
    do {
      System.out.print("Enter a student ID (enter 0 to quit): ");
      id = input.nextInt();

      //gets student with the specified id
      Student std = lookup(students, id);

      if(std != null){
        //prints student info
        std.printStudent();
      }
      else{
        //else prints a not found message
        System.out.println("Student ID " + id + " not found.");
      }
    }while(id != 0);
  }

  //returns the student with the spcified id
  public static Student lookup(Student[] std, int id) {
    for (int i = 0; i < std.length; i++) {
      if(std[i].getID() == id)
        return std[i];
    }
    return null;
  }

  //return false if id doesn't alreay exist
  public static boolean exist(Student[] std, int id){
    for(int i = 0; i < std.length; i++){
      //checks for null student reference and returns false if so
      if(std[i] == null)
        return false;
      //returns true if student id found
      if(std[i].getID() == id)
        return true;
    }
    return false;
  }
}
