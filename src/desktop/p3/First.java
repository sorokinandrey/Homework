package desktop.p3;

public class First {

    public static int random(int n) {
        return (int) (Math.random() * n);
    }

    public static void main(String[] args) {

        //типы данных
        byte b = 127;
        System.out.println(b);

        short s = 32767;
        System.out.println(s);

        int i = 999999999;
        System.out.println(i);

        //для чисел типа long обязательно добавлять 'l'
        long l = 100l;
        System.out.println(l);

        //символьный тип данных
        char c2 = 'c';
        char c3 = 1200;
        System.out.println(c2);
        System.out.println(c3);

        //в шестнадцатиричной системе счисления
        char c = 0x0770;
        System.out.println(c);


        //вывод символов
        for (char c1 = 1200; c1 < 1300; c1++) {
            System.out.print(c1 + " ");
            if ((c1 % 10) == 0) {
                System.out.println("===");
            }
        }

        //приведение типов
        System.out.println((int) c);

        int h = 3, g = 2;
        System.out.println(h / g);
        System.out.println((float) h / g);

        float h1 = 30000000000000000.0f, g1 = 2;
        System.out.println(h1 / g1);
        System.out.println((int) (h1 / g1));

        System.out.println();
        float f = 100000000000000000000000000000000000000.0f;
        System.out.println(f);
        double googol = 1e100;
        double d = 1100.34;
        boolean bool = true;

        //escape-символы
        System.out.println(googol);
        System.out.print("Перенос строки" + "\n");

        //условный оператор switch
        int x = 1, y = 2, z, operation = 0;

        switch (operation) {
            case 0:
                z = x + y;
                break;
            case 1:
                z = x - y;
                break;
            case 2:
                z = x * y;
                break;
            default:
                z = x / y;
        }
        System.out.println("Результат выполнения операции: " + z);

        //цикл for
        long factorial = 1;
        for (l = 1l; l < 10; l++) {
            factorial *= l;
        }
        System.out.println(factorial);

        //массивы
        int[] m1;
        int[] m2 = new int[5];
        int[] m3 = {1, 2, 3};
        System.out.println(m3[0]);

        int[][] m4;
        int[][] m5 = {{1, 2}, {2}};
        System.out.println(m5[0][0]);

        String[] str = new String[4];
        String[] seasons = {"Зима", "Весна", "Лето", "Осень"};

        for (i = 0; i < seasons.length; i++) {
            System.out.println(seasons[i]);
        }

        double dd = Math.random();
        System.out.println(dd);

        int random = (int) (dd * 100);
        System.out.println(random);
    }
}
