package BonEsprit.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Symptom {
    @Id
    Long ID;
    String content;

    @ManyToMany(mappedBy = "symptoms")
    List<Problem> symptoms;
}
