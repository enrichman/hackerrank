/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 20.
 */
package it.enricocandino.hr.algorithms.dynamicprogramming;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheMaximumSubarray extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);

        int testCases = in.nextInt();
        for(int t=0; t<testCases; t++) {

            int[] arr = new int[in.nextInt()];
            for(int i=0; i<arr.length; i++) {
                arr[i] = in.nextInt();
            }

            // Kadane's algorithm

            int max = arr[0];
            int globalMax = arr[0];
            int currMax = arr[0];

            for(int i=1; i<arr.length; i++) {
                if(max < 0) {
                    if(arr[i] > max) {
                        max = arr[i];
                    } else if(arr[i] > 0) {
                        max = arr[i];
                    }
                } else if (arr[i] > 0) {
                    max += arr[i];
                }

                currMax = Math.max(arr[i], currMax+arr[i]);
                if(currMax > globalMax)
                    globalMax = currMax;
            }

            System.out.println(globalMax+" "+max);
        }
    }
}
