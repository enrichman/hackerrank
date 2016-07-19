/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 07.
 */
package it.enricocandino.hr.algorithms.strings;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Scanner;

public class AlternatingCharacters extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);
        int tests = in.nextInt();

        for(int i=0; i<tests; i++) {
            String line = in.next();
            char[] chars = line.toCharArray();

            char prev = 0;
            char curr = 0;
            int deletion = 0;

            for(int c=0; c<chars.length-1; c++) {
                prev = chars[c];
                curr = chars[c+1];

                if(prev == curr) {
                    deletion++;
                }
            }

            System.out.println(deletion);
        }
    }
}
