/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 05.
 */
package it.enricocandino.hr;

import it.enricocandino.hr.algorithms.dynamicprogramming.TheMaximumSubarray;
import it.enricocandino.hr.algorithms.graphtheory.EvenTree;
import it.enricocandino.hr.algorithms.graphtheory.SnakesAndLadders;
import it.enricocandino.hr.algorithms.greedy.MaxMin;
import it.enricocandino.hr.algorithms.sorting.InsertionSort;
import it.enricocandino.hr.algorithms.strings.AlternatingCharacters;
import it.enricocandino.hr.algorithms.strings.BeautifulBinaryString;
import it.enricocandino.hr.algorithms.strings.TheLoveLetterMystery;

public class Main {

    public static void main(String[] args) {
        Solution sol = new EvenTree();
        sol.solve();
    }

}
