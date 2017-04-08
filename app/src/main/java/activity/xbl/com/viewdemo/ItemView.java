package activity.xbl.com.viewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by April on 2017/4/5.
 * 自定义控件：继承自布局,布局需要多个已有布局进行结合
 */

public class ItemView extends RelativeLayout {
    private TextView right_tv;
    private TextView left_tv;
    private ImageView arrow_iv;
    private RelativeLayout r1;
    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //将布局加载进去
        View v=LayoutInflater.from(context).inflate(R.layout.rel_item,this);
        right_tv= (TextView) v.findViewById(R.id.tv_right);
        left_tv= (TextView) v.findViewById(R.id.tv_left);
        r1= (RelativeLayout) v.findViewById(R.id.item_r1);
        arrow_iv= (ImageView) v.findViewById(R.id.arrow_iv);
        //获取xml中写入的属性值，这样程序会去找xml定义的属性值
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.ItemView);
        String left_text=ta.getString(R.styleable.ItemView_left_text);
        String right_text=ta.getString(R.styleable.ItemView_right_text);
        boolean show_arrow=ta.getBoolean(R.styleable.ItemView_show_arrow,false);
        setView(left_text,right_text,show_arrow);
        ta.recycle();



    }

    /**
     *
     * @param text_right 右边文字
     * @param text_left 左边文字
     * @param isShowArrow 箭头是否显示
     */
    public void setView(String text_right,String text_left,boolean isShowArrow){
        if (text_right!=null){
            right_tv.setText(text_right);
        }
        if (text_left!=null){
            left_tv.setText(text_left);

        }
        if(isShowArrow){
            arrow_iv.setVisibility(VISIBLE);
        }else {
            arrow_iv.setVisibility(GONE);
        }

    }
    //自定义属性，View的点击事件
    public void setOnItemViewClickListener(OnClickListener listener){
        r1.setOnClickListener(listener);
    }
    //获取左边内容
    public String getLeftText(){
        return left_tv.getText().toString();
    }
    public String getRightText(){
        return right_tv.getText().toString();
    }

}
