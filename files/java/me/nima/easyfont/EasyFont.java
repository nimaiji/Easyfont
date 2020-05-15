package me.nima.easyfont;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

/**
 * Created by nima on 4/19/2018 AD.
 */

public class EasyFont {
    private static View view;
    private static Activity activity;

    public EasyFont(Activity activity) {
        this.activity = activity;
    }

    public EasyFont(Activity activity, View view) {
        this.activity = activity;
        this.view = view;
    }


    ////////////////
    /*
     *  Insert your regular font and bold font here ...
     */
    private static String font = "Arial.ttf";
    private static String boldFont = "ArialBold.ttf";
    private static String buttonFont = "ArialItalic.ttf";  // if you set this string empty button's font will be regular font
    private static String editTextFont = "ArialBoldItalic.ttf";    // if you set this string empty editText's font will be regular font
    ////////////////


    public static String getButtonFont() {
        return buttonFont;
    }

    public static String getEditTextFont() {
        return editTextFont;
    }

    public static void tf(int id) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(), "fonts/" + font);
        TextView txt = (TextView) activity.findViewById(id);
        txt.setTypeface(tf);
    }

    public static void tfFragment(int id) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(), "fonts/" + font);
        TextView txt = (TextView) view.findViewById(id);
        txt.setTypeface(tf);
    }

    public static void tfBoldFragment(int id) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(), "fonts/" + boldFont);
        TextView txt = (TextView) view.findViewById(id);
        txt.setTypeface(tf);
    }

    public static void tfBold(int id) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(), "fonts/" + boldFont);
        TextView txt = (TextView) activity.findViewById(id);
        txt.setTypeface(tf);
    }

    private static void tfButton(int id) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(), "fonts/" + buttonFont);
        TextView txt = (TextView) activity.findViewById(id);
        txt.setTypeface(tf);
    }

    private static void tfEditText(int id) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(), "fonts/" + editTextFont);
        TextView txt = (TextView) activity.findViewById(id);
        txt.setTypeface(tf);
    }

    public static void changeAllFonts() {
        changeAllFonts_helper(activity.getWindow().getDecorView());
    }


    public static void changeAllFonts_helper(View v) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    //you can recursively call this method
                    changeAllFonts_helper(child);
                }
            } else if (v instanceof EditText || v instanceof AppCompatEditText) {
                if (getEditTextFont().isEmpty())
                    tf(v.getId());
                else
                    tfEditText(v.getId());
            } else if (v instanceof Button || v instanceof AppCompatButton) {
                if (getButtonFont().isEmpty())
                    tfButton(v.getId());
                else
                    tfButton(v.getId());
            } else if (v instanceof TextView) {
                if (v.getId() == R.id.title)
                    tfBold(v.getId());
                else
                    tf(v.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
