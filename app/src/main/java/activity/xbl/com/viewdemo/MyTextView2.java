package activity.xbl.com.viewdemo;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by April on 2017/4/6.
 * 实现TextView动态的文字闪动效果
 */

public class MyTextView2 extends TextView {
    Paint p;
    LinearGradient linearGradient;
    Matrix matrix;
    int translate;

    public MyTextView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //组件大小改变时的回调
    //这里是文字的特效发生了变化，所以调用
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //得到TextPaint 控制字体的颜色
        p = getPaint();
        //线性渐变器  0xffffffff 16进制的白色
        linearGradient = new LinearGradient(0, 0, getMeasuredWidth(),0,new int[]{
                Color.BLUE,0xffffffff,Color.RED //颜色的特效  红白蓝转换
        },null, Shader.TileMode.CLAMP);
        //将画笔设置上渐变器
        p.setShader(linearGradient);
        matrix=new Matrix();
        Log.d("TAG1","width"+getMeasuredWidth());


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (matrix!=null){
            translate+=getMeasuredWidth()/5;
            if(translate>2*getMeasuredWidth()){
                translate=-getMeasuredWidth();
            }
            matrix.setTranslate(translate,0);
            linearGradient.setLocalMatrix(matrix);
            //失效后的循环时间
            postInvalidateDelayed(100);
        }
    }
}
