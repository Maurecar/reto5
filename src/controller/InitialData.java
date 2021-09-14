package controller;

import java.util.ArrayList;
import model.AutorModel;
import model.LibroModel;
import model.PrestamoModel;
import model.RecursoModel;
import model.RevistaModel;
import model.UsuariosModel;
import accessDAO.AutorDAO;
import accessDAO.LibroDAO;
import accessDAO.PrestamoDAO;
import accessDAO.RecursoDAO;
import accessDAO.RevistaDAO;
import accessDAO.UsuariosDAO;
import java.util.Date;

/**
 *
 * @author marco
 */
public class InitialData {

    private ArrayList<UsuariosModel> usuariosLista = null;
    private ArrayList<AutorModel> autoresLista = null;
    private ArrayList<RecursoModel> recursoLista = null;
    private ArrayList<RevistaModel> revistaLista = null;
    private ArrayList<LibroModel> libroLista = null;
    private ArrayList<PrestamoModel> prestamoLista = null;
    private ArrayList<Integer> IdRecursoLista = null;
    private ArrayList<Integer> IdAutorLista = null;
    private ArrayList<String> IdUsuarioLista = null;
    

    public InitialData() {
        /*java.util.Date date = new Date();
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        this.usuariosLista = usuariosDAO.getAllUsuarios();
        this.usuariosLista.add(0, new UsuariosModel("", "Todos los usuarios", "", "", 0, "", date));*/

       /* AutorDAO autoresDAO = new AutorDAO();
        this.autoresLista = autoresDAO.getAllAutores();
        //this.autoresLista.add(0, new AutorModel(-1, "Todos los estudiantes", "", 0));

        RecursoDAO recursoDAO = new RecursoDAO();
        this.recursoLista = recursoDAO.getAllRecursos();

        RevistaDAO revistaDAO = new RevistaDAO();
        this.revistaLista = revistaDAO.getAllRevistas();

        LibroDAO libroDAO = new LibroDAO();
        this.libroLista = libroDAO.getAllLibro();*/
    }

    public ArrayList<UsuariosModel> getUsuariosLista() {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        this.usuariosLista = usuariosDAO.getAllUsuarios();
        return usuariosLista;
    }

    public ArrayList<RecursoModel> getCursosLista() {
        RecursoDAO recursoDAO = new RecursoDAO();
        this.recursoLista = recursoDAO.getAllRecursos();
        return recursoLista;
    }

    public ArrayList<RevistaModel> getRevistaLista() {
        RevistaDAO revistaDAO = new RevistaDAO();
        this.revistaLista = revistaDAO.getAllRevistas();
        return revistaLista;
    }

    public ArrayList<LibroModel> getLibrosLista() {
        LibroDAO libroDAO = new LibroDAO();
        this.libroLista = libroDAO.getAllLibro();
        return libroLista;
    }

    public ArrayList<AutorModel> getAutoresLista() {
        AutorDAO autorDAO = new AutorDAO();
        this.autoresLista = autorDAO.getAllAutores();
        return autoresLista;
    }

    public ArrayList<PrestamoModel> getPrestamoLista() {
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        this.prestamoLista = prestamoDAO.getAllPrestamo();
        return prestamoLista;        
    }

    public ArrayList<Integer> getIdRecursoLista() {
        RecursoDAO recursoDAO = new RecursoDAO();
        this.IdRecursoLista = recursoDAO.getAllIdRecursos();
        
        return IdRecursoLista;
    }

    public ArrayList<Integer> getIdAutorLista() {
        AutorDAO autorDAO = new AutorDAO();
        this.IdAutorLista = autorDAO.getAllIdAutores();
        return IdAutorLista;
    }
    
    public ArrayList<String> getIdUsuariosLista(){
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        this.IdUsuarioLista = usuariosDAO.getAllIdsUsuarios();
    return IdUsuarioLista;
    }

}
