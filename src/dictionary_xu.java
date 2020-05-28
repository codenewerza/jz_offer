import java.util.ArrayList;
import java.util.Arrays;

public class dictionary_xu {
    public void swap(char[] c,int x,int y){
        char temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }
    public ArrayList<String> dictionary(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        //开始字典序
        ArrayList<String> res = new ArrayList<>();
        res.add(new String(c));
        while(true){
            int i = s.length()-2;
            for (; i >=0 ; i--) {
                if(c[i]<c[i+1])
                    break;
            }
            //遍历到了最大的数
            if(i==-1){
                break;
            }
            int j = s.length()-1;
            for (; j >i ; j--) {
                if(c[j]>c[i])
                    break;
            }
            swap(c,i,j);
            for (int k = i+1,h=s.length()-1; k < h; k++,h--) {
                swap(c,k,h);
            }
            res.add(new String(c));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "1234";
        dictionary_xu solution = new dictionary_xu();
        ArrayList<String> list = solution.dictionary(s);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.size());
    }
}