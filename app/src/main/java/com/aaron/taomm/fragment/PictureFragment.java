package com.aaron.taomm.fragment;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.aaron.taomm.LruBitmapCache;
import com.aaron.taomm.R;
import com.aaron.taomm.net.VolleySingleton;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Aaron on 15/7/3.
 */
public class PictureFragment extends Fragment {

    public static final String IMAGE_URL = "image_url";

    private static final String TAG = PictureFragment.class.getSimpleName();

    private AppBarLayout mAppbar;
    private ImageView mImageView;
    private boolean mIsToolbarShown = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setHasOptionsMenu(true);

        mAppbar = (AppBarLayout) view.findViewById(R.id.appbar);
        mAppbar.setAlpha(0.7f);

        mImageView = (ImageView) view.findViewById(R.id.image);
        ImageLoader imageLoader = new ImageLoader(VolleySingleton.getInstance(getActivity()).getRequestQueue(), new LruBitmapCache());
        String url = getActivity().getIntent().getStringExtra(IMAGE_URL);
        imageLoader.get(url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                Bitmap bitmap = response.getBitmap();
                if (bitmap != null) {
                    mImageView.setImageBitmap(bitmap);

                    PhotoViewAttacher attacher = new PhotoViewAttacher(mImageView);
                    attacher.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                        @Override
                        public void onPhotoTap(View view, float v, float v1) {
                            hideOrShowToolbar();
                        }
                    });
                } else {
                    mImageView.setImageResource(R.drawable.ic_placeholder);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return view;
    }

    private void hideOrShowToolbar() {
        ObjectAnimator animY = ObjectAnimator.ofFloat(mAppbar, "y", mIsToolbarShown ? -mAppbar.getHeight() : 0);
        animY.setInterpolator(new DecelerateInterpolator(2));
        animY.start();
        mIsToolbarShown = !mIsToolbarShown;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
