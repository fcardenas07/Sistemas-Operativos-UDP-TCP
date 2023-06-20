import java.net.*;
import java.io.*;

public class ClienteUDP {
    public static void main(String[] argv) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");

            while (true) {
                String mensaje = in.readLine();
                byte[] mensaje_bytes = mensaje.getBytes();
                DatagramPacket paquete = new DatagramPacket(mensaje_bytes, mensaje.length(), address, 10_000);
                socket.send(paquete);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
