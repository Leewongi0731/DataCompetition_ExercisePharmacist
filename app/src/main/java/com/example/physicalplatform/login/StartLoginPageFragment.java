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

public class StartLoginPageFragment extends Fragment implements View.OnClickListener {
    private ViewGroup viewGroup;
    private Context context;

    private Button memberLoginBtn;
    private Button InstructorLoginBtn;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public StartLoginPageFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.start_page_login, container, false);
        context = container.getContext();

        initLayout();

        memberLoginBtn.setOnClickListener(this);
        InstructorLoginBtn.setOnClickListener(this);

        return viewGroup;
    }

    private void initLayout() {
        memberLoginBtn = viewGroup.findViewById(R.id.memberLoginBtn);
        InstructorLoginBtn = viewGroup.findViewById(R.id.InstructorLoginBtn);

        transaction = fragmentManager.beginTransaction();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.memberLoginBtn:
                transaction.replace(R.id.frameLayout, new LoginFragment(fragmentManager));
                transaction.addToBackStack("login");
                transaction.commit();
                break;
            case R.id.InstructorLoginBtn:
                transaction.replace(R.id.frameLayout, new LoginFragment(fragmentManager));
                transaction.addToBackStack("login");
                transaction.commit();
                break;
        }
    }
}
