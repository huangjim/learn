package jim.com.indexViewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/7/25.
 */
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_fragment1,container,false);

        return view;
    }
}
