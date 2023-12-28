package exam05;

import java.io.File;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) throws Exception {
        File dir = new File("D:/folder") ;
        if(!dir.exists()) {    // 파일 또는 디렉토리 존재 여부
            dir.mkdir() ;    // 디렉토리가 없으면 생성
        }

        File file = new File(dir, "test1.txt") ;    // 없는 파일인 경우 오류 발생하기 때문에 디렉토리 생성 필요
        file.createNewFile() ;

        File dir2 = new File("D:/foler1/folder2/folder3") ;
        if (!dir2.exists()) {
            dir2.mkdirs() ;    // 하위 경로가 여러 개인 경우
        }

        File file2 = new File(dir2, "test2.txt") ;
        file2.createNewFile() ;

        File file3 = File.createTempFile("temp_", ".log", new File("D:/")) ;    // 임시 파일
        Thread.sleep(3000);    // 파일 생성 후 3초 지연
        file3.deleteOnExit();    // 임시 파일 삭제
    }
}
