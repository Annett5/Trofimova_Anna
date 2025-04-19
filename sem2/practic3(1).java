import java.util.*; // для сортировки упрощённой
import java.net.*; // нужен для работы с веб-адресами (36 задача)
import java.io.*; //для чтения ошибок (36 задача)

public class AllTasks {

    // Задача 35: Сортировка по сумме цифр веса
    public static void sortByDigitSum() {
        String weights = "56 65 74 100 99 68 86 180 90";
        String[] weightArr = weights.split(" ");

        int[][] weightWithSums = new int[weightArr.length][2];
        for (int i = 0; i < weightArr.length; i++) {
            int num = Integer.parseInt(weightArr[i]);
            weightWithSums[i][0] = num;
            weightWithSums[i][1] = sumOfDigits(num);
        }
        Arrays.sort(weightWithSums, (a, b) -> a[1] - b[1]); // Сортируем по сумме цифр
        StringBuilder result = new StringBuilder();
        for (int[] item : weightWithSums) {
            result.append(item[0]).append(" ");
        }
        System.out.println("Задача 35: " + result.toString().trim());
    }
    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Задача 36: Расшифровка Цезаря с использованием словаря
    public static void caesarDecrypt() throws IOException {
        String encrypted = "Khoor Zruog!";
        String dictionary = getDictionaryText();

        int bestShift = 0;
        int maxMatches = 0;
        for (int shift = 0; shift < 26; shift++) {
            String decrypted = decryptText(encrypted, shift);
            int matches = countDic(decrypted, dictionary);

            if (matches > maxMatches) {
                maxMatches = matches;
                bestShift = shift;
            }
        }
        String result = decryptText(encrypted, bestShift);
        System.out.println("Задача 36: Расшифрованный текст: " + result);
    }

    private static String getDictionaryText() throws IOException {
        URL url = new URL("https://fish-text.ru/get?&number=10000");
        try (Scanner scanner = new Scanner(url.openStream())) {
            return scanner.useDelimiter("\\A").next();
        }
    }

    private static String decryptText(String text, int shift) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                char base = Character.isUpperCase(chars[i]) ? 'A' : 'a';
                chars[i] = (char)(((chars[i] - base - shift + 26) % 26) + base);
            }
        }
        return new String(chars);
    }

    private static int countDic(String text, String dictionary) {
        int count = 0;
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (dictionary.contains(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    // Задача 37: Игра с угадыванием кода
    public static void guessCodeGame() {
        int[] secretCode = {generateRandomDigit(), generateRandomDigit(),
                generateRandomDigit(), generateRandomDigit()};
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Задача 37: Угадайте 4-значный код (цифры 0-9)");

        while (attempts < 20) {
            System.out.print("Попытка " + (attempts + 1) + ": ");
            String input = scanner.nextLine();
            int[] guess = parseGuess(input);
            if (guess.length != 4) {
                System.out.println("Введите ровно 4 цифры!");
                continue;
            }
            int matches = countMatches(secretCode, guess);
            System.out.println("Совпадений: " + matches);
            if (matches == 4) {
                System.out.println("Поздравляем! Вы угадали код!");
                return;
            }
            attempts++;
        }
        System.out.println("Вы проиграли. Код был: " + Arrays.toString(secretCode));
    }
    private static int generateRandomDigit() {
        return (int)(Math.random() * 10);
    }
    private static int[] parseGuess(String input) {
        int[] guess = new int[4];
        for (int i = 0; i < 4 && i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                guess[i] = input.charAt(i) - '0';
            }
        }
        return guess;
    }

    private static int countMatches(int[] secret, int[] guess) {
        int matches = 0;
        for (int i = 0; i < 4; i++) {
            if (secret[i] == guess[i]) {
                matches++;
            }
        }
        return matches;
    }

    // Задача 38: Игра "Каждый третий"
    public static void everyThirdGame() {
        int playersCount = 7;
        int startPlayer = 1;

        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= playersCount; i++) {
            players.add(i);
        }

        List<Integer> eliminated = new ArrayList<>();
        int currentIndex = startPlayer - 1;

        while (players.size() > 1) {
            currentIndex = (currentIndex + 2) % players.size();
            eliminated.add(players.remove(currentIndex));
        }

        eliminated.add(players.get(0)); // Добавляем победителя

        System.out.println("Задача 38: Порядок выбывания: " + eliminated);
    }
    // Задача 39: Преобразование текста (первая буква в конец + "ауч")
    public static void transformText() {
        String text = "Привет, как дела? Это тестовый текст.";
        System.out.println("Исходный текст: " + text);

        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                // Проверяем, есть ли знак препинания в конце слова
                boolean hasPunctuation = Character.isLetterOrDigit(word.charAt(word.length()-1)) ? false : true;
                String punctuation = "";
                String cleanWord = word;

                if (hasPunctuation) {
                    punctuation = word.substring(word.length()-1);
                    cleanWord = word.substring(0, word.length()-1);
                }

                if (cleanWord.length() > 0) {
                    String transformed = cleanWord.substring(1) +
                            cleanWord.charAt(0) +
                            "ауч" + punctuation;
                    result.append(transformed).append(" ");
                } else {
                    result.append(word).append(" ");
                }
            }
        }

        System.out.println("Задача 39: " + result.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        sortByDigitSum();
        caesarDecrypt();
        guessCodeGame();
        everyThirdGame();
        transformText();
    }
}