package com.example.physicalplatform;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.physicalplatform.login.CaptureFragment;
import com.example.physicalplatform.login.FirstLoginActivity;
import com.example.physicalplatform.login.LoginFragment;
import com.example.physicalplatform.login.SignupFragment;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {
    private Button memberBtn;
    private Button instructorBtn;
    private FragmentManager fragmentManager;
    private LoginFragment loginFragment;
    private CaptureFragment captureFragment;
    private SignupFragment signupFragment;
    private FragmentTransaction transaction;


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        fragmentManager = getSupportFragmentManager();
        loginFragment = new LoginFragment();
        captureFragment = new CaptureFragment();
        signupFragment = new SignupFragment();

        memberBtn = (Button)findViewById(R.id.memberLoginBtn);
        instructorBtn = (Button)findViewById(R.id.InstructorLoginBtn);

        //   InputStream inputStream = getResources().openRawResource(R.raw.member);
        //  CSVFile csvFile = new CSVFile(inputStream);
        // List memberList = csvFile.read();

        // Example of a call to a native method
        //      TextView tv = findViewById(R.id.sample_text);
        //     tv.setText(stringFromJNI());
    }

    public void loginBtn(View v){
        memberBtn.setVisibility(View.INVISIBLE);
        instructorBtn.setVisibility(View.INVISIBLE);
        transaction = fragmentManager.beginTransaction();

        if(v.getId() == R.id.memberLoginBtn ){
            transaction.replace(R.id.frameLayout, loginFragment).commitAllowingStateLoss();
        }else if(v.getId() == R.id.InstructorLoginBtn){
            transaction.replace(R.id.frameLayout, loginFragment).commitAllowingStateLoss();
        }
    }

    public void replaceFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment).commitAllowingStateLoss();               // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}