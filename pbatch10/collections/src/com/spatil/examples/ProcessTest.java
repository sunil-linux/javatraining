package com.spatil.examples;

public class ProcessTest {

	public static void main(String[] args) {

		// Retrieve machine information
		Runtime runtime = Runtime.getRuntime();

		int processors = runtime.availableProcessors();
		System.out.println(processors);

		System.out.println(runtime.freeMemory());

		System.out.println(runtime.totalMemory());

		try {

			System.out.println("Launching process...");
			Process firefoxProcess = runtime.exec("firefox");

			System.out.println("process launced and waiting to close....");
			firefoxProcess.waitFor();

			System.out.println("Process has been closed...");
			System.out.println("Exit value:" + firefoxProcess.exitValue());

			//ProcessBuilder builder = new ProcessBuilder(Arrays.asList("firefox"));
			// builder.wait();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
