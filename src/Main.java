import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        number_sort_two();
    }

    private static void number_sort_two() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        List<Integer> result2 = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            result2.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(result2);

        for (int i = 0; i < count; i++) {
            bw.write(result2.get(i)+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

//    private static void growup() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int count = Integer.parseInt(br.readLine());
//        int resultCount=0;
//        for (int i = 0; i < count; i++) {
//            String words = br.readLine();
//            boolean result = true;
//            for (int j = 0; j < words.length()-1; j++) {
//                if (words.charAt(j)!=words.charAt(j+1)){
//                    if (words.substring(j+1).contains(String.valueOf(words.charAt(j)))) {
//                        result = false;
//                        break;
//                    }
//                }
//            }
//            if (result){
//                resultCount++;
//            }
//        }
//        System.out.println(resultCount);
//    }
}