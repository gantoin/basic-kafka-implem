package fr.gantoin.basickafkaimplem.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.gantoin.basickafkaimplem.domain.Video;
import fr.gantoin.basickafkaimplem.domain.VideoStateEnum;
import fr.gantoin.basickafkaimplem.service.kafka.KafkaSender;

@Service
public class VideoDownloaderService {

    private final KafkaSender kafkaSender;

    public VideoDownloaderService(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    public void downloadVideo(String url) {
        System.out.println("💾 Downloaded video from " + url);
        kafkaSender.send("video", new Video(UUID.randomUUID(), url, VideoStateEnum.DOWNLOADED));
    }
}
