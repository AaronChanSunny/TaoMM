package com.aaron.taomm.ui;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.aaron.taomm.LruBitmapCache;
import com.aaron.taomm.R;
import com.aaron.taomm.net.VolleySingleton;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.facebook.drawee.backends.pipeline.Fresco;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Aaron on 15/7/1.
 */
public class PictureActivity extends AppCompatActivity {

    public static final String IMAGE_URL = "image_url";

    private static final String TAG = PictureActivity.class.getSimpleName();

    private AppBarLayout mAppbar;
    private ImageView mImageView;
    private boolean mIsToolbarShown = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_picture);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAppbar = (AppBarLayout) findViewById(R.id.appbar);
        mAppbar.setAlpha(0.7f);

        mImageView = (ImageView) findViewById(R.id.image);
        ImageLoader imageLoader = new ImageLoader(VolleySingleton.getInstance(this).getRequestQueue(), new LruBitmapCache());
        String url = getIntent().getStringExtra(IMAGE_URL);
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
    }

    private void hideOrShowToolbar() {
        ObjectAnimator animY = ObjectAnimator.ofFloat(mAppbar, "y", mIsToolbarShown ? -mAppbar.getHeight() : 0);
        animY.setInterpolator(new DecelerateInterpolator(2));
        animY.start();
        mIsToolbarShown = !mIsToolbarShown;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
