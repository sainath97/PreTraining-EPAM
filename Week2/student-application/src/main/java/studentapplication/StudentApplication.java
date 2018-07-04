package studentapplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * Used to perform searching and sorting on a list of students.
 * @author sainath
 */
public class StudentApplication {
  /**
   * main function of the program commonly used to start the execution.
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Student> studentList = new ArrayList<>();
    String fileName = "E:\\CSE\\EPAM\\PreTraining-EPAM"
    + "\\Week2\\student-application\\students.txt";
    try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader reader = new BufferedReader(fileReader);
      String line = reader.readLine();
      while (line != null) {
        String[] tokens = line.split(",");
        studentList.add(new Student(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3])));
        line = reader.readLine();
      }
      reader.close();
      fileReader.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
    System.out.println("=================Student Search and Sort=================");
    while (true) {
      System.out.println("Please select among the following 3 available options");
      System.out.println("1. To Sort the Students\n2. To Search for a Student\n3. To EXIT from the Application");
      System.out.print("Enter your Selection: ");
      try {
        int choice = sc.nextInt();
        switch (choice) {
          case 1:
            sortStudents(studentList);
            break;
          case 2:
            searchStudent(studentList);
            break;
          case 3:
            System.out.println("Thanks for using the application! :-)");
            return;
          default:
            System.out.println("Invalid Choice!");
        }
      } catch (InputMismatchException e) {
        System.out.println("Input Format Invalid :-( Please enter a number.");
        sc.nextLine();
      }
    }
  }

  /**
   * This method is used to sort the list of students based on users selection.
   * @param studentList List of Students
   */
  private static void sortStudents(List<Student> studentList) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Select a base to sort the students");
    System.out.println("1. First Name \t2. Last Name\n3. Class \t4. ID");
    System.out.print("Enter your sorting criteria: ");
    try {
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          Collections.sort(studentList);
          System.out.println("\nBased on First Name");
          System.out.println("ID\tClass\tLastName\tFirstName");
          System.out.println("==\t=====\t========\t=========");
          for (Student s:studentList) {
            System.out.println(s.getId() + "\t" + s.getCls()
            + "\t" + s.getLastName() + "     \t" + s.getFirstName());
          }
          break;
        case 2:
          Collections.sort(studentList, new Comparator<Student>() {
                @Override
                public int compare(final Student s1, final Student s2) {
                  return (s1.getLastName().compareToIgnoreCase(s2.getLastName()));
                }
          });
          System.out.println("\nBased on Last Name");
          System.out.println("ID\tClass\tLastName\tFirstName");
          System.out.println("==\t=====\t========\t=========");
          for (Student s:studentList) {
            System.out.println(s.getId() + "\t" + s.getCls()
            + "\t" + s.getLastName() + "     \t" + s.getFirstName());
          }
          break;
        case 3:
          Collections.sort(studentList, new Comparator<Student>() {
                @Override
                public int compare(final Student s1, final Student s2) {
                  return (s1.getCls().compareToIgnoreCase(s2.getCls()));
                }
          });
          System.out.println("\nBased on Class");
          System.out.println("ID\tClass\tLastName\tFirstName");
          System.out.println("==\t=====\t========\t=========");
          for (Student s:studentList) {
            System.out.println(s.getId() + "\t" + s.getCls()
            + "\t" + s.getLastName() + "     \t" + s.getFirstName());
          }
          break;
        case 4:
          Collections.sort(studentList, new Comparator<Student>() {
                @Override
                public int compare(final Student s1, final Student s2) {
                  if (s1.getId() > s2.getId()) {
                    return 1;
                  } else if (s1.getId() < s2.getId()) {
                    return -1;
                  } else {
                    return 0;
                  }
                }
          });
          System.out.println("\nBased on ID");
          System.out.println("ID\tClass\tLastName\tFirstName");
          System.out.println("==\t=====\t========\t=========");
          for (Student s:studentList) {
            System.out.println(s.getId() + "\t" + s.getCls()
            + "\t" + s.getLastName() + "     \t" + s.getFirstName());
          }
          break;
        default:
          System.out.println("Invalid Choice!");
      }
    } catch (InputMismatchException e) {
      System.out.println("Input Format Invalid :-( Please enter a number.");
    }
  }

  /**
   * This method is used to search for a student in a list of students.
   * @param studentList list of students
   */
  private static void searchStudent(List<Student> studentList) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Select a base to sort the students");
    System.out.println("1. First Name \t2. Last Name\n3. Class \t4. ID");
    System.out.print("Enter your search criteria: ");
    try {
      int choice = sc.nextInt();
      sc.nextLine();
      int flag = 0;
      switch (choice) {
        case 1:
          System.out.print("Enter First Name: ");
          String firstName = sc.nextLine();
          for (Student s:studentList) {
            if (s.getFirstName().equalsIgnoreCase(firstName)) {
              System.out.println("ID\tClass\tLastName\tFirstName");
              System.out.println("==\t=====\t========\t=========");
              System.out.println(s.getId() + "\t" + s.getCls()
              + "\t" + s.getLastName() + "     \t" + s.getFirstName());
              flag = 1;
            }
          }
          break;
        case 2:
          System.out.print("Enter Last Name: ");
          String lastName = sc.nextLine();
          for (Student s:studentList) {
            if (s.getLastName().equalsIgnoreCase(lastName)) {
              System.out.println("ID\tClass\tLastName\tFirstName");
              System.out.println("==\t=====\t========\t=========");
              System.out.println(s.getId() + "\t" + s.getCls()
              + "\t" + s.getLastName() + "     \t" + s.getFirstName());
              flag = 1;
            }
          }
          break;
        case 3:
          System.out.print("Enter Class Name: ");
          String cls = sc.nextLine();
          for (Student s:studentList) {
            if (s.getCls().equalsIgnoreCase(cls)) {
              System.out.println("ID\tClass\tLastName\tFirstName");
              System.out.println("==\t=====\t========\t=========");
              System.out.println(s.getId() + "\t" + s.getCls()
              + "\t" + s.getLastName() + "     \t" + s.getFirstName());
              flag = 1;
            }
          }
          break;
        case 4:
          try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            for (Student s:studentList) {
              if (s.getId() == id) {
                System.out.println("ID\tClass\tLastName\tFirstName");
                System.out.println("==\t=====\t========\t=========");
                System.out.println(s.getId() + "\t" + s.getCls()
                + "\t" + s.getLastName() + "     \t" + s.getFirstName());
                flag = 1;
              }
            }
          } catch (InputMismatchException e) {
            System.out.println("Input Format Invalid :-("
          + " Please enter a number.");
            flag = 1;
          }
          break;
        default:
          flag = 1;
          System.out.println("Invalid choice!");
      }
      if (flag == 0) {
        System.out.println("No Student found with that data");
      }
    } catch (InputMismatchException e) {
      System.out.println("Input Format Invalid :-( Please enter a number.");
    }
  }
}
