package exam03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06 {
    public static void main(String[] args) {
        int[] scores = { 90, 60, 70, 80, 100 } ;

        try (FileOutputStream fos = new FileOutputStream("score.dat");
             DataOutputStream dos = new DataOutputStream(fos)) {

            for (int score : scores) {
                dos.writeInt(score);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
