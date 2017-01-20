package com.xmy.test.sqlitedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: SQLiteDemo
 * @packageName: com.xmy.test.sqlitedemo
 * @className: BinnerActivity
 * @author:xiamingyan
 * @time: 2017/1/19	17:10
 * @E-mail：xmydeveloper@163.com
 * @desc: TODO
 * @upDateAuthor: lenovo
 * @upDate: 2017/1/19
 * @upDateDesc: TODO
 */
public class BinnerActivity extends BaseActivity {


    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, BinnerActivity.class);
        context.startActivity(intent);
    }


    private ConvenientBanner convenientBanner;
    int[] str = {R.mipmap.ic_test_0, R.mipmap.ic_test_1, R.mipmap.ic_test_2, R.mipmap.ic_test_3, R.mipmap.ic_test_4, R.mipmap.ic_test_5, R.mipmap.ic_test_6};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.binner_view);
        convenientBanner = (ConvenientBanner) findViewById(R.id.convenientBanner);

        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, getData())
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
//        convenientBanner.setManualPageable(false);//设置不能手动影响

    }


    public class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }


    public List getData() {
        List list = new ArrayList();
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        return list;
    }


}
