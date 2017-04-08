package activity.xbl.com.viewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by April on 2017/4/6.
 * 滚动渐变滚动条
 * 1.拿到ListView的滚动事件
 * 2.得到高度变化
 * 3.根据高度的变化设置顶部条的背景颜色
 * 有问题......
 */

public class ScrollChangeHeadView extends ListView {
    private View viewHead;
    //顶部渐变标题栏
    private View topBar;
    public ScrollChangeHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //为ListView添加一个头部
         viewHead= LayoutInflater.from(context).inflate(R.layout.scroll_change_head,null);
        //添加
        addHeaderView(viewHead);
        //滚送事件,得到滑动的高度
        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //滚动中时这个方法会被调用
                //得到顶部head距离顶部  会从0-负200变化
                int  headTop=viewHead.getTop();
                //将高度做成正数
                headTop=Math.abs(headTop);
                if(topBar!=null&&headTop*(255/100)<255){
                    //0-255  0全透明，255不透明  像素为255，但是设置像素为200,所以用255/200
                    topBar.getBackground().setAlpha(headTop*(255/100));

                }

            }
        });
    }
    //添加顶部渐变条
    public void setTopBar(View v){
        topBar=v;
    }
    //根据手机分辨率从dp单位转化为px像素

}
