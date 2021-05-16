package BonEsprit.UI.panel;

import BonEsprit.Model.Quiz;
import BonEsprit.Service.QuizService;
import BonEsprit.UI.form.Main_Form;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class List_Quizz_Panel extends Content_Panel {

    public List_Quizz_Panel(Main_Form mainForm) {
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(0xFFFFFF));
        contentPanel.setBounds(0, 95, 450, 735);
        contentPanel.setLayout(null);

        JLabel latestPostLabel = new JLabel("All Quizzes");
        latestPostLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        latestPostLabel.setBounds(160, 30, 200, 50);
        contentPanel.add(latestPostLabel);

        // Item post panel
        JPanel quizPanel = new JPanelCustom(440, 1000);
        quizPanel.setLocation(10, 80);
        quizPanel.setLayout(null);
        quizPanel.setBackground(new Color(0XFFFFFF));

        JScrollPane quizScrollPanel = new JScrollPane(quizPanel);
        quizScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        quizScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        quizScrollPanel.setBorder(null);
        quizScrollPanel.getVerticalScrollBar().setUnitIncrement(10);
        quizScrollPanel.setBounds(5, 80, 440, 500);

        quizScrollPanel.setBackground(new Color(0xFFFFFF));
        quizScrollPanel.getVerticalScrollBar().getUnitIncrement(10);
        contentPanel.add(quizScrollPanel);

        List<Quiz> quizzes = QuizService.getAll();

        for (int i = 0; i < quizzes.size(); i++) {
            JPanel itemPost1 = new JPanel();
            createQuizPanel(itemPost1,
                    10,
                    5 + (120 * i),
                    quizzes.get(i),
                    mainForm
            );

            quizPanel.add(itemPost1);
        }
    }
}
