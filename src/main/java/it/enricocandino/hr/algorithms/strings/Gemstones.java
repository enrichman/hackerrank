/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Aug,, 31.
 */
package it.enricocandino.hr.algorithms.strings;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Gemstones extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);
        int tests = in.nextInt();

        Set<Character> inAll = new HashSet<Character>();
        String line = in.next();
        for(char c : line.toCharArray()) {
            inAll.add(c);
        }

        for(int i=1; i<tests; i++) {
            line = in.next();
            Set<Character> charset = new HashSet<Character>();
            for(char c : line.toCharArray()) {
                charset.add(c);
            }

            Set<Character> diff = new HashSet<Character>(inAll);
            diff.removeAll(charset);
            inAll.removeAll(diff);

        }

        System.out.println(inAll.size());
    }

}
