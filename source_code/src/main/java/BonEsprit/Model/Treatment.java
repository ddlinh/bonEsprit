package BonEsprit.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Treatment {
    @Id
    Long ID;
    String content;

    @ManyToMany(mappedBy = "treatments")
    List<Problem> problems;
}
