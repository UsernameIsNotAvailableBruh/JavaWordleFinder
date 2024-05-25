import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

class Main{
    public static void main(String[] args) {
        Scanner InputScanner = new Scanner(System.in);
        System.out.println("Enter green (if any) (Use underscores (_) for unknown):\n"); //_____
        String Greens = InputScanner.nextLine();
        System.out.println("Enter yellows (order doesn't matter):\n"); //Just input of 0-5 letters
        String Yellows = InputScanner.nextLine();
        InputScanner.close();
        if (Greens.length() != 5 || Yellows.length() > 5){
            
        }
    }
}