package net.cryptobrewery.processingbuttonsample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import net.cryptobrewery.androidprocessingbutton.ProcessButton;

public class MainActivity extends AppCompatActivity {
ProcessButton btnFail,btnSuccess,btnWarn;
boolean a= true,b=true,c=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFail = findViewById(R.id.failure);
        btnFail.setProgressActivated(false);
        btnFail.setIntepolator(ProcessButton.interpolators.INTERPOLATOR_LINEAR);
        btnFail.setMultipleProgressColors(new String[]{"#EF9812","#A323E1","#ABCDEF","#9ABEF1"});
        btnFail.setBtnBackgroundColor("#253031");
        btnFail.setBtnText("Click Me");
        btnFail.setBtnTextColor("#FFFFFF");
        btnFail.setFailureTxt("Failed!");
        btnFail.playReversed(true);
        btnFail.setIndeterminate(true);
        btnFail.setOnBtnClickListener(new ProcessButton.onClickListener() {
            @Override
            public void onClick() {
                if(a) {
                    btnFail.playProgress();
                    a=false;
                }
                else {
                    btnFail.setButtonState(ProcessButton.state.FAILURE);
                    btnFail.stopProgress();
                    a=true;
                }
            }
        });

        btnFail.setOnStartEndAnimationListener(new ProcessButton.onAnimationPhases() {
            @Override
            public void onStart() {
                Toast.makeText(getBaseContext(),"started",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStop() {
                Toast.makeText(getBaseContext(),"stopped",Toast.LENGTH_LONG).show();

            }
        });

        //

        btnSuccess = findViewById(R.id.success);
        btnSuccess.setProgressActivated(false);
        btnSuccess.setIntepolator(ProcessButton.interpolators.INTERPOLATOR_ACCELERATEDECELERATE);
        btnSuccess.setMultipleProgressColors(new String[]{"#EFA32B","#000000","#FEDABC","#9ABEF1"});
        btnSuccess.setBtnBackgroundColor("#587291");
        btnSuccess.setBtnText("Click Me");
        btnSuccess.setBtnTextColor("#FFFFFF");
        btnSuccess.setSuccessTxt("Success!");
        btnSuccess.setIntepolator(ProcessButton.interpolators.INTERPOLATOR_ACCELERATE);
        btnSuccess.setIndeterminate(true);
        btnSuccess.playMirrorMode(true);
        btnSuccess.setOnBtnClickListener(new ProcessButton.onClickListener() {
            @Override
            public void onClick() {
                if(b) {
                    btnSuccess.playProgress();
                    b=false;
                }
                else {
                    btnSuccess.setButtonState(ProcessButton.state.SUCCESS);
                    btnSuccess.stopProgress();
                    b=true;
                }
            }
        });

        //

        btnWarn = findViewById(R.id.Warning);
        btnWarn.setProgressActivated(false);
        btnWarn.setIntepolator(ProcessButton.interpolators.INTERPOLATOR_ACCELERATEDECELERATE);
        btnWarn.setMultipleProgressColors(new String[]{"#ABEDEF","#123BEF","#BCD358","#9AB34C"});
        btnWarn.setBtnBackgroundColor("#2F97C1");
        btnWarn.setBtnText("Click Me");
        btnWarn.setBtnTextColor("#FFFFFF");
        btnWarn.setSuccessTxt("Success!");
        btnWarn.setIntepolator(ProcessButton.interpolators.INTERPOLATOR_ACCELERATEDECELERATE);
        btnWarn.setIndeterminate(true);

        btnWarn.setOnBtnClickListener(new ProcessButton.onClickListener() {
            @Override
            public void onClick() {
                if(c) {
                    btnWarn.playProgress();
                    c=false;
                }
                else {
                    btnWarn.setButtonState(ProcessButton.state.WARNING);
                    btnWarn.stopProgress();
                    c=true;
                }
            }
        });

    }
}
