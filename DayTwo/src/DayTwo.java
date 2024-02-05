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
        System.out.println(ID);
        for(String game : handAndGames[1].split(";")){
            if(!ParseGame(game)){
                return 0;
            }
        }

        return Integer.parseInt(ID);

    }

    private static boolean ParseGame(String game) {
        String[] hands = game.split(",");
        for(String hand : hands){
            String[] colors = hand.split(" ");
            System.out.println(Arrays.toString(colors));
            switch (colors[2]){
                case "green":
                    if (Integer.parseInt(colors[1]) > 13 ){return false;}
                    break;
                case "red":
                    if (Integer.parseInt(colors[1]) > 12 ){return false;}
                    break;
                case "blue":
                    if (Integer.parseInt(colors[1]) > 14 ){return false;}
                    break;
            }
        }
        return true;
    }
}