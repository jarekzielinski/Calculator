package pl.java.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void keyClicked(View view) {
        Button button=(Button) view;
        String key=button.getText().toString();
        TextView textview=(TextView) findViewById(R.id.textView);
        textview.setText(textview.getText().toString()+key);
    }
}
