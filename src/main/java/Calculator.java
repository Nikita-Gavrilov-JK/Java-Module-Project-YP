import java.util.Scanner;

public class Calculator {
    int countPeople;
    private String productNames;
    private double totalSum;

    Calculator (int countPeople) {
        this.countPeople = countPeople;
        this.productNames = "";
        this.totalSum = 0;
    }

    public void culc () {
        Scanner scanner = new Scanner(System.in);
        double productCost;
        while (true) {
            System.out.println("Введите название товара: ");
            String productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("Завершить"))
                break;

            try {
                do {
                    System.out.println("Введите стоимость товара: ");
                    productCost = Double.parseDouble(scanner.nextLine());
                    if (productCost < 0){
                        System.out.println("Стоимость товара не может быть отрицательной");
                    }
                } while (productCost < 0);
                productNames += productName + "\n";
                totalSum += productCost;
                System.out.println("Товар \"" + productName +"\" добавлен! " + "Общая стоимость: " +
                        formatRub(totalSum) + "\nЕсли хотите \"завершить\" добавление товаров просто напишите;)");
            }
            catch (NumberFormatException e) {
                System.out.println("Неправильный формат стоимости товара!\nПопробуйте снова");
            }
        }

        System.out.println("Добавленные товары: \n" + productNames);
        System.out.println("Сумма которую должен заплатить каждый человек: " +
                formatRub(totalSum/countPeople));
        scanner.close();
    }
    public String formatRub (double sumRub) {
        int ruble = (int) sumRub;
        String strRub;
        if (ruble % 100 == 11 || ruble % 100 == 12 || ruble % 100 == 13 || ruble % 100 == 14) {
            strRub = "рублей";
        } else if (ruble % 10 == 1) {
            strRub = "рубль";
        } else if (ruble % 10 >= 2 && ruble % 10 <= 4) {
            strRub = "рубля";
        } else {
            strRub = "рублей";
        }
        return String.format("%.2f %s", sumRub, strRub);
    }
}