/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Aug,, 04.
 */
package it.enricocandino.hr.algorithms.bitmanipulation;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Scanner;

public class LonelyInteger extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        System.out.println(lonelyInteger(a));
    }

    private static int lonelyInteger(int[] values) {
        int bitmask = 0;
        for (int v : values) {
            bitmask ^= v;
        }
        return bitmask;
    }
}
