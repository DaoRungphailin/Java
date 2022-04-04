import java.io.File;
import java.util.*;

public class Pro4_64011258 {
     public static void main(String[] args) {

          ArrayList<Double> assistant = new ArrayList<Double>();
		ArrayList<Double> associate = new ArrayList<Double>();
		ArrayList<Double> full = new ArrayList<Double>();

          try {
               File text = new File("Salary.txt");
               Scanner input = new Scanner(text);
               while(input.hasNext()) {
                    String[] data = (input.nextLine()).split(" ");
                    Double salary = Double.parseDouble(data[3]);
                    if (data[2].equals("assistant")) {
                         assistant.add(salary);
                    } else if (data[2].equals("associate")) {
                         associate.add(salary);
                    } else if (data[2].equals("full")) {
                         full.add(salary);
                    }
               }
               input.close();
               Double totalAssistant = 0.0,totalAssociate = 0.0,totalFull = 0.0,totalAll = 0.0;
               for (int i = 0; i < assistant.size(); i++) {
                    totalAssistant += assistant.get(i);
               }
               for (int i = 0; i < associate.size(); i++) {
                    totalAssociate += associate.get(i);
               }
               for (int i = 0; i < full.size(); i++) {
                    totalFull += full.get(i);
               }
               totalAll = totalAssistant + totalAssociate + totalFull;
               System.out.printf("Total salary for assistant professor is %.2f \n",totalAssistant);
               System.out.printf("Total salary for associate professor is %.2f \n",totalAssociate);
               System.out.printf("Total salary for full professor is %.2f \n",totalFull);
               System.out.printf("Total salary for all professor is %.2f \n",totalAll);
               System.out.printf("Average salary for assistant professor is %.2f \n",totalAssistant/assistant.size());
               System.out.printf("Average salary for associate professor is %.2f \n",totalAssociate/associate.size());
               System.out.printf("Average salary for full professor is %.2f \n",totalFull/full.size());
               System.out.printf("Average salary for all professors is %.2f \n",totalAll/(assistant.size() + associate.size() + full.size()));
          } catch (Exception e) {
               e.printStackTrace();
          }
     }
}