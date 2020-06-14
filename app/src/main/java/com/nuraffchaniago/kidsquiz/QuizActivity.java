package com.nuraffchaniago.kidsquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewQuestionCount;
    private TextView textViewScore;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private ImageView imageViewQuestion;
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;
    private Button buttonConfirmNext;
    private Button buttonRight;
    private Button buttonWrong;

    private List<Question2> questionList;
    private ColorStateList textColorDefaultRb;
    private int questionCounter;
    private int questionCountTotal;
    private Question2 currentQuestion;

    private int score;
    private boolean answered;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        AudioPlay.playAudio(QuizActivity.this, R.raw.twinkletwinklelittlestar);

        textViewQuestion = findViewById(R.id.text_view_question);
        imageViewQuestion = findViewById(R.id.image_view_question);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewScore = findViewById(R.id.text_view_score);
        cardView1 = findViewById(R.id.card_view1);
        cardView2 = findViewById(R.id.card_view2);
        cardView3 = findViewById(R.id.card_view3);
        cardView4 = findViewById(R.id.card_view4);
        buttonRight = findViewById(R.id.btn_right);
        buttonWrong = findViewById(R.id.btn_wrong);
        tv1 = findViewById(R.id.text_view1);
        tv2 = findViewById(R.id.text_view2);
        tv3 = findViewById(R.id.text_view3);
        tv4 = findViewById(R.id.text_view4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);
        final QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = 10;
        Collections.shuffle(questionList);



        showNextQuestion();


        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showNextQuestion();
            }
        });

        //CardView onClick
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int answerNr = 1;
                if (answerNr == currentQuestion.getAnswerNr()) {
                    score=score+10;
                    textViewScore.setText("Score: " + score);
                    AudioPlayNotLoop.playAudio(QuizActivity.this, R.raw.correctanswer);
                    buttonRight.setVisibility(View.VISIBLE);
                    buttonRight.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showNextQuestion();
                        }
                    });
                }

                else {
                    buttonWrong.setVisibility(View.VISIBLE);
                    buttonWrong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showNextQuestion();
                        }
                    });
                }

                showSolution();

            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int answerNr = 2;
                if (answerNr == currentQuestion.getAnswerNr()) {
                    score=score+10;
                    textViewScore.setText("Score: " + score);
                    AudioPlayNotLoop.playAudio(QuizActivity.this, R.raw.correctanswer);
                    buttonRight.setVisibility(View.VISIBLE);
                    buttonRight.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showNextQuestion();
                        }
                    });

                }

                else {
                    buttonWrong.setVisibility(View.VISIBLE);
                    buttonWrong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showNextQuestion();
                        }
                    });
                }

                showSolution();

            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int answerNr = 3;
                if (answerNr == currentQuestion.getAnswerNr()) {
                    score=score+10;
                    textViewScore.setText("Score: " + score);
                    AudioPlayNotLoop.playAudio(QuizActivity.this, R.raw.correctanswer);
                    buttonRight.setVisibility(View.VISIBLE);
                    buttonRight.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showNextQuestion();
                        }
                    });
                }

                else {
                    buttonWrong.setVisibility(View.VISIBLE);
                    buttonWrong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showNextQuestion();
                        }
                    });
                }

                showSolution();

            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int answerNr = 4;
                if (answerNr == currentQuestion.getAnswerNr()) {
                    score=score+10;
                    textViewScore.setText("Score: " + score);
                    AudioPlayNotLoop.playAudio(QuizActivity.this, R.raw.correctanswer);
                    buttonRight.setVisibility(View.VISIBLE);
                    buttonRight.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showNextQuestion();
                        }
                    });
                }

                else {
                    buttonWrong.setVisibility(View.VISIBLE);
                    buttonWrong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showNextQuestion();
                        }
                    });
                }

                showSolution();

            }
        });




    }

    private void showSolution() {

        cardView1.setCardBackgroundColor(Color.RED);
        cardView2.setCardBackgroundColor(Color.RED);
        cardView3.setCardBackgroundColor(Color.RED);
        cardView4.setCardBackgroundColor(Color.RED);


        switch (currentQuestion.getAnswerNr()) {
            case 1:
                cardView1.setCardBackgroundColor(Color.GREEN);
                break;
            case 2:
                cardView2.setCardBackgroundColor(Color.GREEN);
                break;
            case 3:
                cardView3.setCardBackgroundColor(Color.GREEN);
                break;
            case 4:
                cardView4.setCardBackgroundColor(Color.GREEN);
                break;
        }

        buttonConfirmNext.setVisibility(View.VISIBLE);

        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish");
        }
    }


    private void showNextQuestion() {



        if(questionCounter < questionCountTotal) {

            cardView1.setCardBackgroundColor(Color.WHITE);
            cardView2.setCardBackgroundColor(Color.WHITE);
            cardView3.setCardBackgroundColor(Color.WHITE);
            cardView4.setCardBackgroundColor(Color.WHITE);

            currentQuestion = questionList.get(questionCounter);
            textViewQuestion.setVisibility(View.GONE);
            imageViewQuestion.setVisibility(View.VISIBLE);
            buttonConfirmNext.setVisibility(View.GONE);
            buttonRight.setVisibility(View.GONE);
            buttonWrong.setVisibility(View.GONE);
            /*Glide.with(this)
                    .load(myImage)
                    .override(250, 200)
                    .into(imageViewQuestion);*/
            tv1.setText(currentQuestion.getOption1());
            String uri = "drawable/"+currentQuestion.getQuestionImage();  // where myresource (without the extension) is the file
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            imageViewQuestion.setImageDrawable(res);
            tv2.setText(currentQuestion.getOption2());
            tv3.setText(currentQuestion.getOption3());
            tv4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question :" + questionCounter + "/" + questionCountTotal);
            answered =  false;

        }
        else {
            finishQuiz();
        }


    }




    @Override
    public void onBackPressed() {
        AudioPlay.isplayingAudio = false;
        Intent moveToCat = new Intent(QuizActivity.this, CategoryQuizActivity.class);
        startActivity(moveToCat);
    }

    private void finishQuiz() {
        final int scorequiz = score;
        AudioPlay.stopAudio();
        Intent movetoscore = new Intent(QuizActivity.this, ScoreActivity.class);
        movetoscore.putExtra(ScoreActivity.EXTRA_SCORE, scorequiz);
        startActivity(movetoscore);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy: quiz");
    }
}

