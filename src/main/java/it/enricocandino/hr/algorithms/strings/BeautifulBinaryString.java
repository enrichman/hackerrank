/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Aug,, 03.
 */
package it.enricocandino.hr.algorithms.strings;

import it.enricocandino.hr.Solution;
import it.enricocandino.hr.algorithms.graphtheory.EvenTree;

import java.io.File;
import java.util.Scanner;

public class BeautifulBinaryString extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);

        int n = in.nextInt();
        String B = in.next();

        int count = 0;
        char[] chars = B.toCharArray();
        for(int i=0; i<n-2; i++) {
            if(chars[i] == '0' && chars[i+1] == '1' && chars[i+2] == '0') {
                chars[i+2] = '1';
                count++;
            }
        }

        System.out.println(count);
    }
}
