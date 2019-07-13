package com.ocsim.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


/**
 * entité Event: composée d'un identifiant, d'une date de création, d'un statut (on/off), et d'une salle
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue
    private int id;

    private Date time;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "room")
    private Room room;

}
