package innerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 * @author: zhouqian
 * @date: 2020/2/14
 * @blog:
 * @version:1.0.0
 * @description:
 */

public class InnerClassTest {
    public static void main(String[] args) {

        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));

        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }


}



class TalkingClock{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }
}