package fr.gantoin.basickafkaimplem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.gantoin.basickafkaimplem.service.VideoDownloaderService;
import fr.gantoin.basickafkaimplem.service.kafka.interfaces.ISender;

@SpringBootApplication
public class BasicKafkaImplemApplication implements CommandLineRunner {

    private final VideoDownloaderService videoDownloaderService;

    public BasicKafkaImplemApplication(VideoDownloaderService videoDownloaderService) {
        this.videoDownloaderService = videoDownloaderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicKafkaImplemApplication.class, args);
    }

    /**
     * Exécuter le programme
     * Permet d'envoyer des messages vers une messagerie (Kafka ou autre)
     * <p>
     * La réception du message est asynchrone (en attente)
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("🚀 Wait application booting");
        Thread.sleep(10000);
        this.videoDownloaderService.downloadVideo("https://www.youtube.com/watch?0");
        this.videoDownloaderService.downloadVideo("https://www.youtube.com/watch?1");
        this.videoDownloaderService.downloadVideo("https://www.youtube.com/watch?2");
        this.videoDownloaderService.downloadVideo("https://www.youtube.com/watch?3");
    }

}
