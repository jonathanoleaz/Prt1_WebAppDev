// Generated by DB Solo 5.2.3 on 24/02/2019 at 12:35:00 PM
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

public class AlumnoDAOImpl implements AlumnoDAO {
    //
    // static data
    //

    protected static List pkColumns = new ArrayList();
    protected static List stdColumns = new ArrayList();
    protected static List allColumns = new ArrayList();
    protected static String tableName = "alumno";

    static {
        pkColumns.add("noboleta");
        stdColumns.add("nombre");
        stdColumns.add("materno");
        stdColumns.add("paterno");
        stdColumns.add("domicilio");
        stdColumns.add("email");
        stdColumns.add("idcarrera");
        stdColumns.add("idusuario");
        stdColumns.add("usuario_idusuario");
        stdColumns.add("carrera_idcarrera");
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
    public AlumnoDAOImpl() {
        this(null);
    }

    public AlumnoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    //
    // CRUD methods
    //
    public Alumno getByPrimaryKey(int noboleta) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            int pos = 1;
            ps = getConn().prepareStatement(DBUtil.select(tableName, allColumns, pkColumns));
            DBUtil.bind(ps, pos++, noboleta);
            rs = ps.executeQuery();

            if (rs.next()) {
                return fromResultSet(rs);
            }
        } catch (SQLException e) {
            try {
                throw new DAOException(e);
            } catch (DAOException ex) {
                Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            DBUtil.close(ps, rs);
        }

        return null;
    }

