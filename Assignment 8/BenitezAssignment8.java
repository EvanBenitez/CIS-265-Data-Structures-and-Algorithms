/*
 * Name: Evan Benitez
 * CSU ID: 2486032
 * CIS 265: Assignment 8
 * Discription: Count the number of occurences of each word in a file.
*/

import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;

//implementing both bonus features
public class BenitezAssignment8 {
  public static void main(String[] args) {
    if(args.length == 1){
      //convert a file to a StringBuilder
      StringBuilder file = loadFile(args[0]);
      //remove puctuation and extra white space
      strip(file);
      //convert StringBuilder to a lowercase string array
      String[] text = file.toString().toLowerCase().split(" ");
      //print out the word count
      wordCount(text);
    }
    else {
      System.out.println("Incorrect number of argument");
      System.out.println("Format:");
      System.out.println("  BenitezAssignment8 source_file");
    }
  }

  //puts the content of a file into a StringBuilder object
  public static StringBuilder loadFile(String file){
    StringBuilder text = new StringBuilder();
    try{
      Scanner input = new Scanner(new File(file));
      //reads file and puts it in the text object
      while(input.hasNext()){
        text.append(input.nextLine());
        //place a space between each line
        text.append(" ");
      }
    }
    catch(java.io.IOException e){
      System.out.println("Incorrect file path");
    }
    finally{
      return text;
    }
  }

  //Removes punctuation and replaces with a space.
  public static void strip(StringBuilder text){
    for(int i = 0; i < text.length(); i++){
      char index = text.charAt(i);
      if(index == ',' || index == '!' || index == '?' || index == '.')
        text.setCharAt(i, ' ');
      //Remove extra white space
      while(i + 1 < text.length() && text.charAt(i) == ' ' && text.charAt(i + 1) == ' '){
        text.deleteCharAt(i + 1);
      }
    }
  }

  //print out the number of each word in a String array
  public static void wordCount(String[] text){
    TreeMap<String, Integer> words = new TreeMap<>();
    for(int i = 0; i < text.length; i++){
      if(words.containsKey(text[i])){
        //increment value
        words.put(text[i], Integer.valueOf(words.get(text[i]).intValue() + 1));
      }
      else{
        //create entry and set value to 1
        words.put(text[i], Integer.valueOf(1));
      }
    }
    //print out word and number of occurences
    words.forEach((word, num) -> System.out.println(word + ": " + num));
  }
}
