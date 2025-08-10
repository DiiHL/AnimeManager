package service;

import domain.Producer;
import repository.ProducerRepository;

import java.util.Optional;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner sc1 = new Scanner(System.in);

    public static void buildMenu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
            default -> throw new IllegalArgumentException("Not a valid option");
        }
    }

    private static void findByName() {
        System.out.println("Type the name or empty to all");
        String name = sc1.nextLine();
        ProducerRepository.findByName(name).forEach(producer1 -> System.out.printf("[%d] - %s%n", producer1.getId(), producer1.getName()));
    }

    private static void delete() {
        ProducerRepository.findByName("").forEach(producer1 -> System.out.printf("[%d] - %s%n", producer1.getId(), producer1.getName()));
        System.out.println("Type one of the ids below to delete");
        int id = Integer.parseInt(sc1.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = sc1.next();
        if ("y".equalsIgnoreCase(choice)) {
            ProducerRepository.delete(id);
        }
    }

    public static void save() {
        System.out.println("Type the name for save");
        String name = sc1.nextLine();
        ProducerRepository.save(name);
    }

    public static void update() {
        System.out.println("Type the id of the object you want to update");
        Optional<Producer> producerOptional = ProducerRepository.findById(Integer.parseInt(sc1.nextLine()));
        if (producerOptional.isEmpty()) {
            System.out.println("Producer not found");
            return;
        }
        Producer producerFromDb = producerOptional.get();
        System.out.println("Type the new name or enter to keep the same");
        String name = sc1.nextLine();
        name = name.isEmpty() ? producerFromDb.getName() : name;

        Producer producerToUpdate = Producer.builder().id(producerFromDb.getId()).name(name).build();

        ProducerRepository.update(producerToUpdate);
    }
}