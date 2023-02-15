import java.util.HashSet;
import java.util.Set;

class UniqueCharacterString {
    public static void main(String[] args) {
        final UniqueCharacterString uString = new UniqueCharacterString();
        final String uniqueString = "abcd lksf";
        final String nonUniqueString = "Abcd bfk";
        System.out.println("Is unique: " + uString.isUnique(uniqueString));
        System.out.println("Is unique: " + uString.isUnique(nonUniqueString));
        System.out.println("Is unique(B): " + uString.isUnique(uniqueString));
        System.out.println("Is unique(B): " + uString.isUnique(nonUniqueString));
        System.out.println("Is unique(U): " + uString.isUnique(uniqueString));
        System.out.println("Is unique(U): " + uString.isUnique(nonUniqueString));
    }

    public boolean isUnique(final String text) { // Ascii character implementation
        final boolean[] asciiBoolArray = new boolean[128]; //256 for extended ascii
        final int length = text.length();

        for(int i = 0; i < length; i++) {
            final int asciiCode = text.charAt(i);

            if(asciiBoolArray[asciiCode]) {
                return false;
            }
            asciiBoolArray[asciiCode] = true;
        }
        return true;
    }

    public boolean isUniqueB(final String text) { // Bitwise implementation
        final int length = text.length();
        int check = 0;

        for(int i = 0; i < length; i++) {
            int asciiCode = text.charAt(i);

            if(asciiCode >= 'a' && asciiCode <= 'z') {
                asciiCode -= 'a';
            } else if(asciiCode >= 'A' && asciiCode <= 'Z') {
                asciiCode -= 'A';
            } else {
                continue;
            }

            if((check & (1 << asciiCode)) > 0) {
                return false;
            }
            check |= 1 << asciiCode;
        }
        return true;
    }

    public boolean isUniqueU(final String text) { //Unicode character implementation
        final Set<Character> charSet = new HashSet<>();
        final int length = text.length();

        for(int i = 0; i < length; i++) {
            final Character character = text.charAt(i);

            if(charSet.contains(character)) {
                return false;
            }
            charSet.add(character);
        }
        return true;
    }
}