import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Exer2 {

    static CompletableFuture<Double> calculateAverageGpa(List<Student> students) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (students == null || students.isEmpty()) {
                    throw new IllegalArgumentException("Danh sach sinh vien rong hoac null");
                }

                Thread.sleep(1000);

                double total = 0;
                for (Student student : students) {
                    total += student.getGpa();
                }

                return total / students.size();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Tac vu bi gian doan", e);
            }
        });
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("SV01", "An", 3.2));
        students.add(new Student("SV02", "Binh", 2.8));
        students.add(new Student("SV03", "Chi", 3.6));

        CompletableFuture<Double> averageFuture = calculateAverageGpa(students)
                .exceptionally(ex -> {
                    System.out.println("Loi khi tinh GPA trung binh: " + ex.getMessage());
                    return 0.0;
                });

        System.out.println("Dang tinh GPA trung binh... luong chinh khong bi chan.");

        for (int i = 1; i <= 3; i++) {
            System.out.println("dang xu ly ... buoc " + i);
        }

        double averageGpa = averageFuture.join();
        System.out.println("GPA trung binh = " + averageGpa);
    }
}