// Generated by DB Solo 5.2.3 on 24/02/2019 at 12:37:21 PM
package DAOs;

import java.util.Date;


public class Examen
{
  private int idexamen;
  private String nombreexamen;
  private String descripcion;
  private Date fecha;
  private int materiaIdmateria;

    public Examen() {
    }

    public Examen(String nombreexamen, String descripcion, Date fecha, int materiaIdmateria) {
        
        this.nombreexamen = nombreexamen;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.materiaIdmateria = materiaIdmateria;
    }

    @Override
    public String toString() {
        return "Examen{" + "idexamen=" + idexamen + ", nombreexamen=" + nombreexamen + ", descripcion=" + descripcion + ", fecha=" + fecha + ", materiaIdmateria=" + materiaIdmateria + '}';
    }
    

  //
  // getters / setters
  //
  public int getIdexamen()
  {
    return this.idexamen;
  }

  public void setIdexamen(int idexamen)
  {
    this.idexamen = idexamen;
  }

  public String getNombreexamen()
  {
    return this.nombreexamen;
  }

  public void setNombreexamen(String nombreexamen)
  {
    this.nombreexamen = nombreexamen;
  }

  public String getDescripcion()
  {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }

  public Date getFecha()
  {
    return this.fecha;
  }

  public void setFecha(Date fecha)
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
}
