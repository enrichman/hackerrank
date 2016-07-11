/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 07.
 */
package it.enricocandino.hr.algorithms.strings;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Scanner;

public class FunnyStrings extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);
        int tests = in.nextInt();

        for(int i=0; i<tests; i++) {
            String line = in.next();
            char[] chars = line.toCharArray();

            String result = "Funny";
            for(int j=0; j<chars.length-1; j++) {
                int val1 = Math.abs(chars[j+1] - chars[j]);
                int val2 = Math.abs(chars[chars.length-j-2] - chars[chars.length-j-1]);
                if(val1 != val2) {
                    result = "Not Funny";
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
