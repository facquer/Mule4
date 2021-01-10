/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luffy.gestion;

import java.util.List;

import javax.ejb.Local;

import luffy.modelo.Usuario;

/**
 *
 * @author angel
 */
@Local
public interface GestionUsuarioLocal {

    public void insertUsuario(Usuario u);

    public List<Usuario> getUsuarios();

    public List<Usuario> buscarUsuario(String usuario, String contrasenia);
}
