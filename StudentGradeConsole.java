import java.util.*;
class Subject {
String subjectName;
int mark;
Subject(String subjectName, int mark) {
this.subjectName = subjectName;
this.mark = mark;
}
}
class Student {
String name;
String rollNo;
String className;
String section;
ArrayList<Subject> subjects;
Student(String name, String rollNo, String className, String section) {
this.name = name;
this.rollNo = rollNo;
this.className = className;
this.section = section;
this.subjects = new ArrayList<>();
}
void addSubject(String subjectName, int mark) {
subjects.add(new Subject(subjectName, mark));
}
double getAverage() {
if (subjects.isEmpty()) return 0;
int total = 0;
for (Subject s : subjects) {
total += s.mark;
}
return (double) total / subjects.size();
}
int getHighest() {
int max = Integer.MIN_VALUE;
for (Subject s : subjects) {
if (s.mark > max) max = s.mark;
}
return max;
}
int getLowest() {
int min = Integer.MAX_VALUE;
for (Subject s : subjects) {
if (s.mark < min) min = s.mark;
}
return min;
}
void displaySummary() {
System.out.println("--------------------------------------------------");
System.out.println("Name     : " + name);
System.out.println("Roll No  : " + rollNo);
System.out.println("Class    : " + className);
System.out.println("Section  : " + section);
System.out.println("Subjects :");
for (Subject s : subjects) {
System.out.println("   " + s.subjectName + " = " + s.mark);
}
System.out.printf("Average  : %.2f\n", getAverage());
System.out.println("Highest  : " + getHighest());
System.out.println("Lowest   : " + getLowest());
System.out.println("--------------------------------------------------\n");
}
}
public class StudentGradeConsole {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
ArrayList<Student> studentList = new ArrayList<>();
System.out.print("Enter number of students: ");
int totalStudents = sc.nextInt();
sc.nextLine(); 
for (int i = 0; i < totalStudents; i++) {
System.out.println("\nEnter details for Student " + (i + 1) + ":");
System.out.print("Name     : ");
String name = sc.nextLine();
System.out.print("Roll No  : ");
String roll = sc.nextLine();
System.out.print("Class    : ");
String cls = sc.nextLine();
System.out.print("Section  : ");
String sec = sc.nextLine();
Student student = new Student(name, roll, cls, sec);
System.out.print("Enter number of subjects: ");
int subCount = sc.nextInt();
sc.nextLine(); 
for (int j = 0; j < subCount; j++) {
System.out.print("Subject " + (j + 1) + " name : ");
String subName = sc.nextLine();
System.out.print("Subject " + (j + 1) + " mark : ");
int mark = sc.nextInt();
sc.nextLine(); 
student.addSubject(subName, mark);
}
studentList.add(student);
}
System.out.println("\n========== STUDENT GRADE REPORT ==========\n");
for (Student s : studentList) {
s.displaySummary();
}
sc.close();
}
}


