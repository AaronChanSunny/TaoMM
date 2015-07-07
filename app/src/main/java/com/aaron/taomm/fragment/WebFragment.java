package com.aaron.taomm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aaron.taomm.R;
import com.aaron.taomm.util.LogUtil;

/**
 * Created by Aaron on 15/7/7.
 */
public class WebFragment extends Fragment {

    private static final String TAG = WebFragment.class.getSimpleName();
    private static final String URL = "http://m.baidu.com";

    private WebView mWebView;
    private SwipeRefreshLayout mSwipeRefresh;
    private Toolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);

        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbar);

        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        mSwipeRefresh.setColorSchemeResources(R.color.primary, R.color.accent, R.color.primary, R.color.accent);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mWebView.reload();
            }
        });

        mWebView = (WebView) view.findViewById(R.id.web);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                LogUtil.i(TAG, "page loading " + newProgress + "%");
                if (newProgress == 100) {
                    mSwipeRefresh.setRefreshing(false);
                } else {
                    mSwipeRefresh.setRefreshing(true);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);

                mToolbar.setTitle(title);
            }
        });
        mWebView.loadUrl(URL);
        return view;
    }

    public boolean onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }

        return false;
    }

}
