import java.util.Random;

/**
 * Décrivez votre classe RobotPapi ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RobotPapi extends Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private boolean pause = false;
    String color = "GREEN";
    static private Random randomGenerator;
    /**
     * Constructeur d'objets de classe RobotPapi
     */
    public RobotPapi(int x, int y)
    {
        super(x, y);
        canvasRobot = new CanvasRobot(color);
        canvasRobot.drawRobot(x,y);
        randomGenerator = new Random();
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void move() 
    {
        if(pause)
        {
            System.out.println("Papi se déplace");
            Random randomGenerator = new Random();
            // definir une direction 0 à 3 
            int direction = randomGenerator.nextInt(4);
            boolean ok = false;
            // calcul des nouvelles coordonnées
            switch (direction) {
                case 0: // droite
                    if (world.noCollisionOk(x+1, y)){
                        x = x+1;ok = true;
                    }break;
                case 1: // bas
                    if (world.noCollisionOk(x, y+1)){
                        y = y+1;ok = true;
                    }break;
                case 2: // gauche
                    if (world.noCollisionOk(x-1, y)){
                        x = x-1;ok = true;
                    }break;
                case 3: // haut
                    if (world.noCollisionOk(x, y-1)){
                        y = y-1;ok = true;
                    }break;
            }
            if (!ok) {
                System.out.println("déplacement impossible");
            }
            canvasRobot.drawRobot(x, y);
            // verif dans world parmi les positions des robots si celle-ci est recevable
        }
        else
        {
            System.out.println("Papi ne se déplace pas");
        }
        if(pause)
            pause = false;
        else
            pause = true;
    }
}


