import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    static JTextField t;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // label to display text
    static JLabel l;

    private Deserializer des;

    App()
    {
        des = new Deserializer();
        f = new JFrame("Weather App");

        // create a label to display text
        l = new JLabel("nothing entered");

        // create a new button
        b = new JButton("submit");



        // create a object of JTextField with 16 columns and a given initial text
        t = new JTextField("enter the text", 16);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();
        b.addActionListener(this::actionPerformed);
        // add buttons and textfield to panel
        p.add(t);
        p.add(b);
        p.add(l);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(300, 300);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            l.setText(t.getText());
            des.setLocation(t.getText());
            // set the text of field to blank
            t.setText("  ");
        }
    }
}
