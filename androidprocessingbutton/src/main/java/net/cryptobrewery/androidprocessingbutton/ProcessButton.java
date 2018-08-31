package net.cryptobrewery.androidprocessingbutton;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable;

public class ProcessButton extends RelativeLayout {
    LayoutInflater mInflater;

    private String btnText="Button";
    private String bgColor="#ABEABE";
    private String SuccessTxt="Success";
    private String FailureTxt="Failed";
    private String WarningTxt="Warning";
    private SmoothProgressBar mSmoothProgressBar;
    private Button btn;
    private onClickListener mOnClickListener;
    private onAnimationPhases mOnAnimationPhases;

    public ProcessButton(Context context) {
        super(context);
        init(context);

    }

    public ProcessButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public enum interpolators{
        INTERPOLATOR_ACCELERATE,INTERPOLATOR_LINEAR,INTERPOLATOR_ACCELERATEDECELERATE,INTERPOLATOR_DECELERATE
    }
    public enum state{
        SUCCESS,FAILURE,WARNING
    }
    public interface onClickListener{
         void onClick();
    }

    public interface  onAnimationPhases{
        void onStart();
        void onStop();
    }


    private void init(Context context) {
       inflate(context,R.layout.process_button,this);
        mSmoothProgressBar = findViewById(R.id.progress_bar);
        btn = findViewById(R.id.fButton);

    }

    public void playProgress(){

        setBtnBackgroundColor(bgColor);
        setBtnText(btnText);
        if(mOnAnimationPhases!=null)
            mOnAnimationPhases.onStart();
        mSmoothProgressBar.progressiveStart();
    }

    public void stopProgress(){
        if(mOnAnimationPhases !=null)
            mOnAnimationPhases.onStop();

        mSmoothProgressBar.progressiveStop();
    }

    public void setProgress(int progress){
        mSmoothProgressBar.setProgress(progress);
    }

    public void setIntepolator(interpolators TYPE) throws RuntimeException {
        switch (TYPE){
            case INTERPOLATOR_LINEAR:
                mSmoothProgressBar.setInterpolator(new LinearInterpolator());
                break;
            case INTERPOLATOR_ACCELERATE:
                mSmoothProgressBar.setInterpolator(new AccelerateInterpolator());
                break;
            case INTERPOLATOR_DECELERATE:
                mSmoothProgressBar.setInterpolator(new DecelerateInterpolator());
                break;
            case INTERPOLATOR_ACCELERATEDECELERATE:
                mSmoothProgressBar.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            default:
                throw new RuntimeException("INVALID INTERPOLATOR TYPE");
        }
    }

    public void setOnBtnClickListener(final onClickListener onClickListener){
        mOnClickListener = onClickListener;
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick();
            }
        });
    }

    public  void setStartSpeed(float startSpeed){
        mSmoothProgressBar.setSmoothProgressDrawableProgressiveStopSpeed(startSpeed);
    }

    public void setStopSpeed(float stopSpeed){
        mSmoothProgressBar.setSmoothProgressDrawableProgressiveStopSpeed(stopSpeed);
    }

   public void setIndeterminate(boolean isSetIndeterminate){
        mSmoothProgressBar.setIndeterminate(isSetIndeterminate);
   }

   public void setSingleProgressColor(String Color){
       mSmoothProgressBar.setSmoothProgressDrawableColor(android.graphics.Color.parseColor(Color));
   }

   public void setMultipleProgressColors(String[] Colors){
       int [] Colorsint=new int[Colors.length];
       int i = 0;
       for(String color : Colors){
           Colorsint[i]=Color.parseColor(color);
        i++;
       }
       if(Colorsint.length == 0){
           setSingleProgressColor("#000000");
       }
       mSmoothProgressBar.setSmoothProgressDrawableColors(Colorsint);
   }


   public void playReversed(boolean isReversed){
       mSmoothProgressBar.setSmoothProgressDrawableReversed(isReversed);
   }

   public void playMirrorMode(boolean isMirrored){
       mSmoothProgressBar.setSmoothProgressDrawableMirrorMode(isMirrored);

   }

   public void setProgressActivated(boolean isActivated){
       if(isActivated){
           mSmoothProgressBar.setProgressiveStartActivated(true);
           mSmoothProgressBar.progressiveStart();
       }else{
           mSmoothProgressBar.setProgressiveStartActivated(false);
           mSmoothProgressBar.progressiveStop();
       }
   }

   public void setOnProgressFinishListener(SmoothProgressDrawable.Callbacks callbacks){
       mSmoothProgressBar.setSmoothProgressDrawableCallbacks(callbacks);

   }

   public void setOnStartEndAnimationListener(onAnimationPhases mOnAnimationPhases){
       this.mOnAnimationPhases = mOnAnimationPhases;
   }

   public void setProgressStrokeWidth(float width){
       mSmoothProgressBar.setSmoothProgressDrawableStrokeWidth(width);
   }

   public void setProgressSeperatorLength(int length){
       mSmoothProgressBar.setSmoothProgressDrawableSeparatorLength(length);
   }

   public void setProgressSectionCount(int Count){
       mSmoothProgressBar.setSmoothProgressDrawableSectionsCount(Count);
   }

   public void setButtonState(state btnState){
       switch (btnState){
           case SUCCESS:
               btn.setText(SuccessTxt);
               btn.setBackgroundColor(Color.parseColor("#5cb85c"));
               mSmoothProgressBar.setBackgroundColor(darken(Color.parseColor("#5cb85c"),0.1));
               break;
           case FAILURE:
               btn.setText(FailureTxt);
               btn.setBackgroundColor(Color.parseColor("#d9534f"));
               mSmoothProgressBar.setBackgroundColor(darken(Color.parseColor("#d9534f"),0.1));

               break;
           case WARNING:
               btn.setText(WarningTxt);
               btn.setBackgroundColor(Color.parseColor("#fd7e14"));
               mSmoothProgressBar.setBackgroundColor(darken(Color.parseColor("#fd7e14"),0.1));
               break;
       }
   }
    public void setBtnTextColor(String color){
       btn.setTextColor(Color.parseColor(color));
    }

    public void setBtnText(String Text){
        btn.setText(Text);
        btnText = Text;
    }

    public void setBtnBackgroundColor(String color){
        if(color!=null) {
            bgColor = color;
            btn.setBackgroundColor(Color.parseColor(color));
            mSmoothProgressBar.setBackgroundColor(darken(Color.parseColor(color), 0.1));
        }
    }

    private  int darken(int color, double fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        red = darkenColor(red, fraction);
        green = darkenColor(green, fraction);
        blue = darkenColor(blue, fraction);
        int alpha = Color.alpha(color);

        return Color.argb(alpha, red, green, blue);
    }
    private static int darkenColor(int color, double fraction) {
        return (int)Math.max(color - (color * fraction), 0);
    }

    public void setSuccessTxt(String successTxt) {
        SuccessTxt = successTxt;
    }

    public void setFailureTxt(String failureTxt) {
        FailureTxt = failureTxt;
    }

    public void setWarningTxt(String warningTxt) {
        WarningTxt = warningTxt;
    }
}
