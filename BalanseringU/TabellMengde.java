public void push(T el) {
	LinearNode<T> nynode = new LinearNode<T>(el);
	nynode.setNeste(topp);
	topp = nynode;
	antall++;
	}