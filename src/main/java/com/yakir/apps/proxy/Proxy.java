package com.yakir.apps.proxy;

import java.net.InetAddress;
import java.net.ServerSocket;

public class Proxy implements Runnable {

	protected final static int PORT_TIME_OUT = 3000;
	protected String mIP = null;
	protected int mPort = 0;
	protected boolean mIsRunning = false;
	protected ServerSocket mServerSocket = null;
	protected boolean mIsExit = false;
	protected Thread myThread = null;

	public Proxy(String proxyIP, int port) {
		mIP = proxyIP;
		mPort = port;
	}

	public void run() {
		while (!mIsExit) {

		}
	}

	public synchronized boolean startServer() {
		try {
			myThread = new Thread(this);
			myThread.setDaemon(true);
			myThread.setPriority(Thread.NORM_PRIORITY + 1);
			myThread.start();
			mIsRunning = false;
			mIsExit = false;
			mServerSocket = new ServerSocket(mPort, 300, InetAddress.getByName(mIP));
			mServerSocket.setSoTimeout(PORT_TIME_OUT);
			mIsRunning = true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public synchronized boolean stopServer() {
		return false;
	}

}
