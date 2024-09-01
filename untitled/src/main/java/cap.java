import org.apache.commons.lang3.StringUtils;

public class cap {
    public static void main(String[] args) {
        String name = "SHIPPER TEST<BR/>BY QUALITY TEAM FMC";
        String a = toCamelCase("<BR/>", name);
        System.out.println(a);
//        final StringBuilder ret = new StringBuilder(name.length());
//        String[] split = name.split("<BR/>");
//        boolean first = true;
//        for (String s : split) {
//            ret.append(toCamelCase(s));
//
//            if (!(ret.length() == name.length())&& first) {
//                ret.append("<BR/>");
//                first = false;
//
//            }
//
//        }
//        System.out.println(ret);

    }

    public static String toCamelCase(String splitConjus, final String init) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());
        for (final String value : init.split(splitConjus)) {
            for (final String word : value.split(" ")) {
                if (!word.isEmpty()) {
                    ret.append(word.substring(0, 1).toUpperCase());
                    ret.append(word.substring(1).toLowerCase());
                }
//                if (!(ret.length() == value.length()))
                    ret.append(" ");
            }
            if (!(ret.length() == init.length()))
                ret.append(splitConjus);
        }
        if (ret.length() > 0) {
            ret.delete(ret.length() - splitConjus.length(), ret.length());
        }
        return ret.toString();
    }

    static String toCamelCase(String s){
        String[] parts = s.split(" ");
        String camelCaseString = "";
        for (String part : parts){
            if(part!=null && part.trim().length()>0)
                camelCaseString = camelCaseString + toProperCase(part);
            else
                camelCaseString=camelCaseString+part+" ";
        }
        return camelCaseString;
    }

    static String toProperCase(String s) {
        String temp=s.trim();
        String spaces="";
        if(temp.length()!=s.length())
        {
            int startCharIndex=s.charAt(temp.indexOf(0));
            spaces=s.substring(0,startCharIndex);
        }
        temp=temp.substring(0, 1).toUpperCase() +
                spaces+temp.substring(1).toLowerCase()+" ";
        return temp;

    }
}
