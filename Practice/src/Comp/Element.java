package Comp;

import lombok.ToString;

@ToString
public class Element implements Comparable<Element>{
        String x;
        int y;

        public int compareTo(Element compared) {
            int res = this.x.compareTo(compared.x);
            if (res == 0) {
                res = this.y - compared.y;
            }
            return res;
        }

    public Element(String x, int y) {
        this.x = x;
        this.y = y;
    }
}
