package Train.CompanyWorker.Model;

import Train.CompanyWorker.Position;
import Train.CompanyWorker.Worker;

public class Top extends Worker implements Topable{
    public Top(String name, String surName, Position position, Integer salary) {
        super(name, surName, position, salary);
    }

    @Override
    public void giveTheOrder() {
        System.out.println("You have five minutes for rebuild 10000 lines of code");
    }
}
