import java.util.Random;

public class Ambulancia extends Thread{

    AtencionAmbulancia atencion = new AtencionAmbulancia();

    @Override
    public void run() {
        esperarCorredor();
    }

    public void esperarCorredor() {
       atencion.finAmbulancia();
    }

    public void atender (Corredor corredor) {
        Random r = new Random();
        boolean ocupada = r.nextBoolean();

        // Si la ambulancia está ocupada no podrá atender al corredor, y ese corredor no continuará en la carrera:
        if (ocupada){
            System.out.println("La ambulancia está ocupada... El " + corredor.getName() + " no continúa en la carrera :(");
        } else {
            // Si la ambulancia no está ocupada, atenderá a ese corredor (Clase AtencionAmbulancia):
            System.out.println("La ambulancia va a atender al " + corredor.getName());
            atencion.atenderCorredor(corredor);
        }
    }
}
