package com.zhen.baselibrary.datasource.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zhen.baselibrary.commonutils.BaseContentProvider;

public class PreferencesManage {

    private static SharedPreferences SP = null;

    static {
        init(BaseContentProvider.context);
    }

    private static void init(Context context) {
        SP = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setLogin(boolean login) {
        SP.edit().putBoolean(SharedKey.LOGIN, login).apply();
    }

    public static boolean getLogin() {
        return SP.getBoolean(SharedKey.LOGIN, false);
    }

}
