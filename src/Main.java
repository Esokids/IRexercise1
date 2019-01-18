import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.*;

public class Main {
    static ArrayList<Token> posting = new ArrayList<>();
    static ArrayList<Posting> postingList = new ArrayList<>();

    public static void main(String[] args) {
        // Tokenizing and Preprocessing
        String delim = "\\ |\\;|\\:|\\.|\\-|\\_|\\!|\\?|\\\"|\\'";

        // Generate name of files.
        String path[] = new String[100];
        for(int i = 0; i < path.length ; i++)
            path[i] = "Doc"+(i+1)+".txt";

        // Read from file
        StringTokenizer doc[] = new StringTokenizer[100];
        for(int i = 0 ; i<path.length ; i++)
            doc[i] = new StringTokenizer(ReadFile.readFile(path[i]), delim);

        // Test show token
        for(int i = 0 ; i<doc.length ; i++){
            if(doc[i].countTokens()==0)
                continue;
            while (doc[i].hasMoreTokens())
                System.out.print(doc[i].nextToken() + " ");
            System.out.println();
        }

        // Delete duplicate words.
//        Set<String> term1 = setTerm(doc1);
//        Set<String> term2 = setTerm(doc2);

        // Generate posting
//        genaratePosting(term1,1);
//        genaratePosting(term2,2);

        // Sorting
        posting.sort(Comparator.comparing(Token::getTerm));

        //Create posting lists, determine document frequency
        createPostingsLists(postingList);
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

    public static <Integer> ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> result = new ArrayList<>();
        for(Integer e : list1) {
            if (list2.contains(e))
                result.add(e);
        }
        return result;
    }

    public static <T> ArrayList<T> anotherIntersect(ArrayList<T> list1, ArrayList<T> list2){
        list1.retainAll(list2);
        return list1;
    }

}