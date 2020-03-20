import java.util.Scanner;

public class Index {
public static String[][][] locs = {{{" ", "a1"}, {" ", "b1"}, {" ", "c1"}}, 
                                   {{" ", "a2"}, {" ", "b2"}, {" ", "c2"}},
                                   {{" ", "a3"}, {" ", "b3"}, {" ", "c3"}}};
public static int movesCommitted = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Instructions
        System.out.println("Welcome to 2v2 Tic Tac Toe!");
        System.out.println("Enter coordinates as [letter][number] pairs.\nHave fun Ara Ara!");
        boolean drawCounter = true;     // Determines a tie or not
        board();    // Board initialize
        
        do {
            String symbol = (movesCommitted % 2 == 0) ? "O" : "X";
            System.out.println("Turn of " + symbol);
            String move = scanner.next();  // Input move
            validateAndAppend(move, symbol, scanner);     // Validate for wrong input and filled spots
            board();    // Display board
            movesCommitted++;
            if (anyWinner(symbol)) {
                drawCounter = false;
                System.out.println(symbol + " wins!");
                break;
            }
            
        } while (movesCommitted < 9);

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

    public static void validateAndAppend(String input, String symbol, Scanner scanner) {
        int check = 0;  // If there input is there in array key, change to 1
        int ival = -1;  // Final array value for convenience for overwrite check
        int jval = -1;  // Final array value for convenience for overwrite check
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
                input = scanner.next();
            } else {
                //  Since this block has come, we have correct input

                if (" ".equals(locs[ival][jval][0])) {
                    locs[ival][jval][0] = symbol;
                } else {
                    System.out.println("Place taken! Try again.");
                    input = scanner.next();
                    // Since we have a new input, we have to check again for incorrect input
                    check--;
                }
            }
        } while (check == 0);
    }

    public static Boolean anyWinner(String xo) {
        if (movesCommitted < 5) {
            return false;
        }

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