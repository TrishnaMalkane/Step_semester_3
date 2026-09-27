import java.util.*;

abstract class Question {
    int points;

    Question(int points) {
        this.points = points;
    }

    abstract double evaluate();
}

class MCQ extends Question {

    String correctAnswer;
    String studentAnswer;

    MCQ(String correctAnswer, String studentAnswer, int points) {
        super(points);
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
    }

    double evaluate() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class TF extends Question {

    String correctAnswer;
    String studentAnswer;

    TF(String correctAnswer, String studentAnswer, int points) {
        super(points);
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
    }

    double evaluate() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class Essay extends Question {

    String keywords;
    String answer;

    Essay(String keywords, String answer, int points) {
        super(points);
        this.keywords = keywords;
        this.answer = answer.toLowerCase();
    }

    double evaluate() {

        String[] keys = keywords.toLowerCase().split(",");
        int count = 0;

        for (String k : keys) {
            if (answer.contains(k.trim())) {
                count++;
            }
        }

        if (count >= 2)
            return points * 0.5;

        if (count == 1)
            return points * 0.25;

        return 0;
    }
}

public class QuestionGrader {

    public static void main(String[] args) {

        Essay q1 = new Essay(
                "Inheritance, Polymorphism, Encapsulation",
                "Polymorphism is important",
                20);

        System.out.println("ESSAY: " + q1.evaluate());
    }
}