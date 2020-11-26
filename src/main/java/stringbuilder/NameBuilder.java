package stringbuilder;

public class NameBuilder {

    private final StringBuilder sb = new StringBuilder();


    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {

        if (title == null) {
            sb.append(givenName);
        } else {
            sb.append(title.getName() + " " + givenName);
        }

        if (!isEmpty(middleName)) {
            sb.append(" " + middleName);
        }

        if (!isEmpty(familyName)) {
            sb.append(" " + familyName);
        }


        return sb.toString();
    }


    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {

        if (title == null) {
            sb.append(givenName);
        } else {
            sb.append(title.getName() + " " + familyName);
        }

        if (!isEmpty(middleName)) {
            sb.append(" " + givenName);
        }

        if (!isEmpty(familyName)) {
            sb.append(" " + middleName);
        }


        return sb.toString();
    }



    public String insertTitle(String name, Title title, String where) {



        return "";
    }


    public String deleteNamePart(String name, String delete) {



        return "";
    }


    public boolean isEmpty(String text) {
        return (text == null || text.isBlank());
    }




    public static void main(String[] args) {
        System.out.println(new NameBuilder().concatNameWesternStyle("Smith", "G", "John", Title.MR));
    }

}
