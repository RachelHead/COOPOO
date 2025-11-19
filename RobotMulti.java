import java.util.Random;

public class RobotMulti extends Robot
{
    private int compte;
    private boolean multiplié;
    /**
     * Constructeur d'objets de classe RobotMulti
     */
    
    public RobotMulti(int PosX, int PosY){
        super(PosX, PosY);
        compte = 0;
        multiplié = true;
        canvasRobot = new CanvasRobot("blue");
        canvasRobot.drawRobot(PosX, PosY);
    }

    public void multiplication()
    {
        if(multiplié){
            int PosX = 0;
            int PosY = 0;
            if(this.x > World.MIN_POSITION){
                PosX = this.x - 1;
            } else if (this.y > World.MIN_POSITION){
                PosY = this.y - 1;
            } else if (this.x < World.MAX_POSITION){
                PosX = this.x + 1;
            } else if (this.y < World.MAX_POSITION){
                PosY = this.y + 1;
            }
            RobotMulti nouveauRob = new RobotMulti(PosX, PosY); 
            this.multiplié = false;    
        } 
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
        this.compte ++;
        if (this.compte == 10){
            multiplication();
        }
        canvasRobot.drawRobot(x, y);
    }
}


