// Generated by DB Solo 5.2.3 on 24/02/2019 at 12:36:17 PM
package DAOs;

import java.util.List;


public interface CarreraDAO
{
  // CRUD methods
  public Carrera getByPrimaryKey(int idcarrera) throws DAOException;

  public List selectAll() throws DAOException;

  public List select(String whereStatement, Object[] bindVariables)
    throws DAOException;

  public long selectCount() throws DAOException;

  public long selectCount(String whereStatement, Object[] bindVariables)
    throws DAOException;

  public int update(Carrera obj) throws DAOException;

  public int insert(Carrera obj) throws DAOException;

  public int delete(Carrera obj) throws DAOException;

  // Finders
  public List getByNombrecarrera(String nombrecarrera)
    throws DAOException;

  public List getByDescripcion(String descripcion) throws DAOException;

  public List getByDuracion(Integer duracion) throws DAOException;
}