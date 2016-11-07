package me.yamlee.demo.databinding;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yamlee on 10/21/16.
 */

public class BindingPresenter {
    private static final String TAG = "BindingPresenter";

    public void clickUserName(View view) {
        Log.d(TAG, "clickUserName: clicked");
        TextView textView;
        EditText editText;
    }

    public void clickInSubElement() {
        Log.d(TAG, "click In Sub Element");
    }
}
