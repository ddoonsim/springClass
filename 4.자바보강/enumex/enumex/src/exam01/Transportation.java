package exam01;

public enum Transportation {
    BUS("버스") {
        @Override
        public int getTotal(int people) {
            return 1400 * people ;
        }
    },
    SUBWAY("지하철") {
        @Override
        public int getTotal(int people) {
            return 1450 * people ;
        }
    },
    TAXI("택시") {
        @Override
        public int getTotal(int people) {
            return 4500 * people ;
        }
    };

    private final String title ;    // : final 필드 (!= 상수)

    // 생성자 정의 가능
    Transportation(String title) {
        this.title = title ;
    }

    // 메서드 정의 가능
    public String getTitle() {
        return title;
    }

    // 추상 메서드 정의 가능
    public abstract int getTotal(int people) ;
}
