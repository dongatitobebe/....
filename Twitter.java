
package exmanen_q1;

public class Twitter extends SocialClass{
     public Twitter(String username) {
        super(username);
    }
    
    void timeLine() {
        System.out.println("Timeline de: " + username);
        for (String post : posts) {
            System.out.println(post);
        }
    }
    
}

