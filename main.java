import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner InputScanner = new Scanner(System.in);
        System.out.println("Enter green (if any) (Use underscores (_) for unknown):"); //_____
        String Greens = InputScanner.nextLine();
        System.out.println("Enter yellows (order doesn't matter):"); //Just input of 0-5 letters
        String Yellows = InputScanner.nextLine();
        while (Greens.length() != 5 || Yellows.length() > 5){
            System.err.println("You entered something incorrectly!");
            System.out.println("Enter green (if any) (Use underscores (_) for unknown):"); //_____
            Greens = InputScanner.nextLine();
            System.out.println("Enter yellows (order doesn't matter):");
            Yellows = InputScanner.nextLine();
        }
        InputScanner.close();
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
        
        File OutputFile = new File("JavaWordleFinder/Output.txt");
        if (OutputFile.createNewFile()){
            System.out.println("\nCreated Output.txt file.");
        }
        else {
            System.out.println("\nUsing existing Output.txt file.");
        }
        FileWriter OutputWriter = new FileWriter(OutputFile);
        System.err.println("The possible Words are:");
        for (String Words : PossibleWords){
            System.out.println(Words);
            OutputWriter.write(Words);
            OutputWriter.write("\n");
        }
        OutputWriter.close();
        System.out.println("This list of words is also saved to Output.txt");

    }
}