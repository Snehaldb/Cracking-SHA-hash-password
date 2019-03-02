package CS265_1;

public class Main {
    private static final String HASH_CODE = "67AE1A64661AC8B4494666F58C4822408DD0A3E4";

    public static Sha1Analyzer sha1Analyzer;
    
    public static void main(String[] args) {
        sha1Analyzer = new Sha1Analyzer();
        PermutationUtil.permutation(new PermutationCreated());
    }

    public static class PermutationCreated implements PermutationUtil.onPermutationCreated {
        @Override
        public boolean onPermutationCreated(String permutedString) {
            if (HASH_CODE.equals(sha1Analyzer.sha1Encrypt(permutedString))) {
                System.out.println("The match is found and the password is:" + permutedString);
                return true;
            }
            return false;
        }
    }
}