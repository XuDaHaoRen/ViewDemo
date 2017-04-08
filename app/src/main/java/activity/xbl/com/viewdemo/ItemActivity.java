package activity.xbl.com.viewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by April on 2017/4/5.
 */

public class ItemActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        final ItemView itemView1= (ItemView) findViewById(R.id.item_view1);
        ItemView itemView2= (ItemView) findViewById(R.id.item_view2);
        ItemView itemView3= (ItemView) findViewById(R.id.item_view3);
        itemView1.setView("地址","中国",true);
        itemView2.setView("姓名","April",false);
        itemView3.setView("年龄",null,false);
        //自定义空间的点击事件
        itemView1.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItemActivity.this,itemView1.getLeftText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
