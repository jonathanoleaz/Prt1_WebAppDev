// Generated by DB Solo 5.2.3 on 24/02/2019 at 12:37:59 PM
package DAOs;

public class Materia
{
  private int idmateria;
  private String nombremateria;
  private String descripcion;
  private int carreraIdcarrera;

    public Materia(String nombremateria, String descripcion, int carreraIdcarrera) {
       
        this.nombremateria = nombremateria;
        this.descripcion = descripcion;
        this.carreraIdcarrera = carreraIdcarrera;
    }

    public Materia() {
    }

    @Override
    public String toString() {
        return "Materia{" + "idmateria=" + idmateria + ", nombremateria=" + nombremateria + ", descripcion=" + descripcion + ", carreraIdcarrera=" + carreraIdcarrera + '}';
    }

  
  //
  // getters / setters
  //
  public int getIdmateria()
  {
    return this.idmateria;
  }

  public void setIdmateria(int idmateria)
  {
    this.idmateria = idmateria;
  }

  public String getNombremateria()
  {
    return this.nombremateria;
  }

  public void setNombremateria(String nombremateria)
  {
    this.nombremateria = nombremateria;
  }

  public String getDescripcion()
  {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }

  public int getCarreraIdcarrera()
  {
    return this.carreraIdcarrera;
  }

  public void setCarreraIdcarrera(int carreraIdcarrera)
  {
    this.carreraIdcarrera = carreraIdcarrera;
  }
}
