package activity.xbl.com.viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by April on 2017/4/5.
 * 绘制一个已有控件，让它更好看
 */

public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画笔
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);//设置填充风格
        Paint paint1=new Paint();
        paint1.setColor(Color.YELLOW);
        paint1.setStyle(Paint.Style.FILL);
        //绘制矩形
        //外侧图形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,paint1);
        //文字开始输入时在画布向右平移10个像素
        canvas.translate(100,0);
        super.onDraw(canvas);
        canvas.restore();
    }
    //对控件进行测量，如果没有设置宽高就把宽高设置成200px
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeigh(heightMeasureSpec));
    }
    //测量一个控件的宽度
    private int measureWidth(int measureSpec){
        int result=0;
        int specMode=MeasureSpec.getMode(measureSpec);
        int specSize=MeasureSpec.getSize(measureSpec);
        if(specMode==MeasureSpec.EXACTLY){
            result=specSize;
        }else {
            result=200;
            if(specMode==MeasureSpec.AT_MOST){
                result=Math.min(result,specSize);
            }
        }
        return result;

    }
    //测量一个控件的宽度
    private int measureHeigh(int measureSpec){
        int result=0;
        int specMode=MeasureSpec.getMode(measureSpec);
        int specSize=MeasureSpec.getSize(measureSpec);
        //如果是有具体数值或者填充父布局时就返回xml中的宽高
        if(specMode==MeasureSpec.EXACTLY){
            result=specSize;
        }else {
            result=200;
            //如果是warp_content，判断是当前是200px大还是当前已经设置的View大，取小的进行部署
            if(specMode==MeasureSpec.AT_MOST){
                //两个数谁小取谁
                result=Math.min(result,specSize);
            }
        }
        return result;

    }

}
