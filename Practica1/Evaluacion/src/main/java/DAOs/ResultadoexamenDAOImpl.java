// Generated by DB Solo 5.2.3 on 24/02/2019 at 01:33:27 PM
package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ResultadoexamenDAOImpl implements ResultadoexamenDAO
{
  //
  // static data
  //
  protected static List pkColumns = new ArrayList();
  protected static List stdColumns = new ArrayList();
  protected static List allColumns = new ArrayList();
  protected static String tableName = "resultadoexamen";

  static
  {
    pkColumns.add("idresultado");
    stdColumns.add("calificacion");
    stdColumns.add("fecha");
    stdColumns.add("materia_idmateria");
    stdColumns.add("alumno_noboleta");
    allColumns.addAll(pkColumns);
    allColumns.addAll(stdColumns);
  }

  //
  // data
  //
  protected Connection conn = null;

  //
  // construction
  //
  public ResultadoexamenDAOImpl()
  {
    this(null);
  }

  public ResultadoexamenDAOImpl(Connection conn)
  {
    this.conn = conn;
  }

  //
  // CRUD methods
  //
  public Resultadoexamen getByPrimaryKey(int idresultado)    
  {
    PreparedStatement ps = null;
    ResultSet rs = null;

    try
    {
      int pos = 1;
      ps = getConn().prepareStatement(DBUtil.select(tableName, allColumns, pkColumns));
      DBUtil.bind(ps, pos++, idresultado);
      rs = ps.executeQuery();

      if (rs.next())
      {
        return fromResultSet(rs);
      }
    }
    catch (SQLException e)
    {
        try {
            throw new DAOException(e);
        } catch (DAOException ex) {
            Logger.getLogger(ResultadoexamenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    finally
    {
      DBUtil.close(ps, rs);
    }

    return null;
  }

  public long selectCount() throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;

    try
    {
      ps = getConn().prepareStatement("select count(*) from " + tableName);
      rs = ps.executeQuery();

      if (rs.next())
      {
        return rs.getLong(1);
      }
    }
    catch (SQLException e)
    {
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, rs);
    }

    return 0;
  }

  public long selectCount(String whereStatement, Object[] bindVariables)
    throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;

    if (!whereStatement.trim().toUpperCase().startsWith("WHERE"))
    {
      whereStatement = " WHERE " + whereStatement;
    }
    else if (whereStatement.startsWith(" ") == false)
    {
      whereStatement = " " + whereStatement;
    }

    try
    {
      ps = getConn().prepareStatement("select count(*) from " + tableName + whereStatement);

      for (int i = 0; i < bindVariables.length; i++)
        DBUtil.bind(ps, i + 1, bindVariables[i]);

      rs = ps.executeQuery();

      if (rs.next())
      {
        return rs.getLong(1);
      }
    }
    catch (SQLException e)
    {
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, rs);
    }

    return 0;
  }

  public List selectAll() throws DAOException
  {
    List ret = new ArrayList();
    PreparedStatement ps = null;
    ResultSet rs = null;

    try
    {
      ps = getConn().prepareStatement(DBUtil.select(tableName, allColumns));
      rs = ps.executeQuery();

      while (rs.next())
        ret.add(fromResultSet(rs));
    }
    catch (SQLException e)
    {
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, rs);
    }

    return ret;
  }

  public List select(String whereStatement, Object[] bindVariables)
    throws DAOException
  {
    List ret = new ArrayList();
    PreparedStatement ps = null;
    ResultSet rs = null;

    if (!whereStatement.trim().toUpperCase().startsWith("WHERE"))
    {
      whereStatement = " WHERE " + whereStatement;
    }
    else if (whereStatement.startsWith(" ") == false)
    {
      whereStatement = " " + whereStatement;
    }

    try
    {
      ps = getConn().prepareStatement(DBUtil.select(tableName, allColumns) + whereStatement);

      for (int i = 0; i < bindVariables.length; i++)
        DBUtil.bind(ps, i + 1, bindVariables[i]);

      rs = ps.executeQuery();

      while (rs.next())
        ret.add(fromResultSet(rs));
    }
    catch (SQLException e)
    {
      throw new DAOException("Error in select(), table = " + tableName, e);
    }
    finally
    {
      DBUtil.close(ps, rs);
    }

    return ret;
  }

  public int update(Resultadoexamen obj)
  {
    PreparedStatement ps = null;
    int pos = 1;

    try
    {
      ps = getConn().prepareStatement(DBUtil.update(tableName, stdColumns, pkColumns));
      pos = bindStdColumns(ps, obj, pos);
      bindPrimaryKey(ps, obj, pos);

      int rowCount = ps.executeUpdate();

      if (rowCount != 1)
      {
        throw new DAOException("Error updating " + obj.getClass() + " in " + tableName +
          ", affected rows = " + rowCount);
      }

      return rowCount;
    }
    catch (SQLException e)
    {
        try {
            throw new DAOException(e);
        } catch (DAOException ex) {
            Logger.getLogger(ResultadoexamenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (DAOException ex) {
          Logger.getLogger(ResultadoexamenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
      }
    finally
    {
      DBUtil.close(ps, null);
    }
      return 0;
  }

  public int insert(Resultadoexamen obj)
  {
    PreparedStatement ps = null;
    int pos = 1;

    try
    {
      ps = getConn().prepareStatement(DBUtil.insert(tableName, pkColumns, stdColumns));
      pos = bindPrimaryKey(ps, obj, pos);
      bindStdColumns(ps, obj, pos);

      int rowCount = ps.executeUpdate();

      if (rowCount != 1)
      {
        throw new DAOException("Error inserting " + obj.getClass() + " in " + tableName +
          ", affected rows = " + rowCount);
      }

      return rowCount;
    }
    catch (SQLException e)
    {
        try {
            throw new DAOException(e);
        } catch (DAOException ex) {
            Logger.getLogger(ResultadoexamenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (DAOException ex) {
          Logger.getLogger(ResultadoexamenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
      }
    finally
    {
      DBUtil.close(ps, null);
    }
      return 0;
  }

  public int delete(Resultadoexamen obj) 
  {
    PreparedStatement ps = null;

    try
    {
      ps = getConn().prepareStatement(DBUtil.delete(tableName, pkColumns));
      bindPrimaryKey(ps, obj, 1);

      int rowCount = ps.executeUpdate();

      if (rowCount != 1)
      {
        throw new DAOException("Error deleting " + obj.getClass() + " in " + tableName +
          ", affected rows = " + rowCount);
      }

      return rowCount;
    }
    catch (SQLException e)
    {
        try {
            throw new DAOException(e);
        } catch (DAOException ex) {
            Logger.getLogger(ResultadoexamenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (DAOException ex) {
          Logger.getLogger(ResultadoexamenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
      }
    finally
    {
      DBUtil.close(ps, null);
    }
      return 0;
  }

  //
  // finders
  //
  public List getByCalificacion(int calificacion) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      ps = getConn()
             .prepareStatement(DBUtil.select(tableName, allColumns,
            Arrays.asList(new String[]{ "calificacion" })));
      DBUtil.bind(ps, 1, calificacion);
      rs = ps.executeQuery();

      while (rs.next())
        ret.add(fromResultSet(rs));
    }
    catch (SQLException e)
    {
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, rs);
    }

    return ret;
  }

  public List getByFecha(String fecha) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == fecha)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "fecha" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{ "fecha" })));
        DBUtil.bind(ps, 1, fecha);
      }

      rs = ps.executeQuery();

      while (rs.next())
        ret.add(fromResultSet(rs));
    }
    catch (SQLException e)
    {
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, rs);
    }

    return ret;
  }

  public List getByMateriaIdmateria(int materiaIdmateria)
    throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      ps = getConn()
             .prepareStatement(DBUtil.select(tableName, allColumns,
            Arrays.asList(new String[]{ "materia_idmateria" })));
      DBUtil.bind(ps, 1, materiaIdmateria);
      rs = ps.executeQuery();

      while (rs.next())
        ret.add(fromResultSet(rs));
    }
    catch (SQLException e)
    {
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, rs);
    }

    return ret;
  }

  public List getByAlumnoNoboleta(int alumnoNoboleta) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      ps = getConn()
             .prepareStatement(DBUtil.select(tableName, allColumns,
            Arrays.asList(new String[]{ "alumno_noboleta" })));
      DBUtil.bind(ps, 1, alumnoNoboleta);
      rs = ps.executeQuery();

      while (rs.next())
        ret.add(fromResultSet(rs));
    }
    catch (SQLException e)
    {
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, rs);
    }

    return ret;
  }

  //
  // helpers
  //
  protected int bindPrimaryKey(PreparedStatement ps, Resultadoexamen obj, int pos)
    throws SQLException
  {
    DBUtil.bind(ps, pos++, obj.getIdresultado());

    return pos;
  }

  protected int bindStdColumns(PreparedStatement ps, Resultadoexamen obj, int pos)
    throws SQLException
  {
    DBUtil.bind(ps, pos++, obj.getCalificacion());
    DBUtil.bind(ps, pos++, obj.getFecha());
    DBUtil.bind(ps, pos++, obj.getMateriaIdmateria());
    DBUtil.bind(ps, pos++, obj.getAlumnoNoboleta());

    return pos;
  }

  protected Resultadoexamen fromResultSet(ResultSet rs)
    throws SQLException
  {
    Resultadoexamen obj = new Resultadoexamen();

    obj.setIdresultado(DBUtil.getInt(rs, "idresultado"));
    obj.setCalificacion(DBUtil.getInt(rs, "calificacion"));
    obj.setFecha(DBUtil.getString(rs, "fecha"));
    obj.setMateriaIdmateria(DBUtil.getInt(rs, "materia_idmateria"));
    obj.setAlumnoNoboleta(DBUtil.getInt(rs, "alumno_noboleta"));

    return obj;
  }

  protected Connection getConn() {
        return conn = Conexion.getConexion();
    }
  
  public static void main(String[] args) {

        try {
            System.out.println("nada");
            UsuarioDAOImpl dao=new UsuarioDAOImpl();
            dao.insert(new Usuario("jonathan", "jonathan", 2));
            System.out.println(Arrays.toString(dao.selectAll().toArray()));
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}