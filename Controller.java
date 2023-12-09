import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller extends World
{
    private Elevator elevator;
    private OpenButton openButton;
    private CloseButton closeButton;
    /**
     * Constructor for objects of class Controller.
     * 
     */
    public Controller()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 650, 1); 
        prepare();
        Greenfoot.setSpeed(30);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        elevator = new Elevator();
        addObject(elevator, 241, 375);
        openButton = new OpenButton();
        addObject(openButton, 531, 437);
        closeButton = new CloseButton();
        addObject(closeButton, 529, 535);
    }
    
    public void open()
    {
        elevator.open();
        closeButton.turnOff();
    }
    
    public void close()
    {
        elevator.close();
        openButton.turnOff();
    }
    
    public void opened()
    {
        openButton.turnOff();
    }
    
    public void closed()
    {
        closeButton.turnOff();
    }
}
