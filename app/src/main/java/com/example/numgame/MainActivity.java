package com.example.numgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // View
    private TextView  mTextView;
    private Button    mButton;
    private EditText  mEditText;
    private ImageView mImageView;

    // Int
    private int mUserNum;
    private int mRandomNum;
    private int mCount=0;

    // Random
    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRandom = new Random();
        mRandomNum = mRandom.nextInt(100)+1;

        mButton    = findViewById(R.id.button);
        mTextView  = findViewById(R.id.textView);
        mEditText  = findViewById(R.id.editText);
        mImageView = findViewById(R.id.imageView1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCount += 1;

                mUserNum = Integer.parseInt(mEditText.getText().toString());
                if (mUserNum>mRandomNum) {
                    mTextView.setText(mUserNum + "보다 작습니다. " + mCount + "번 시도했습니다.");
                } else if (mUserNum<mRandomNum) {
                    mTextView.setText(mUserNum + "보다 큽니다. " + mCount + "번 시도했습니다.");
                } else {
                    mTextView.setText("정답입니다! " + mCount + "번 만에 맞췄습니다!\n축하드립니다! 윤배공주와 결혼할 기회를 얻으셨습니다!");
                    mImageView.setImageResource(R.drawable.yoonbae);
                }
                mEditText.setText("");

            }
        });

    }
}