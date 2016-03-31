import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.geom.*;

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
    
    private ArrayList<BoxBall> box;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bolas = new ArrayList<BouncingBall>();
        box = new ArrayList<BoxBall>();
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
            int y = rnd.nextInt(200);

            int r = rnd.nextInt(256);
            int g = rnd.nextInt(256);
            int b = rnd.nextInt(256);

            int radio =  rnd.nextInt(200);
            // crate and show the balls
            BouncingBall ball = new BouncingBall(x, y, radio, new Color(r, g, b), ground, myCanvas);
            ball.draw();
            bolas.add(ball);
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50); 
            for(BouncingBall ball : bolas)
            {          // small delay
                ball.move();
                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() > 550) {
                    finished = true;
                }
            }
        }
    }
    
    /**
     * Dibuja un rectángulo sin relleno en la pantalla y tantas bolas como se indiquen como parámetro en la 
     * invocación del método dentro de dicho rectángulo
     */
    public void boxBounce(int numBolas)
    {
        myCanvas.setVisible(true);
        Random rnd = new Random();
                       //Inix; Iniy; Finx; Finy
        myCanvas.drawLine(50, 100, 550, 100); // Sup
        myCanvas.drawLine(50, 400, 550, 400); // Inf
        myCanvas.drawLine(50, 400, 50, 100); // Iz
        myCanvas.drawLine(550, 400, 550, 100); // Der
        
        // Crea bolas hasta q llega al número introducido por el usuario.
        for (int cont=0; cont<numBolas; cont++)
        {
            // genera un número aleatorio dentro del rango
            int x = 0;
            int y = 0;
            
            // color aleatorio
            int r = rnd.nextInt(256);
            int g = rnd.nextInt(256);
            int b = rnd.nextInt(256);
            while (x < 100)
            {
                x = rnd.nextInt(500);
            }
            while (y < 150)
            {
                y = rnd.nextInt(350);
            }
            // crate and show the balls
            BoxBall ball = new BoxBall(x, y, 50,  new Color(r, g, b), 50, 400, 100, 550, myCanvas);
            ball.draw();
            box.add(ball);
        }
        
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50); 
            for(BoxBall ball : box)
            {          // small delay
                ball.move();
            }
        }
    }
}
