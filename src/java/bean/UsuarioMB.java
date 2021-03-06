package bean;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ApplicationScoped //Application, pois os usu�rios cadastrados dever�o permanecer mesmo se fizer logout.
public class UsuarioMB {

    //CRUD
    private List<Usuario> listaUsuarios;
    private Usuario usuarioSelecionado;

    public UsuarioMB() {
        usuarioSelecionado = new Usuario();
        listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario("Admin","admin", "admin"));
        listaUsuarios.add(new Usuario("Francke","francke", "admin"));
        listaUsuarios.add(new Usuario("Convidado","a", "a"));
    }
    
    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    

    public String novoUsuario(){
        usuarioSelecionado=new Usuario();        
        return("/admin/cadastroUsuarios?faces-redirect=true");
    }

    public String adicionarUsuario(){        
        listaUsuarios.add(usuarioSelecionado);
        this.novoUsuario();
        return("/admin/confirmaCadastroUsuario?faces-redirect=true");
    }
    
    public String mostrarUsuarios(){        
        return("/admin/listaUsuarios?faces-redirect=true");
    }

    public String editarUsuario(Usuario u){
        usuarioSelecionado = u;
        return("/admin/edicaoUsuarios?faces-redirect=true");
    }
    
    public String editarPerfil(Usuario u){
        usuarioSelecionado = u;
        return("/usuario/editarPerfil?faces-redirect=true");
    }
    
    public String atualizarUsuario(){
        return("/admin/listaUsuarios?faces-redirect=true");
    }

    public void removerUsuario(Usuario usuario){
        listaUsuarios.remove(usuario);
    }

}
