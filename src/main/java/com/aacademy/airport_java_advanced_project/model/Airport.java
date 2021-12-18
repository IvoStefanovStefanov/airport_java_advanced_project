package com.aacademy.airport_java_advanced_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name="airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

//    @OneToMany(mappedBy = "airport")
//    private Set<Destination> destinations;

//    @OneToMany
//    @JoinColumn(name = "destination_id", foreignKey = @ForeignKey(name = "fk_destination_id"))
//    private Destination destination;
}
