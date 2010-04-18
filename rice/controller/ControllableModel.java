package rice.controller;

public interface ControllableModel
{
    public void previousMode();
    public void nextSubmode();
    public void previousSubmode();
    public void nextInstance();
    public void previousInstance();
    public void nextAbility();
    public void previousAbility();
    public void processCommand(String command);

    public void createRallyPoint();
    public void tick( int tickNum );
    public void nextMode();

    public void nextTechnology();
    public void previousTechnolgy();
    public void nextTechnologyBranch();
    public void previousTechnologyBranch();
    
    public void previousUnit();
    public void nextUnit();
    public void previousStructure();
    public void nextStructure();
}
