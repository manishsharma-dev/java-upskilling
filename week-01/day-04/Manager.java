public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double salary, int teamSize){
        super(name, salary);
        this.teamSize = teamSize;
    }

    public void conductMeeting(){
        System.out.println("Meeting conducted with team of size " + teamSize);
    }

    @Override
    public void work(){
        System.out.println("The team is managed by: " + getName());
    }
}
