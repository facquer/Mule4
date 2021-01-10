/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luffy.gestion;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import luffy.dao.UsuarioDAO;
import luffy.modelo.Usuario;
/**
 *
 * @author angel
 */
@Stateless
public class GestionUsuario implements GestionUsuarioLocal {

	@Inject
	private UsuarioDAO dao;
	
	@Override
	public void insertUsuario(Usuario usuario) {
		dao.insert(usuario);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return dao.getUsuarios();
	}
        
        @Override
        public List<Usuario> buscarUsuario(String usuario, String contra){
            return dao.buscarUsuario(usuario, contra);
        }

	public UsuarioDAO getDao() {
		return dao;
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}
	
	
}
