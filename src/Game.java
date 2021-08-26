import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Main main = new Main();
    private ArrayList<String> moviesList = new ArrayList<String>();
   private String guessedLetters =  new String() ;
    private String wrongGuessedLetters =  new String() ;

    private Scanner letterScanner = new Scanner(System.in);

    private String pickedMovie;

    private int listSize = 0;
    private int index = 0;
    public int Points = 9;
    private String space = new String();
    public void inputFromFile()
    {

        try{
            File file = new File("src/Movies List");

            Scanner scan = new Scanner(file);
            while(scan.hasNextLine())
            {
                String movie = scan.nextLine();
                this.moviesList.add(movie);
            }

        }catch(Exception e){
            System.out.println("File Not Found!");
        }
        listSize = moviesList.size();


    }

    public void randomNumberGenerator(){

        Random random = new Random();
         index = Math.abs(random.nextInt() % listSize);

    }

    public void randomMoviePickup(){
        pickedMovie = moviesList.get(index);
       
        //System.out.println(movie.charAt(0));
    }

    public void guessTheMovieOutput() {

        System.out.println();
        System.out.print("You are guessing: ");


         space += " ";


        Points = 9;

        for (int i = 0; i < pickedMovie.length(); i++) {

            boolean guessedRight = false;

            for (int j = 0; j < guessedLetters.length(); j++) {

                if (this.pickedMovie.charAt(i) == guessedLetters.charAt(j) ) {
                    guessedRight = true;
                }

            }
            if(this.pickedMovie.charAt(i) == space.charAt(0)) guessedRight = true;


            if (guessedRight) System.out.print(pickedMovie.charAt(i));
            else System.out.print("_");
        }

        for(int j=0 ; j< guessedLetters.length() ; j++) {

            boolean guessedRight = false;

            for (int i = 0; i < pickedMovie.length(); i++) {


                if (pickedMovie.charAt(i) == guessedLetters.charAt(j)) {
                    guessedRight = true;
                }

            }


            if (guessedRight == false)
            {
                Points--;
                wrongGuessedLetters += guessedLetters.charAt(j);
            }
        }

    }



    public void remainingPointsOutput(){

        System.out.println();
        System.out.print("You have guessed (" + guessedLetters.length() + ") ");
        System.out.print("Wrong letters: ");
        for( int i = 0 ; i<wrongGuessedLetters.length() ; i++){

            System.out.print(" " + wrongGuessedLetters.charAt(i));
        }

        wrongGuessedLetters = "";

    }

    public void letterInput(){
        System.out.println();
        System.out.print("Guess a letter: ");
        String guessedLetter = letterScanner.nextLine();
        guessedLetters = guessedLetters + guessedLetter;
    }

    public void winAndLose(){
        space += " ";
        int dash=0;
        for (int i = 0; i < pickedMovie.length(); i++) {

            boolean guessedRight = false;

            for (int j = 0; j < guessedLetters.length(); j++) {

                if (this.pickedMovie.charAt(i) == guessedLetters.charAt(j) ) {
                    guessedRight = true;
                }

            }
            if(this.pickedMovie.charAt(i) == space.charAt(0)) guessedRight = true;




            if(!guessedRight) dash ++;
        }
        if(dash == 0 ) {
            System.out.println();
            System.out.print("You win!");
            System.out.println();
            System.out.print("You have guessed '" + pickedMovie + "' correctly.");
            Points = 0;
        }
        else if(Points == 0){
            System.out.println();
            System.out.print("You lose!");
            System.out.println();
            System.out.print("You have'nt guessed '" + pickedMovie + "' correctly.");
        }


    }


}
