// Generated by DB Solo 5.2.3 on 24/02/2019 at 01:34:02 PM
package DAOs;

import static DAOs.AlumnoDAOImpl.tableName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAOImpl implements UsuarioDAO
{
  //
  // static data
  //
  protected static List pkColumns = new ArrayList();
  protected static List stdColumns = new ArrayList();
  protected static List allColumns = new ArrayList();
  protected static String tableName = "usuario";

  static
  {
    pkColumns.add("idusuario");
    stdColumns.add("nombre_usuario");
    stdColumns.add("password");
    stdColumns.add("tipo_usuario");
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
  public UsuarioDAOImpl()
  {
    this(null);
  }

  public UsuarioDAOImpl(Connection conn)
  {
    this.conn = conn;
  }

  //
  // CRUD methods
  //
  public Usuario getByPrimaryKey(int idusuario) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;

    try
    {
      int pos = 1;
      ps = getConn().prepareStatement(DBUtil.select(tableName, allColumns, pkColumns));
      DBUtil.bind(ps, pos++, idusuario);
      rs = ps.executeQuery();

      if (rs.next())
      {
        return fromResultSet(rs);
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

  public int update(Usuario obj) throws DAOException
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
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, null);
    }
  }

  public int insert(Usuario obj) throws DAOException
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
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, null);
    }
  }

  public int delete(Usuario obj) throws DAOException
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
      throw new DAOException(e);
    }
    finally
    {
      DBUtil.close(ps, null);
    }
  }

  //
  // finders
  //
  public List getByNombreUsuario(String nombreUsuario)
    throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == nombreUsuario)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "nombre_usuario" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns,
              Arrays.asList(new String[]{ "nombre_usuario" })));
        DBUtil.bind(ps, 1, nombreUsuario);
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

  public List getByPassword(String password) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == password)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "password" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns,
              Arrays.asList(new String[]{ "password" })));
        DBUtil.bind(ps, 1, password);
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

  public List getByTipoUsuario(Integer tipoUsuario) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == tipoUsuario)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "tipo_usuario" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns,
              Arrays.asList(new String[]{ "tipo_usuario" })));
        DBUtil.bind(ps, 1, tipoUsuario);
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
  protected int bindPrimaryKey(PreparedStatement ps, Usuario obj, int pos)
    throws SQLException
  {
    DBUtil.bind(ps, pos++, obj.getIdusuario());

    return pos;
  }

  protected int bindStdColumns(PreparedStatement ps, Usuario obj, int pos)
    throws SQLException
  {
    DBUtil.bind(ps, pos++, obj.getNombreUsuario());
    DBUtil.bind(ps, pos++, obj.getPassword());
    DBUtil.bind(ps, pos++, obj.getTipoUsuario());

    return pos;
  }

  protected Usuario fromResultSet(ResultSet rs) throws SQLException
  {
    Usuario obj = new Usuario();

    obj.setIdusuario(DBUtil.getInt(rs, "idusuario"));
    obj.setNombreUsuario(DBUtil.getString(rs, "nombre_usuario"));
    obj.setPassword(DBUtil.getString(rs, "password"));
    obj.setTipoUsuario(DBUtil.getInteger(rs, "tipo_usuario"));

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