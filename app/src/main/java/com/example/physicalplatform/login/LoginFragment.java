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

import com.example.physicalplatform.MainActivity;
import com.example.physicalplatform.MainPageActivity;
import com.example.physicalplatform.R;

public class LoginFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;
    private Button loginBtn;
    private Button newMemberBtn;
    private EditText loginId;
    private EditText loginPwd;
    private InputMethodManager imm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.login, container, false);
        context = container.getContext();

        loginId = (EditText) viewGroup.findViewById(R.id.loginId);
        loginPwd = (EditText) viewGroup.findViewById(R.id.loginPwd);

        // 로그인 버튼 클릭
        loginBtn = (Button) viewGroup.findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
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
            }
        });
        
        
        // 회원버튼 클릭
        newMemberBtn = (Button) viewGroup.findViewById(R.id.newMemberBtn);
        newMemberBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment( new CaptureFragment() );
            }
        });


        return viewGroup;
    }

    private boolean isMember(String id, String pwd){
        // 아직 미구현
        return true;
    }
}
