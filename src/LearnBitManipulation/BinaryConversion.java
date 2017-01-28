package LearnBitManipulation;

/**
 * About the code :
 */
public class BinaryConversion {
    public static void main(String[] args) {
        int n = 254;
        int x = (int) (Math.log(n) / Math.log(2));
        StringBuilder bits = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                bits.append("1");
            }
            else {
                bits.append("0");
            }
        }

        System.out.println(bits.reverse());
    }
}
