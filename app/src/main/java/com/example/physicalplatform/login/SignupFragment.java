package com.example.physicalplatform.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.physicalplatform.R;

public class SignupFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;
    private Button enrollmentBtn;
    private EditText signupId;
    private EditText signupPwd;
    private EditText signupPwdCheck;
    private EditText signupEmail;
    private EditText signupBirth;
    private EditText signupPhone;

    private FragmentManager fragmentManager;

    public SignupFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.sign_up, container, false);
        context = container.getContext();

        signupId = (EditText)viewGroup.findViewById(R.id.signupId);
        signupPwd = (EditText)viewGroup.findViewById(R.id.signupPwd);
        signupPwdCheck = (EditText)viewGroup.findViewById(R.id.signupPwdCheck);
        signupEmail = (EditText)viewGroup.findViewById(R.id.signupEmail);
        signupBirth = (EditText)viewGroup.findViewById(R.id.signupBirth);
        signupPhone = (EditText)viewGroup.findViewById(R.id.signupPhone);

        enrollmentBtn = (Button)viewGroup.findViewById(R.id.enrollmentBtn);
        enrollmentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if( addMember() ){
                    String age = getAge();
                    String sex = getSex();

                    fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    
                    Intent intent = new Intent(context, FirstLoginActivity.class);
                    intent.putExtra( "age", age );
                    intent.putExtra( "sex", sex );
                    startActivity(intent);
                    getActivity().finish();
                }else{
                    Toast.makeText(context, "잘못 입력하셨습니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show();

                    signupId.setText("");
                    signupPwd.setText("");
                    signupPwdCheck.setText("");
                    signupEmail.setText("");
                    signupPhone.setText("");
                }
            }
        });
        return viewGroup;
    }

   public boolean addMember(){
        // 데이터 추가
        return true;
   }
   
   public String getAge(){
       String birth = signupBirth.getText().toString();
       
       // 주민번호에서 나이 계산 후 반환
       
       return "65";
   }
   
   private String getSex(){
       String birth = signupBirth.getText().toString();

       // 주민번호에서 성별 추출 후 반환
       
       return "남성";
   }

}
