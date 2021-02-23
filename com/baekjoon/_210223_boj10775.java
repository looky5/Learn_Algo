import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _210223_boj10775 {

    static int G, P;
    static int[] openGate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        openGate = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            openGate[i] = i;
        }
        int answer = 0, standard_num = 0, landingGate = 0;
        for (int i = 1; i <= G; i++) {
            standard_num = Integer.parseInt(br.readLine());
            landingGate = findLandingGate(standard_num);
            if (landingGate == 0) break;
            ++answer;
            assignGate(landingGate, landingGate - 1);
        }
        System.out.println(answer);
    }

    public static void assignGate(int g1, int g2) {
        openGate[g1] = findLandingGate(g2);
    }

    public static int findLandingGate(int num) {
        if (openGate[num] == num) return num;
        return openGate[num] = findLandingGate(openGate[num]);
    }
}
