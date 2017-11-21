import java.time.LocalDateTime;
import java.time.Clock;
import java.time.format.DateTimeFormatter;
public class News {
    
    private String title, text;
    private Author author;
    private Photo[] photos;
    private Review[] reviews;
    private int numberOfPhotos, numberOfReviews;
    private LocalDateTime dateOfPublication;
    private boolean isPublished;
    
    public News(){
        title = "";
        text = "";
        author = new Author();
        photos = new Photo[20];
        reviews = new Review[3];
        numberOfPhotos = 0;
        numberOfReviews = 0;
        dateOfPublication = null;
        isPublished = false;
    }
    
    public News(String title, String text, String authorName) {
        this.title = validateString(title);
        this.text = validateString(text);
        author = new Author(authorName, "h_miguel.f@hotmail.com");
        photos = new Photo[20];
        reviews = new Review[3];
        numberOfPhotos = 0;
        numberOfReviews = 0;
        dateOfPublication = null;
    }
    
    private String validateString(String string) {
        if(string != null) {
            return string;
        }
        return "";
    }
    
    private String printDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = dateOfPublication.format(formatter);
        return formatDateTime;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getText() {
        return text;
    }
    
    public LocalDateTime getDateOfPublication() {
        return dateOfPublication;
    }
    
    public String getAuthorName() {
        return author.getName();
    }
    
    public String getAuthorEmail() {
        return author.getEmail();
    }
    
    public void addPhoto(Photo photo) {
        for(int i=0; i<20; i++) {
            if(photos[i] == null) {
                photos[i] = photo;
                numberOfPhotos++;
                break;
            } 
        }
    }
    
    public String display() {
        String shits;
        shits = title + "\n" + author.getName() + "-" + author.getEmail() + "\n" + text + "\n";
        String moreShit = "";
        String date = "";
        for(int i=0; i<20; i++) {
            if(photos[i] == null) {
                           
            } else {
                moreShit += "[" + photos[i].getImageFile() + "]: " + photos[i].getCaption() + "\n";
            }
        }
        if(isPublished) {
            date = printDate() + "\nNotícia publicada.";
        } else {
            date = "\nNotícia não publicada.";
        }
        return shits + moreShit + date;
    }
   
    
    public void addReview(Review review) {
        for(int i=0; i<3; i++) {
            if(reviews[i] == null) {
                reviews[i] = review;
                numberOfReviews++;
                break;
            }
        }
    }
    
    public void displayComReviews() {
        System.out.println(display());
        for(int i=0; i<3; i++) {
            if(reviews[i] != null) {
                System.out.println(reviews[i].showDetails());
            } else {
              break;  
            }
        }
    }
    
    public void publish() {
        isPublished = true;
        dateOfPublication = LocalDateTime.now(Clock.systemUTC());
    }
    
    private void findReviewByEditor(){
        
        
    }

}