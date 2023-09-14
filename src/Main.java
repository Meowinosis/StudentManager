import java.util.Scanner;

public class Main {
    public static Student inputInfor() {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        boolean flagGender = false;
        System.out.println("Nhap ten:");
        student.setName(sc.nextLine());
        do {
            System.out.println("Nhap gioi tinh:");
            String gender = sc.nextLine();
            if (gender.equalsIgnoreCase("male")) {
                student.setGender(true);
                flagGender = true;
            } else if (gender.equalsIgnoreCase("female")) {
                flagGender = true;
            } else {
                System.out.println("Vui long nhap lai gioi tinh (Male or Female)");
            }
        } while (!flagGender);
        for (int i = 0; i < student.getScore().length; i++) {
            System.out.println("Nhap diem " + (i + 1) + ":");
            double diem = sc.nextDouble();
            student.getScore()[i] = diem;
        }
        sc.nextLine();
        return student;
    }

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        Student st1 = new Student("Phon",new double[]{3.0,4.0,5.0},true);
        Student st2 = new Student("Phong",new double[]{1.0,2.0,3.0},true);
        Student st3 = new Student("Huan",new double[]{3.0,4.0,5.0},true);
        sm.setStudents(sm.addStudent(st1));
        sm.setStudents(sm.addStudent(st2));
        sm.setStudents(sm.addStudent(st3));
        Student student;
        Scanner sc = new Scanner(System.in);
        int id;
        int choice;
        do {
            System.out.println("Chon option: "
                    + "\n1. Thêm học sinh"
                    + "\n2. Hiển thị học sinh"
                    + "\n3. Chỉnh sửa sinh viên"
                    + "\n4. Xóa sinh viên"
                    + "\n5. Tính điểm trung bình của các học sinh"
                    + "\n6. Tìm học viên theo ID"
                    + "\n7. Tìm học viên theo tên gần đúng"
                    + "\n8. Tìm học viên có điểm trung bình lớn nhất"
                    + "\n9. Exit");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    student = inputInfor();
                    sm.setStudents(sm.addStudent(student));
                    break;
                case 2:
                    sm.getAllStudent();
                    break;
                case 3:
                    System.out.println("Nhap id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if (sm.getStudentById(id) == null) {
                        System.out.println("không tìm thấy sinh viên");
                    } else {
                        student = inputInfor();
                        sm.setStudents(sm.editStudent(id, student));
                    }
                    break;
                case 4:
                    System.out.println("Nhap id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if (sm.getStudentById(id) == null) {
                        System.out.println("không tìm thấy sinh viên");
                    } else {
                        sm.setStudents(sm.deleteStudent(id));
                    }
                    break;
                case 5:
                    System.out.println("Điểm trung bình của tất cả sinh viên:" + sm.avgScoreOfClass());
                    break;
                case 6:
                    System.out.println("Nhap id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    if (sm.getStudentById(id) == null) {
                        System.out.println("không tìm thấy sinh viên");
                    } else {
                        System.out.println(sm.getStudentById(id));
                    }
                    break;
                case 7:
                    System.out.println("Nhap ten muon tim: ");
                    String name = sc.nextLine();
                    sm.findStudentsByName(name);
                    break;
                case 8:
                    sm.getTopAvgStudents();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
