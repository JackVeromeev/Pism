package com.rudko.pism.common;

/**
 * Created by jack on 14/03/17.
 */
public class Constants {

    public static boolean inRelease;
    public static String globalPath;

    static {

        inRelease = false;

        if(inRelease) globalPath = "Pism/";
        else globalPath = "";
    }
}
