import java.util.ArrayList;
import java.util.Random;

/**
 * Décrivez votre classe World ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class World
{
    private ArrayList<Robot> listRobots;
    final static int MAX_POSITION = 11;
    final static int MIN_POSITION = 0;
    /**
     * Constructeur d'objets de classe World
     */
    public World()
    {
        listRobots = new ArrayList<Robot>();
    }
    
    public void affListRobots(){
        for (Robot r : listRobots){
            System.out.println(r.affRobot());
        }
    }
    
    public boolean noCollisionOk(int x, int y) {
        // verifier si les coordonnées 
        System.out.println("Coors : "+x+" "+y);
        if (x > MAX_POSITION || x < MIN_POSITION || y > MAX_POSITION || y < MIN_POSITION){
            return false;
        }
        for (Robot r : listRobots){
            if (r.getX() == x && r.getY() == y) {
                return false;
            }
        }
        return true;
    }
    
    
    private int[] genererCoors(){
        // Verifier qu'il reste au moins une case de libre
        int nbMaxRobots = (MAX_POSITION+1)*(MAX_POSITION+1);
        if (listRobots.size() >= nbMaxRobots){
            System.out.println("Plus de place !");
            return new int[]{-1, -1};
        }
        else {
          // Trouver une case parmi les libres
            Random randomGenerator = new Random();
            int x = 0;
            int y = 0;
            boolean ok = false;
            while (!ok) {
                x = randomGenerator.nextInt(MAX_POSITION+1);
                y = randomGenerator.nextInt(MAX_POSITION+1);
                if (noCollisionOk(x, y)){
                    ok = true;
                } 
                else {
                    System.out.println("superposition : changement de position");
                }
            }
            return new int[]{x, y};  
        }
    }
    
    public void addRobotDisco(){
        int[] tab = genererCoors();
        if (tab[0] != -1){
            int x = tab[0]; int y = tab[1];
            Robot newR = new RobotDisco(x, y);
            
            listRobots.add(newR);
        }
    }
    
    public void addRobotPapi(){
        int[] tab = genererCoors();
        if (tab[0] != -1){
            int x = tab[0]; int y = tab[1];
            Robot newR = new RobotPapi(x, y);
            
            listRobots.add(newR);
        }
    }
    
    
    public void addRobotMultiplicateur(){
        int[] tab = genererCoors();
        if (tab[0] != -1){
            int x = tab[0]; int y = tab[1];
            Robot newR = new RobotMulti(x, y);
            
            listRobots.add(newR);
        }
    }
    
    /**
    public void addRobotCavalier(){
        int[] tab = genererCoors();
        if (tab[0] != -1){
            int x = tab[0]; int y = tab[1];
            Robot newR = new RobotCavalier(x, y);
            
            listRobots.add(newR);
        }
    }
    **/
    public void addRobotLineaire(){
        Random randomGenerator = new Random();
        int dir = randomGenerator.nextInt(4);
        int[] tab = genererCoors();
        if (tab[0] != -1){
            int x = tab[0]; int y = tab[1];
            Robot newR = new RobotLinér(dir, x, y);
            
            listRobots.add(newR);
        }
    }
    
    public void tour(){
        // pour chaque robot, move()
        for (Robot r : listRobots) {
            r.move();
        }
    }
}