package objectAnalyzer;

import java.util.ArrayList;

/**
 * @author: zhouqian
 * @date: 2020/2/10
 * @blog:
 * @version:1.0.0
 * @description:
 */

public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            squares.add(i * i);
        }

        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
