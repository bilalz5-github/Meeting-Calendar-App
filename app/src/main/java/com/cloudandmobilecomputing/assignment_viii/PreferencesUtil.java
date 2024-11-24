package com.cloudandmobilecomputing.assignment_viii;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUtil {
    private static final String PREFERENCES_FILE = "AppSettingsPrefs";

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
    }

    public static void savePreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getPreference(Context context, String key, String defaultValue) {
        return getPreferences(context).getString(key, defaultValue);
    }

    public static void savePreference(Context context, String key, int value) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getPreference(Context context, String key, int defaultValue) {
        return getPreferences(context).getInt(key, defaultValue);
    }
}
