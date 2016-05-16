package classroom.monster;

public class Monster {
    public static String TYPE_DRAGON = "dragon";
    public static String TYPE_GHOST = "ghost";
    public static String[] getMonsterTypes() {
        String[] types = new String[2];

        types[0] = TYPE_DRAGON;
        types[1] = TYPE_GHOST;

        return types;
    }
    protected String name;
    protected String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name == null) {
            this.name = name;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Monster() {

    }

    public Monster(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "This is Monster " + name;
    }


    @Override
    public boolean equals(Object obj) {
        return ((Monster) obj).getName().equals(name);
    }
}
