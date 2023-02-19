class URLify {

    public static void main(String[] args) {
        final URLify urLify = new URLify();
        final String str1 = "Mr John Smith    ";
        System.out.println(urLify.getUrl(str1, 13));
        final String str2 = "Spaces should be removed      ";
        System.out.println(urLify.getUrlB(str2, 24));
    }

    public String getUrl(String str, int trueSize) {
        final char[] chars = str.toCharArray();
        replaceSpaces(chars, trueSize);
        return new String(chars);
    }

    public String getUrlB(String str, int trueSize) {
        final StringBuilder builder = new StringBuilder();

        for(int i = 0; i < trueSize; i++) {
            if(str.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    public void replaceSpaces(char[] chars, int truLength) {
        int spaceCount = 0;

        for(int i = 0; i < truLength; i++) {
            if(chars[i] == ' ') {
                spaceCount ++;
            }
        }
        int index = truLength + spaceCount * 2;

        if(truLength < chars.length) {
            chars[truLength] = '\0';
        }
        for(int i = truLength - 1; i >= 0; i--) {
            if(chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index -= 3;
            } else {
                chars[index - 1] = chars[i];
                index --;
            }
        }
    }
}