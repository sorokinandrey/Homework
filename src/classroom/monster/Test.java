package classroom.monster;

public class Test {

    public static void main(String[] args) {

        Monster m = new Monster("Jan");
        //Monster m1 = new Monster();
        FlyingMonster fm = FlyingMonster.initMonster("Drago", 3);
        //fm.setName("sd");
        //fm.setName("drname");
        //m.setName("dddd");
        //m.setName("");
        //System.out.print(m.name+"; "+fm.name);
        System.out.println(Monster.getMonsterTypes()[0]);
        System.out.println(fm);
    }

}
