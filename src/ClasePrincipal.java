public class ClasePrincipal {

    private final static int TOTALCORREDORES = 36;

    ClasePrincipal() {

        Carrera carrera = new Carrera();

        //En la carrera compiten un total de 36 corredores:
        for (int i = 0; i < TOTALCORREDORES; i++) {
            Corredor corredor = new Corredor(carrera);
            corredor.setName("Corredor " + (i + 1));
            corredor.start();
        }
    }
}
