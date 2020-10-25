/*
 * Name: Evan Benitez
 * CSU ID: 2486032
 * CIS 265: Assignment 5
 * Discription: Read students from a file and print to a new
 * file in reverse order
*/

package BenitezAS5;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

//implementing bonus 1-5
public class BenitezAssignment5{
  public static void main(String[] args){
    //determine if the correct number of args has been entered
    if(args.length == 2){
      //hold all the student objects
      ArrayList<Student> students = new ArrayList<Student>();
      //get file information
      try{
        //open file and make ready for use
        File file = new File(args[0]);
        Scanner input = new Scanner(file);
        //create a student objects from the file information
        while(input.hasNext()){
          String line = input.nextLine();
          String[] tokens = line.split(",");
          //check for correct number of field and 4th and 5 fields are correct
          if(tokens.length == 5 && (tokens[3].toLowerCase().equals("graduate")||
          (tokens[3].toLowerCase().equals("undergraduate") &&
          (tokens[4].toLowerCase().equals("true") ||
          tokens[4].toLowerCase().equals("false"))))) {
            try{
              int id = Integer.parseInt(tokens[1]);
              float gpa = Float.parseFloat(tokens[2]);
              //determine type of students
              if(tokens[3].toLowerCase().equals("undergraduate")){
                //create and add undergrad student to array list
                UndergradStudent underStd = new UndergradStudent(tokens[0], id, gpa,
                                                Boolean.parseBoolean(tokens[4]));
                students.add(underStd);
              }
              else{
                GradStudent gradStd = new GradStudent(tokens[0], id, gpa, tokens[4]);
                students.add(gradStd);
              }
            }
            catch(NumberFormatException num){
              System.out.println("Invalid input: " + line);
            }
          }
          else{
            System.out.println("Invalid input: " + line);
          }
        }
        //close input stream
        input.close();

        //create a output file
        PrintWriter output = new PrintWriter(args[1]);
        //print in reverse order
        while(students.size() > 0){
          students.remove(students.size() - 1).printStudent(output);
        }
        output.close();
      }
      catch(IOException e){
          System.out.println("File " + args[0] + " not found.");
      }
    }
    else{
      System.out.println("Usage: BenitezAS5.BenitezAssignment input_file output_file");
    }
  }
}
