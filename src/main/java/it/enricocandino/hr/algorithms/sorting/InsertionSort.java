/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 12.
 */
package it.enricocandino.hr.algorithms.sorting;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Scanner;

public class InsertionSort extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }

    public static void insertIntoSorted(int[] ar) {
        int unsorted = Integer.MAX_VALUE;
        int stepIndex = 0;

        for(int i=0; i<ar.length-1; i++) {
            unsorted = ar[i+1];
            if(unsorted < ar[i]) {
                stepIndex = i;
                break;
            }
        }

        for(int i=stepIndex; i>=0; i--) {
            ar[i+1] = ar[i];
            printArray(ar);

            if(i==0 || ar[i-1] < unsorted) {
                ar[i] = unsorted;
                printArray(ar);
                break;
            }
        }
    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

}
