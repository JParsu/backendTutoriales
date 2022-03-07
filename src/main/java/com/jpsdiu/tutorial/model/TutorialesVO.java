package com.jpsdiu.tutorial.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class TutorialesVO {

    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private boolean publicado;

}
