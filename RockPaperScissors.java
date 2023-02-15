import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private String player_name;
    private int highest_score;
    private int score;
    
    public RockPaperScissors(String player_name) {
        this.player_name = player_name;
        this.highest_score = 0;
        this.score = 0;
    }
    
    public String getPlayerName() {
        return player_name;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getHighestScore() {
        return highest_score;
    }
    
    public String play(String player_move) {
        String[] moves = {"rock", "paper", "scissors"};
        Random random = new Random();
        String computer_move = moves[random.nextInt(moves.length)];
        
        if (player_move.equals(computer_move)) {
            return "draw";
        } else if (player_move.equals("rock") && computer_move.equals("scissors")) {
            score++;
            if (score > highest_score) {
                highest_score = score;
            }
            return "win";
        } else if (player_move.equals("scissors") && computer_move.equals("paper")) {
            score++;
            if (score > highest_score) {
                highest_score = score;
            }
            return "win";
        } else if (player_move.equals("paper") && computer_move.equals("rock")) {
            score++;
            if (score > highest_score) {
                highest_score = score;
            }
            return "win";
        } else {
            score = 0;
            return "lose";
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RockPaperScissors game = new RockPaperScissors("John");
        System.out.println("Highest score: " + game.getHighestScore());
        
        while (true) {
            System.out.print("Enter your move (rock, paper, or scissors), or type q to quit: ");
            String player_move = scanner.nextLine();
            if (player_move.equals("q")) {
                break;
            }
            
            String result = game.play(player_move);
            System.out.println(game.getPlayerName() + " chose " + player_move);
            System.out.println("Computer chose " + game.play("")); // passing empty string to play as computer
            System.out.println("Result: " + result);
            System.out.println("Current score: " + game.getScore());
            System.out.println("Highest score: " + game.getHighestScore());
        }
        
        scanner.close();
    }
}