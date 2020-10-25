/*
 * Name: Evan Benitez
 * CSU ID: 2486032
 * CIS 265: Assignment 7
 * Discription: Search a directory for all instances of files with the partial
 * given name
*/

import java.io.File;
import java.util.LinkedHashSet;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;

//implementing bonus features
public class BenitezAssignment7 {
  public static void main(String[] args) {
    //check for proper number of arguments
    if(args.length == 2){
      try {
        //create file
        File dir = new File(args[0]);
        //search for files
        LinkedHashSet<File> matches = searchDir(dir, args[1]);
        //print matching files, creation date and file size
        SimpleDateFormat date = new SimpleDateFormat("E MMM d HH:mm:ss zzz yyyy");
        matches.forEach(new java.util.function.Consumer<File>() {
                              public void accept(File e)  {
                                try{
                                System.out.println(e.getAbsolutePath() + " "
                                + date.format(Files.readAttributes(e.toPath(), BasicFileAttributes.class).creationTime().toMillis()) + " "
                                + e.length());
                                }
                                catch(java.io.IOException error){
                                  System.out.println("Failed to print file paths.");
                                }
                              }
        });
      }
      catch(java.io.IOException e){
        System.out.println("An error occured.");
      }
    }
    //print out correct input formate
    else {
      System.out.println("Incorrect input.");
      System.out.println("BenitezAssignment7 search_directory target_file");
    }
  }

  //searches for all instances with the target name in the directory
  public static LinkedHashSet<File> searchDir(File dir, String target) throws java.io.IOException{
    //check if directory
    if(dir.isDirectory()){
      //check to see if file is empty
      if(dir.length() > 0){
        //create array of files for dir
        File[] subDir = dir.listFiles();
        //check to make sure array isn't empty
        if(subDir != null){
          //place to store target file matches
          LinkedHashSet<File> match = new LinkedHashSet<>();
          //search each file in directory for target file
          for(File file : subDir){
            match.addAll(searchDir(file, target));
          }
          return match;
        }
      }
      //return empty LinkedHashSet if file is empty or array is empty
      return new LinkedHashSet<File>();
    }
    else{
      //check if file matches target
      if(dir.getName().toLowerCase().contains(target.toLowerCase())){
        //return the match
        LinkedHashSet<File> match = new LinkedHashSet<>();
        match.add(dir);
        return match;
      }
      //return an empty LinkedHashSet if not a match
      return new LinkedHashSet<File>();
    }
  }
}
