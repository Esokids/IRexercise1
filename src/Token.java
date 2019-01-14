public class Token {
    private String term;
    private int docID;
    Token(String term, int docID){
        this.term = term;
        this.docID = docID;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public String toString(){
        return  term + " " + docID;
    }
}
