import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        char[][] board = new char[3][3];
        String pl1 = "Player1";
        String pl2 = "Player2";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Ahoj borce, chces hrat proti sobe, protoze nemas kamose nebo proti nejlepsimu AI ve vesmiru? Pro hrani proti sobe klikni na 0 a pro hrani s AI klikni na 1.");
        //String ans = scanner.nextLine();
        //int x =Integer.parseInt(ans);

        boolean player = true;
        boolean end = false;

        while (!end) {

            drawBoard(board);

            if (player) {
                System.out.println(pl1 + "hraje (x)");
            } else {
                System.out.println(pl2 + "hraje (y)");
            }

            char sign = '-';
            if (player) {
                sign = 'x';
            } else {
                sign = 'o';
            }

            int row = 0;
            int col = 0;

            while (true) {
                System.out.print("Napis radek do ktereho chces zahrat (0 az 2)");
                row = scanner.nextInt();
                System.out.print("Napis sloupec v poli do ktereho chces zahrat (0 az 2)");
                col = scanner.nextInt();

                if (row > 2 || col > 2 || row < 0 || col < 0) {
                    System.out.println("Koupil bych si slabikar a znova bych se mrknul na ctení, protoze jsem psal 0 az 2!");
                } else if (board[row][col] != '-') {
                    System.out.println("Sorry, tohle policko uz je zabrany.");
                } else {
                    break;
                }
            }

            board[row][col] = sign;

            if (hasWon(board) == 'x') {
                System.out.println(pl1 + "hezky chlape, vyhral jsi v piskvorkach.");
                end = true;
            } else if (hasWon(board) == 'o') {
                System.out.println(pl2 + "hezky chlape, vyhral jsi v piskvorkach.");
                end = true;
            } else {
                player = !player;
            }
        }

        drawBoard(board);
    }

    public static void drawBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    //[1][1](střed)
    public static char hasWon(char[][] board) {
        for (int x = 0; x < 3; x++) {
            if (board[x][0] == board[x][2] && board[1][x] == board[2][x] && board[0][x] != '-') {
                return board[0][x];
            }
            //dodelat vyhru v radku a sikmo
        }
        return ' ';
    }
}
