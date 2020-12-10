package com.example.physicalplatform.matching;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.MatchingListDataset;

public class MatchingDetailFragment extends Fragment implements View.OnClickListener {
    private ViewGroup viewGroup;
    private Context context;
    private ImageView imageViewBackBtn;

    private TextView textViewTitle;
    private TextView textViewTrainer;
    private TextView textViewSummary;
    private TextView textViewPeriod;
    private TextView textViewRating;

    private TextView textViewIntroduction;
    private TextView textViewCurriculum;
    private TextView textViewClassPlan;
    private TextView textViewClassReview;
    private TextView textViewContents;

    private View viewIntroduction;
    private View viewCurriculum;
    private View viewClassPlan;
    private View viewClassReview;

    private Button buttonQuestion;
    private Button buttonRegister;

    private MatchingListDataset matchingListDataset;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public MatchingDetailFragment(MatchingListDataset matchingListDataset) {
        this.matchingListDataset = matchingListDataset;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.matching_page_detail, container, false);
        context = container.getContext();

        initLayout();

        textViewTitle.setText(matchingListDataset.getListTitle());
        //textViewTrainer.setText(());
        //textViewSummary.setText(());
        //textViewPeriod.setText(());

        imageViewBackBtn.setOnClickListener(this);

        textViewIntroduction.setOnClickListener(this);
        textViewCurriculum.setOnClickListener(this);
        textViewClassPlan.setOnClickListener(this);
        textViewClassReview.setOnClickListener(this);

        buttonQuestion.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);

        return viewGroup;
    }

    private void initLayout() {
        imageViewBackBtn = viewGroup.findViewById(R.id.imageViewBackBtn);

        textViewTitle = viewGroup.findViewById(R.id.textViewTitle);
        textViewTrainer = viewGroup.findViewById(R.id.textViewTrainer);
        textViewSummary = viewGroup.findViewById(R.id.textViewSummary);
        textViewPeriod = viewGroup.findViewById(R.id.textViewPeriod);
        textViewRating = viewGroup.findViewById(R.id.textViewRating);

        textViewIntroduction = viewGroup.findViewById(R.id.textViewIntroduction);
        textViewCurriculum = viewGroup.findViewById(R.id.textViewCurriculum);
        textViewClassPlan = viewGroup.findViewById(R.id.textViewClassPlan);
        textViewClassReview = viewGroup.findViewById(R.id.textViewClassReview);
        textViewContents = viewGroup.findViewById(R.id.textViewContents);

        viewIntroduction = viewGroup.findViewById(R.id.viewIntroduction);
        viewCurriculum = viewGroup.findViewById(R.id.viewCurriculum);
        viewClassPlan = viewGroup.findViewById(R.id.viewClassPlan);
        viewClassReview = viewGroup.findViewById(R.id.viewClassReview);

        buttonQuestion = viewGroup.findViewById(R.id.buttonQuestion);
        buttonRegister = viewGroup.findViewById(R.id.buttonRegister);

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.imageViewBackBtn:
                fragmentManager.popBackStackImmediate();
                break;
            case R.id.textViewIntroduction:
                setTextSelected("소개", R.color.custom_red, R.color.black, R.color.black, R.color.black, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
                break;
            case R.id.textViewCurriculum:
                setTextSelected("커리큘럼", R.color.black, R.color.custom_red, R.color.black, R.color.black, View.INVISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
                break;
            case R.id.textViewClassPlan:
                setTextSelected("일정", R.color.black, R.color.black, R.color.custom_red, R.color.black, View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
                break;
            case R.id.textViewClassReview:
                setTextSelected("후기", R.color.black, R.color.black, R.color.black, R.color.custom_red, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE);
                break;
            case R.id.buttonQuestion:

                break;
            case R.id.buttonRegister:

                break;
        }
    }

    private void setTextSelected(String content, Integer c1, Integer c2, Integer c3, Integer c4, Integer v1, Integer v2, Integer v3, Integer v4) {
        textViewContents.setText(content);

        textViewIntroduction.setTextColor(getResources().getColor(c1));
        textViewCurriculum.setTextColor(getResources().getColor(c2));
        textViewClassPlan.setTextColor(getResources().getColor(c3));
        textViewClassReview.setTextColor(getResources().getColor(c4));

        viewIntroduction.setVisibility(v1);
        viewCurriculum.setVisibility(v2);
        viewClassPlan.setVisibility(v3);
        viewClassReview.setVisibility(v4);
    }
}

