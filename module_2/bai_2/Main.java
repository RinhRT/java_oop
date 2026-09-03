package bai_2;

public class Main {
    public static void main(String[] args) {
    SinhVien sv1 = new SinhVien(1001, "Nguyen Van A", 8.5f, 9.0f);
    SinhVien sv2 = new SinhVien(1002, "Tran Van B", 7.0f, 8.0f);

    try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
        SinhVien sv3 = new SinhVien();

        System.out.print("Nhap ma sinh vien: ");
        int maSV = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap diem LT: ");
        float diemLT = scanner.nextFloat();
        System.out.print("Nhap diem TH: ");
        float diemTH = scanner.nextFloat();

        sv3.setMaSV(maSV);
        sv3.setHoTen(hoTen);
        sv3.setDiemLT(diemLT);
        sv3.setDiemTH(diemTH);

        // Thay cach gan du lieu bang constructor day du tham so.
        sv3 = new SinhVien(maSV, hoTen, diemLT, diemTH);

        System.out.printf("%-10s %-30s %5s %5s %5s%n",
            "MSSV", "Ho ten", "Diem LT", "Diem TH", "Diem TB");
        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);
    }
    }
}