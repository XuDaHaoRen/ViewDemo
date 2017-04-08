package activity.xbl.com.viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by April on 2017/4/6.
 * 折线图的绘图
 */

public class LineView extends View {
    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        p.setColor(Color.BLUE);
        //原点的位置
        int xPoint=200;
        int yPoint=400;
        //y轴(起点坐标，终点坐标，画笔)
        canvas.drawLine(xPoint,yPoint-200,xPoint,yPoint,p);
        //x轴
        canvas.drawLine(xPoint,yPoint,xPoint+300,yPoint,p);
        //画斜线
        canvas.drawLine(xPoint,yPoint,xPoint+50,yPoint-100,p);
        canvas.drawLine(xPoint+50,yPoint-100,xPoint+50+50,yPoint-100-30,p);
        canvas.drawLine(xPoint+50+50,yPoint-100-30,xPoint+50+50+50,yPoint-100-30+50,p);
    }
}
