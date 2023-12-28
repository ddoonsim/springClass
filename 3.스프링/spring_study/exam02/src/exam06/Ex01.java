package exam06;

public class Ex01 {
    public static void main(String[] args) {
        Transportation trans = Transportation.SUBWAY ;

        // 주소값 비교
        if (trans == Transportation.SUBWAY) {
            System.out.println("지하철🚇");
        }

        switch (trans) {
            case SUBWAY :
                System.out.println("지하철🚇");
                break;
            case TAXI :
                System.out.println("택시🚕");
                break;
            case BUS :
                System.out.println("버스🚌");
                break;
        }
    }
}
