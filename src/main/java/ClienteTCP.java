import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClienteTCP {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 10_000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String mensaje = userInput.readLine();
                out.println(mensaje);

                String respuesta = in.readLine();
                System.out.println("Servidor responde: " + respuesta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
