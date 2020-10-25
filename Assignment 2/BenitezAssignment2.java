/*
 *  Name: Evan Benitez
 *  CSU ID: 2486032
 *  CIS 265: Assignment #2
 *  Description: Asks the user to input students ID # and their score. It will
 *               ask for a studends ID number and return their score.
 *               (Will be implementing the Bonus Feature)
*/

import java.util.Scanner;
import java.util.Arrays;

public class BenitezAssignment2 { //implementing bonus features
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); //Scanner for user input
    int[][] stdInfo;                        //integer array for student information

    System.out.print("How many student records are there? ");
    int number = input.nextInt();           //The number of student records
    if(number > 0) {
      stdInfo = new int[number][2];         //Creates the stdInfo integer array with space for the specified number of records.
      populate(stdInfo, input);             //populate the array with the number of student records previously specified
      lookUp(stdInfo, input);               //retreive student records until zero is entered.
      System.out.println("Goodbye.");
    }
    else {
      System.out.println("Number of students must be greater than 0.");
    }
  }

  //populate the array with the number of student records
  public static void populate(int[][] stdInfo, Scanner input) {
    for(int i = 0; i < stdInfo.length; i++){
      System.out.print("Enter student " + i + " and score: ");
      stdInfo[i][0] = input.nextInt();    //gets student ID number
      stdInfo[i][1] = input.nextInt();    //gets student's score
    }
  }

  //outputs specified student scores until zero is endered.
  public static void lookUp(int[][] stdInfo, Scanner input) {
    int id;
    do {
      System.out.print("Enter a student ID (enter 0 to quit): ");
      id = input.nextInt();             //get student ID
      if( id != 0) {
        int i;                          //counter for for loop

        //perfomr linear search for ID
        for(i = 0; i < stdInfo.length; i++) {
          if(stdInfo[i][0] == id){
            System.out.println("Student " + id + " scored " + stdInfo[i][1]);
            i = stdInfo.length + 1;     //change value of i to break out of for loop and not trigger the not found check
          }
        }
        //inform user that ID wasn't found
        if(i == stdInfo.length)
            System.out.println("Student ID " + id + " not found.");
      }
    } while(id != 0);

  }
}
