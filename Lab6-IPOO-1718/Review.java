import java.time.LocalDateTime;
import java.time.Clock;
import java.time.format.DateTimeFormatter;
public class Review {
    
    private LocalDateTime date;
    private String[] comments;
    private int numberOfComments;
    private Editor editor;
    public Review() {
        date = LocalDateTime.now(Clock.systemUTC());
        comments = new String[10];
        numberOfComments = 0;
        editor = new Editor();
        
    }
    
    public void addComment(String comment) {
       if(comment != null) {
           for(int i = 0; i < 10; i++) {
               if(comments[i] == null) {
                   comments[i] = comment;
                   numberOfComments++;
                   break;
               }
           }
       } else {
           System.out.println("Comentário inválido.");
       }
    }
    
    private String printDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = date.format(formatter);
        return formatDateTime;
    }
    
    public void show() {
        int d = 1;
        System.out.print("Data: " + printDate() + "\n");
        for(int i=0; i<10; i++) {
             if(comments[i] != null) {   
             System.out.println(d + " - " + comments[i]);
            } 
            d++;
        }
    }
    
    public String showDetails() {
        String someShitty = "";
        int d = 1;
        System.out.print("Data: " + printDate() + "\n");
        for(int i=0; i<10; i++) {
             if(comments[i] != null) {   
             someShitty += d + " - " + comments[i] + "\n";
            } 
            d++;
         }
         
        return someShitty;
    }
    
    public String[] getComments() {
        return comments;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}