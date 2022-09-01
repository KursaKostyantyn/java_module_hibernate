package models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String series;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "passport")
    @ToString.Exclude
    private User user;


    public Passport(String series) {
        this.series = series;
    }


}
