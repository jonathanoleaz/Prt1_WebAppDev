// Generated by DB Solo 5.2.3 on 24/02/2019 at 01:31:41 PM
package DAOs;

import java.util.List;


public interface PreguntaDAO
{
  // CRUD methods
  public Pregunta getByPrimaryKey(int idpregunta) throws DAOException;

  public List selectAll() throws DAOException;

  public List select(String whereStatement, Object[] bindVariables)
    throws DAOException;

  public long selectCount() throws DAOException;

  public long selectCount(String whereStatement, Object[] bindVariables)
    throws DAOException;

  public int update(Pregunta obj) throws DAOException;

  public int insert(Pregunta obj) throws DAOException;

  public int delete(Pregunta obj) throws DAOException;

  // Finders
  public List getByNombremateria(String nombremateria)
    throws DAOException;

  public List getByDescripcion(String descripcion) throws DAOException;

  public List getByOpcion1(String opcion1) throws DAOException;

  public List getByOpcion2(String opcion2) throws DAOException;

  public List getByOpcion3(String opcion3) throws DAOException;

  public List getByOpcion4(String opcion4) throws DAOException;

  public List getByOpcion5(String opcion5) throws DAOException;

  public List getByOpcioncorrecta(String opcioncorrecta)
    throws DAOException;

  public List getByPreguntacol(String preguntacol) throws DAOException;

  public List getByExamenIdexamen(int examenIdexamen) throws DAOException;
}