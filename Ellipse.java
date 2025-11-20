package academy.tochkavhoda.figures.v1;

public class Ellipse {
    private Point center;
    private int xAxis;
    private int yAxis;
// 1 Создает Ellipse по координатам центра и размерам осей
    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = new Point(center.getX(), center.getY());
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
// 2 Создает Ellipse по координатам центра и размерам осей
    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.center = new Point(xCenter, yCenter);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
// 3 Создает Ellipse с центром в точке (0,0) с указанными размерами осей
    public Ellipse(int xAxis, int yAxis) {
        this(0, 0, xAxis, yAxis);
    }
// 4 Создает Ellipse с центром в точке (0,0) и единичными размерами осей
    public Ellipse() {
        this(1, 1);
    }
// 5 	Возвращает центр Ellipse.
    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }
// 6 Возвращает размер оси Ellipse по X
    public int getXAxis() {
        return xAxis;
    }
// 7 Возвращает размер оси Ellipse по Y
    public int getYAxis() {
        return yAxis;
    }
// 8 Устанавливает размер оси Ellipse по X
    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }
// 9 Устанавливает размер оси Ellipse по Y
    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }
// 10	Устанавливает центр Ellipse.
    public void setCenter(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }
// 11 	Передвигает Ellipse в точку (x, y).
    public void moveTo(int x, int y) {
        center.setX(x);
        center.setY(y);
    }
// 12 	Передвигает Ellipse в точку point.
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }
// 13 	Передвигает Ellipse на (dx, dy).
    public void moveRel(int dx, int dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dy);
    }
// 14 Увеличивает оси Ellipse в n раз, не изменяя центра. Дробная часть вычисленных осей отбрасывается.
    public void resize(double ratio) {
        xAxis = (int) (xAxis * ratio);
        yAxis = (int) (yAxis * ratio);
    }
// 15 Увеличивает ось X Ellipse в xRatio раз и ось Y Ellipse в yRatio раз, не изменяя центра. Дробная часть вычисленных осей отбрасывается.
    public void stretch(double xRatio, double yRatio) {
        xAxis = (int) (xAxis * xRatio);
        yAxis = (int) (yAxis * yRatio);
    }
// 16 Возвращает площадь Ellipse.
    public double getArea() {
        return Math.PI * xAxis * yAxis;
    }
// 17 Возвращает периметр Ellipse. Для вычисления используйте формулу P= 2π * sqrt((XAxis2+YAxis2)/8)
    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((xAxis * xAxis + yAxis * yAxis) / 8.0);
    }
// 18 Определяет, лежит ли точка (x, y) внутри Ellipse. Если точка лежит на линии эллипса, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        int dx = x - center.getX();
        int dy = y - center.getY();
        return (dx * dx / (double)(xAxis * xAxis) + dy * dy / (double)(yAxis * yAxis)) <= 1.0;
    }
// 19 Определяет, лежит ли точка point внутри Ellipse. Если точка лежит на линии эллипса, считается, что она лежит внутри.
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
// 20 Не пишите эти методы сами, используйте средства IDEA.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis && yAxis == ellipse.yAxis && center.equals(ellipse.center);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * center.hashCode() + xAxis) + yAxis;
    }
}
