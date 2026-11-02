import java.util.Scanner;

/**
 * Практична робота №2 — Робота з типами даних, типи-обгортки.
 * Виконав: Савич Олексій, група Кб-21.
 *
 * 1) Виводимо інформацію про всі примітивні типи: назву, розмір, мінімальне та максимальне значення
 *    (дані беремо з констант класів-обгорток).
 * 2) Зчитуємо з терміналу рядки (Scanner.nextLine()) і перетворюємо їх на потрібний тип
 *    за допомогою методів класів-обгорток (Integer.parseInt() тощо).
 */
public class Lab2 {

    public static void main(String[] args) {
        // ---------- Частина 1: інформація про примітивні типи ----------
        System.out.println("=== Примітивні типи даних Java ===");
        // Шапка таблиці: назва, розмір у бітах і байтах, мінімум, максимум
        System.out.printf("%-8s | %-6s | %-6s | %-24s | %-24s%n", "Тип", "Біт", "Байт", "Мінімум", "Максимум");
        System.out.println("-".repeat(80));

        // Цілочисельні типи — константи SIZE, BYTES, MIN_VALUE, MAX_VALUE класів-обгорток
        System.out.printf("%-8s | %-6d | %-6d | %-24d | %-24d%n", "byte", Byte.SIZE, Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("%-8s | %-6d | %-6d | %-24d | %-24d%n", "short", Short.SIZE, Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("%-8s | %-6d | %-6d | %-24d | %-24d%n", "int", Integer.SIZE, Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("%-8s | %-6d | %-6d | %-24d | %-24d%n", "long", Long.SIZE, Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE);

        // Дробові типи: MIN_VALUE — це найменше ДОДАТНЕ значення, тому мінімум = -MAX_VALUE
        System.out.printf("%-8s | %-6d | %-6d | %-24s | %-24s%n", "float", Float.SIZE, Float.BYTES, -Float.MAX_VALUE, Float.MAX_VALUE);
        System.out.printf("%-8s | %-6d | %-6d | %-24s | %-24s%n", "double", Double.SIZE, Double.BYTES, -Double.MAX_VALUE, Double.MAX_VALUE);

        // char — символ Unicode, виводимо коди мінімального та максимального символу
        System.out.printf("%-8s | %-6d | %-6d | %-24d | %-24d%n", "char", Character.SIZE, Character.BYTES,
                (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);

        // boolean не має констант розміру — розмір залежить від JVM, значення лише false/true
        System.out.printf("%-8s | %-6s | %-6s | %-24s | %-24s%n", "boolean", "1*", "-", Boolean.FALSE, Boolean.TRUE);
        System.out.println("* логічно 1 біт, фактичний розмір у пам'яті визначає JVM");
        System.out.println();

        // ---------- Частина 2: введення рядків і перетворення типів ----------
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Перетворення введених рядків на примітивні типи ===");

        // Для кожного типу просимо ввести рядок і перетворюємо його методом класу-обгортки
        byte b = Byte.parseByte(readLine(scanner, "Введіть значення типу byte: "));
        System.out.println("  -> byte = " + b);

        short s = Short.parseShort(readLine(scanner, "Введіть значення типу short: "));
        System.out.println("  -> short = " + s);

        int i = Integer.parseInt(readLine(scanner, "Введіть значення типу int: "));
        System.out.println("  -> int = " + i);

        long l = Long.parseLong(readLine(scanner, "Введіть значення типу long: "));
        System.out.println("  -> long = " + l);

        float f = Float.parseFloat(readLine(scanner, "Введіть значення типу float: "));
        System.out.println("  -> float = " + f);

        double d = Double.parseDouble(readLine(scanner, "Введіть значення типу double: "));
        System.out.println("  -> double = " + d);

        // Boolean.parseBoolean повертає true лише для рядка "true" (без урахування регістру)
        boolean bool = Boolean.parseBoolean(readLine(scanner, "Введіть значення типу boolean (true/false): "));
        System.out.println("  -> boolean = " + bool);

        // Для char беремо перший символ рядка (Character.valueOf обгортає його в об'єкт)
        Character ch = Character.valueOf(readLine(scanner, "Введіть символ (char): ").charAt(0));
        System.out.println("  -> char = " + ch + " (код " + (int) ch.charValue() + ")");

        scanner.close();
    }

    /** Виводить запрошення і повертає непорожній рядок, введений користувачем. */
    private static String readLine(Scanner scanner, String prompt) {
        String line;
        do {
            System.out.print(prompt);
            line = scanner.nextLine().trim(); // зчитуємо весь рядок і прибираємо пробіли по краях
        } while (line.isEmpty());             // порожній рядок не приймаємо — питаємо ще раз
        return line;
    }
}
