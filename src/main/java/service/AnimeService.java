package service;

import domain.Anime;
import domain.Producer;
import repository.AnimeRepository;

import java.util.Optional;
import java.util.Scanner;

public class AnimeService {
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
        AnimeRepository.findByName(name).forEach(anime -> System.out.printf("[%d] - %s%n", anime.getId(), anime.getName()));
    }

    private static void delete() {
        AnimeRepository.findByName("").forEach(producer1 -> System.out.printf("[%d] - %s%n", producer1.getId(), producer1.getName()));
        System.out.println("Type the id of the producer you want to delete");
        int id = Integer.parseInt(sc1.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = sc1.next();
        if ("y".equalsIgnoreCase(choice)) {
            AnimeRepository.delete(id);
        }
    }

    public static void save() {
        System.out.println("Type the name for save");
        String name = sc1.nextLine();
        System.out.println("Type the number of episodes");
        int episodes = Integer.parseInt(sc1.nextLine());
        System.out.println("Type the id of the producer");
        Integer producerId = Integer.parseInt(sc1.nextLine());
        Anime anime = Anime.builder().name(name).episodes(episodes).producer(Producer.builder().id(producerId).build()).build();
        AnimeRepository.save(anime);
    }

    public static void update() {
        System.out.println("Type the id of the object you want to update");
        Optional<Anime> animeOptional = AnimeRepository.findById(Integer.parseInt(sc1.nextLine()));
        if (animeOptional.isEmpty()) {
            System.out.println("Producer not found");
            return;
        }
        Anime animeFromDb = animeOptional.get();
        System.out.println("Type the new name or enter to keep the same");
        String name = sc1.nextLine();
        name = name.isEmpty() ? animeFromDb.getName() : name;

        System.out.println("Type the new number to episodes");
        int episodes = Integer.parseInt(sc1.nextLine());

        Anime AnimeToUpdate = Anime.builder()
                .id(animeFromDb.getId())
                .name(name)
                .episodes(episodes)
                .producer(animeFromDb.getProducer())
                .build();

        AnimeRepository.update(AnimeToUpdate);
    }
}