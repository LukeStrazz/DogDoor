package luke.strazzera.strazzeracsc211dogdoor;

public class Dog{
    public String name;
    public String bark;
    public String scratch;

    public Dog(String name, String bark, String scratch){
        this.name = name;
        this.bark = bark;
        this.scratch = scratch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }
    public String getScratch() {
        return scratch;
    }

    public void setScratch(String scratch) {
        this.scratch = scratch;
    }
}
