package com.example.physicalplatform.health;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.R;

public class HealthShowVideoFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private TextView healthShowVideoBackBtn;
    private VideoView videoViewHealthVideo;
    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    private String videoPath;
    private FragmentManager fragmentManager;

    private MyControllerView controllerView;
    private TextView textView_time;
    private ImageButton btn_play;
    private ImageButton btn_back, btn_front;
    private SeekBar seekBar;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_show_video, container, false);
        context = container.getContext();
        final MediaController mc = new MediaController(context);

        Bundle bundle=getArguments();
        if(bundle !=null) {
            videoPath = bundle.getString("videoPath");
        }

        // set backBtn
        healthShowVideoBackBtn = viewGroup.findViewById(R.id.healthShowVideoBackBtn);
        healthShowVideoBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStackImmediate();
            }
        });

        // 비디오 링크걸기
        videoViewHealthVideo = viewGroup.findViewById(R.id.videoViewHealthVideo);
        Uri videoUri= Uri.parse( videoPath );

        //비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업

        videoViewHealthVideo.setMediaController(new MediaController( context ));

        /*
        videoViewHealthVideo.setMediaController(new MediaController( context ){
            @Override
            public void hide() {
                show();
            }

            @Override
            public void setAnchorView(View view) {
                super.setAnchorView(view);
                View anchor = view;

                removeAllViews();
                //View 세팅
                controllerView = new MyControllerView(context);

                textView_time = controllerView.textView_time;
                seekBar = controllerView.seekBar;
                btn_back = controllerView.btn_back;
                btn_front = controllerView.btn_front;
                btn_play = controllerView.btn_play;

                btn_play.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(videoViewHealthVideo.isPlaying())
                            videoViewHealthVideo.pause();
                        else
                            videoViewHealthVideo.start();
                    }
                });
                btn_back.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("V", "onSeekComplete1 " + videoViewHealthVideo.getCurrentPosition());


                        int pos = videoViewHealthVideo.getCurrentPosition();
                        videoViewHealthVideo.seekTo( pos - 1000 );

                        Log.d("V", "onSeekComplete1 " + videoViewHealthVideo.getCurrentPosition());
                        //setProgress();
                    }
                });
                btn_front.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("V", "onSeekComplete1 " + videoViewHealthVideo.getCurrentPosition());

                        int pos = videoViewHealthVideo.getCurrentPosition();
                        videoViewHealthVideo.seekTo( pos + 1000 );

                        Log.d("V", "onSeekComplete1 " + videoViewHealthVideo.getCurrentPosition());
                    }
                });


                seekBar.setMax(1000);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        if(fromUser) {
                    //        int where = (progress * duration / seekBar.getMax());

                  //          videoViewHealthVideo.seekTo(where);
                   //         textView_time.setText(stringForTime(where) + "/" + stringForTime(duration));
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });


                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while(true) {
                                Thread.sleep(100);

                                if(videoViewHealthVideo == null || textView_time == null || seekBar == null)
                                    continue;

                               // setProgress();

                            }
                        } catch(Exception e) {
                            Log.e("TAG HI", "ERROR", e);
                        }
                    }
                });
                thread.start();

                addView(controllerView);
            }
        });
*/

        //VideoView가 보여줄 동영상의 경로 주소(Uri) 설정하기
        videoViewHealthVideo.setVideoURI(videoUri);

        //동영상을 읽어오는데 시간이 걸리므로..
        //비디오 로딩 준비가 끝났을 때 실행하도록..
        //리스너 설정
        videoViewHealthVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //비디오 시작
                videoViewHealthVideo.start();
            }
        });




        return viewGroup;
    }


}
