package exam03;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex07 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("score.dat");
             DataInputStream dis = new DataInputStream(fis)) {

            int total = 0, count = 0 ;
            try {
                while (true) {
                    int score = dis.readInt();
                    total += score ;
                    count++ ;
                }
            }
            catch (EOFException e) {    // 파일의 끝에 도달한 경우
                double avg = total / (double)count ;
                System.out.printf("합계 : %d, 평균 : %.2f%n", total, avg);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
