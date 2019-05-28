public class GenericsTest {

    public static void main(String[] args) {

//        System.out.println("=================");
//        System.out.println("IJSE");
//        System.out.println("=================");
//
//        System.out.println("=================");
//        System.out.println("NSBM");
//        System.out.println("=================");
//
//        System.out.println("=================");
//        System.out.println("SLIIT");
//        System.out.println("=================");

        System.out.println("Print Names");
        GenericsTest.<String>print("IJSE");
        GenericsTest.<String>print("NSBM");
        GenericsTest.<String>print("SLIIT");

        System.out.println("Print Integer Numbers");
        GenericsTest.<Integer>print(10);
        GenericsTest.<Integer>print(20);
        GenericsTest.<Integer>print(30);

        System.out.println("Print Floating Point Numbers");
        GenericsTest.<Double>print(10.25);
        GenericsTest.<Double>print(11.25);
        GenericsTest.<Double>print(12.25);

    }

    public static <T> void print(T institute){
        System.out.println("================");
        System.out.println(institute);
        System.out.println("================");
    }

}
