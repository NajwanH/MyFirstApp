package tut.najwan.myfirstapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText num1TextView;
    private EditText num2TextView;
    private Button addBtn;
    private int result;
    private  int num1;
    private int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        if(getIntent().hasExtra("KeyIntent")) {
            calculateNum();
            String intentText = getIntent().getExtras().getString("KeyIntent");
            Context context = getApplicationContext();
            Toast intentToast = Toast.makeText(context,intentText,Toast.LENGTH_SHORT);
            intentToast.show();
        }
    }
    private void calculateNum() {
        resultTextView =  findViewById(R.id.resultTextView);
        num1TextView   =  findViewById(R.id.num1EditText);
        num2TextView  =  findViewById(R.id.num2EditText);
        addBtn =  findViewById(R.id.addButton);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try{
                        num1 = Integer.parseInt( num1TextView.getText().toString());
                        num2 = Integer.parseInt( num2TextView.getText().toString());
                        result = num1 + num2 ;
                        resultTextView.setText(result+"");

                    }catch (Exception  e) {
                        e.getMessage();
                        Context context = getApplicationContext();
                        CharSequence text = "Please enter a number,after change";
                        Toast toast = Toast.makeText(context, text,  Toast.LENGTH_SHORT);
                        toast.show();
                    }


            }
        });

    }
}
