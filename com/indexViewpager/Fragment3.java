package jim.com.indexViewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by Administrator on 2015/7/25.
 */
public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.activity_fragment3,container,false);
        Button button=(Button)view.findViewById(R.id.bt_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Login.class);
                startActivity(intent);
                getActivity().finish();
                Log.i("Jim Log","开始体验");
                //Toast.makeText(Fragment3.this,"ni",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
