import java.net.DatagramPacket;
import java.net.DatagramSocket;

class ServidorUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(10_000);
            System.out.println("Servidor iniciado. Esperando mensajes...");

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength());
                String direccionCliente = paquete.getAddress().getHostAddress();

                System.out.println("Mensaje recibido de: " + direccionCliente + ":" + paquete.getPort() + ": " + mensaje);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
