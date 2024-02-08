import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        croatia_alphabet();
    }

    public static void croatia_alphabet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String croatia = br.readLine();
        int count = 0;
        int length = croatia.length();

        if (croatia.contains("c=")){
            length = croatia.length() - croatia.replaceAll("c=", "").length();
            croatia = croatia.replaceAll("c=", "_");
            count += length / 2;
        }
        if (croatia.contains("c-")){
            length = croatia.length() - croatia.replaceAll("c-", "").length();
            croatia = croatia.replaceAll("c-","_");
            count += (length / 2);
        }
        if (croatia.contains("dz=")){
            length = croatia.length() - croatia.replaceAll("dz=", "").length();
            croatia = croatia.replaceAll("dz=","_");
            count += length / 3;
        }
        if (croatia.contains("d-")){
            length = croatia.length() - croatia.replaceAll("d-", "").length();
            croatia = croatia.replaceAll("d-","_");
            count += length / 2;
        }
        if (croatia.contains("lj")){
            length = croatia.length() - croatia.replaceAll("lj", "").length();
            croatia =  croatia.replaceAll("lj","_");
            count += length / 2;
        }
        if (croatia.contains("nj")){
            length = croatia.length() - croatia.replaceAll("nj", "").length();
            croatia = croatia.replaceAll("nj","_");
            count += length / 2;
        }
        if (croatia.contains("s=")){
            length = croatia.length() - croatia.replaceAll("s=", "").length();
            croatia =  croatia.replaceAll("s=","_");
            count += length / 2;
        }
        if (croatia.contains("z=")){
            length = croatia.length() - croatia.replaceAll("z=", "").length();
            croatia = croatia.replaceAll("z=","_");
            count += length / 2;
        }
        croatia = croatia.replaceAll("_","");

        System.out.println(croatia.length() + count);
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

    private static void growup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int resultCount=0;
        for (int i = 0; i < count; i++) {
            String words = br.readLine();
            boolean result = true;
            for (int j = 0; j < words.length()-1; j++) {
                if (words.charAt(j)!=words.charAt(j+1)){
                    if (words.substring(j+1).contains(String.valueOf(words.charAt(j)))) {
                        result = false;
                        break;
                    }
                }
            }
            if (result){
                resultCount++;
            }
        }
        System.out.println(resultCount);
    }
}