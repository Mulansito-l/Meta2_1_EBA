/**
 * Casa
 */
public class Casa {
    SensorLuminico sensorLuminico;
    Lampara lampara;
    DepositoComida depositoComida;
    AireAcondicionado ac;

    Casa(){
        depositoComida = new DepositoComida(1000);
        sensorLuminico = new SensorLuminico();
        ac = new AireAcondicionado(35);
        lampara = new Lampara();
    }

    void realizarMediciones(){
        sensorLuminico.verificarHoraDeEncender();
    }

    Integer getRemainingFood(){
        return depositoComida.getCurrentFood();
    }
}
