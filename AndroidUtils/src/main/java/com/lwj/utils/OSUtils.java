package com.lwj.utils;

import android.os.Build;


/**
 * Created by lwj on 16/6/7.
 * Des:
 */
public class OSUtils {
    /**
     * 8
     * @return 2.2
     */
    public static boolean hasFroyo() {
        return has(Build.VERSION_CODES.FROYO);
    }

    /**
     * 9
     * @return 2.3
     */
    public static boolean hasGingerbread() {
        return has(Build.VERSION_CODES.GINGERBREAD);
    }

    /**
     * 11
     * @return 3.0
     */
    public static boolean hasHoneycomb() {
        return has(Build.VERSION_CODES.HONEYCOMB);
    }

    /**
     * api 14
     *
     * @return 4.0
     */
    public static boolean hasIceCreamSandwich() {
        return has(Build.VERSION_CODES.ICE_CREAM_SANDWICH);
    }


    /**
     * api 16
     *
     * @return 4.2
     */
    public static boolean hasJellyBean() {
        return has(Build.VERSION_CODES.JELLY_BEAN);
    }


    /**
     * api 17
     *
     * @return 4.3
     */
    public static boolean hasJELLY_BEAN_MR1() {
        return has(Build.VERSION_CODES.JELLY_BEAN_MR1);
    }

    /**
     * api 18
     *
     * @return 4.4
     */
    public static boolean hasJELLY_BEAN_MR2() {
        return has(Build.VERSION_CODES.JELLY_BEAN_MR2);
    }

    /**
     * api 19
     *
     * @return 4.4
     */
    public static boolean hasKitKat() {
        return has(Build.VERSION_CODES.KITKAT);
    }

    /**
     * api 21
     *
     * @return 5.0
     */
    public static boolean hasLollipop() {
        return has(Build.VERSION_CODES.LOLLIPOP);
    }


    /**
     * api 22
     *
     * @return 5.1
     */
    public static boolean hasLollipop_MR1() {
        return has(Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    /**
     * api 23
     *
     * @return 6.0
     */
    public static boolean hasM() {
        return has(Build.VERSION_CODES.M);
    }

    /**
     * api 24
     *
     * @return 7.0
     */
    public static boolean hasN() {
        return has(Build.VERSION_CODES.N);
    }

    /**
     * api 25
     *
     * @return 7.1.1
     */
    public static boolean hasN_MR1() {
        return has(Build.VERSION_CODES.N_MR1);
    }

    /**
     * The user-visible SDK version of the framework); its possible
     * values are defined in {@link Build.VERSION_CODES}.
     */
    public static boolean has(int versionCode) {
        return Build.VERSION.SDK_INT >= versionCode;
    }
}
