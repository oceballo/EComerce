package com.example.ecomerce.Tools;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSession {
    private String user;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    int PRIVATE_MODE=0;
    private static final String PREF_NAME="UserSessionPref";
    private static final String IS_LOGIN = "IsLoggedIn";

    public UserSession(Context context) {
        this.context = context;

        sharedPreferences=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }
    public void setUser(String user) {
        editor.putString("user",user);
        editor.commit();
    }
    public String getUser() {
        return sharedPreferences.getString("user","default");
    }

    public void createLoginSession() {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }

    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.putBoolean(IS_LOGIN, false);
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }
}
