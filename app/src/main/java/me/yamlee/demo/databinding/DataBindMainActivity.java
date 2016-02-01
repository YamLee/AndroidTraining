package me.yamlee.demo.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import me.yamlee.demo.BaseActivity;
import me.yamlee.demo.R;
import me.yamlee.demo.entity.User;

/**
 * Created by yamlee on 15/11/20.
 */
public class DataBindMainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databind_demo);
//        ActivityDatabindDemoBinding binding = DataBindingUtil.setContentView(this,
//                R.layout.activity_databind_demo);
//        User user = new User("YamLee", "23");
//        binding.setUser(user);
    }
}
