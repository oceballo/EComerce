package com.example.ecomerce.Tools;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ecomerce.Entity.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class UserSession {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    int PRIVATE_MODE=0;
    private static final String PREF_NAME="UserSessionPref";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String USER_OBJECT = "User";

    public UserSession(Context context) {
        this.context = context;

        sharedPreferences=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=sharedPreferences.edit();
    }

    public void createLoginSession(final User user) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(USER_OBJECT, user.toJson().toString());
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

    public User getUserDetails() {

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(Objects.requireNonNull(sharedPreferences.getString(USER_OBJECT, null)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new User(jsonObject);
    }
}
