package activity.xbl.com.viewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private Button submit_btn;
    private Button layout_btn;
    private Button draw_btn;
    private Button line_btn;
    private Button scroll_btn;
    private Button arc_btn;
    private Button music_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit_btn = (Button) findViewById(R.id.main_submit_btn);
        layout_btn = (Button) findViewById(R.id.main_layout_btn);
        draw_btn = (Button) findViewById(R.id.main_draw_btn);
        line_btn = (Button) findViewById(R.id.main_line_btn);
        scroll_btn = (Button) findViewById(R.id.main_scroll_btn);
        music_btn= (Button) findViewById(R.id.main_music_btn);
        arc_btn= (Button) findViewById(R.id.main_arc_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
                startActivity(intent);
            }
        });
        layout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                startActivity(intent);
            }
        });
        draw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyViewActivity.class);
                startActivity(intent);
            }
        });
        line_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LineActivity.class);
                startActivity(intent);
            }
        });
        scroll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollChangeActivity.class);
                startActivity(intent);


            }
        });
        arc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ArcActivity.class);
                startActivity(intent);
            }
        });
        music_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MusicActivity.class);
                startActivity(intent);

            }
        });
    }
}
