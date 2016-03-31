import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private final int sup;      // margen superior
    private final int iz;      // margen izquierdo
    private final int der;      // margen superior derecho
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private int xSpeed = 1;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int superior,
                        int groundPos, int izquierda, int derecha, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        sup = superior;
        iz = izquierda;
        der = derecha;
        canvas = drawingCanvas;
        
        xSpeedChange();
        ySpeedChange();
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        ySpeed += 0;
        yPosition += ySpeed;
        
        xSpeed +=0;
        xPosition += xSpeed;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter)) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed; 
        }
        
        // comprueba que no supere la altura del rectángulo
        if(yPosition <= (sup + diameter)) {
            yPosition = (int)(sup + diameter);
            ySpeed = -ySpeed; 
        }
        
        // comprueba si ha llegado a la derecha
        if(xPosition >= (der - diameter)) {
            xPosition = (int)(der - diameter);
            xSpeed = -xSpeed; 
        }
        
        // comprueba si ha llegado a la izquierda
        if(xPosition <= (iz - diameter)) {
            xPosition = (int)(iz - diameter);
            xSpeed = -xSpeed; 
        }
        

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    private int xSpeedChange()
    {
        Random rnd = new Random();
        int x = rnd.nextInt(100);
        if (x > 50)
        {
            xSpeed = -xSpeed;
        }
        else
        {
            xSpeed = xSpeed;
        }
        return xSpeed;
    }
    
    private int ySpeedChange()
    {
        Random rnd = new Random();
        int y = rnd.nextInt(100);
        if (y > 50)
        {
            ySpeed = -ySpeed;
        }
        else
        {
            ySpeed = ySpeed;
        }
        return ySpeed;
    }
}
