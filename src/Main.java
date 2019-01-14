import java.util.*;
public class Main {
    static ArrayList<Token> posting = new ArrayList<>();
    public static void main(String[] args) {
        // Tokenizing and Preprocessing
        String delim = "\\ |\\;|\\:|\\.";
        StringTokenizer doc1 = new StringTokenizer(ReadFile.readFile("Doc1.txt"),delim);
        StringTokenizer doc2 = new StringTokenizer(ReadFile.readFile("Doc2.txt"),delim);

        // Delete duplicate words.
        Set<String> term1 = setTerm(doc1);
        Set<String> term2 = setTerm(doc2);

        // Generate posting
        genaratePosting(term1,1);
        genaratePosting(term2,2);

        // Sorting
        posting.sort(Comparator.comparing(Token::getTerm));

        // Printing
        for(Token e : posting)
            System.out.println(e);
    }

    static void genaratePosting(Set<String> term, int docID){
        for(String e : term)
            posting.add(new Token(e,docID));
    }

    static Set setTerm(StringTokenizer doc){
        Set<String> term = new HashSet<>();
        while(doc.hasMoreTokens())
            term.add(doc.nextToken());
        return term;
    }
}