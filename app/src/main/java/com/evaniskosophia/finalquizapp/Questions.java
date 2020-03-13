package com.evaniskosophia.finalquizapp;

import com.google.gson.Gson;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Questions {
    private String question;
    private Boolean answer;
    private HashMap<String, Boolean> questions;

    public Questions()
    {
        questions = new HashMap<String, Boolean>();
        questions = makeMap();
        getRandQuestion();
        getQuestionsAnswer();
    }

    public HashMap<String, Boolean> makeMap(){
        questions.put("Puerto Rico is a U.S. territory", true);
        questions.put("cows only drink milk", false);
        questions.put("there are 5 f's in the phrase 'fluffy fellow failing'", true);
        questions.put("2 + 8 x 3 = 30", false);
        questions.put("a penny can kill someone when dropped off a tall building", false);
        questions.put("the sun rises in the east", true);
        questions.put("all rivers flow west", false);
        questions.put("Andromeda is the closest star to Earth", false);
        questions.put("lemons can cure cancer", false);
        questions.put("stars are just bright planets", false);
        questions.put("Russia has a larger area than pluto", true);
        questions.put("Texas is the biggest U.S. state", false);
        questions.put("all babies are born completely blind", false);
        questions.put("a right triangle can never be equilateral", true);
        questions.put("35 + 75 = 100", false);
        questions.put("R is located between E and T on a keyboard", true);
        return questions;
    }

    public void newQandA(){
        getRandQuestion();
        getQuestionsAnswer();
    }

    private void getRandQuestion(){
        Set qs = questions.keySet();
        int randint = (int)(Math.random()*qs.size()) + 1;
        int index = 0;
        String myq = "";
        for (String s: questions.keySet()) {
            if (index == randint)
                myq = s;
            index++;
        }
        question = myq;
    }

    private void getQuestionsAnswer(){
        Boolean mya = questions.get(question);
        answer = mya;
    }

    public String mapToString(){
        Gson gson = new Gson();
        return gson.toJson(questions);
    }

    public Boolean getAnswer() {
        return answer;
    }

    public String getQuestion(){
        return question;
    }
}
