package org.basejava.thread.study1;

public class TestTheadIsAlive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleThread s = new SimpleThread();
		LinsterThread l = new LinsterThread(s);
		s.start();
		l.start();

	}

}
