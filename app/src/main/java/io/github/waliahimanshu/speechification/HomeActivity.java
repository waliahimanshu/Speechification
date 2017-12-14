package io.github.waliahimanshu.speechification;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.fab) FloatingActionButton recordActionButton;
    @BindView(R.id.fab1) FloatingActionButton fab1;
    @BindView(R.id.fab_1_menu) TextView mTextView1;
    @BindView(R.id.fab2) FloatingActionButton fab2;
    @BindView(R.id.fab_2_menu) TextView mTextView2;


    private boolean isFabOpen  = false;
    private Animation mAnimation_fab_open;
    private Animation mAnimation_fab_close;
    private Animation mAnimation1_Fab_rotate;
    private Animation mAnimation2_fab_rotate_back;

    @OnClick(R.id.fab)
    public void onRecord(){
//        startActivity(AudioRecordingActivity.getIntent(getBaseContext()));
//        overridePendingTransition(R.anim.right_in, R.anim.left_out);

        animateFab();


    }

    private void animateFab() {
        if(isFabOpen){

            recordActionButton.startAnimation(mAnimation2_fab_rotate_back);
            fab1.startAnimation(mAnimation_fab_close);
            mTextView1.startAnimation(mAnimation_fab_close);
            fab2.startAnimation(mAnimation_fab_close);
            mTextView2.startAnimation(mAnimation_fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;

        } else {

            recordActionButton.startAnimation(mAnimation1_Fab_rotate);
            fab1.startAnimation(mAnimation_fab_open);
            mTextView1.startAnimation(mAnimation_fab_open);
            fab2.startAnimation(mAnimation_fab_open);
            mTextView2.startAnimation(mAnimation_fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;

        }
    }

    public static Intent getIntent(Context baseContext) {
        return new Intent(baseContext, HomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAnimation_fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        mAnimation_fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        mAnimation1_Fab_rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_main_fab);
        mAnimation2_fab_rotate_back = AnimationUtils.loadAnimation(this, R.anim.rotate_back_main_fab);

    }
}
