package Jatek.Aknakereso;

import Jatek.Kivetel.AknakeresoException;

import java.util.Arrays;

/**
 * @author Herczeg Martinez
 */
public class Jatek {

    private char[][] tabla;
    public char[][] gametable;
    private int mineNumber =0;
    private int notMine = 0;
    private boolean gameOnGoing = false;

    /*
    _____________________________________
    |2024.11.28 Aknakereső játék zhgyak |
    -------------------------------------
    |Meg kell oldani a tippelést        |
    |To string megvan                   |
    |Tárolás megvan                     |
    |Check megvan                       |
    -------------------------------------
    |Programming is hell                |
    -------------------------------------
     */


    /**
     * Constructor
     * checks the table then fills it with the right values replacing the zeros
     * @param tabla the given table which holds the data for the game fields
     */
    public Jatek(char[][] tabla) {
        try {
            if (preCheck(tabla)){
                this.gametable = new char[tabla.length][tabla[0].length];
                this.gameOnGoing=true;
                this.tabla = fillTable(tabla);
            }
        }
        catch (AknakeresoException e){
            System.err.println(e);
        }
    }

    /**
     * Precheck for table validity
     * @param tabla
     * @return boolean that shows if the table is valid for use
     */
    private boolean preCheck(char[][] tabla){
        //tabla.length sorok
        // tabla[0].length oszlopok
        //check if tabla is not null
        if (tabla == null)return false;

        for (int i = 0; i < tabla.length;i++){
            for (int j = 0; i< tabla[0].length;i++){
                if (tabla[i][j] != '0' && tabla[i][j] != 'a') {
                    throw new AknakeresoException("Nem megfelelő karakter találva");
                }
            }
        }
        return true;
    }
    /**
     * Replaces zeros with the corresponding surrounding number of mines
     *
     */
    private char[][] fillTable(char[][] tabla){

        char[][] filled = tabla.clone();
        for (int i = 0; i < tabla.length;i++){
            for (int j = 0; j< tabla[0].length;j++){
                this.gametable[i][j] = '#';
                if (tabla[i][j] == '0'){
                    // rewrite
                    this.notMine++;
                    int mineNum=aroundZero(tabla,i,j);
                    filled[i][j] = (((Integer)mineNum).toString()).charAt(0);
                    //too complicated use aroundZero method instead
                    /*
                    if (i == 0 ){
                        if (tabla[0][j+1] =='a') mineNum++;
                        jb= 1;
                    }
                    else if
                    (i == tabla.length-1) { if (tabla[0][j-1] =='a') mineNum++;
                        jb=-1;
                    }
                    if (j == 0){
                        if (jb==-1){
                            
                        } else if (jb==1) {
                            
                        }
                        else{

                        }
                    }
                    if (j==tabla[0].length){
                        if (jb==-1){

                        } else if (jb==1) {

                        }
                        else{

                        }
                    }
                    */
                } else if (tabla[i][j] == 'a') {
                    this.mineNumber++;
                }
            }
        }
        return filled;
    }

    /**
     * Finds the mines around the given the x,y values
     * @param x
     * @param y
     * @return Number of mines around the x,y
     */
    private int aroundZero(char[][] tabla,int x, int y){
        int sum=0;
        for (int i = -1; i <= 1 ; i++){
            for (int j = -1; j<=1; j++){
                //check if out of bounds
                if(((x+i) >= 0 && (y+j) >= 0 && (x+i) < tabla.length && (y+j) < tabla[0].length)){
                    sum += (tabla[x+i][y+j] == 'a') ? 1 : 0;
                }
            }
        }
        return sum;
    }

    /**
     * Used to make a tip on the table
     * @param x
     * @param y
     * @return The hit field contains mine or not and the number of mines remaining
     */
    public String tipp(int x, int y){
        StringBuilder sb = new StringBuilder();
        x--;y--;
        System.out.println(this.tabla[x][y]);
        sb.append("1 2 3 4");
        switch (this.tabla[x][y])
        {
            // if you tipped a mine, sout
            case 'a': sb.append("Aknát talált!");
                this.gametable[x][y] = 'a';
                this.gameOnGoing= false;break;
            default:
                sb.append("Jó hely!");
                this.gametable[x][y] = this.tabla[x][y];
                this.notMine--; break;
        }
        if (notMine ==0){
            sb.append("Nyert!");
            this.gameOnGoing = false;
        }
        else{
            sb.append("(Találat helye: " + (x++) + " " + (y++) + ")\n");
            sb.append("Aknák száma: "+ this.mineNumber +"\n");
            sb.append("Maradék üres: "+ this.notMine);
        }

        return sb.toString();
    }

    /**
     * Used for the game to show the gametable
     * @return The gametables contents
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var i : this.gametable){
            for ( var j : i){
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Getter for gameOnGoing field
     * @return the games state either it's running or not
     */
    public boolean isGameOnGoing() {
        return gameOnGoing;
    }

    public int getMineNumber() {
        return mineNumber;
    }

    public int getNotMine() {
        return notMine;
    }
}
