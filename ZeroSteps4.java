package academy.tochkavhoda.introduction;

public class ZeroSteps4 {
    private static final ZeroSteps3 steps3 = new ZeroSteps3();
    // 1 Возвращает минимальное из чисел, заданных двумерным массивом matrix. Для пустого двумерного
    //массива возвращает Integer.MAX_VALUE.
    public int min(int[][] matrix){
        if (matrix == null || matrix.length == 0) return Integer.MAX_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            if (row != null && row.length > 0) {
                int rowMin = steps3.min(row);
                if (rowMin < minVal) minVal = rowMin;
            }
        }
        return minVal;
    }
    // 2 Возвращает максимальное из чисел, заданных двумерным массивом matrix. Для пустого двумерного
    //массива возвращает Integer.MIN_VALUE.
    public int max(int[][] matrix){
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            if (row != null && row.length > 0) {
                int rowMax = steps3.max(row);
                if (rowMax > maxVal) maxVal = rowMax;
            }
        }
        return maxVal;
    }

    // 3 Возвращает true, если в двумерном массиве matrix имеется элемент, равный value, иначе false.
    public boolean find(int[][] matrix, int value){
        if (matrix == null) return false;
        for (int[] row : matrix) {
            if (row != null && steps3.find(row, value)) {
                return true;
            }
        }
        return false;
    }

    // 4 Возвращает true, если все строки двумерного массива matrix строго упорядочены по убыванию, иначе
    //false. Пустая строка считается упорядоченной.
    public boolean isSortedDescendant(int[][] matrix){
        if (matrix == null) return true;
        for (int[] row : matrix) {
            if (row != null && !steps3.isSortedDescendant(row)) {
                return false;
            }
        }
        return true;
    }
    // 5 Возвращает количество строк двумерного массива matrix, не содержащих нулевого элемента.
    public int hasNoZeroRows(int[][] matrix){
        if (matrix == null) return 0;
        int count = 0;
        for (int[] row : matrix) {
            if (row != null && !steps3.find(row, 0)) {
                count++;
            }
        }
        return count;
    }

    // 6 Возвращает true, если в двумерном массиве matrix есть хотя бы одна строка, состоящая только из
    //нулевых элементов, иначе false.
    public boolean hasFullZeroRow(int[][] matrix){
            if (matrix == null) return false;
            for (int[] row : matrix) {
                if (row != null && row.length > 0) {
                    boolean allZero = true;
                    for (int value : row) {
                        if (value != 0) {
                            allZero = false;
                            break;
                        }
                    }
                    if (allZero) return true;
                }
            }
            return false;
    }
    // 7 Возвращает true, если в квадратном двумерном массиве matrix все элементы симметричны
    //относительно главной диагонали (то есть a[i][j] == a[j][i]), иначе false.
    public boolean isSymmetric(int[][] matrix){
        if (matrix == null || matrix.length == 0) return true;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i] == null || matrix[i].length != n) return false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) return false;
            }
        }
        return true;
    }

    // 8 Возвращает максимальное из чисел, находящихся на главной диагонали квадратного двумерного
    //массива matrix. Для пустого двумерного массива возвращает Integer.MIN_VALUE
    public int mainDiagonalMax(int[][] matrix){
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != null && i < matrix[i].length) {
                maxVal = Math.max(maxVal, matrix[i][i]);
            }
        }
        return maxVal;
    }

    // 9 Возвращает сумму положительных элементов главной диагонали квадратного двумерного массива
    //matrix.
    public int mainDiagonalPositivesSum(int[][] matrix){
        if (matrix == null || matrix.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != null && i < matrix[i].length && matrix[i][i] > 0) {
                sum += matrix[i][i];
            }
        }
        return sum;
    }
    // 10 Возвращает максимальное из чисел, находящихся на побочной диагонали квадратного двумерного
    //массива matrix. Для пустого двумерного массива возвращает Integer.MIN_VALUE
    public int secondaryDiagonalMax(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
        int n = matrix.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (matrix[i] != null && (n - 1 - i) < matrix[i].length) {
                maxVal = Math.max(maxVal, matrix[i][n - 1 - i]);
            }
        }
        return maxVal;
    }
    // 11 Возвращает сумму положительных элементов побочной диагонали квадратного двумерного массива
    //matrix.
    public int secondaryDiagonalPositivesSum(int[][] matrix){
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i] != null && (n - 1 - i) < matrix[i].length && matrix[i][n - 1 - i] > 0) {
                sum += matrix[i][n - 1 - i];
            }
        }
        return sum;
    }
    // 12 Возвращает сумму двух двумерных массивов matrix1 и matrix2 одинаковых размеров. Суммой
    //является новый двумерный массив того же размера, элементы которого вычисляются по формуле
    //matrix1[i][j] + matrix2[i][j]. Строки массивов могут иметь разную длину, в том числе и нулевую.
    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null || matrix1.length != matrix2.length) {
            return new int[0][];   // по условию задачи — "пустой" массив
        }

        int rows = matrix1.length;
        int[][] result = new int[rows][];

        for (int i = 0; i < rows; i++) {
            if (matrix1[i] == null || matrix2[i] == null || matrix1[i].length != matrix2[i].length) {
                return new int[0][];   // размеры строк не совпадают → возвращаем "пустой"
            }

            int cols = matrix1[i].length;
            result[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    // 13 Транспонирует квадратный массив matrix, то есть меняет друг с другом значения matrix[i][j] и
    //matrix[j][i] для всех i, j
    public void transpose(int[][] matrix){
        if (matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    //  Меняет местами четные и нечетные строки двумерного массива matrix. Количество строк в массиве
    //четное. Строки массивов могут иметь разную длину, в том числе и нулевую.
    public void interchange(int[][] matrix){
        if (matrix == null || matrix.length % 2 != 0) return;
        for (int i = 0; i < matrix.length; i += 2) {
            int[] temp = matrix[i];
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = temp;
        }
    }

    // 15 По двумерному массиву matrix делает одномерный массив, переписывая туда все элементы matrix,
    //при проходе ее по строкам. Строки matrix могут иметь разную длину, в том числе и нулевую.
    public int[] toLinearByRow(int[][] matrix){
        if (matrix == null) return new int[0];
        int total = 0;
        for (int[] row : matrix) if (row != null) total += row.length;
        int[] result = new int[total];
        int idx = 0;
        for (int[] row : matrix) {
            if (row != null) {
                for (int val : row) result[idx++] = val;
            }
        }
        return result;
    }

    // 16 По двумерному квадратному массиву matrix делает одномерный массив, переписывая туда все
    //элементы matrix, при проходе ее по столбцам.
    public int[] toLinearByColumn(int[][] matrix){
        if (matrix == null || matrix.length == 0) return new int[0];
        int n = matrix.length;
        int[] result = new int[n * n];
        int idx = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i] != null && j < matrix[i].length) {
                    result[idx++] = matrix[i][j];
                }
            }
        }
        return result;
    }
    // 17 По двумерному квадратному массиву matrix делает одномерный массив, переписывая туда все
    //элементы верхнего треугольника matrix (то есть элементы на главной диагонали и выше ее), при
    //проходе ее по строкам.
    public int[] toLinearByRowUpperTriangle(int[][] matrix){
        if (matrix == null || matrix.length == 0) return new int[0];
        int n = matrix.length;
        int size = n * (n + 1) / 2;
        int[] result = new int[size];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (matrix[i] != null && j < matrix[i].length) {
                    result[idx++] = matrix[i][j];
                }
            }
        }
        return result;
    }

    // 18 Находит сумму элементов двумерного массива matrix, проходя его по строкам. В каждой строке
    //суммируются элементы ее , пока не встретится элемент со значением barrier, его в сумму не
    //включают. Если такой элемент не встретится, в сумму добавляются все элементы данной строки
    //матрицы. Строки matrix могут иметь разную длину, в том числе и нулевую.
    public int sumUntilNotFoundInRow(int[][] matrix, int barrier){
        if (matrix == null) return 0;
        int total = 0;
        for (int[] row : matrix) {
            if (row == null) continue;
            for (int val : row) {
                if (val == barrier) break;
                total += val;
            }
        }
        return total;
    }

    // 19 Находит сумму элементов двумерного массива matrix, проходя его по строкам пока не встретится
    //элемент со значением barrier, его в сумму не включают. Если такой элемент не встретится, находит
    //сумму всех элементов матрицы. Строки matrix могут иметь разную длину, в том числе и нулевую.
    public int sumUntilNotFound(int[][] matrix, int barrier){
        if (matrix == null) return 0;
        int total = 0;
        for (int[] row : matrix) {
            if (row == null) continue;
            for (int val : row) {
                if (val == barrier) return total;
                total += val;
            }
        }
        return total;
    }
    }

