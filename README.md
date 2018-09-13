# Process-Button-Android
Material Processing Button Library For Android

# Example
Colors,Button Text can be modified as you want

![Screenshot](https://i.imgur.com/sv3zkeF.gif)

# How to add to your app 

add this to your dependencies in build.gradle file
```
implementation 'com.github.Badranh:Process-Button-Android:0.1'
```
Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
# Usage
# XML:
```
<net.cryptobrewery.androidprocessingbutton.ProcessButton
        android:id="@+id/failure"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="20dp" />
```
# JAVA: 
```
ProcessButton btnFail;
boolean a = true;
btnFail = findViewById(R.id.failure);
   btnFail.setProgressActivated(false);
   btnFail.setIntepolator(ProcessButton.interpolators.INTERPOLATOR_LINEAR);
   btnFail.setMultipleProgressColors(new String[]{"#EF9812","#A323E1","#ABCDEF","#9ABEF1"});
   btnFail.setBtnBackgroundColor("#253031");
   btnFail.setBtnText("Click Me");
   btnFail.setBtnTextColor("#FFFFFF");
   btnFail.setFailureTxt("Failed!");
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
```
# Available Methods
| Methods | Description |
| --- | --- |
| playProgress() | Will Play the progress of the button |
| stopProgress() | Will Stop the progress of the button |
| setProgress(int progress) | Set the progress of button  |
| setIntepolator(interpolators TYPE) | you can choose different interpolators. Available Interpolators: <b>INTERPOLATOR_LINEAR</b> & <b>INTERPOLATOR_ACCELERATE</b> & <b>INTERPOLATOR_DECELERATE</b> & <b>INTERPOLATOR_ACCELERATEDECELERATE</b>  |
| setOnBtnClickListener(onClickListener onClickListener)| Button Click Listener  |
| setStartSpeed(float startSpeed) | Trivial,Will set the starting speed of progress of the button  |
| setIndeterminate(boolean isSetIndeterminate) |  should always be set as true !  |
| setSingleProgressColor(String Color) | Trivial |
| playReversed(boolean isReversed) | set the progress to play in reversed style |
| playMirrorMode(boolean isMirrored) |  set the progress to play in Mirror style |
| setProgressActivated(boolean isActivated) | You can initially set it to false if u don't want it to autoplay |
| setOnStartEndAnimationListener(onAnimationPhases mOnAnimationPhases) | Listener when the animation starts and ends |
| setProgressStrokeWidth(float width) | width of each section in progress |
| setProgressSeperatorLength(int length) |length of seperator between sections |
| setProgressSectionCount(int Count) | how many sections u want ur progress bar to be divided |
| setButtonState(state btnState) | There are 3 states u can change the button to : <b>SUCCESS</b> & <b>FAILURE</b> & <b>WARNING</b> refer to example and sample app in the repo |
| setBtnTextColor(String color) | Will change color of the text in the button ex: "#FFFFFF" |
| setBtnText(String Text) | Will change the text of the button |
| setBtnBackgroundColor(String color) | | Will change the backgroung color of the buttonn |
| setSuccessTxt(String successTxt) | Set Success Text That Appear when u change button state to <b>SUCCESS</b> |
| setFailureTxt(String failureTxt) | Set Failure Text That Appear when u change button state to <b>FAILURE</b> |
| setWarningTxt(String warningTxt) | Set Warning Text That Appear when u change button state to <b>WARNING</b> |

# LICENCE:
MIT

# Used Libraries: 

https://github.com/castorflex/SmoothProgressBar


