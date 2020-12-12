package com.example.physicalplatform.health;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.physicalplatform.R;

public class MyControllerView extends LinearLayout {
    Context context;
    ImageButton btn_play, btn_back, btn_front;
    SeekBar seekBar;
    TextView textView_time;

    boolean isFullScreen=false;

    MyControllerView(Context context) {
        super(context);
        this.context=context;
        init();
    }
    MyControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_video_controller,this,true);


        btn_back = view.findViewById(R.id.imageViewVideoBack);
        btn_front = view.findViewById(R.id.imageViewVideoFront);
        btn_play=view.findViewById(R.id.imageViewVideoStart);
        seekBar=view.findViewById(R.id.videoSeekBar);
        textView_time=view.findViewById(R.id.textViewVideoTime);
    }

}
