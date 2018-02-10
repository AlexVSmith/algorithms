package com.kate;

import java.util.ArrayList;

public class Helper {

    public static Integer getRandomIndexFromList(ArrayList<Integer> list) {
        int counter = list.size();
        Double randomDouble = counter * Math.random();
        Integer randomIndex = randomDouble.intValue();
        if (randomIndex == counter) randomIndex = counter - 1;

        /*Debug.print("w", "counter      == " + counter);
        Debug.print("w", "randomDouble == " + randomDouble);
        Debug.print("w", "randomIndex  == " + randomIndex);*/
        
        return randomIndex;
    }
}
