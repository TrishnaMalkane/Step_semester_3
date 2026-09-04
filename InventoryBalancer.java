public class InventoryBalancer {
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            sumA += sectionA[i];
            sumB += sectionB[i];
        }

        System.out.println("Section A Total: " + sumA + " | Section B Total: " + sumB);
        System.out.println("Status: " + (sumA == sumB ? "Balanced" : "Not Balanced"));

        int max = sectionA[0];
        String location = "Section A, Item 1";

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > max) {
                max = sectionA[i];
                location = "Section A, Item " + (i + 1);
            }
            if (sectionB[i] > max) {
                max = sectionB[i];
                location = "Section B, Item " + (i + 1);
            }
        }

        System.out.println("Highest Quantity: " + max + " (" + location + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = { 20, 15, 30 };
        int[] sectionB = { 25, 10, 30 };
        analyzeInventory(sectionA, sectionB);
    }
}
