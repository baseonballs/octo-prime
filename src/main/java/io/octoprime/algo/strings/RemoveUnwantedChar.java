package io.octoprime.algo.strings;

public class RemoveUnwantedChar {

    public static String remove(String word, char unwanted)
    {
        StringBuilder sb = new StringBuilder();
        char[] letters = word.toCharArray();

        for ( char c : letters)
        {
            if ( c != unwanted) sb.append(c);
        }

        return sb.toString();
    }

    public static String removeRecur( String word, char ch )
    {
        int index = word.indexOf(ch);
        if (index == -1)
        {
            return word;
        }

        return removeRecur(word.substring(0, index) + word.substring(index +1, word.length()), ch);
    }

    public static void main(String[] args)
    {
        String s = "The cow jumped over the moon.";
        String r = remove( s, 'o');
        System.out.println(s + " : " + r);
    }
}
