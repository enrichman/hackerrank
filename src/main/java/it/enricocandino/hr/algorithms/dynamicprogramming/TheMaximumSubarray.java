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

            List<Integer> merged = new ArrayList<Integer>();

            Integer curr;
            for(int i=0; i<arr.length; i++) {

                // init
                if(merged.isEmpty()) {
                    merged.add(arr[i]);
                    continue;
                }

                // get last
                curr = merged.get(merged.size()-1);

                if(arr[i] > 0 && curr > 0) {
                    curr += arr[i];
                    merged.set(merged.size()-1, curr);
                } else {
                    merged.add(arr[i]);
                }
            }

            int posMax = 0;
            int max = 0;

            for(int i=0; i<merged.size()-1; i++) {
                Integer prev = merged.get(i);
                int currMax = prev;

                if(prev < 0) {
                    continue;
                } else {
                    posMax += prev;
                }

                for(int j=i+1; j<merged.size(); j++) {
                    Integer next = merged.get(j);
                    if(currMax > max) {
                        max = currMax;
                    }
                    currMax += next;
                }
            }

            for(Integer i : merged) {
                if(i > posMax && i > max)
                    max = posMax = i;
            }
            System.out.println(max+" "+posMax);
        }
    }

}
