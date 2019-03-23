// Generated by DB Solo 5.2.3 on 24/02/2019 at 12:36:17 PM
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


public class CarreraDAOImpl implements CarreraDAO
{
  //
  // static data
  //
  protected static List pkColumns = new ArrayList();
  protected static List stdColumns = new ArrayList();
  protected static List allColumns = new ArrayList();
  protected static String tableName = "carrera";

  static
  {
    pkColumns.add("idcarrera");
    stdColumns.add("nombrecarrera");
    stdColumns.add("descripcion");
    stdColumns.add("duracion");
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
  public CarreraDAOImpl()
  {
    this(null);
  }

  public CarreraDAOImpl(Connection conn)
  {
    this.conn = conn;
  }

  //
  // CRUD methods
  //
  public Carrera getByPrimaryKey(int idcarrera)
  {
    PreparedStatement ps = null;
    ResultSet rs = null;

    try
    {
      int pos = 1;
      ps = getConn().prepareStatement(DBUtil.select(tableName, allColumns, pkColumns));
      DBUtil.bind(ps, pos++, idcarrera);
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
            Logger.getLogger(CarreraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

  public int update(Carrera obj) 
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
            Logger.getLogger(CarreraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (DAOException ex) {
          Logger.getLogger(CarreraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
      }
    finally
    {
      DBUtil.close(ps, null);
    }
      return 0;
  }

  public int insert(Carrera obj)
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
            Logger.getLogger(CarreraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (DAOException ex) {
          Logger.getLogger(CarreraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
      }
    finally
    {
      DBUtil.close(ps, null);
    }
      return 0;
  }

  public int delete(Carrera obj)
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
            Logger.getLogger(CarreraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (DAOException ex) {
          Logger.getLogger(CarreraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
  public List getByNombrecarrera(String nombrecarrera)
    throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == nombrecarrera)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "nombrecarrera" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns,
              Arrays.asList(new String[]{ "nombrecarrera" })));
        DBUtil.bind(ps, 1, nombrecarrera);
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

  public List getByDescripcion(String descripcion) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == descripcion)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "descripcion" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns,
              Arrays.asList(new String[]{ "descripcion" })));
        DBUtil.bind(ps, 1, descripcion);
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

  public List getByDuracion(Integer duracion) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == duracion)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "duracion" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns,
              Arrays.asList(new String[]{ "duracion" })));
        DBUtil.bind(ps, 1, duracion);
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

  //
  // helpers
  //
  protected int bindPrimaryKey(PreparedStatement ps, Carrera obj, int pos)
    throws SQLException
  {
    DBUtil.bind(ps, pos++, obj.getIdcarrera());

    return pos;
  }

  protected int bindStdColumns(PreparedStatement ps, Carrera obj, int pos)
    throws SQLException
  {
    DBUtil.bind(ps, pos++, obj.getNombrecarrera());
    DBUtil.bind(ps, pos++, obj.getDescripcion());
    DBUtil.bind(ps, pos++, obj.getDuracion());

    return pos;
  }

  protected Carrera fromResultSet(ResultSet rs) throws SQLException
  {
    Carrera obj = new Carrera();

    obj.setIdcarrera(DBUtil.getInt(rs, "idcarrera"));
    obj.setNombrecarrera(DBUtil.getString(rs, "nombrecarrera"));
    obj.setDescripcion(DBUtil.getString(rs, "descripcion"));
    obj.setDuracion(DBUtil.getInteger(rs, "duracion"));

    return obj;
  }

  protected Connection getConn()
  {
    return conn=Conexion.getConexion();
  }
  
  public void closeConn(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
}
