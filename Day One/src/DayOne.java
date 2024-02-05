
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
        System.out.println(parsedInt);

        for(int index = 0; index < line.length();index++){

            if(Character.isDigit(line.charAt(index))){
                parsedInt += line.charAt(index);
                break;
            }

        }
        System.out.println(parsedInt);
        for(int index = line.length() - 1; index >= 0;index--){

            if(Character.isDigit(line.charAt(index))){
                parsedInt += line.charAt(index);
                break;
            }

        }
        System.out.println(parsedInt);

        return Integer.parseInt(parsedInt);

    }

}