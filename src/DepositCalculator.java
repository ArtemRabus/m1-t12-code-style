import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double year, int period) {
        double pay = amount * Math.pow((1 + year / 12), 12 * period);
        return random(pay, 2);
    }

    double calculateSimplePercent(double amount, double year, int period) {
        return random(amount + amount * year * period, 2);
    }

    double random(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateAll() {
        int period;
        int type;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        type = scanner.nextInt();

        double result = 0;

        if (type == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (type == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateAll();
    }
}
