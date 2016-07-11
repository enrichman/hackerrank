/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 06.
 */
package it.enricocandino.hr;

import java.io.File;
import java.net.URL;

public abstract class Solution {

    private File[] tests;
    private File[] solutions;

    public Solution() {
        String pkgName = this.getClass().getPackage().getName();
        String folder = pkgName.replace("it.enricocandino.hr", "").replace(".", "/");
        folder += "/" + this.getClass().getSimpleName().toLowerCase();

        URL resource = this.getClass().getClassLoader().getResource("input"+folder);
        if(resource != null) {
            File dir = new File(resource.getFile());
            tests = dir.listFiles();
        }

        resource = this.getClass().getClassLoader().getResource("output"+folder);
        if(resource != null) {
            File dir = new File(resource.getFile());
            solutions = dir.listFiles();
        }
    }

    public void solve() {
        if(tests != null) {
            for(File f : tests) {
                try {
                    solve(f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public abstract void solve(File file) throws Exception ;
}
