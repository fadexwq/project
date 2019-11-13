package cn.ego.base.vo;

import java.util.List;

public class MenuNode {
    private String u; //url
    private String n; //name
    private List<?> i;

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public List<?> getI() {
        return i;
    }

    public void setI(List<?> i) {
        this.i = i;
    }
}
