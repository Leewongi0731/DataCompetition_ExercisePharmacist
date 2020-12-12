package com.example.physicalplatform.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.physicalplatform.R;

public class SettingNoticeFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private TextView settingNoticeBackBtn;

    private FragmentManager fragmentManager;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.setting_notice, container, false);
        context = container.getContext();

        // set backBtn
        settingNoticeBackBtn = viewGroup.findViewById(R.id.settingNoticeBackBtn);
        settingNoticeBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStackImmediate();
            }
        });




        return viewGroup;
    }
}
