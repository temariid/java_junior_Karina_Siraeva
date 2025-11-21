package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;
// 1 Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(Point leftTop, Point rightBottom) {
        this.topLeft = new Point(leftTop.getX(), leftTop.getY());
        this.bottomRight = new Point(rightBottom.getX(), rightBottom.getY());
    }
// 2 Создает Rectangle по координатам углов - левого верхнего и правого нижнего.

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(xRight, yBottom);
    }
// 3 Создает Rectangle, левый нижний угол которого находится в начале координат, а  длина (по оси X) и ширина (по оси Y) задаются.
    public Rectangle(int length, int width) {
        this.topLeft = new Point(0, -width);     // верхняя точка выше нуля
        this.bottomRight = new Point(length, 0); // нижняя точка на нуле
    }
// 4 Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
    public Rectangle() {
        this(1, 1);
    }
// 5 Возвращает левую верхнюю точку Rectangle.
    public Point getTopLeft() {
        return new Point(topLeft.getX(), topLeft.getY());
    }
// 6 Возвращает правую нижнюю точку Rectangle.
    public Point getBottomRight() {
        return new Point(bottomRight.getX(), bottomRight.getY());
    }
// 7 Устанавливает левую верхнюю точку Rectangle
    public void setTopLeft(Point topLeft) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    }
// 8 Устанавливает правую нижнюю точку Rectangle.
    public void setBottomRight(Point bottomRight) {
        this.bottomRight = new Point(bottomRight.getX(), bottomRight.getY());
    }
// 9 Возвращает длину прямоугольника.
    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }
// 10 Возвращает ширину прямоугольника
    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }
// 11 Передвигает Rectangle в точку (x, y).
    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        topLeft.setX(x);
        topLeft.setY(y);
        bottomRight.setX(x + length);
        bottomRight.setY(y + width);
    }
// 12 Передвигает Rectangle в точку point
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }
// 13 Передвигает Rectangle на (dx, dy).
    public void moveRel(int dx, int dy) {
        topLeft.setX(topLeft.getX() + dx);
        topLeft.setY(topLeft.getY() + dy);
        bottomRight.setX(bottomRight.getX() + dx);
        bottomRight.setY(bottomRight.getY() + dy);
    }
// 14 Изменяет обе стороны Rectangle в ratio раз при сохранении координат левой верхней вершины. Дробная часть координат отбрасывается.
    public void resize(double ratio) {
        int newLength = (int) (getLength() * ratio);
        int newWidth = (int) (getWidth() * ratio);
        bottomRight.setX(topLeft.getX() + newLength);
        bottomRight.setY(topLeft.getY() + newWidth);
    }
// 15 Изменяет длину Rectangle в xRatio раз, а ширину в yRatio раз при сохранении координат левой верхней вершины. Дробная часть координат отбрасывается.
    public void stretch(double xRatio, double yRatio) {
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);
        bottomRight.setX(topLeft.getX() + newLength);
        bottomRight.setY(topLeft.getY() + newWidth);
    }
//16 Возвращает площадь прямоугольника.
    public double getArea() {
        return getLength() * getWidth();
    }
// 17 Возвращает периметр прямоугольника.
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }
// 18 Определяет, лежит ли точка (x, y) внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX() &&
                y >= topLeft.getY() && y <= bottomRight.getY();
    }
// 19 Определяет, лежит ли точка point внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
// 20 Определяет, пересекается  ли Rectangle с другим Rectangle. Считается, что прямоугольники пересекаются, если у них есть хоть одна общая точка.
    public boolean isIntersects(Rectangle rectangle) {
        return !(rectangle.getTopLeft().getX() > bottomRight.getX() ||
                rectangle.getBottomRight().getX() < topLeft.getX() ||
                rectangle.getTopLeft().getY() > bottomRight.getY() ||
                rectangle.getBottomRight().getY() < topLeft.getY());
    }
// 21 Определяет, лежит ли rectangle целиком внутри текущего Rectangle.
    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.getTopLeft()) && isInside(rectangle.getBottomRight());
    }
    // 22 Не пишите эти методы сами, используйте средства IDEA.

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft) && Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}

