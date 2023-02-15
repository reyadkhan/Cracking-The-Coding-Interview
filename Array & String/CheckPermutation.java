import java.util.Arrays;

class CheckPermutation {

    public static void main(String[] args) {
        final CheckPermutation checkPermutation = new CheckPermutation();
        final String str1 = "God";
        final String str2 = "dGo";
        final String str3 = "God";
        final String str4 = "dGO";
        final boolean result1 = checkPermutation.isPermutation(str1, str2);
        final boolean result2 = checkPermutation.isPermutation(str3, str4);
        final boolean resultU1 = checkPermutation.isPermutationU(str1, str2);
        final boolean resultU2 = checkPermutation.isPermutationU(str3, str4);
        System.out.println(str1 + " is" + (result1 ? " " : " not ") + "a permutation of " + str2);
        System.out.println(str3 + " is" + (result2 ? " " : " not ") + "a permutation of " + str4);
        System.out.println(str1 + " is" + (resultU1 ? " " : " not ") + "a permutation of " + str2);
        System.out.println(str3 + " is" + (resultU2 ? " " : " not ") + "a permutation of " + str4);
    }

    public boolean isPermutation(final String str1, final String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    private String sort(final String str) {
        final char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }

    public boolean isPermutationU(final String str1, final String str2) { //For ascii code implementation
        final int ln1 = str1.length();

        if (ln1 != str2.length()) {
            return false;
        }
        final int[] asciiArray = new int[128]; // 256 for extended ascii

        for(int i = 0; i < ln1; i++) {
            asciiArray[str1.charAt(i)] ++;
        }
        for(int i = 0; i < ln1; i++) {
            final int asciiCode = str2.charAt(i);
            asciiArray[asciiCode] --;

            if(asciiArray[asciiCode] < 0) {
                return false;
            }
        }
        return true;
    }
}