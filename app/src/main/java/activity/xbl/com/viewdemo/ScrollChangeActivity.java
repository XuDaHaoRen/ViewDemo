package activity.xbl.com.viewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by April on 2017/4/6.
 */

public class ScrollChangeActivity extends Activity {
    private LinearLayout top_bar;
    private ScrollChangeHeadView sc_list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        top_bar= (LinearLayout) findViewById(R.id.scroll_top_bar);
        sc_list_view= (ScrollChangeHeadView) findViewById(R.id.sc_list_view);
        sc_list_view.setTopBar(top_bar);
        //为listView绑定适配器
        sc_list_view.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv=new TextView(ScrollChangeActivity.this);
                tv.setText("这是："+position);
                return tv;
            }
        });


    }
}
