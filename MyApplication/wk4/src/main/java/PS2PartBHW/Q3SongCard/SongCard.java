package PS2PartBHW.Q3SongCard;
// Homework Question 3
// total: 15 points

//===============================================
// todo: complete the following program
//===============================================




import java.util.*;
public class SongCard {

    private int songs;
    private boolean activated;
    public SongCard(int n) {
        //Type your codes here
        songs =n;
        activated =false;

    }
    public void activate(){
        //Type your codes here
        activated =true;

    }
    public void buyASong()
            throws CardNotActivatedException, CardEmptyException {

        //Type your codes here
        if(activated ==false) {
            throw new CardNotActivatedException();
        }

        if(songs ==0) {
            throw new CardEmptyException();
        }

        songs -=1;
    }

    public int songsRemaining(){
        //Type your codes here
        return songs;

    }
    public String toString() {
        //Type your codes here
        if(activated ==true) {
            return "Card has " +songsRemaining() +" songs and is activated.";
        } else {
            return "Card has " +songsRemaining() +" songs and is not activated.";
        }


    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SongCard sc = new SongCard(10);
        System.out.println(sc);
        System.out.println("Trying to buy a song");
        try{
            sc.buyASong();
        } catch (CardEmptyException e1){
            System.out.println("Caught error: " +e1.getMessage() );
        } catch (CardNotActivatedException e2){
            System.out.println("Caught error: " +e2.getMessage() );
        }
        System.out.println(sc);
        System.out.println("Activating the card");
        sc.activate();
        System.out.println(sc);
        System.out.println("Buying songs");

        //Type your codes here
        for(int i=0; i <11; i++) {
            try{
                sc.buyASong();
            } catch (CardEmptyException e1){
                System.out.println("Caught error: " +e1.getMessage() );
            } catch (CardNotActivatedException e2){
                System.out.println("Caught error: " +e2.getMessage() );
            }
            System.out.println(sc);
        }

    }

    public class CardNotActivatedException extends Exception{
        // Type your codes here
        public CardNotActivatedException() {
        }
        public String getMessage() {
            return "Card not activated";
        }

    }

    public class CardEmptyException extends Exception{
        // Type your codes here
        public CardEmptyException() {
        }
        public String getMessage() {
            return "No more songs on the card";
        }

    }
}
