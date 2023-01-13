package fr.gantoin.basickafkaimplem.service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import fr.gantoin.basickafkaimplem.domain.Video;
import fr.gantoin.basickafkaimplem.domain.VideoStateEnum;
import fr.gantoin.basickafkaimplem.service.kafka.interfaces.ISender;

/**
 * Expediteur Kafka
 */
@Service
public class KafkaSender implements ISender {

    private final KafkaTemplate<String, Video> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, Video> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Permet d'envoyer un message (Video) dans un topic
     *
     * @param topicName Nom du topic
     * @param video     Objet à envoyer
     */
    @Override
    public void send(String topicName, Video video) {
        new NewTopic(topicName, 1, (short) 1);
        kafkaTemplate.send(topicName, video);
    }
}
