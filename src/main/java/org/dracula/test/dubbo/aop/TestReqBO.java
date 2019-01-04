package org.dracula.test.dubbo.aop;

import java.io.Serializable;

/**
 * @author dk
 */
public class TestReqBO implements Serializable {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
