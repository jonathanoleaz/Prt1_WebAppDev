// Generated by DB Solo 5.2.3 on 24/02/2019 at 01:33:27 PM
package DAOs;

public class Resultadoexamen
{
  private int idresultado;
  private int calificacion;
  private String fecha;
  private int materiaIdmateria;
  private int alumnoNoboleta;

    public Resultadoexamen() {
    }

    public Resultadoexamen(int calificacion, String fecha, int materiaIdmateria, int alumnoNoboleta) {
        
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.materiaIdmateria = materiaIdmateria;
        this.alumnoNoboleta = alumnoNoboleta;
    }

    @Override
    public String toString() {
        return "Resultadoexamen{" + "idresultado=" + idresultado + ", calificacion=" + calificacion + ", fecha=" + fecha + ", materiaIdmateria=" + materiaIdmateria + ", alumnoNoboleta=" + alumnoNoboleta + '}';
    }

  
  //
  // getters / setters
  //
  public int getIdresultado()
  {
    return this.idresultado;
  }

  public void setIdresultado(int idresultado)
  {
    this.idresultado = idresultado;
  }

  public int getCalificacion()
  {
    return this.calificacion;
  }

  public void setCalificacion(int calificacion)
  {
    this.calificacion = calificacion;
  }

  public String getFecha()
  {
    return this.fecha;
  }

  public void setFecha(String fecha)
  {
    this.fecha = fecha;
  }

  public int getMateriaIdmateria()
  {
    return this.materiaIdmateria;
  }

  public void setMateriaIdmateria(int materiaIdmateria)
  {
    this.materiaIdmateria = materiaIdmateria;
  }

  public int getAlumnoNoboleta()
  {
    return this.alumnoNoboleta;
  }

  public void setAlumnoNoboleta(int alumnoNoboleta)
  {
    this.alumnoNoboleta = alumnoNoboleta;
  }
}