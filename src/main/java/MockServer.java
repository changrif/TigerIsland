import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ddmac on 4/7/2017.
 */
public class MockServer {
    private int incrementer;

    public MockServer(){
        incrementer = 0;
    }

    public String readFromFile() throws IOException {
        String lineInTextFile = "";
        File file = new File("C:\\Users\\ddmac\\Documents\\TigerIslandExampleServerMessages3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int loops = 0;
        while((st=br.readLine()) != null) {
            if(incrementer == loops) {
                lineInTextFile = st;
                incrementer += 1;
                break;
            }
            loops++;
        }
        //System.out.println(incrementer);
        return lineInTextFile;
    }
    public static void main(String [] args){
        try {
            TournamentClient t = new TournamentClient(args);
            t.runClient();
        }catch(IOException e){

        }
    }
}
