public class ISBNValidator {
    static String normalizeCode(String raw) {
        return raw.trim();
    }

    static void validateAndFormat(String code) {
        code = normalizeCode(code);
        if (code.length() != 13) {
            System.out.println("Invalid: wrong length");
            return;
        }

        String pubCode = code.substring(0, 3).toUpperCase();
        String body = code.substring(3);

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(pubCode.charAt(i))) {
                System.out.println("Invalid: publisher code must be 3 letters");
                return;
            }
        }
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                System.out.println("Invalid: body must be digits");
                return;
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);
        System.out.println("[" + pubCode + "] YEAR: " + year + " | CATALOG: " + catalog);
    }

    public static void main(String[] args) {
        validateAndFormat(" pen026004251 ");
        validateAndFormat("12N2026004251");
    }
}
