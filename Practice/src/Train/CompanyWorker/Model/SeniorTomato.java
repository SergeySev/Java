package Train.CompanyWorker.Model;

import Train.CompanyWorker.Position;
import Train.CompanyWorker.Worker;

public class SeniorTomato extends Worker implements Seniorable{
    public SeniorTomato(String name, String surName, Position position, Integer salary) {
        super(name, surName, position, salary);
    }

    @Override
    public void fixProblemAfterJunAndMiddle() {
        System.out.println("Let's take a look at this");
    }
}
