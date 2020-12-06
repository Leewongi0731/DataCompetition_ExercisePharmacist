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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.MainPageActivity;
import com.example.physicalplatform.R;

public class FirstLoginActivity extends AppCompatActivity {
    Button detailEnrollmentBtn;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private DetailInformationFragment detailInformationFragment;
    static String age;
    static String sex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_login);

        Intent intent = getIntent();
        age = intent.getExtras().getString("age");
        sex = intent.getExtras().getString("sex");

        Toast.makeText( this.getApplicationContext(), age, Toast.LENGTH_SHORT ).show();


        fragmentManager = getSupportFragmentManager();
        detailInformationFragment = new DetailInformationFragment();


        detailEnrollmentBtn = (Button)findViewById(R.id.detailEnrollmentBtn);
        detailEnrollmentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.detailFrameLayout, detailInformationFragment).commitAllowingStateLoss();
            }
        });
    }


    public static class DetailInformationFragment extends Fragment {
        private ViewGroup viewGroup;
        private Context context;
        private EditText detailTall;
        private EditText detailWeight;
        private EditText detailZone;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            viewGroup = (ViewGroup) inflater.inflate(R.layout.detail_information, container, false);
            context = container.getContext();

            EditText detailAge = (EditText) viewGroup.findViewById(R.id.detailAge);
            EditText detailSex = (EditText) viewGroup.findViewById(R.id.detailSex);
            EditText detailTall = (EditText) viewGroup.findViewById(R.id.detailTall);
            EditText detailWeight = (EditText) viewGroup.findViewById(R.id.detailWeight);
            EditText detailZone = (EditText) viewGroup.findViewById(R.id.detailZone);
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
}
