package com.company;

import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x = 100;  //小球横坐标
    double y = 100; //小球纵坐标
//    boolean right = true;  //小球运动方向
    double degree = 3.14 / 3;

    //画窗口，会循环执行
    public void paint(Graphics g){
        System.out.println("窗口被画一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int)x, (int)y, null);

        x += 10 * Math.cos(degree);
        y += 10 * Math.sin(degree);

        if(x<40 || x>856-30-40){    //碰到右边界
            degree = 3.14 - degree;
        }

        if(y<40+40 || y>500-40-30){
            degree = -degree;
        }
    }

    //窗口加载
    void lauchFrame(){
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);

        while (true){
            repaint();
            try{
                Thread.sleep(20); //40ms,   1秒=1000毫秒.  大约一秒画25次窗口
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("桌球小游戏");
        BallGame game = new BallGame();
        game.lauchFrame();
    }
}
