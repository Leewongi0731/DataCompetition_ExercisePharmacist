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
        if(sendText.contains("관절염")) {
            resultText = "네 저희 강좌 커리큘럼에는 관절염을 위한 근력운동이 포함되어 있어서 가능하실 것 같습니다!";
        } else if(sendText.contains("강사")) {
            resultText = "네 저는 생활스포츠지도사 2급(보디빌딩), 퍼스널 트레이닝 짐 근무경험이 있습니다.";
        } else if(sendText.contains("송파구")) {
            resultText = "그러면 홈 트레이닝 신청가능합니다!";
        } else if(sendText.contains("알겠습니다")) {
            resultText = "또 궁금한 사항 있으시면 연락주세요!";
        }
        ChattingTalkDataset chattingTalkDataset = new ChattingTalkDataset(R.drawable.trainer_profile_1, false,"이강사",resultText,"2020-12-11 16:22:00");
        return chattingTalkDataset;
    }

}
