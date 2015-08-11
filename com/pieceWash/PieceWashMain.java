package jim.com.pieceWash;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import jim.com.adapter.MyPagerAdapter;
import jim.com.indexViewpager.R;

/**
 * Created by Jim Huang on 2015/8/9.
 */
public class PieceWashMain extends FragmentActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private Button btnSpring,btnSummer,btnAutumn,btnWinter;
    private FragmentSprint fragmentSprint;
    private FragmentSummer fragmentSummer;
    private FragmentAutumn fragmentAutumn;
    private FragmentWinter fragmentWinter;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piece_wash);
        initView();
    }

    private void initView() {
        viewPager=(ViewPager)findViewById(R.id.piece_wash_viewpager);
        btnSpring=(Button)findViewById(R.id.btn_sprint);
        btnSummer=(Button)findViewById(R.id.btn_summer);
        btnAutumn=(Button)findViewById(R.id.btn_autumn);
        btnWinter=(Button)findViewById(R.id.btn_winter);

        btnSpring.setOnClickListener(new MyClickListener());
        btnSummer.setOnClickListener(new MyClickListener());
        btnAutumn.setOnClickListener(new MyClickListener());
        btnWinter.setOnClickListener(new MyClickListener());

        fragmentSprint=new FragmentSprint();
        fragmentSummer=new FragmentSummer();
        fragmentAutumn=new FragmentAutumn();
        fragmentWinter=new FragmentWinter();

        list=new ArrayList<Fragment>();
        list.add(fragmentSprint);
        list.add(fragmentSummer);
        list.add(fragmentAutumn);
        list.add(fragmentWinter);

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),list));
        viewPager.setCurrentItem(0);



    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_sprint:
                    viewPager.setCurrentItem(0);
                    initBtn();
                    btnSpring.setBackgroundResource(R.drawable.wash_btn_press);
                    btnSpring.setTextColor(Color.parseColor("#28ccfc"));
                    break;
                case R.id.btn_summer:
                    viewPager.setCurrentItem(1);
                    initBtn();
                    btnSummer.setBackgroundResource(R.drawable.wash_btn_press);
                    btnSummer.setTextColor(Color.parseColor("#28ccfc"));
                    break;
                case R.id.btn_autumn:
                    viewPager.setCurrentItem(2);
                    initBtn();
                    btnAutumn.setBackgroundResource(R.drawable.wash_btn_press);
                    btnAutumn.setTextColor(Color.parseColor("#28ccfc"));
                    break;
                case R.id.btn_winter:
                    viewPager.setCurrentItem(3);
                    initBtn();
                    btnWinter.setBackgroundResource(R.drawable.wash_btn_press);
                    btnWinter.setTextColor(Color.parseColor("#28ccfc"));
                    break;
            }
        }
    }

    private void initBtn(){
        btnSpring.setBackgroundResource(R.drawable.wash_btn_selector);
        btnSummer.setBackgroundResource(R.drawable.wash_btn_selector);
        btnAutumn.setBackgroundResource(R.drawable.wash_btn_selector);
        btnWinter.setBackgroundResource(R.drawable.wash_btn_selector);

        btnSpring.setTextColor(getResources().getColor(R.color.piece_wash_btn_color));
        btnSummer.setTextColor(getResources().getColor(R.color.piece_wash_btn_color));
        btnAutumn.setTextColor(getResources().getColor(R.color.piece_wash_btn_color));
        btnWinter.setTextColor(getResources().getColor(R.color.piece_wash_btn_color));
    }
}
