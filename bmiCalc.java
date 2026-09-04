public class bmiCalc {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    public static void main(String[] args) {
        double[] heights = { 1.75, 1.60, 1.80 };
        double[] weights = { 70, 90, 50 };

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.println("Person " + (i + 1) + " → Height: " + heights[i] + " m, Weight: " + weights[i]
                    + " kg, BMI: " + bmi + ", Status: " + getBmiStatus(bmi));
        }
    }
}
