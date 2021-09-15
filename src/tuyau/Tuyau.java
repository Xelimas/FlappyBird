package tuyau;

import javax.swing.ImageIcon;
import java.awt.*;

public class Tuyau {
    private int largeur;
    private int hauteur;
    private int x;
    private int y;
    private String strImage;
    private ImageIcon icoTuyau;
    private Image imgTuyau;

    public Tuyau(int x, int y, String strImage) {

        this.largeur = 50;
        this.hauteur = 300;
        this.x = x;
        this.y = y;
        this.strImage = strImage;

        this.icoTuyau = new ImageIcon(getClass().getResource(strImage));
        this.imgTuyau = icoTuyau.getImage();
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
     * @return ImageIcon return the icoTuyau
     */
    public ImageIcon getIcoTuyau() {
        return icoTuyau;
    }

    /**
     * @param icoTuyau the icoTuyau to set
     */
    public void setIcoTuyau(ImageIcon icoTuyau) {
        this.icoTuyau = icoTuyau;
    }

    /**
     * @return Image return the imgTuyau
     */
    public Image getImgTuyau() {
        return imgTuyau;
    }

    /**
     * @param imgTuyau the imgTuyau to set
     */
    public void setImgTuyau(Image imgTuyau) {
        this.imgTuyau = imgTuyau;
    }

}