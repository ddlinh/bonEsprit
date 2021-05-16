package BonEsprit.UI.panel;

import BonEsprit.Model.Problem;
import BonEsprit.Service.ProblemService;
import BonEsprit.UI.form.Main_Form;

import javax.swing.*;
import java.awt.*;

import java.util.List;
import java.util.ArrayList;

public class Search_Panel extends Content_Panel {

    public Search_Panel(Main_Form mainForm, String keyword) {
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(0xFFFFFF));
        contentPanel.setBounds(0, 95, 450, 735);
        contentPanel.setLayout(null);

        JLabel searchLabel = new JLabel("Search: ");
        searchLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        searchLabel.setBounds(25, 5, 200, 50);
        contentPanel.add(searchLabel);

        JLabel searchKeywordLabel = new JLabel(keyword);
        searchKeywordLabel.setFont(new Font("SansSerif", Font.ITALIC, 16));
        searchKeywordLabel.setBounds(110, 5, 200, 50);
        contentPanel.add(searchKeywordLabel);


        // Item post panel
        JPanel postSearchPanel = new JPanelCustom(440, 1000);
        postSearchPanel.setLocation(10, 70);
        postSearchPanel.setLayout(null);
        postSearchPanel.setBackground(new Color(0XFFFFFF));

        JScrollPane postSearchScrollPanel = new JScrollPane(postSearchPanel);
        postSearchScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        postSearchScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        postSearchScrollPanel.setBorder(null);
        postSearchScrollPanel.setBounds(5, 70, 440, 500);

        postSearchScrollPanel.setBackground(new Color(0xFFFFFF));
        postSearchScrollPanel.getVerticalScrollBar().getUnitIncrement(10);
        contentPanel.add(postSearchScrollPanel);

        List<Problem> searchResult = ProblemService.search(keyword);

        for (int i = 0; i < searchResult.size(); i++) {
            JPanel itemPost1 = new JPanel();

            createItemPostPanel(itemPost1,
                    5,
                    5 + 135*i,
                    searchResult.get(i),
                    mainForm
            );

            postSearchPanel.add(itemPost1);
        }
    }

}
