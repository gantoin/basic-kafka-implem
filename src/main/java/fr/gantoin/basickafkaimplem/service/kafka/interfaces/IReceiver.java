package fr.gantoin.basickafkaimplem.service.kafka.interfaces;


import fr.gantoin.basickafkaimplem.domain.Video;
import fr.gantoin.basickafkaimplem.domain.VideoStateEnum;

/**
 * Interface pour écouter la réception d'un message
 *
 * Il serait possible d'utiliser la même interface pour écouter
 * un message avec une autre messagerie que Kafka (ex : RabbitMQ)
 * */
public interface IReceiver {
    public void listen(String topicName, Video video);
}
