package com.example.physicalplatform.login;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.MainActivity;
import com.example.physicalplatform.R;

public class CaptureFragment extends Fragment implements View.OnClickListener {
    private ViewGroup viewGroup;
    private Context context;
    private VideoView captureVideoView;
    private Button captureBtn;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public CaptureFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.capture_identity_card, container, false);
        context = container.getContext();

        initLayout();

        captureBtn.setOnClickListener(this);
        
        return viewGroup;
    }

    private void initLayout() {
        captureBtn = viewGroup.findViewById(R.id.captureBtn);

        captureVideoView = viewGroup.findViewById(R.id.captureVideoView);
        // sample.mp4 설정
        Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/raw/card_s");
        captureVideoView.setVideoURI(uri);
        // 리스너 등록
        captureVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                try {
                    Thread.sleep(1500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                // 준비 완료되면 비디오 재생
                mp.start();
            }
        });

        transaction = fragmentManager.beginTransaction();
    }
    
    private boolean processOCR(){
        return true;
    }

    @Override
    public void onClick(View v) {
        if( processOCR() ){
            captureBtn.setClickable(false);
            captureBtn.setText( "사진에서 정보를 추출중입니다." );


            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            transaction.replace(R.id.frameLayout, new SignupFragment(fragmentManager));
            transaction.addToBackStack("signUp");
            transaction.commit();
        }else {
            Toast.makeText(context, "카드를 잘 인식하지 못하였습니다. 다시 촬영해주세요.", Toast.LENGTH_SHORT).show();
        }
    }

}