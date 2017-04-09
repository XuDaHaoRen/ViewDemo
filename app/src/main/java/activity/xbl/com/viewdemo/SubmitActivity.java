package activity.xbl.com.viewdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by April on 2017/4/5.
 * 继承一个Button的自定义View
 */

public class SubmitActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
    }
}
