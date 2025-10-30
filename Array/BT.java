/*Yêu cầu chức năng

Nhập dữ liệu:
Nhập n (số giao dịch, 1 ≤ n ≤ 10_000).
Nhập n giá trị giao dịch. Giá trị hợp lệ: > 0. Giá trị <= 0 coi là không hợp lệ và không đưa vào phân tích (bạn có thể:
Hoặc bỏ qua khi thêm vào mảng sạch.
Hoặc lưu vào mảng riêng invalid[] để báo cáo).
Thống kê cơ bản trên mảng hợp lệ tx[]:
Tổng doanh thu, trung bình, giao dịch nhỏ nhất/lớn nhất.
Đếm số giao dịch trên một ngưỡng T do người dùng nhập (ví dụ T = 500 nghìn).
Tìm kiếm:
Tuyến tính: kiểm tra xem có giao dịch bằng một giá trị X hay không; in ra tất cả vị trí (index) tìm thấy.
Sắp xếp:
Cài đặt Bubble Sort hoặc Selection Sort để sắp xếp tăng dần mảng tx[].
Sau khi sắp xếp, in top 5 giao dịch lớn nhất (nếu ít hơn 5 thì in tất cả).
Nâng cao (tùy chọn):
Binary Search trên mảng đã sắp xếp cho giá trị X.
Loại bỏ trùng lặp: tạo mảng mới chỉ giữ mỗi giá trị một lần (giữ thứ tự sau sắp xếp).
Chuẩn hóa tiền tệ: nếu dùng double, cân nhắc làm tròn về 1 chữ số thập phân khi in.
Định dạng I/O gợi ý

Input ví dụ:
n = 8
Dòng giá trị: 100 0 250 -10 700 500 500 1200
T = 400
X = 500
Xử lý:
invalid = [0, -10]
tx = [100, 250, 700, 500, 500, 1200]
Output mong muốn (tham khảo):
Tổng = 3250; Trung bình ≈ 541.67
Min = 100; Max = 1200
Trên ngưỡng 400: 4 giao dịch
Vị trí giá trị X=500: index 3, 4 (trước sắp xếp)
Sau sắp xếp tăng: [100, 250, 500, 500, 700, 1200]
Top 5: [1200, 700, 500, 500, 250]
Gợi ý cấu trúc lớp/phương thức

readIntArray() đọc và trả về mảng sau khi lọc giá trị hợp lệ.
sum(int[] a), avg(int[] a), min(int[] a), max(int[] a)
countGreaterThan(int[] a, int threshold)
linearSearchAll(int[] a, int x) trả về mảng index
bubbleSort(int[] a) hoặc selectionSort(int[] a)
topKFromSortedAsc(int[] a, int k) trả về mảng top k từ cuối
(tùy chọn) binarySearch(int[] a, int x) trên mảng đã sắp xếp
(tùy chọn) uniqueFromSorted(int[] a) loại trùng lặp
Tiêu chí hoàn thành

Xử lý đúng dữ liệu hợp lệ/không hợp lệ.
Tất cả thống kê khớp với kết quả kiểm chứng tay.
Sắp xếp đúng, top-k in chính xác với mọi n.
Tìm kiếm tuyến tính trả về tất cả vị trí. Binary search (nếu làm) hoạt động sau sắp xếp.*/

