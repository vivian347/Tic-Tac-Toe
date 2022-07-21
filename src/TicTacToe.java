import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JLabel t_field = new JLabel();
    JPanel b_panel = new JPanel();
    JButton[] buttons = new JButton[9];
    boolean player_a = true;

//   constructor for class
    public TicTacToe(){
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(0,0,0));
        frame.setVisible(true);

        t_field.setBackground(new Color(0,0,0));
        t_field.setForeground(new Color(255, 255,255));
        t_field.setFont(new Font("Larken", Font.BOLD,75));
        t_field.setHorizontalAlignment(JLabel.CENTER);
        t_field.setText("TicTacToe");
        t_field.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0, 500, 500);

        b_panel.setLayout(new GridLayout(3,3));
        b_panel.setBackground(new Color(0,0,0));

        for(int i = 0; i < 9; i++)
        {
            buttons[i]= new JButton();
            b_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Taberna", Font.BOLD, 150));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        title.add(t_field);
        frame.add(title, BorderLayout.NORTH);
        frame.add(b_panel);

        first();
    }

// action performed method for actionlistener
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++)
        {
            if (e.getSource() == buttons[i])
            {
                if (player_a)
                {
                    if (buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(0,0,0));
                        buttons[i].setText("X");
                        player_a = false;
                        t_field.setText("Z's turn");
                        winner();
                    }
                }
                else
                {
                    if (buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(0,0,0));
                        buttons[i].setText("O");
                        player_a = true;
                        t_field.setText("A's turn");
                        winner();
                    }
                }
            }
        }
    }

//    method to determine who goes first
    public void first()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextInt(2) == 0)
        {
            player_a = true;
            t_field.setText("A's turn");
        }
        else
        {
            player_a =false;
            t_field.setText("Z's turn");
        }
    }

//    method to check winner
    public void winner()
    {
//        check X wins
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText()== "X")&&
                        (buttons[2].getText() == "X")
        ){
            aWins(0,1,2);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText()== "X")&&
                        (buttons[5].getText() == "X")
        ){
            aWins(3,4,5);
        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText()== "X")&&
                        (buttons[8].getText() == "X")
        ){
            aWins(6,7,8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText()== "X")&&
                        (buttons[6].getText() == "X")
        ){
            aWins(0,3,6);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText()== "X")&&
                        (buttons[7].getText() == "X")
        ){
            aWins(01,4,7);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText()== "X")&&
                        (buttons[8].getText() == "X")
        ){
            aWins(2, 5,8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText()== "X")&&
                        (buttons[8].getText() == "X")
        ){
            aWins(0,4,8);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText()== "X")&&
                        (buttons[6].getText() == "X")
        ){
            aWins(2,4,6);
        }

//        check O wins
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText()== "O")&&
                        (buttons[2].getText() == "O")
        ){
            zWins(0,1,2);
        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText()== "O")&&
                        (buttons[5].getText() == "O")
        ){
            zWins(3,4,5);
        }
        if (
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText()== "O")&&
                        (buttons[8].getText() == "O")
        ){
            zWins(6,7,8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText()== "O")&&
                        (buttons[6].getText() == "O")
        ){
            zWins(0,3,6);
        }
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText()== "O")&&
                        (buttons[7].getText() == "O")
        ){
            zWins(01,4,7);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText()== "O")&&
                        (buttons[8].getText() == "O")
        ){
            zWins(2, 5,8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText()== "O")&&
                        (buttons[8].getText() == "O")
        ){
            zWins(0,4,8);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText()== "O")&&
                        (buttons[6].getText() == "O")
        ){
            zWins(2,4,6);
        }

    }

//    method for if a wins
    public void aWins(int i, int j, int k)
    {
        buttons[i].setForeground(Color.gray);
        buttons[j].setForeground(Color.gray);
        buttons[k].setForeground(Color.gray);

        for(int n =0; n<9;n++)
        {
            buttons[i].setEnabled(false);
        }
        t_field.setText("Player A wins");
    }

//    method for when z wins
    public void zWins(int i, int j, int k)
    {
        buttons[i].setForeground(Color.gray);
        buttons[j].setForeground(Color.gray);
        buttons[k].setForeground(Color.gray);

        for(int n =0; n<9;n++)
        {
            buttons[i].setEnabled(false);
        }
        t_field.setText("Player Z wins");
    }

}
