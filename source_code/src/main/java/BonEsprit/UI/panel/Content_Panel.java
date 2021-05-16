package BonEsprit.UI.panel;

import BonEsprit.Model.Problem;
import BonEsprit.Model.Quiz;
import BonEsprit.UI.form.Main_Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

public class Content_Panel {

    protected JPanel contentPanel;

    public JPanel getContentPanel() {
        return this.contentPanel;
    }

    protected void createItemPostPanel(JPanel latestPostDetailPanel, int x, int y, Problem problem, Main_Form mainForm) {
        latestPostDetailPanel.setBounds(x, y,410,110);
        latestPostDetailPanel.setBackground(new Color(0xD3E4F9));
        latestPostDetailPanel.setLayout(null);
        latestPostDetailPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel titleLatestPostLabel = new JLabel(problem.getName());
        titleLatestPostLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        titleLatestPostLabel.setBounds(5, 10, 300, 20);
        latestPostDetailPanel.add(titleLatestPostLabel);

        JLabel authorLatestPostLabel = new JLabel(problem.getAuthor().getFirstName() + " " + problem.getAuthor().getLastName());
        authorLatestPostLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        authorLatestPostLabel.setBounds(300, 10, 200 , 20);
        authorLatestPostLabel.setHorizontalAlignment(SwingConstants.LEFT);
        latestPostDetailPanel.add(authorLatestPostLabel);

        JLabel descriptionLatestPostLabel = new JLabel(problem.getDescription().substring(0, 30) + "...");
        descriptionLatestPostLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        descriptionLatestPostLabel.setBounds(5, 32, 500, 20);
        latestPostDetailPanel.add(descriptionLatestPostLabel);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(problem.getDate());
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        JLabel dateLatestPostLabel = new JLabel(mDay + "/" + mMonth + "/" + mYear);
        dateLatestPostLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        dateLatestPostLabel.setBounds(5, 73, 500, 20);
        latestPostDetailPanel.add(dateLatestPostLabel);

        latestPostDetailPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainForm.changePanel(new ProblemView_Panel(problem, mainForm).getContentPanel());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    protected void createQuizPanel(JPanel latestPostDetailPanel, int x, int y, Quiz quiz, Main_Form mainForm) {
        latestPostDetailPanel.setBounds(x, y,410,110);
        latestPostDetailPanel.setBackground(new Color(0xD3E4F9));
        latestPostDetailPanel.setLayout(null);
        latestPostDetailPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel titleLatestPostLabel = new JLabel(quiz.getName());
        titleLatestPostLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        titleLatestPostLabel.setBounds(5, 10, 300, 20);
        latestPostDetailPanel.add(titleLatestPostLabel);

        JLabel authorLatestPostLabel = new JLabel(quiz.getAuthor().getFirstName() + " " + quiz.getAuthor().getLastName());
        authorLatestPostLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        authorLatestPostLabel.setBounds(300, 10, 200 , 20);
        authorLatestPostLabel.setHorizontalAlignment(SwingConstants.LEFT);
        latestPostDetailPanel.add(authorLatestPostLabel);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(quiz.getDate());
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        JLabel dateLatestPostLabel = new JLabel(mDay + "/" + mMonth + "/" + mYear);
        dateLatestPostLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        dateLatestPostLabel.setBounds(5, 73, 500, 20);
        latestPostDetailPanel.add(dateLatestPostLabel);

        latestPostDetailPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainForm.changePanel(new QuizView_Panel(quiz, mainForm).getContentPanel());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
