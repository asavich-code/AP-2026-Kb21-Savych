import java.text.MessageFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Практична робота №3 — Форматоване виведення даних у Java.
 * Виконав: Савич Олексій, група Кб-21.
 *
 * Користувач вводить ціле число, число з плаваючою точкою, рядок і логічне значення.
 * Програма виводить введені дані 10 разів у різних форматах, використовуючи 3 підходи з лекції 1.6:
 *   1) System.out.println (конкатенація рядків);
 *   2) MessageFormat.format;
 *   3) System.out.format / printf.
 */
public class Lab3_Savych_Kb21 {

    public static void main(String[] args) {
        // Locale.US — щоб дробова частина вводилась і виводилась через крапку
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // ---------- Введення даних ----------
        System.out.print("Введіть ціле число: ");
        int number = scanner.nextInt();

        System.out.print("Введіть число з плаваючою точкою: ");
        double real = scanner.nextDouble();
        scanner.nextLine(); // забираємо символ нового рядка, що залишився після nextDouble()

        System.out.print("Введіть рядок: ");
        String text = scanner.nextLine();

        System.out.print("Введіть логічне значення (true/false): ");
        boolean flag = scanner.nextBoolean();

        System.out.println();
        System.out.println("=== Результати форматованого виведення ===");

        // ---------- Підхід 1: System.out.println ----------
        // Формат 1: проста конкатенація всіх значень
        System.out.println("1) println: ціле = " + number + ", дробове = " + real
                + ", рядок = " + text + ", логічне = " + flag);
        // Формат 2: ціле у двійковій, вісімковій та шістнадцятковій системі (методи класу Integer)
        System.out.println("2) println: " + number + " -> bin " + Integer.toBinaryString(number)
                + ", oct " + Integer.toOctalString(number) + ", hex " + Integer.toHexString(number));

        // ---------- Підхід 2: MessageFormat.format ----------
        // Формат 3: підстановка за номером аргументу, порядок аргументів змінено
        System.out.println(MessageFormat.format("3) MessageFormat: рядок \"{2}\", ціле {0}, логічне {3}, дробове {1}",
                String.valueOf(number), String.valueOf(real), text, flag));
        // Формат 4: дробове як відсотки та ціле як ціле число з розділювачем тисяч
        System.out.println(MessageFormat.format("4) MessageFormat: відсотки {0,number,percent}, ціле {1,number,integer}",
                real, number));
        // Формат 5: дробове як грошова сума (валюта для Locale.US)
        System.out.println(new MessageFormat("5) MessageFormat: як валюта {0,number,currency}", Locale.US)
                .format(new Object[]{real}));

        // ---------- Підхід 3: System.out.format / printf ----------
        // Формат 6: ціле у полі шириною 10, вирівнювання праворуч і ліворуч
        System.out.format("6) format: [%10d] [%-10d]%n", number, number);
        // Формат 7: ціле з нулями попереду, зі знаком і в шістнадцятковій/вісімковій системі
        System.out.format("7) format: %08d | %+d | hex %X | oct %o%n", number, number, number, number);
        // Формат 8: дробове з 2 знаками, з 5 знаками та в експоненційному вигляді
        System.out.format(Locale.US, "8) format: %.2f | %.5f | %e%n", real, real, real);
        // Формат 9: рядок у полі шириною 15 праворуч, ліворуч і обрізаний до 3 символів
        System.out.format("9) format: [%15s] [%-15s] [%.3s]%n", text, text, text);
        // Формат 10: логічне значення, великими літерами та в полі шириною 8
        System.out.printf("10) printf: %b | %B | [%8b]%n", flag, flag, flag);

        scanner.close();
    }
}
