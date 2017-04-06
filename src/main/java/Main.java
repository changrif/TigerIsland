import java.io.IOException;

/**
 * Created by Nick Kroeger on 3/21/2017.
 */
public class Main {
    public static void main(String [] args){
        CheckIfCommandLineInputLengthIsValid(args);
        TournamentClient client;
        try {
            client = new TournamentClient(args);
            client.runClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CheckIfCommandLineInputLengthIsValid(String[] args) {
        if (args.length != 5) {
            System.err.println(
                    "Usage: java TournamentClient <host name> <port number> <Tournament Password> <Team username> <Team password>");
            System.exit(1);
        }
    }
}
