package slim3.util;

public class Util {

    public static boolean isEmpty(String msg) {
        if(msg == null) {
            return true;
        }

        if(msg.length() == 0) {
            return true;
        }

        return false;
    }

    public static boolean isNotEmpty(String msg) {
        if(msg == null) {
            return false;
        }

        if(msg.length() == 0) {
            return false;
        }

        return true;
    }
}
