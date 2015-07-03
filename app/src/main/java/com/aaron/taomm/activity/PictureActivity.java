package com.aaron.taomm.activity;

import android.support.v4.app.Fragment;

import com.aaron.taomm.fragment.PictureFragment;

/**
 * Created by Aaron on 15/7/1.
 */
public class PictureActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new PictureFragment();
    }

}
