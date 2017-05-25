package com.softserve.edu.task2;

import com.softserve.edu.task2.envelopes.CheckExecutor;

/**
 * entry point
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CheckExecutor checkExecutor=new CheckExecutor();
        checkExecutor.execute();
    }
}
