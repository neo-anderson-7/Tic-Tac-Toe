/*

In this stage, you should analyze a Tic-Tac-Toe field. 

Note. In this stage either 'X' or 'O' can start the game.

After printing the field, you need to find the state in which the game is at the moment. Possible states:

    "Game not finished" - when no side has a three in a row but the field has empty cells;
    "Draw" - when no side has a three in a row and the field has no empty cells;
    "X wins" - when the field has three X in a row;
    "O wins" - when the field has three O in a row;
    "Impossible" - when the field has three X in a row as well as three O in a row. Or the field has a lot more X's that O's or vice versa (if the difference is 2 or more, should be 1 or 0).

Also, you can use ' ' or '_' to print empty cells - it's up to you.
Examples

The examples below show outputs for some predefined states. Your program should work in the same way.

Example 1:

Enter cells: XXXOO__O_
---------
| X X X |
| O O _ |
| _ O _ |
---------
X wins

Example 2:

Enter cells: XOXOXOXXO
---------
| X O X |
| O X O |
| X X O |
---------
X wins

Example 3:

Enter cells: XOOOXOXXO
---------
| X O O |
| O X O |
| X X O |
---------
O wins

Example 4:

Enter cells: XOXOOXXXO
---------
| X O X |
| O O X |
| X X O |
---------
Draw

Example 5:

Enter cells: XO_OOX_X_
---------
| X O   |
| O O X |
|   X   |
---------
Game not finished

Example 6:

Enter cells: XO_XO_XOX
---------
| X O _ |
| X O _ |
| X O X |
---------
Impossible

Example 7:

Enter cells: _O_X__X_X
---------
|   O   |
| X     |
| X   X |
---------
Impossible

Example 8:

Enter cells: _OOOO_X_X
---------
|   O O |
| O O   |
| X   X |
---------
Impossible

*/

// package tictactoe;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] coordinates = new String[9];
        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();
        
        coordinates = cells.split("", 0);
        String[][] matrix = new String[3][3];
        int index = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = coordinates[index];
            }    
        }
        
        board(matrix);
        System.out.print(result(matrix, cells));
        scanner.close();
    }
    
    public static void board(String[][] arr) {
        System.out.println("---------");
        System.out.println("| " + arr[0][0] + " " + arr[0][1] + " " + arr[0][2] + " |");
        System.out.println("| " + arr[1][0] + " " + arr[1][1] + " " + arr[1][2] + " |");
        System.out.println("| " + arr[2][0] + " " + arr[2][1] + " " + arr[2][2] + " |");
        System.out.println("---------");
    }
    
    public static String result(String[][] arr, String cells) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count += arr[i][j] == "X" ? 1 : arr[i][j] == "O" ? -1 : 0;
            }    
        }
        
        if (!(count == 1 || count == 0)) {
            return "Impossible";
        }
        
        int xWins = 0;
        int oWins = 0;
        //  Rows and columns check
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == "X" && arr[i][1] == "X" && arr[i][2] == "X") {
                xWins++;
            }
            
            if (arr[0][i] == "X" && arr[1][i] == "X" && arr[2][i] == "X") {
                xWins++;
            }
            
            if (arr[i][0] == "O" && arr[i][1] == "O" && arr[i][2] == "O") {
                oWins++;
            }
            
            if (arr[0][i] == "O" && arr[1][i] == "O" && arr[2][i] == "O") {
                oWins++;
            }
        }
        
        if (xWins == 0 && oWins == 0) {
            
                   
        }

        if (!(xWins == 1 && oWins == 0 || xWins == 0 && oWins == 1)) {
            return "Impossible";
        } else {
            return xWins == 1 ? "X wins" : "O wins";
        }
        
        /*
        | X X X |
        | X O O |
        | X O O |

        | O X O |
        | X X X |
        | O X O |
        
        This does not work in these cases
        */
        
    }
}