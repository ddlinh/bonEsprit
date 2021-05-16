package BonEsprit.UI.panel;

import BonEsprit.Model.Problem;
import BonEsprit.Service.DATA;
import BonEsprit.Service.ProblemService;
import BonEsprit.UI.form.Main_Form;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class List_Post_Panel extends Content_Panel {

    public List_Post_Panel(Main_Form mainForm) {
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(0xFFFFFF));
        contentPanel.setBounds(0, 95, 450, 750);
        contentPanel.setLayout(null);

        JLabel latestPostLabel = new JLabel("All Posts");
        latestPostLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        latestPostLabel.setBounds(160, 30, 200, 50);
        contentPanel.add(latestPostLabel);

        // Item post panel

        JPanel postPanel = new JPanelCustom(440, 1000);
        postPanel.setLocation(10, 80);
        postPanel.setLayout(null);
        postPanel.setBackground(new Color(0XFFFFFF));

        JScrollPane postScrollPanel = new JScrollPane(postPanel);
        postScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        postScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        postScrollPanel.setBorder(null);
        postScrollPanel.getVerticalScrollBar().setUnitIncrement(10);
        postScrollPanel.setBounds(5, 80, 440, 500);

        postScrollPanel.setBackground(new Color(0xFFFFFF));
        postScrollPanel.getVerticalScrollBar().getUnitIncrement(10);
        contentPanel.add(postScrollPanel);

        List<Problem> problems = ProblemService.getAll();
        for (int i = 0; i < DATA.problems.size(); i++) {
            JPanel itemPost1 = new JPanel();

            createItemPostPanel(itemPost1,
                    10,
                    5 + (120 * i),
                    DATA.problems.get(i),
                    mainForm
            );

            postPanel.add(itemPost1);
        }
    }
}
