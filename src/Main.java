import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Main extends JFrame implements ActionListener {

    private  int counter = 0;
    private List<JButton> buttons = new ArrayList<>();

    public Main() {

        setTitle("Kółko i Krzyżyk");

        setSize(500, 500);

        GridLayout gridLayout = new GridLayout(3, 3);

        setLayout(gridLayout);

        for (int i = 1; i <= 9; i++) {

            JButton button = new JButton("");

            button.addActionListener(this);

            buttons.add(button);

            add(button);

        }

        setVisible(true);

    }    public static void main(String[] args) {

        // write your code here

        SwingUtilities.invokeLater(new Runnable() {

            @Override

            public void run() {

                new Main();

            }

        });

    }

    public void actionPerformed(ActionEvent e) {

        JButton clikedButton = (JButton) e.getSource();

        if (counter % 2 == 0) {

            clikedButton.setText("X");

        } else {

            clikedButton.setText("0");

        }

        counter++;

        clikedButton.setEnabled(false);
        if (isWinner()){
            JOptionPane.showMessageDialog(null, "Koniec gry");
            dispose();

            
        }

        System.out.println(isWinner());


    }
    private  boolean isWinner(){
            return (isWinner(0, 1, 2) ||
                    isWinner(3, 4, 5) ||
                    isWinner(6, 7, 8) ||
                    isWinner(0, 3, 6) ||
                    isWinner(1, 4, 7) ||
                    isWinner(2, 5, 8) ||
                    isWinner(0, 4, 8) ||
                    isWinner(6, 4, 2)
            );

    }    private boolean isWinner(int i, int j, int k) {

        boolean a =buttons.get(i).getText().equals(buttons.get(j).getText()) &&

                buttons.get(j).getText().equals(buttons.get(k).getText())

                && !buttons.get(i).getText().equals("");

        if(a==true) {

            buttons.get(i).setBackground(Color.green);

            buttons.get(j).setBackground(Color.green);

            buttons.get(k).setBackground(Color.green);

        }

        return a;

    }

}



