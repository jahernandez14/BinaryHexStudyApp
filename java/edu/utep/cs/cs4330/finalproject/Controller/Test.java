package edu.utep.cs.cs4330.finalproject.Controller;

import android.util.Log;

import java.util.Random;

import edu.utep.cs.cs4330.finalproject.Model.QuizInfo;
import static edu.utep.cs.cs4330.finalproject.Controller.Conversion.easy;

public class Test{
    private static QuizInfo question;
    private static char[] hexSet = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    private static QuizInfo randomHex(int difficulty){
        QuizInfo qInfo = new QuizInfo();
        Random rand = new Random();
        String hex = "";
        int len = 0;
        if(difficulty ==1){
            len = 2;
        }
        else{
            len = 4;
        }
        for(int i = 0; i < len; i++){
            hex += hexSet[rand.nextInt(16)];
        }
        qInfo.setType(true);
        qInfo.setQuestion(hex);
        qInfo.setAnswer(easy(hex,false));

        return qInfo;
    }

    private static QuizInfo randomBin(int difficulty){
        QuizInfo qInfo = new QuizInfo();
        String bin = "";
        int len = 0;
        Random rand = new Random();
        if(difficulty ==1){
            len = 32;
        }
        else{
            len = 256;
        }
        int answer = rand.nextInt(len);
        bin = Integer.toBinaryString(answer);
        qInfo.setType(true);
        qInfo.setQuestion(bin);
        qInfo.setAnswer(Integer.toString(answer));

        return qInfo;
    }


    public static QuizInfo questionGen(int difficulty){
        if (difficulty == 1) {
            question = randomBin(difficulty);
        }
        if(difficulty == 2){
            question = randomHex(difficulty);
        }
        if(difficulty == 3) {
            Random rand = new Random();
            int randQ = rand.nextInt(2);
            if(randQ == 0){
                question = randomBin(difficulty);
            }
            else{
                question = randomHex(difficulty);
            }
        }

        return question;
    }
}
