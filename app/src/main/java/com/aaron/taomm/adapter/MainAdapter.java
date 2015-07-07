package com.aaron.taomm.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aaron.taomm.R;
import com.aaron.taomm.bean.Image;
import com.aaron.taomm.activity.PictureActivity;
import com.aaron.taomm.fragment.PictureFragment;
import com.aaron.taomm.util.LogUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private static final String TAG = MainAdapter.class.getSimpleName();

    private Context mContext;
    private List<Image> mImages;

    public MainAdapter(Context context, List<Image> images) {
        mContext = context;
        mImages = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Image item = mImages.get(position);
        final int thumbWidth = item.getThumbWidth();
        final int thumbHeight = item.getThumbHeight();
//        LogUtil.i(TAG, "image url: " + url);

        holder.container.post(new Runnable() {
            @Override
            public void run() {
//                LogUtil.i(TAG, "container width: " + holder.container.getWidth() + "; height: " + holder.container.getHeight());
                int imageActualWidth = holder.container.getWidth();
                float aspectRatio = (float) thumbHeight / thumbWidth;
//                LogUtil.i(TAG, "image aspect ratio: " + aspectRatio);
                int imageActualHeight = Math.round(imageActualWidth * aspectRatio);

                holder.image.setLayoutParams(new LinearLayout.LayoutParams(imageActualWidth, imageActualHeight));
//                LogUtil.i(TAG, "image width: " + holder.image.getLayoutParams().width + "; height: " + holder.image.getLayoutParams().height);

                String url = item.getUrl();
                Uri uri = Uri.parse(url);
                holder.image.setImageURI(uri);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        SimpleDraweeView image;
        LinearLayout container;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (SimpleDraweeView) itemView.findViewById(R.id.image);
            image.setOnClickListener(this);

            container = (LinearLayout) itemView.findViewById(R.id.container);
        }

        @Override
        public void onClick(View v) {
            LogUtil.i(TAG, "item clicked." + v);

            if (v instanceof SimpleDraweeView) {
                String url = mImages.get(getLayoutPosition()).getUrl();
                LogUtil.i(TAG, "item clicked. url: " + url);

                Intent intent = new Intent(mContext, PictureActivity.class);
                intent.putExtra(PictureFragment.IMAGE_URL, url);
                mContext.startActivity(intent);
            }
        }

    }

}