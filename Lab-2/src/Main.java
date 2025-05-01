public class Main {
    public static void main(String[] args) {

        double interestRate = 5.5;

        if (args.length < 2) {
            System.out.println("Будь ласка, вкажіть термін та початкову суму.");
            return;
        }

        double principal = Double.parseDouble(args[0]);
        int term = Integer.parseInt(args[1]);

        double simpleInterest = principal * interestRate * term / 100;
        double totalAmount = principal + simpleInterest;

        System.out.println("Початкова сума: " + principal);
        System.out.println("Депозитна ставка: " + interestRate + "%");
        System.out.println("Термін: " + term + " років");
        System.out.println("Загальні відсотки: " + simpleInterest);
        System.out.println("Загальна сума після терміну: " + totalAmount);
    }
}
