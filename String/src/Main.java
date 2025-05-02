public class Main {
    // reverse string
    public static String reverse(String s){
        StringBuilder sb=new StringBuilder(s);
       /* int start=0,end=sb.length()-1;
        while(start<end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }*/
        return String.valueOf(sb.reverse());
        }
        //check palaindrom
    public static Boolean checkPalaindrom(String s){
        if (s.equals(reverse(s))) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // reverse string
        String str="this is javatpoint";
        System.out.println(reverse(str));

        //How to check Palindrome String in java?
        String str1="nitin";
        System.out.println(checkPalaindrom(str1));

        //Write a java program to capitalize each word in string?
        String str2="this is javatpoint";
        StringBuilder sb= new StringBuilder(str2);

        for(int i=0;i<=str2.length()-1;i++){


        }

    }
}