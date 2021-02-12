//Outdated class not in use
package com.server;

public class UserIDChange {
	int oldID[];
	int newID;
	
	public UserIDChange(int[] oldID, int newID) {
		super();
		this.oldID = oldID;
		this.newID = newID;
	}
	
	public int[] getOldID() {
		return oldID;
	}
	public void setOldID(int[] oldID) {
		this.oldID = oldID;
	}
	public int getNewID() {
		return newID;
	}
	public void setNewID(int newID) {
		this.newID = newID;
	}

}
