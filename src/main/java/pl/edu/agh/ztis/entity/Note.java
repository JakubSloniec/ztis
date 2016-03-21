package pl.edu.agh.ztis.entity;

import javax.persistence.*;

/**
 * Created by js on 21.03.2016.
 */
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
