package BonEsprit.UI.panel;

import BonEsprit.Model.Problem;
import BonEsprit.Model.Therapist;
import BonEsprit.Model.User;
import BonEsprit.Service.ProblemService;
import BonEsprit.Service.UserService;
import BonEsprit.UI.UserManager;
import BonEsprit.UI.form.Main_Form;
import jdk.jfr.internal.tool.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;

public class Home_Panel extends Content_Panel {

    public Home_Panel(Main_Form mainForm) {
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(0xFFFFFF));
        contentPanel.setBounds(0, 95, 450, 735);
        contentPanel.setLayout(null);

        JLabel latestPostLabel = new JLabel("Latest Posts");
        latestPostLabel.setHorizontalAlignment(SwingConstants.CENTER);
        latestPostLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        latestPostLabel.setBounds(135, 30, 200, 50);
        contentPanel.add(latestPostLabel);

        // Begin of latest post panel creating
        JPanel postPanel = new JPanelCustom(440, 1000);
        postPanel.setLocation(10, 80);
        postPanel.setLayout(null);
        postPanel.setBackground(new Color(0XFFFFFF));

        JScrollPane postScrollPanel = new JScrollPane(postPanel);
        postScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        postScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        postScrollPanel.setBorder(null);
        postScrollPanel.getVerticalScrollBar().setUnitIncrement(10);
        postScrollPanel.setBounds(5, 80, 440, 250);

        postScrollPanel.setBackground(new Color(0xFFFFFF));
        postScrollPanel.getVerticalScrollBar().getUnitIncrement(10);
        contentPanel.add(postScrollPanel);

        List<Problem> problems = ProblemService.recentProblem();
        for (int i = 0; i < problems.size(); i++) {
            JPanel itemPost1 = new JPanel();

            createItemPostPanel(itemPost1,
                    10,
                    5 + (120 * i),
                    problems.get(i),
                    mainForm
            );

            postPanel.add(itemPost1);
        }

        // End of latest post panel creating

        JLabel mostHonorableTherapistPanel = new JLabel("Most Honorable Therapist");
        mostHonorableTherapistPanel.setFont(new Font("SansSerif", Font.BOLD, 24));
        mostHonorableTherapistPanel.setBounds(80, 380, 400, 50);
        contentPanel.add(mostHonorableTherapistPanel);

        // Begin of therapist panel creating

        JPanel therapistPanel = new JPanelCustom(1000, 300);
        therapistPanel.setLocation(5, 420);
        therapistPanel.setLayout(null);
        therapistPanel.setBackground(new Color(0XFFFFFF));

        JScrollPane therapistScrollPanel = new JScrollPane(therapistPanel);
        therapistScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        therapistScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        therapistScrollPanel.setBorder(null);
        therapistScrollPanel.getHorizontalScrollBar().setUnitIncrement(10);
        therapistScrollPanel.setBounds(5, 430, 440, 200);

        therapistScrollPanel.setBackground(new Color(0xFFFFFF));
        therapistScrollPanel.getHorizontalScrollBar().getUnitIncrement(10);
        contentPanel.add(therapistScrollPanel);

        List<User> mostHonorable = UserService.mostHorable();

        for(int i = 0; i < mostHonorable.size(); i++)
        {
            JPanel therapist = new JPanel();
            createItemTherapist(therapist, 5 + i*180,20, mostHonorable.get(i), mainForm);
            therapistPanel.add(therapist);
        }
    }

    private void createItemTherapist(JPanel therapistPanel, int x, int y, User therapist, Main_Form mainForm) {
        therapistPanel.setLayout(null);
        therapistPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        therapistPanel.setBackground(new Color(0xffffff));
        therapistPanel.setBounds(x, y, 200, 200);

        JLabel imageTherapist = new JLabel();
        try {
            Image image = ImageIO.read(new File("./resources/therapist.png"));
            Image imageICON = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH );
            imageTherapist.setIcon(new ImageIcon(imageICON));
        } catch (Exception e) {
            e.printStackTrace();
        }
        imageTherapist.setBounds(30, 25, 70, 50);
        imageTherapist.setHorizontalAlignment(SwingConstants.CENTER);
        imageTherapist.setBorder(null);

        JLabel nameLabel = new JLabel(therapist.getFirstName() + " " + therapist.getLastName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        nameLabel.setBounds(0, 90, 130, 20);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        therapistPanel.add(imageTherapist);
        therapistPanel.add(nameLabel);

        therapistPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainForm.changePanel(new TherapistView_Panel(therapist, mainForm).getContentPanel());
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
