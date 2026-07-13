import java.util.ArrayList;

interface MathOperation {
    public double compute(double a, double b);
}

class AdditionOperation implements MathOperation {
    public double compute(double a, double b) {
        return a + b;
    }
}

public class CalculatorApp {

    public static MathOperation add() {
        return new AdditionOperation();
    }

    public static MathOperation mod() {
        return new MathOperation() {
            public double compute(double a, double b) {
                return a % b;
            }
        };
    }

    public static MathOperation compare() {
        return (a, b) -> {
            if (a >= b + 2)
                return 1;
            else
                return 0;
        };
    }

    public static void main(String[] args) {
        ArrayList<MathOperation> ops = new ArrayList<>();
        ops.add( add() );
        ops.add( mod() );
        ops.add( compare() );

        System.out.println("Operands:  add  mod  cmp");
        for(int b = 1; b < 6; b++)
            for(int a = b; a < 6; a++) {
                System.out.print("     "+a+","+b+":");
                for(MathOperation op: ops)
                    if(op != null)
                        System.out.printf( "%5.1f", op.compute(a,b) );
                    else
                        System.out.print("    -");
                System.out.println();
            }
    }
}
