package lol2;

import java.io.IOException;

public class CabbageSquare {

    public static void main(String[] args) throws IOException {
        char answer;
        do{
            printSquare();
            answer = DataInput.getChar("Для продовження натисніть y (YES): ");
        }while(answer == 'y'|| answer == 'Y');
    }

    private static void printSquare(){
        int number;
        do{
            number = DataInput.getInt("Введіть кількість обгорток : ");
        }while(number < 0 || number > 9);
        int length = number * 2 + 1;
        int plus = 0;
        String str = "";
        for(int i = 0; i < length / 2; i++){
            str = "";
            plus = 0;
            for(int j = 1; j <= length / 2; j++){
                str += ((9 - length / 2) + plus);
                if(plus < i) plus++;
            }
            System.out.println(str + ((9 - length / 2) + plus) + reverseStr(str));
        }
        for(int i = length / 2; i >= 0; i--){
            str = "";
            plus = 0;
            for(int j = 1; j <= length / 2; j++){
                str += ((9 - length / 2) + plus);
                if(plus < i) plus++;
            }
            System.out.println(str + ((9 - length / 2) + plus) + reverseStr(str));
        }
    }

    private static String reverseStr(String str) {
        char ch;
        String nstr = "";
        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i);
            nstr= ch+nstr;
        }
        return nstr;
    }
}
