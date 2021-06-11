package apcs.version2017.October;

import java.util.ArrayList;
import java.util.Scanner;

public class Answer_3 {

    /*測試資料

7
0
2 6 7
2 1 4
0
2 3 2
0
0




9
1 6
3 5 3 8
0
2 1 7
1 9
0
1 2
0
0

     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        MyTree tree = new MyTree();

        //建立所有節點
        int lines = Integer.parseInt(keyboard.nextLine());
        for (int i = 1; i <= lines; i++) {
            Element e = new Element(i);
            tree.add(e);
        }

        //建立所有父子節點的關係
        for (int i = 1; i <= lines; i++) {
            String[] datas = keyboard.nextLine().split(" ");
            int j = Integer.parseInt(datas[0]); //取得節點i的子節點數
            if (j == 0) {
                continue;
            }
            Element parent = tree.get(new Element(i)); //取得父物件
            for (int k = 1; k <= j; k++) {
                int value = Integer.parseInt(datas[k]);
                Element child = tree.get(new Element(value)); //取得子物件
                parent.children.add(child);
                child.parent = parent;
            }
        }

        //計算每一個節點的高度
        tree.setHeight();

        System.out.println(tree.findRoot().value);
        System.out.println(tree.getHT());

    }

}

class Element {

    int value;
    Element parent;
    int height;
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

    public Element findRoot() {
        Element e = null;
        for (Element ee : list) {
            if (ee.parent == null) {
                e = ee;
                break;
            }
        }
        return e;
    }
    //由下往上記錄層級數, 直到 parent == null
    //事實上可以用所有葉節點來算就可以了

    public void setHeight() {
        for (Element e : list) {
            //根節點
            if (e.parent == null) {
                continue;
            }

            //i 記錄往上跑的層級數
            int i = 0;
            Element parent = e.parent;
            do {
                i++;
                //若目前父類別中記錄的高度比較小
                if (i > parent.height) {
                    parent.height = i;
                }
                parent = parent.parent;
            } while (parent != null);
        }
    }

    //計算總高度
    //事實上計算非葉節點即可
    public int getHT() {
        int ht = 0;
        for (Element e : list) {
            ht += e.height;
        }
        return ht;
    }
}
