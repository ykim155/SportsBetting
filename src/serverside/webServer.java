package src.serverside;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class webServer {

    public static void main(String[] args){

        try{
            try (ServerSocket ss = new ServerSocket(1234, 1, InetAddress.getByName("127.0.0.1"))) {
                Socket s=ss.accept();//establishes connection
                var rawIn = s.getInputStream();
                var in = new BufferedReader(new InputStreamReader(rawIn, StandardCharsets.US_ASCII)); {

      while (true){
                String cmd = in.readLine().trim();
                if (cmd == null) break; //client is hung up
                if (cmd.isEmpty()) continue; //empty line was sent
                System.out.println("client sent: " + cmd);
      }
                }
            }

        }catch(Exception e){System.out.println(e);}

    }
}
