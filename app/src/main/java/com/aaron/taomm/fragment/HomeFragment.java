package com.aaron.taomm.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.aaron.taomm.R;
import com.aaron.taomm.adapter.MainAdapter;
import com.aaron.taomm.bean.Image;
import com.aaron.taomm.util.LogUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 15/7/3.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getSimpleName();

    private RecyclerView mRecycleView;
    private MainAdapter mAdapter;
    private List<Image> mImages;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDatas();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.i(TAG, "onCreateView.");
        Fresco.initialize(getActivity());
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        setHasOptionsMenu(true);

        mRecycleView = (RecyclerView) view.findViewById(R.id.recycleview);
        mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecycleView.setAdapter(mAdapter);

        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.notifyDataSetChanged();
                mRecycleView.scrollToPosition(0);
            }
        });
        return view;
    }

    private void initDatas() {
        mImages = new ArrayList<>();
        mImages.add(new Image("http://ww2.sinaimg.cn/large/610dc034gw1eqnjfdn45qj20h30mk443.jpg", 450, 594));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/610dc034gw1eqoqwkyy8cj20h20h10wz.jpg", 401, 400));
        mImages.add(new Image("http://ww4.sinaimg.cn/large/610dc034gw1eqpx7qtursj20go0go779.jpg", 300, 300));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1eqr2vp3xtcj20m80m8jwd.jpg", 400, 400));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1eqs82kt4e9j20m80tnwjo.jpg", 400, 534));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1eqwuw1t94yj20ga0ib405.jpg", 400, 450));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/610dc034gw1eqz66m9qctj20go0okdif.jpg", 450, 663));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/610dc034gw1er0c8agag2j20m80bjt93.jpg", 549, 285));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/610dc034jw1er3t0hhn8dj20m80tn76d.jpg", 450, 600));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1er4yt4dy15j20m80etwff.jpg", 500, 333));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/610dc034gw1er645i2y90j20hb0kimyr.jpg", 623, 738));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1er79vdrfvqj20b40jraao.jpg", 400, 711));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/610dc034gw1er8fhea7vnj20b40deq3i.jpg", 400, 482));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1erbum2ltm6j20go0caab3.jpg", 600, 442));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1erd1rhreacj20m80efjsd.jpg", 640, 415));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/610dc034gw1ere7awhfj0j20go0b3dg8.jpg", 600, 399));
        mImages.add(new Image("http://ww4.sinaimg.cn/large/610dc034gw1erfcxwxlvuj20m80gzmyw.jpg", 640, 489));
        mImages.add(new Image("http://ww4.sinaimg.cn/large/610dc034gw1ergiue1xlbj20m80gq757.jpg", 450, 339));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1erjtx9odarj20m80e2mxw.jpg", 640, 405));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1erm9yr0v83j20m80snjt2.jpg", 450, 580));
        mImages.add(new Image("http://ww4.sinaimg.cn/large/610dc034gw1erng5ktg5ij20m80eumy7.jpg", 450, 300));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/610dc034gw1ers1ue9tizj20m80euq3k.jpg", 480, 320));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034jw1erudbbww3xj20go0p075j.jpg", 480, 720));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/610dc034gw1ervje0eqqbj20b40gmjry.jpg", 384, 580));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1erwpilp4kjj20go0p00tr.jpg", 480, 720));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/610dc034jw1es0jgf2v91j20go0p2ab1.jpg", 480, 722));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/610dc034gw1es1dap6rvgj20m80eugmi.jpg", 480, 320));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/610dc034jw1es2hkc090aj20go0p0dgu.jpg", 480, 720));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034jw1es3mty6nm2j20go0n60t9.jpg", 600, 834));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/610dc034gw1es4si7kzebj20m80eu0te.jpg", 450, 300));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/610dc034gw1es89uzch20j20pw0xcadb.jpg", 400, 515));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/7a8aed7bgw1esahpyv86sj20hs0qomzo.jpg", 400, 600));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/7a8aed7bgw1esbmanpn0tj20hr0qo0w8.jpg", 400, 601));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/7a8aed7bgw1escs1cl4f5j20qo0jsn3m.jpg", 450, 334));
        mImages.add(new Image("http://ww4.sinaimg.cn/large/7a8aed7bgw1esfbgw6vc3j20gy0pedic.jpg", 480, 719));
        mImages.add(new Image("http://ww4.sinaimg.cn/large/7a8aed7bgw1eshfawk6bmj20hs0qo41i.jpg", 640, 960));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/7a8aed7bgw1esijbxxwkfj20f00qotb6.jpg", 540, 960));
        mImages.add(new Image("http://ww4.sinaimg.cn/large/7a8aed7bgw1esjpu1vxggj20qo0hrgqw.jpg", 650, 433));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/7a8aed7bgw1esk47n9j93j20hs0qoacp.jpg", 500, 750));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/610dc034jw1esofhleczfj20qo0hsgoq.jpg", 600, 373));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/7a8aed7bgw1esojpl5gmgj20qo0hstbs.jpg", 650, 433));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/7a8aed7bgw1esq1f0899qj20hs0qo780.jpg", 600, 900));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/7a8aed7bgw1essxtqxs6jj20mj0tzdhl.jpg", 493, 655));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/7a8aed7bgw1eswem6zx1mj20qo0hrwgs.jpg", 650, 433));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/7a8aed7bgw1esxxiw20rej20qo0hstcp.jpg", 650, 433));
        mImages.add(new Image("http://ww2.sinaimg.cn/large/7a8aed7bgw1esz3jq17foj20hs0qodj9.jpg", 550, 825));
        mImages.add(new Image("http://ww4.sinaimg.cn/large/7a8aed7bgw1et11xp5wwij20hs0qotb2.jpg", 640, 960));
        mImages.add(new Image("http://ww4.sinaimg.cn/large/7a8aed7bgw1et3qjtenw1j20qo0hsdj3.jpg", 650, 433));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/7a8aed7bgw1et5nl9mno8j20hs0qoacj.jpg", 450, 675));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/7a8aed7bgw1et6yio5s7rj20hs0qogop.jpg", 450, 675));
        mImages.add(new Image("http://ww1.sinaimg.cn/large/7a8aed7bgw1et80fw2p80j20qo0hsdj1.jpg", 660, 440));
        mImages.add(new Image("http://ww3.sinaimg.cn/large/7a8aed7bgw1et95oadpnjj20qo0hs0vk.jpg", 720, 480));

        mAdapter = new MainAdapter(getActivity(), mImages);
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
