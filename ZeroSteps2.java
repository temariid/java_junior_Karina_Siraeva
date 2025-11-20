package academy.tochkavhoda.introduction;

public class ZeroSteps2 {
    //Возвращает сумму квадратов целых чисел от 1 до
    public int sumSquares(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
        }
        return sum;
    }
    //Возвращает сумму квадратов целых чисел от 1 до count
    public int sumOdds(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i += 2) {  //нечет
            sum += i;
        }
        return sum;
    }
    //Возвращает сумму обратных величин целых чисел от 1 до count
    public double sumInverses(int count) {
        double sum = 0.0;
        for (int i = 1; i <= count; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
    //Возвращает произведение целых чисел от 1 до count
    // (факториал от count)
    public long factorial(int count) {
        long result = 1;
        for (int i = 2; i <= count; i++) {
            result *= i;
        }
        return result;
    }
    //Возвращает произведение цифр целого числа
    public int prodDigits(int value) {
        if (value == 0) return 0;
        value = Math.abs(value);
        int prod = 1;
        while (value > 0) {
            prod *= value % 10;
            value /= 10;
        }
        return prod;
    }
    //Возвращает число Фибоначчи номер number. Не использовать рекурсию.
    //Число Фибоначчи определяется следующим образом : fibonacci(0) == 0, fibonacci(1) == 1, fibonacci
    //(number) = fibonacci (number -1) + fibonacci (number -2). Список первых чисел Фибоначчи : 0, 1, 1, 2,
    //3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946
    public int fibonacci(int number) {
        if (number <= 1) return number;
        int a = 0, b = 1;
        for (int i = 2; i <= number; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    //Возвращает сумму всех степеней 2 от 2^0 до 2^max
    public long sum2Powers(int max) {
        long sum = 0;
        for (int i = 0; i <= max; i++) {
            sum += 1L << i;
        }
        return sum;
    }
    //Возвращает сумму квадратов целых чисел от 1 до count. Суммирование прекращается как только
    //сумма станет больше barrier
    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            int square = i * i;
            sum += square;
            if (sum > barrier) {
                break;
            }
        }
        return sum;
    }
    //Возвращает сумму всех произведений i*j (1 <=i <= count1 и 1 <=j <= count2)
    public int sumPairProd(int count1, int count2) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += i * j;
            }
        }
        return sum;
    }
    //Возвращает сумму тех произведений i*j, (1 <=i <= count1 и 1 <=j <= count2), которые меньше barrier
    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                int prod = i * j;
                if (prod >= barrier) continue;
                sum += prod;
            }
        }
        return sum;
    }
    //Возвращает сумму всех величин 1/(i*j) (1 <=i <= count1 и 1 <=j <= count2)
    public double sumInversePairProd(int count1, int count2) {
        double sum = 0.0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += 1.0 / (i * j);
            }
        }
        return sum;
    }
    //Возвращает сумму всех произведений i*j *k (1 <=i <= count1, 1 <=j <= count2, 1 <=k <= count3)
    public int sumTripleProd(int count1, int count2, int count3) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                for (int k = 1; k <= count3; k++) {
                    sum += i * j * k;
                }
            }
        }
        return sum;
    }
    //Возвращает значение числа e, вычисляемое по следующей формуле
    //1 + 1/(1) + 1 / (1 * 2) + 1 / (1* 2 * 3) + 1 / (1* 2 * 3 * 4) + 1 / (1* 2 * 3 * 4 * 5) + …
    //Суммирование вести до тех пор, пока очередной элемент не станет меньше 1E-6
    public double calculateE() {
        double e = 1.0;
        double term = 1.0;
        int n = 1;
        while (term >= 1e-6) {
            term /= n;
            e += term;
            n++;
        }
        return e;
    }
    //Суммирование вести до тех пор, пока очередной элемент по абсолютной величине не станет меньше
    //1E-8
    public double calculatePi() {
        double sum = 0.0;
        double term = 1.0;
        int denominator = 1;
        int sign = 1;
        while (Math.abs(term) >= 1E-8) {
            sum += term;
            denominator += 2;
            sign *= -1;
            term = (double) sign / denominator;
        }
        return 4 * sum;
    }
    //На плоскости задан квадрат со стороной length и вписанный в него круг, Центр квадрата (и, следовательно, круга) находится в точке (length/2, length/2) Случайным образом count раз выбирается
    //точка, лежащая внутри квадрата. Эта точка может оказаться внутри круга или нет.
    //Вычислить площадь круга по формуле
    //S = length * length * k / count
    //где k - количество точек, попавших в круг
    //Этот метод носит название “метод Монте-Карло”, точность его невысока.
    //Проверьте работу тестов в консольном окне, запишите все классы на сервер (не забудьте изменить
    // текст сообщения в git commit!) и убедитесь, что на сервере все тесты также проходят успешно (см.
    //Задание в Модуле 3, п.10-14)
    public double calculateCircleSquare(double length, int count) {
        double center = length / 2.0;
        double radius = center;
        int inside = 0;
        for (int i = 0; i < count; i++) {
            double x = Math.random() * length;
            double y = Math.random() * length;
            // расстояние от точки до центра
            double distance = Math.sqrt((x - center) * (x - center) + (y - center) * (y - center));
            if (distance <= radius) {
                inside++;
            }
        }
        return length * length * (double) inside / count;
    }
}


