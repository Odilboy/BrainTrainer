package com.example.odiljonergashev.braintrainer;


import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

   LinearLayout linearLayout;
   GridLayout answerVariantsGridLayout;
   Button playAgainButton, firstVariantButton, secondVariantButton, thirdVariantButton, fourthVariantButton;
   TextView timeCounterTextView, questionTextView, answerCounterTextView, wrongCorrectTextView;
   Random random;


   int questionCounter = 0, correctAnswerCounter = 0, correctAnswer, correctButton ;


    public void onClick(View view) {

        view.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
        answerVariantsGridLayout.setVisibility(View.VISIBLE);
        answerCounterTextView.setText(correctAnswerCounter + " / " + questionCounter);
        countTime();
        makeQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        answerVariantsGridLayout = findViewById(R.id.answerVariantsGridLayout);
        playAgainButton = findViewById(R.id.playAgainButton);
        timeCounterTextView = findViewById(R.id.timeCounterTextView);
        questionTextView = findViewById(R.id.questionTextView);
        answerCounterTextView = findViewById(R.id.answerCounterTextView);
        firstVariantButton = findViewById(R.id.firstVariantButton);
        secondVariantButton = findViewById(R.id.secondVariantButton);
        thirdVariantButton = findViewById(R.id.thirdVariantButton);
        fourthVariantButton = findViewById(R.id.fourthVariantButton);
        wrongCorrectTextView = findViewById(R.id.wrongOrCorrectTextView);
        random = new Random();

    }

    public void countTime()
    {
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timeCounterTextView.setText((millisUntilFinished / 1000) + "s");
            }

            public void onFinish() {
                wrongCorrectTextView.setText("Your score: " + correctAnswerCounter + " / " + questionCounter);
                timeCounterTextView.setText("0s");
                playAgainButton.setVisibility(View.VISIBLE);
                firstVariantButton.setEnabled(false);
                secondVariantButton.setEnabled(false);
                thirdVariantButton.setEnabled(false);
                fourthVariantButton.setEnabled(false);
            }
        }.start();
    }

    @RequiresApi()
    public void makeQuestion()
    {
        int firstNumber = random.nextInt(50);
        int secondNumber = random.nextInt(50);
        correctAnswer = firstNumber + secondNumber;
        questionTextView.setText(firstNumber + " + " + secondNumber);
        correctButton = random.nextInt(3-0+1)+0;

        if(correctButton == 0)
        {
            firstVariantButton.setText(String.valueOf(correctAnswer));
            secondVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
            thirdVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
            fourthVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
        } else if (correctButton == 1)
        {
            firstVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
            secondVariantButton.setText(String.valueOf(correctAnswer));
            thirdVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
            fourthVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
        } else if (correctButton == 2)
        {
            firstVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
            secondVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
            thirdVariantButton.setText(String.valueOf(correctAnswer));
            fourthVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
        } else if (correctButton == 3)
        {
            firstVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
            secondVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
            thirdVariantButton.setText(String.valueOf(random.nextInt(correctAnswer)));
            fourthVariantButton.setText(String.valueOf(correctAnswer));
        }
    }

    public void pressAnswerButton (View view)
    {
         if(new String(view.getResources().getResourceEntryName(view.getId())).equals("firstVariantButton") && correctButton == 0)
         {
             wrongCorrectTextView.setText("Correct");
             makeQuestion();
             questionCounter++;
             correctAnswerCounter++;
             answerCounterTextView.setText(correctAnswerCounter + " / " + questionCounter);
         } else if (new String(view.getResources().getResourceEntryName(view.getId())).equals("secondVariantButton") && correctButton == 1)
         {
             wrongCorrectTextView.setText("Correct");
             makeQuestion();
             questionCounter++;
             correctAnswerCounter++;
             answerCounterTextView.setText(correctAnswerCounter + " / " + questionCounter);
         } else if (new String(view.getResources().getResourceEntryName(view.getId())).equals("thirdVariantButton") && correctButton == 2)
         {
             wrongCorrectTextView.setText("Correct");
             makeQuestion();
             questionCounter++;
             correctAnswerCounter++;
             answerCounterTextView.setText(correctAnswerCounter + " / " + questionCounter);
         } else if (new String(view.getResources().getResourceEntryName(view.getId())).equals("fourthVariantButton") && correctButton == 3)
         {
             wrongCorrectTextView.setText("Correct");
             makeQuestion();
             questionCounter++;
             correctAnswerCounter++;
             answerCounterTextView.setText(correctAnswerCounter + " / " + questionCounter);
         } else
         {
             wrongCorrectTextView.setText("Wrong");
             makeQuestion();
             questionCounter++;
             answerCounterTextView.setText(correctAnswerCounter + " / " + questionCounter);
         }
    }
    public void playAgain(View view)
    {
        wrongCorrectTextView.setText(" ");
        answerCounterTextView.setText("0 / 0");
        questionCounter = 0;
        correctAnswerCounter = 0;
        countTime();
        makeQuestion();
        firstVariantButton.setEnabled(true);
        secondVariantButton.setEnabled(true);
        thirdVariantButton.setEnabled(true);
        fourthVariantButton.setEnabled(true);
        playAgainButton.setVisibility(View.INVISIBLE);
    }
}