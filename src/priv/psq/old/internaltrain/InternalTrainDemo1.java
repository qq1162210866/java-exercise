package priv.psq.old.internaltrain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * InternalTrainDemo1.java
 * Description: 内部类练习demo1
 *
 * @author Peng Shiquan
 * @date 2019-08-14
 */
public class InternalTrainDemo1 {

    /**
     * Description: 主方法
     *
     * @param args
     * @return void
     * @Author: Peng Shiquan
     * @Date: 2019-08-15
     */
    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(2000, true);
        talkingClock.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock {
    private Integer interval;
    private Boolean beep;

    public TalkingClock(Integer integer, Boolean beep) {
        this.interval = integer;
        this.beep = beep;
    }

    public void start() {
        /**
         * 按integer的毫秒执行
         */
        ActionListener actionListener = new TimePrienter();
        /**
         * 定时工具
         */
        Timer timer = new Timer(interval, actionListener);
        timer.start();
    }

    /**
     * InternalTrainDemo1.java
     * Description:  内部类，继承了时间监听器
     *
     * @author Peng Shiquan
     * @date 2019-09-04
     */
    public class TimePrienter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("now time is " + new Date());
            if (beep) {
                /**
                 * 和java的swing有关，可以不用理解
                 */
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}