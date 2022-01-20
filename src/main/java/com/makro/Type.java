package com.makro;

public class Type {
	 private String type;
	 private int noType;

    public Type() {
    }
    public Type(String type, int noType) {
        setType(type);
        setNoType(noType);
    }
    
	 public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNoType() {
		return noType;
	}

	public void setNoType(int noType) {
		this.noType = noType;
	}

	


}
