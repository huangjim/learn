package jim.com.pieceWash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import jim.com.adapter.MyPieceGridAdapter;
import jim.com.indexViewpager.R;

/**
 * Created by Jim Huang on 2015/8/9.
 */
public class FragmentSprint extends Fragment {

    private View view;
    private int imageId[];
    private int price[];
    private String clothesName[];
    private List<PieceItemMsg> list;
    private PieceItemMsg pieceItemMsg;
    private GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.activity_frag_spring,container,false);

        initView();
        gridView.setAdapter(new MyPieceGridAdapter(list,getActivity()));

        return view;

    }

    private void initView() {

        gridView=(GridView)view.findViewById(R.id.grid_spring);
        imageId=new int[]{R.drawable.basket_list_item_img01,R.drawable.basket_list_item_img02,
                R.drawable.basket_list_item_img03,R.drawable.basket_list_item_img10,
                R.drawable.basket_list_item_img11};

        price=new int[]{8,8,12,18,24};
        clothesName=new String[]{"衬衣","T恤","短风衣","长风衣","西装"};

        list=new ArrayList<>();
        for (int i=0;i<imageId.length;i++){
            pieceItemMsg=new PieceItemMsg();
            pieceItemMsg.setImageId(imageId[i]);
            pieceItemMsg.setPrice(price[i]);
            pieceItemMsg.setClothesName(clothesName[i]);
            list.add(pieceItemMsg);
        }

    }
}
