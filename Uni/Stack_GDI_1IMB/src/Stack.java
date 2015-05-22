
public class Stack {
 
	    private char[] stack;
	 
	    public Stack(char element) {
	        this.stack = new char[1];
	        this.stack[0] = element;
	    }
	     
	    public Stack(){
	        this.stack = new char[0];
	    }
	     
	    public void push(char element){
	        char[] stackTmp = new char[this.stack.length + 1];
	        for (int i = 0; i < this.stack.length; i++) {
	            stackTmp[i] = this.stack[i];
	        }
	        stackTmp[stackTmp.length-1] = element;
	        this.stack = stackTmp;
	    }
	     
	    public char pop(){
	        char element = 'x';
	        if(this.stack.length > 0){
	            element = this.stack[this.stack.length - 1];
	            char[] stackTmp = new char[this.stack.length-1];
	            for (int i = 0; i < stackTmp.length; i++) {
	                stackTmp[i] = this.stack[i];
	            }
	            this.stack = stackTmp;
	        }
	 
	        return element;
	    }
	     
	    public int size(){
	        return stack.length;
	    }
	     
	    public void print(){
	        System.out.println();
	        for (int i = 0; i < stack.length; i++) {
	            System.out.print(" " + stack[i]);
	        }
	        System.out.println();
	    }
	     
	}


