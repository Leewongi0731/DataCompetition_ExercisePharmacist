package com.example.physicalplatform.health;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.HealthCardDataset;

import java.util.ArrayList;

public class HealthInfoVideoFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private Button healthInfoVideoBackBtn;
    private Button healthInfoFrontBtn;

    private ArrayList<HealthCardDataset> healthCardDatasets;
    private RecyclerView.LayoutManager healthLayoutManager;
    private RecyclerView recyclerView;

    private AppCompatActivity activity;
    private FragmentTransaction transaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_info_video, container, false);
        context = container.getContext();


        return viewGroup;
    }
}
