package edu.illinois.cs465.myquizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    //Declare TextView
    private TextView RevealAnswer;

    //Declare
    public static String ACTIVITY_RETURN_MESSAGE = "ACTIVITY_MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String getResult = getIntent().getStringExtra("get_answer");
        RevealAnswer = (TextView) findViewById(R.id.reveal_answer);
        RevealAnswer.setText(getResult +"!");

        /******* For Step 3-1: display the back button on the action bar **/
         getActionBar().setDisplayHomeAsUpEnabled(true);

        /*****************
         * For Step 3-3
         * Assign the return message "They really don't!"
         * to string label = "return_message"
         * *****************************************************/
        Intent intent= new Intent();
        intent.putExtra( "return_message", "They really don't!");
        setResult(RESULT_OK,intent);




    }
    /******* For Step 3-1:  display the back button on the action bar **/
    @Override
    public boolean onNavigateUp(){
        finish(); return true;
    }

}
