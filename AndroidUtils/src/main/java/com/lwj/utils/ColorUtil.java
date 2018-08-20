package com.lwj.utils;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;

import java.util.ArrayList;

/**
 * Created by lwj on 2018/7/5.
 * lwjfork@gmail.com
 */

public final class ColorUtil {

    @ColorInt
    public static int praseColor(String color) {
        return Color.parseColor(color);
    }

    /**
     * 从colors.xml中读取color
     *
     * @param resId color id
     * @return color
     */
    @ColorInt
    public static int getColor(@ColorRes int resId) {
        return ResUtil.getColor(resId);
    }


    /**
     * @param r red
     * @param g green
     * @param b blue
     * @return
     */
    @ColorInt
    public static int rgb(@IntRange(from = 0, to = 255) int r, @IntRange(from = 0, to = 255) int g, @IntRange(from = 0, to = 255) int b) {
        return Color.rgb(r, g, b);
    }


    /**
     * @param a alpha
     * @param r red
     * @param g green
     * @param b blue
     * @return
     */
    @ColorInt
    public static int argb(@IntRange(from = 0, to = 255) int a, @IntRange(from = 0, to = 255) int r, @IntRange(from = 0, to = 255) int g, @IntRange(from = 0, to = 255) int b) {
        return Color.argb(a, r, g, b);
    }


    /**
     * @param r red
     * @param g green
     * @param b blue
     * @return
     */
    @ColorInt
    public static int rgb(@FloatRange(from = 0.0, to = 1.0) float r, @FloatRange(from = 0.0, to = 1.0) float g, @FloatRange(from = 0.0, to = 1.0) float b) {
        if (OSUtils.hasO_26()) {
            return Color.rgb(r, g, b);
        }
        return 0xff000000 |
                ((int) (r * 255.0f + 0.5f) << 16) |
                ((int) (g * 255.0f + 0.5f) << 8) |
                (int) (b * 255.0f + 0.5f);
    }

    /**
     * @param a alpha
     * @param r red
     * @param g green
     * @param b blue
     * @return
     */
    @ColorInt
    public static int argb(@FloatRange(from = 0.0, to = 1.0) float a, @FloatRange(from = 0.0, to = 1.0) float r, @FloatRange(from = 0.0, to = 1.0) float g, @FloatRange(from = 0.0, to = 1.0) float b) {
        if (OSUtils.hasO_26()) {
            return Color.argb(a, r, g, b);
        }
        return ((int) (a * 255.0f + 0.5f) << 24) |
                ((int) (r * 255.0f + 0.5f) << 16) |
                ((int) (g * 255.0f + 0.5f) << 8) |
                (int) (b * 255.0f + 0.5f);
    }

    /**
     * 透明度和颜色合成另外一种颜色
     *
     * @param a     透明度
     * @param color 颜色值
     * @return 合成颜色值
     */
    @ColorInt
    public static int argb(@FloatRange(from = 0.0f, to = 1.0f) float a, int color) {
        return argb(a, Color.red(color), Color.green(color), Color.blue(color));
    }

    /**
     * 透明度和颜色合成另外一种颜色
     *
     * @param a     透明度
     * @param color 颜色值
     * @return 合成颜色值
     */
    @ColorInt
    public static int argb(@IntRange(from = 0, to = 255) int a, int color) {
        return argb(a, Color.red(color), Color.green(color), Color.blue(color));
    }


    /**
     * create Drawable by color
     *
     * @param resId color id
     * @return Drawable
     */
    public static Drawable getColorDrawable(@ColorRes int resId) {
        return ResUtil.getColorDrawable(resId);
    }


    /**
     * 颜色值
     *
     * @param a 透明度百分比
     * @param r 红
     * @param g 绿
     * @param b 蓝
     * @return 颜色值
     */
    public static int getColor(@FloatRange(from = 0.0f, to = 1.0f) float a, int r, int g, int b) {
        int alpha = (int) (a * 255.0f + 0.5f);
        return argb(alpha, r, g, b);
    }


    /**
     * 从colors.xml中读取color
     *
     * @param resId color id
     * @return color
     */
    public static ColorStateList getColorStateList(@ColorRes int resId) {
        return ResUtil.getColorStateList(resId);
    }


    public static ColorStateListBuilder getColorStateListBuilder() {
        return new ColorStateListBuilder();
    }

    public static class ColorStateListBuilder {

        private ArrayList<int[]> state = new ArrayList<>();
        private ArrayList<Integer> color = new ArrayList<>();


        private ColorStateListBuilder() {

        }

        public ColorStateListBuilder addColorState(@ColorInt int colorInt, int... stateSet) {
            state.add(stateSet);
            color.add(colorInt);
            return this;
        }


        public ColorStateListBuilder addColorResState(@ColorRes int resId, int... stateSet) {
            return addColorState(ResUtil.getColor(resId), stateSet);
        }


        public ColorStateList buildColor() {

            int num = state.size();
            int[][] states = new int[num][];
            int[] colors = new int[num];
            for (int i = 0; i < num; i++) {
                states[i] = state.get(i);
                colors[i] = color.get(i);
            }
            return new ColorStateList(states, colors);
        }
    }


}
