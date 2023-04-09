package lol1;

import java.io.IOException;

public class RockPaperScissorsSpockLizard {

    private int player1, player2;
    private String rock = "rock", paper = "paper", scissors = "scissors", spock = "spock", lizard = "lizard";

    private static int isWin(){
        int player1Choice = DataInput.getInt("1 - scissors" +
                '\n' + "2 - paper" +
                '\n' + "3 - rock" +
                '\n' + "4 - lizard" +
                '\n' + "5 - spock" + '\n' + "   : ");
        int player2Choice = getPlayer2Choice();
        showPlayer2Choice(player2Choice);
        switch (player1Choice){
            case 1:{
                if(player2Choice == 1)
                    return 3;

                if(player2Choice == 2)
                return 1;
                if(player2Choice == 4)
                    return 1;

                if(player2Choice == 5)
                    return 2;
                if(player2Choice == 3)
                    return 2;
            }
            case 2:{
                if(player2Choice == 2)
                    return 3;

                if(player2Choice == 3)
                    return 1;
                if(player2Choice == 5)
                    return 1;

                if(player2Choice == 1)
                    return 2;
                if(player2Choice == 4)
                    return 2;
            }
            case 3:{
                if(player2Choice == 3)
                    return 3;

                if(player2Choice == 4)
                    return 1;
                if(player2Choice == 1)
                    return 1;

                if(player2Choice == 2)
                    return 2;
                if(player2Choice == 5)
                    return 2;
            }
            case 4:{
                if(player2Choice == 4)
                    return 3;

                if(player2Choice == 5)
                    return 1;
                if(player2Choice == 2)
                    return 1;

                if(player2Choice == 3)
                    return 2;
                if(player2Choice == 1)
                    return 2;
            }
            case 5:{
                if(player2Choice == 5)
                    return 3;

                if(player2Choice == 1)
                    return 1;
                if(player2Choice == 3)
                    return 1;

                if(player2Choice == 4)
                    return 2;
                if(player2Choice == 2)
                    return 2;
            }
        }
        return 1;
    }

    private static int getPlayer2Choice(){
        return (int)Math.floor(Math.random() * (5 - 1 + 1) + 1);
    }

    private static void showPlayer2Choice(int i){
        switch (i){
            case 1:{
                System.out.println("Комп'ютер обрав Scissors");
                break;
            }
            case 2:{
                System.out.println("Комп'ютер обрав Paper");
                break;
            }
            case 3:{
                System.out.println("Комп'ютер обрав Rock");
                break;
            }
            case 4:{
                System.out.println("Комп'ютер обрав Lizard");
                break;
            }
            case 5:{
                System.out.println("Комп'ютер обрав Spock");
                break;
            }
        }
    }

    public static void main(String[] args) {
        char contin;
        do{
            int result = isWin();
            if(result == 1) System.out.println("Ви виграли!!!");
            else if(result == 2) System.out.println("Ви програли!!!");
            else System.out.println("Нічия!!!");
            try {
                contin = DataInput.getChar("Для продовження натисніть y \"yes\"");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while(contin == 'Y' || contin == 'y');
    }

}