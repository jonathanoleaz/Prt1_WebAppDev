// Generated by DB Solo 5.2.3 on 24/02/2019 at 01:31:41 PM
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


public class PreguntaDAOImpl implements PreguntaDAO
{
  //
  // static data
  //
  protected static List pkColumns = new ArrayList();
  protected static List stdColumns = new ArrayList();
  protected static List allColumns = new ArrayList();
  protected static String tableName = "pregunta";

  static
  {
    pkColumns.add("idpregunta");
    stdColumns.add("nombremateria");
    stdColumns.add("descripcion");
    stdColumns.add("opcion1");
    stdColumns.add("opcion2");
    stdColumns.add("opcion3");
    stdColumns.add("opcion4");
    stdColumns.add("opcion5");
    stdColumns.add("opcioncorrecta");
    stdColumns.add("preguntacol");
    stdColumns.add("examen_idexamen");
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
  public PreguntaDAOImpl()
  {
    this(null);
  }

  public PreguntaDAOImpl(Connection conn)
  {
    this.conn = conn;
  }

  //
  // CRUD methods
  //
  public Pregunta getByPrimaryKey(int idpregunta) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;

    try
    {
      int pos = 1;
      ps = getConn().prepareStatement(DBUtil.select(tableName, allColumns, pkColumns));
      DBUtil.bind(ps, pos++, idpregunta);
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

  public int update(Pregunta obj) throws DAOException
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

  public int insert(Pregunta obj) throws DAOException
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

  public int delete(Pregunta obj) throws DAOException
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
  public List getByNombremateria(String nombremateria)
    throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == nombremateria)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "nombremateria" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns,
              Arrays.asList(new String[]{ "nombremateria" })));
        DBUtil.bind(ps, 1, nombremateria);
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

  public List getByOpcion1(String opcion1) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == opcion1)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "opcion1" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{ "opcion1" })));
        DBUtil.bind(ps, 1, opcion1);
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

  public List getByOpcion2(String opcion2) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == opcion2)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "opcion2" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{ "opcion2" })));
        DBUtil.bind(ps, 1, opcion2);
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

  public List getByOpcion3(String opcion3) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == opcion3)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "opcion3" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{ "opcion3" })));
        DBUtil.bind(ps, 1, opcion3);
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

  public List getByOpcion4(String opcion4) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == opcion4)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "opcion4" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{ "opcion4" })));
        DBUtil.bind(ps, 1, opcion4);
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

  public List getByOpcion5(String opcion5) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == opcion5)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "opcion5" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{ "opcion5" })));
        DBUtil.bind(ps, 1, opcion5);
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

  public List getByOpcioncorrecta(String opcioncorrecta)
    throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == opcioncorrecta)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "opcioncorrecta" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns,
              Arrays.asList(new String[]{ "opcioncorrecta" })));
        DBUtil.bind(ps, 1, opcioncorrecta);
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

  public List getByPreguntacol(String preguntacol) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      if (null == preguntacol)
      {
        ps = getConn()
               .prepareStatement(DBUtil.selectNull(tableName, allColumns,
              Arrays.asList(new String[]{ "preguntacol" })));
      }
      else
      {
        ps = getConn()
               .prepareStatement(DBUtil.select(tableName, allColumns,
              Arrays.asList(new String[]{ "preguntacol" })));
        DBUtil.bind(ps, 1, preguntacol);
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

  public List getByExamenIdexamen(int examenIdexamen) throws DAOException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List ret = new ArrayList();

    try
    {
      ps = getConn()
             .prepareStatement(DBUtil.select(tableName, allColumns,
            Arrays.asList(new String[]{ "examen_idexamen" })));
      DBUtil.bind(ps, 1, examenIdexamen);
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
  protected int bindPrimaryKey(PreparedStatement ps, Pregunta obj, int pos)
    throws SQLException
  {
    DBUtil.bind(ps, pos++, obj.getIdpregunta());

    return pos;
  }

  protected int bindStdColumns(PreparedStatement ps, Pregunta obj, int pos)
    throws SQLException
  {
    DBUtil.bind(ps, pos++, obj.getNombremateria());
    DBUtil.bind(ps, pos++, obj.getDescripcion());
    DBUtil.bind(ps, pos++, obj.getOpcion1());
    DBUtil.bind(ps, pos++, obj.getOpcion2());
    DBUtil.bind(ps, pos++, obj.getOpcion3());
    DBUtil.bind(ps, pos++, obj.getOpcion4());
    DBUtil.bind(ps, pos++, obj.getOpcion5());
    DBUtil.bind(ps, pos++, obj.getOpcioncorrecta());
    DBUtil.bind(ps, pos++, obj.getPreguntacol());
    DBUtil.bind(ps, pos++, obj.getExamenIdexamen());

    return pos;
  }

  protected Pregunta fromResultSet(ResultSet rs) throws SQLException
  {
    Pregunta obj = new Pregunta();

    obj.setIdpregunta(DBUtil.getInt(rs, "idpregunta"));
    obj.setNombremateria(DBUtil.getString(rs, "nombremateria"));
    obj.setDescripcion(DBUtil.getString(rs, "descripcion"));
    obj.setOpcion1(DBUtil.getString(rs, "opcion1"));
    obj.setOpcion2(DBUtil.getString(rs, "opcion2"));
    obj.setOpcion3(DBUtil.getString(rs, "opcion3"));
    obj.setOpcion4(DBUtil.getString(rs, "opcion4"));
    obj.setOpcion5(DBUtil.getString(rs, "opcion5"));
    obj.setOpcioncorrecta(DBUtil.getString(rs, "opcioncorrecta"));
    obj.setPreguntacol(DBUtil.getString(rs, "preguntacol"));
    obj.setExamenIdexamen(DBUtil.getInt(rs, "examen_idexamen"));

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
