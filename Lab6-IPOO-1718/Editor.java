
/**
 * Escreva a descrição da classe Editor aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Editor
{
    private String email;

    
    public Editor() {
       email = "editor@newsagency.com";
    }
    
    public Editor(String newEmail) {
        email = validateEmail(newEmail);
    }

    private String validateEmail(String email) {
        if (email != null && email.contains("@"))
            return email;   
        
        return "redacao@newsagency.com";
    }
    
    public void setEmail(String newEmail) {
        email = validateEmail(newEmail);
        
    }
    
    public String getEmail() {
        return email;
    }
    
}
