package fr.gantoin.basickafkaimplem.service.kafka.interfaces;

import fr.gantoin.basickafkaimplem.domain.Video;
import fr.gantoin.basickafkaimplem.domain.VideoStateEnum;

/**
 * Interface pour envoyer un message
 *
 * Il serait possible d'utiliser la même interface pour envoyer
 * un message avec une autre messagerie que Kafka (ex : RabbitMQ)
 * */
public interface ISender {
    void send(String topicName, Video video);
}
