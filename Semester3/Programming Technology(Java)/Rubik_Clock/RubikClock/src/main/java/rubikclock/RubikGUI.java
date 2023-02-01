/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package rubikclock;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author sarunkumar
 */




public class RubikGUI
{
    private JFrame jframe;
    private JPanel jpanel;
    private JLabel clock1, clock2, clock3, clock4, clock5, clock6, clock7, clock8, clock9;                                                               
    private JButton topLeftButton, topRightButton, bottomLeftButton, bottomRightButton;
    private static int counter = 0;

    public RubikGUI()
    {
        declareFrame();
    }
    
    /**
     * @return  void... An new frame created with randomized clock timing
     */
    private void declareFrame()
    {
        counter = 0;
        jframe = new JFrame("Rubik's Clock Game");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //jframe.setBounds(200,200,500,500);
        //jframe.setSize(500,500);
        jframe.setPreferredSize(new Dimension(700,800));
        jpanel = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
        jpanel.setBorder(blackline);

        //jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
        //jpanel.setPreferredSize(new Dimension(500,500));
        jpanel.setBounds(100, 100, 700, 700);
        clock1 = new JLabel("XHour"); //First row of clocks
        clock2 = new JLabel("XHour");
        clock3 = new JLabel("XHour");
        
        topLeftButton = new JButton("Button1"); //Button1
        topRightButton = new JButton("Button2"); // Button2
        
        clock4 = new JLabel("XHour"); //Second row of clocks
        clock5 = new JLabel("XHour");
        clock6 = new JLabel("XHour");
        
        bottomLeftButton = new JButton("Button3"); //Button3
        bottomRightButton = new JButton("Button4"); //Button1
        
        clock7 = new JLabel("XHour"); //Third row of clocks
        clock8 = new JLabel("XHour");
        clock9 = new JLabel("XHour");
        
        
        
        
        
        //clock1.setSize(new Dimension(200,100));
        // Setting layout here
        clock1.setBounds(50,50,100,100);
        clock2.setBounds(250,50,100,100);
        clock3.setBounds(450,50,100,100);
        
        topLeftButton.setBounds(150, 200, 100, 100);
        topRightButton.setBounds(350, 200, 100, 100);
        
        clock4.setBounds(50,350,100,100);
        clock5.setBounds(250,350,100,100);
        clock6.setBounds(450,350,100,100);
        
        bottomLeftButton.setBounds(150, 500, 100, 100);
        bottomRightButton.setBounds(350, 500, 100, 100);
        
        clock7.setBounds(50,650,100,100);
        clock8.setBounds(250,650,100,100);
        clock9.setBounds(450,650,100,100);
        
        clock1.setOpaque(true);
        clock2.setOpaque(true);
        clock3.setOpaque(true);
        clock4.setOpaque(true);
        clock5.setOpaque(true);
        clock6.setOpaque(true);
        clock7.setOpaque(true);
        clock8.setOpaque(true);
        clock9.setOpaque(true);
        
        
        topLeftButton.setOpaque(true);
        topRightButton.setOpaque(true);
        bottomLeftButton.setOpaque(true);
        bottomRightButton.setOpaque(true);
        
        Color panelColor = new Color(118,69,148); 
        Color clockBg = new Color(198,181,208);
        Color clockFg = new Color(43,4,66);
        Color buttonBg = new Color(45,173,214);
        Color buttonFg = new Color(228,131,151);
        
        topLeftButton.setBackground(buttonBg);
        topLeftButton.setForeground(buttonFg);
        topLeftButton.setFont(new Font("Serif", Font.ITALIC, 24));
        
        topRightButton.setBackground(buttonBg);
        topRightButton.setForeground(buttonFg);
        topRightButton.setFont(new Font("Serif", Font.ITALIC, 24));
        
        bottomLeftButton.setBackground(buttonBg);
        bottomLeftButton.setForeground(buttonFg);
        bottomLeftButton.setFont(new Font("Serif", Font.ITALIC, 24));
        
        bottomRightButton.setBackground(buttonBg);
        bottomRightButton.setForeground(buttonFg);
        bottomRightButton.setFont(new Font("Serif", Font.ITALIC, 24));
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            arr.add((int) (Math.random() * 12) + 1 );
            
        }
        
