import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CloseButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloseButton extends Button
{
    private Controller controller;
    
    public CloseButton()
    {
       super("closeButtonPressed.png","closeButton.png");
    }
    
    public void addedToWorld(World world)
    {
        controller = (Controller)world;
    }
    
    public void turnOn()
    {
      super.turnOn();
      controller.close();
    }   
}
