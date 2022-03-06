package com.example.nishvariaorange;

public class CalculatorModel {

    double firstNumber = 0.0;
    double secondNumber = 0.0;
    double result = 0.0;

    String operator = "";

    public void setFirstNumber(double num)
    {
        firstNumber=num;
    }

    public void setSecondNumber(double num)
    {
        secondNumber=num;
    }

    public double getResult()
    {
        return result;
    }

    public void computeResult(){
        switch (operator)
        {
            case "+":
                result = firstNumber + secondNumber;
                break;
        }
    }

    public void setOperator(String op)
    {
        operator=op;
    }
}
