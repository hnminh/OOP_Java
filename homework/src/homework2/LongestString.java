package homework2;

public class LongestString {
    public static int longestStringLength(String[] strings) {
        if (strings == null) return -1;
        else if (strings.length == 0) return -1;
        else {
            int maxLength = -1;
            for (int i = 0; i < strings.length; i++)
                if (strings[i] != null)
                    if (strings[i].length() > maxLength) maxLength = strings[i].length();
            
            return maxLength;
        }
    }
}