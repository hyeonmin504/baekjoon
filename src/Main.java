import java.io.*;
import java.util.*

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        number_card();
    }
    public static void number_card() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n, m;
        HashMap<String, Integer> owned = new HashMap<>();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            owned.put(st.nextToken(), 0);
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            if (owned.get(st.nextToken()) != null) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb.toString());
    }
}


class Combination{
    Long n,r;
    public Combination(Long n, Long r) {
        this.n = n;
        this.r = r;
    }
    public static long calculate(int r,int n){
        long xr= (long)r;
        long xn= (long)n;

        if (r==0) return 0;
        for (int i = 1; i < r; i++) xn = xn*(n-i); // 분자
        for (int i = 1; i < r-1; i++) xr = xr*(r-i); //분모 r!
        return xn/xr;
    }
}
class Person {
    int age;
    String name;
    int weight, height;
    int sequence;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.sequence = 1;
    }
}
/*
    public static void confetti() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] map = new int[100][100];
        int x,y,xy=0;

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    map[j][k]++;
                }
            }
        }
        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                if (map[j][k]>0) xy++;
            }
        }
        System.out.println(xy);
    }
}

class Point {
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

    public static void yosaepus() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = 2*K;
        List<Integer> array = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            array.add(i);
        }
        bw.append("<" + array.get(K-1));
        System.out.println("array.get("+(K-1)+") = " + array.get(K - 1));
        array.remove(K-1);
        start--;

        while(!array.isEmpty()){
            System.out.println("array.size(),K = " + array.size() + ", " + start);
            if (start%array.size()==0||array.size() == 1) start = array.size();
            if (array.size()<start){
                start = start%array.size();
                System.out.println("if");
                continue;
            }
            bw.append(", " + array.get(start-1));
            System.out.println("array.get("+(start-1)+") = " + array.get(start-1));
            array.remove(start-1);
            start += K-1;


        }
        bw.append(">");
        bw.flush();
    }

    public static void put_bridge() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.append(String.valueOf(Combination.calculate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))).append("\n");
        }
        bw.flush();
    }

    public static void coordinate_sort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Point[] point = new Point[count];
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(point, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.y == o2.y) return o1.x - o2.x;
                return o1.y-o2.y;
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i<count ; i++){
            bw.append(point[i].x + " " + point[i].y);
            bw.append("\n");
        }
        bw.flush();

    }

    public static void weight_height() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Person[] person = new Person[count];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i] = new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < count-1; i++) {
            for (int j = i+1; j < count; j++) {
                if ((person[i].weight > person[j].weight && person[i].height > person[j].height)){
                    person[j].sequence++;
                }
                else if (person[i].weight < person[j].weight && person[i].height < person[j].height){
                    person[i].sequence++;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.print(person[i].sequence+ " ");
        }
    }

    public static void age_sort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Person[] person = new Person[count];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i] = new Person(Integer.parseInt(st.nextToken()),st.nextToken());
        }

        Arrays.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        for (int i = 0; i < count; i++) {
            System.out.println(person[i].age+" "+ person[i].name);
        }
    }

    public static void sort_inside() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] x = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            x[i] = num.charAt(i) - '0';
        }

        for (int i = 0; i < x.length-1; i++) {
            for (int j = 0; j <x.length-i-1; j++) {
                if (x[j] > x[j+1]){
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < x.length; i++) {
            System.out.print(x[x.length-i-1]);
        }
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
}*/