/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 08.
 */
package it.enricocandino.hr.algorithms.strings;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Scanner;

public class TheLoveLetterMystery extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);

        int testCases = in.nextInt();
        for(int i=0; i<testCases; i++) {
            String line = in.next();

            int steps = 0;
            char[] arr = line.toCharArray();
            int middle = arr.length/2;

            for(int a=0; a<middle; a++) {
                char c1 = arr[a];
                char c2 = arr[arr.length-a-1];

                while(c1<c2) {
                    c2--;
                    steps++;
                }
                while(c2<c1) {
                    c1--;
                    steps++;
                }
            }

            System.out.println(steps);
        }
    }
}
