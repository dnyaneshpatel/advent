import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Captcha {

    public static void main(String[] args){
        Captcha captcha = new Captcha();

        System.out.println(captcha.getSum(91212129));
    }

    public int getSum(int inputNumber) {
        String inputString = String.valueOf(inputNumber);
        char[] inputArray = inputString.toCharArray();
        int firstValue = inputArray != null ? Character.getNumericValue(inputArray[0]) : Integer.MIN_VALUE;
        int sum = 0;
        int length = inputArray.length;
        for (int i = 0; i < length; i++) {
            int currentValue = Character.getNumericValue(inputArray[i]);
            if (i != length - 1) {
                if (currentValue == Character.getNumericValue(inputArray[i + 1])) {
                    sum = sum + currentValue;
                }
            } else {
                if (currentValue == firstValue) {
                    sum = sum + currentValue;
                }
            }


        }
        return sum;

    }

}
