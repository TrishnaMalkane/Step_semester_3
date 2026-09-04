public class BankRef {
    static String normalizeReference(String raw) {
        return raw.trim();
    }

    static void validateAndFormat(String reference) {
        reference = normalizeReference(reference);
        if (reference.length() != 14) {
            System.out.println("Invalid: wrong length");
            return;
        }

        String bankCode = reference.substring(0, 3).toUpperCase();
        String body = reference.substring(3);

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                System.out.println("Invalid: bank code must be 3 letters");
                return;
            }
        }
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                System.out.println("Invalid: body must be digits");
                return;
            }
        }

        String date = body.substring(0, 6);
        String seq = body.substring(6);
        String formatted = "[" + bankCode + "] DATE: " + date.substring(0, 2) + "/" + date.substring(2, 4) + "/"
                + date.substring(4) +
                " | SEQ: " + seq;
        System.out.println(formatted);
    }

    public static void main(String[] args) {
        validateAndFormat("hdf0302260042");
        validateAndFormat("12F0302260042");
    }
}
