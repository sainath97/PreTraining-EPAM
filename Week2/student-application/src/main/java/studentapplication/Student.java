package studentapplication;
/**
 * Prototype of a student.
 * @author sainath
 */
class Student implements Comparable {
  /**
   * firstName is the first name of the student.
   * lastName is the last name of the student
   * cls represents the department of the student
   */
  private String firstName, lastName, cls;
  /**
   * id represents the registration id of the student.
   */
  private int id;

  /**
   * Constructor used to initialize the values of a student object.
   * @param firstName represents the first name of the student
   * @param lastName represents the last name of the student
   * @param cls represents the department of the student
   * @param id represents the registration id of the student
   */
  public Student(String firstName, String lastName, String cls, int id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.cls = cls;
    this.id = id;
  }

  /**
   * used to compare the student objects based on firstName.
   */
  @Override
  public int compareTo(final Object o) {
    Student other = (Student) o;
    return (this.firstName.compareToIgnoreCase(other.firstName));
  }
  /**
   * This method returns the first name of the student.
   * @return firstName of the student
   */
  public String getFirstName() {
    return this.firstName;
  }
  /**
   * This method returns the last name of the student.
   * @return lastName of the student
   */
  public String getLastName() {
    return this.lastName;
  }
  /**
   * This method returns the class of the student.
   * @return cls of the student
   */
  public String getCls() {
    return this.cls;
  }
  /**
   * This method returns the registration id of the student.
   * @return id of the student
   */
  public int getId() {
    return this.id;
  }
}
