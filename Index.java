import java.util.Scanner;

public class Index {
public static String[][][] locs = {{{" ", "a1"}, {" ", "b1"}, {" ", "c1"}}, 
                                        {{" ", "a2"}, {" ", "b2"}, {" ", "c2"}},
                                        {{" ", "a3"}, {" ", "b3"}, {" ", "c3"}}};   // Locations

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
            coordinates will be a{1,2,3}, b{1,2,3}, c{1,2,3}
            code 0 stands for unfilled block, 1 for player, 2 for computer
            Layout:

                a b c
            1 | X X X |
            2 | X X X |
            3 | X X X |
        */

        

        scanner.close();
    }

    public static void board() {
        System.out.println("    a b c ");
        System.out.println("1 | " + locs[0][0][0] + " " + locs[0][1][0] + " " + locs[0][2][0] + " |");
        System.out.println("2 | " + locs[1][0][0] + " " + locs[1][1][0] + " " + locs[1][2][0] + " |");
        System.out.println("3 | " + locs[2][0][0] + " " + locs[2][1][0] + " " + locs[2][2][0] + " |");
    }
}