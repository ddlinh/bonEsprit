package BonEsprit.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Certificate {
    @Id
    Long ID;
    String name;

    @ManyToOne
    @JoinColumn(name = "ID")
    User therapist;
}
