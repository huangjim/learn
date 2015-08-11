package jim.com.indexViewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import jim.com.adapter.MyPagerAdapter;

/**
 * Created by Administrator on 2015/7/25.
 */
public class ViewPagerActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {


    private ViewPager viewPager;
    private ArrayList<Fragment> listFragment;
    private MyPagerAdapter adapter;
    private LinearLayout layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        listFragment = new ArrayList<Fragment>();

        viewPager = (ViewPager) findViewById(R.id.my_viewPager);

        layout=(LinearLayout)findViewById(R.id.layout_index_container);

        for (int i = 0; i < 3; i++) {
            ImageView index=new ImageView(ViewPagerActivity.this);
            index.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            index.setPadding(8,8,8,8);

            index.setImageResource(R.drawable.circle_selector);
            index.setSelected(i==0?true:false);
            layout.addView(index);
        }


        listFragment.add(new Fragment1());
        listFragment.add(new Fragment2());
        listFragment.add(new Fragment3());

        adapter = new MyPagerAdapter(getSupportFragmentManager(), listFragment);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        viewPager.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int count=layout.getChildCount();
        for (int i = 0; i <count ; i++) {
            layout.getChildAt(i).setSelected(i==position?true:false);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
