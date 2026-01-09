package imp_concepts.featuresOfJava8.lambdaEx;
import imp_concepts.featuresOfJava8.functionalInterface.Add;

public class LambdaExamples{
    public static void main(String[] args) {
        int a=1;
        int b=2;
        //Add Function using Lambda Expression and Functional Interface
        Add add = (x, y) -> System.out.print(x+y);
        add.sum(a, b);
        new Thread(() -> System.out.print("1")).start();
    }
}
