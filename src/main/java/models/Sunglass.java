package models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Sunglass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_sg",
            joinColumns = @JoinColumn(name = "sg_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public Sunglass(String brand) {
        this.brand = brand;
    }

    public Sunglass(String brand, List<User> users) {
        this.brand = brand;
        this.users = users;
    }
}
