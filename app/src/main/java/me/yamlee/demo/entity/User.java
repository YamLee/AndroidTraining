package me.yamlee.demo.entity;

import android.databinding.ObservableField;

/**
 * Created by yamlee on 15/11/20.
 */
public class User {
    public ObservableField<String> userName = new ObservableField<>();
    public String age = "default_age";
    public int userNameLength = 2;


    public User() {
    }


}
