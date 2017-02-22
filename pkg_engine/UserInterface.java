package pkg_engine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;

/**
 * Décrivez votre classe UserInterface ici.
 *
 * @author Baptiste HULIN
 * @version (un numéro de version ou une date)
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame myFrame;
    private JTextField aEntryField;
    private JTextArea log;
    private JLabel image;
    private JButton aButton1, aButton2, aButton3, aButton4, aButton5, 
    aButton6, aButton7, aButton8, aButton9, aButton10;

    /**
     * Construit une interface utilisateur
     * Un moteur de jeu est requis en tant que paramètre
     */
    public UserInterface (GameEngine aGE)
    {
        aEngine = aGE;
        createGUI();
    }

    /**
     * Affiche du texte dans la zone de texte
     */
    public void print (String text)
    {
        log.append(text);
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * Affiche du texte dans la zone de texte, suivi d'un saut de ligne
     */
    public void println (String text)
    {
        log.append(text + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * Affiche une image dans l'interface
     */
    public void showImage (String imageName)
    {
        URL imageURL = this.getClass().getClassLoader().getResource(imageName);
        if(imageURL == null)
            System.out.println("image not found");
        else 
        {
            ImageIcon icon = new ImageIcon(imageURL);
            image.setIcon(icon);
            myFrame.pack();
        }
    }

    /**
     * Enable or disable input in the input field.
     */
    public void enable(boolean on)
    {
        aEntryField.setEditable(on);
        if(!on)
        { 
            aEntryField.getCaret().setBlinkRate(0);
            aButton1.setVisible(false);
            aButton2.setVisible(false);
            aButton3.setVisible(false);
            aButton4.setVisible(false);
            aButton5.setVisible(false);
            aButton6.setVisible(false);
            aButton7.setVisible(false);
            aButton8.setVisible(false);
            aButton9.setVisible(false);
            aButton10.setVisible(false);
        }
    }

    /**
     * Créé l'interface joueur graphique
     */
    private void createGUI()
    {
        myFrame = new JFrame ("Nargael and the Wind Blade");

        aEntryField = new JTextField(34);

        this.aButton1 = new JButton ("East");
        this.aButton2 = new JButton ("West");
        this.aButton3 = new JButton ("South");
        this.aButton5 = new JButton("Quit");
        this.aButton6 = new JButton ("Look");
        this.aButton7 = new JButton ("Back");
        this.aButton8 = new JButton ("Help");
        this.aButton4 = new JButton ("North");
        this.aButton9 = new JButton ("Up");
        this.aButton10 = new JButton ("Down");

        this.aButton1.setBackground(Color.LIGHT_GRAY );
        this.aButton2.setBackground(Color.LIGHT_GRAY );
        this.aButton3.setBackground(Color.LIGHT_GRAY );
        this.aButton5.setBackground(Color.red );
        this.aButton6.setBackground(Color.LIGHT_GRAY );
        this.aButton7.setBackground(Color.LIGHT_GRAY );
        this.aButton8.setBackground(Color.LIGHT_GRAY );
        this.aButton4.setBackground(Color.LIGHT_GRAY );
        this.aButton9.setBackground(Color.LIGHT_GRAY );
        this.aButton10.setBackground(Color.LIGHT_GRAY );
        
        log = new JTextArea();
        log.setEditable(false);
        JScrollPane listScroller = new JScrollPane(log);
        listScroller.setPreferredSize(new Dimension (100, 100));
        listScroller.setMinimumSize(new Dimension(10,10));

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JPanel left = new JPanel();
        image = new JLabel();

        panel.setLayout(new BorderLayout());

        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(aEntryField, BorderLayout.SOUTH);
        panel.add(panel2, BorderLayout.EAST);
        panel.add(left, BorderLayout.WEST);

        panel2.setLayout(new BorderLayout());
        //         panel3.setLayout(new BoxLayout());
        Box box = Box.createVerticalBox();

        panel2.add(aButton1, BorderLayout.EAST);
        panel2.add(aButton2, BorderLayout.WEST);
        panel2.add(aButton3, BorderLayout.SOUTH);
        panel2.add(aButton4, BorderLayout.NORTH);

        left.add(aButton5, BorderLayout.NORTH);
        left.add(aButton6, BorderLayout.NORTH);
        left.add(aButton7, BorderLayout.WEST);
        left.add(aButton8, BorderLayout.SOUTH);
        left.add(box, BorderLayout.SOUTH);

        //         panel3.add(aButton8, BoxLayout.NORTH);
        //         panel3.add(aButton9, BoxLayout.CENTER);
        //         panel3.add(aButton10, BoxLayout.SOUTH);
        
        box.add(aButton9);
        box.add(aButton8);
        box.add(aButton10);

        myFrame.getContentPane().add(panel, BorderLayout.CENTER);
        // add some event listeners to some components
        myFrame.addWindowListener(new WindowAdapter()
            { public void windowClosing(WindowEvent e) { System.exit(0);}

            });
        aEntryField.addActionListener(this);
        aButton1.addActionListener(this);
        aButton2.addActionListener(this);
        aButton3.addActionListener(this);
        aButton4.addActionListener(this);
        aButton5.addActionListener(this);
        aButton6.addActionListener(this);
        aButton7.addActionListener(this);
        aButton8.addActionListener(this);
        aButton9.addActionListener(this);
        aButton10.addActionListener(this);
        
        myFrame.pack();
        myFrame.setVisible(true);
        aEntryField.requestFocus();
    }

    /**
     * Interface de lecteur d'action pour le champ de texte
     */
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("Quit"))
            aEngine.interpretCommand("quit");

        else if(e.getActionCommand().equals("Look"))
            aEngine.interpretCommand("look");

        else if(e.getActionCommand().equals("Back"))
            aEngine.interpretCommand("back");

        else if(e.getActionCommand().equals("Help"))
            aEngine.interpretCommand("help");

        else if(e.getActionCommand().equals("North"))
            aEngine.interpretCommand("go north");

        else if(e.getActionCommand().equals("East"))
            aEngine.interpretCommand("go east");

        else if(e.getActionCommand().equals("West"))
            aEngine.interpretCommand("go west");

        else if(e.getActionCommand().equals("South"))
            aEngine.interpretCommand("go south");
        
        else if(e.getActionCommand().equals("Up"))
            aEngine.interpretCommand("go up");
        
        else if(e.getActionCommand().equals("Down"))
            aEngine.interpretCommand("go down");
            
        else processCommand();
    }

    /**
     * Une commande a été saisie. Lire la commande et effectue le 
     * nécessaire pour effectuer cette commande.
     */
    private void processCommand()
    {
        boolean vFinished = false;
        String input = aEntryField.getText();
        aEntryField.setText("");

        aEngine.interpretCommand(input);
    }

}
