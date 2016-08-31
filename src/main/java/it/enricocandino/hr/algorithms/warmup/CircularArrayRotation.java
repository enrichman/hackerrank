/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Aug,, 30.
 */
package it.enricocandino.hr.algorithms.warmup;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Scanner;

public class CircularArrayRotation extends Solution {

    public void solve(File file) throws Exception {
        try {
            Scanner in = new Scanner(file);

            int n = in.nextInt();
            int k = in.nextInt() % n;
            int q = in.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            for(int i=0; i<q; i++) {
                System.out.println(arr[(i+n-k) % n]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
