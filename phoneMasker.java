public class phoneMasker {
    static void maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !phone.matches("\\d+")) {
            System.out.println("Invalid phone number");
            return;
        }
        String masked = "XXXXXX-" + phone.substring(6);
        System.out.println(masked);
    }

    public static void main(String[] args) {
        maskPhoneNumber("9876543210");
        maskPhoneNumber("98765");
    }
}
