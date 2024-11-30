package Jatek.Aknakereso;

import org.junit.Test;

import java.util.ArrayList;

public class uTest {
    @Test
    public void tests() {
        Jatek jatek = new Jatek(TableGen.generateTable(4,4));
        //assert true == jatek.isGameOnGoing();
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("1,1");
        inputs.add("4,4");
        inputs.add("2,2");
        //assert 0 < jatek.getMineNumber();
        assert char[][].class == TableGen.generateTable(3,3).getClass();
    }

}