    public long selectCount() throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = getConn().prepareStatement("select count(*) from " + tableName);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return 0;
    }

    public long selectCount(String whereStatement, Object[] bindVariables)
            throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (!whereStatement.trim().toUpperCase().startsWith("WHERE")) {
            whereStatement = " WHERE " + whereStatement;
        } else if (whereStatement.startsWith(" ") == false) {
            whereStatement = " " + whereStatement;
        }

        try {
            ps = getConn().prepareStatement("select count(*) from " + tableName + whereStatement);

            for (int i = 0; i < bindVariables.length; i++) {
                DBUtil.bind(ps, i + 1, bindVariables[i]);
            }

            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return 0;
    }

    public List selectAll() throws DAOException {
        List ret = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = getConn().prepareStatement(DBUtil.select(tableName, allColumns));
            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public List select(String whereStatement, Object[] bindVariables)
            throws DAOException {
        List ret = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (!whereStatement.trim().toUpperCase().startsWith("WHERE")) {
            whereStatement = " WHERE " + whereStatement;
        } else if (whereStatement.startsWith(" ") == false) {
            whereStatement = " " + whereStatement;
        }

        try {
            ps = getConn().prepareStatement(DBUtil.select(tableName, allColumns) + whereStatement);

            for (int i = 0; i < bindVariables.length; i++) {
                DBUtil.bind(ps, i + 1, bindVariables[i]);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Error in select(), table = " + tableName, e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public int update(Alumno obj) {
        PreparedStatement ps = null;
        int pos = 1;

        try {
            ps = getConn().prepareStatement(DBUtil.update(tableName, stdColumns, pkColumns));
            pos = bindStdColumns(ps, obj, pos);
            bindPrimaryKey(ps, obj, pos);

            int rowCount = ps.executeUpdate();

            if (rowCount != 1) {
                throw new DAOException("Error updating " + obj.getClass() + " in " + tableName
                        + ", affected rows = " + rowCount);
            }

            return rowCount;
        } catch (SQLException e) {
            try {
                throw new DAOException(e);
            } catch (DAOException ex) {
                Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.close(ps, null);
        }
        return 1;
    }

    @Override
    public int insert(Alumno obj) {
        PreparedStatement ps = null;
        int pos = 1;

        try {
            ps = getConn().prepareStatement(DBUtil.insert(tableName, pkColumns, stdColumns));
            pos = bindPrimaryKey(ps, obj, pos);
            bindStdColumns(ps, obj, pos);

            int rowCount = ps.executeUpdate();

            if (rowCount != 1) {
                throw new DAOException("Error inserting " + obj.getClass() + " in " + tableName
                        + ", affected rows = " + rowCount);
            }

            return rowCount;
        } catch (SQLException e) {
            try {
                throw new DAOException(e);
            } catch (DAOException ex) {
                Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.close(ps, null);
        }
        return 1;
    }

    public int delete(Alumno obj) {
        PreparedStatement ps = null;

        try {
            ps = getConn().prepareStatement(DBUtil.delete(tableName, pkColumns));
            bindPrimaryKey(ps, obj, 1);

            int rowCount = ps.executeUpdate();

            if (rowCount != 1) {
                throw new DAOException("Error deleting " + obj.getClass() + " in " + tableName
                        + ", affected rows = " + rowCount);
            }

            return rowCount;
        } catch (SQLException e) {
            try {
                throw new DAOException(e);
            } catch (DAOException ex) {
                Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtil.close(ps, null);
        }
        return 0;
    }

    //
    // finders
    //
    public List getByNombre(String nombre) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List ret = new ArrayList();

        try {
            if (null == nombre) {
                ps = getConn()
                        .prepareStatement(DBUtil.selectNull(tableName, allColumns,
                                Arrays.asList(new String[]{"nombre"})));
            } else {
                ps = getConn()
                        .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{"nombre"})));
                DBUtil.bind(ps, 1, nombre);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public List getByMaterno(String materno) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List ret = new ArrayList();

        try {
            if (null == materno) {
                ps = getConn()
                        .prepareStatement(DBUtil.selectNull(tableName, allColumns,
                                Arrays.asList(new String[]{"materno"})));
            } else {
                ps = getConn()
                        .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{"materno"})));
                DBUtil.bind(ps, 1, materno);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public List getByPaterno(String paterno) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List ret = new ArrayList();

        try {
            if (null == paterno) {
                ps = getConn()
                        .prepareStatement(DBUtil.selectNull(tableName, allColumns,
                                Arrays.asList(new String[]{"paterno"})));
            } else {
                ps = getConn()
                        .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{"paterno"})));
                DBUtil.bind(ps, 1, paterno);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public List getByDomicilio(String domicilio) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List ret = new ArrayList();

        try {
            if (null == domicilio) {
                ps = getConn()
                        .prepareStatement(DBUtil.selectNull(tableName, allColumns,
                                Arrays.asList(new String[]{"domicilio"})));
            } else {
                ps = getConn()
                        .prepareStatement(DBUtil.select(tableName, allColumns,
                                Arrays.asList(new String[]{"domicilio"})));
                DBUtil.bind(ps, 1, domicilio);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public List getByEmail(String email) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List ret = new ArrayList();

        try {
            if (null == email) {
                ps = getConn()
                        .prepareStatement(DBUtil.selectNull(tableName, allColumns,
                                Arrays.asList(new String[]{"email"})));
            } else {
                ps = getConn()
                        .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{"email"})));
                DBUtil.bind(ps, 1, email);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public List getByIdcarrera(int idcarrera) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List ret = new ArrayList();

        try {
            ps = getConn()
                    .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{"idcarrera"})));
            DBUtil.bind(ps, 1, idcarrera);
            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public List getByIdusuario(int idusuario) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List ret = new ArrayList();

        try {
            ps = getConn()
                    .prepareStatement(DBUtil.select(tableName, allColumns, Arrays.asList(new String[]{"idusuario"})));
            DBUtil.bind(ps, 1, idusuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public List getByUsuarioIdusuario(int usuarioIdusuario)
            throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List ret = new ArrayList();

        try {
            ps = getConn()
                    .prepareStatement(DBUtil.select(tableName, allColumns,
                            Arrays.asList(new String[]{"usuario_idusuario"})));
            DBUtil.bind(ps, 1, usuarioIdusuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    public List getByCarreraIdcarrera(int carreraIdcarrera)
            throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List ret = new ArrayList();

        try {
            ps = getConn()
                    .prepareStatement(DBUtil.select(tableName, allColumns,
                            Arrays.asList(new String[]{"carrera_idcarrera"})));
            DBUtil.bind(ps, 1, carreraIdcarrera);
            rs = ps.executeQuery();

            while (rs.next()) {
                ret.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            DBUtil.close(ps, rs);
        }

        return ret;
    }

    //
    // helpers
    //
    protected int bindPrimaryKey(PreparedStatement ps, Alumno obj, int pos)
            throws SQLException {
        DBUtil.bind(ps, pos++, obj.getNoboleta());

        return pos;
    }

    protected int bindStdColumns(PreparedStatement ps, Alumno obj, int pos)
            throws SQLException {
        DBUtil.bind(ps, pos++, obj.getNombre());
        DBUtil.bind(ps, pos++, obj.getMaterno());
        DBUtil.bind(ps, pos++, obj.getPaterno());
        DBUtil.bind(ps, pos++, obj.getDomicilio());
        DBUtil.bind(ps, pos++, obj.getEmail());
        DBUtil.bind(ps, pos++, obj.getIdcarrera());
        DBUtil.bind(ps, pos++, obj.getIdusuario());
        DBUtil.bind(ps, pos++, obj.getUsuarioIdusuario());
        DBUtil.bind(ps, pos++, obj.getCarreraIdcarrera());

        return pos;
    }

    protected Alumno fromResultSet(ResultSet rs) throws SQLException {
        Alumno obj = new Alumno();

        obj.setNoboleta(DBUtil.getInt(rs, "noboleta"));
        obj.setNombre(DBUtil.getString(rs, "nombre"));
        obj.setMaterno(DBUtil.getString(rs, "materno"));
        obj.setPaterno(DBUtil.getString(rs, "paterno"));
        obj.setDomicilio(DBUtil.getString(rs, "domicilio"));
        obj.setEmail(DBUtil.getString(rs, "email"));
        obj.setIdcarrera(DBUtil.getInt(rs, "idcarrera"));
        obj.setIdusuario(DBUtil.getInt(rs, "idusuario"));
        obj.setUsuarioIdusuario(DBUtil.getInt(rs, "usuario_idusuario"));
        obj.setCarreraIdcarrera(DBUtil.getInt(rs, "carrera_idcarrera"));

        return obj;
    }

    protected Connection getConn() {
        return conn = Conexion.getConexion();
    }
    
    public void closeConn(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void main(String[] args) {

        try {
            System.out.println("nada");
            AlumnoDAOImpl dao = new AlumnoDAOImpl();
            dao.insert(new Alumno(tableName, tableName, tableName, tableName, tableName, 0, 0, 6, 1006));
            System.out.println(Arrays.toString(dao.selectAll().toArray()));
        } catch (DAOException ex) {
            Logger.getLogger(AlumnoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
