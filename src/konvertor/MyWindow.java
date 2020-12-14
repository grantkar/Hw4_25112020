package konvertor;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    public MyWindow(){
        setTitle("Конвертор мл. в чайные ложки");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600,200,400,600);
        JTextArea textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton button1 = new JButton("KONVERT");
        JButton button2 = new JButton("CLEAR");
        panel.add(button1);
        panel.add(button2);
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
