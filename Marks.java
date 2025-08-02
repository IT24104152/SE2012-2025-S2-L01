
import java.util.Scanner;

public class Marks {
  static int n;
  static int choice;
  static Scanner scanner=new Scanner(System.in);
  static int[][] matrix;

  public static void main(String [] args){
  System.out.print("Enter the number of students: ");
    n=scanner.nextInt();
    System.out.print("\n\nEnter the choice:\nAdd student marks\nUpdate student mark\nGet the average for a subject\nGet the average for a student\nGet the total mark of a student      ->");
    choice=scanner.nextInt();
    matrix=new int [n][3];
    while(choice!=-99){
      switch (choice) {
          case 1:
              addStudentMark();
              break;
          case 2:
              updateMark();
              break;
          case 3:
              getAverageSubject();
              break;
          case 4:
              getAverageStudent();
              break;
          case 5:
              getTotalStudentMarks();
              break;                              
          default:
            System.out.print("Not valid!");
      }
      System.out.print("Enter the choice: ");
      choice=scanner.nextInt();      
    }
    for (int i = 0; i < matrix.length; ++i) {
        for (int j = 0; j < matrix[i].length; ++j) {
            System.out.print(getGrade(matrix[i][j])+" ");
        }
        System.out.println();
    }

  }

  static String getGrade(int score) {
      if (score >= 90) return "A";
      else if (score >= 80) return "B";
      else if (score >= 70) return "C";
      else if (score >= 60) return "D";
      else return "Fail";
  }

  private static int getTotalStudentMarks() {
    return getAverageStudent()*3;
  }

  private static int getAverageStudent() {
    System.out.print("Enter the student Id: ");
    int index=scanner.nextInt()-1;
    int total=0;
    for(int i=0;i<matrix[0].length;++i){
      total+=matrix[index][i];
    }

    return total;
  }

  private static void getAverageSubject() {
    System.out.print("Enter the subject code: ");
    int subject=scanner.nextInt()-1;
    int total=0;
    for(int i=0;i<matrix.length;++i){
      total+=matrix[i][subject];
    }
  }

  private static void updateMark() {
    System.out.print("Enter the subject code: ");
    int subject=scanner.nextInt()-1;
    System.out.print("Enter the student Id: ");
    int index=scanner.nextInt()-1;
    System.out.print("Enter the student new mark: ");    
    matrix[index][subject]=scanner.nextInt();    
  }

  private static void addStudentMark() {
    System.out.print("Enter the subject code: ");
    int subject=scanner.nextInt()-1;
    System.out.print("Enter the student Id: ");
    int index=scanner.nextInt()-1;
    System.out.print("Enter the student mark: ");    
    matrix[index][subject]=scanner.nextInt();
  }

}