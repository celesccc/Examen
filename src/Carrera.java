import java.util.concurrent.Semaphore;

public class Carrera {

    private static final int MAXIMO = 9;
    private final Semaphore semaforo = new Semaphore(MAXIMO, true);
    private Corredor ganador;
    private int corredores = 0;

    // Método para añadir los corredores, pudiendo haber un máximo de 9, uno por país:
    public void addCorredor (Corredor corredor) {
        try {
            semaforo.acquire();
            System.out.println(corredor.getName() + " entra en la carrera.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Comienza la carrera:
    public void startCarrera (Corredor corredor) throws InterruptedException {
        System.out.println("¡Comienza la carrera para el " + corredor.getName()+ "!");

        Ambulancia ambulancia = new Ambulancia();

        int sleepingTime = (int) ((Math.random() * 5000) + 1000);
        Thread.sleep(sleepingTime);
        corredores++;

        // 90% de probabilidades de que el corredor supere el obstáculo:
        int obstaculo = (int) (Math.random()*11);
        if (obstaculo < 9) {
            // Hasta que un corredor no supere el obstáculo, no entrará otro en la carrera
            System.out.println("El " + corredor.getName() + " supera el obstáculo.");
            semaforo.release();
        } else {
            // Si no supera el obstáculo, tendrá que entrar en acción la ambulancia y atender al corredor (Clase Ambulancia):
            System.out.println("El " + corredor.getName() + " no supera el obstáculo.");
            ambulancia.start();
            ambulancia.atender(corredor);
        }
    }

    /*public void fin () {
        if (corredores == 36) {
            System.out.println("Fin de la Carrera");
        }
    }*/
}
