public class AtencionAmbulancia {

    // Cuando la ambulancia está atendiendo a un corredor hará un wait, de esta forma
    // el resto de corredores tendrán que esperar a que la ambulancia termine su trabajo,
    // y cuando la ambulancia haya terminado tendrá que avisar al siguiente corredor para que continúe la carrera,
    // no sé si usar nofify o notifyAll, pero no lo consigo

    public synchronized void finAmbulancia() {
        notify();
    }

    public synchronized void atenderCorredor (Corredor corredor) {
        try {
            wait();
            System.out.println("La ambulancia está atendiendo al corredor " + corredor.getName() + "...");
            Thread.sleep(5000);
            corredor.serAtendido();
            System.out.println(corredor.getName() + " curado :) ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}