import java.sql.SQLOutput;
import java.util.*;
import java.*;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Введите целые числа от 1 до 10");
        Scanner scan = new Scanner(System.in);
        String all = scan.nextLine();
        processTheResult(all);
    }

    public static void processTheResult(String all) {

        MathTermins symbol;
        List<String> arabianNumbers = new ArrayList<String>();
        Collections.addAll(arabianNumbers,"1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<String> romeNumbers = new ArrayList<String>();
        Collections.addAll(romeNumbers,"I","II","III","IV","V","VI","VII", "VIII","IX","X");
        String valueA;
        String valueB;
        String c;
        String result = null;

        String[] str = all.split(" ");
        valueA = str[0];
        c = str[1];
        valueB = str[2];

        symbol = mathTer(c);

        ArabToRoman converter = new ArabToRoman();

        if (arabianNumbers.indexOf(valueA) >= 0 && arabianNumbers.indexOf(valueB) >= 0) {
            int aArabian = Integer.parseInt(valueA);
            int bArabian = Integer.parseInt(valueB);
            if(symbol == MathTermins.PLUS){
                result = String.valueOf(Plus.operation(aArabian, bArabian));
            }
            else if(symbol == MathTermins.MINUS){
                result = String.valueOf(Minus.operation(aArabian, bArabian));
            }
            else if(symbol == MathTermins.MULTIPLICATION){
                result = String.valueOf(Multiplication.operation(aArabian, bArabian));
            }else if(symbol == MathTermins.DIVISION){
                result = String.valueOf(Division.operation(aArabian, bArabian));
            }else{
                throw new ArithmeticException("Введите +, -, *, /");
            }
        } else if (romeNumbers.indexOf(valueA) >= 0 && romeNumbers.indexOf(valueB) >= 0){
            if(symbol == MathTermins.PLUS){
                result = converter.arabToRoman(Plus.operation(romeNumbers.indexOf(valueA) + 1, romeNumbers.indexOf(valueB) + 1));
            }
            else if(symbol == MathTermins.MINUS){
                result = converter.arabToRoman(Minus.operation(romeNumbers.indexOf(valueA) + 1, romeNumbers.indexOf(valueB) + 1));
            }
            else if(symbol == MathTermins.MULTIPLICATION){
                result = converter.arabToRoman(Multiplication.operation(romeNumbers.indexOf(valueA) + 1, romeNumbers.indexOf(valueB) + 1));
            }
            else if(symbol == MathTermins.DIVISION){
                result = converter.arabToRoman(Division.operation(romeNumbers.indexOf(valueA) + 1, romeNumbers.indexOf(valueB) + 1));
            }else{
                throw new ArithmeticException("Введите +, -, *, /");
            }
        }else{
            throw new ArithmeticException("Введите цифры от 1 до 10");
        }
        System.out.println(result);
    }

    public static MathTermins mathTer(String c) {
        if (c != null){
            switch (c){
                case "+": return MathTermins.PLUS;
                case "-": return MathTermins.MINUS;
                case "*": return MathTermins.MULTIPLICATION;
                case "/": return MathTermins.DIVISION;
            }
        }
        return null;
    }

}

