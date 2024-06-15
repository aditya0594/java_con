package Java_Concept;

import com.aventstack.extentreports.gherkin.model.ScenarioOutline;

public class InstanceOF {

    public static void main (String[] args){

        InstanceOF ap = new InstanceOF();

        if(ap instanceof InstanceOF){
            System.out.println("This is instance of ");
        }
        else {
            System.out.println("Not a instance of");
        }


    }



}
