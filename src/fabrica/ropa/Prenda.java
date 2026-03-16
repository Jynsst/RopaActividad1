package fabrica.ropa;

import java.util.ArrayList;

public class Prenda {

    private String modelo;
    private String tela;
    private String genero;
    private  float costoDeProduccion;
    private String temporada;
    private List<Lote> lotes;

    public Prenda(String modelo,String tela,String genero,float costoDeProduccion, String temporada){
        this.modelo=modelo;
        this.tela=tela;
        this.genero=genero;
        this.costoDeProduccion=costoDeProduccion;
        this.temporada=temporada;
        this.lotes=new ArrayList<Lote>();
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
        return genero;
    }

    public float getCostoDeProduccion() {
        return costoDeProduccion;
    }

    public void setCostoDeProduccion(float costoDeProduccion) {
        this.costoDeProduccion = costoDeProduccion;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public void addLote(Lote lote) {
        this.lotes.add(lote);
    }

    public void deleteLote(String noDeLote) {
        for(Lote lote1:this.lotes){
            if(lote1.getNoDeLote().equals(noDeLote)){
                this.lotes.remove(lote1);
                break;
            }
        }
    }

    public float montoDeRecuperacionPorLote(String noDeLote){
        float montoDeRecuperacionP=0.0f;
        for(Lote lote1:this.lotes){
            if(lote1.getNoDeLote().equals(noDeLote)){
               montoDeRecuperacionP=this.costoDeProduccion*lote1.getNumeroDePrendas()*0.05f;
                break;
            }
        }
        return costoDePrenda;
    }

    public float montoDeRecuperacionPorPrenda(){
        float montoDeRecuperacionPorLote=this.costoDeProduccion*0.15f;
        return montoDeRecuperacionPorLote;

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

}