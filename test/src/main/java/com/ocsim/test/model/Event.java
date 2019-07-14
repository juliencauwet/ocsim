package com.ocsim.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Date;


/**
 * entité Event: composée d'un identifiant, d'une date de création, d'un statut (on/off), et d'une salle
 * Lombok est utilisé pour les constructeurs, les setters/getters, et le toString()
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    private int id;

    private Date time;

    private String event;

    private String room;

    @ManyToOne
    @JoinColumn(name = "room_object")
    private Room roomObject;

}
