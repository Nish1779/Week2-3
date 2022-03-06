package com.example.nishvariaorange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean startNumber = true;
    boolean acceptingDigits=true;

    CalculatorModel calculatorModel = new CalculatorModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClicked(android.view.View view) // here the last view e argument pass karel 6.
    {
        Log.i("button", "Button Clicked");
        // which btn is pressed ...
        Button button = (Button) view;  // here,  Btn btn = (Btn) view to ema btn e id and = (Btn) e TYPECAST karyu 6
               // bcz aapde upper view pass karyu 6 to view ma madse je made e so aaapde BTN ma joie etle same evu if Text ma joie to Text mate karvanu
        String buttonText = button.getText().toString();  // String obj. btntext e khali store karya badha btns ne.
        Log.i("bn", " btn is :"+buttonText);

        // what was the btn displed at the time of btn pressed...
        TextView textView= (TextView) findViewById(R.id.numberdisplay); // textView e ahiya define karyu 6 as a TV
                                                                        // tv ne find karyo id thi bs and ene textview name aapoine backend ma store karyo.
                                                                // e pa6o aapse  view ma etle caste karvano TV ma.
        String currentnumber = textView.getText().toString();

        switch(buttonText)
        {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":

                // deal with the digit or .
                if (startNumber){
                    if (buttonText.equals("."))
                    {
                        currentnumber="0.";
                    }
                    else
                    {
                        currentnumber=buttonText;
                    }

                    startNumber=false;
                }
                else {
                    if(buttonText.equals(".") && currentnumber.contains("."))
                    {
                        //do nothinbg, already contians a DOT.
                    }
                    else
                    {
                    currentnumber=currentnumber+buttonText;
                    }
                }
                break;

            case "+":
                double firstNumber= Double.parseDouble(currentnumber);  // converted the STRING into the DOUBLE
                calculatorModel.setFirstNumber(firstNumber);

                calculatorModel.setOperator(buttonText);
                startNumber=true;
                break;


            case "=":
                double secondNumber = Double.parseDouble(currentnumber);  // converted the STRING into the DOUBLE
                calculatorModel.setSecondNumber(secondNumber);

                String result = Double.toString(calculatorModel.getResult());
                currentnumber = result;
                break;
        }

        textView.setText(currentnumber);


    }
}