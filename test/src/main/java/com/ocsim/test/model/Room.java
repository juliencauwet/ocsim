package com.ocsim.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * entité Event: composée d'un identifiant unique et d'un nom de salle
 * Lombok est utilisé pour les constructeurs, les setters/getters, et le toString()
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private boolean availability;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "room"
    )
    private Set<Event> events = new HashSet<>();


}
