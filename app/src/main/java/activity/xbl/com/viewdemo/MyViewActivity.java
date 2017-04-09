package activity.xbl.com.viewdemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by April on 2017/4/5.
 * 显示两个自定义的TextView
 */

public class MyViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myview);
    }
}
