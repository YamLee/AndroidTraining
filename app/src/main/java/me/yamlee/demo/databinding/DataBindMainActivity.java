package me.yamlee.demo.databinding;

import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
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
//        setContentView(R.layout.activity_data_bind_demo);

        me.yamlee.demo.databinding.ActivityDataDemoBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_data_demo);
        User user = new User();
        user.userName.set("LiYan");
        user.age = "20";
        BindingPresenter bindingPresenter = null;
//        bindingPresenter = new BindingPresenter();
        binding.setUser(user);
        binding.setPresenter(bindingPresenter);
    }
}
