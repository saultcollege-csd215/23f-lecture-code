package _03_staying_immutable.generic;

public class BoxOfOne<MyType> {

    private MyType myVal;

    public BoxOfOne(MyType myVal) {
        this.myVal = myVal;
    }

    public MyType getMyVal() {
        return myVal;
    }

    public void setMyVal(MyType myVal) {
        this.myVal = myVal;
    }

    @Override
    public String toString() {
        return "BoxOfOne{" +
                "myVal=" + myVal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoxOfOne)) return false;

        BoxOfOne<?> boxOfOne = (BoxOfOne<?>) o;

        return getMyVal() != null ? getMyVal().equals(boxOfOne.getMyVal()) : boxOfOne.getMyVal() == null;
    }
}
