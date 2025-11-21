package academy.tochkavhoda.figures.v1;

public class Square extends Rectangle {

    public Square(Point leftTop, int size) {
        super(leftTop, new Point(leftTop.getX() + size, leftTop.getY() + size));
    }

    public Square(int xLeft, int yTop, int size) {
        super(xLeft, yTop, xLeft + size, yTop + size);
    }

    public Square(int size) {
        super(0, -size, size, 0);  // левый верхний (0, -size), правый нижний (size, 0)
    }

    public Square() {
        this(1);
    }

    // Правильно — используем геттеры/сеттеры родителя!
    @Override
    public void setTopLeft(Point topLeft) {
        int size = getLength();
        super.setTopLeft(topLeft);                                      // ← правильно!
        setBottomRight(new Point(topLeft.getX() + size, topLeft.getY() + size));
    }

    @Override
    public void resize(double ratio) {
        stretch(ratio, ratio);
    }
}