package BT_Java_If_Else;
import java.util.Scanner;
public class Tinh_Nghiem_X {
    public static void main(String[] args) {
        int a,b;
        System.out.println("nhap vao so a");
        
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();

        System.out.println("nhap vao so b");
        Scanner sc1 = new Scanner(System.in);
        b = sc1.nextInt();
        if (a==0 && b==0 ) {
            System.out.println("phuong trinh vo so nghiem");
        } else if (a==0 && b!=0) {
            System.out.println("phuong trinh vo nghiem");
        } else {
            float x = (float)-b/a;
            System.out.println("phuong trinh co nghiem x = " + x);
            
        }
        
    }
}
