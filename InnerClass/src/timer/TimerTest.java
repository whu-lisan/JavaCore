package timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author: zhouqian
 * @date: 2020/2/14
 * @blog:
 * @version:1.0.0
 * @description:
 */

public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(1000, listener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }

}

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}