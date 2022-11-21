package Train.CompanyWorker.Model;

import Train.CompanyWorker.Position;
import Train.CompanyWorker.Worker;

public class Junior extends Worker implements Juniorable{
    public Junior(String name, String surName, Position position, Integer salary) {
        super(name, surName, position, salary);
    }

    @Override
    public void iDoMyBest() {
        System.out.println("Broken the prod");
    }
}
