package one.jamaa.appjamaa.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {

    private static final int PRIVATE_MODE = 0;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    // Shared preferences filename
    private static final String PREFERENCE_NAME = "JamaaPreference";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PreferencesManager(Context context){
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch(){
        return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
