package com.ocsim.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * entité Event: composée d'un identifiant unique et d'un nom de salle, ainsi que d'un statut de disponibilité
 * Lombok est utilisé pour les constructeurs, les setters/getters, et le toString()
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room_object")
public class RoomObject {

    public RoomObject(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private boolean availability;

    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "roomObject"
    )
    private Set<Event> events = new HashSet<>();


}
