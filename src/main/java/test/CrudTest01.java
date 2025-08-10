package test;

import service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            producerMenu();
            op = Integer.parseInt(sc1.nextLine());
            if (op == 0) break;
            ProducerService.buildMenu(op);
        }
    }

    private static void producerMenu() {
        System.out.println("Type the number of your operation");
        System.out.println("1. Search for producer");
        System.out.println("2. Delete producer");
        System.out.println("3. save producer");
        System.out.println("4. update producer");
        System.out.println("0. Exit");
    }
}