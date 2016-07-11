/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 11.
 */
package it.enricocandino.hr.algorithms.greedy;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MaxMin extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] list = new int[N];

        for(int i = 0; i < N; i ++)
            list[i] = in.nextInt();

        int unfairness = Integer.MAX_VALUE;

        Arrays.sort(list);

        // initialization
        int[] nums = new int[K];
        for(int i=0; i<K; i++) {
            nums[i] = list[i];
        }
        unfairness = getUnfairness(nums);

        // get next K nums
        int[] next = new int[K];
        for(int i=1; i<N-K+1; i++) {
            for(int j=0; j<K; j++) {
                next[j] = list[i+j];
            }

            int unfairness1 = getUnfairness(next);

            if(unfairness1 < unfairness) {
                nums = next;
                unfairness = getUnfairness(nums);
            }
        }

        System.out.println(unfairness);
    }

    private int getUnfairness(int[] nums) {
        return nums[nums.length-1] - nums[0];
    }
}
