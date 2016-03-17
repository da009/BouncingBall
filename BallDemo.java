import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> bolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bolas = new ArrayList<BouncingBall>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        // Crea bolas hasta q llega al número introducido por el usuario.
        for (int cont=0; cont<numBolas; cont++)
        {
            Random rnd = new Random();
            // genera un número aleatorio dentro del rango
            int x = rnd.nextInt(200);
            int y =  rnd.nextInt(200);
            
            int r = rnd.nextInt(256);
            int g = rnd.nextInt(256);
            int b = rnd.nextInt(256);
            // crate and show the balls
            BouncingBall ball = new BouncingBall(x, y, 20, new Color(r, g, b), ground, myCanvas);
            ball.draw();
            bolas.add(ball);
        }
        // make them bounce
        boolean finished =  false;
        int index = 0;
        while(!finished) {
            for(BouncingBall ball : bolas)
                {
                myCanvas.wait(50);           // small delay
                ball.move();
                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
