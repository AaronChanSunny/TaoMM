package com.aaron.taomm;

import android.support.v4.app.Fragment;

import com.aaron.taomm.activity.SingleFragmentActivity;
import com.aaron.taomm.fragment.HomeFragment;


public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new HomeFragment();
    }

}
