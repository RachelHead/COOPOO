import java.util.Random;

/**
 * Décrivez votre classe Robot ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public abstract class Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    protected int x;
    protected int y;
    protected String name;
    protected String color = "BLACK";
    protected CanvasRobot canvasRobot;
    static int cpt = 1;
    protected World world;

    /**
     * Constructeur d'objets de classe Robot
     */
    public Robot(int x, int y)
    {
        world = new World();
        this.x = x;
        this.y = y;
        name = "Robot"+cpt;
        cpt++;
    }

    public void setX(int posX){
        this.x = posX;
    }
    
    public void setY(int posY){
        this.y = posY;
    }
    
    public int getX(){
        return(x);
    }
    
    public int getY(){
        return(y);
    }

    public String getName()
    {
        return name;
    }


    public void move()
    {
        System.out.println("Le robot se déplace");
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
    
    public String affRobot(){
         return name + " : " + x + " " + y;
    }
}
