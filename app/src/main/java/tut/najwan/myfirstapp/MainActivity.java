package tut.najwan.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView greetingTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingTextView = findViewById(R.id.greeting);

        //Calc. Button
        //Attempt to launch an activity within our own app
        Button calcBtn =  findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calcIntent = new Intent(getApplicationContext(),CalcActivity.class);
                calcIntent.putExtra("KeyIntent","Intent works");
                startActivity(calcIntent); //Launch other Activity : CalcActivity
            }
        });

        //Google Search Button
        //Attempt to launch activity outside our app: Run Google
        Button googleBtn =  findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webAddress = Uri.parse(google);

                Intent gotoGoogleIntent = new Intent(Intent.ACTION_VIEW,webAddress); // Who`s ready to handle this activity
                //if there is some app at the device that can handle this activity, give it to me
                if(gotoGoogleIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoGoogleIntent);
                }
            }
        });


    }



    //For Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.activity_main,menu);
      return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_bye){
            greetingTextView.setText(R.string.say_bye);
            finish();
            System.exit(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
