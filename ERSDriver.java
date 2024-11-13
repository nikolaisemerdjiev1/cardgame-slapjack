
public class ERSDriver {
    public static void main(String[] args) {
        Game game = new Game(4);
        System.out.println(game.getPlayers().size() + " player game");

        int r = 1;
        while (game.getPlayers().size() > 1) {
            System.out.println("Starting Round " + r);
            int rWinnerNum = game.play();
            System.out.println("Player " + rWinnerNum + " Won the round and takes the pile!");

            r++;
        }

        int gameWinner = game.getPlayers().getFirst().getPlayerNum();
        System.out.println("Player " + gameWinner + " won the game!");

    }
}
