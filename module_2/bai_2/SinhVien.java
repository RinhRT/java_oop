package bai_2;

import java.lang.reflect.Field;

public class SinhVien {
    private int maSV;
    private String hoTen = "";
    private float diemLT;
    private float diemTH;

    public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
        setMaSV(maSV);
        setHoTen(hoTen);
        setDiemLT(diemLT);
        setDiemTH(diemTH);
    }

    public SinhVien() {}

    public void getter(String attribute) {
        try {
            Field field = this.getClass().getDeclaredField(attribute);
            field.setAccessible(true);
            System.out.println(field.get(this));
        } catch (NoSuchFieldException e) {
            System.err.println("Attribute does not exist: " + attribute);
        } catch (IllegalAccessException e) {
            System.err.println("Unable to access attribute: " + attribute);
        }
    }

    public void setMaSV(int maSV) {
        if (maSV > 0) 
            this.maSV = maSV;
        else
            System.err.println("Mã sinh viên phải là số nguyên>0.");
    }

    public void setHoTen(String hoTen) {
        if (hoTen != null && !hoTen.isBlank())
            this.hoTen = hoTen;
        else
            System.err.println("Họ tên chuỗi, không được rỗng.");
    }

    public void setDiemLT(float diemLT) {
        if (diemLT>=0.0 && diemLT<=10.0)
            this.diemLT = diemLT;
        else
            System.err.println("Điểm LT là số thực, thuộc [0.0, 10.0]).");
    }

    public void setDiemTH(float diemTH) {
        if (diemTH>=0.0 && diemTH<=10.0)
            this.diemTH = diemTH;
        else
            System.err.println("Điểm TH là số thực, thuộc [0.0, 10.0]).");
    }

    public float average() {
        return (float)(this.diemTH+this.diemLT)/2;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-30s %5.2f %5.2f %5.2f",
            maSV, hoTen, diemLT, diemTH, average());
    }
}