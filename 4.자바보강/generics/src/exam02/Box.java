package exam02;

public class Box<T extends Fruit> {

    private T item ;
    //private static T item2 ;  ∵ static은 선언과 동시에 객체화 되기 때문에 타입이 미정인 상태로는 컴파일 X
    //private T[] item3 = new T[] ;  ∵ 배열도 선언과 동시에 new로 객체로 만들어야 하기 때문에 타입이 미정인 상태로는 컴파일 X

    public T getItem() {
        return  item ;
    }

    public void setItem(T item) {
        this.item = item ;
    }

    public void printItem() {
        // T -> Object, 객체를 만드는 시점 -> 투입된 타입으로 형변환
        // T -> Fruit, 객체를 만드는 시점 -> 투입된 타입으로 형변환
        item.print();
    }
}
