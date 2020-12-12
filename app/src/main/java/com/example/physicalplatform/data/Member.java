package com.example.physicalplatform.data;

import android.content.Intent;

public class Member {
    String name;
    String pwd;
    String email;
    String registrationNumber;
    String height;
    String weight;
    String score;
    String location;

    public Member(String name, String pwd, String email, String registrationNumber, String height, String weight, String score, String location) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.registrationNumber = registrationNumber;
        this.height = height;
        this.weight = weight;
        this.score = score;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getScore() {
        return score;
    }

    public String getLocation() {
        return location;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBMI(){
        double bmi = Double.parseDouble( weight ) / ( Double.parseDouble( height )  * Double.parseDouble( height )  * 0.0001 );
        if( bmi >= 35 ){
            return "3단계비만";
        }else if( bmi >= 30 ){
            return "2단계비만";
        }else if( bmi >= 25 ){
            return "1단계비만";
        }else if( bmi >= 23 ){
            return "비만전단계비만";
        }else if( bmi >= 18.5 ){
            return "정상";
        }else{
            return "저체중";
        }
    }

    public int getAge(){
        String[] tmp = getRegistrationNumber().split("-");
        int tmp2 = Integer.parseInt(tmp[0].substring(0, 2));

        return 100 - tmp2 + 20 + 1;
    }

    public String getGender(){
        String[] tmp = getRegistrationNumber().split("-");
        if( tmp[1] == "1" ){
            return "M";
        }else{
            return "F";
        }
    }

    public String getKey(){
        String result = "";

        int age = getAge();
        if ( age >= 70 ){
            result += "70대";
        }else if(age >= 60){
            result += "60대";
        }else{
            result += "50대";
        }

        result += "/" + getBMI() + "/" + getGender() + "/" + getScore() + "/";

        return result;
    }

}
