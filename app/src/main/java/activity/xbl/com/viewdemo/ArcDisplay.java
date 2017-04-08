package activity.xbl.com.viewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by April on 2017/4/7.
 * 3.6.3.1弧线展示图
 * 中间圆
 * 圆弧：圆弧的外接矩形（矩形是一个正方形）  圆弧显示的角度
 * 中心的文字：
 */

public class ArcDisplay extends View {
    //绘制中心圆的工具
    // 中心圆的xy轴坐标 x=y 都是屏幕宽度的一半
    private float mCircleXY;
    // 中心圆的半径
    private float mRadius;
    // 中心圆的画笔
    private Paint mCirclePaint;
    //中心的文字
    // 中心圆的文字
    private String mShowText;
    // 文字的画笔
    private Paint mTextPaint;
    //绘制圆弧用的工具
    // 弧线椭圆的画笔
    private Paint mArcPaint;
    // 弧线扫过的角度
    private float mSweepValue;
    //弧线的外接矩形
    private RectF mArcRectF;
    // 文字大小尺寸
    private int mShowTextSize;
    // 画布的宽
    private int length;


    public ArcDisplay(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //画笔等工具的实例化
        initView(context, attrs);
    }

    //设置所有的属性
    private void initView(Context context, AttributeSet attrs) {
        // 将所有的attrs中的所有样式都存储到TypeArray中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ArcDisplay);
        // 给中心圆设置属性
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.GREEN);
        mCirclePaint.setColor(ta.getColor(R.styleable.ArcDisplay_centerCircleColor,
                Color.RED));

        // 给弧形设置属性
        mArcPaint = new Paint();
        //圆弧的笔的粗细
        mArcPaint.setStrokeWidth(ta.getInteger(R.styleable.ArcDisplay_arcWidth, 60));
        mArcPaint.setColor(ta.getColor(R.styleable.ArcDisplay_arcColor,
                Color.RED));
        //空心圆
        mArcPaint.setStyle(Paint.Style.STROKE);
        // 给中间文字设置属性
        mTextPaint = new Paint();
        mShowTextSize = ta.getInteger(R.styleable.ArcDisplay_centerFontSize, 70);
        mTextPaint.setTextSize(mShowTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        //给弧形设置一个角度
        setProgress(ta.getFloat(R.styleable.ArcDisplay_arcAngle, 10));
        ta.recycle();


    }

    /**
     * 将百分比转换为度数
     * @param mSweepValue 百分比
     */
    public void setProgress(float mSweepValue) {
        if (mSweepValue != 0) {
            this.mSweepValue = (float) (360.0 * (mSweepValue / 100.0));
            mShowText = mSweepValue + "%";
        } else {
            this.mSweepValue = 25;
            mShowText = 25 + "%";
        }

        invalidate();
    }



    //得到View的宽高
    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);
        length = w;
        mCircleXY = length / 2;
        mRadius = (float) (length * 0.5 / 2);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制弧线需要指定其椭圆的外接矩形(这个矩形是float型的  不加F为int)
        mArcRectF = new RectF((float) (length * 0.1),
                (float) (length * 0.1),
                (float) (length * 0.9),
                (float) (length * 0.9));
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mArcRectF, 270, mSweepValue, false, mArcPaint);
        canvas.drawText(mShowText,
                0,
                mShowText.length(),
                mCircleXY,
                mCircleXY + (mShowTextSize / 4),
                mTextPaint);
    }

    //为圆弧设置状态值
    public void setmSweepValue(float sweepValue) {
        if (sweepValue != 0) {
            mSweepValue=sweepValue;
        } else {
            mSweepValue = 25;
            mShowText = 25 + "%";
        }
        Log.d("TAG", mSweepValue + "");
        //更新view
        this.invalidate();
    }
}
