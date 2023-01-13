package fr.gantoin.basickafkaimplem.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.gantoin.basickafkaimplem.domain.Video;
import fr.gantoin.basickafkaimplem.domain.VideoStateEnum;
import fr.gantoin.basickafkaimplem.service.kafka.KafkaSender;

@Service
public class VideoEditingService {

    private final KafkaSender kafkaSender;

    public VideoEditingService(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    public synchronized void longEditingVideo(UUID videoId) throws Exception {
        wait(5000);
        kafkaSender.send("video", new Video(videoId, "http://edited-video.com", VideoStateEnum.EDITED));
    }
}
