import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elevator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elevator extends Actor
{
    private Controller controller;
    private GreenfootImage[] elevator;
    private ElevatorState currentState;
    private int currentImageIndex;
    private GreenfootSound doorDing;
    private GreenfootSound doorSound;
    
    public Elevator()
    {
       currentState = ElevatorState.CLOSED;
        currentImageIndex=0;
        elevator = new GreenfootImage[10];
        for(int i=0; i < elevator.length; i++)
        {
            elevator[i] = new GreenfootImage("elevator"+i+".png");
        }
        doorDing = new GreenfootSound("elevatorDing.wav");
        doorSound = new GreenfootSound("elevatorDoor.wav");
    }
    
    public void addedToWorld(World world)
    {
        controller = (Controller)world;
    }
    
    /**
     * Act - do whatever the Elevator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        switch (currentState)
        {
            case OPENING:
                currentImageIndex += 1;
                if (currentImageIndex == elevator.length-1)
                {
                    currentState = ElevatorState.OPENED;
                    controller.opened(); 
                    doorSound.stop();
                }
                setImage(elevator[currentImageIndex]);
            break;
            case CLOSING:
                currentImageIndex -= 1;
                if (currentImageIndex == 0)
                {
                    currentState = ElevatorState.CLOSED;
                    controller.closed();
                    doorSound.stop();
                }
                setImage(elevator[currentImageIndex]);
            break;
        }
    }
    
    public void open()
    {
        switch (currentState)
        {
            case CLOSED:
                currentState = ElevatorState.OPENING;
                doorDing.play();
                doorSound.play();
            break;
            case CLOSING:
                currentState = ElevatorState.OPENING;
                doorSound.stop();
                doorSound.play();
            break;
            case OPENED:
                controller.opened();
            break;
        }
    }
   
    public void close()
    {
        switch (currentState)
        {
            case OPENED:
                currentState = ElevatorState.CLOSING;
                doorSound.play();
            break;
            case OPENING:
                currentState = ElevatorState.CLOSING;
                doorSound.stop();
                doorSound.play();
            break;
            case CLOSED:
                controller.closed();
            break;
        }
    }
    
    public boolean isOpen()
    {
        return currentState == ElevatorState.OPENED;
    }
    
    public boolean isClosed()
    {
        return currentState == ElevatorState.CLOSED;
    }
}
