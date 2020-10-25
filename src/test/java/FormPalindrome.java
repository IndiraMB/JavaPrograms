import java.util.Scanner;

public class FormAPalindrome {
    public static char[] output;
    public static void main (String a[]) {
        int[] input = new int[4];
        try {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 4; i++) {
                input[i] = Integer.parseInt(scanner.next());
            }
        } catch (NumberFormatException e){
            System.out.println("Please enter only numbers");
        }
        int totalLength = input[0];
        int charCount = input[1];
        int numCount = input[2];
        int specialChar = input[3];
        output = new char[totalLength];
        int mid = totalLength / 2;
        int[] flags = checkForValidInput(totalLength, charCount, numCount, specialChar);
        if (flags[4] == 1){
            formString(totalLength, charCount, numCount, specialChar);
            if (flags[1]==1){
                output[mid] = getAsciiValue(97);
            }
            if (flags[2]==1){
                output[mid] = getAsciiValue(48);
            }
            if (flags[3]==1){
                output[mid] = getAsciiValue(33);
            }
            System.out.println(String.valueOf(output));
            if (checkPalindrome(String.valueOf(output))){
                System.out.println("It is a palindrome");
            } else System.out.println("It is NOT a palindrome");
        }
    }

    public static boolean checkPalindrome(String output){
        StringBuilder stringBuilder = new StringBuilder(output);
        if (stringBuilder.reverse().toString().equals(output)){
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

    public static int[] checkForValidInput(int totalLength, int charCount, int numCount, int specialChar){
        int[] flags = {0,0,0,0,0};
        int validFlag = 0;
        if (charCount+numCount+specialChar==totalLength){
            if (checkEven(charCount) && checkEven(numCount) && checkEven(specialChar)){
                validFlag=1;
                flags[0]=1;
            }
            if (!checkEven(charCount)){
                if (checkEven(numCount) && (checkEven(specialChar))){
                    flags[1] = 1;
                    validFlag = 1;
                }
            }
            if (!checkEven(numCount)){
                if (checkEven(charCount) && (checkEven(specialChar))){
                    flags[2] = 1;
                    validFlag = 1;
                }
            }
            if (!checkEven(specialChar)){
                if (checkEven(numCount) && (checkEven(charCount))){
                    flags[3] = 1;
                    validFlag = 1;
                }
            }
            flags[4] = validFlag;
            if (validFlag == 0){
                System.out.println("Invalid Input");
            }
        }
            else System.out.println("Invalid Input");
        return flags;
    }

    public static void formString (int totalLength, int charCount, int numCount, int specialChar){
        int i, j, k = 0;
        for (i=0;i<charCount/2;i++){
            output[i] = getAsciiValue(i + 97);
            output[totalLength - 1 - i] = getAsciiValue(i + 97);
        }
        for (j = i; j < i + numCount/2; j++) {
            output[j] = getAsciiValue(j-i + 48);
            output[totalLength - 1 - j] = getAsciiValue(j-i + 48);
        }
        for (k = j; k < j + specialChar / 2; k++) {
            output[k] = getAsciiValue(k-j + 33);
            output[totalLength - 1 - k] = getAsciiValue(k-j + 33);
        }
    }
}
