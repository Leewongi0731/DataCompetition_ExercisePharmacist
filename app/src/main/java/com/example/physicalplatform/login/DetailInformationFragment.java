package com.example.physicalplatform.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.MainPageActivity;
import com.example.physicalplatform.R;

import static com.example.physicalplatform.login.FirstLoginActivity.age;
import static com.example.physicalplatform.login.FirstLoginActivity.sex;

public class DetailInformationFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private EditText detailAge;
    private EditText detailSex;
    private EditText detailTall;
    private EditText detailWeight;
    private EditText detailZone;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public DetailInformationFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.detail_information, container, false);
        context = container.getContext();

        detailAge = (EditText) viewGroup.findViewById(R.id.detailAge);
        detailSex = (EditText) viewGroup.findViewById(R.id.detailSex);
        detailTall = (EditText) viewGroup.findViewById(R.id.detailTall);
        detailWeight = (EditText) viewGroup.findViewById(R.id.detailWeight);
        detailZone = (EditText) viewGroup.findViewById(R.id.detailZone);

        detailAge.setText(age);
        detailSex.setText(sex);
        detailAge.setFocusable(false);
        detailAge.setClickable(false);
        detailSex.setFocusable(false);
        detailSex.setClickable(false);

        Button finishInfoBtn = (Button)viewGroup.findViewById(R.id.finishInfoBtn);
        finishInfoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainPageActivity.class);

                String userID = "새로운 로그인 채크";
                intent.putExtra( "userID", userID );
                startActivity(intent);
                getActivity().finish();
            }
        });

        detailTall.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().equals("")) {
                    finishInfoBtn.setEnabled(false);
                } else {
                    finishInfoBtn.setEnabled(true);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        detailWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().equals("")) {
                    finishInfoBtn.setEnabled(false);
                } else {
                    finishInfoBtn.setEnabled(true);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        detailZone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().equals("")) {
                    finishInfoBtn.setEnabled(false);
                } else {
                    finishInfoBtn.setEnabled(true);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return viewGroup;
    }
}