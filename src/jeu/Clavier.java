package jeu;

import java.awt.event.*;

// import audio.Audio;

public class Clavier implements KeyListener {

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {

        if (e.getKeyCode() == 90 && flappyMain.scene.finDuJeu == false) { // touche Z (saut)
            flappyMain.scene.flappyBird.monte();
            Audio.playSound("/audio/battementAile.wav");
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {

    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
    }

}