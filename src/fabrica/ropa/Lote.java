package fabrica.ropa;

import java.time.LocalDate;


public class Lote {

    private int noDeLote;
    private int numeroDePrendas;
    private LocalDate fechaDeFabricacion;
    static int contador;

    {
        contador++;
    }
    public Lote(LocalDate fechaDeFabricacion,int numeroDePrendas) {
        this.numeroDePrendas = numeroDePrendas;
        this.fechaDeFabricacion = fechaDeFabricacion;
        this.noDeLote=contador;
    }

    public int getNoDeLote() {
        return this.noDeLote;
    }


    public void setNumeroDePrendas(int numeroDePrendas){
        this.numeroDePrendas=numeroDePrendas;

    }
    public int getNumeroDePrendas() {
        return this.numeroDePrendas;
    }


    public LocalDate getFechaDeFabricacion() {
        return this.fechaDeFabricacion;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "numeroDeLote=" +this.noDeLote +
                ", numeroDePrendas=" + this.numeroDePrendas +
                ", fechaDeFabricacion=" + this.fechaDeFabricacion +
                '}';
    }
}


