package desktop.p4;


/**
 * Created by stran on 09.05.2016.
 */

interface Instrument {
    void play(Note n);

    void tune();
}

class Guitar implements Instrument {
    public void play(Note n) {
        System.out.println(this + " is wonderfully playing note:  " + n);
    }

    public String toString() {
        return "Guitar";
    }

    public void tune() {
        System.out.println(this + " is perfectly tuned now.");
    }
}

class Wind implements Instrument {
    public void play(Note n) {
        System.out.println(this + " is wonderfully playing note:  " + n);
    }

    public String toString() {
        return "Wind";
    }

    public void tune() {
        System.out.println(this + " is perfectly tuned now.");
    }
}

class Percussion implements Instrument {
    public void play(Note n) {
        System.out.println(this + " is wonderfully playing note:  " + n);
    }

    public String toString() {
        return "Percussion";
    }

    public void tune() {
        System.out.println(this + " is perfectly tuned now.");
    }
}

class Stringed implements Instrument {
    public void play(Note n) {
        System.out.println(this + "is wonderfully playing note:  " + n);
    }

    public String toString() {
        return "Stringed";
    }

    public void tune() {
        System.out.println(this + " is perfectly tuned now.");
    }
}

class Brass extends Wind {
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    public String toString() {
        return "Woodwind";
    }
}

public class Music {
    static void playMelody(Instrument[] o) {
        System.out.println("Enjoy music...");
        for (Instrument i : o) {
            i.play(Note.DO);
            i.play(Note.RE);
            i.play(Note.MI);
        }
    }

    static void tuneAll(Instrument[] o) {
        System.out.println("Please wait while instruments are tuning...");
        for (Instrument i : o) {
            i.tune();
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Guitar(),
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        System.out.println("Welcome to the orchestra concert!");
        tuneAll(orchestra);
        playMelody(orchestra);
        System.out.println("See you next time!");
    }
}