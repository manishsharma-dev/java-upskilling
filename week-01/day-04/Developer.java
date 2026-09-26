public class Developer extends Employee {
    private String programmingLanguage;
    
    public Developer(String name, double salary, String programmingLanguage){
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public void writeCode(){
        System.out.println(getName() + " writes " + programmingLanguage);
    }

    @Override
    public void work(){
        System.out.println("The work is done by a developer named: " + getName());
    }
}
