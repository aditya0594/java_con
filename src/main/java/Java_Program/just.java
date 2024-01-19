package Java_Program;

import java.io.IOException;

public class just {
    static Process serverProcess ;
    public static void startServer() throws IOException {
        String[] command = {"cmd.exe", "/c", "start", "cmd.exe", "/k", "appium -a 127.0.0.1 -p 4723 --base-path /wd/hub","--allow-cors"};
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        // Redirecting error and output streams
        processBuilder.redirectErrorStream(true);
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        serverProcess = processBuilder.start();
    }
    public static void stopAppium(Process process) {
        if (process != null) {
            process.destroy();
        }
    }

    public static void main(String[] args) throws IOException {
        startServer();
       // stopAppium(serverProcess);

    }
}
