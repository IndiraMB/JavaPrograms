import java.util.Scanner;

public class FormAPalindrome {
    public static void main (String a[]) {
        int[] input = new int[4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            input[i] = Integer.parseInt(scanner.next());
        }
         int totalLength = input[0];
         int charCount = input[1];
         int numCount = input[2];
         int specialChar = input[3];
        int specialCharFlag = 0;
        int charFlag = 0;
        int numFlag = 0;
        int allEven = 0;


        if (charCount + numCount + specialChar == totalLength) {
            if (checkEven(charCount) && checkEven(numCount) && checkEven(specialChar)) {
                allEven = 1;
            } else {
                if (!checkEven(charCount)) {
                    if (checkEven(numCount) && checkEven(specialChar)) {
                        charFlag = 1;
                    }
                }
                else if (!checkEven(specialChar)) {
                    if (checkEven(numCount) && checkEven(charCount)) {
                        specialCharFlag = 1;
                    }
                }
                else if (!checkEven(numCount)) {
                    if (checkEven(specialChar) && checkEven(charCount)) {
                        numFlag = 1;
                    }
                }
                else
                    System.out.println("Invalid Input");
            }
        } else
            System.out.println("Invalid Input");

        char[] output = new char[totalLength];
        int i, j, k = 0;

        if (allEven==1){
            for ( i=0;i<charCount/2;i++){
                output[i] = getAsciiValue(i + 97);
                output[totalLength - 1 - i] = getAsciiValue(i + 97);
            }
            for (j = i; j < i + numCount/2; j++) {
                output[j] = getAsciiValue(j + 48);
                output[totalLength - 1 - j] = getAsciiValue(j + 48);
            }
            for (k = j; k < j + specialChar / 2; k++) {
                output[k] = getAsciiValue(k + 33);
                output[totalLength - 1 - k] = getAsciiValue(k + 33);
            }
        }

        if (specialCharFlag==1){
            for ( i=0;i<charCount/2;i++){
                output[i] = getAsciiValue(i + 97);
                output[totalLength - 1 - i] = getAsciiValue(i + 97);
            }
            for (j = i; j < i + numCount/2; j++) {
                output[j] = getAsciiValue(j + 48);
                output[totalLength - 1 - j] = getAsciiValue(j + 48);
            }
            for (k = j; k < j + specialChar / 2; k++) {
                output[k] = getAsciiValue(k + 33);
                output[totalLength - 1 - k] = getAsciiValue(k + 33);
            }
            output[k] = getAsciiValue(k + 33);
        }

        if (charFlag==1){
            for (j = 0; j < numCount/2; j++) {
                output[j] = getAsciiValue(j + 48);
                output[totalLength - 1 - j] = getAsciiValue(j + 48);
            }
            for (k = j; k < j + specialChar / 2; k++) {
                output[k] = getAsciiValue(k + 33);
                output[totalLength - 1 - k] = getAsciiValue(k + 33);
            }
            for ( i=k;i<k+charCount/2;i++){
                output[i] = getAsciiValue(i + 97);
                output[totalLength - 1 - i] = getAsciiValue(i + 97);
            }
            output[i] = getAsciiValue(i + 97);
        }

        if (numFlag==1){
            for (j = 0; j < charCount/2; j++) {
                output[j] = getAsciiValue(j + 97);
                output[totalLength - 1 - j] = getAsciiValue(j + 97);
            }
            for (k = j; k < j + specialChar / 2; k++) {
                output[k] = getAsciiValue(k + 33);
                output[totalLength - 1 - k] = getAsciiValue(k + 33);
            }
            for ( i=k;i<k+numCount/2;i++){
                output[i] = getAsciiValue(i + 48);
                output[totalLength - 1 - i] = getAsciiValue(i + 48);
            }
            output[i] = getAsciiValue(i + 48);
        }

        System.out.println(String.valueOf(output));

    }

    public static boolean checkPalindrome(String output){
        StringBuilder stringBuilder = new StringBuilder(output);
        if (stringBuilder.reverse().equals(output)){
            return true;
        }
        else return false;
    }


    public static char getAsciiValue(int ascii){
        return (char)ascii;
    }

    public static boolean checkEven(int input){
        if (input % 2 == 0)
            return true;
        else return false;
    }
}
