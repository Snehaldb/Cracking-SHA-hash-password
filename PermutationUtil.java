package CS265_1;

public class PermutationUtil {

    public static boolean skip = false;
    public static void permutation(onPermutationCreated permutationCreated) {
        String str = "({=}@+*QWINqwin50";
        for (int i = 1; i <= str.length(); i++) {
            createPermutation(str, new StringBuilder(), i, permutationCreated);
            if (skip) {
                break;
            }
        }
    }

    private static String createPermutation(String str, StringBuilder newStr, int size, onPermutationCreated permutationCreated) {
        if (size == 0 || skip == true) {
            return newStr.toString();
        }

        String permutedString = "";
        for (int i = 0; i < str.length(); i++) {
            newStr.append(str.charAt(i));
            permutedString = createPermutation(str, newStr, size - 1, permutationCreated);
            if (!skip && permutationCreated.onPermutationCreated(permutedString)) {
                skip = true;
                return permutedString;
            }
            newStr.deleteCharAt(newStr.length() - 1);
        }
        return permutedString;
    }

    public interface onPermutationCreated {
        boolean onPermutationCreated(String permutedString);
    }

}