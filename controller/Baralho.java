package controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baralho extends Comunicado {
    public final Integer[] cartas;
    public Baralho(Integer[] cartas) {
        this.cartas = cartas;
    }
    public Baralho()
    {
        cartas = new Integer[] {
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9
        };

        List<Integer> intList = Arrays.asList(cartas);

        Collections.shuffle(intList);

        intList.toArray(cartas);
    }
}
