package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        int waterAvailable = 400, milkAvailable = 540, coffeeBeansAvailable = 120,
                cupsAvailable = 9, moneyAvailable = 550;

        cMachineStatus(waterAvailable, milkAvailable, coffeeBeansAvailable,
                cupsAvailable, moneyAvailable);
    }

    private static void cMachineStatus(int waterAvailable, int milkAvailable,
                                       int coffeeBeansAvailable, int cupsAvailable,
                                       int moneyAvailable) {

        Boolean exitFlag = false;
        while (exitFlag == false) {

            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    Scanner scanner2 = new Scanner(System.in);
                    String optionSelect = scanner2.nextLine();
                    if (optionSelect.equals("1")) {
                        //sufficient
                        boolean isSufficient = isSufficient(250, 0, 16, waterAvailable, milkAvailable, coffeeBeansAvailable);
                        if (isSufficient == false) {
                            continue;
                        }
                        System.out.println("I have enough resources, making you a coffee!");
                        waterAvailable = waterAvailable - 250;
                        coffeeBeansAvailable = coffeeBeansAvailable - 16;
                        moneyAvailable = moneyAvailable + 4;
                        cupsAvailable = cupsAvailable - 1;

                    }

                    if (optionSelect.equals("2")) {
                        boolean isSufficient = isSufficient(350, 75, 20, waterAvailable, milkAvailable, coffeeBeansAvailable);
                        if (isSufficient == false) {
                            continue;
                        }
                        System.out.println("I have enough resources, making you a coffee!");
                        waterAvailable = waterAvailable - 350;
                        milkAvailable = milkAvailable - 75;
                        coffeeBeansAvailable = coffeeBeansAvailable - 20;
                        moneyAvailable = moneyAvailable + 7;
                        cupsAvailable = cupsAvailable - 1;
                    }
                    if (optionSelect.equals("3")) {
                        boolean isSufficient = isSufficient(200, 100, 12, waterAvailable, milkAvailable, coffeeBeansAvailable);
                        if (isSufficient == false) {
                            continue;
                        }
                        System.out.println("I have enough resources, making you a coffee!");
                        waterAvailable = waterAvailable - 200;
                        milkAvailable = milkAvailable - 100;
                        coffeeBeansAvailable = coffeeBeansAvailable - 12;
                        moneyAvailable = moneyAvailable + 6;
                        cupsAvailable = cupsAvailable - 1;
                    }
                    if (optionSelect == "back - to main menu:") {
                        printStatus(waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable);

                    }

                    break;
                case "fill":
                    System.out.println("\nWrite how many ml of water you want to add:");
                    Scanner scanner1 = new Scanner(System.in);
                    int waterAdded = scanner1.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int milkAdded = scanner1.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int coffeeBeansAdded = scanner1.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    int cupsAdded = scanner1.nextInt();
                    waterAvailable = waterAvailable + waterAdded;
                    milkAvailable = milkAvailable + milkAdded;
                    coffeeBeansAvailable = coffeeBeansAvailable + coffeeBeansAdded;
                    cupsAvailable = cupsAvailable + cupsAdded;

                    // printStatus(waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable);
                    break;

                case "take":
                    System.out.println("\nI gave you " + moneyAvailable);
                    moneyAvailable = 0;
                    //printStatus(waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable);
                    break;
                case "remaining":
                    printStatus(waterAvailable, milkAvailable, coffeeBeansAvailable, cupsAvailable, moneyAvailable);
                    break;
                case "exit":
                    exitFlag = true;
                    break;
                default:
                    break;
            }
        }
    }

    private static void printStatus(int waterAvailable, int milkAvailable, int coffeeBeansAvailable, int cupsAvailable, int moneyAvailable) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(waterAvailable + " " + "ml of water");
        System.out.println(milkAvailable + " " + "ml of milk");
        System.out.println(coffeeBeansAvailable + " " + "g of coffee beans");
        System.out.println(cupsAvailable + " " + "disposable cups");
        System.out.println("$" + moneyAvailable + " " + "of money");
    }

    public static boolean isSufficient(int waterWanted, int milkWanted, int coffeeBeansWanted, int waterAvailable, int milkAvailable, int coffeeBeansAvailable) {
        boolean flag = true;
        if (waterAvailable - waterWanted < 0) {
            System.out.println("Sorry, not enough water!");
            flag = false;
        }
        if (coffeeBeansAvailable - coffeeBeansWanted < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            flag = false;
        }
        if (milkAvailable - milkWanted < 0) {
            System.out.println("Sorry, not enough milk!");
            flag = false;
        }
        return flag;
    }
}





