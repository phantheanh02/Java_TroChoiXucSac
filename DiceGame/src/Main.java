// Nguyen Duy Doanh 20204948
import controller.GameController;
import model.ComputerPlayer;
import model.Constant;
import model.Dice;
import model.Player;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Dice> dices = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("So luong nguoi choi: ");
        int countPlayers = sc.nextInt();

        // Thêm người chơi thực
        for(int i = 0; i < countPlayers; i++) {
            System.out.println("Ten nguoi choi so " + (i+1) + ": ");
            String name = sc.next();
            players.add(new Player(name));
        }

        // Thêm người chơi máy để đủ 4 người chơi
        for(int i = countPlayers; i < Constant.MAX_PLAYER; i++) {
            String name = "May " + (i+1);
            players.add(new ComputerPlayer(name));
        }

        // Khởi tạo xúc xắc
        for(int i = 1; i <= Constant.MAX_DICE; i++) {
            dices.add(new Dice(i));
        }
        // Vào game
        GameController gameController = new GameController(players, dices);
        gameController.play();
    }
}