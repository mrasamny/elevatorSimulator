import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private boolean isOn;
    private GreenfootImage buttonOn;
    private GreenfootImage buttonOff;
    
    public Button(String imageOnFile, String imageOffFile)
    {
        isOn = false;
        buttonOn = new GreenfootImage(imageOnFile);
        buttonOff = new GreenfootImage(imageOffFile);
    }
    
    /**
     * Act - do whatever the OpenButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!isOn && Greenfoot.mouseClicked(this))
        {
            turnOn();
        }
    }  
    
    public void turnOn()
    {
      isOn = true;
      setImage(buttonOn);
    }
    
    public void turnOff()
    {
        isOn = false;
        setImage(buttonOff);
    }   
}
