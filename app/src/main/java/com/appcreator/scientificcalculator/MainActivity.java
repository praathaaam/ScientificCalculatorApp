package com.appcreator.scientificcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scientificcalculator.R;

import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity {
    private TextView prevCal;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prevCal=findViewById(R.id.prevCalView);
        display=findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String str)
    {
//        if(str.equals(getResources().getString(R.string.zeroText))
//                || str.equals(getResources().getString(R.string.decimalText))
//                || str.equals(getResources().getString(R.string.oneText))
//                || str.equals(getResources().getString(R.string.twoText))
//                || str.equals(getResources().getString(R.string.threeText))
//                || str.equals(getResources().getString(R.string.fourText))
//                || str.equals(getResources().getString(R.string.fiveText))
//                || str.equals(getResources().getString(R.string.sixText))
//                || str.equals(getResources().getString(R.string.sevenText))
//                || str.equals(getResources().getString(R.string.eightText))
//                || str.equals(getResources().getString(R.string.nineText))
//        )
//        {
//            display.setText(str);
//        }
        String oldStr = display.getText().toString();
        int cursorPos=display.getSelectionStart();
        String leftStr=oldStr.substring(0,cursorPos);
        String rightStr=oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, str, rightStr));
        display.setSelection(cursorPos+str.length());

    }

    public void zeroButton(View view)
    {
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneButton(View view)
    {
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoButton(View view)
    {
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeButton(View view)
    {
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourButton(View view)
    {
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveButton(View view)
    {
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixButton(View view)
    {
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenButton(View view)
    {
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightButton(View view)
    {
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineButton(View view)
    {
        updateText(getResources().getString(R.string.nineText));
    }
    public void clearButton(View view)
    {
        display.setText("");
        prevCal.setText("");
    }
    public void parenthesesOpenButton(View view)
    {
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void parenthesesCloseButton(View view)
    {
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void divideButton(View view)
    {
        updateText(getResources().getString(R.string.divideText));
    }
    public void multiplyButton(View view)
    {
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void addButton(View view)
    {
        updateText(getResources().getString(R.string.addText));
    }
    public void subtractButton(View view)
    {
        updateText(getResources().getString(R.string.subtractText));
    }
    public void decimalButton(View view)
    {
        updateText(getResources().getString(R.string.decimalText));
    }
    public void equalsButton(View view)
    {
        String userExp=display.getText().toString();
        prevCal.setText(userExp);
        userExp=userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp=userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");
        Expression exp = new Expression(userExp);
        double value=exp.calculate();
        String result=String.format("%.2f", value);
        //String result=String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public void backspaceButton(View view)
    {
        int cursorPos=display.getSelectionStart();
        int textLen=display.getText().length();

        if(cursorPos!=0&&textLen!=0)
        {
            SpannableStringBuilder selection=(SpannableStringBuilder)display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }

    }

    public void percentageBTNPush(View view)
    {
       updateText(getResources().getString(R.string.percentageText));
    }

    public void factorialBTNPush(View view)
    {
        updateText(getResources().getString(R.string.factorialTextView));
    }
    public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void trigCosBTNPush(View view){
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){
        updateText("arctan(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void logBTNPush(View view){
        updateText("log2(");
    }

    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }

    public void absBTNPush(View view){
        updateText("abs(");
    }

    public void piBTNPush(View view){
        updateText("pi");
    }

    public void eBTNPush(View view){
        updateText("e");
    }

    public void xSquaredBTNPush(View view){
        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void primeBTNPush(View view){
        updateText("ispr(");
    }
}
