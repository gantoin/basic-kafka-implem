package fr.gantoin.basickafkaimplem.service.kafka;

import org.springframework.stereotype.Service;

import fr.gantoin.basickafkaimplem.domain.Video;
import fr.gantoin.basickafkaimplem.service.VideoEditingService;
import fr.gantoin.basickafkaimplem.service.kafka.interfaces.IProcess;

/**
 * Traitement exemple
 */
@Service
public class ProcessExample implements IProcess {

    private final VideoEditingService videoEditingService;

    public ProcessExample(VideoEditingService videoEditingService) {
        this.videoEditingService = videoEditingService;
    }

    /**
     * Exécuter le traitement : Dans notre exemple affichage du message dans la console
     *
     * @param info   Nom du Topic
     * @param video objet video
     */
    @Override
    public synchronized void  execute(String info, Video video) {
        try {
            videoEditingService.longEditingVideo(video.getId());
            System.out.println("✅ Video successfully edited : " + video.getId());
        } catch (Exception e) {
            throw new RuntimeException("Error during video editing", e);
        }
    }
}
