package lab_21;

public class ArrayList {
	
	private Object[] objectList;
	
	public ArrayList() {
		objectList = null;
	}
	
	public int size() {
		if(objectList == null) {
			return 0;
		}
		return objectList.length;
	}
	
	public boolean add(Object obj){
	    if(objectList == null){
	    	objectList = new Object[1];
	        objectList[0] = obj;
	        return true;
	    }
	    else{//Otherwise
	        Object[] copy = new Object[this.size()];
	        for(int i = 0; i < copy.length; i++){
	            copy[i] = objectList[i];
	        }
	        objectList = new Object[this.size()+1];
	        for(int i = 0; i < copy.length; i++){
	        	objectList[i] = copy[i];
	        }
	        objectList[this.size()-1] = obj;
	        return true;
	    }
	}
	
public void add(int index, Object obj) {
		assert (index == 0) && (objectList == null) || objectList != null &&
				index <= objectList.length && index >0: "Error: add()";
		Object[] a = new Object[this.size() + 1];
		for(int i = 0; i < index; i++) {
			a[i] = objectList[i];
		}
		a[index] = obj;
		for(int i = index; i < this.size(); i++) {
			a[i + 1] = objectList[i];
		}
		objectList = a;
	}
	
	public Object get(int index) {
		return objectList[index];
	}
	
	public Object remove(int index) {
		Object o = objectList[index];
		Object[] temp = new Object[objectList.length - 1];
		for(int i = 0; i < index; i++) {
			temp[i] = objectList[i];
		}
		for(int i = index; i < temp.length; i++) {
			temp[i] = objectList[i + 1];
		}
		objectList = new Object[temp.length];
		for(int i = 0; i < temp.length; i++) {
			objectList[i] = temp[i];
		}
		return o;
	}
	
	public String toString() {
		String ret = "[";
		for(int i = 0; i < objectList.length - 1; i++) {
			ret += objectList[i] + ", ";			
		}
		ret += objectList[objectList.length - 1] + "]";
		return ret;
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
