public class pract1 {
    public static void main(String[] args) {

    // Task 1:
    String firstStr = "hello"; // пример
    String secondStr = "lo";
    boolean isEnding = true;
    if (firstStr.length() >= secondStr.length()) {
        for (int i = 0; i < secondStr.length(); i++) {
            if (firstStr.charAt(firstStr.length() - secondStr.length() + i) != secondStr.charAt(i)) {
                isEnding = false;
                break;
            }
        }
    } else {
        isEnding = false;
    }
    System.out.println(isEnding);

    // Task 2:
    String name = "аНнА"; // пример
    String pust = "";
    for (int i = 0; i < name.length(); i++) {
        char ch = name.charAt(i);
        if (i == 0) {
            pust += Character.toUpperCase(ch);
        } else {
            pust += Character.toLowerCase(ch);
        }
    }
    System.out.println("Привет, " + pust + "!");

    // Task 3:
    String inputStr = "example"; //
    String pust = "";
    for (int i = 0; i < inputStr.length(); i++) {
        char ch = inputStr.charAt(i);
        if ("aeiouAEIOU".indexOf(ch) == -1) {
            pust += ch;
        }
    }
    System.out.println(pust);

    // Task 4:
    int num1 = 5;
    int num2 = 1;
    int start = Math.min(num1, num2);
    for (int i = 1; i <= start; i++) {
        System.out.print(i * i + " ");
    }
    System.out.println();

    // Task 5:
    int sStart = 1;
    int stepSize = 2;
    int count = 5;
    int nach = sStart;
    for (int i = 0; i < count; i++) {
        System.out.print(nach + " ");
        nach += stepSize;
    }
    System.out.println();

    // Task 6:
    int[] memory = new int[3];
    int memoryCount = 0;
    int[] inputs = {7, 2, 5, 10}; // заданные числа
    for (int newNum : inputs) {
        if (memoryCount < 3) {
            memory[memoryCount] = newNum;
            memoryCount++;
        } else {
            int minIndex = 0;
            for (int i = 1; i < 3; i++) {
                if (memory[i] < memory[minIndex]) {
                    minIndex = i;
                }
            }
            memory[minIndex] = newNum;
        }
        for (int i = 0; i < memoryCount; i++) {
            System.out.print(memory[i] + " ");
        }
        System.out.println();
    }

    // Task 7:
    String duplicateWords = "abc abc ab abc ab acs acs"; // пример
    String[] words = duplicateWords.split(" ");
    String result = "";
    for (int i = 0; i < words.length; i++) {
        boolean isDuplicate = false;
        for (int j = 0; j < i; j++) {
            if (words[i].equals(words[j])) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            result += words[i] + " ";
        }
    }
    System.out.println(result.trim());

    // Task 8:
    String exStr = "ABccAAr";
    int upperCount = 0;
    int lowerCount = 0;
    for (int i = 0; i < exStr.length(); i++) {
        char ch = exStr.charAt(i);
        if (Character.isUpperCase(ch)) {
            upperCount++;
        } else if (Character.isLowerCase(ch)) {
            lowerCount++;
        }
    }
    if (upperCount > lowerCount) {
        System.out.println(exStr.toUpperCase());
    } else {
        System.out.println(exStr.toLowerCase());
    }
}
}

