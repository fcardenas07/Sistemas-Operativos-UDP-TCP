import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServidorTCP {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10_000);
            System.out.println("Servidor iniciado. Esperando conexiones...");

            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {
                String mensaje = in.readLine();
                System.out.println("Cliente dice: " + mensaje);

                out.println("Servidor responde: " + new StringBuilder(mensaje).reverse().toString().toUpperCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

