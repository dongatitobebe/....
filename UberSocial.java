
package exmanen_q1;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class UberSocial {
    private static ArrayList<SocialClass> redes = new ArrayList();
    
    public static SocialClass buscar(String username){
        for(SocialClass usuario: redes){
            if(usuario.getUsername().equals(username)){
                return usuario;
            }
        }
        return null;
    }
    
    public static void agregarCuenta(String username, String tipo){
        if(buscar(username)==null){
            if(tipo.equals("facebook")){
                redes.add(new Facebook(username));
                        JOptionPane.showMessageDialog(null, "Agregado exitosamente");
                        System.out.println("Se Creo una Cuenta en Facebook con Nombre de "+username);
            } else{
                redes.add(new Twitter(username));
                JOptionPane.showMessageDialog(null, "Agregado exitosamente");
                 System.out.println("Se Creo una Cuenta en Twitter con Nombre de "+username);
            }
        }else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no valido.");
                    System.out.println("Nombre INVALIDO");

        }
    }
    
    public static void agregarPost(String username, String post) {
        SocialClass account = buscar(username);
        
        if (account instanceof Twitter) {
            ((Twitter) account).addPost(post);
            System.out.println("se agrego");
        } else if(account instanceof Facebook) {
            ((Facebook) account).addPost(post);
            System.out.println("se agrego");
        } else {
        JOptionPane.showMessageDialog(null, "El usuario no existe.");
            System.out.println("Usuario no existente");        }
        
    }
    
    public static void agregarComment(String user, int postID, String autor, String comment){
        Comment comentario = new Comment(postID, autor, comment);
        if(buscar(user)!=null){
        if(buscar(user) instanceof Facebook){
            Facebook userface = (Facebook) buscar(user);
            userface.addComment(comentario);
            JOptionPane.showMessageDialog(null, "Agregado exitosamente");
            System.out.println("se agrego comentario "+comentario);
        }   
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe.");
        }
    }
    
    public static void agregarAmigo(String user1, String user2){
        if(buscar(user1)!=null && buscar(user2)!=null){
            for(SocialClass usuario1: redes){
                if(usuario1.getUsername().equals(user1)){
                    for(SocialClass usuario2: redes){
                        if(usuario2.getUsername().equals(user2)){
                            if((usuario1 instanceof Twitter && usuario2 instanceof Twitter) || (usuario1 instanceof Facebook && usuario2 instanceof Facebook)){
                                usuario1.addFriend(user2);
                                usuario2.addFriend(user1);
                                JOptionPane.showMessageDialog(null, "Agregado exitosamente");
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo completar la accion.");
        }
        
    }
    
    public static void profileFrom(String user){
        if(buscar(user)!=null){
            buscar(user).myProfile();
        }
    }
    
}

