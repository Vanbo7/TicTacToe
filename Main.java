import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean anotherRound = true;
        TicTacToe game = new TicTacToe();

        System.out.println("Welcome to TicTacToe!");
        System.out.println("First of all, who is going to be X?");
        String xName = scanner.next();
        System.out.println("Who is going to be O?");
        String oName = scanner.next();
        System.out.println("To play, please input the coordinate where you would like you next move.");
        System.out.println("There are three rows and three columns. The first row is 0 and the last is 2. The same goes for the columns");
        game.displayBoard();
        System.out.println("You can make a move on any of these spaces");
        System.out.println("Ready to play?");

        while(anotherRound) {
            //to make a move
            boolean win = false;
            while (!game.isBoardFull() && !win){
                System.out.println("It's "+ game.getCurrentPlayer() +" turn!");
                System.out.println("First, the row");
                int row = scanner.nextInt();
                System.out.println("Now, the column");
                int col = scanner.nextInt();
                while (!game.makeMove(row,col)){
                    System.out.println("Invalid input, please try again (remember to use coordinates from 0 to 2)");
                    System.out.println("First, the row");
                    row = scanner.nextInt();
                    System.out.println("Now, the column");
                    col = scanner.nextInt();
                } 
                game.makeMove(row, col);
                game.displayBoard();
                win = game.checkWin();
                if (!win){
                    game.changePlayer();
                }   
            }
            if (win){
                if (game.getCurrentPlayer()=='X') {
                System.out.println("\nCongratulations "+ xName + " you won!\n");
                } else if (game.getCurrentPlayer()=='O'){
                System.out.println("\nCongratulations "+ oName + " you won!\n");
                }
            } else if (game.isBoardFull()){
                System.out.println("\nIts a tie!\n");
            }
            game.winCount();
            System.out.println("Would you like to play anotherRound? (Enter true or false)");
            anotherRound = scanner.nextBoolean();
            game.resetBoard();
        }
        System.out.println("Thanks for playing!");
    }
}
