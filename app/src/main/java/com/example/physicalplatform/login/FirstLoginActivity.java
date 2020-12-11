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

        detailEnrollmentBtn = findViewById(R.id.detailEnrollmentBtn);
        detailEnrollmentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                transaction = fragmentManager.beginTransaction();
                transaction.addToBackStack("firstLogin");
                transaction.replace(R.id.detailFrameLayout, new DetailInformationFragment());
                transaction.commit();
            }
        });
    }

}
