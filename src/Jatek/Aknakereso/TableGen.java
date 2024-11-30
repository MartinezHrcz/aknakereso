package Jatek.Aknakereso;

import java.util.Random;

public class TableGen {

    private static final char[] USED_CHARS = {'a','0'};

    public static char[][] generateTable(int x, int y){
        char[][] generated = new char[x][y];
        Random r = new Random();
        for (int i =0; i < x; i++){
            for (int j =0; j < y; j++){
                generated[i][j] = USED_CHARS[r.nextInt(0,2)];
            }
        }
        return generated;
    }
}
