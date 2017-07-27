package pl.lukaszkolacz.quizapp;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Lukasz Kolacz on 24.07.2017.
 */

@Parcel
public class Question {
    public String text;
    public ArrayList<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(String text) {
        this.text = text;
    }

    public Question(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
