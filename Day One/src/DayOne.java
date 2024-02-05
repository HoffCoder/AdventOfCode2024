
// Imports from jdk
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayOne {

    public static void main(String[] args) {
        BufferedReader reader;

        int runningTotal = 0;

        try {
            reader = new BufferedReader(new FileReader("DayOne.txt"));
            String line = reader.readLine();

            while(line != null){

                runningTotal += ParseLine(line);
                line = reader.readLine();

            }
            System.out.println(runningTotal);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int ParseLine(String line){

        System.out.println(line);
        String parsedInt = "";
        int lineLength = line.length();

        for(int index = 0; index < lineLength;index++){
            if(Character.isDigit(line.charAt(index))){
                parsedInt += line.charAt(index);
                break;
            }
            if(lineLength - index >= 3){
                parsedInt += EvaluateThreeCharacters(line.substring(index,index + 3));
                if (!parsedInt.isEmpty()){break;}

            }else{continue;}
            if(lineLength - index >= 4){
                parsedInt += EvaluateFourCharacters(line.substring(index,index + 4));
                if (!parsedInt.isEmpty()){break;}
            }else{continue;}
            if(lineLength - index >= 5){
                parsedInt += EvaluateFiveCharacters(line.substring(index,index + 5));
                if (!parsedInt.isEmpty()){break;}
            }
        }
        System.out.println(parsedInt);
        for(int index = lineLength - 1; index >= 0;index--){

            if(Character.isDigit(line.charAt(index))){
                parsedInt += line.charAt(index);
                break;
            }
            if(index >= 2){
                parsedInt += EvaluateThreeCharacters(line.substring(index - 2,index + 1));
                if (parsedInt.length() != 1){break;}
            }else{continue;}
            if(index >= 3){
                parsedInt += EvaluateFourCharacters(line.substring(index - 3,index + 1));
                if (parsedInt.length() != 1){break;}
            }else{continue;}
            if(index >= 4){
                parsedInt += EvaluateFiveCharacters(line.substring(index - 4,index + 1));
                if (parsedInt.length() != 1){break;}
            }

        }
        System.out.println(parsedInt);
        return Integer.parseInt(parsedInt);
    }

    public static String EvaluateThreeCharacters(String substring){
        return switch (substring) {
            case "one" -> "1";
            case "two" -> "2";
            case "six" -> "6";
            default -> "";
        };
    }
    public static String EvaluateFourCharacters(String substring){
        return switch (substring) {
            case "four" -> "4";
            case "five" -> "5";
            case "nine" -> "9";
            case "zero" -> "0";
            default -> "";
        };
    }
    public static String EvaluateFiveCharacters(String substring){
        return switch (substring) {
            case "three" -> "3";
            case "seven" -> "7";
            case "eight" -> "8";
            default -> "";
        };
    }

}