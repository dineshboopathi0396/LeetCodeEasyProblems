package com.interview.mutithreading;

public class ThreadTest implements Runnable {
    @Override
    public void run() {
        System.out.println("3");
        System.out.println("3");
        System.out.println("3");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadTest());
        t1.start();
        System.out.println("1");
        t1.join();
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");

        try
        {
            System.out.printf("1");
            int sum = 9 / 0;
            System.out.printf("2");
        }
        catch(ArithmeticException e)
        {
            System.out.printf("3");
        }
        catch(Exception e)
        {
            System.out.printf("4");
        }
        finally
        {
            System.out.printf("5");
        }
    }
}
