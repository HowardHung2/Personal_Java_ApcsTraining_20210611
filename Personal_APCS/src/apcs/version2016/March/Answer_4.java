package apcs.version2016.March;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Answer_4 {

/*測試資料
8
0 1
0 2
0 3
7 0
1 4
1 5
3 6


4
0 1
0 2
2 3
*/
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        MyTree tree = new MyTree();

        //接收第一行的輸入後便可以建立所有元素物件,並置入樹物件的串列中
        int lines = Integer.parseInt(keyboard.nextLine());
        for (int i = 0; i < lines; i++) {
            Element e = new Element(i);
            tree.add(e);
        }

        //接收其他輸入, 並建立所有物件的父子關係
        for (int i = 1; i < lines; i++) {
            String[] datas = keyboard.nextLine().split(" ");
            int a = Integer.parseInt(datas[0]);
            int b = Integer.parseInt(datas[1]);
            Element A = tree.get(new Element(a));
            Element B = tree.get(new Element(b));
            A.children.add(B);
            B.parent = A;
        }

        //取得所有葉節點
        ArrayList<Element> leaves = tree.getAllLeaf();
        //計算所有葉節點的距離, 集合並排序
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < leaves.size() - 1; i++) { //每一個元素與後面的所有元素比對
            for (int j = i + 1; j < leaves.size(); j++) {
                int far = tree.getFar(leaves.get(i), leaves.get(j));
                list.add(far);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

}

class Element {

    int value;
    Element parent;
    ArrayList<Element> children = new ArrayList<>();

    Element(int value) {
        this.value = value;
    }

    public ArrayList<Element> getParents() {
        ArrayList<Element> parents = new ArrayList<>();

        Element e = parent;
        while (e != null) {
            parents.add(0, e); //越上層的父節點排越前面
            e = e.parent;
        }
        return parents;
    }

    public boolean equals(Object o) {
        Element e = (Element) o;
        if (value == e.value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return value;
    }
}

class MyTree {

    ArrayList<Element> list = new ArrayList<>();

    public void add(Element e) {
        list.add(e);
    }

    public Element get(Element e) {
        int index = list.indexOf(e);
        if (index < 0) {
            return null;
        }
        return list.get(index);
    }

    //取得所有葉節點
    public ArrayList<Element> getAllLeaf() {
        ArrayList<Element> allLeaf = new ArrayList<>();
        for (Element e : list) {
            //沒有子節點者為葉節點
            if (e.children.size() == 0) {
                allLeaf.add(e);
            }
        }
        return allLeaf;
    }

    //取得兩個葉節點間的距離
    public int getFar(Element e1, Element e2) {
        //取得兩個元素由上往下排列的父節點集合
        ArrayList<Element> p1 = e1.getParents(); //7 0 1 => 5 
        ArrayList<Element> p2 = e2.getParents(); //7 0 3 => 6	

        int far = 0;

        //找到第一個不一樣的父節點的前面一個節點便是共同的父節點		
        int sameParentCount = 0; // 記錄是第幾個元素為共同父節點
        int length = p1.size() < p2.size() ? p1.size() : p2.size(); //父節點數量不一樣時, 以少的為主
        for (int i = 0; i < length; i++) {
            if (!p1.get(i).equals(p2.get(i))) {
                break;
            }
            sameParentCount++;
        }

        //計算兩個葉節點之間的距離
        //p1 -> sameParent
        far = p1.size() - sameParentCount + 1;
        //sameParent -> p2
        far += p2.size() - sameParentCount + 1;

        return far;
    }

    public String toString() {
        return list.toString();
    }
}
