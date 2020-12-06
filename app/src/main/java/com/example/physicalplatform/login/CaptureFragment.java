package com.example.physicalplatform.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.physicalplatform.MainActivity;
import com.example.physicalplatform.R;

public class CaptureFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;
    private Button captureBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.capture_identity_card, container, false);
        context = container.getContext();


        captureBtn = (Button)viewGroup.findViewById(R.id.captureBtn);
        captureBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if( processOCR() ){
                    ((MainActivity)getActivity()).replaceFragment( new SignupFragment() );
                }else {
                    Toast.makeText(context, "카드를 잘 인식하지 못하였습니다. 다시 촬영해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        return viewGroup;
    }
    
    
    private boolean processOCR(){
        return true;
    }
}