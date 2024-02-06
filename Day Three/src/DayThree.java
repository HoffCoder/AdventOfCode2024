import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DayThree {

    /*
    *
    *   Thoughts...
    *       Two ways to attack
    *           Map every number, check for non-"." and non-digit around
    *           Map out every non-digit non-"." and check for digit around
    *       I like first option
    *
    *       Two more options for parsing
    *           Check for valid numbers (prev line) following the reading of a line
    *           Check for valid numbers at the end (two run-throughs?)
    *
    *       Another option
    *           Map both and then check each numbers adjacent blocks
    *
    *
    *       NEW THOUGHT! when doing dishes I came up with a system that doesn't have us
    *       maintain the whole two-dimensional array.
    *           - Read through a line and maintain it and the previous
    *           - When reading number check above (and upper diagonal) as well as before
    *             and following for special chars
    *           - if none found notate as a todo for the next line in checking
    *       is this better? probably not. More complicated? yes.
    *       lets do it~
    *
    * */

    static final int schematicWidth = 140;
    static int schematicLength = 140;


    public static void main(String[] args) {

        String[][] mapping = CreateMapping();
        //for (String[] x : mapping) {for (String y : x){System.out.print(y + " ");}System.out.println();}

        Boolean inDigit = false;
        String number = "";
        Boolean validNumber = false;

        for(int row = 1; row < schematicLength+2; row++){

            for(int column = 0; column < schematicWidth; column++){

                if(isNumeric(mapping[row][column])){

                    if(inDigit){

                        number += mapping[row][column];

                        // If the thing we are evaluating is not currently a valid number
                        //    AND
                        // The value (above || below) is (not a number) && (not a period)
                        if(!validNumber && (!isNumeric(mapping[row - 1][column]) && !mapping[row - 1][column].equals(".")||!isNumeric(mapping[row + 1][column]) && !mapping[row + 1][column].equals("."))){

                            validNumber = true;

                        }

                    }
                    else{

                        inDigit = true;
                        // Time to check the previous and the left diagonals

                    }

                }

            }

        }

    }
    public static void ugh(String[] args) {

        final int schematicWidth = 140;
        final int schematiclength = 140;


        BufferedReader reader;
        Character[] prior = new Character[schematicWidth];
        Arrays.fill(prior, '.');
        Character[] current = new Character[schematicWidth];
        Boolean inNumber = false;
        int[] numberIndexes = {};
        Boolean isValid = false;
        try {
            reader = new BufferedReader(new FileReader("DayTwo.txt"));
            String line = reader.readLine();

            while(line != null){

                for (int index = 0 ; index < schematicWidth ;index++){

                    current[index] = line.charAt(index);

                }

                line = reader.readLine();

            }
            System.out.println("Woot.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String[][] CreateMapping() {

        String[][] mapping = new String[schematicLength + 2][schematicWidth];
        Arrays.fill(mapping[0],".");
        Arrays.fill(mapping[schematicLength + 1],".");
        BufferedReader reader;


        try {
            reader = new BufferedReader(new FileReader("DayThree.txt"));
            String line = reader.readLine();

            int rowCount = 1;

            while(line != null){

                for(int index = 0 ; index < line.length(); index++){

                    mapping[rowCount][index] = String.valueOf(line.charAt(index));


                }
                rowCount++;
                line = reader.readLine();

            }
            System.out.println("Woot.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return mapping;

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


}