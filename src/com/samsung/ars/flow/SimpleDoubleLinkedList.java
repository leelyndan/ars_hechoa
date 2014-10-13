package com.samsung.ars.flow;

import java.util.ArrayList;

public class SimpleDoubleLinkedList<T> extends ArrayList<T> {

    private static final long serialVersionUID = 1613245810658843975L;

    private int pos = -1;

    public T getNextObject() {
	this.pos += 1;
	if (this.size() == pos) {
	    return null;
	}
	T t = this.get(this.pos);
	return t;
    }

    public T getPreviousObject() {
	this.pos -= 1;
	if (-1 == pos) {
	    return null;
	}
	T t = this.get(this.pos);
	return t;
    }

    @Override
    public T get(int index) {
	this.pos = index;
	return super.get(index);
    }

    public int getPos() {
	return pos;
    }

}
