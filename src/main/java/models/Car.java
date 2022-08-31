package models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;

    private int year;

    @Enumerated(EnumType.STRING)
    private ModelClass modelClass;

    public Car(String model, int year, ModelClass modelClass) {
        this.model = model;
        this.year = year;
        this.modelClass = modelClass;
    }
}
