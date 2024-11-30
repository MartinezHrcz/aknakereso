package Jatek.Runner;

import Jatek.Aknakereso.Jatek;
import Jatek.Aknakereso.TableGen;

import java.util.Scanner;

/**
 * @author Herczeg Martinez
 * @version 1.0
 */
public class Runner {

    /**
     * Just starts the gamse
     * @param args
     */


    /*
    |----------------|
    |TO DO           |
    |-game runner    |
    |-and tests!     |
    |----------------|
     */
    private static boolean wantToPlay = true;

    public static void main(String[] args) {

        do{
            GameRunner();
        }
        while (wantToPlay == true);
    }
    private static void GameRunner(){
        System.out.println("|Aknakereső játék|");
        System.out.println("Kilépés: X");
        System.out.println("Tippelés: x,y");
        System.out.println("------------------------");
        System.out.println("1.Kilépés");
        System.out.println("2.Saját input");
        Scanner s = new Scanner(System.in);
        String input ="";
        input = s.next();
        input.trim();
        switch (input)
        {
            case "1":
                System.out.println("Exiting!"); wantToPlay =false; break;
            case "2": Game(); break;
        }
    }
    /**
     * The game runner
     * Gets an input from the Standard input, checks it for validity and sends it to the tipp method of Jatek class
     */
    private static void Game(){
        Jatek jatek = new Jatek(TableGen.generateTable(5,5));
        String input;

        Scanner s = new Scanner(System.in);
        System.out.println(jatek.toString());
        do {
            input = s.next();
            if (validityCheck(input)) {
                int x = Integer.parseInt(input.split(",")[0]);
                int y = Integer.parseInt(input.split(",")[1]);
                System.out.println(jatek.tipp(x,y));
                System.out.println(jatek.toString());
            }
        }
        while (input.trim() != "X" && jatek.isGameOnGoing());
        {
            System.out.println("Játék vége!");
        }
    }

    /**
     * Checks if the given input is valid for use
     * @param input Players input of x,y
     * @return If an input is valid or not
     */
    private static boolean validityCheck(String input){
        String[] check = input.split(",");
        if(check.length <= 1 || check.length > 2){
            System.out.println("Invalid");
            return false;
        }
        if(check[0].trim() == "" || check[1].trim()==""){
            System.out.println("Invalid");
            return false;

        }
        return true;
    }
}
