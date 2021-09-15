package personnages;

import javax.swing.ImageIcon;

import tuyau.Tuyau;

import java.awt.*;

public class FlappyBird implements Runnable {

    private int largeur;
    private int hauteur;
    private int x;
    private int y;
    private int dy;
    private String strImage;
    private ImageIcon icoOiseau;
    private Image imgOiseau;
    private final int PAUSE = 10;

    public FlappyBird(int x, int y, String strImage) {
        this.largeur = 34;
        this.hauteur = 24;
        this.x = x;
        this.y = y;
        this.strImage = strImage;
        this.icoOiseau = new ImageIcon(getClass().getResource(this.strImage));
        this.imgOiseau = this.icoOiseau.getImage();

        Thread chronoAiles = new Thread(this);
        chronoAiles.start();
    }

    public void monte() {
        this.dy = 50;
    }

    private void batDesAiles(int dy) {
        if (this.dy > 10) {
            this.icoOiseau = new ImageIcon(getClass().getResource("/images/oiseau2.png"));
            this.imgOiseau = this.icoOiseau.getImage();
            this.y = this.y - 3;
        } else if (this.dy > 5) {
            this.y = this.y - 2;
        } else if (this.dy > 1) {
            this.y = this.y - 1;
        } else if (this.dy == 1) {
            this.icoOiseau = new ImageIcon(getClass().getResource("/images/oiseau1.png"));
            this.imgOiseau = this.icoOiseau.getImage();
        }
    }

    public boolean collision(Tuyau tuyau) {
        if (tuyau.getY() < 50) { // Tuyau haut
            if (this.y <= tuyau.getY() + tuyau.getHauteur() && this.x + this.largeur >= tuyau.getX()
                    && this.x <= tuyau.getX() + tuyau.getLargeur()) {
                return true;
            } else {
                return false;
            }
        } else if (this.y + this.hauteur >= tuyau.getY() && this.x + this.largeur >= tuyau.getX()
                && this.x <= tuyau.getX() + tuyau.getLargeur()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.batDesAiles(dy);
                this.dy--;
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
            }
        }

    }

    /**
     * @return int return the largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * @return int return the hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * @return int return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return int return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return int return the dy
     */
    public int getDy() {
        return dy;
    }

    /**
     * @param dy the dy to set
     */
    public void setDy(int dy) {
        this.dy = dy;
    }

    /**
     * @return ImageIcon return the icoOiseau
     */
    public ImageIcon getIcoOiseau() {
        return icoOiseau;
    }

    /**
     * @return Image return the imgOiseau
     */
    public Image getImgOiseau() {
        return imgOiseau;
    }

}