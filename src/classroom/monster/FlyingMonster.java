package classroom.monster;

public class FlyingMonster extends Monster {

    protected float lengthj;
    protected static FlyingMonster monster;

    private FlyingMonster(String name, float lengthj) {
        super(name);
        this.lengthj = lengthj;

    }
    public static FlyingMonster getMonster() {
        return monster;
    }
    public static FlyingMonster initMonster(String name, float lengthj) {
        if (monster == null) {
            monster = new FlyingMonster(name, lengthj);
        }
        return monster;
    }

//	public FlyingMonster(String name, float lengthj){
//		super(name);
//		this.lengthj = lengthj;
//		super.name = "";
//
//	}

    @Override
    public void setName(String name) {

        this.name = name;
    }


}
