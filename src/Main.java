import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        coordinate_sort();
    }

    public static void coordinate_sort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<Integer> xy = new ArrayList<Integer>();


        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy.add(Integer.valueOf(st.nextToken()));
            xy.add(Integer.valueOf(st.nextToken()));

        }

        for (int i = 0; i <count ; i++) {
            for (int j = 0; j < count - i; j++) {
                if (xy.get(2*j) > xy.get(2*(j+1))) {
                    int x = xy.get(2*j);
                    xy.set(2*j, xy.get(2*(j+1)));
                    xy.set(2*(j+1), x);
                    int y = xy.get(2*j+1);
                    xy.set(2*j+1, xy.get(2*(j+1)+1));
                    xy.set(2*(j+1)+1, y);
                }
            }
        }
    }

    public static void maze_search() throws IOException { //2178
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] nstring = new int[n];
        int[][] nmarray = new int[n][m];

        for (int i = 0; i < n; i++) {
            nstring[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m+1; j++) {
                nmarray[i][j-1] = nstring[i]/(10*(m-j)-(10*(m-j+1)*10));
                System.out.println("nmarray = " + nmarray[i][j]);
            }
        }
    }

    public static void find_fractions() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int temp = count;
        int numerator,denominator;

        for (int i = 1 ; i<=temp; i++){
            if ( count > i ){
                count -= i;
            } else if (i%2 == 1) {
                numerator = i-count+1;
                denominator = count;
                System.out.println(numerator + "/" + denominator);
                break;
            } else {
                numerator = count;
                denominator = i-count+1;
                System.out.println(numerator + "/" + denominator);
                break;
            }
        }
    }

    public static void words_sort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        String temp;

        for (int i = 0; i < count; i++) {
            words.add(br.readLine());
        }
        Collections.sort(words);
        for (int i = 0; i < count-1; i++) {
            for (int j = 0; j < count-i-1; j++) {
                if ((words.get(j).length() > words.get(j + 1).length()) ){
                    temp = words.get(j);
                    words.set(j, words.get(j+1));
                    words.set(j+1, temp);
                }
            }
        }
        words = words.stream().distinct().collect(Collectors.toList());
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void croatia_alphabet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String croatia = br.readLine();
        int count = 0;
        int length;

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