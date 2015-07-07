package com.aaron.taomm.activity;

import android.support.v4.app.Fragment;

import com.aaron.taomm.fragment.HomeFragment;

/**
 * Created by Aaron on 15/7/7.
 */
public class HomeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new HomeFragment();
    }
}
