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
        int x = 0;
        int y = 0;
        
        // Crea bolas hasta q llega al número introducido por el usuario.
        for (int cont = 0; cont <=numBolas; cont++)
        {
            // crate and show the balls
            BouncingBall ball = new BouncingBall(x, y, 16, Color.BLUE, ground, myCanvas);
            ball.draw();
            bolas.add(ball);
            x = x+5;
            y = y+10;
            cont++;
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
