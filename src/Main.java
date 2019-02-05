import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public String readFile() {
        String[] nameslist = new String[1000];
        int index = 0;
        int randomNumber = -1;
        File file = new File("C:\\Users\\hp\\IdeaProjects\\GuessTheMovie\\src\\movieslist.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                nameslist[index] = scan.nextLine();
                index++;
            }
            randomNumber = (int)(Math.random()*(index-1));
            scan.close();
        }
        catch (FileNotFoundException exception) {
            System.out.println("File Not FOund !!!");
        }
        return nameslist[randomNumber];
    }

    public void playGame(String movieName) {
        movieName = movieName.replace(" ", "");
        System.out.println(movieName);
        int noOfChances = 10;
        int wrongGuesses = 0;
        StringBuilder uncover = new StringBuilder("");
        int uncoveredBlanks = movieName.length();
        for(int i=0;i<uncoveredBlanks; i++) {
            uncover.append("_");
        }

        while (noOfChances>0) {
            System.out.print("You Are Guessing: ");
            System.out.println(uncover);
            System.out.println("You have guessed (" + wrongGuesses + ") wrong letters" );
            System.out.print("Guess a letter: ");
            Scanner scan = new Scanner(System.in);
            String guess = scan.nextLine();
            while(guess.length()!=1) {
                System.out.println("Please enter one char only !");
                guess = scan.next();
            }
            int index = movieName.indexOf(guess);
            if( index == -1) {
                wrongGuesses++;
                noOfChances--;
            }
            else {
                //uncover = uncover.insert(index,guess);
                while (index != -1) {
                    //n
                    //uncover = uncover.insert(index,guess);
                    uncover.replace(index,index+1,guess);
                    uncoveredBlanks--;
                    index = movieName.indexOf(guess,index+1);
                }
            }
            if(uncover.indexOf("_")==-1) {
                System.out.println("Congrats Winner !!!");
                break;
            }
        }
        if(uncover.indexOf("_") != -1)
            System.out.println("OOPs, Better Luck Next Time :-)");
    }

    public static void main(String[] args) {
        Main m = new Main();
        String movieName = m.readFile();
        m.playGame(movieName);
    }
}
/*
    Split it into classes

 */