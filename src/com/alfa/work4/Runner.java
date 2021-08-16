package com.alfa.work4;

public class Runner {
    public void run () {
        equalsInt1();
        equalsInt2();
        System.out.println("********************");
        System.out.println(computer(34, 543.456f));
        System.out.println(computer(new Integer("34"), new Float("543.456")));
        System.out.println(computer(Integer.valueOf(34), Float.valueOf(543.456f)));
        System.out.println(computer(Integer.valueOf(34), 543.456f));
        System.out.println(computer(Integer.valueOf(34), new Float(543.456f)));
    }

    public void equalsInt1 () {
        Integer a = 127;
        Integer b = new Integer(127);
        Integer c = new Integer("127");
        Integer d = Integer.valueOf(127);
        Integer e = Integer.valueOf("127");

        System.out.println("-------------------");
        System.out.println("a=b " + (a == b));
        System.out.println("a=c " + (a == c));
        System.out.println("a=d " + (a == d));
        System.out.println("a=e " + (a == e));
        System.out.println();
        System.out.println("b=c " + (b == c));
        System.out.println("b=d " + (b == d));
        System.out.println("b=e " + (b == e));
        System.out.println();
        System.out.println("c=d " + (c == d));
        System.out.println("c=e " + (c == e));
        System.out.println();
        System.out.println("d=e " + (d == e));
        System.out.println("-------------------");
        System.out.println("a equals b " + (a.equals(b)));
        System.out.println("a equals c " + (a.equals(c)));
        System.out.println("a equals d " + (a.equals(d)));
        System.out.println("a equals e " + (a.equals(e)));
        System.out.println();
        System.out.println("b equals c " + (b.equals(c)));
        System.out.println("b equals d " + (b.equals(d)));
        System.out.println("b equals e " + (b.equals(e)));
        System.out.println();
        System.out.println("c equals d " + (c.equals(d)));
        System.out.println("c equals e " + (c.equals(e)));
        System.out.println();
        System.out.println("d equals e " + (d.equals(e)));
        System.out.println("-------------------");
    }

    public void equalsInt2 () {
        Integer a = 128;
        Integer b = new Integer(128);
        Integer c = new Integer("128");
        Integer d = Integer.valueOf(128);
        Integer e = Integer.valueOf("128");

        System.out.println("-------------------");
        System.out.println("a=b " + (a == b));
        System.out.println("a=c " + (a == c));
        System.out.println("a=d " + (a == d));
        System.out.println("a=e " + (a == e));
        System.out.println();
        System.out.println("b=c " + (b == c));
        System.out.println("b=d " + (b == d));
        System.out.println("b=e " + (b == e));
        System.out.println();
        System.out.println("c=d " + (c == d));
        System.out.println("c=e " + (c == e));
        System.out.println();
        System.out.println("d=e " + (d == e));
        System.out.println("-------------------");
        System.out.println("a equals b " + (a.equals(b)));
        System.out.println("a equals c " + (a.equals(c)));
        System.out.println("a equals d " + (a.equals(d)));
        System.out.println("a equals e " + (a.equals(e)));
        System.out.println();
        System.out.println("b equals c " + (b.equals(c)));
        System.out.println("b equals d " + (b.equals(d)));
        System.out.println("b equals e " + (b.equals(e)));
        System.out.println();
        System.out.println("c equals d " + (c.equals(d)));
        System.out.println("c equals e " + (c.equals(e)));
        System.out.println();
        System.out.println("d equals e " + (d.equals(e)));
        System.out.println("-------------------");
    }

    public Double computer (Integer integerA, Float floatB) {
        return integerA.doubleValue() + floatB.doubleValue();
    }
}
