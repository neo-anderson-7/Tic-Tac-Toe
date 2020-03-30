// package tictactoe;
import java.util.*;

public class Index {
    public static int movesCommitted = 0;
    static String[][][] matrix = {{{" ", "13"}, {" ", "23"}, {" ", "33"}}, 
                                  {{" ", "12"}, {" ", "22"}, {" ", "32"}},
                                  {{" ", "11"}, {" ", "21"}, {" ", "31"}}};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean drawCounter = true;
        board(matrix);
        do {
            String symbol = (movesCommitted % 2 == 0) ? "X" : "O";
            validateAndAppend(symbol, scanner);     // Validate for wrong input and filled spots
            board(matrix);    // Display board
            movesCommitted++;
            if (anyWinner(symbol)) {
                drawCounter = false;
                System.out.println(symbol + " wins");
                break;
            }
            
        } while (movesCommitted < 9);

        if (drawCounter) {
            System.out.println("Its a draw");
        }

        scanner.close();    //  Delete this for submission
    }
    
    public static void board(String[][][] arr) {
        System.out.println("---------");
        System.out.println("| " + arr[0][0][0] + " " + arr[0][1][0] + " " + arr[0][2][0] + " |");
        System.out.println("| " + arr[1][0][0] + " " + arr[1][1][0] + " " + arr[1][2][0] + " |");
        System.out.println("| " + arr[2][0][0] + " " + arr[2][1][0] + " " + arr[2][2][0] + " |");
        System.out.println("---------");
    }
    
    public static void validateAndAppend(String symbol, Scanner scanner) {
        boolean cont = true;
        do {
            System.out.print("Enter coordinates: ");
            String inp = scanner.nextLine();  // Input move
            int dataInput;
            String input = "0" + inp;
            input = input.replace(" ", "");
            if (Integer.parseInt(input) < 11) {
                System.out.println("You should enter numbers!");
                continue;
            } else {
                dataInput = Integer.parseInt(input);
            }
            
            int unit = dataInput % 10;
            int tens = dataInput / 10;
            
            if (unit < 1 || unit > 3 || tens < 1 || tens > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j][1].toString().equals(String.valueOf(dataInput))) {
                        if (matrix[i][j][0] != " " && matrix[i][j][0] != "_") {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            matrix[i][j][0] = symbol;
                            cont = false;
                        }
                    }
                }
            }
        } while (cont);
    }

    public static Boolean anyWinner(String xo) {
        if (movesCommitted < 5) {
            return false;
        }

        for (int i = 0; i <= 2; i++) {
            if (matrix[i][0][0] == xo && matrix[i][1][0] == xo && matrix[i][2][0] == xo) {
                return true;    // This is row check
            }

            if (matrix[0][i][0] == xo && matrix[1][i][0] == xo && matrix[2][i][0] == xo) {
                return true;    // This is column check
            }
        }
        
        if (matrix[0][0][0] == xo && matrix[1][1][0] == xo && matrix[2][2][0] == xo) {
            return true;    // This is "\" diagonal check
        }

        if (matrix[0][2][0] == xo && matrix[1][1][0] == xo && matrix[2][0][0] == xo) {
            return true;    // This is "/" check
        }

        return false;
    }
}