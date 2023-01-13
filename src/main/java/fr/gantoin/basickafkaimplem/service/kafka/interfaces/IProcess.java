package fr.gantoin.basickafkaimplem.service.kafka.interfaces;

import fr.gantoin.basickafkaimplem.domain.Video;

/**
 * Interface pour gérer les traitements
 */
public interface IProcess {

    /**
     * Exécuter un traitement
     *
     * @param info
     * @param video
     */
    public void execute(String info, Video video);
}
