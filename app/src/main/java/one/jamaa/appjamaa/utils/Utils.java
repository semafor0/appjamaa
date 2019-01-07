package one.jamaa.appjamaa.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {

    private Utils(){
        throw new java.lang.UnsupportedOperationException
                ("This is a utility class and cannot be instantiated");
    }

    /**
     * This method hides the Keyboard with a touch outside the KeyboardView
     * Works only in activities
     *
     * @param activity
     */
    public static void hideKeyboard(Activity activity){
        View view = activity.getCurrentFocus();
        if(view != null){
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
