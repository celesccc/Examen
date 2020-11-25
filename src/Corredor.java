
public class Corredor extends Thread {

    Carrera carrera;
    boolean atendido = false;

    public Corredor(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public void run() {
        try {
            carrera.addCorredor(this);
            carrera.startCarrera(this);
            //carrera.fin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serAtendido() {
        atendido = true;
    }
}
