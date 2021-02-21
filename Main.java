public class Main {
    public Main(){

    }
    public boolean palindrome(String word){
        if(word==""||word.length()==1) {
            return true;
        }else if(word.substring(0,1).equals(word.substring(word.length()-1))){
            return palindrome(word.substring(1,word.length()-1));
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        Main gang= new Main();
        System.out.println(gang.palindrome("rotor"));
    }
}
