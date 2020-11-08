public class _1024_NHN01 {

    public static void main(String[] args) {
//        int numOfAllPlayers = 17;
//        int numOfQuickPlayers = 5;
//        char[] namesOfQuickPlayers = {'B', 'D', 'I', 'M', 'P'};
//        int numOfGames = 11;
//        int[] numOfMovesPerGame = {3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23};
        int numOfAllPlayers = 4;
        int numOfQuickPlayers = 1;
        char[] namesOfQuickPlayers = {'C'};
        int numOfGames = 2;
        int[] numOfMovesPerGame = {33, -46};
        solution(numOfAllPlayers, numOfQuickPlayers, namesOfQuickPlayers, numOfGames, numOfMovesPerGame);
    }

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
        char[] spot = new char[numOfAllPlayers - 1];
        int[] players = new int[numOfAllPlayers];
        players[0]++;
        char c = 'B';
        for (int i = 0; i < numOfAllPlayers - 1; i++) {
            spot[i] = c++;
        }
        char soolae = 'A';
        int startPoint = 0;
        int times = 0;
        while (times < numOfMovesPerGame.length) {
            int putTowel = 0;
            int p = numOfMovesPerGame[times] % spot.length;
            if(p >= 0) {
                 if(startPoint + p < spot.length) {
                     putTowel = startPoint + p;
                 } else {
                     putTowel = p - spot.length + startPoint;
                 }
            } else {
                if(startPoint + p >= 0) {
                    putTowel = startPoint + p;
                } else {
                    putTowel = spot.length + p + startPoint;
                }
            }
            char choose = spot[putTowel];
            boolean isQuick = false;
            for (char ch : namesOfQuickPlayers) {
                if (choose == ch) {
                    isQuick = true;
                    break;
                }
            }
            if (isQuick) {
                players[soolae - 'A']++;
            } else {
                spot[putTowel] = soolae;
                soolae = choose;
                players[soolae - 'A']++;
            }
            startPoint = putTowel;
            times++;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : spot) {
            sb.append(ch).append(" ").append(players[ch - 'A']).append('\n');
        }
        sb.append(soolae).append(" ").append(players[soolae - 'A']);
        System.out.println(sb.toString());
    }
}
