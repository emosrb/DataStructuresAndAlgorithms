package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Caterpillar {

    public static void main(String[] args) {
                int numberOfLeaves = 10;
                int[] caterpillars = new int[]{2,3,5};
                Arrays.sort(caterpillars);
                int uneatenLeaves = 0;
                for (int leaf = 1; leaf <= numberOfLeaves; leaf++) {
                    if (isLeafUneaten(leaf, caterpillars)) {
                        uneatenLeaves++;
                    }
                }
                System.out.println("uneatenLeaves "+uneatenLeaves);
    }


    private static boolean isLeafUneaten(int leaf, int[] caterpillars) {
        for (int caterpillar : caterpillars) {
            if (leaf % caterpillar == 0) {
                return false;
            }
        }
        return true;
    }

}
