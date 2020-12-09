package com.example.physicalplatform.health;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.physicalplatform.R;

public class HealthItemInfoFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_item_info_main, container, false);
        context = container.getContext();

        String exerciseName = "";
        Bundle bundle=getArguments();
        if(bundle !=null) {
            exerciseName = bundle.getString("exerciseName");
        }

        Toast.makeText(context, exerciseName, Toast.LENGTH_SHORT).show();

        return viewGroup;
    }
}