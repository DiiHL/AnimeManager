package test;

import service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            menu();
            op = Integer.parseInt(sc1.nextLine());
            if (op == 0) break;
            ProducerService.buildMenu(op);
        }
    }


    private static void menu(){
        System.out.println("Type the number of your operation");
        System.out.println("1. Producer");
        System.out.println("2. Anime");
        System.out.println("0. Exit");

    }

    private static void producerMenu() {
        System.out.println("Type the number of your operation");
        System.out.println("1. Search for producer");
        System.out.println("2. Delete producer");
        System.out.println("3. save producer");
        System.out.println("4. update producer");
        System.out.println("9. Go back");
    }

    private static void animeMenu() {
        System.out.println("Type the number of your operation");
        System.out.println("1. Search for anime");
        System.out.println("2. Delete anime");
        System.out.println("3. save anime");
        System.out.println("4. update anime");
        System.out.println("9. Go back");
    }
}