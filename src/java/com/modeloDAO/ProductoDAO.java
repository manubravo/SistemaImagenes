package com.modeloDAO;

import com.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public int agregar(Producto p) {
        Conexion cn = new Conexion();
        String sql = "insert into producto(Nombre, Ruta)values(?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getRuta());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public List<Producto> listar() {
        Conexion cn = new Conexion();
        String sql = "select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setRuta(rs.getString(3));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
