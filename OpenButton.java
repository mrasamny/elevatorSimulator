import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpenButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpenButton extends Button
{
    private Controller controller;
    
    public OpenButton()
    {
       super("openButtonPressed.png","openButton.png");
    }
    
    public void addedToWorld(World world)
    {
        controller = (Controller)world;
    }
    
    public void turnOn()
    {
      super.turnOn();
      controller.open();
    }
}
