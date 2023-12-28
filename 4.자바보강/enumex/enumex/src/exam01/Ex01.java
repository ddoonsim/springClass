package exam01;

// static을 붙여서 import하면 클래스명을 안 붙이고 상수 사용 가능
import static exam01.Transportation.* ;
public class Ex01 {
    public static void main(String[] args) {
        Transportation bus = BUS ;
        System.out.println(BUS == Transportation.BUS);
        System.out.printf("ordinal() : %d, name() : %s%n", bus.ordinal(), bus.name());

        Transportation trans = Transportation.BUS ;
        System.out.println(trans.getTitle()) ;

        int fare = trans.getTotal(10) ;
        System.out.println(fare);
    }
}
