package ru.edu.penzgtu.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cooks")
public class Cook {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "cooks_restaurants",
            joinColumns = @JoinColumn(name = "restaurants_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cooks_id", referencedColumnName = "id"))
    private List<Restaurant> restaurants;

}

