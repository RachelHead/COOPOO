
/**
 * Décrivez votre classe RobotLinér ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RobotLinér extends Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int direction;
    /**
     * Constructeur d'objets de classe RobotLinér
     */
    public RobotLinér(int direction, int x, int y)
    {
        super(x, y);
        canvasRobot = new CanvasRobot ("PURPLE");
        canvasRobot.drawRobot(x,y);
        this.direction = direction;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    
    public void move() {
        // si 
        switch(direction) {
            
            case 0: // gauche
               if (!world.noCollisionOk(x+1, y)){
                   System.out.println("D norme");
                   direction = 1;
                   x++;
                } else {
                    x--;
                }
                   
                break;
            case 1: // droite
                if (!world.noCollisionOk(x-1, y)){
                    System.out.println("G norme");
                    direction = 0;
                    x--;
               } else {
                   x++;
               }
                
                break;
            case 2: // bas
                if (!world.noCollisionOk(x, y+1)){
                    System.out.println("H norme");
                    direction = 3;
                    y++; 
                } else {  
                    y--;
                } 
                break;
            case 3: // haut
                if (!world.noCollisionOk(x, y-1)){
                    System.out.println("B norme");
                    direction = 2;
                    y--;
                } else {
                    y++;
                }
                break;
        }
        canvasRobot.drawRobot(x,y);
        }
            
    private int getDirection()
    {
        return(direction);
    }
    public int getX()
    {
        return(x);
    }
    public int getY(){
        return(y);
    }
    }


