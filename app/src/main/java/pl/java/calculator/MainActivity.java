package pl.java.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String display="0";
    private double acumulator=0.0;
    private Operation currentOperation=Operation.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void keyClicked(View view) {
        Button button=(Button) view;
        String key=button.getText().toString();
        TextView textview=(TextView) findViewById(R.id.textView);


        switch (key){
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if(display.equals("0"))
                    display="";
                display+=key;
                break;
            case ".":
                if (!display.contains("."))
                    display+=key;
                break;
            case "+":
            case "-":
                calculateOperation(key);
                break;
            case "=":
                calculateRsult();
                break;
            case "CE":
                clearOne();
                break;
            case "C":
                clearAll();

        }
        textview.setText(display);
    }

    private void clearAll() {
        display="0";
        acumulator=0.0;
        currentOperation=Operation.NONE;
    }

    private void clearOne() {
        if(display.length()>1)
           display=display.substring(0,display.length()-1);
        else
            display="0";
    }

    private void calculateRsult() {
        double displayValue=Double.parseDouble(display);
        switch (currentOperation){
            case ADD:
                displayResult(acumulator+displayValue);
                break;
            case SUBSTRACT:
                displayResult(acumulator-displayValue);
                break;
        }
        acumulator=0.0;
        currentOperation=Operation.NONE;
    }

    private void displayResult(double v) {
        if(v==(long)v)//Obcinanie częsci ułamkowej
            display=String.format("%d",(long)v);
        else
            display=String.format("%s",v);
    }

    private void calculateOperation(String key) {
        currentOperation=Operation.operationFromKey(key);//zapamiętywanie operacji
        acumulator=Double.parseDouble(display);
        display="0";
    }
}
