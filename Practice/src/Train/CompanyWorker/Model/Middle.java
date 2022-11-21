package Train.CompanyWorker.Model;

import Train.CompanyWorker.Position;
import Train.CompanyWorker.Worker;

public class Middle extends Worker implements Middleable {
    public Middle(String name, String surName, Position position, Integer salary) {
        super(name, surName, position, salary);
    }

    @Override
    public void iWorkSoHard() {
        System.out.println("Junior, you have new tasks...");
    }
}
