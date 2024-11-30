package Jatek.Test;

import Jatek.Aknakereso.Jatek;
import Jatek.Aknakereso.TableGen;

public class Tests {
    public static void main(String[] args) {
        Jatek j = new Jatek(TableGen.generateTable(4,4));
        System.out.println(j.toString());
    }
}
