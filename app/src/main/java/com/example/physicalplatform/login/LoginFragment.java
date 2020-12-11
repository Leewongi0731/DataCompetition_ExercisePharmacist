package com.example.physicalplatform.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.MainPageActivity;
import com.example.physicalplatform.R;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private ViewGroup viewGroup;
    private Context context;
    private Button loginBtn;
    private Button newMemberBtn;
    private EditText loginId;
    private EditText loginPwd;
    private InputMethodManager imm;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public LoginFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.login, container, false);
        context = container.getContext();

        initLayout();

        // 로그인 버튼 클릭
        loginBtn.setOnClickListener(this);
        
        // 회원버튼 클릭
        newMemberBtn.setOnClickListener(this);

        return viewGroup;
    }

    private void initLayout() {
        loginId = viewGroup.findViewById(R.id.loginId);
        loginPwd = viewGroup.findViewById(R.id.loginPwd);
        loginBtn = viewGroup.findViewById(R.id.loginBtn);
        newMemberBtn = viewGroup.findViewById(R.id.newMemberBtn);

        transaction = fragmentManager.beginTransaction();
    }

    private boolean isMember(String id, String pwd){
        // 아직 미구현
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.loginBtn:
                String id = loginId.getText().toString();
                String pwd = loginPwd.getText().toString();

                if( isMember(id, pwd) ){
                    Intent intent = new Intent(context, MainPageActivity.class);
                    intent.putExtra( "userID", "기존 유저 로그인 채크" );
                    startActivity(intent);
                }else{
                    // 회원 X -> 아이디 / 비밀번호 다시 입력받도록
                    Toast.makeText(context, "일치하는 회원정보가 없습니다.", Toast.LENGTH_SHORT).show();
                    loginId.setText("");
                    loginPwd.setText("");
                }
                break;
            case R.id.newMemberBtn:
                transaction.replace(R.id.frameLayout, new CaptureFragment(fragmentManager));
                transaction.addToBackStack("photoRegister");
                transaction.commit();
                break;
        }
    }
}
