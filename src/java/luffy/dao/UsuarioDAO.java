/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luffy.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import luffy.modelo.Usuario;

/**
 *
 * @author angel
 */
@Stateless
public class UsuarioDAO {

    @Inject
    private EntityManager em;

    public void insert(Usuario usuario) {
        this.em.persist(usuario);
    }

    public List<Usuario> getUsuarios() {
        String jpql = "SELECT u FROM Usuario u";
        Query query = this.em.createQuery(jpql, Usuario.class);
        List<Usuario> usuarioList = query.getResultList();
        return usuarioList;
    }

    public List<Usuario> buscarUsuario(String usuario, String contra) {
        String jpql = "SELECT p FROM Usuario u WHERE u.usuario= ?1 AND u.contrasenia= ?2";
        Query query = this.em.createQuery(jpql, Usuario.class);
        query.setParameter(1, usuario);
        query.setParameter(2, contra);
        return query.getResultList();
    }
}
