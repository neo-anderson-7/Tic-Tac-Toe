// package tictactoe;
import java.util.*;

public class JetbrainsMove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] coordinates = new String[9];
        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();
        
        coordinates = cells.split("", 0);
        String[][][] matrix = {{{" ", "13"}, {" ", "23"}, {" ", "33"}}, 
                               {{" ", "12"}, {" ", "22"}, {" ", "32"}},
                               {{" ", "11"}, {" ", "21"}, {" ", "31"}}};
            
        int index = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (coordinates[index].equals("_")) {
                    matrix[i][j][0] = " ";
                } else {
                    matrix[i][j][0] = coordinates[index];
                }
                index++;
            }    
        }
        board(matrix);
        // boolean carryOn = true;

        // int count = 0;
        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         count += matrix[i][j].equals("X") ? 1 : matrix[i][j].equals("O") ? -1 : 0;
        //     }    
        // }
        
        // if (!(Math.abs(count) == 1 || Math.abs(count) == 0)) {
        //     System.out.print("Impossible");
        //     carryOn = false;
        // }

        // if (carryOn) {
        //     int xWins = match("X", matrix);
        //     int oWins = match("O", matrix);
        //     //  Add symmetric case later

        //     if (Math.abs(xWins - oWins) == 1 && xWins + oWins == 1) {
        //         String str = xWins == 1 ? "X " : "O ";
        //         System.out.print(str + "wins");
        //     } else if (Math.abs(xWins - oWins) == 2 && xWins + oWins == 2) {
        //         //  This is supposed to handle the symmetric case
        //         String str = xWins == 2 ? "X " : "O ";
        //         System.out.print(str + "wins");
        //     } else if (xWins == 0 && oWins == 0) {
        //         //  check for incomplete or draw
        //         if (cells.contains("_") || cells.contains(" ")) {
        //             System.out.print("Game not finished");
        //         } else {
        //             System.out.print("Draw");
        //         }
        //     } else {
        //         System.out.print("Impossible");
        //     }
        
        boolean cont = true;
        do {
            int dataInput;
            System.out.print("Enter the coordinates: ");
            String inp = scanner.nextLine();
            String input = "0" + inp;
            input = input.replace(" ", "");
            if (Integer.parseInt(input) < 11) {
                System.out.print("You should enter numbers!");
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
                        if (matrix[i][j][0] != " ") {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            matrix[i][j][0] = "X";
                            cont = false;
                        }
                    }
                }
            }
        } while (cont);
        board(matrix);

        scanner.close();    //  Remove this later
    }
    
    public static void board(String[][][] arr) {
        System.out.println("---------");
        System.out.println("| " + arr[0][0][0] + " " + arr[0][1][0] + " " + arr[0][2][0] + " |");
        System.out.println("| " + arr[1][0][0] + " " + arr[1][1][0] + " " + arr[1][2][0] + " |");
        System.out.println("| " + arr[2][0][0] + " " + arr[2][1][0] + " " + arr[2][2][0] + " |");
        System.out.println("---------");
    }

    // public static int match(String xo, String[][] locs) {
    //     int match = 0;

    //     for (int i = 0; i <= 2; i++) {
    //         if (locs[i][0][0].equals(xo) && locs[i][1][0].equals(xo) && locs[i][2][0].equals(xo)) {
    //             match++;    // This is row check
    //         }

    //         if (locs[0][i][0].equals(xo) && locs[1][i][0].equals(xo) && locs[2][i][0].equals(xo)) {
    //             match++;    // This is column check
    //         }
    //     }
        
    //     if (locs[0][0][0].equals(xo) && locs[1][1][0].equals(xo) && locs[2][2][0].equals(xo)) {
    //         match++;    // This is "\" diagonal check
    //     }

    //     if (locs[0][2][0].equals(xo) && locs[1][1][0].equals(xo) && locs[2][0][0].equals(xo)) {
    //         match++;    // This is "/" check
    //     }
        
    //     return match;
    // }
}