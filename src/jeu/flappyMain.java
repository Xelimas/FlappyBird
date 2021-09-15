package jeu;
import javax.swing.JFrame;


public class flappyMain {

    
    public static Scene scene;
    public static void main(String[] args) throws Exception {


        JFrame fenetre = new JFrame("jeu Flappy Bird");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(300, 425);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setAlwaysOnTop(true);

        scene = new Scene();

        fenetre.setContentPane(scene);
        fenetre.setVisible(true);

    }
}
