import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class DayTwo {
    public static void main(String[] args) {

        BufferedReader reader;

        int runningTotal = 0;

        try {
            reader = new BufferedReader(new FileReader("DayTwo.txt"));
            String line = reader.readLine();

            while(line != null){

                runningTotal += ParseLine(line);

                line = reader.readLine();

            }
            System.out.println("Woot.");
            System.out.println(runningTotal);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static int ParseLine(String line){

        String[] handAndGames = line.split(":");
        String ID = handAndGames[0].split(" ")[1];
        int[] counts;
        int[] bests = {0,0,0};
        for(String game : handAndGames[1].split(";")){
            counts = ParseGame(game);
            for(int index = 0; index < 3; index++){
                if(counts[index] > bests[index]){
                    bests[index] = counts[index];
                }
            }
        }

        return bests[0] * bests[1] * bests[2] ;

    }

    private static int[] ParseGame(String game) {
        String[] hands = game.split(",");

        int greenMax = 0;
        int redMax = 0;
        int blueMax = 0;
        for(String hand : hands){
            String[] colors = hand.split(" ");
            switch (colors[2]){
                case "green":
                    greenMax = Integer.parseInt(colors[1]);
                    break;
                case "red":
                    redMax = Integer.parseInt(colors[1]);
                    break;
                case "blue":
                    blueMax = Integer.parseInt(colors[1]);
                    break;
            }
        }
        return new int[]{greenMax, redMax, blueMax};
    }
}