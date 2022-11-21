package Train.CompanyWorker.DB;

import Train.CompanyWorker.Worker;

import java.util.ArrayList;

public class DB {
    ArrayList<Worker> dataBase = new ArrayList<>();

    public void addToDB(Worker worker){
        dataBase.add(worker);
        System.out.println("Data Base");
        System.out.println(dataBase);
    }
}
