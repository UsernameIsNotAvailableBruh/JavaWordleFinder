import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner InputScanner = new Scanner(System.in);
        System.out.println("Enter green (if any) (Use special characters for unknown):"); //input of 5 characters
        String Greens = InputScanner.nextLine();
        System.out.println("Enter yellows (order matters, use special characters):"); //input of 5 characters
        String Yellows = InputScanner.nextLine();
        System.out.println("Enter grays (order doesn't matter, no need for specials):"); //input of 1 or more characters
        String Grays = InputScanner.nextLine();
        Boolean NoGreens = Greens.length() == 0;
        Boolean NoYellows = Yellows.length() == 0;
        while ((Greens.length() != 5 && !NoGreens) || (Yellows.length() != 5 && !NoYellows)){ //not 5 and not 0
            System.err.println("You entered something incorrectly!");
            System.out.println("Enter green (if any) (Use special characters for unknown):");
            Greens = InputScanner.nextLine();
            System.out.println("Enter yellows (order matters, use special characters):");
            Yellows = InputScanner.nextLine();
            System.out.println("Enter grays (order doesn't matter, no need for specials):");
            Grays = InputScanner.nextLine();
        }
        InputScanner.close();
        Yellows = Yellows.toLowerCase();
        Greens = Greens.toLowerCase();
        Grays = Grays.toLowerCase();
        if (NoGreens) Greens = "-----";
        if (NoYellows) Yellows = "-----";
        //Create WordList from WordList.txt:
        Scanner WordListScanner = new Scanner(new File("WordList.txt"));
        ArrayList<String> WordList = new ArrayList<String>();
        while (WordListScanner.hasNext()){
            WordList.add(WordListScanner.next());
        }
        WordListScanner.close();
        ArrayList<String> PossibleWords = new ArrayList<String>(WordList);
        //code for greens:
        for (String Word : WordList) {//nested for loops
            Word = Word.toLowerCase(); //Word should already be lowercase, but just in case
            for (int i=0; i<5; i++) {//i<5 because Greens should be length of 5
                if (IsNonLetter(Greens.charAt(i))){ //if greens[i] is not a letter
                    continue;
                }
                if (Greens.charAt(i) != Word.charAt(i)){ //not same letter
                    PossibleWords.remove(Word);
                }
            }
        }
        //code for yellows:
        for (String Word : new ArrayList<String>(PossibleWords)) {
            for (int i=0; i<Yellows.length(); i++) {
                if (IsNonLetter(Yellows.charAt(i))){ //if yellows[i] is not a letter
                    continue;
                }
                else if (Word.indexOf(Yellows.charAt(i)) == -1 || Yellows.charAt(i) == Word.charAt(i)){ //(yellow[i] is only letters) - If Word doesnt have yellow[i] OR yellows
                    PossibleWords.remove(Word);
                }
                else if (CharCount(Word, Yellows.charAt(i)) <  CharCount(Yellows, Yellows.charAt(i))){ // dounble (or more) and word has less than yellows
                    PossibleWords.remove(Word);
                }
            }
        }
        //for doubles (or more)
        //code for grays:
        for (String Word : new ArrayList<String>(PossibleWords)){
            for (int x=0; x<Grays.length(); x++){
                for (int y=0; y<Word.length(); y++){
                    if (Grays.charAt(x) == Word.charAt(y)){
                        PossibleWords.remove(Word);
                    }
                }
            }
        }
        File OutputFile = new File("Output.txt");
        if (OutputFile.createNewFile()){
            System.out.println("\nCreated Output.txt file.");
        }
        else {
            System.out.println("\nUsing existing Output.txt file.");
        }
        FileWriter OutputWriter = new FileWriter(OutputFile);
        System.out.println("The possible Words are:");
        for (String Words : PossibleWords){
            System.out.println(Words);
            OutputWriter.write(Words);
            OutputWriter.write("\n");
        }
        OutputWriter.close();
        System.out.println("This list of words is also saved to Output.txt");
    }
    public static boolean IsNonLetter(char character){
        String NonLetters = "~`!@#$%^&*()_+-={}|[]\\;':\"<>?,./";
        for (int i=0;i<NonLetters.length();i++){
            if (NonLetters.charAt(i) == character){
                return true;
            }
        }
        return false;
    }

    public static int CharCount(String string, char character) {
        int count = 0;
        for (int i=0;i<string.length();i++){
            if (string.charAt(i) == character) count++;
        }
        return count;
    }
}    