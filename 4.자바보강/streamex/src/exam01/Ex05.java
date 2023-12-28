package exam01;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        String[] words1 = { "aaa", "aaa", "bb", "ccc", "ccc", "abcd"};

        // 중복 제거
        List<String> newWords = new ArrayList<>();

        for (String word : words1) {
            if (!newWords.contains(word)) {
                newWords.add(word);
            }
        }

        // 3자리 이상
        List<String> newWords2 = new ArrayList<>();
        for (String word : newWords) {
            if (word.length() >= 3) {
                newWords2.add(word);
            }
        }

        // 반복 출력
        for (String word : newWords2) {
            System.out.println(word);
        }
    }
}