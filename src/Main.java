import java.io.IOException;
import java.net.*;
import java.util.*;
public class Main {
    static ArrayList<Token> posting = new ArrayList<>();
    static ArrayList<Posting> postingList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Tokenizing and Preprocessing
        String delim = "\\ |\\;|\\:|\\.";

        // Read from file
        StringTokenizer doc1 = new StringTokenizer(ReadFile.readFile("Doc1.txt"),delim);
        StringTokenizer doc2 = new StringTokenizer(ReadFile.readFile("Doc2.txt"),delim);

        // Read from URL
//        StringTokenizer doc1 = new StringTokenizer(ReadFile.readURL(new URL("http://do9.xyz/proxy2.txt?fbclid=IwAR1htIryqavNnGlXHW-Qg8Cwasq-8Nvx-cixejoIfYQzd3B-vDaJNlqoDLE")),delim);
//        StringTokenizer doc2 = new StringTokenizer(ReadFile.readURL(new URL("http://do9.xyz/proxy1.txt?fbclid=IwAR1mC2BbkvJTRWE4SGseFdIPFf3_DIt-RKjGeBD_MMBHHwhpvJukHtj3Gps")),delim);

        // Delete duplicate words.
        Set<String> term1 = setTerm(doc1);
        Set<String> term2 = setTerm(doc2);

        // Generate posting
        genaratePosting(term1,1);
        genaratePosting(term2,2);

        // Sorting
        posting.sort(Comparator.comparing(Token::getTerm));

        //Create posting lists, determine document frequency
        createPostingsLists(postingList);

        // Printing All posting arr
//        for(Token e : posting)
//            System.out.println(e);

        // Printing All postingList arr
        for(Posting e : postingList)
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

    public static void createPostingsLists(ArrayList<Posting> postingList) {
        for(Token e : posting){
            boolean flag = false;
            for(Posting ee : postingList)
                if(ee.getTerm().equals(e.getTerm())){
                    ee.addDocID(e.getDocID());
                    flag = true;
                }
            if(flag == false)
                postingList.add(new Posting(e.getTerm(),e.getDocID()));
        }
    }
}