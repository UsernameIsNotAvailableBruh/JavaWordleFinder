import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws FileNotFoundException {
        /*
        Scanner InputScanner = new Scanner(System.in);
        System.out.println("Enter green (if any) (Use underscores (_) for unknown):\n"); //_____
        String Greens = InputScanner.nextLine();
        System.out.println("Enter yellows (order doesn't matter):\n"); //Just input of 0-5 letters
        String Yellows = InputScanner.nextLine();
        while (Greens.length() != 5 || Yellows.length() > 5){
            System.err.println("You entered something incorrectly!");
            System.out.println("Enter green (if any) (Use underscores (_) for unknown):\n"); //_____
            Greens = InputScanner.nextLine();
            System.out.println("Enter yellows (order doesn't matter):\n");
            Yellows = InputScanner.nextLine();
        }
        InputScanner.close();
        */
        String Yellows = "a";
        String Greens = "y____";
        Yellows = Yellows.toLowerCase();
        Greens = Greens.toLowerCase();
        //Create WordList from WordList.txt
        Scanner WordListScanner = new Scanner(new File("JavaWordleFinder/WordList.txt"));
        ArrayList<String> WordList = new ArrayList<String>();
        while (WordListScanner.hasNext()){
            WordList.add(WordListScanner.next());
        }
        WordListScanner.close();
        ArrayList<String> PossibleWords = new ArrayList<String>(WordList);
        //code for greens:
        for (String Word : WordList) {//nested for loops
            Word = Word.toLowerCase();
            for (int i=0; i<5; i++) {//1<5 because Greens should be length of 5
                if (Greens.charAt(i) != Word.charAt(i) && Greens.charAt(i) != '_'){
                    PossibleWords.remove(Word);
                }
            }
        }
        //code for yellows
        for (String Word : new ArrayList<String>(PossibleWords)) {//nested for loops
            for (int i=0; i<Yellows.length(); i++) {
                if (Word.indexOf(Yellows.charAt(i)) == -1){
                    PossibleWords.remove(Word);
                }
            }
        }
        System.out.println(PossibleWords);
    }
}