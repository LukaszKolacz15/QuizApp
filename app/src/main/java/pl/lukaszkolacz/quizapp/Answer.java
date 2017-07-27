package pl.lukaszkolacz.quizapp;

import org.parceler.Parcel;

/**
 * Created by Lukasz Kolacz on 24.07.2017.
 */

@Parcel
class Answer {
    public String text;
    public boolean isCorrect;

    public Answer() {
    }

    public Answer(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }
}
