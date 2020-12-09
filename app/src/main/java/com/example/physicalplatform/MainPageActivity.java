package com.example.physicalplatform;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.chatting.ChattingFragment;
import com.example.physicalplatform.health.HealthFragment;
import com.example.physicalplatform.matching.MatchingFragment;
import com.example.physicalplatform.setting.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPageActivity extends AppCompatActivity {
    String userId;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private HealthFragment healthFragment;
    private MatchingFragment matchingFragment;
    private ChattingFragment chattingFragment;
    private SettingFragment settingFragment;
    private BottomNavigationView bottomNavigationView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        try{
            Intent intent = getIntent();
            userId = intent.getExtras().getString("userID");
            Toast.makeText(this.getApplicationContext(), userId, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this.getApplicationContext(), "홈페이지서 시작", Toast.LENGTH_SHORT).show();
        }

        initLayout();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.nav_main: {
                        transaction.replace(R.id.frame_container, new HealthFragment()).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.nav_matching: {
                        transaction.replace(R.id.frame_container, new MatchingFragment()).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.nav_chat: {
                        transaction.replace(R.id.frame_container, new ChattingFragment()).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.nav_setting: {
                        transaction.replace(R.id.frame_container, new SettingFragment()).commitAllowingStateLoss();
                        return true;
                    }
                }
                return false;
            }
        });
    }


    private void initLayout() {
        fragmentManager = getSupportFragmentManager();
        healthFragment = new HealthFragment();
        matchingFragment = new MatchingFragment();
        chattingFragment = new ChattingFragment();
        settingFragment = new SettingFragment();


        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_container, healthFragment).commitAllowingStateLoss();
    }

    public void replaceFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment).commitAllowingStateLoss();               // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
}







