package io.octoprime.algo.strings;

public class StringMathExample {

    public static void main(String args[])
    {
        String str="Hello i am john,id is 1 and my seat number is 88";
        System.out.println(str);
        // showing  numeric pattern matching
        System.out.println("===================");
        System.out.println("Number matching example");
        System.out.println("===================");

        boolean b=str.matches(".*[1-9].*");
        System.out.println("pattern: .*[1-9].* matches => "+b);

        b=str.matches(".*(100).*");
        System.out.println("pattern: .*(100).* matches => "+b);

        b=str.matches(".*(88).*");
        System.out.println("pattern: .*(88).* matches => "+b);

        //showing character matching
        System.out.println("===================");
        System.out.println("Character matching example");
        System.out.println("===================");

        b=str.matches(".*[A-Za-z].*");
        System.out.println("pattern: .*[A-Za-z].* matches => "+b);

        b=str.matches(".*[A].*");
        System.out.println("pattern: .*[A].* matches => "+b);

        b=str.matches(".*[i].*");
        System.out.println("pattern: .*[i].* matches => "+b);


        System.out.println("===================");
        System.out.println("Word and String matching example");
        System.out.println("===================");
        //showing word  and string matching
        b=str.matches(".*(john).*");
        System.out.println("pattern: .*(john).* matches => "+b);

        b=str.matches(".*(Hello i am john).*");
        System.out.println("pattern: .*(Hello i am john).* matches => "+b);

        b=str.matches(".*(JOHN).*");
        System.out.println("pattern: .*(JOHN).*matches => "+b);

        System.out.println();
        String str1="Hello i am John Adam";
        System.out.println(str1);
        b=str1.matches(".*(Adam).*");    //ignore after and before words
        System.out.println("pattern: .*(Adam).* matches => "+b);

        b=str.matches("John");     //just match for single word john
        System.out.println("pattern: John matches => "+b);

    }
}
