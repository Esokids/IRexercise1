import java.util.ArrayList;

public class Posting {
    private String term;
    private ArrayList<Integer> postingList = new ArrayList<>();

    Posting(String term, int docID){
        this.term = term;
        postingList.add(docID);
    }

    public void addDocID(int docID){
        postingList.add(docID);
    }

    public ArrayList<Integer> getPostingList() {
        return postingList;
    }

    public void setPostingList(ArrayList<Integer> postingList) {
        this.postingList = postingList;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String toString(){
        return term + postingList;
    }
}
