import java.io.*;
import java.lang.reflect.Array;
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

        //Intersect
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//
//        list2.add(1);
//        list2.add(3);
//        list2.add(5);
//        list2.add(4);
//
//        System.out.println(intersect(list1,list2));
//        System.out.println(anotherIntersect(list1,list2));

        // Printing All posting arr
//        for(Token e : posting)
//            System.out.println(e);

        // Printing All postingList arr
//        for(Posting e : postingList)
//            System.out.println(e);
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