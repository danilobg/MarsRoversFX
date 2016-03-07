package zup.marsroverfx;

/**
 *
 * @author danilo
 */
public class MarsRover {

    public static final String North = "N";
    public static final String East  = "E";
    public static final String South = "S";
    public static final String West  = "W";
    
    public static final Character Left  = 'L';
    public static final Character Right = 'R';
    public static final Character Move  = 'M';
    
    Integer posX = 0;
    Integer posY = 0;
    
    Integer gridX = 0;
    Integer gridY = 0;
    
    String face = North;
    
    public MarsRover() {
    }
    
    public void setGridSize(String position) throws Exception {
    
        try{
            String[] parts = position.split(" ");
            
            if (parts.length > 2 ) throw new IllegalArgumentException("Invalid Grid Size");
            
            this.gridX = Integer.parseInt(parts[0]);
            this.gridY = Integer.parseInt(parts[1]);
        }catch(Exception ex){
            throw new IllegalArgumentException("Invalid Grid Size");
        }
    
    }    
    
    public void setPosition(String position) {
        
        try{
            String[] parts = position.split(" ");
            if (parts[2].equals(North) || 
                parts[2].equals(East)  ||
                parts[2].equals(South) || 
                parts[2].equals(West)){
            
                this.posX = Integer.parseInt(parts[0]);
                this.posY = Integer.parseInt(parts[1]);
                this.face = parts[2];
            }else{
                throw new IllegalArgumentException();
            }
            
        }catch(Exception ex){
            throw new IllegalArgumentException("Invalid Position");
        }
        
    }
    
    public String printPosition() {
        return posX + " " + posY + " " + face;
    }
    
    public Boolean command(String command) {
        for (int i = 0 ; i < command.length() ; i++) {
            
            if (!action(command.charAt(i))){ 
                throw new IllegalArgumentException("Command " + (i+1) + " not Recognized");
            }
            
        }
        return true;
    }
    
    private Boolean action(Character command) {
        
        if (command.equals(Left)) {
            turnLeft();
        } else if (command.equals(Right)) {
            turnRight();
        } else if (command.equals(Move)) {
            moveForward();
        } else {
            return false;
        }
        return true;
        
    }
    
    private void moveForward() {
        
        if (face.equals(North)) {
            this.posY++;
        } else if (face.equals(East)) {
            this.posX++;
        } else if (face.equals(South)) {
            this.posY--;
        } else if (face.equals(West)) {
            this.posX--;
        }
        
        if (this.posX > this.gridX || 
            this.posY > this.gridY ||
            this.posX < 0 || 
            this.posY < 0 ){
            
            throw new IllegalArgumentException("Grid out of Range");
        }
        
    }
    
    private void turnLeft() {
        switch (face){
            case North:
                face = West;
                break;
            case West:
                face = South;
                break;
            case South:
                face = East;
                break;
            case East:
                face = North;
                break;
        }
    }
    
    private void turnRight() {
        switch (face){
            case North:
                face = East;
                break;
            case East:
                face = South;
                break;
            case South:
                face = West;
                break;
            case West:
                face = North;
                break;
        }

    }
   
}
    

