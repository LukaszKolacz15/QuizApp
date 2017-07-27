package pl.lukaszkolacz.quizapp;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Lukasz Kolacz on 24.07.2017.
 */

@Parcel
public class Quiz {
    public ArrayList<Question> questions = new ArrayList<>();
    public int allQuestions;
    public int correctAnswers;
    public int answersSoFar = 0;
}
