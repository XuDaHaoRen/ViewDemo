package activity.xbl.com.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by April on 2017/4/5.
 * 自定义控件：继承于系统已有的控件
 */

public class SubmitButton extends Button {
    public SubmitButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    //设置Button的样式
    private void init(){
        //设置背景
        setBackgroundResource(R.drawable.btn_submit);
        //设置文字
        setText(R.string.submit);
        //文字大小
        setTextSize(18);

    }
}
