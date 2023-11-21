import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    //Our size will always be set to a 3 by 3 board
    private int boardSize =3;
    private int winNumX = 0;
    private int winNumO = 0;
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        resetBoard();
    }


    public void resetBoard() {
        for (int i=0; i<boardSize; i++){
            for (int j=0; j<boardSize; j++){
                board[i][j] = '-';
            }
        }
    }


    public void displayBoard() {
        for (int i=0; i<boardSize; i++){
            for (int j=0; j<boardSize; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col) {
        if (row<boardSize && col<boardSize && row>=0 && col>=0){
            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin() {
        // Check rows
        int sum = 0;
        //loop is to check if a row is filled with the same character
        for (int i=0; i<boardSize; i++) {
            sum = 0;
            for (int j=0; j<boardSize; j++){
                if(board[j][i]==currentPlayer){
                    sum++;
                }
                if(sum==3){
                //if there is 3 characters of the same type, they win and a one is added to their wins
                    if(currentPlayer=='X'){
                        winNumX++;
                    } else if(currentPlayer=='O'){
                        winNumO++;
                    }
                    return true;
                }
            }
        }
        // Check columns
        //loop is to check if a column is filled with the same character
        for (int i=0; i<boardSize; i++) {
            sum = 0;
            for (int j=0; j<boardSize; j++){
                if(board[i][j]==currentPlayer){
                    sum++;
                }
                if(sum==3){
                    if(currentPlayer=='X'){
                        winNumX++;
                    } else if(currentPlayer=='O'){
                        winNumO++;
                    }
                    return true;
                }
            }
        }
        // Check diagonals
        sum = 0;
        //same as previous, but diagonally
        for (int i=0; i<boardSize; i++) {
                if(board[i][i]==currentPlayer){
                    sum++;
                } 
                if(sum==3){
                    if(currentPlayer=='X'){
                        winNumX++;
                    } else if(currentPlayer=='O'){
                        winNumO++;
                    }
                    return true;
                }   
        }
        sum = 0;
        for (int i=0; i<boardSize; i++) {
                if(board[boardSize-1-i][i]==currentPlayer){
                    sum++;
                } 
                if(sum==3){
                    if(currentPlayer=='X'){
                        winNumX++;
                    } else if(currentPlayer=='O'){
                        winNumO++;
                    }
                    return true;
                }   
        }
        // No win found
        return false;
    }    
    public void changePlayer() {
        if (currentPlayer=='X'){
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public boolean isBoardFull() {
        // loop check if there are any '-' characters left
        for (int i=0; i<boardSize; i++){
            for (int j=0; j<boardSize; j++){
                if(board[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }
    public void winCount(){
        System.out.println("X wins: "+ winNumX);
        System.out.println("O wins: "+ winNumO);
    }

    public char getCurrentPlayer() {
        return this.currentPlayer; ///Please change, x is here as a placeholder
    }
}

