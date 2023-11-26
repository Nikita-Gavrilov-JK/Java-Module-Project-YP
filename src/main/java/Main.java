import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPeople;

        while(true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            countPeople = scanner.nextInt();
            if (countPeople == 1){
                System.out.println("Нет смысла ничего считать и делить.");
            } else if (countPeople < 1) {
                System.out.println("Количество людей должно быть больше 1");
            }
            else {
                Calculator calculator = new Calculator(countPeople);
                calculator.culc();
                scanner.close();
                break;
            }

        }

    }
}