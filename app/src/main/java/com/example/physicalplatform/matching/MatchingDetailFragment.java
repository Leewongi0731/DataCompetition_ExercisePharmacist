package com.example.physicalplatform.matching;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

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

    private View viewIntroduction;
    private View viewCurriculum;
    private View viewClassPlan;
    private View viewClassReview;

    private LinearLayout linearLayoutIntroduction;
    private TextView textViewIntroductionContents;
    private TextView buttonIntroductionQuestion;
    private TextView buttonIntroductionRegister;

    private LinearLayout linearLayoutCurriculum;
    private TextView textViewCurriculumContents;

    private LinearLayout linearLayoutClassPlan;
    private TextView textViewClassPlanSummary;
    private CalendarView calendarViewClassPlan;

    private LinearLayout linearLayoutClassReview;
    private RecyclerView recyclerViewClassReviewList;

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

        buttonIntroductionQuestion.setOnClickListener(this);
        buttonIntroductionRegister.setOnClickListener(this);

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

        viewIntroduction = viewGroup.findViewById(R.id.viewIntroduction);
        viewCurriculum = viewGroup.findViewById(R.id.viewCurriculum);
        viewClassPlan = viewGroup.findViewById(R.id.viewClassPlan);
        viewClassReview = viewGroup.findViewById(R.id.viewClassReview);

        linearLayoutIntroduction = viewGroup.findViewById(R.id.linearLayoutIntroduction);
        textViewIntroductionContents = viewGroup.findViewById(R.id.textViewIntroductionContents);
        buttonIntroductionQuestion = viewGroup.findViewById(R.id.buttonIntroductionQuestion);
        buttonIntroductionRegister = viewGroup.findViewById(R.id.buttonIntroductionRegister);

        linearLayoutCurriculum = viewGroup.findViewById(R.id.linearLayoutCurriculum);
        textViewCurriculumContents = viewGroup.findViewById(R.id.textViewCurriculumContents);

        linearLayoutClassPlan = viewGroup.findViewById(R.id.linearLayoutClassPlan);
        textViewClassPlanSummary = viewGroup.findViewById(R.id.textViewClassPlanSummary);
        calendarViewClassPlan = viewGroup.findViewById(R.id.calendarViewClassPlan);

        linearLayoutClassReview = viewGroup.findViewById(R.id.linearLayoutClassReview);
        recyclerViewClassReviewList = viewGroup.findViewById(R.id.recyclerViewClassReviewList);

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
                setTextSelected(R.color.custom_red, R.color.black, R.color.black, R.color.black, View.VISIBLE, View.GONE, View.GONE, View.GONE);
                break;
            case R.id.textViewCurriculum:
                setTextSelected(R.color.black, R.color.custom_red, R.color.black, R.color.black, View.GONE, View.VISIBLE, View.GONE, View.GONE);
                break;
            case R.id.textViewClassPlan:
                setTextSelected(R.color.black, R.color.black, R.color.custom_red, R.color.black, View.GONE, View.GONE, View.VISIBLE, View.GONE);
                break;
            case R.id.textViewClassReview:
                setTextSelected(R.color.black, R.color.black, R.color.black, R.color.custom_red, View.GONE, View.GONE, View.GONE, View.VISIBLE);
                break;
            case R.id.buttonIntroductionQuestion:

                break;
            case R.id.buttonIntroductionRegister:

                break;
        }
    }

    private void setTextSelected(Integer c1, Integer c2, Integer c3, Integer c4, Integer v1, Integer v2, Integer v3, Integer v4) {
        textViewIntroduction.setTextColor(getResources().getColor(c1));
        textViewCurriculum.setTextColor(getResources().getColor(c2));
        textViewClassPlan.setTextColor(getResources().getColor(c3));
        textViewClassReview.setTextColor(getResources().getColor(c4));

        viewIntroduction.setVisibility(v1);
        viewCurriculum.setVisibility(v2);
        viewClassPlan.setVisibility(v3);
        viewClassReview.setVisibility(v4);

        linearLayoutIntroduction.setVisibility(v1);
        linearLayoutCurriculum.setVisibility(v2);
        linearLayoutClassPlan.setVisibility(v3);
        linearLayoutClassReview.setVisibility(v4);
    }
}

