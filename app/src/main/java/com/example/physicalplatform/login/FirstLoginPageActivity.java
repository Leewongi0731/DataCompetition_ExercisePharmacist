package com.example.physicalplatform.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.R;

public class FirstLoginPageActivity extends Fragment implements View.OnClickListener {
    private ViewGroup viewGroup;
    private Context context;

    private Button detailEnrollmentBtn;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;


    public FirstLoginPageActivity(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.first_login_page, container, false);
        context = container.getContext();

        initLayout();

        detailEnrollmentBtn.setOnClickListener(this);

        return viewGroup;
    }

    private void initLayout() {
        transaction = fragmentManager.beginTransaction();
        detailEnrollmentBtn = viewGroup.findViewById(R.id.detailEnrollmentBtn);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.detailEnrollmentBtn:
                transaction.replace(R.id.detailFrameLayout, new DetailInformationFragment(fragmentManager));
                transaction.addToBackStack("firstLogin");
                transaction.commit();
                break;
        }
    }
}
