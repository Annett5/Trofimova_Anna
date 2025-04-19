public class practic3 {
    // Задание 28: Шифр Цезаря
    public static void caesarCipher() {
        String mes = "Hello World!";
        int shift = 3;
        String direct = "right"; // или "left"

        char[] chars = mes.toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (Character.isLetter(chars[i])) {
                char base = Character.isUpperCase(chars[i]) ? 'A' : 'a'; //помогает понять номер буквы
                if (direct.equals("right")) {
                    chars[i] = (char)((chars[i] - base + shift) % 26 + base);
                } else {
                    chars[i] = (char)((chars[i] - base - shift + 26) % 26 + base);
                }
            }
            i++;
        }
        System.out.println("Задание 28: " + new String(chars));
    }

    // Задание 29: Разность квадратов
    public static void squareDifference() {
        int n = 9;
        int a = 1;
        boolean found = false;

        while (!found) {
            int b = a + 1;
            int difference = b * b - a * a;

            if (difference == n) {
                System.out.println("Задание 29: " + n + " = " + (b*b) + " - " + (a*a));
                found = true;
            } else if (difference > n) {
                System.out.println("Задание 29: Решение не найдено");
                break;
            }
            a++;
        }
    }

    // Задание 30: Сумма степеней цифр
    public static void digitPowerSum() {
        int number = 695;
        int start = 2;
        String numStr = Integer.toString(number);

        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            sum += Math.pow(digit, start + i);
        }

        if (sum % number == 0) {
            System.out.println("Задание 30: " + sum + " = " + number + " * " + (sum/number));
        } else {
            System.out.println("Задание 30: Условие не выполняется");
        }
    }

    // Задание 31: Оптимальный маршрут
    public static void bestTravel() {
        int[] distances = {50, 55, 57, 58, 60};
        int maxDistance = 163;
        int citiesToVisit = 3;
        int bestSum = 0;

        for (int i = 0; i < distances.length; i++) {
            for (int j = i + 1; j < distances.length; j++) {
                for (int k = j + 1; k < distances.length; k++) {
                    int currentSum = distances[i] + distances[j] + distances[k];
                    if (currentSum <= maxDistance && currentSum > bestSum) {
                        bestSum = currentSum;
                    }
                }
            }
        }

        System.out.println("Задание 31: Максимальная сумма расстояний: " + bestSum);
    }

    // Задание 32: Анализ числа Фибоначчи
    public static void fibonacciAnalysis() {
        int n = 10;
        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        long number = fib[n];
        System.out.println(n + "-е число Фибоначчи: " + number);

        int[] digitCount = new int[10];
        String numStr = Long.toString(number);

        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            digitCount[digit]++;
        }

        int maxDigit = 0;
        int maxCount = digitCount[0];

        for (int i = 1; i < 10; i++) {
            if (digitCount[i] > maxCount || (digitCount[i] == maxCount && i > maxDigit)) {
                maxCount = digitCount[i];
                maxDigit = i;
            }
        }

        System.out.println("Задание 32: Цифра " + maxDigit + " встречается " + maxCount + " раз(а)");
    }

    // Задания 33-34: Игра с палочками
    public static void sticksGame() {
        long sticks = 10;
        long tanyaSticks = 0;
        boolean tanyaTurn = true;

        System.out.println("Начальное количество палочек: " + sticks);

        while (sticks > 0) {
            long taken;
            if (sticks % 2 == 0) {
                taken = sticks / 2;
            } else {
                taken = 1;
            }

            if (tanyaTurn) {
                tanyaSticks += taken;
                System.out.println("Таня взяла: " + taken);
            } else {
                System.out.println("Саша взял: " + taken);
            }

            sticks -= taken;
            tanyaTurn = !tanyaTurn;
        }

        System.out.println("Задание 33-34: Таня собрала " + tanyaSticks + " палочек");
    }

    public static void main(String[] args) {
        caesarCipher();
        squareDifference();
        digitPowerSum();
        bestTravel();
        fibonacciAnalysis();
        sticksGame();
    }
}

