package jeu;

public class Chrono implements Runnable {

    private final int PAUSE = 5;

    @Override
    public void run() {

        while (flappyMain.scene.finDuJeu == false) {

            flappyMain.scene.xFonds--;
            flappyMain.scene.repaint();
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
            }
        }

    }
}