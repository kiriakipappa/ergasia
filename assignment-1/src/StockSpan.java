
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StockSpan {

    public static void main(String[] args) {
		  StockSpan obj = new StockSpan();
    if ("-s".equals(args[0])){
        obj.stack();
        }else if("-counter2".equals(args[0])) {
        obj.normal();
        }else if("-b".equals(args[0])){
		obj.time();
       }else{

		   }
}
    public void normal() {

        String csvFile = "DJIA.csv";
        BufferedReader br = null;
        String line = "";
        String splitOperator = ",";
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        boolean end;
        double doubleparts;
        ArrayList<String> stringList = new ArrayList<String>();
        ArrayList<Double> doubleList = new ArrayList<Double>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while (((line = br.readLine()) != null)) {
                if (counter1 != 0) {

                    // uses comma as file separator
                    String[] parts = line.split(splitOperator);
                    doubleparts = Double.parseDouble(parts[1]);

                    stringList.add(parts[0]);
                    doubleList.add(doubleparts);

                }
                counter1 = 1;

            }//while
            int size = doubleList.size();

            int a = 0;
            double b;
            double c;
            int[] d_array = new int[size];
            for (int i = 0; i < size; ++i) {
                a = 1;
                end = false;

                while ((i - a >= 0) && (!end)) {
                    b = doubleList.get(i - a);
                    c = doubleList.get(i);
                    if (b < c) {
                        ++a;
                    }//end if
                    else {
                        end = true;
                    }

                }//end while
                d_array[i] = a;
            }//end for
            for (int i = 0; i < size; ++i) {
                System.out.println(d_array[i]);

            }
            System.out.println("normal");
        }//end try
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");

    }

    public void time() {

        String csvFile = "DJIA.csv";
        BufferedReader br = null;
        String line = "";
        String splitOperator = ",";
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        boolean end;
        double doubleparts;
        ArrayList<String> stringList = new ArrayList<String>();
        ArrayList<Double> doubleList = new ArrayList<Double>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while (((line = br.readLine()) != null)) {
                if (counter1 != 0) {

                    // use comma as separator
                    String[] parts = line.split(splitOperator);
                    doubleparts = Double.parseDouble(parts[1]);

                    stringList.add(parts[0]);
                    doubleList.add(doubleparts);

                }
                counter1 = 1;

            }//while
            int size = doubleList.size();

            int a = 0;
            double b;
            double c;
            int i;
            int[] d_array = new int[size];
            long start = System.currentTimeMillis();
            for (int y = 0; y <= 100; ++y) {
                for ( i = 0; i < size; ++i) {
                    a = 1;
                    end = false;

                    while ((i - a >= 0) && (!end)) {
                        b = doubleList.get(i - a);
                        c = doubleList.get(i);
                        if (b < c) {
                            ++a;
                        }//end if
                        else {
                            end = true;
                        }
                    }//end while
                    d_array[i] = a;
                }//end for
            }
            long endTime = System.currentTimeMillis();

            System.out.println("normal implementation took:" + (endTime - start) + "millis");



            Stack <Integer> astack=new <Integer>Stack();
            astack.push(0);
           // System.out.println(b.pop());
           //b.empty();
           int[] span=new int[size];
           span[0]=1;
  start = System.currentTimeMillis();
            for (int y = 0; y <= 100; ++y) {
           for (i=1;i<size;++i){
			  while((!astack.empty())&&(doubleList.get(astack.peek())<doubleList.get(i))){
				  astack.pop();
				  }//end while
				  if (astack.empty()){
					  span[i]=i+1;
					  }else
					  {
					span[i]=i-(astack.peek());	  }
					astack.push(i);
			   }//end for
		   }
			     endTime = System.currentTimeMillis();

            System.out.println("Stack implementation took:" + (endTime - start) + "millis");




        }//end try
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");

    }
    public void stack(){

		 String csvFile = "DJIA.csv";
		        BufferedReader br = null;
		        String line = "";
		        String splitOperator = ",";
		        int counter1 = 0;
		        int counter2 = 0;
		        int counter3 = 0;
		        boolean end;
		        double doubleparts;
		        ArrayList<String> stringList = new ArrayList<String>();
		        ArrayList<Double> doubleList = new ArrayList<Double>();

		        try {

		            br = new BufferedReader(new FileReader(csvFile));
		            while (((line = br.readLine()) != null)) {
		                if (counter1 != 0) {

		                    // use comma as separator
		                    String[] parts = line.split(splitOperator);
		                    doubleparts = Double.parseDouble(parts[1]);

		                    stringList.add(parts[0]);
		                    doubleList.add(doubleparts);

		                }
		                counter1 = 1;

		            }//end while
            int size = doubleList.size();

            Stack <Integer>b=new <Integer>Stack();
            int c;
            b.push(0);

           int[] span=new int[size];
           span[0]=1;


           for (int i=1;i<size;++i){
			  while((!b.empty())&&(doubleList.get(b.peek())<doubleList.get(i))){
				  b.pop();
				  }//end while
				  if (b.empty()){
					  span[i]=i+1;
					  }else
					  {
					span[i]=i-(b.peek());	  }
					b.push(i);
			   }//end for


              for (int y = 0; y <size; ++y) {
            System.out.println(span[y]);

		}
		 System.out.println("Stack");




        }//end try
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");


		}

}
