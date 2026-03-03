
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {

    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | GPA: " + gpa;
    }
}

public class Exer1 {

    static Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());

    static class StudentManager {
        private final List<Student> data = new ArrayList<>();

        void addFromInput() {
            System.out.print("Nhap MSSV: ");
            String id = scanner.nextLine();

            System.out.print("Nhap ten: ");
            String name = scanner.nextLine();

            System.out.print("Nhap diem GPA: ");
            double gpa;
            try {
                gpa = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("GPA khong hop le, mac dinh = 0");
                gpa = 0;
            }

            data.add(new Student(id, name, gpa));
            System.out.println("Da them sinh vien thanh cong");
        }

        List<Student> getAll() {
            return data;
        }

        void printAll() {
            if (data.isEmpty()) {
                System.out.println("Danh sach rong");
                return;
            }

            for (Student sv : data) {
                System.out.println(sv);
            }
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        System.out.print("\nNhap so luong sinh vien muon them: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            n = 1;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nSinh vien thu " + (i + 1) + ":");
            manager.addFromInput();
        }

        System.out.println("\nDanh sach sinh vien:");
        manager.printAll();
    }
}

