package activity.xbl.com.viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by April on 2017/4/7.
 * 实现音乐频率浮动的效果
 * 音乐频率的浮动就是有很多个小矩形，长短不断地变化
 */

public class MusicView extends View {
    private int rect_count;
    //小矩形的高度,这个是不断改变的
    private float rect_heigh;
    //小矩形的水平高度，这个是不变的
    private float low_rect_height;
    private float rect_width;//矩形的宽度
    private float rect_gap;//矩形之间的间距
    private Paint paint;

    public MusicView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i< rect_count; i++){
            rect_heigh=(float)(Math.random()*low_rect_height) ;
            //左上，右下的坐标
            canvas.drawRect((float)i*rect_width+i*rect_gap,
                    rect_heigh,
                    (float)(i+1)*rect_width+i*rect_gap,
                    low_rect_height,
                    paint
                    );
            //每次绘制完一次矩形就要在重新更新数据重绘
            postInvalidateDelayed(300);
        }

    }
    //得到小矩形的宽度的函数
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        low_rect_height=getMeasuredHeight();
        rect_count=10;
        //一共绘制10个矩形，两个是间距
        rect_width=getMeasuredWidth()/12;
        //10个矩形会产生9个间距
        rect_gap=(getMeasuredWidth()/12)/9;
        //添加一个可以渐变的画笔
        paint=new Paint();
        LinearGradient linearGradient=new LinearGradient(0,0,rect_width,
                low_rect_height,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);



    }
}
