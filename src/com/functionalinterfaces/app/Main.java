package com.functionalinterfaces.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		IntStream.range(1, 10).forEach((value)->System.out.println(value));
		
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		Integer sum=list.stream()
			.filter((e)->{
				return e%2==0;
			})
			.reduce((n1,n2)->n1+n2).orElseThrow(()->new IllegalArgumentException("hehh"));
		System.out.println(sum);
		
		
			
			
		
		/*this is a functional interface */
		/*this is not creating an object of the functional interface but the traditional way of
		 * implementing the method
		 */
		/*Runnable runnable=new Runnable() {
			public void run() {
				System.out.println("Inside the runnable");
				try {
					for(int i=0;i<10;i++) {
					System.out.println(i+" "+Thread.currentThread().getName());
					Thread.sleep(1000);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		};*/
		
		/*now using lambda expression passing it in the Thread constructor */
		
		Thread myThread=new Thread(()->{
			try {
				for(int i=0;i<10;i++) {
					System.out.println(i+" "+Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		myThread.setName("Shilp");
		myThread.start(); //run method will be executed
		
		for(int i=0;i<10;i++) {
			System.out.println(i+" "+Thread.currentThread().getName());
			Thread.sleep(1000);
		}

	}

}
