public class Demo {

    public static void main(String[] args) {

//        MyInterface i = Demo.A::new;

//        int a = 10;
        MyInterface i = (s) ->{
//            a=20;
            new A(s);
        };

//        int a = 10;
//        a = 20;

//        MyInterface i = new MyInterface() {
//            @Override
//            public void print(String something) {
//
//                new A(something + a);
//            }
//        };

        i.print("IJSE");

    }

    static class A {
        public A(String something) {
            System.out.println(something);
        }
    }

}
