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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nuraffchaniago.kidsquiz.Model.QuestinWord;

import java.util.Collections;
import java.util.List;

public class QuizWordActivity extends AppCompatActivity {
    
    private TextView textViewQuestionCount;
    private TextView textViewScore;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private TextView textViewQuestion;
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;
    private Button buttonConfirmNext;
    private Button buttonRight;
    private Button buttonWrong;

    private List<QuestinWord> questionListWord;
    private ColorStateList textColorDefaultRb;
    private int questionCounter;
    private int questionCountTotal;
    private QuestinWord currentQuestion;

    private int score;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_word);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewQuestion = findViewById(R.id.text_view_question);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewScore = findViewById(R.id.text_view_score);
        cardView1 = findViewById(R.id.card_view1);
        cardView2 = findViewById(R.id.card_view2);
        cardView3 = findViewById(R.id.card_view3);
        cardView4 = findViewById(R.id.card_view4);
        buttonRight = findViewById(R.id.btn_right);
        buttonWrong = findViewById(R.id.btn_wrong);
        iv1 = findViewById(R.id.image_view1);
        iv2 = findViewById(R.id.image_view2);
        iv3 = findViewById(R.id.image_view3);
        iv4 = findViewById(R.id.image_view4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        // Play Audio
        AudioPlay.playAudio(QuizWordActivity.this, R.raw.abcsong);

        //getQuestion
        final QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionListWord = dbHelper.getAllQuestionsWord();
        questionCountTotal = 5;
        Collections.shuffle(questionListWord);

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
                    AudioPlayNotLoop.playAudio(QuizWordActivity.this, R.raw.correctanswer);
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
                    AudioPlayNotLoop.playAudio(QuizWordActivity.this, R.raw.correctanswer);
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
                    AudioPlayNotLoop.playAudio(QuizWordActivity.this, R.raw.correctanswer);
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
                    AudioPlayNotLoop.playAudio(QuizWordActivity.this, R.raw.correctanswer);
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

    private void showNextQuestion() {
        if(questionCounter < questionCountTotal) {

            cardView1.setCardBackgroundColor(Color.WHITE);
            cardView2.setCardBackgroundColor(Color.WHITE);
            cardView3.setCardBackgroundColor(Color.WHITE);
            cardView4.setCardBackgroundColor(Color.WHITE);

            currentQuestion = questionListWord.get(questionCounter);

            buttonConfirmNext.setVisibility(View.GONE);
            buttonRight.setVisibility(View.GONE);
            buttonWrong.setVisibility(View.GONE);
            textViewQuestion.setText(currentQuestion.getQuestion());
            String uri = "drawable/"+currentQuestion.getOption1();  // where myresource (without the extension) is the file
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);

            // iv1.setImageDrawable(res);
            Glide.with(this)
                    .load(res)
                    .override(150, 100)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(iv1);
            String uri2 = "drawable/"+currentQuestion.getOption2();  // where myresource (without the extension) is the file
            int imageResource2 = getResources().getIdentifier(uri2, null, getPackageName());
            Drawable res2 = getResources().getDrawable(imageResource2);
            // iv2.setImageDrawable(res2);
            Glide.with(this)
                    .load(res2)
                    .override(150, 100)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(iv2);
            String uri3 = "drawable/"+currentQuestion.getOption3();  // where myresource (without the extension) is the file
            int imageResource3 = getResources().getIdentifier(uri3, null, getPackageName());
            Drawable res3 = getResources().getDrawable(imageResource3);
            //iv3.setImageDrawable(res3);
            Glide.with(this)
                    .load(res3)
                    .override(150, 100)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(iv3);

            String urilast = "drawable/"+currentQuestion.getOption4();  // where myresource (without the extension) is the file
            int imageResourcelast = getResources().getIdentifier(urilast, null, getPackageName());
            Drawable reslast = getResources().getDrawable(imageResourcelast);
            //iv4.setImageDrawable(reslast);
            Glide.with(this)
                    .load(reslast)
                    .override(150, 100)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(iv4);

            questionCounter++;
            textViewQuestionCount.setText("Question :" + questionCounter + "/" + questionCountTotal);


        }
        else {
            finishQuiz();
        }

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
        
        if(questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        }
        else {
            buttonConfirmNext.setText("Finish");
        }
    }


    @Override
    public void onBackPressed() {
        AudioPlay.isplayingAudio = false;
        Intent moveToCat = new Intent(QuizWordActivity.this, CategoryQuizActivity.class);
        startActivity(moveToCat);
    }


    private void finishQuiz() {
        final int scorequiz = score;
        AudioPlay.stopAudio();
        Intent movetoscore = new Intent(QuizWordActivity.this, ScoreActivity.class);
        movetoscore.putExtra(ScoreActivity.EXTRA_SCORE, scorequiz);
        startActivity(movetoscore);

        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy:quizword ");
    }
}
