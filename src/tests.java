import java.util.Scanner;
class tests{
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Enter first vector");
        Vector3 firstVector = getInput();
        Vector3 secondVector,resultant;
        System.out.println("You entered "+firstVector.toString());
        int ch=0;
        while(ch!=7){
            System.out.println("What would you like to do ?\n" +
                    "1.Addition\n" +
                    "2.Subtraction\n" +
                    "3.Dot Product\n" +
                    "4.Cross Product\n" +
                    "5.Get Magnitude\n" +
                    "6.Get unit vector\n" +
                    "7. Multiply by a scalar\n"+
                    "7.Exit");
            ch=s.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Enter second vector:");
                     secondVector = getInput();
                     resultant = firstVector.add(secondVector);
                    System.out.println("Resultant"+resultant.toString());
                    break;
                case 2:
                    System.out.println("Enter second vector:");
                     secondVector = getInput();
                     resultant = firstVector.subtract(secondVector);
                    System.out.println("Resultant"+resultant.toString());
                    break;
                case 3:
                    System.out.println("Enter second vector:");
                    secondVector = getInput();
                    resultant = firstVector.dot(secondVector);
                    System.out.println("Resultant"+resultant.toString());
                    break;
                case 4:
                    System.out.println("Enter second vector:");
                    secondVector = getInput();
                    resultant = firstVector.cross(secondVector);
                    System.out.println("Resultant"+resultant.toString());
                    break;
                case 5:
                    System.out.println("Magnitude of the vector is:"+firstVector.getMagnitude());
                    break;
                case 6:
                    System.out.println("Unit vetor along "+firstVector.toString()+" is "+firstVector.unitVector().toString());
                    break;
            }
        }
    }
    private static Vector3 getInput(){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter your vector:");
        float x,y,z;
        x=s.nextFloat();
        y=s.nextFloat();
        z=s.nextFloat();
        Vector3 temp= new Vector3(x,y,z);
        return temp;
    }
}
