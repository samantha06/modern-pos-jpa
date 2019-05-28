public class TestVarArgs {

    public static void main(String[] args) {
        print(1,2,3);
    }

    public static void print(Object... params){
        for (Object param : params) {
            System.out.println(param);
        }
    }

}
