package fabrica.ropa;


import Excepciones.ExcepcionTipoDeDatoInvalido;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Prenda implements Comparable<Prenda> {

    private String modelo;
    private String tela;
    private Genero genero;
    private  float costoDeProduccion;
    private Temporada temporada;
    private List<Lote> lotes;
    public Comparator<Prenda> comparator;
    private final float LIMITE;

    public Prenda(String modelo,String tela,Genero genero,float costoDeProduccion, Temporada temporada,float limite){
      if(genero.name().equals("MASCULUNO")||genero.name().equals("FEMENINO")||genero.name().equals("MIXTO")) {

          if(temporada.name().equals("PRIMAVERA")||temporada.name().equals("VERANO")
                 ||temporada.name().equals("INVIERNO")||temporada.name().equals("OTOÑO")) {
            if(limite>=costoDeProduccion) {
                this.LIMITE=limite;
                this.modelo = modelo;
                this.tela = tela;
                this.genero = genero;
                this.costoDeProduccion = costoDeProduccion;
                this.temporada = temporada;
                this.lotes = new ArrayList<Lote>();
                comparator = new Comparator<Prenda>() {
                    @Override
                    public int compare(Prenda o1, Prenda o2) {
                        return o1.compareTo(o2);
                    }
                };
            }else{
                throw new IllegalArgumentException("Costo invalido superior al limite!!");
            }
         }else{
              throw new ExcepcionTipoDeDatoInvalido("Temporada no encontrada!!");
          }
      } else {
         throw  new ExcepcionTipoDeDatoInvalido("Genero introducido invalido!!");
      }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTela() {
        return tela;
    }
    

    public String getGenero() {
        return genero.name();
    }

    public float getCostoDeProduccion() {
        return costoDeProduccion;
    }

    public void setCostoDeProduccion(float costoDeProduccion) {
        if(LIMITE>=costoDeProduccion) {
            this.costoDeProduccion = costoDeProduccion;
        }else{
            throw new IllegalArgumentException("Costo Invalido superior al limite");
        }
    }

    public String getTemporada() {
        return temporada.name();
    }

    public void setTemporada(Temporada temporada) {
        if(temporada.name().equals("PRIMAVERA")||temporada.name().equals("VERANO")
                ||temporada.name().equals("INVIERNO")||temporada.name().equals("OTOÑO")) {
            this.temporada = temporada;
        }else{
            throw new ExcepcionTipoDeDatoInvalido("Temporada invalida!!");
        }
    }

    public void addLote(Lote lote) {
        this.lotes.add(lote);
    }

    public void deleteLote(int noDeLote) {
        for(Lote lote1:this.lotes){
            if(lote1.getNoDeLote()==noDeLote){
                this.lotes.remove(lote1);
                break;
            }
        }
    }

    public float montoDeRecuperacionPorLote(int noDeLote){
        float montoDeRecuperacionP=0.0f;
        for(Lote lote1:this.lotes){
            if(lote1.getNoDeLote()==(noDeLote)){
               montoDeRecuperacionP=this.costoDeProduccion*lote1.getNumeroDePrendas()*0.05f;
                break;
            }
        }
        return montoDeRecuperacionP;
    }

    public float montoDeRecuperacionPorPrenda(){
        float montoDeRecuperacionPorLote=this.costoDeProduccion*0.15f;
        return montoDeRecuperacionPorLote;

    }

    public List<Lote> getLotes() {
        return lotes;
    }


    public boolean equals(Prenda o) {
        if (!(o instanceof Prenda)) return false;
        return Float.compare(costoDeProduccion, o.costoDeProduccion)
                == 0 && Objects.equals(modelo, o.modelo) &&
                Objects.equals(tela, o.tela) &&
                Objects.equals(genero, o.genero) && Objects.equals(temporada, o.temporada);
    }

    @Override
    public int hashCode() {
       int result=Objects.hashCode(modelo);
       result=31*result + Objects.hashCode(tela);
       result=31*result + Objects.hashCode(genero);
       result=31*result + Float.hashCode(costoDeProduccion);
       result=31*result + Objects.hashCode(temporada);
       return result;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "modelo='" + modelo + '\'' +
                ", tela='" + tela + '\'' +
                ", Lotes='" + lotes+ '\'' +
                ", genero='" + genero + '\'' +
                ", costoDeProduccion=" + costoDeProduccion +
                ", temporada='" + temporada + '\'' +
                '}';
    }

    @Override
    public int compareTo(Prenda prenda) {
        int r=0;
        if((r=this.modelo.compareTo(prenda.modelo))!=0){
            return r;
        }
        if((r=this.tela.compareTo(prenda.tela))!=0){
            return r;
        }
        if((r=this.genero.compareTo(prenda.genero))!=0){
            return r;
        }
        if((r=Float.compare(this.costoDeProduccion, prenda.costoDeProduccion))!=0){
            return r;
        }
        return 0;
    }
}