package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 > value2) {
            return 1;
        } else if (value1 < value2) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return value1 >= value2 ? value1 : value2;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int max = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                count++;
            }
        }

        int[] evenDigits = new int[count];
        for (int i = 0, j = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                evenDigits[j++] = values[i];
            }
        }
        return evenDigits;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        long fact = 1;
        for (int i = 1; i <= initialVal; i++) {
            fact *= i;
        }
        return initialVal == 0 ? 1 : fact;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        int [] fibArr = new int[number+1];
        for (int i = 0; i < fibArr.length; i++) {
            if (i == 0) {
                fibArr[0] = 0;
            } else if (i == 1) {
                fibArr[1] = 1;
            } else {
                fibArr[i] = fibArr[i-1] + fibArr[i-2];
            }
        }
        return fibArr[number];
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        if (values.length > 0) {
            int max = values[values.length - 1];
            int index = values.length - 1; //  индекс максимального числа в массиве
            int tmp; // значение максимального числа в массиве
            for (int i = 0; i < values.length - 1; i++) {
                for (int j = 0; j < values.length - i - 1; j++) {
                    if (values[j] > max) {
                        max = values[j];
                        index = j;
                    }
                }
                if (max !=  values[values.length - i - 1]) {
                    tmp = values[values.length - i - 1];
                    values[values.length - i - 1] = max;
                    values[index] = tmp;
                }
                if ((values.length - i - 1) != 0) {
                    max = values[values.length - i - 2];
                }
            }
        }
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        int i = 2;
        boolean isPrimary = false;
        if (number == 1 || number == 2) {
            return true;
        } else {
            while (i < 10 && i < number) {
                if (number % i != 0) {
                    isPrimary = true;
                    i++;
                } else {
                    isPrimary = false;
                    break;
                }
            }
            return isPrimary;
        }
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        if (values.length == 0) {
            return values;
        } else {
            int tmp;
            for (int i = 0; i < values.length/2; i++) {
                tmp = values[i];
                values[i] = values[values.length - i - 1];
                values[values.length - i - 1] = tmp;
            }
            return values;
        }
    }
}
