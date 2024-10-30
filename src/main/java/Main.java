import model.Game;
import model.Player;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(3);
        game.initializeGame();
        Player winner = game.runGame();

        if (winner == null) {
            System.out.println("Its a TIE");
        }
        else {
            System.out.println("Winner is " + winner.getName());
        }
    }
}
