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

            while (true) {
                try {
                    System.out.println("Введите стоимость товара: ");
                    productCost = Double.parseDouble(scanner.nextLine());
                    if (productCost < 0) {
                        System.out.println("Стоимость товара не может быть отрицательной");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неправильный формат стоимости товара!\nПопробуйте снова");
                }
            }
            productNames += productName + "\n";
            totalSum += productCost;
            System.out.println("Товар \"" + productName +"\" добавлен! " + "Общая стоимость: " +
                    formatRub(totalSum) + "\nЕсли хотите \"завершить\" добавление товаров просто напишите;)");
        }


        System.out.println("Добавленные товары: \n" + productNames);
        System.out.println("Сумма которую должен заплатить каждый человек: " +
                formatRub(totalSum/countPeople));
        scanner.close();
    }
    public String formatRub (double sumRub) {
        int ruble = (int) sumRub;
        int twoLustNum = ruble % 100;
        int oneLustNum = ruble % 10;
        String strRub;

        switch (twoLustNum) {
            case 11:
            case 12:
            case 13:
            case 14:
                strRub = "рублей";
                break;
            default:
                switch (oneLustNum) {
                    case 1:
                        strRub = "рубль";
                        break;
                    case 2:
                    case 3:
                    case 4:
                        strRub = "рубля";
                        break;
                    default:
                        strRub = "рублей";
                        break;
                }
        }
        return String.format("%.2f %s", sumRub, strRub);
    }
}