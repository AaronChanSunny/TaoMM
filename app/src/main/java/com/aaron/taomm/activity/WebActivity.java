package com.aaron.taomm.activity;

import android.support.v4.app.Fragment;

import com.aaron.taomm.fragment.WebFragment;

/**
 * Created by Aaron on 15/7/7.
 */
public class WebActivity extends SingleFragmentActivity {

    private WebFragment mWebFragment;

    @Override
    protected Fragment createFragment() {
        mWebFragment = new WebFragment();
        return mWebFragment;
    }

    @Override
    public void onBackPressed() {
        boolean isWebViewBack = mWebFragment.onBackPressed();
        if (!isWebViewBack) {
            super.onBackPressed();
        }
    }
}
