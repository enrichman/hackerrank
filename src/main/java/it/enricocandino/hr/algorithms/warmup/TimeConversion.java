/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 06.
 */
package it.enricocandino.hr.algorithms.warmup;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.Scanner;

public class TimeConversion extends Solution {

    public void solve(File file) {
        try {
            Scanner in = new Scanner(file);
            String time = in.next();
            int hour = Integer.valueOf(time.substring(0, 2));
            String amPm = time.substring(8);

            if(amPm.equals("PM")) {
                if(hour < 12)
                    hour += 12;
            } else {
                if(hour == 12)
                    hour = 0;
            }

            String converted = "";
            if(hour < 10) converted += "0";
            converted += hour + time.substring(2, 8);

            System.out.println(converted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
