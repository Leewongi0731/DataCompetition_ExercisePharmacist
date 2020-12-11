package com.example.physicalplatform.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.R;

public class FirstLoginActivity extends AppCompatActivity {
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
        transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.detailFrameLayout, new FirstLoginPageActivity(fragmentManager));
        transaction.commit();
    }
}
