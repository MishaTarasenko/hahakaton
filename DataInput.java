package lol1;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public final class DataInput {

    private static void writeText(String wr){
        if(wr == null)
            System.out.print("Введіть данні: ");
        else
            System.out.print(wr);
    }

    public static Long getLong(String description) throws IOException{
        writeText(description);
        String s = getString();
        Long value = Long.valueOf(s);
        return value;
    }

    public static char getChar(String description) throws IOException{
        writeText(description);
        String s = getString();
        return s.charAt(0);
    }

    public static Integer getInt(String description){
        int counter;
        String s = "";
        do{
            writeText(description);
            counter = 0;
            try {
                s = getString();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(s.charAt(0) == '-'){
                for(int i = 1; i < s.length(); i++)
                    if(s.charAt(i) < '0' || s.charAt(i) > '9')
                        counter++;
            }else{
                for(int i = 0; i < s.length(); i++)
                    if(s.charAt(i) < '0' || s.charAt(i) > '9')
                        counter++;
            }
        }while(counter != 0);
        Integer value = Integer.valueOf(s);
        return value;
    }

    public static String getStr(String description){
        String s = "";
        writeText(description);
        try {
            s = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }


    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

}

