
import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        Game game = new Game();
        game.inputFromFile();
        game.randomNumberGenerator();
        game.randomMoviePickup();

        while(game.Points != 0)
        {
            game.guessTheMovieOutput();
            game.wrongGuessedLetterssOutput();
            game.letterInput();
            game.winAndLose();
        }
    }


}
