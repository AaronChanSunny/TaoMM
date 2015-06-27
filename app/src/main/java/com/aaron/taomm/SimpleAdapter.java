package com.aaron.taomm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Git on 2015/6/27.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    private static final String TAG = SimpleAdapter.class.getSimpleName();

    Context mContext;
    List<String> mDatas;

    public SimpleAdapter(Context context, List<String> mDatas) {
        this.mContext = context;
        this.mDatas = mDatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(android.R.layout
                .simple_list_item_1, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }

        @Override
        public void onClick(View v) {
            if (v instanceof TextView)
                Log.i(TAG, "Item " + mDatas.get(getLayoutPosition()) + " clicked.");
        }
    }

}