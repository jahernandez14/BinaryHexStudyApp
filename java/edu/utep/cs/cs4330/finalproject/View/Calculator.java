package edu.utep.cs.cs4330.finalproject.View;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import edu.utep.cs.cs4330.finalproject.R;
import static edu.utep.cs.cs4330.finalproject.Controller.Conversion.easy;

public class Calculator extends AppCompatActivity {
    private TextView input, ans;
    private Boolean response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        Spinner dropdown = findViewById(R.id.drop);
        input = findViewById(R.id.input);
        String[] items = new String[]{"Binary", "Hex"};
        ans = findViewById(R.id.ans);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position == 0) {
                    response = true;
                }
                if(position == 1) {
                    response = false;
                }
                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                       String result = easy(input.getText().toString(),response);
                       if(result.equals("-1")){
                           ans.setText("");
                           Toast.makeText(getBaseContext(),"Please enter a valid number",Toast.LENGTH_LONG).show();
                       }
                       else{
                            ans.setText(result);
                       }
                        InputMethodManager inputManager = (InputMethodManager)
                                getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);

                        input.setText("");
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
    }
}

