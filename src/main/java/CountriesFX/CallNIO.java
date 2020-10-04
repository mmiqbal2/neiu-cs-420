package CountriesFX;


public class CallNIO {

    private static String data;

      public void CallNIO(){
        NIOreadFile NIO = new NIOreadFile();
        FilterCountries FC = new FilterCountries();
        NIO.ReadFile();
        FC.FileData();
        System.out.println(FC);
    }
}
