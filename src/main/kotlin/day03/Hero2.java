package day03;

public class Hero2 {
    private String name;
    private int hp;

    public Hero2(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    //getter setter 단축키 뭐였더라 -> alt+insert
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


}
