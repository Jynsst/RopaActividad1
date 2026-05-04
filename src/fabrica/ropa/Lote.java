package fabrica.ropa;

import Excepciones.ExcepcionRangoInvalido;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;


public class Lote implements Comparable<Lote>{

  
    private int noDeLote;
    private int numeroDePrendas;
    private LocalDate fechaDeFabricacion;
    static int contador;
    static final int LIMITEIP=50;
    static final int LIMITESP=350;
    public Comparator<Lote> comparator;

    {
        contador++;
    }
    public Lote(LocalDate fechaDeFabricacion,int numeroDePrendas) {
        if(LIMITEIP<=numeroDePrendas||numeroDePrendas<=LIMITESP) {
            this.numeroDePrendas = numeroDePrendas;
            this.fechaDeFabricacion = fechaDeFabricacion;
            this.noDeLote = contador;
            comparator = new Comparator<Lote>() {
                @Override
                public int compare(Lote o1, Lote o2) {
                    return o1.compareTo(o2);
                }
            };
        }else{
           throw new ExcepcionRangoInvalido("Numero de prendas fuera del rango!!");
        }
    }

    public int getNoDeLote() {
        return this.noDeLote;
    }


    public void setNumeroDePrendas(int numeroDePrendas){
        if(numeroDePrendas>=LIMITEIP||numeroDePrendas<=LIMITESP) {
            this.numeroDePrendas = numeroDePrendas;
        }else {
            throw new ExcepcionRangoInvalido("numero de prendas fuera del rango!!");
        }

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


    public boolean equals(Lote o) {
        if (!(o instanceof Lote )) return false;
        return numeroDePrendas == o.numeroDePrendas && Objects.equals(fechaDeFabricacion, o.fechaDeFabricacion);
    }

    @Override
    public int hashCode() {
       int result=numeroDePrendas;
       result=result*31+fechaDeFabricacion.hashCode();
       return result;
    }

    @Override
    public int compareTo(Lote lote) {
        int r=0;
        if((r=Integer.compare(this.numeroDePrendas, lote.numeroDePrendas))!=0) {
            return r;
        }
        if((r = (this.fechaDeFabricacion.compareTo(lote.fechaDeFabricacion)))!= 0){
        return r;
        }
        return 0;
    }
}


