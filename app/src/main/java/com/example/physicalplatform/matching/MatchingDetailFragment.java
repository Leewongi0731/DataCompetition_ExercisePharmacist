package com.example.physicalplatform.matching;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.R;

public class MatchingDetailFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;
    private ImageView imageViewBackBtn;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.matching_page_detail, container, false);
        context = container.getContext();

        initLayout();

        imageViewBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.popBackStackImmediate();
            }
        });

        return viewGroup;
    }

    private void initLayout() {
        imageViewBackBtn = viewGroup.findViewById(R.id.imageViewBackBtn);

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
    }
}
