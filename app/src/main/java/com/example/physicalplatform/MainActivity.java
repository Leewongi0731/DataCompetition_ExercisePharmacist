package com.example.physicalplatform;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.login.CaptureFragment;
import com.example.physicalplatform.login.LoginFragment;
import com.example.physicalplatform.login.SignupFragment;
import com.example.physicalplatform.login.StartLoginPageFragment;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
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

        initLayout();

        //   InputStream inputStream = getResources().openRawResource(R.raw.member);
        //  CSVFile csvFile = new CSVFile(inputStream);
        // List memberList = csvFile.read();

        // Example of a call to a native method
        //      TextView tv = findViewById(R.id.sample_text);
        //     tv.setText(stringFromJNI());
    }

    private void initLayout() {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.frameLayout, new StartLoginPageFragment(fragmentManager));
        transaction.commit();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}