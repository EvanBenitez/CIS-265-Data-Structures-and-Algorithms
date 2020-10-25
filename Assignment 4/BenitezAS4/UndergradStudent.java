package BenitezAS4;

public class UndergradStudent extends Student{

  //are they a transfer student
  private boolean isTransfer;

  //Creates an undergradStudent object
  public UndergradStudent(String name, int id, float gpa, boolean tran){
    super(name, id, gpa);
    isTransfer = tran;
  }

  //prints the student
  public void printStudent(){
    super.printStudent();
    System.out.println("    Transfer Student: " + isTransfer);
  }
}
