import com.sun.deploy.association.AssociationException;
import org.testng.annotations.Test;

public class FirstClass {
    @Test
    public void test00001() {
        System.out.print("I can do it");
    }

    @Test
    public void test00002() {
        int myNumber = 5;
        System.out.print(myNumber);
    }

    @Test
    public void test00003() {
        String messageOne = new String("Who let the dogs out!!!");
        String messageTwo = "Who Who Who!";
        String s3 = messageOne + messageTwo;
        System.out.println(s3);
    }

    @Test
    public void test00004() {
        int num = 6;
        String message = "I have only " + num + " hours of sleep left!";
        System.out.println(message);
    }

    @Test
    public void test00005() {
        boolean toBe = false;
        boolean b = toBe || !toBe;
        if (b) {
            System.out.println(toBe);
        }

    }

    @Test
    public void test0006() {
        int a = 6;
        if (a == 4) {
            System.out.println("It is actually " + a);
        } else {
            System.out.println("IT IS NOT equal to 4 it is " + a);
        }
    }

    @Test
    public void test0007() {
        int[] numbers = {1, 2, 21};
        int length = numbers[2];
        char[] chars = new char[length];
        chars[numbers.length + 4] = 'y';
        System.out.println("Done!");
    }

    @Test
    public void test0008() {
        int[] arrayOfIntegers = {1, 4, 9, 9};
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            System.out.println(arrayOfIntegers[i]);

        }
    }

    @Test
    public void test0009() {
        int [] numbers = { 951, 402, 984, 651, 360, 69, 408, 319, 601, 485, 980, 507, 725, 547, 544,
                615, 83, 165, 141, 501, 263, 617, 865, 575, 219, 390, 984, 592, 236, 105, 942, 941,
                386, 462, 47, 418, 907, 344, 236, 375, 823, 566, 597, 978, 328, 615, 953, 345,
                399, 162, 758, 219, 918, 237, 412, 566, 826, 248, 866, 950, 626, 949, 687, 217,
                815, 67, 104, 58, 512, 24, 892, 894, 767, 553, 81, 379, 843, 831, 445, 742, 717,
                958, 609, 842, 451, 688, 753, 854, 685, 93, 857, 440, 380, 126, 721, 328, 753, 470,
                743, 527

        };
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 237){
                break;
            }
            if (numbers[i] % 2 == 0) {

                System.out.println(numbers[i]);
            }

        }
    }

    @Test
    public void test0010() {
        class Student {
            private String firstName;
            private String lastName;

            Student(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public void printFullName() {
                System.out.println(this.firstName + " " + this.lastName);
            }
        }

        Student[] students = new Student[]{
                new Student("Morgan", "Freeman"),
                new Student("Brad", "Pitt"),
                new Student("Kevin", "Spacey"),
        };
        for (Student s : students) {
            s.printFullName();
        }
    }

    @Test
    public void test0011() {
        class Point {
            private double clasX;
            private double clasY;

            Point(double x, double y) {
                this.clasX = x;
                this.clasY = y;
            }

            public void print() {
                System.out.println("(" + clasX + "," + clasY + ")");
            }

            public void scale(){
                clasX = clasX/2;
                clasY = clasY/2;
            }
        }
                Point pointObject = new Point(64, 64);
                Point pointObject2 = new Point(32,32);
                for (int i = 0; i < 5; i++) {
                    pointObject.scale();
                    pointObject.print();
                }
                System.out.println("*****New Object*****");
                for(int b = 0; b<5; b++){
                    pointObject2.scale();
                    pointObject2.print();
                }



    }
    // ******Class 3********


    @Test
    public void testPrintEvenNUmbers() {
        for(int i = 1; i <= 10; i++) {
            if(i % 2 == 0) {
                System.out.println(i);
            }
            else{
                System.out.println(i + " this number is not even! ");
            }
        }
    }

    @Test
    public void testPrintHelloWorld() {
        for(int i = 1; i <= 10; i++) {
            if(i % 2 == 0) {
                System.out.println("Hello World!");
            }

        }
    }

    @Test
    public void testprintOutArray() {
        int[] input = {1, 4, 9, 9};
        printingAllMemebersofArray(input);
    }

    public void printingAllMemebersofArray(int[] arrayParameters){
            for (int i = 0; i <arrayParameters.length; i++) {
                System.out.println(arrayParameters[i]);

            }
        }
        // Swap two numbers in an array
        //1. create input array
        //2. create method that will accept input array
        //3. new method will take indexes of L and R elements
        //4. method will swap L and R elements respectively with each other
        //5. Print out final array with new swapped numbers


    @Test
    public void testSwapNumbers() {
            int[] inputArray = {1,2,3,4,5,6};
            int indexL = 0;
            int indexR =1;

            swap(inputArray, indexL,indexR);
            printingAllMemebersofArray(inputArray);


    }

    private void swap(int[] inputArray, int indexL, int indexR) {
            int temp = inputArray[indexR];
            inputArray[indexR] = inputArray[indexL];
            }

    @Test
    public void testSwapException() {
        int[] inputArray = {1,2,3,4,5,6};
        int indexL = 1;
        int indexR =5;
        checkInputes(inputArray,indexL,indexR);
        swap(inputArray, indexL,indexR);
        printingAllMemebersofArray(inputArray);
    }
    //TODO: add checks for input array and other cases that can break the code
    private void checkInputes(int[] inputArray, int indexL, int indexR) {
        if(indexL >= 0 && indexL < inputArray.length && indexR >= 0 && indexR < inputArray.length){
            System.out.println("Correct input");
        } else {
            throw new AssertionError("Please enter correct number for the array element");
        }

    }
    //Count letter l in this sentance
    //1. Create a string "Hello World"
    //2. create an array that will have all letters of the string
    //3. create method that will count letter l
    //4.print out the final result of how many letters l in the string
    //TODO break it down into sub-steps (external method), 'letter' should be a parameter as well
    @Test
    public void testCountLetters() {
        String letters = "HelloL5 World";
        counter(letters);
    }

    private void counter(String sentence) {
        int result = 0;
        for(char eachLetter : sentence.toCharArray()) {
            if(eachLetter== 'l'){
                System.out.println(eachLetter);
                result ++;
            }
        }
    }
}







