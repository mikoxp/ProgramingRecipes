package com.rabit.r;

import java.util.Objects;

public class Info {
    private String info;
    private int i = 0;

    public Info() {
    }

    public Info(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Info info1 = (Info) o;
        return i == info1.i && Objects.equals(info, info1.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, i);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Info{" + "info='" + info + '\'' + ", i=" + i + '}';
    }
}
