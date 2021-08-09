package ru.geekbrains.ntr_0102;

public class Main {

    public static void main(String[] args) {

        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] array1 = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array1.length; i++) {
            array1[i] ^= 1;
        }

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями
        // 0 3 6 9 12 15 18 21;
        int[] array2 = new int[8];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = 3 * i;
        }

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
        // умножить на 2;
        int[] array3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            array3[i] = array3[i] < 6 ? 2 * array3[i] : array3[i];
        }

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] array4 = new int[5][5];
        for (int i = 0; i < array4.length; i++) {
            array4[i][i] = 1;
            array4[i][array4.length - i - 1] = 1;
        }

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] array5 = new int[]{3, 5, 7, 9, 4, 42, -34, -5, 6, -2};
        if (array5.length != 0) {
            int min = array5[0];
            int max = array5[0];
            for (int number : array5) {
                if (number < min) min = number;
                if (number > max) max = number;
            }
            System.out.println("Array min: " + min);
            System.out.println("Array max: " + max);
        }

        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.
        int[] array6 = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(array6));

        // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения
        // задачи нельзя пользоваться вспомогательными массивами.
        int[] array7 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        pushArray(array7, 2);
        pushArray(array7, -2);
        pushArray(array7, +3);
        pushArray(array7, -3);
        pushArray(array7, 0);
    }

    // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.

    public static boolean checkBalance(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < array.length; i++) {
            sumRight += array[i];
        }
        for (int i = 0; i < array.length-1; i++) {
            sumLeft += array[i];
            sumRight -= array[i];
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения
    // задачи нельзя пользоваться вспомогательными массивами.
    public static void pushArray(int[] array, int shift) {      

        shift = Math.abs(shift) > array.length ? shift % array.length : shift;

        if (shift == 0) return;

        for (int i = 0; i < Math.abs(shift); i++) {
            if (shift > 0) {
                int temp = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;
            } else {
                int temp = array[0];
                for (int j = 1; j < array.length; j++) {
                    array[j-1] = array[j];
                }
                array[array.length-1] = temp;
            }
        }
    }
}
