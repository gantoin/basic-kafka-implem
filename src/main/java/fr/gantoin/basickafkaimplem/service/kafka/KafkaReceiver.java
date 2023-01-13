package fr.gantoin.basickafkaimplem.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import fr.gantoin.basickafkaimplem.domain.Video;
import fr.gantoin.basickafkaimplem.domain.VideoStateEnum;
import fr.gantoin.basickafkaimplem.service.kafka.interfaces.IProcess;
import fr.gantoin.basickafkaimplem.service.kafka.interfaces.IReceiver;


/**
 * Receveur Kafka
 */
@Service
public class KafkaReceiver implements IReceiver {

    @Autowired
    private IProcess process; // Affectation de l'instance pour la gestion des traitements

    /**
     * Écoute sur le topic "video", s'il existe un message
     *
     * @param video Objet reçu
     */
    @KafkaListener(topics = "video", containerFactory = "kafkaListenerContainerFactory")
    public void listenVideo(Video video) {
        listen("video", video);
    }


    /**
     * Exécution d'un traitement
     *
     * @param topicName Nom du topic
     * @param topicName Objet reçu
     */
    @Override
    public void listen(String topicName, Video video) {
        System.out.println("⚙️ Event received, editing video : " + video.getId());
        process.execute(topicName + "Info", video);
    }
}
