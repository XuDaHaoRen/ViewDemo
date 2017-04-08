package activity.xbl.com.viewdemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by April on 2017/4/7.
 * 用来装载弧度变化View的界面
 */

public class ArcActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc);
        ArcDisplay arc= (ArcDisplay) findViewById(R.id.arc);
        arc.setmSweepValue(100);
    }
}
