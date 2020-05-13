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
            public Student(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }
            public void printFullName() {
                System.out.println(firstName + " " + lastName);
            }
        }

        Student[] students = new Student[] {
                new Student("Morgan", "Freeman"),
                new Student("Brad", "Pitt"),
                new Student("Kevin", "Spacey"),
        };
        for (Student s : students) {
            s.printFullName();
        }

            }
}






