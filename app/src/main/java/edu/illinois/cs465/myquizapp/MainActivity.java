package edu.illinois.cs465.myquizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
//import Intent package
import android.content.Intent;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;

    //Declare request code
    public static final int COMPLETE_ANSWER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(this);

        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.false_button) {
            /************ Modify here for Step 2-2
             *   Goal: send the text "Correct Answer. Congratulation!" to SecondActivity
             *   initiate an intent connecting to SecondActivity
             *   put extra data with the intent using label "get_answer"
             ***************************************************/
            Intent intent= new Intent(this, SecondActivity.class );
            intent.putExtra("get_answer", "Correct Answer");
            startActivity(intent);

        } else if (v.getId() == R.id.true_button) {
            Intent intent= new Intent(this, SecondActivity.class );
            intent.putExtra("get_answer", "Incorrect answer!");

            /************ Modify here for Step 3 - 2
             *   Goal: Start activity that gets a result back from
             *   SecondActivity when it ends.
             *   Use COMPLETE_ANSWER as the requestCode
             ***************************************************/
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if (requestCode==COMPLETE_ANSWER){
            if(resultCode== RESULT_OK)
            {
                String s= intent.getStringExtra("return_message");
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            }
        }

    }
}

