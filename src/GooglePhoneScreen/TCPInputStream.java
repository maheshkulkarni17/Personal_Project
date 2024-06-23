package GooglePhoneScreen;

public class TCPInputStream {
    public static StringBuffer buffer= new StringBuffer(" ");

    public static void onData(String data)
    {
        buffer.append(data);
    }

    public static String read(int length)
    {
        if(length==0)
            return "Length is zero";

        if(length>=buffer.length())
            length=buffer.length();

        String ans = buffer.substring(0,length);
        buffer.delete(0,length);

        return ans;

    }

    public static void main(String[] args) {
        onData("Mahesh Kulkarni");
        System.out.println(read(20));
        onData("Software Engineer at barclays");
        System.out.println(read(100));
    }
}
