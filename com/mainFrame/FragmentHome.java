package jim.com.mainFrame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import jim.com.adapter.MyPAdapter;
import jim.com.adapter.MyPChangeAdapter;
import jim.com.indexViewpager.R;
import jim.com.pieceWash.PieceWashMain;

/**
 * Created by Jim Huang on 2015/8/3.
 */
public class FragmentHome extends Fragment {

    private View view;
    private ViewPager viewPager;
    private LinearLayout layout;
    private ImageView imageView[];
    private int imageId[]=new int[]{
           R.drawable.frag_home_img03, R.drawable.frag_home_img03,R.drawable.frag_home_img03
    };
    private Button pieceWashBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view=inflater.inflate(R.layout.activity_fragment_home,container,false);
        initView();

        imageView=new ImageView[imageId.length];
        for (int i=0;i<3;i++){
            ImageView image=new ImageView(getActivity());
            image.setBackgroundResource(imageId[i]);
            imageView[i]=image;
        }

        for (int i=0;i<4;i++){
            ImageView image=new ImageView(getActivity());
            image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            image.setPadding(8,8,8,8);
            image.setImageResource(R.drawable.circle_selector);
            image.setSelected(i==0?true:false);
            layout.addView(image);
        }

        viewPager.setAdapter(new MyPAdapter(imageView));
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new MyPChangeAdapter(layout));

        return view;
    }

    private void initView(){

        pieceWashBtn=(Button)view.findViewById(R.id.frag_home_btn01);
        viewPager=(ViewPager)view.findViewById(R.id.frag_home_viewpager);
        layout =(LinearLayout)view.findViewById(R.id.frag_home_index_container);

        pieceWashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), PieceWashMain.class);
                startActivity(intent);
            }
        });

    }





}
