/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 06.
 */
package it.enricocandino.hr.algorithms.warmup;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Scanner;

public class SaveThePrisoner extends Solution {

    public void solve(File file) {
        try {
            Scanner in = new Scanner(file);
            int n = in.nextInt();
            for (int test = 0; test < n; test++) {
                long prisoners = in.nextLong();
                long candies = in.nextLong();
                long starter = in.nextLong();

                candies += (starter - 1);
                long result = (candies % prisoners);
                System.out.println((result == 0) ? prisoners : result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
