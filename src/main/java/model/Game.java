package model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    GameBoard board;
    private Scanner scan = new Scanner(System.in);

    public Game(int n) {
        players = new ArrayDeque<>();
        board = new GameBoard(n);
    }

    public void initializeGame() {
        Player player1 = new Player("Ram", new PieceX());
        Player player2 = new Player("Sam", new PieceO());

        players.offerLast(player1);
        players.offerLast(player2);
    }

    public Player runGame() {
        boolean isTie = false;
        System.out.println("Game Starts");
        board.display();
        while(!isTie) {
            Player currentPlayer = players.pollFirst();

            if(!board.hasSpace()) {
                isTie = true;
                continue;
            }

            System.out.println(currentPlayer.getName() + " please enter position: ");
            int i = scan.nextInt();
            int j = scan.nextInt();

            if(!board.assignPiece(currentPlayer.getPiece(), i, j)) {
                System.out.println("Position already occupied!");
                players.offerFirst(currentPlayer);
                continue;
            }

            board.display();
            players.offerLast(currentPlayer);

            if(board.hasWinningPosition(i, j)) {
                return currentPlayer;
            }

        }
        return null;
    }


}