package Array;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so giao dich n (1..10000): ");
        int n = readPositiveInt(sc);
        System.out.println("Nhap " + n + " gia tri giao dich (don vi: nghin dong):");
        int[] raw = readIntN(sc, n);
        int[] invalid = filterInvalid(raw);
        int[] tx = filterValid(raw);
        System.out.println("Giao dich khong hop le (<= 0): " + Arrays.toString(invalid));
        System.out.println("Giao dich hop le: " + Arrays.toString(tx));
        if (tx.length == 0) {
            System.out.println("Khong co du lieu hop le de phan tich.");
            return;
        }
        // Thong ke co ban
        long total = sum(tx);
        double average = avg(tx);
        int minVal = min(tx);
        int maxVal = max(tx);
        System.out.println("Tong doanh thu = " + total);
        System.out.printf("Trung binh = %.2f\n", average);
        System.out.println("Min = " + minVal + "; Max = " + maxVal);
        System.out.print("Nhap nguong T de dem so giao dich > T: ");
        int T = readInt(sc);
        int countGT = countGreaterThan(tx, T);
        System.out.println("> T (" + T + "): " + countGT + " giao dich");
        System.out.print("Nhap gia tri X de tim kiem: ");
        int X = readInt(sc);
        int[] foundIdx = linearSearchAll(tx, X);
        if (foundIdx.length == 0) {
            System.out.println("Khong tim thay X = " + X + " trong mang (truoc sap xep)");
        } else {
            System.out.println("Vi tri X = " + X + " (truoc sap xep): " + Arrays.toString(foundIdx));
        }
        // Sap xep tang dan bang Bubble Sort (khong dung Arrays.sort)
        int[] sorted = Arrays.copyOf(tx, tx.length);
        bubbleSort(sorted);
        System.out.println("Sau sap xep tang: " + Arrays.toString(sorted));
        // Top 5 lon nhat
        int[] top5 = topKFromSortedAsc(sorted, 5);
        System.out.println("Top 5: " + Arrays.toString(top5));
        // (Tuy chon) Binary Search tren mang da sap xep
        int pos = binarySearch(sorted, X);
        if (pos >= 0) {
            System.out.println("Binary search tim thay X = " + X + " tai index (sau sap xep) = " + pos);
        } else {
            System.out.println("Binary search khong thay X = " + X);
        }
        // (Tuy chon) Loai bo trung lap tu mang da sap xep
        int[] unique = uniqueFromSorted(sorted);
        System.out.println("Mang unique (sau sap xep): " + Arrays.toString(unique));
    }

    // ------------ Input helpers ------------
    private static int readPositiveInt(Scanner sc) {
        while (true) {
            int v = readInt(sc);
            if (v >= 1 && v <= 10000)
                return v;
            System.out.print("Vui long nhap so trong khoang [1..10000]: ");
        }
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Khong hop le, nhap lai so nguyen: ");
        }
        return sc.nextInt();
    }

    private static int[] readIntN(Scanner sc, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readInt(sc);
        }
        return a;
    }

    // ------------ Filtering ------------
    private static int[] filterValid(int[] a) {
        int cnt = 0;
        for (int v : a)
            if (v > 0)
                cnt++;
        int[] b = new int[cnt];
        int j = 0;
        for (int v : a)
            if (v > 0)
                b[j++] = v;
        return b;
    }

    private static int[] filterInvalid(int[] a) {
        int cnt = 0;
        for (int v : a)
            if (v <= 0)
                cnt++;
        int[] b = new int[cnt];
        int j = 0;
        for (int v : a)
            if (v <= 0)
                b[j++] = v;
        return b;
    }

    // ------------ Stats ------------
    private static long sum(int[] a) {
        long s = 0;
        for (int v : a)
            s += v;
        return s;
    }

    private static double avg(int[] a) {
        return a.length == 0 ? 0.0 : (double) sum(a) / a.length;
    }

    private static int min(int[] a) {
        int m = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] < m)
                m = a[i];
        return m;
    }

    private static int max(int[] a) {
        int m = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > m)
                m = a[i];
        return m;
    }

    private static int countGreaterThan(int[] a, int threshold) {
        int c = 0;
        for (int v : a)
            if (v > threshold)
                c++;
        return c;
    }

    // ------------ Search ------------
    private static int[] linearSearchAll(int[] a, int x) {
        int c = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == x)
                c++;
        int[] idx = new int[c];
        int j = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == x)
                idx[j++] = i;
        return idx;
    }

    // ------------ Sort ------------
    private static void bubbleSort(int[] a) {
        boolean swapped;
        int n = a.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    int t = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = t;
                    swapped = true;
                }
            }
            n--; // phan tu lon nhat da nam cuoi
        } while (swapped);
    }

    // ------------ Top-K from sorted asc ------------
    private static int[] topKFromSortedAsc(int[] sortedAsc, int k) {
        int take = Math.min(k, sortedAsc.length);
        int[] top = new int[take];
        int idx = sortedAsc.length - 1;
        for (int i = 0; i < take; i++) {
            top[i] = sortedAsc[idx--];
        }
        return top;
    }

    // ------------ Binary search (on sorted asc) ------------
    private static int binarySearch(int[] a, int x) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == x)
                return mid;
            if (a[mid] < x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    // ------------ Unique from sorted asc ------------
    private static int[] uniqueFromSorted(int[] sortedAsc) {
        if (sortedAsc.length == 0)
            return new int[0];
        int count = 1;
        for (int i = 1; i < sortedAsc.length; i++)
            if (sortedAsc[i] != sortedAsc[i - 1])
                count++;
        int[] u = new int[count];
        u[0] = sortedAsc[0];
        int j = 1;
        for (int i = 1; i < sortedAsc.length; i++) {
            if (sortedAsc[i] != sortedAsc[i - 1])
                u[j++] = sortedAsc[i];
        }
        return u;
    }
}