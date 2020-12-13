package com.example.physicalplatform.health;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicalplatform.DataBase;
import com.example.physicalplatform.MainActivity;
import com.example.physicalplatform.MainPageActivity;
import com.example.physicalplatform.R;
import com.example.physicalplatform.data.HealthCardDataset;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HealthFragment extends Fragment {
    private ViewGroup viewGroup;
    private Context context;

    private TextView healthMainPageNameSet;
    private ArrayList<HealthCardDataset> bestHealthCardDataset;
    private ArrayList<HealthCardDataset> trendHealthCardDataset;
    private RecyclerView.LayoutManager bestHealthLayoutManager;
    private RecyclerView.LayoutManager trendHealthLayoutManager;
    private RecyclerView bestRecyclerView;
    private RecyclerView trendRecyclerView;
    private HealthFragmentRecyclerViewAdapter bestHealthAdapter;
    private HealthFragmentRecyclerViewAdapter trendHealthAdapter;

    private LinearLayout healthTestLinearLayout;
    private AppCompatActivity activity;
    private FragmentTransaction transaction;

    private String userKey;
    ArrayList<String> mvList;
    ArrayList<String> resultMVList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.health_page, container, false);
        context = container.getContext();



        userKey = DataBase.MEMBER_DB.get(  MainPageActivity.LOGIN_USER_ID ).getKey();
        Toast.makeText(context, userKey, Toast.LENGTH_LONG).show();

        healthMainPageNameSet = viewGroup.findViewById(R.id.healthMainPageNameSet);
        healthMainPageNameSet.setText(  DataBase.MEMBER_DB.get(  MainPageActivity.LOGIN_USER_ID ).getName() + "님한테 맞는 운동처방" );


        initLayout();

        // click test btn
        healthTestLinearLayout = viewGroup.findViewById(R.id.healthTestLinearLayout);
        healthTestLinearLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                activity = (AppCompatActivity)v.getContext();
                transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HealthTestFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return viewGroup;
    }

    private void initLayout() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);


        mvList = DataBase.HEALTH_RECOMMEND_DB.get( userKey + "준비운동" );
        resultMVList = getVideoList( mvList );
        DataBase.HEALTH_DB.get( "준비운동" ).setVideoNameList( resultMVList );

        mvList = DataBase.HEALTH_RECOMMEND_DB.get( userKey + "본운동" );
        resultMVList = getVideoList( mvList );
        DataBase.HEALTH_DB.get( "본운동" ).setVideoNameList( resultMVList );

        mvList = DataBase.HEALTH_RECOMMEND_DB.get( userKey + "마무리운동" );
        resultMVList = getVideoList( mvList );
        DataBase.HEALTH_DB.get( "마무리운동" ).setVideoNameList( resultMVList );

        bestHealthCardDataset = new ArrayList<>();
        bestHealthCardDataset.add( DataBase.HEALTH_DB.get( "준비운동" ) );
        bestHealthCardDataset.add( DataBase.HEALTH_DB.get( "본운동" ) );
        bestHealthCardDataset.add( DataBase.HEALTH_DB.get( "마무리운동" ) );

        bestRecyclerView = viewGroup.findViewById(R.id.bestRecyclerView);
        bestHealthLayoutManager = new LinearLayoutManager(context);
        bestRecyclerView.setLayoutManager(bestHealthLayoutManager);
        bestRecyclerView.setLayoutManager(layoutManager);  // 세로로 나오게 설정
        bestHealthAdapter = new HealthFragmentRecyclerViewAdapter(context, bestHealthCardDataset);
        bestRecyclerView.setAdapter(bestHealthAdapter);


        /////////////////////////////////

        layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        trendHealthCardDataset = new ArrayList<>();
        trendHealthCardDataset.add( DataBase.HEALTH_DB.get( "근력/근지구력" ) );
        trendHealthCardDataset.add( DataBase.HEALTH_DB.get( "심폐지구력" ) );
        trendHealthCardDataset.add( DataBase.HEALTH_DB.get( "유연성" ) );
        trendHealthCardDataset.add( DataBase.HEALTH_DB.get( "평형성" ) );
        trendRecyclerView = viewGroup.findViewById(R.id.trendRecyclerView);

        trendHealthLayoutManager = new LinearLayoutManager(context);
        trendRecyclerView.setLayoutManager(trendHealthLayoutManager);
        trendRecyclerView.setLayoutManager(layoutManager);  // 세로로 나오게 설정
        trendHealthAdapter = new HealthFragmentRecyclerViewAdapter(context, trendHealthCardDataset);
        trendRecyclerView.setAdapter(trendHealthAdapter);
    }


    private ArrayList<String> getVideoList( ArrayList<String> mvList){
        ArrayList<String> resultMVList = new ArrayList<String>();
        //  없는 영상제거...
        for ( int i = 0 ; i < mvList.size() ; i++) {
            if (DataBase.HEALTH_VIDEO_DB.containsKey(mvList.get(i)))
                resultMVList.add( mvList.get(i) );
        }

        return resultMVList;
    }

}