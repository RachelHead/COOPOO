import java.util.Random;

/**
 * Décrivez votre classe RobotDisco ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RobotDisco extends Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    /**
     * Constructeur d'objets de classe RobotDisco 
     */
    public RobotDisco(int x, int y)
    {
        // initialisation des variables d'instance
        super(x, y);
        canvasRobot = new CanvasRobot("red");
        canvasRobot.drawRobot(x, y);
    }

    public void changeColours(){
        Random randomGenerator = new Random();
        boolean oui = false;
        // parcours de toutes les couleurs.
        // pour chaque, pile ou face l'associe à une partie du corps au pif
        for (Colour c : Colour.values()){
            oui = randomGenerator.nextBoolean();
            if (oui){
                int corps = randomGenerator.nextInt(4);
                switch (corps){
                    case 0 :
                        canvasRobot.setColourHead(c);
                        break;
                    case 1 :
                        canvasRobot.setColourBody(c);
                        break;
                    case 2 :
                        canvasRobot.setColourLeg(c);
                        break;
                    case 3 :
                        canvasRobot.setColourEye(c);
                        break; 
                }
            }
        }    
        canvasRobot.drawRobot(x, y);
    }
    
    public void move(){
        super.move();
        this.changeColours();
    }
}