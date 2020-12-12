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
import com.example.physicalplatform.data.HealthCardDataset;
import com.example.physicalplatform.data.HealthVideoDataset;
import com.example.physicalplatform.health.HealthFragment;
import com.example.physicalplatform.matching.MatchingFragment;
import com.example.physicalplatform.setting.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainPageActivity extends AppCompatActivity {
    public static final String LOGIN_USER_ID = "490000-2000000";


    String userId;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private HealthFragment healthFragment;
    private MatchingFragment matchingFragment;
    private ChattingFragment chattingFragment;
    private SettingFragment settingFragment;
    public static BottomNavigationView bottomNavigationView;

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

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


        initializeDataBase(); // static 디비 초기화
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

    private void initializeDataBase(){
        DataBase db = new DataBase(getApplicationContext());
        // DB 초기화.
        db.initializMemberDB();
        db.initializHealthDB();
        db.initializHealtVideohDB();
        db.initializRecommandFile();
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

    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            if (intervalTime >= 0 && intervalTime <= FINISH_INTERVAL_TIME) {        // 2초 이내에 뒤로가기 버튼 클릭 시 종료
                super.onBackPressed();
            } else {
                backPressedTime = tempTime;
                Toast.makeText(getApplicationContext(), "한번 더 누르면 종료됩니다.", Toast.LENGTH_LONG).show();
            }
        }
    }
}







