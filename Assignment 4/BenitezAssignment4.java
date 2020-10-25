/*
 * Name: Evan Benitez
 * CSU ID: 2486032
 * CIS 265: Assignment 4
 * Discription: Create an array of students and
 * assign them various information including
 * there status as a transfer or grad student
*/

package BenitezAS4;

import java.util.Scanner;
import java.util.ArrayList;

//Implementing bonus 1 and 2
public class BenitezAssignment4{
  public static void main(String args[]){

    //for user input
    Scanner input = new Scanner(System.in);
    //for all the student objects
    ArrayList<Student> students = new ArrayList<Student>();
    //Deside if more students need to be entered.
    String moreStudent;

    //Ask if student data should be entered
    do{
      System.out.print("Would you like to enter student data? (Y for yes, N for no): ");
      moreStudent = input.nextLine().toUpperCase();
    }while(!moreStudent.equals("Y") && !moreStudent.equals("N") );

    //start collecting student info
    while(moreStudent.equals("Y")){
      //for if the student is a grad or undergrade student
      String type;
      int id;
      float gpa;

      //general student data
      String name;
      //get Graduate/undergraduate and check for proper input
      do{
        System.out.print("Graduate or Undergraduate? (G for graduate, U for undergraduate): ");
        type = input.nextLine().toUpperCase();
      }while(!type.equals("G") && !type.equals("U") );

      //general student info gathering
      System.out.print("Student name: ");
      name = input.nextLine();
      System.out.print("Student ID: ");
      id = input.nextInt();
      System.out.print("Student GPA: ");
      gpa = input.nextFloat();
      input.nextLine();

      if(type.equals("U")){
        boolean transfer;
        System.out.print("Is student a transfer student? (Y for yes, N for no): ");

        //user ternary operator to assigne transfer status
        transfer = input.nextLine().toUpperCase().equals("Y") ? true : false;

        //Add the student
        students.add(new UndergradStudent(name, id, gpa, transfer));
      }
      else{
        //for college attended
        String college;

        System.out.print("What college did the student graduate from?: ");
        college = input.nextLine();

        //add the student
        students.add(new GradStudent(name, id, gpa, college));
      }
      //ask if there are additional students
      do{
        System.out.print("Do you have more students to enter? (Y for yes, N for no)");
        moreStudent = input.nextLine().toUpperCase();
      }while(!moreStudent.equals("Y") && !moreStudent.equals("N") );
    }

    //student retrieval phase
    int id;
    do{
      System.out.print("Enter a student ID (enter 0 to quit): ");
      id = input.nextInt();
      if(id != 0){
        Student std = lookup(students, id);

        if(std != null){
          //prints student info
          std.printStudent();
        }
        else{
          //else prints a not found message
          System.out.println("Student ID " + id + " not found.");
        }
      }
    }while(id != 0);
    System.out.println("Good bye.");
  }

  //returns the student with the spcified id
  public static Student lookup(ArrayList<Student> std, int id) {
    for (int i = 0; i < std.size(); i++) {
      if(std.get(i).getID() == id)
        return std.get(i);
    }
    return null;
  }
}
