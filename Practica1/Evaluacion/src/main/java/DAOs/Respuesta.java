// Generated by DB Solo 5.2.3 on 24/02/2019 at 01:32:57 PM
package DAOs;

public class Respuesta
{
  private int idrespuesta;
  private Integer opcionelegida;
  private int preguntaIdpregunta;
  private int resultadoexamenIdresultado;

    public Respuesta() {
    }

    public Respuesta(Integer opcionelegida, int preguntaIdpregunta, int resultadoexamenIdresultado) {
        
        this.opcionelegida = opcionelegida;
        this.preguntaIdpregunta = preguntaIdpregunta;
        this.resultadoexamenIdresultado = resultadoexamenIdresultado;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "idrespuesta=" + idrespuesta + ", opcionelegida=" + opcionelegida + ", preguntaIdpregunta=" + preguntaIdpregunta + ", resultadoexamenIdresultado=" + resultadoexamenIdresultado + '}';
    }

  
  //
  // getters / setters
  //
  public int getIdrespuesta()
  {
    return this.idrespuesta;
  }

  public void setIdrespuesta(int idrespuesta)
  {
    this.idrespuesta = idrespuesta;
  }

  public Integer getOpcionelegida()
  {
    return this.opcionelegida;
  }

  public void setOpcionelegida(Integer opcionelegida)
  {
    this.opcionelegida = opcionelegida;
  }

  public int getPreguntaIdpregunta()
  {
    return this.preguntaIdpregunta;
  }

  public void setPreguntaIdpregunta(int preguntaIdpregunta)
  {
    this.preguntaIdpregunta = preguntaIdpregunta;
  }

  public int getResultadoexamenIdresultado()
  {
    return this.resultadoexamenIdresultado;
  }

  public void setResultadoexamenIdresultado(int resultadoexamenIdresultado)
  {
    this.resultadoexamenIdresultado = resultadoexamenIdresultado;
  }
}