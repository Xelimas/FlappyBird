package jeu;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tuyau.Tuyau;

import java.awt.*;
import java.util.Random;

public class Scene extends JPanel {

    private ImageIcon icoBandeFond;
    private Image imgBandeFond;

    public Tuyau tuyauHaut1;
    public Tuyau tuyauHaut2;
    public Tuyau tuyauHaut3;
    public Tuyau tuyauBas1;
    public Tuyau tuyauBas2;
    public Tuyau tuyauBas3;

    private final int LARGEUR_BANDE_FOND = 140;
    private final int DISTANCE_TUYAU = 250;
    private final int ECART_TUYAU = 120;

    public int xFonds;
    private int dxTuyaux;
    private int xTuyaux;

    private Random hasard;

    public Scene() {
        super();
        this.icoBandeFond = new ImageIcon(getClass().getResource("/images/bandeFondEcran.png"));
        this.imgBandeFond = this.icoBandeFond.getImage();
        this.xFonds = 0;

        this.xTuyaux = 100;
        this.dxTuyaux = 0;

        this.tuyauHaut1 = new Tuyau(this.xTuyaux, -150, "/images/tuyauHaut.png");
        this.tuyauBas1 = new Tuyau(this.xTuyaux, 250, "/images/tuyauBas.png");

        this.tuyauHaut2 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAU, -100, "/images/tuyauHaut.png");
        this.tuyauBas2 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAU, 300, "/images/tuyauBas.png");

        this.tuyauHaut3 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAU * 2, -120, "/images/tuyauHaut.png");
        this.tuyauBas3 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAU * 2, 280, "/images/tuyauBas.png");

        hasard = new Random();

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    private void deplacementFond(Graphics g) {
        if (this.xFonds == -this.LARGEUR_BANDE_FOND) {
            this.xFonds = 0;
        }
        g.drawImage(this.imgBandeFond, this.xFonds, 0, null);
        g.drawImage(this.imgBandeFond, this.xFonds + this.LARGEUR_BANDE_FOND, 0, null);
        g.drawImage(this.imgBandeFond, this.xFonds + this.LARGEUR_BANDE_FOND * 2, 0, null);
        g.drawImage(this.imgBandeFond, this.xFonds + this.LARGEUR_BANDE_FOND * 3, 0, null);
    }

    private void deplacementTuyaux(Graphics g) {
        // Tuyau 1
        this.tuyauHaut1.setX(this.tuyauHaut1.getX() - 1);
        this.tuyauBas1.setX(this.tuyauHaut1.getX());

        if(this.tuyauHaut1.getX() == -100) {
            this.tuyauHaut1.setX(this.tuyauHaut3.getX() + this.DISTANCE_TUYAU);
            this.tuyauHaut1.setY(-100 - 10 * this.hasard.nextInt(18));
            this.tuyauBas1.setY(this.tuyauHaut1.getY() + this.tuyauHaut1.getHauteur() + this.ECART_TUYAU);
        }
        g.drawImage(this.tuyauHaut1.getImgTuyau(), this.tuyauHaut1.getX(), this.tuyauHaut1.getY(), null);
        g.drawImage(this.tuyauBas1.getImgTuyau(), this.tuyauBas1.getX(), this.tuyauBas1.getY(), null);

        // Tuyau 2
        this.tuyauHaut2.setX(this.tuyauHaut2.getX() - 1);
        this.tuyauBas2.setX(this.tuyauHaut2.getX());

        if(this.tuyauHaut2.getX() == -100) {
            this.tuyauHaut2.setX(this.tuyauHaut1.getX() + this.DISTANCE_TUYAU);
            this.tuyauHaut2.setY(-100 - 10 * this.hasard.nextInt(18));
            this.tuyauBas2.setY(this.tuyauHaut2.getY() + this.tuyauHaut2.getHauteur() + this.ECART_TUYAU);
        }
        g.drawImage(this.tuyauHaut2.getImgTuyau(), this.tuyauHaut2.getX(), this.tuyauHaut2.getY(), null);
        g.drawImage(this.tuyauBas2.getImgTuyau(), this.tuyauBas2.getX(), this.tuyauBas2.getY(), null);

        // Tuyau 3
        this.tuyauHaut3.setX(this.tuyauHaut3.getX() - 1);
        this.tuyauBas3.setX(this.tuyauHaut3.getX());

        if(this.tuyauHaut3.getX() == -100) {
            this.tuyauHaut3.setX(this.tuyauHaut2.getX() + this.DISTANCE_TUYAU);
            this.tuyauHaut3.setY(-100 - 10 * this.hasard.nextInt(18));
            this.tuyauBas3.setY(this.tuyauHaut3.getY() + this.tuyauHaut3.getHauteur() + this.ECART_TUYAU);
        }
        g.drawImage(this.tuyauHaut3.getImgTuyau(), this.tuyauHaut3.getX(), this.tuyauHaut3.getY(), null);
        g.drawImage(this.tuyauBas3.getImgTuyau(), this.tuyauBas3.getX(), this.tuyauBas3.getY(), null);
    }

    public void paintComponent(Graphics g) {
        this.deplacementFond(g);
        this.deplacementTuyaux(g);
    }
}