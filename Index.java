import java.util.Scanner;

public class Index {
public static String[][][] locs = {{{" ", "a1"}, {" ", "b1"}, {" ", "c1"}}, 
                                   {{" ", "a2"}, {" ", "b2"}, {" ", "c2"}},
                                   {{" ", "a3"}, {" ", "b3"}, {" ", "c3"}}};
public static int movesCommitted = 0;

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

            First O has turn then X.
        */

        //  Instructions
        System.out.println("Welcome to 2v2 Tic Tac Toe!");
        System.out.println("Enter coordinates as [letter][number] pairs.\nHave fun Ara Ara!");
        String move = "";
        boolean drawCounter = true;     // Determines a tie or not
        board();    // Board initialize
        
        do {
            String symbol = (movesCommitted % 2 == 0) ? "O" : "X";
            System.out.println("Turn of " + symbol);
            move = scanner.next();  // Input move
            validateAndAppend(move, symbol);     // Validate for wrong input and filled spots
            board();    // Display board
            if (anyWinner(symbol)) {
                drawCounter = false;
                System.out.println(symbol + " wins!");
                break;
            }
            movesCommitted++;
        } while (movesCommitted <= 9);

        if (drawCounter) {
            System.out.println("Its a draw");
        }

        scanner.close();
    }

    public static void board() {
        System.out.println("    a b c ");
        System.out.println("1 | " + locs[0][0][0] + " " + locs[0][1][0] + " " + locs[0][2][0] + " |");
        System.out.println("2 | " + locs[1][0][0] + " " + locs[1][1][0] + " " + locs[1][2][0] + " |");
        System.out.println("3 | " + locs[2][0][0] + " " + locs[2][1][0] + " " + locs[2][2][0] + " |");
    }

    public static void validateAndAppend(String input, String symbol) {
        Scanner scannerForValidate = new Scanner(System.in);
        int check = 0;  // If there input is there in array key, change to 1
        int ival = -1;  // Final array value for convenience for overwrite check
        int jval = -1;// Final array value for convenience for overwrite check
        do {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (input.equals(locs[i][j][1])) {// Use Arrays method here
                        //  i is for row and j is for column
                        ival = i;
                        jval = j;
                        check++;
                        break;
                    }
                }
    
                if (check == 1) {
                    break;
                }
            }

            if (check == 0) {
                System.out.println("Wrong input! Try again.");
                input = scannerForValidate.next();
            }
        } while (check == 0);

        //  Now we have correct input

        do {
            if (" ".equals(locs[ival][jval][0])) {
                locs[ival][jval][0] = symbol;
                break;
            } else {
                System.out.println("Place taken! Try again.");
                input = scannerForValidate.next();
                continue;
            }
        } while (true);


        scannerForValidate.close();
    }

    public static Boolean anyWinner(String xo) {
        //return " "; //  Delete this later
        for (int i = 0; i <= 2; i++) {
            if (locs[i][0][0] == xo && locs[i][1][0] == xo && locs[i][2][0] == xo) {
                return true;    // This is row check
            }

            if (locs[0][i][0] == xo && locs[1][i][0] == xo && locs[2][i][0] == xo) {
                return true;    // This is column check
            }
        }
        
        if (locs[0][0][0] == xo && locs[1][1][0] == xo && locs[2][2][0] == xo) {
            return true;    // This is "\" diagonal check
        }

        if (locs[0][2][0] == xo && locs[1][1][0] == xo && locs[2][0][0] == xo) {
            return true;    // This is "/" check
        }

        return false;
    }
}