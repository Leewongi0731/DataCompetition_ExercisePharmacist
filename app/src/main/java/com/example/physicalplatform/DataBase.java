package com.example.physicalplatform;

import android.content.Context;
import android.util.Log;

import com.example.physicalplatform.data.CSVFile;
import com.example.physicalplatform.data.HealthCardDataset;
import com.example.physicalplatform.data.HealthVideoDataset;
import com.example.physicalplatform.data.Member;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    public static HashMap<String, Member> MEMBER_DB;
    public static HashMap<String, HealthCardDataset> HEALTH_DB;
    public static HashMap<String, HealthVideoDataset> HEALTH_VIDEO_DB;
    public static HashMap<String, ArrayList<String>> HEALTH_RECOMMEND_DB;


    private Context context;

    DataBase( Context context ){
        this.context = context;
    }

    public void initializMemberDB() {
        MEMBER_DB = new HashMap<String, Member>();
// String name, String pwd, String email, String registrationNumber, String gender, String height, String weight, String score, String location
        MEMBER_DB.put( "490000-2000000", new Member("김혜자", "pwd", "email", "490000-2000000", "151.5", "44.58",  "금상", "서울"));
        MEMBER_DB.put( "530000-1000000", new Member("김춘배", "pwd", "email", "530000-1000000", "164.2", "80.8",  "은상", "서울"));
    }

    public void initializHealthDB() {
        HEALTH_DB = new HashMap<String, HealthCardDataset>();

        String[] mvNameList = { "엉덩이 스트레칭", "대퇴사두근 스트레칭", "몸통 들어올리기", "누워서 전신 뻗기" };

        HEALTH_DB.put("준비운동", new HealthCardDataset("준비운동", "준비운동은 신체활동 또는 운동에 참여하기 전 신체의 기능을 안정 상태에서 운동에 " +
                "적합한 상태로 서서히 유도해가는 일련의 과정으로서 웜업(warm-up)이라고도 하며," +
                "본운동에 참여하기 전 최소한 10분 이상은 투자하여 실시하는 것이 권장합니다. ", R.drawable.exercise_1, mvNameList));
        HEALTH_DB.put("본운동", new HealthCardDataset("본운동", "본 강좌는 3~5개로 이루어져있으며, 회원님에게 알맞은 운동영상을 제공함으로써 운동에 대한 흥미와 건강 효과를 극대화 할 수 있습니다."
                , R.drawable.exercise_10, mvNameList));
        HEALTH_DB.put("마무리운동", new HealthCardDataset("마무리운동", "마무리 운동은 본운동에 의해 올라간 체온과 심박수, 근육의 긴장감, 몸 곳곳에 쌓인 피로를 제거해 신체를 원래 상태로 돌려놓기 위한 신체안정화 단계 입니다.\n"+
                "마무리 운동을 통해 근육통, 관절부상을 예방 및 보호할 수 있습니다.  ", R.drawable.exercise_4, mvNameList));


        String[] l1 = { "의자 이용 근력운동 루틴 프로그램", "치매를 위한 근력운동", "우울증을 위한 근력운동", "관절염을 위한 근력운동", "요통을 위한 근력운동" };
        HEALTH_DB.put("근력/근지구력", new HealthCardDataset("근력/근지구력", "근력은 노인의 체력을 결정하는 가장 중요한 요소지만 50세 이후부터 10년마다 15~20%씩 감소한다." +
                "그러면 계단 오르기나 의자에서 일어서기, 물건 나르기 등의 일상적인 생활에서도 불편함을 느끼게 된다. 근육량과 근력의 감소는 유전·질병·영양과 같은 다양한 요인들의 영향을 받지만," +
                "노인의 근력 감소와 관련된 가장 중요한 변수는 신체활동의 부족이라고 한다. 아래의 추천 근력운동을 통해 효과적으로 근력운동을 수행 할 수 있다.", R.drawable.exercise_3, l1));

        String[] l2 = { "우울증을 위한 심폐지구력 운동", "관절염을 위한 심폐지구력 운동", "고혈압환자 심폐지구력운동" };
        HEALTH_DB.put("심폐지구력", new HealthCardDataset("심폐지구력", "적절한 심폐지구력을 유지하는 것은 심혈관계 질환, 당뇨, 비만, 고혈압 등의 성인병 질환을 감소시키는 데 도움을 준다." +
                " 정상적인 생활을 유지하기 위해 필요한 최소한의 산소 섭취량은 15-18ml/kg/min이다. 하지만 심폐 지구력은 30세 이후 10년마다 5~15%씩 감소하며 70세까지는 절반 이상이 감소한다." +
                "노인들이 심폐지구력을 향상시키기 위해서는 매일 중등도 강도의 운동을 30분씩 시행해야 한다. 아래의 추천 심폐력운동을 통해 효과적으로 심폐력운동을 수행 할 수 있다.", R.drawable.exercise_2, l2));

        String[] l3 = { "의자이용 유연성운동 루틴 프로그램", "의자이용 치매를 위한 스트레칭", "우울증을 위한 스트레칭", "관절염을 위한 스트레칭", "골다공증을 위한 스트레칭\n" };
        HEALTH_DB.put("유연성", new HealthCardDataset("유연성", "유연성이 감소하면 머리 빗기, 등 뒤의 지퍼 올리기, 지갑을 뒷주머니에 넣기, 안전벨트와 착용하기 등 일상생활 중의 동작이 어려워진다." +
                " 65세 이상의 건강한 노인의 36%가 어깨 통증을 호소하는데, 이 이유가 어깨의 유연성이 떨어지기 때문이라는 연구 결과도 있다." +
                "일상생활에 필요한 유연성을 유지하기 위해서는 적어도 하루에 10분, 주 2일의 유연성 운동이 필요하다. 아래의 추천 유연성운동을 통해 효과적으로 유연성운동을 수행 할 수 있다.", R.drawable.exercise_9, l3));



        HEALTH_DB.put("평형성", new HealthCardDataset("평형성", "종아리 스트레칭은 ~", R.drawable.exercise_8, mvNameList));
    }

    public void initializHealtVideohDB(){
        HEALTH_VIDEO_DB = new HashMap<String, HealthVideoDataset>();

        HEALTH_VIDEO_DB.put(  "엉덩이 스트레칭", new HealthVideoDataset( "엉덩이 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/246/246.mp4","10분 00초") );
        HEALTH_VIDEO_DB.put(  "엉덩이 스트레칭2", new HealthVideoDataset( "엉덩이 스트레칭2", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/247/247.mp4","10분 00초") );
        HEALTH_VIDEO_DB.put(  "내전근 스트레칭", new HealthVideoDataset( "내전근 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/285/285.mp4","7분 00초") );
        HEALTH_VIDEO_DB.put(  "대퇴사두근 스트레칭", new HealthVideoDataset( "대퇴사두근 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/287/287.mp4","7분 00초") );
        HEALTH_VIDEO_DB.put(  "대퇴이두근 스트레칭", new HealthVideoDataset( "대퇴이두근 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/272/272.mp4","8분 00초") );
        HEALTH_VIDEO_DB.put(  "대퇴이두근 스트레칭2", new HealthVideoDataset( "대퇴이두근 스트레칭2", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/273/273.mp4","8분 00초") );
        HEALTH_VIDEO_DB.put(  "배 스트레칭", new HealthVideoDataset( "배 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/251/251.mp4","10분 00초") );
        HEALTH_VIDEO_DB.put(  "등 대고 대퇴이두근 스트레칭", new HealthVideoDataset( "등 대고 대퇴이두근 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/268/268.mp4","8분 00초") );
        HEALTH_VIDEO_DB.put(  "가슴/어깨 스트레칭", new HealthVideoDataset( "가슴/어깨 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/251/251.mp4","9분 00초") );
        HEALTH_VIDEO_DB.put(  "고양이 자세", new HealthVideoDataset( "고양이 자세", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/604/604.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "목 스트레칭", new HealthVideoDataset( "목 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/279/279.mp4","8분 00초") );
        HEALTH_VIDEO_DB.put(  "고정식 자전거 타기", new HealthVideoDataset( "고정식 자전거 타기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/169/169.mp4","16분 12초") );
        HEALTH_VIDEO_DB.put(  "벽에서 팔굽혀 펴기", new HealthVideoDataset( "벽에서 팔굽혀 펴기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/225/225.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "실내 자전거타기", new HealthVideoDataset( "실내 자전거타기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/4/4.mp4","2분 21초") );
        HEALTH_VIDEO_DB.put(  "물병 들고 한발 앞으로 내밀고 앉았다 일어서기", new HealthVideoDataset( "물병 들고 한발 앞으로 내밀고 앉았다 일어서기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/212/212.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "몸통 들어올리기", new HealthVideoDataset( "몸통 들어올리기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/221/221.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "엎드려 버티기", new HealthVideoDataset( "엎드려 버티기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/78/78.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "앉았다 일어서기", new HealthVideoDataset( "앉았다 일어서기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/188/188.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "달리기", new HealthVideoDataset( "달리기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/2/2.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "수영", new HealthVideoDataset( "수영", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/187/187.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "줄넘기 운동", new HealthVideoDataset( "줄넘기 운동", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/453/453.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "의자에 앉아 옆구리 숙이기", new HealthVideoDataset( "의자에 앉아 옆구리 숙이기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/587/587.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "합장하여 앞으로 숙이기", new HealthVideoDataset( "합장하여 앞으로 숙이기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/537/537.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "양손 모아 균형 잡기", new HealthVideoDataset( "양손 모아 균형 잡기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/470/470.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "트레드밀에서 걷기", new HealthVideoDataset( "트레드밀에서 걷기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/168/168.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "누워서 전신 뻗기", new HealthVideoDataset( "누워서 전신 뻗기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/240/240.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "몸통 비틀기", new HealthVideoDataset( "몸통 비틀기", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/278/278.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "어깨 스트레칭", new HealthVideoDataset( "어깨 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/256/256.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "척추 스트레칭", new HealthVideoDataset( "척추 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/302/302.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "옆구리 스트레칭", new HealthVideoDataset( "옆구리 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/283/283.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "고관절 스트레칭", new HealthVideoDataset( "고관절 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/271/271.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "회전근개 스트레칭", new HealthVideoDataset( "회전근개 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/255/255.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "스텝박스", new HealthVideoDataset( "스텝박스", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/171/171.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "복부 스트레칭", new HealthVideoDataset( "복부 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/296/296.mp4","9분 48초") );
        HEALTH_VIDEO_DB.put(  "동적 스트레칭 루틴프로그램", new HealthVideoDataset( "동적 스트레칭 루틴프로그램", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/598/598.mp4","9분 48초") );

        HEALTH_VIDEO_DB.put(  "의자 이용 근력운동 루틴 프로그램", new HealthVideoDataset( "의자 이용 근력운동 루틴 프로그램", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/404/404.mp4","1분 23초") );
        HEALTH_VIDEO_DB.put(  "치매를 위한 근력운동", new HealthVideoDataset( "치매를 위한 근력운동", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/390/390.mp4","1분 42초") );
        HEALTH_VIDEO_DB.put(  "우울증을 위한 근력운동", new HealthVideoDataset( "우울증을 위한 근력운동", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/386/386.mp4","1분 16초") );
        HEALTH_VIDEO_DB.put(  "관절염을 위한 근력운동", new HealthVideoDataset( "관절염을 위한 근력운동", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/382/382.mp4","1분 16초") );
        HEALTH_VIDEO_DB.put(  "요통을 위한 근력운동", new HealthVideoDataset( "요통을 위한 근력운동", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/375/375.mp4","1분 10초") );


        HEALTH_VIDEO_DB.put(  "우울증을 위한 심폐지구력 운동", new HealthVideoDataset( "우울증을 위한 심폐지구력 운동", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/387/387.mp4","5분 50초") );
        HEALTH_VIDEO_DB.put(  "관절염을 위한 심폐지구력 운동", new HealthVideoDataset( "관절염을 위한 심폐지구력 운동", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/384/384.mp4","1분 22초") );
        HEALTH_VIDEO_DB.put(  "고혈압환자 심폐지구력운동", new HealthVideoDataset( "고혈압환자 심폐지구력운동", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/372/372.mp4","1분 05초") );


        HEALTH_VIDEO_DB.put(  "의자이용 유연성운동 루틴 프로그램", new HealthVideoDataset( "의자이용 유연성운동 루틴 프로그램", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/402/402.mp4","1분 47초") );
        HEALTH_VIDEO_DB.put(  "의자이용 치매를 위한 스트레칭", new HealthVideoDataset( "의자이용 치매를 위한 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/389/389.mp4","2분 02초") );
        HEALTH_VIDEO_DB.put(  "우울증을 위한 스트레칭", new HealthVideoDataset( "우울증을 위한 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/385/385.mp4","2분 12초") );
        HEALTH_VIDEO_DB.put(  "관절염을 위한 스트레칭", new HealthVideoDataset( "관절염을 위한 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/381/381.mp4","1분 11초") );
        HEALTH_VIDEO_DB.put(  "골다공증을 위한 스트레칭", new HealthVideoDataset( "골다공증을 위한 스트레칭", "http://nfa.kspo.or.kr/common/site/www/front/movie_zip/377/377.mp4","1분 14초") );
    }


    public void initializRecommandFile(){
        HEALTH_RECOMMEND_DB = new HashMap<String, ArrayList<String>>();

        InputStream inputStream = context.getResources().openRawResource(R.raw.recommend_set);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> recoommedList = csvFile.read();

        for ( int i = 0 ; i < recoommedList.size() ; i++){
            if(  !HEALTH_RECOMMEND_DB.containsKey( recoommedList.get(i)[0] ) )
                HEALTH_RECOMMEND_DB.put(  recoommedList.get(i)[0], new ArrayList<String>());
            HEALTH_RECOMMEND_DB.get(  recoommedList.get(i)[0] ).add( recoommedList.get(i)[2] );
        }

        Log.d(  "M",  HEALTH_RECOMMEND_DB.get(  "50대/정상/F/동상/본운동" ).get(0)  );
        Log.d(  "M",  HEALTH_RECOMMEND_DB.get(  "50대/정상/F/동상/본운동" ).get(1)  );
        Log.d(  "M",  HEALTH_RECOMMEND_DB.get(  "50대/정상/F/동상/본운동" ).get(2)  );
        Log.d(  "M",  HEALTH_RECOMMEND_DB.get(  "50대/정상/F/동상/본운동" ).get(3)  );
        Log.d(  "M",  HEALTH_RECOMMEND_DB.get(  "50대/정상/F/동상/본운동" ).get(4)  );
    }

}
