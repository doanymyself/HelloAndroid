package com.pact.hello.components.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.ToxicBakery.viewpager.transforms.ABaseTransformer;
import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.FlipVerticalTransformer;
import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.ScaleInOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutSlideTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutTranformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.pact.hello.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ********************************************************
 * banner控件 github地址:https://github.com/saiwu-bigkoo/Android-ConvenientBanner
 * viewpager动画 github地址:https://github.com/ToxicBakery/ViewPagerTransforms
 * ********************************************************
 * Created by wangdong on 2016/9/28.
 */

public class BannerActivty extends AppCompatActivity {

    ConvenientBanner mConvenientBanner;
    private List<Integer> localImages = new ArrayList<>();
    private List<String> networkImages = new ArrayList<>();

    @BindView(R.id.listView)
    ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private List<String> mTransformers = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        localImages.add(R.mipmap.ic_test_0);
        localImages.add(R.mipmap.ic_test_1);
        localImages.add(R.mipmap.ic_test_2);
        localImages.add(R.mipmap.ic_test_3);
        localImages.add(R.mipmap.ic_test_4);
        localImages.add(R.mipmap.ic_test_5);
        localImages.add(R.mipmap.ic_test_6);


        networkImages.add("http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg");
        networkImages.add("http://img2.3lian.com/2014/f2/37/d/40.jpg");
        networkImages.add("http://d.3987.com/sqmy_131219/001.jpg");
        networkImages.add("http://img2.3lian.com/2014/f2/37/d/39.jpg");
        networkImages.add("http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg");
        networkImages.add("http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg");
        networkImages.add("http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg");


        mTransformers.add(DefaultTransformer.class.getSimpleName());
        mTransformers.add(AccordionTransformer.class.getSimpleName());
        mTransformers.add(BackgroundToForegroundTransformer.class.getSimpleName());
        mTransformers.add(CubeInTransformer.class.getSimpleName());
        mTransformers.add(CubeOutTransformer.class.getSimpleName());
        mTransformers.add(DepthPageTransformer.class.getSimpleName());
        mTransformers.add(FlipHorizontalTransformer.class.getSimpleName());
        mTransformers.add(FlipVerticalTransformer.class.getSimpleName());
        mTransformers.add(ForegroundToBackgroundTransformer.class.getSimpleName());
        mTransformers.add(RotateDownTransformer.class.getSimpleName());
        mTransformers.add(RotateUpTransformer.class.getSimpleName());
        mTransformers.add(ScaleInOutTransformer.class.getSimpleName());
        mTransformers.add(StackTransformer.class.getSimpleName());
        mTransformers.add(ZoomInTransformer.class.getSimpleName());
        mTransformers.add(ZoomOutSlideTransformer.class.getSimpleName());
        mTransformers.add(ZoomOutTranformer.class.getSimpleName());

    }

    private void initView() {
        mConvenientBanner = (ConvenientBanner) LayoutInflater.from(this).inflate(R.layout.listview_header_cb, null);
        mConvenientBanner.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 600));

        //加载网络图片
        mConvenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, networkImages);

        //加载本地图片
//        mConvenientBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
//            @Override
//            public LocalImageHolderView createHolder() {
//                return new LocalImageHolderView();
//            }
//        }, localImages);

        //设置两个点图片作为翻页指示器，不设置则没有指示器
        mConvenientBanner.setPageIndicator(new int[]{R.drawable.ic_page_indicator_normal,
                R.drawable.ic_page_indicator_focus});
        //设置指示器的方向
        mConvenientBanner.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        //设置不能手动影响
        mConvenientBanner.setManualPageable(true);
        //设置控制循环
        mConvenientBanner.setCanLoop(true);
        //设置adapter
        mAdapter = new ArrayAdapter<String>(this, R.layout.adapter_transformer, mTransformers);
        mListView.setAdapter(mAdapter);
        //listview添加头部
        mListView.addHeaderView(mConvenientBanner);
        //设置切换动画
//        mConvenientBanner.getViewPager().setPageTransformer(true, new FlipHorizontalTransformer());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String transforemerName = mTransformers.get(position);

                try {
                    Class cls = Class.forName("com.ToxicBakery.viewpager.transforms." + transforemerName);
                    ABaseTransformer transforemer = (ABaseTransformer) cls.newInstance();
                    mConvenientBanner.getViewPager().setPageTransformer(true, transforemer);

                    //部分3D特效需要调整滑动速度
                    if (transforemerName.equals("StackTransformer")) {
                        mConvenientBanner.setScrollDuration(1200);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //开始自动翻页
        mConvenientBanner.startTurning(5000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //停止翻页
        mConvenientBanner.stopTurning();
    }

}
