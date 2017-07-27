package pl.lukaszkolacz.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView textViewQuestion;
    Quiz quiz;
//    Question question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);

        findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNext();
            }
        });

        if (getIntent().hasExtra("quiz")) {
            quiz = Parcels.unwrap(getIntent().getParcelableExtra("quiz"));
        } else {
            initQuiz();
        }

        setQuestion(quiz.questions.get(quiz.answersSoFar));
    }

    private void initQuiz() {
        quiz = new Quiz();
        Question question = new Question(getString(R.string.question_one));
        question.answers.add(new Answer(getString(R.string.answer_one), false));
        question.answers.add(new Answer(getString(R.string.answer_two), false));
        question.answers.add(new Answer(getString(R.string.answer_three), false));
        question.answers.add(new Answer(getString(R.string.answer_four), true));
        quiz.questions.add(question);

        question = new Question(getString(R.string.question_two));
        question.answers.add(new Answer(getString(R.string.answer_two_one), true));
        question.answers.add(new Answer(getString(R.string.answer_two_two), false));
        question.answers.add(new Answer(getString(R.string.answer_two_three), false));
        question.answers.add(new Answer(getString(R.string.answer_two_four), false));
        quiz.questions.add(question);
    }

    private void setQuestion(Question question) {
        textViewQuestion.setText(question.text);
        for (Answer answer : question.answers) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(answer.text);
            radioGroup.addView(radioButton);
        }
    }

    private int getSelectedIndex() {
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        return radioGroup.indexOfChild(radioButton);
    }


    public void onClickNext() {
        if (quiz.questions.get(quiz.answersSoFar).answers.get(getSelectedIndex()).isCorrect) {
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            quiz.correctAnswers++;
        } else {
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
        }
        quiz.answersSoFar++;
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("quiz", Parcels.wrap(quiz));
        startActivity(intent);
    }
}