        clock1.setBackground(clockBg);
        clock1.setBorder(blackline);
        clock1.setFont(new Font("Serif", Font.ITALIC, 30));
        clock1.setForeground(clockFg);
        clock1.setText( arr.get(0) < 10 ? "0"+arr.get(0)+":00" : ""+arr.get(0)+":00");
        
        clock2.setBackground(clockBg);
        clock2.setBorder(blackline);
        clock2.setFont(new Font("Serif", Font.ITALIC, 30));
        clock2.setForeground(clockFg);
        clock2.setText( arr.get(1) < 10 ? "0"+arr.get(1)+":00" : ""+arr.get(1)+":00");
        
        clock3.setBackground(clockBg);
        clock3.setBorder(blackline);
        clock3.setFont(new Font("Serif", Font.ITALIC, 30));
        clock3.setForeground(clockFg);
        clock3.setText( arr.get(2) < 10 ? "0"+arr.get(2)+":00" : ""+arr.get(2)+":00");
        
        clock4.setBackground(clockBg);
        clock4.setBorder(blackline);
        clock4.setFont(new Font("Serif", Font.ITALIC, 30));
        clock4.setForeground(clockFg);
        clock4.setText( arr.get(3) < 10 ? "0"+arr.get(3)+":00" : ""+arr.get(3)+":00");
        
        clock5.setBackground(clockBg);
        clock5.setBorder(blackline);
        clock5.setFont(new Font("Serif", Font.ITALIC, 30));
        clock5.setForeground(clockFg);
        clock5.setText( arr.get(4) < 10 ? "0"+arr.get(4)+":00" : ""+arr.get(4)+":00");
        
        clock6.setBackground(clockBg);
        clock6.setBorder(blackline);
        clock6.setFont(new Font("Serif", Font.ITALIC, 30));
        clock6.setForeground(clockFg);
        clock6.setText( arr.get(5) < 10 ? "0"+arr.get(5)+":00" : ""+arr.get(5)+":00");
        
        clock7.setBackground(clockBg);
        clock7.setBorder(blackline);
        clock7.setFont(new Font("Serif", Font.ITALIC, 30));
        clock7.setForeground(clockFg);
        clock7.setText( arr.get(6) < 10 ? "0"+arr.get(6)+":00" : ""+arr.get(6)+":00");
        
        clock8.setBackground(clockBg);
        clock8.setBorder(blackline);
        clock8.setFont(new Font("Serif", Font.ITALIC, 30));
        clock8.setForeground(clockFg);
        clock8.setText( arr.get(7) < 10 ? "0"+arr.get(7)+":00" : ""+arr.get(7)+":00");
        
        clock9.setBackground(clockBg);
        clock9.setBorder(blackline);
        clock9.setFont(new Font("Serif", Font.ITALIC, 30));
        clock9.setForeground(clockFg);
        clock9.setText( arr.get(8) < 10 ? "0"+arr.get(8)+":00" : ""+arr.get(8)+":00");
        
        
        
        // For test case 1 
//        clock1.setText("11:00");
//        clock2.setText("11:00");
//        clock3.setText("12:00");
//        clock4.setText("11:00");
//        clock5.setText("11:00");
//        clock6.setText("12:00");
//        clock7.setText("12:00");
//        clock8.setText("12:00");
//        clock9.setText("12:00");
        
        
        jpanel.setBackground(panelColor);
        
        topLeftButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Button1Action(ev);
            }
        });
        
        topRightButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Button2Action(ev);
            }
        });
        
        bottomLeftButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Button3Action(ev);
            }
        });
        
        bottomRightButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Button4Action(ev);
            }
        });
   
        
        // Adding components to the panel
        jpanel.add(clock1);
        jpanel.add(clock2);
        jpanel.add(clock3);
        
        jpanel.add(topLeftButton);
        jpanel.add(topRightButton);
        
        jpanel.add(clock4);
        jpanel.add(clock5);
        jpanel.add(clock6);
        
        jpanel.add(bottomLeftButton);
        jpanel.add(bottomRightButton);

        jpanel.add(clock7);
        jpanel.add(clock8);
        jpanel.add(clock9);
        
        
        jframe.setContentPane(jpanel);
       
        
        //jframe.getContentPane().add(BorderLayout.WEST, jpanel);
        JMenuBar menuBar = new JMenuBar();
        jframe.setJMenuBar(menuBar);
        
        
        JMenu menu = new JMenu("Help"); // Menu
        menuBar.add(menu);
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        JMenuItem newGame = new JMenuItem("Start New Game");
        
        
        menu.add(exitMenuItem);
        menu.add(newGame);
        
        
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                jframe.dispose();
                String mess = "The new game starts in 5 sec....";
                try {
                    refreshAndRestart(mess);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(jframe, "Interrupted exception!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
//        int h = Integer.valueOf(clock5.getText().split(":")[0]); // Check working getText()
//        System.out.println("this" + h );
        
        jframe.setLayout(null);
        jframe.pack();
        jframe.setVisible(true);
    }
    
    
    
    private void Button1Action(ActionEvent ev)  // Setting adjacent clocks with +1 hours
    {         
        try
        {
            
            int l1 = Integer.parseInt(clock1.getText().split(":")[0]);
            int l2 = Integer.parseInt(clock2.getText().split(":")[0]);
            int l4 = Integer.parseInt(clock4.getText().split(":")[0]);
            int l5 = Integer.parseInt(clock5.getText().split(":")[0]);
            
            l1+=1; l2+=1; l4+=1; l5+=1;
            
            counter+=1;
            
            String aux1 = (l1 < 10) ? "0"+l1+":00" : l1+":00";
            clock1.setText((l1 >12) ? "01:00" : aux1 );
            
            String aux2 = (l2 < 10) ? "0"+l2+":00" : l2+":00";
            clock2.setText((l2 >12) ? "01:00" : aux2 );
            
            String aux4 = (l4 < 10) ? "0"+l4+":00" : l4+":00";
            clock4.setText((l4 >12) ? "01:00" : aux4 );
            
            String aux5 = (l5 < 10) ? "0"+l5+":00" : l5+":00";
            clock5.setText((l5 >12) ? "01:00" : aux5 );
            
            String mess = "Congrats, You won the game in " + counter +  " steps!\n New game starts in 5 seconds....";
                     
            if(checkGameFinish(ev)) {refreshAndRestart(mess);}
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jframe, "Wrong number format!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(jframe, "Interrupted exception!", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    } 
    
    private void Button2Action(ActionEvent ev) // Setting adjacent clocks with +1 hours
    {         
        try
        {
            
            int l2 = Integer.parseInt(clock2.getText().split(":")[0]);
            int l3 = Integer.parseInt(clock3.getText().split(":")[0]);
            int l5 = Integer.parseInt(clock5.getText().split(":")[0]);
            int l6 = Integer.parseInt(clock6.getText().split(":")[0]);
            
            l2+=1; l3+=1; l5+=1; l6+=1;
            counter+=1;
            
            String aux2 = (l2 < 10) ? "0"+l2+":00" : l2+":00";
            clock2.setText((l2 >12) ? "01:00" : aux2 );
            
            String aux3 = (l3 < 10) ? "0"+l3+":00" : l3+":00";
            clock3.setText((l3 >12) ? "01:00" : aux3 );
            
            String aux5 = (l5 < 10) ? "0"+l5+":00" : l5+":00";
            clock5.setText((l5 >12) ? "01:00" : aux5 );
            
            String aux6 = (l6 < 10) ? "0"+l6+":00" : l6+":00";
            clock6.setText((l6 >12) ? "01:00" : aux6 );
            
            String mess = "Congrats, You won the game in " + counter +  " steps!\n New game starts in 5 seconds....";
            if(checkGameFinish(ev)) {refreshAndRestart(mess);}
       
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jframe, "Wrong number format!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(jframe, "Interrupted exception!", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    } 
    
    
    private void Button3Action(ActionEvent ev) // Setting adjacent clocks with +1 hours
    {         
        try
        {
            
            int l4 = Integer.parseInt(clock4.getText().split(":")[0]);
            int l5 = Integer.parseInt(clock5.getText().split(":")[0]);
            int l7 = Integer.parseInt(clock7.getText().split(":")[0]);
            int l8 = Integer.parseInt(clock8.getText().split(":")[0]);
            
            l4+=1; l5+=1; l7+=1; l8+=1;
            
            counter+=1;
            
            String aux4 = (l4 < 10) ? "0"+l4+":00" : l4+":00";
            clock4.setText((l4 >12) ? "01:00" : aux4 );
            
            String aux5 = (l5 < 10) ? "0"+l5+":00" : l5+":00";
            clock5.setText((l5 >12) ? "01:00" : aux5 );
            
            String aux7 = (l7 < 10) ? "0"+l7+":00" : l7+":00";
            clock7.setText((l7 >12) ? "01:00" : aux7 );
            
            String aux8 = (l8 < 10) ? "0"+l8+":00" : l8+":00";
            clock8.setText((l8 >12) ? "01:00" : aux8 );
            
            String mess = "Congrats, You won the game in " + counter +  " steps!\n New game starts in 5 seconds....";
            if(checkGameFinish(ev)) {refreshAndRestart(mess);}
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jframe, "Wrong number format!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(jframe, "Interrupted exception!", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    private void Button4Action(ActionEvent ev) // Setting adjacent clocks with +1 hours
    {         
        try
        {
     
            int l5 = Integer.parseInt(clock5.getText().split(":")[0]);
            int l6 = Integer.parseInt(clock6.getText().split(":")[0]);
            int l8 = Integer.parseInt(clock8.getText().split(":")[0]);
            int l9 = Integer.parseInt(clock9.getText().split(":")[0]);
            
            l5+=1; l6+=1; l8+=1; l9+=1;
            
            counter+=1;
            
            String aux5 = (l5 < 10) ? "0"+l5+":00" : l5+":00";
            clock5.setText((l5 >12) ? "01:00" : aux5 );
            
            String aux6 = (l6 < 10) ? "0"+l6+":00" : l6+":00";
            clock6.setText((l6 >12) ? "01:00" : aux6 );
            
            String aux8 = (l8  < 10) ? "0"+l8+":00" : l8+":00";
            clock8.setText((l8 >12) ? "01:00" : aux8 );
            
            String aux9 = (l9 < 10) ? "0"+l9+":00" : l9+":00";
            clock9.setText((l9 >12) ? "01:00" : aux9 );
            
            
            String mess = "Congrats, You won the game in " + counter +  " steps!\n New game starts in 5 seconds....";
            
            if(checkGameFinish(ev)) {refreshAndRestart(mess);}
           
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jframe, "Wrong number format!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(jframe, "Interrupted exception!", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    
    /**
     * 
     * @param ev which is an Action Event
     * @return a boolean which decides whether the user won the game or the game is still going on.....
     */
    private boolean checkGameFinish(ActionEvent ev)
    {
        boolean l1 = Integer.parseInt(clock1.getText().split(":")[0]) == 12;
        boolean l2 = Integer.parseInt(clock2.getText().split(":")[0]) == 12;
        boolean l3 = Integer.parseInt(clock3.getText().split(":")[0]) == 12;
        boolean l4 = Integer.parseInt(clock4.getText().split(":")[0]) == 12;
        boolean l5 = Integer.parseInt(clock5.getText().split(":")[0]) == 12;
        boolean l6 = Integer.parseInt(clock5.getText().split(":")[0]) == 12;
        boolean l7 = Integer.parseInt(clock5.getText().split(":")[0]) == 12;
        boolean l8 = Integer.parseInt(clock5.getText().split(":")[0]) == 12;
        boolean l9 = Integer.parseInt(clock5.getText().split(":")[0]) == 12;
        
        boolean check = l1 && l2 && l3 && l4 && l5 && l6 && l7 && l8 && l9 ;
        
        return check;
    }
    
    
    /**
     * This function disposes the current frame a makes a new one after displaying a message
     * @param mess which is a string displayed as dialog message
     * @throws InterruptedException 
     */
    private void refreshAndRestart(String mess) throws InterruptedException 
    {
        JOptionPane.showMessageDialog(jframe, mess);
        Thread.sleep(5000);
        jframe.dispose();
        declareFrame();
    }
    
    
    
    
}
