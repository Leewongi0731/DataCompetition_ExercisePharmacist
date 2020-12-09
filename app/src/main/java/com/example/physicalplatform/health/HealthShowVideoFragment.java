package com.example.physicalplatform.health;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
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

    private Button healthShowVideoBackBtn;
    private VideoView videoViewHealthVideo;
    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    private String videoPath;
    private FragmentManager fragmentManager;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_show_video, container, false);
        context = container.getContext();

        Bundle bundle=getArguments();
        if(bundle !=null) {
            videoPath = bundle.getString("videoPath");
        }

        // set backBtn
        healthShowVideoBackBtn = (Button) viewGroup.findViewById(R.id.healthShowVideoBackBtn);
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
