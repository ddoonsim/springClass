package exam02;

public class Box<T extends Fruit> {

    private T item ;
    //private static T item2 ;
    //private T[] item3 = new T[] ;

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
