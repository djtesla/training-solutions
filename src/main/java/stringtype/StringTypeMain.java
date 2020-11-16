package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {

       /* String s1 ="";
        String s2 ="Hello World";
        String s3 = "Hello" + " World";
        System.out.println(s2.equals(s3));

        System.out.println(s3.indexOf("World"));
        System.out.println(s3.indexOf("xxx"));
        System.out.println(s3.length());
        System.out.println(s3.substring(0,3));

        System.out.println(s3);
        */
    String prefix = "Hello";
    String name = "John Doe";
    String message = prefix + name;
        System.out.println(message);
    message = message + 444;
        System.out.println(message);

        boolean b = message.equals("Hello John Doe444");
        System.out.println(b);
        String con  = "" + "";
        System.out.println(con.length());

        System.out.println("Abcde".length());
        System.out.println("Abcde".substring(0,1) + "," + "Abcde".substring(2,3));
        System.out.println("Abcde".substring(0,3));
    }
}
