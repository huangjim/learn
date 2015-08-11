package jim.com.mainFrame;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by Jim Huang on 2015/8/3.
 */
public class MyListView extends ListView {

    private ScrollView parentScrollView;

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyListView(Context context){
        super(context);

    }

    public void setParentScrollView(ScrollView parentScrollView) {

        this.parentScrollView = parentScrollView;
    }

    public ScrollView getParentScrollView() {
        return parentScrollView;
    }

    private int maxHeight;

    public int getMaxHeight() {

        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (maxHeight > -1) {

            heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println(getChildAt(0));

    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){
                case MotionEvent.ACTION_DOWN:

                    setParentScrollAble(false);
                case MotionEvent.ACTION_MOVE:

                    break;
                case MotionEvent.ACTION_UP:

                case MotionEvent.ACTION_CANCEL:
                    setParentScrollAble(true);
                    break;
                default:
                    break;
        }
        return super.onInterceptTouchEvent(ev);

    }

    private void setParentScrollAble(boolean flag) {

        parentScrollView.requestDisallowInterceptTouchEvent(!flag);
    }
}
