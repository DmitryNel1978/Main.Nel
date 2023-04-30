import java.util.Scanner; // импортируем класс Scanner для работы с вводом пользовательских данных

class Main {
    // создаем метод calc, который будет принимать строку с выражением и возвращать результат вычислений или сообщение об ошибке
    public static String calc(String input) {
        String[] parts = input.split(" ");// разбиваем строку на части по пробелам , если без пробелов то можно заменить на эту строку String[] parts = input.split("(?<=[-+*/])|(?=[-+*/])");
        int a, b;
        if (parts.length != 3) { // проверяем, что выражение состоит из трех частей (двух чисел и оператора)
            return "throws Exception"; // если не соответствует формату, возвращаем сообщение об ошибке
        }
        try {
            a = Integer.parseInt(parts[0]); // пытаемся преобразовать первую часть в целое число
            b = Integer.parseInt(parts[2]); // пытаемся преобразовать третью часть в целое число
        } catch (NumberFormatException e) {
            return "throws Exception"; // если не удалось преобразовать, возвращаем сообщение об ошибке
        }
        if (a < 1 || a > 10 || b < 1 || b > 10) { // проверяем, что числа находятся в диапазоне от 1 до 10
            return "throws Exception"; // если не находятся, возвращаем сообщение об ошибке
        }
        int result;
        switch (parts[1]) { // проверяем оператор
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) { // проверяем, что делитель не равен нулю
                    return "throws Exception"; // если равен, возвращаем сообщение об ошибке
                }
                result = a / b;
                break;
            default:
                return "throws Exception"; // если оператор не соответствует ни одному из допустимых, возвращаем сообщение об ошибке
        }
        return Integer.toString(result); // возвращаем результат вычислений в виде строки
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // создаем объект класса Scanner для чтения пользовательского ввода
        String input = scanner.nextLine(); // считываем строку с выражением
        String result = calc(input); // вызываем метод calc для вычисления результата
        System.out.println(result); // выводим результат на экран
    }
}