package BonEsprit.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswerDetail {
    @Id
    Long ID;

    @ManyToOne
    @JoinColumn(name = "ID")
    Answer answer;

    @ManyToOne
    @JoinColumn(name = "ID")
    Choice choice;
}
