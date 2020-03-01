import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = 0;
        String idk = " ";
        while (i < 10) {
            idk = s.next();
            i++;
        }

        System.out.println(idk);
        s.close();
    }
}