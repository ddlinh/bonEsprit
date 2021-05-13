package BonEsprit.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Question {
    @Id
    long ID;

    @ManyToOne
    @JoinColumn(name = "ID")
    Quiz quiz;

    String content;

    @OneToMany
    @JoinColumn(name = "ID")
    List<Choice> choices;

}
