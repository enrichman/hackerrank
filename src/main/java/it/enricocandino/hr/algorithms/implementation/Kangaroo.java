/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 06.
 */
package it.enricocandino.hr.algorithms.implementation;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Scanner;

public class Kangaroo extends Solution {

    public void solve(File file) {
        try {
            Scanner in = new Scanner(file);
            int x1 = in.nextInt();
            int v1 = in.nextInt();
            int x2 = in.nextInt();
            int v2 = in.nextInt();

            if(x1 < x2) {
                int t = x1;
                x1 = x2;
                x2 = t;
                t = v1;
                v1 = v2;
                v2 = t;
            }

            if(x1 > x2 && v1 > v2) {
                System.out.println("NO");
            } else {
                while(x2 < x1) {
                    x1 += v1;
                    x2 += v2;
                }
                if(x1 == x2) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
