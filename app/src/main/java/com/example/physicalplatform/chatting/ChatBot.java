package com.example.physicalplatform.chatting;

import com.example.physicalplatform.R;
import com.example.physicalplatform.data.ChattingTalkDataset;

public class ChatBot {
    private String sendText;

    public ChatBot(String sendText) {
        this.sendText = sendText;
    }

    public ChattingTalkDataset sendChatting() {
        String resultText = "";
        if(sendText.contains("커리큘럼")) {
            resultText = "1주차 - OT\n2주차 - 헬스트레이닝1\n3주차 - 헬스트레이닝2\n4주차 - 헬스트레이닝3\n5주차 - 헬스트레이닝4\n6주차 - 헬스트레이닝5\n7주차 - 혼자하는 헬스 트레이닝\n8주차 - 마무리";
        } else if(sendText.contains("수업일정")) {
            resultText = "헬스트레이닝 강좌1 은 매주 수요일 7시에서 8시 사이에 진행됩니다.";
        } else if(sendText.contains("강사")) {
            resultText = "강사 정보는 다음과 같습니다.\n이강사\n생활스포츠지도사 2급(보디빌딩)\n퍼스널 트레이닝 근무";
        } else if(sendText.contains("체력정보")) {
            resultText = "사용자님의 체력정보는 다음과 같습니다.\n앉았다 일어서기 18회\n2분 제자리 걷기 110회\n앞으로 굽히기 17cm";
        } else if(sendText.contains("테스트결과")) {
            resultText = "사용자님의 체력결과는 은상입니다.\n은상 기준은 다음과 같습니다.\n앉았다 일어서기 17회\n2분 제자리 걷기 106회\n앞으로 굽히기 16.1cm";
        } else {        // 그 외 입력
            resultText = "올바른 값을 입력해 주세요.";
        }
        ChattingTalkDataset chattingTalkDataset = new ChattingTalkDataset(R.drawable.trainer_profile_1, false,"이강사",resultText,"2020-12-11 16:22:00");
        return chattingTalkDataset;
    }

}
