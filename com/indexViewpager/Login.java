package jim.com.indexViewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import jim.com.mainFrame.FragmentMainActivity;

/**
 * Created by Jim Huang on 2015/7/26.
 */
public class Login extends Activity {

    private Button getCodeButton,registButton;
    private Boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        initView();

    }

    private void initView() {
        final CountTime time=new CountTime(60000,1000);
        getCodeButton=(Button)findViewById(R.id.bt_code);
        registButton=(Button)findViewById(R.id.bt_register);
        getCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                time.start();

            }
        });

        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this, FragmentMainActivity.class);
                startActivity(intent);
            }
        });
    }

    class CountTime extends CountDownTimer{


        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CountTime(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            flag=false;
            getCodeButton.setText(millisUntilFinished/1000+"秒");
            getCodeButton.setClickable(flag);

        }

        @Override
        public void onFinish() {
            flag=true;
            getCodeButton.setText("重新发送");
            getCodeButton.setClickable(flag);

        }
    }
}
