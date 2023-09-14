import java.util.Arrays;

public class StudentManager {
    private int size = 0;

    private Student[] students;
    private double avgAllScore;


    public StudentManager() {
    }

    public double avgScoreOfClass() {
        for (Student student : students) {
            avgAllScore += student.getAvgScore();
        }
        return avgAllScore / students.length;
    }

    public Student[] addStudent(Student student) {

        Student[] newStudents = new Student[size + 1];

        for (int i = 0; i < size; i++)
            newStudents[i] = students[i];

        newStudents[size] = student;
        size++;
        return newStudents;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student[] editStudent(int id, Student student) {
        Student student1 = getStudentById(id);
        Student[] newStudents = new Student[size];
        student1.setName(student.getName());
        student1.setGender(student.isGender());
        student1.setScore(student.getScore());
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                newStudents[i] = student1;
            } else {
                newStudents[i] = students[i];
            }
        }
        return newStudents;
    }

    public Student[] deleteStudent(int id) {
        Student[] newStudents = new Student[size - 1];
        for (int i = 0, k = 0; i < students.length; i++) {
            if (students[i].getId() != id) {
                newStudents[k] = students[i];
                k++;
            }
        }
        size--;
        return newStudents;
    }

    public void findStudentsByName(String name){
        StudentManager smTemp = new StudentManager();
        smTemp.size =0;
        for (int i=0;i<students.length;i++){
            if(students[i].getName().contains(name)){
                smTemp.setStudents(smTemp.addStudent(students[i]));
            }
        }
        for (Student student : smTemp.students) {
            System.out.println(student);
        }
    }
    public void getAllStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void getTopAvgStudents(){
        double max = students[0].getAvgScore();
        for(Student student: students){
            if(max< student.getAvgScore()){
                max = student.getAvgScore();
            }
        }
        StudentManager smTemp = new StudentManager();
        smTemp.size =0;
        for (int i=0;i<students.length;i++){
            if(students[i].getAvgScore() == max){
                smTemp.setStudents(smTemp.addStudent(students[i]));
            }
        }
        for (Student student : smTemp.students) {
            System.out.println(student);
        }
    }
    public void setStudents(Student[] students) {
        this.students = students;
    }


}
