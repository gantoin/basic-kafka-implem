package fr.gantoin.basickafkaimplem.domain;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Video {
    private UUID id;
    private String url;
    private VideoStateEnum state;
}
